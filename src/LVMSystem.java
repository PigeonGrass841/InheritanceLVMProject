import java.util.UUID;
import java.util.ArrayList;

public class LVMSystem {
    private String name; // Name
    private String UUIDName; // Randomly generated UUID

    public LVMSystem (String name) // Constructor for the LVM System
    {
        this.name = name;
        this.UUIDName = (UUID.randomUUID()).toString();
    }

    public String getName() // Returns the name
    {
        return this.name;
    }

    public String getUUID() // Returns the UUID
    {
        return this.UUIDName;
    }
}