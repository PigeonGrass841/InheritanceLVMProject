public class VG extends LVMSystem {
    // Volume Groups (VGs) also have a UUID and a user provided name.
    // VGs consist of a list of physical volumes, and a list of Logical Volumes.
    // You should be able to get the size of a VG by adding up all of its associated PVs.
    // You should also be able to compute how much free space is left on a VG by looking at how big each Logical Volume is and subtracting that from the total PV space.
    // Name, UUID, size, and associated VG for a specific LV
    private int size = 0;
    private PV[] physical;
    private LV[] logical;

    public VG(String name, PV[] physical, LV[] logical)
    {
        super(name);
        this.physical = physical;
        this.logical = logical;
        for (LV volume : logical)
        {
            this.size = volume.getSize();
        }
    }
}
