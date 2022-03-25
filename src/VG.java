import java.util.ArrayList;

public class VG extends LVMSystem {
    // Volume Groups (VGs) also have a UUID and a user provided name.
    // VGs consist of a list of physical volumes, and a list of Logical Volumes.
    // You should be able to get the size of a VG by adding up all of its associated PVs.
    // You should also be able to compute how much free space is left on a VG by looking at how big each Logical Volume is and subtracting that from the total PV space.
    // Name, UUID, size, and associated VG for a specific LV

    private ArrayList<PV> listOfPVs;
    private ArrayList<LV> listOfLVs;
    private String size;

    public VG (String name, ArrayList<PV> listOfPVs, ArrayList<LV> listOfLVs)
    {
        super(name);
        this.listOfPVs = listOfPVs;
        this.listOfLVs = listOfLVs;
        this.size = "";

        for (PV volume : listOfPVs)
        {
            this.size += volume.getSize();
        }
    }

    public String totalFreeSpace()
    {
        int totalFreeSpace = 0;

        for (LV volume : listOfLVs)
        {
            totalFreeSpace += Integer.parseInt(volume.getSize());
        }

        for (PV volume : listOfPVs)
        {
            totalFreeSpace -= Integer.parseInt(volume.getSize());
        }

        return totalFreeSpace + "G";
    }
}
