public class LV extends LVMSystem {
    // Logical Volumes are the highest level of LVM, which are used to create file structures on top.
    // Each Logical Volume (LV) has a size, UUID, user provided name, and an associated volume group.
    // A logical volume CANNOT exist without an associated volume group.
    // You should not be able to create a logical volume in a volume group that does not have enough available space.
    // Name, UUID, list of PVs, and a list of LVs for a Volume Group.
    // You should also be able to get the total VG size and the total free space.

    private int size;
    private PV[] PVList;
    private LV[] LVList;

    public LV(String name, int size)
    {
        super(name);
        this.size = size;
    }

    public int getSize()
    {
        return this.size;
    }
}
