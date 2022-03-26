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
        System.out.println(" - lvcreate [lv_size] [vg_name]");
        System.out.println(" - lvlist");
        System.out.println("-------------------------");
        System.out.println("Welcome to the LVM System! Enter your commands: ");
        System.out.print("cmd# ");

        ArrayList<HardDrive> hardDrives = new ArrayList<HardDrive>();
        ArrayList<PhysicalVolume> physicalVolumes = new ArrayList<PhysicalVolume>();

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
                        System.out.println("That hard-drive already exists.");
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

                if (hardDrives.size() == 0)
                {
                    System.out.println("That hard-drive doesn't exist.");
                    error = true;
                }

                for (HardDrive hd : hardDrives)
                {
                    if (hd.getName().equals(driveName))
                    {
                        drive = hd;
                        break;
                    }
                }

                if (drive == null)
                {
                    System.out.println("That hard-drive doesn't exist.");
                    error = true;
                }

                for (PhysicalVolume pv : physicalVolumes)
                {
                    if (pv.getHardDrive().getName().equals(driveName))
                    {
                        System.out.println("That hard-drive is already associated with a created physical volume");
                        error = true;
                    }

                    if (pv.getName().equals(physicalName))
                    {
                        System.out.println("That physical volume already exists");
                        error = true;
                    }
                }

                if (error == false)
                {
                    PhysicalVolume volume = new PhysicalVolume(physicalName, drive);
                    physicalVolumes.add(volume);
                    System.out.println(physicalName + " created");
                }
            }

            if (command.indexOf("pvlist") != -1)
            {

            }

            if (command.indexOf("vgcreate ") != -1)
            {

            }

            if (command.indexOf("vgextend ") != -1)
            {

            }

            if (command.indexOf("vglist") != -1)
            {

            }

            if (command.indexOf("lvcreate ") != -1)
            {

            }

            if (command.indexOf("lvlist") != -1)
            {

            }

            System.out.print("cmd# ");
            command = input.nextLine();
        }
    }
}
