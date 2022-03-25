// Volume Groups (VGs) also have a UUID and a user provided name.
// VGs consist of a list of physical volumes, and a list of Logical Volumes.
// You should be able to get the size of a VG by adding up all of its associated PVs.
// You should also be able to compute how much free space is left on a VG by looking at how big each Logical Volume is and subtracting that from the total PV space.

import java.util.ArrayList;

public class VolumeGroup extends LVMSystem {
    private ArrayList<PhysicalVolume> pvList;
    private ArrayList<LogicalVolume> lvList;
    private int size;
    private int freeSpace;

    public VolumeGroup (String name, ArrayList<PhysicalVolume> pvList, ArrayList<LogicalVolume> lvList)
    {
        super(name, 0);
        this.pvList = pvList;
        this.lvList = lvList;
        for (PhysicalVolume pv : pvList)
        {
            size += pv.getSize();
        }
        for (LogicalVolume lv : lvList)
        {
            this.freeSpace += lv.getSize();

        }
        this.freeSpace = this.freeSpace - size;
    }

    public ArrayList<PhysicalVolume> getPVList()
    {
        return this.pvList;
    }

    public ArrayList<LogicalVolume> getLVList()
    {
        return this.lvList;
    }

    public int getFreeSpace()
    {
        return this.freeSpace;
    }
}