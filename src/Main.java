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

        Scanner input = new Scanner(System.in);
        String command = input.nextLine();

        while (!(command.equals("exit")))
        {
            if (command.indexOf("install-drive ") != -1) {
            }

            if (command.indexOf("pvcreate ") != -1) {
            }

            if (command.indexOf("pvlist") != -1) {
            }

            System.out.print("cmd# ");
            command = input.nextLine();
        }
    }
}
