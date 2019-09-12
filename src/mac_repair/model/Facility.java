package mac_repair.model;

import java.io.Serializable;

public class Facility implements Serializable
{
    private static final long serialVersionUID = -5533857792763363793L;
    private String name;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
}
