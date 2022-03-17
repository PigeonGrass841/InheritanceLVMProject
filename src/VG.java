public class VG extends LVMSystem {
    // Volume Groups (VGs) also have a UUID and a user provided name.
    // VGs consist of a list of physical volumes, and a list of Logical Volumes.
    // You should be able to get the size of a VG by adding up all of its associated PVs.
    // You should also be able to compute how much free space is left on a VG by looking at how big each Logical Volume is and subtracting that from the total PV space.
    // Name, UUID, size, and associated VG for a specific LV

    private PV[] listOfPVs;
    private LV[] listOfLVs;


    public VG (String name, PV[] listOfPVs, LV[] listOfLVs)
    {
        super(name);
        this.listOfPVs = listOfPVs;
        this.listOfLVs = listOfLVs;

        for (PV volume : listOfPVs)
        {
            size += volume.getSize();
        }
    }

    public int totalFreeSpace()
    {

    }
}
