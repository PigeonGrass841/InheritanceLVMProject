import java.util.UUID;
import java.util.ArrayList;
public class LVMSystem {
    private String name;
    private String UUIDs;
    private String size;

    public LVMSystem (String name)
    {
        this.name = name;
        this.UUIDs = (UUID.randomUUID()).toString();
        this.size = "";
    }

    public String getName()
    {
        return this.name;
    }

    public String getUUID()
    {
        return this.UUIDs;
    }

    public String getSize()
    {
        return this.size;
    }
}
