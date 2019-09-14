package mac_repair.model;

import java.io.Serializable;

public class Facility implements Serializable
{
    private static final long serialVersionUID = -5533857792763363793L;
    private String name;
    private String type;
    private String interval;
    private String duration;
    private String venue;
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getType()
    {
        return type;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }

    public String getInterval()
    {
        return interval;
    }

    public void setInterval(String interval)
    {
        this.interval = interval;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getVenue()
    {
        return venue;
    }

    public void setVenue(String venue)
    {
        this.venue = venue;
    }
}
