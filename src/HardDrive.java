// Each physical hard drive has a name and size (in GB).

public class HardDrive extends LVMSystem {
    private int size; // Size of the hard-drive

    public HardDrive(String name, int size) // Constructor for a hard-drive
    {
        super(name);
        this.size = size;
    }

    public int getSize() // Returns the size of the hard-drive
    {
        return this.size;
    }
}