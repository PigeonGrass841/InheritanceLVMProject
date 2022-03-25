import java.util.UUID;
import java.util.ArrayList;
public class LVMSystem {
    private String name;
    private int size;
    private String UUIDName;

    public LVMSystem (String name, int size)
    {
        this.name = name;
        this.size = size;
        this.UUIDName = (UUID.randomUUID()).toString();

    }

    public String getName()
    {
        return this.name;
    }

    public int getSize()
    {
        return this.size;
    }

    public String getUUID()
    {
        return this.UUIDName;
    }
}
