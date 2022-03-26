// Volume Groups (VGs) also have a UUID and a user provided name.
// VGs consist of a list of physical volumes, and a list of Logical Volumes.
// You should be able to get the size of a VG by adding up all of its associated PVs.
// You should also be able to compute how much free space is left on a VG by looking at how big each Logical Volume is and subtracting that from the total PV space.

import java.util.ArrayList;

public class VolumeGroup extends LVMSystem {
    private ArrayList<PhysicalVolume> pvList = new ArrayList<PhysicalVolume>();
    private ArrayList<LogicalVolume> lvList = new ArrayList<LogicalVolume>();
    private PhysicalVolume physicalVolume;
    private int size;
    private int freeSpace;

    public VolumeGroup (String name, PhysicalVolume physicalVolume, ArrayList<LogicalVolume> lvlist)
    {
        super(name);
        this.pvList.add(physicalVolume);

        for (LogicalVolume lv : lvList)
        {
            if (lv.getVolumeGroup().getUUID().equals(getUUID()))
            {
                this.lvList.add(lv);
            }
        }

        for (PhysicalVolume pv : pvList)
        {
            size += pv.getSize();
        }

        for (LogicalVolume lv : this.lvList)
        {
            this.freeSpace += lv.getSize();
        }

        this.freeSpace = this.freeSpace - size;
    }

    public void extendPVList(PhysicalVolume pv)
    {
        this.pvList.add(pv);
    }

    public ArrayList<PhysicalVolume> getPVList()
    {
        return this.pvList;
    }

    public void extendLVList(LogicalVolume lv)
    {
        this.lvList.add(lv);
    }

    public ArrayList<LogicalVolume> getLVList()
    {
        return this.lvList;
    }

    public void setFreeSpace()
    {
        for (LogicalVolume lv : lvList)
        {
            this.freeSpace += lv.getSize();
        }
        this.freeSpace = this.freeSpace - size;
    }

    public int getFreeSpace()
    {
        return this.freeSpace;
    }

    public void setSize()
    {
        for (PhysicalVolume pv : pvList)
        {
            size += pv.getSize();
        }
    }

    public int getSize()
    {
        return this.size;
    }
}