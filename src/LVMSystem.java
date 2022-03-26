import java.util.UUID;
import java.util.ArrayList;
public class LVMSystem {
    private String name;
    private String UUIDName;

    public LVMSystem (String name)
    {
        this.name = name;
        this.UUIDName = (UUID.randomUUID()).toString();

    }

    public String getName()
    {
        return this.name;
    }

    public String getUUID()
    {
        return this.UUIDName;
    }
}
