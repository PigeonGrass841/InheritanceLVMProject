import java.util.ArrayList;

public class PV extends LVMSystem {
    // Each physical volume (PV) has only one associated physical hard drive, and a user provided name.
    // Each PV also has a UUID (Universally Unique Identifier) that is generated whenever a PV is created.
    // A PV can only be created with an associated hard drive.
    // PVs can also be added to Volume Groups (outlined below).
    // A physical hard drive can only belong to one physical volume.
    // Name, UUID, and associated hard drive of each PV.
    // You should also be able to get the size of a PV by checking its hard drive.

    private PHD hardDrive;
    private String size;

    public PV(String name, PHD hardDrive)
    {
        super(name);
        this.hardDrive = hardDrive;
        this.size = hardDrive.getSize();
    }
}
