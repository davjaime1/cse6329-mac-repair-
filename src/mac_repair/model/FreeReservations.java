package mac_repair.model;


import java.io.Serializable;
import java.util.ArrayList;

public class FreeReservations implements Serializable
{
    
    private static final long serialVersionUID = 3L;
    private String facilitytype;
    private String facilityname;
    private String date;
    private String to;
    private String from;
    private String venue;
    private String id;
    
    public void setReserved(String facilitytype, String facilityname, String venue, String date, String to, String from)
    {
        setFacilitytype(facilitytype);
        setFacilityname(facilityname);
        setDate(date);
        setTo(to);
        setFrom(from);
        setVenue(venue);
    }
    
    public String getFacilitytype()
    {
        return facilitytype;
    }
    
    public void setFacilitytype(String facilitytype)
    {
        this.facilitytype = facilitytype;
    }
    
    public String getFacilityname()
    {
        return facilityname;
    }
    
    public void setFacilityname(String facilityname)
    {
        this.facilityname = facilityname;
    }
    
    public String getTo()
    {
        return to;
    }
    
    public void setTo(String to)
    {
        this.to = to;
    }
    
    public String getFrom()
    {
        return from;
    }
    
    public void setFrom(String from)
    {
        this.from = from;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public String getVenue()
    {
        return venue;
    }
    
    public void setVenue(String venue)
    {
        this.venue = venue;
    }
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public static ArrayList<FreeReservations> getAvaliableReservations(ArrayList<FreeReservations> possible, ArrayList<FreeReservations> inDB)
    {
		int possibleSize = possible.size();
		int inDBSize = inDB.size();
		for(int i = 0; i < possibleSize; i++)
		{
			for(int j = 0; j < inDBSize; j++)
			{
				if(possible.get(i).getTo().equals(inDB.get(j).getTo().substring(0,19)) && possible.get(i).getFrom().equals(inDB.get(j).getFrom().substring(0,19)))
				{
					if(i == 0)
					{
						possible.remove(i);
						possibleSize--;
						
					}
					else
					{
						possible.remove(i);
						i--;
						possibleSize--;
					}
				}
			}
		}
		return possible; 
    }
}