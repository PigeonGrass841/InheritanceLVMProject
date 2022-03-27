import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("List of commands: ");
        System.out.println("-------------------------");
        System.out.println(" - install-drive [drive_name] [size]");
        System.out.println(" - list-drives");
        System.out.println(" - pvcreate [pv_name] [drive_name]");
        System.out.println(" - pvlist");
        System.out.println(" - vgcreate [vg_name] [pv_name]");
        System.out.println(" - vgextend [vg_name] [pv_name]");
        System.out.println(" - vglist");
        System.out.println(" - lvcreate [lv_name] [lv_size] [vg_name]");
        System.out.println(" - lvlist");
        System.out.println("-------------------------");
        System.out.println("Welcome to the LVM System! Enter your commands: ");
        System.out.print("cmd# ");

        ArrayList<HardDrive> hardDrives = new ArrayList<HardDrive>(); // List of hard-drives
        ArrayList<PhysicalVolume> physicalVolumes = new ArrayList<PhysicalVolume>(); // List of physical volumes
        ArrayList<VolumeGroup> volumeGroups = new ArrayList<VolumeGroup>(); // List of volume groups
        ArrayList<LogicalVolume> logicalVolumes = new ArrayList<LogicalVolume>(); // List of logical volumes

        Scanner input = new Scanner(System.in);
        String command = input.nextLine();

        while (!(command.equals("exit")))
        {
            // This command will install a new hard drive with the name "sda" of size 100G
            // You should not allow the user to install a drive that is already installed.
            if (command.indexOf("install-drive ") != -1)
            {
                boolean error = false;
                String info = command.substring(command.indexOf(" ") + 1);
                String driveName = info.substring(0, info.indexOf(" "));
                String driveSize = info.substring(info.indexOf(" ") + 1);

                if (driveSize.indexOf("G") != -1)
                {
                    driveSize = driveSize.substring(0, driveSize.indexOf("G"));
                }

                for (HardDrive hd : hardDrives)
                {
                    if (hd.getName().equals(driveName))
                    {
                        System.out.println("That hard-drive already exists");
                        error = true;
                        break;
                    }
                }

                if (error == false)
                {
                    HardDrive drive = new HardDrive(driveName, Integer.parseInt(driveSize));
                    hardDrives.add(drive);
                    System.out.println("Drive " + driveName + " installed");
                }

            }

            // This command will list all the drives that have been installed and output it in this format:
            // drive [size]
            if (command.indexOf("list-drives") != -1)
            {
                for (HardDrive hd : hardDrives)
                {
                    System.out.println(hd.getName() + " [" + hd.getSize() + "G]");
                }
            }

            // This command will create a new physical volume named "pv1" with the size of the given drive.
            // You should not allow the user to create a physical volume with a drive that has already been used as part of another physical volume.
            // This should report an error if the drive doesn't exist or if the drive is associated with an already created PV.
            // It should also report an error if the PV name already exists.
            if (command.indexOf("pvcreate ") != -1)
            {
                boolean error = false;
                String info = command.substring(command.indexOf(" ") + 1);
                String physicalName = info.substring(0, info.indexOf(" "));
                String driveName = info.substring(info.indexOf(" ") + 1);
                HardDrive drive = null;

                for (HardDrive hd : hardDrives)
                {
                    if (hd.getName().equals(driveName))
                    {
                        drive = hd;
                        break;
                    }
                }

                if (hardDrives.size() == 0 || drive == null)
                {
                    System.out.println("That hard-drive doesn't exist");
                    error = true;
                }

                for (PhysicalVolume pv : physicalVolumes)
                {
                    if (pv.getHardDrive().getName().equals(driveName))
                    {
                        System.out.println("That hard-drive is already associated with a created physical volume");
                        error = true;
                        break;
                    }

                    if (pv.getName().equals(physicalName))
                    {
                        System.out.println("That physical volume already exists");
                        error = true;
                        break;
                    }
                }

                if (error == false)
                {
                    PhysicalVolume volume = new PhysicalVolume(physicalName, drive);
                    physicalVolumes.add(volume);
                    System.out.println(physicalName + " created");
                }
            }

            // This command will list all of the information about physical volumes (sorted by volume group) in this format:
            // pv1:[100G] [vg1] [uuid]
            // This denotes that pv1 is 100G and part of Volume Group vg1.
            // If the PV is not part of a volume group yet, do not display the VG information.
            if (command.indexOf("pvlist") != -1)
            {
                for (PhysicalVolume pv : physicalVolumes)
                {
                    System.out.print(pv.getName() + " [" + pv.getSize() + "G]");

                    for (VolumeGroup vg : volumeGroups)
                    {
                        for (PhysicalVolume pv1 : vg.getPVList())
                        {
                            if (pv1.equals(pv))
                            {
                                System.out.print(" [" + vg.getName() + "]");
                            }
                        }
                    }

                    System.out.println(" [" + pv.getUUID() + "]");
                }
            }

            // This command will create a new volume group named "vg1" with the physical volume "pv1"
            // This should report an error if the pv specified doesn't exist or is part of another VG.
            // It should also report an error if the VG name already exists.
            if (command.indexOf("vgcreate ") != -1)
            {
                boolean error = false;
                String info = command.substring(command.indexOf(" ") + 1);
                String volumeName = info.substring(0, info.indexOf(" "));
                String physicalName = info.substring(info.indexOf(" ") + 1);
                PhysicalVolume volume = null;

                for (PhysicalVolume pv : physicalVolumes)
                {
                    if (pv.getName().equals(physicalName))
                    {
                        volume = pv;
                        break;
                    }
                }

                if (physicalVolumes.size() == 0 || volume == null)
                {
                    System.out.println("That physical volume doesn't exist");
                    error = true;
                }

                for (VolumeGroup vg : volumeGroups)
                {
                    if (vg.getName().equals(volumeName))
                    {
                        System.out.println("That volume group already exists");
                        error = true;
                        break;
                    }

                    for (PhysicalVolume pv : vg.getPVList())
                    {
                        if (pv.getName().equals(physicalName))
                        {
                            System.out.println("That physical volume is already associated with a created volume group");
                            error = true;
                            break;
                        }
                    }
                }

                if (error == false)
                {
                    VolumeGroup group = new VolumeGroup(volumeName, volume, logicalVolumes);
                    volumeGroups.add(group);
                    System.out.println(volumeName + " created");
                }
            }

            // This command will add physical volume "pv2" to "vg1"
            // This should report an error if the vg or pv specified doesn't exist or if the PV is part of another VG
            if (command.indexOf("vgextend ") != -1)
            {
                boolean error = false;
                String info = command.substring(command.indexOf(" ") + 1);
                String volumeName = info.substring(0, info.indexOf(" "));
                String physicalName = info.substring(info.indexOf(" ") + 1);
                VolumeGroup group = null;
                PhysicalVolume volume = null;

                for (PhysicalVolume pv : physicalVolumes)
                {
                    if (pv.getName().equals(physicalName))
                    {
                        volume = pv;
                    }
                }

                for (VolumeGroup vg : volumeGroups)
                {
                    if (vg.getName().equals(volumeName))
                    {
                        group = vg;
                        break;
                    }
                }

                for (VolumeGroup vg : volumeGroups)
                {
                    for (PhysicalVolume pv : vg.getPVList())
                    {
                        if (volume.equals(pv))
                        {
                            System.out.println("That physical volume is already associated with a created volume group");
                            error = true;
                            break;
                        }
                    }
                }

                if (volumeGroups.size() == 0 || group == null)
                {
                    System.out.println("That volume group doesn't exist");
                    error = true;
                }

                if (physicalVolumes.size() == 0 || volume == null)
                {
                    System.out.println("That physical volume doesn't exist");
                    error = true;
                }

                if (error == false)
                {
                    for (int i = 0; i < volumeGroups.size(); i++)
                    {
                        if (volumeGroups.get(i).getName().equals(volumeName))
                        {
                            volumeGroups.get(i).extendPVList(volume);
                            System.out.println(volumeGroups.get(i).getName() + " extended");
                            break;
                        }
                    }
                }
            }

            // This command will list information about all the VGs in this format:
            // vg1: total:[300G] available:[120G] [pv1,pv2] [uuid]
            // This means vg1 has a total of 300G, with 120G available and contains the PVs pv1 and pv2.
            if (command.indexOf("vglist") != -1)
            {
                for (VolumeGroup vg : volumeGroups)
                {
                    System.out.print(vg.getName() + ": total:[" + vg.getSize() + "G] available:[" + vg.getFreeSpace() + "G]");
                    System.out.print(" [" + vg.getPVList().get(0).getName());

                    if (vg.getPVList().size() > 1)
                    {
                        for (int i = 1; i < vg.getPVList().size() - 1; i++)
                        {
                            System.out.print(", " + vg.getPVList().get(i).getName());
                        }
                        System.out.print(", " + vg.getPVList().get(vg.getPVList().size() - 1).getName());
                    }

                    System.out.println("] [" + vg.getUUID() + "]");
                }
            }

            // This command will create an LV named "lv1" with the size of 50G inside the volume group "vg1"
            // This should only allow you to do this if there is enough space in the VG
            // This should report an error if the vg name doesn't exist or doesn't have enough space.
            // It should also report an error if the LV name already exists.
            if (command.indexOf("lvcreate ") != -1)
            {
                boolean error = false;
                String info = command.substring(command.indexOf(" ") + 1);
                String logicalName = info.substring(0, info.indexOf(" "));
                info = info.substring(info.indexOf(" ") + 1);
                String logicalSize = info.substring(0, info.indexOf(" "));
                String groupName = info.substring(info.indexOf(" ") + 1);
                VolumeGroup group = null;

                if (logicalSize.indexOf("G") != -1)
                {
                    logicalSize = logicalSize.substring(0, logicalSize.indexOf("G"));
                }

                for (VolumeGroup vg : volumeGroups)
                {
                    if (vg.getName().equals(groupName))
                    {
                        group = vg;
                    }
                }

                if (volumeGroups.size() == 0 || group == null)
                {
                    System.out.println("That volume group doesn't exist");
                    error = true;
                }

                if (group != null && group.getFreeSpace() < Integer.parseInt(logicalSize))
                {
                    System.out.println("That volume group doesn't have enough space");
                    error = true;
                }

                for (LogicalVolume lv : logicalVolumes)
                {
                    if (lv.getName().equals(logicalName))
                    {
                        System.out.println("That logical volume already exists");
                        error = true;
                    }
                }

                if (error == false)
                {
                    LogicalVolume volume = new LogicalVolume(logicalName, Integer.parseInt(logicalSize), group);
                    logicalVolumes.add(volume);

                    for (int i = 0; i < volumeGroups.size(); i++)
                    {
                        if (volumeGroups.get(i).getName().equals(volume.getVolumeGroup().getName()))
                        {
                            volumeGroups.get(i).extendLVList(volume);
                        }
                    }

                    System.out.println(logicalName + " created");
                }
            }

            // This command should list the information about all logical volumes (sorted by volume group) created in this format:
            // lv1: [50G] [vg1] [uuid]
            if (command.indexOf("lvlist") != -1)
            {
                for (LogicalVolume lv : logicalVolumes)
                {
                    System.out.println(lv.getName() + ": [" + lv.getSize() + "G] [" + lv.getVolumeGroup().getName() + "] [" + lv.getUUID() + "]");
                }
            }

            System.out.print("cmd# ");
            command = input.nextLine();
        }
        System.out.println("Saving data. Good bye!");
    }
}