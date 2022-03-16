import java.util.UUID;

public class LVMSystem {
    private String name;
    private String UUIDs;

    public LVMSystem(String name)
    {
        this.name = name;
        this.UUIDs = (UUID.randomUUID()).toString();
    }

    public String getUUID()
    {
        return this.UUIDs;
    }
}
