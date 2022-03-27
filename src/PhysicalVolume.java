// Each physical volume (PV) has only one associated physical hard drive, and a user provided name.
// Each PV also has a UUID (Universally Unique Identifier) that is generated whenever a PV is created.
// A PV can only be created with an associated hard drive.
// PVs can also be added to Volume Groups (outlined below).
// A physical hard drive can only belong to one physical volume.

public class PhysicalVolume extends LVMSystem {
    private HardDrive hardDrive; // Associated hard drive

    public PhysicalVolume (String name, HardDrive hardDrive) // Constructor for a physical volume
    {
        super(name);
        this.hardDrive = hardDrive;
    }

    public HardDrive getHardDrive() // Return associated hard drive
    {
        return this.hardDrive;
    }

    public int getSize() // Returns the size of the associated hard drive
    {
        return hardDrive.getSize();
    }
}