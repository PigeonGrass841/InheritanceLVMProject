import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        // - Install hard drives
        // - List drives
        // - Create physical volumes
        // - List physical volumes
        // - Create and extend volume groups
        // - List volume groups
        // - Create and extend logical volumes
        // - List logical volumes
        // If the user types the command exit, the program should end.

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

        Scanner input = new Scanner(System.in);
        String command = input.nextLine();

        if (command.indexOf("install-drive ") != -1)
        {
            String info = command.substring(command.indexOf(" ") + 1);
            String driveName = info.substring(0, command.indexOf(" ") + 1);
            int size = Integer.parseInt(info.substring(command.indexOf(" ") + 1));
            PHD physical = new PHD(driveName, size);
        }
    }
}
