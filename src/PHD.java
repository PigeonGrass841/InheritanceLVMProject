import java.util.ArrayList;

public class PHD extends LVMSystem {
    // Each physical hard drive has a name and size (in GB).
    // Name and size of each hard drive
    private int size;

    public PHD(String name, int size)
    {
        super(name);
        this.size = size;
    }
}
