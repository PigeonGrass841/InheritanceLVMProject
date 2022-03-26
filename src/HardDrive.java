// Each physical hard drive has a name and size (in GB).

public class HardDrive extends LVMSystem {
    private int size;

    public HardDrive(String name, int size)
    {
        super(name);
        this.size = size;
    }
    public int getSize()
    {
        return this.size;
    }
}