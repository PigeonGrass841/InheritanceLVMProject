import java.util.ArrayList;

public class LV extends LVMSystem {
    // Each Logical Volume (LV) has a size, UUID, user provided name, and an associated volume group.
    // A logical volume CANNOT exist without an associated volume group.
    // You should not be able to create a logical volume in a volume group that does not have enough available space.
    // Name, UUID, list of PVs, and a list of LVs for a Volume Group.
    // You should also be able to get the total VG size and the total free space.

    private ArrayList<PV> listOfPVs;
    private ArrayList<LV> listOfLVs;

    public LV (String name, ArrayList<PV> listOfPVs)
    {
        super(name);
        this.listOfPVs = listOfPVs;
    }

    public ArrayList<PV> getListOfPVs()
    {
        return this.listOfPVs;
    }
}
