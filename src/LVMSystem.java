import java.util.UUID;
import java.util.ArrayList;
public class LVMSystem {
    private String name;
    private String UUIDs;
    private int size;

    public LVMSystem (String name)
    {
        this.name = name;
        this.UUIDs = (UUID.randomUUID()).toString();
        this.size = 0;
    }

    public String getName()
    {
        return this.name;
    }

    public String getUUID()
    {
        return this.UUIDs;
    }

    public int getSize()
    {
        return this.size;
    }
}
