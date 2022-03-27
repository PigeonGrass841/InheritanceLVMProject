// Volume Groups (VGs) also have a UUID and a user provided name.
// VGs consist of a list of physical volumes, and a list of Logical Volumes.
// You should be able to get the size of a VG by adding up all of its associated PVs.
// You should also be able to compute how much free space is left on a VG by looking at how big each Logical Volume is and subtracting that from the total PV space.

import java.util.ArrayList;

public class VolumeGroup extends LVMSystem {
    private ArrayList<PhysicalVolume> pvList = new ArrayList<PhysicalVolume>(); // List of associated physical volumes
    private ArrayList<LogicalVolume> lvList = new ArrayList<LogicalVolume>(); // List of associated logical volumes
    private PhysicalVolume physicalVolume; // associated physical volume
    private int size = 0; // Size of the volume group
    private int freeSpace = 0; // Amount of free space

    public VolumeGroup (String name, PhysicalVolume physicalVolume, ArrayList<LogicalVolume> lvlist) // Constructor for a volume group
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

        this.freeSpace = this.size - this.freeSpace;
    }

    public void extendPVList(PhysicalVolume pv) // Adds an associated physical volume to pvList and sets the volume group's size and amount of free space
    {
        this.pvList.add(pv);
        setSize();
        setFreeSpace();
    }

    public ArrayList<PhysicalVolume> getPVList() // Returns a list of associated physical volumes
    {
        return this.pvList;
    }

    public void extendLVList(LogicalVolume lv) // Adds an associated logical volume to lvList and sets the volume group's size and amount of free space
    {
        this.lvList.add(lv);
        setSize();
        setFreeSpace();
    }

    public ArrayList<LogicalVolume> getLVList() // Returns a list of associated logical volumes
    {
        return this.lvList;
    }

    public void setFreeSpace() // Sets freeSpace to the amount of free space in the volume group
    {
        this.freeSpace = 0;
        for (LogicalVolume lv : this.lvList)
        {
            this.freeSpace += lv.getSize();
        }
        this.freeSpace = this.size - this.freeSpace;
    }

    public int getFreeSpace() // Returns the amount of free space
    {
        return this.freeSpace;
    }

    public void setSize() // Sets size to the size of the volume group
    {
        this.size = 0;
        for (PhysicalVolume pv : this.pvList)
        {
            this.size += pv.getSize();
        }
    }

    public int getSize() // Returns the size of the volume group
    {
        return this.size;
    }
}