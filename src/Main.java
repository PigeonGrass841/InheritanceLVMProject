import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("List of commands: ");
        System.out.println("-------------------------");
        System.out.println(" - install-drive [drive_name] [size]");
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

        Scanner input = new Scanner(System.in);
        String command = input.nextLine();

        while (!(command.equals("exit")))
        {
            // This command will install a new hard drive with the name "sda" of size 100G
            // You should not allow the user to install a drive that is already installed.
            if (command.indexOf("install-drive ") != -1)
            {
                boolean exists = false;
                String info = command.substring(command.indexOf(" ") + 1);
                String driveName = info.substring(0, info.indexOf(" "));
                String driveSize = info.substring(info.indexOf(" ") + 1);

                for (HardDrive hd : hardDrives)
                {
                    if (hd.getName().equals(driveName))
                    {
                        System.out.println("That hard-drive already exists.");
                        exists = true;
                        break;
                    }
                }

                if (exists == false)
                {
                    HardDrive drive = new HardDrive(driveName, Integer.parseInt(driveSize));
                    hardDrives.add(drive);
                    System.out.println("Drive " + driveName + " installed");
                }

            }

            if (command.indexOf("pvcreate ") != -1)
            {

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
