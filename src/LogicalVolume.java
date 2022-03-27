// Each Logical Volume (LV) has a size, UUID, user provided name, and an associated volume group.
// A logical volume CANNOT exist without an associated volume group.
// You should not be able to create a logical volume in a volume group that does not have enough available space.

public class LogicalVolume extends LVMSystem {
    private VolumeGroup vg; // Associated volume group
    private int size; // Size of the logical volume

    public LogicalVolume (String name, int size, VolumeGroup vg) // Constructor for a logical volume
    {
        super(name);
        this.size = size;
        this.vg = vg;
    }

    public VolumeGroup getVolumeGroup() // Returns the associated volume group
    {
        return this.vg;
    }

    public int getSize() // Returns the size of the logical volume
    {
        return this.size;
    }
}