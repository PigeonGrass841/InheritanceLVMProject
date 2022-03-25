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

        ArrayList<PHD> hardDrives = new ArrayList<PHD>();
        ArrayList<PV> pv = new ArrayList<PV>();
        ArrayList<VG> vg = new ArrayList<VG>();


        Scanner input = new Scanner(System.in);
        String command = input.nextLine();

        while (!(command.equals("exit")))
        {
            if (command.indexOf("install-drive ") != -1) {
                String info = command.substring(command.indexOf(" ") + 1);
                String driveName = info.substring(0, info.indexOf(" ") + 1);
                String size = info.substring(info.indexOf(" ") + 1);
                PHD hardDrive = new PHD(driveName, size);
                hardDrives.add(hardDrive);
                System.out.println("Drive " + driveName + "installed");
            }

            if (command.indexOf("pvcreate ") != -1) {
                String info = command.substring(command.indexOf(" ") + 1);
                String physicalName = info.substring(0, info.indexOf(" ") + 1);
                String driveName = info.substring(info.indexOf(" ") + 1);
                PV physical = new PV(physicalName, hardDrives.get(hardDrives.indexOf(driveName)));
                System.out.println(physicalName + " created");
            }

            if (command.indexOf("pvlist") != -1) {
                for (PV physical : pv)
                {
                    System.out.println(physical.getName() + ": [" + physical.getSize() + "] ");
                }
            }

            System.out.print("cmd# ");
            command = input.nextLine();
        }
    }
}
