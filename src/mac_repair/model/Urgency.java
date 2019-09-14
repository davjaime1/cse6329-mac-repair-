package mac_repair.model;

import java.io.Serializable;

public class Urgency implements Serializable
{
    private static final long serialVersionUID = 3016476298550996297L;
    private String id;
    private String urgency;
    
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getUrgency()
    {
        return urgency;
    }
    
    public void setUrgency(String urgency)
    {
        this.urgency = urgency;
    }
}
