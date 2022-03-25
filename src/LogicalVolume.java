// Each Logical Volume (LV) has a size, UUID, user provided name, and an associated volume group.
// A logical volume CANNOT exist without an associated volume group.
// You should not be able to create a logical volume in a volume group that does not have enough available space.
public class LogicalVolume extends LVMSystem {
    private VolumeGroup vg;

    public LogicalVolume (String name, int size, VolumeGroup vg)
    {
        super(name, size);
        this.vg = vg;
    }
}