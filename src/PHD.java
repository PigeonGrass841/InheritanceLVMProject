import java.util.ArrayList;

public class PHD extends LVMSystem {
    // Each physical hard drive has a name and size (in GB).
    // Name and size of each hard drive
    private String size;

    public PHD(String name, String size)
    {
        super(name);
        this.size = size;
    }
}
