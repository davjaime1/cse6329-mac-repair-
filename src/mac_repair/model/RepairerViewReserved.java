package mac_repair.model;


import java.io.Serializable;
import java.util.ArrayList;

public class RepairerViewReserved implements Serializable
{
    
    private static final long serialVersionUID = 3L;
    private String facilitytype;
    private String facilityname;
    private String date;
    private String marnum;
    private String to;
    private String from;
    private String user;
    
    public void setReserved(String date, String marnum, String facilitytype, String facilityname, String to,
            String from)
    {
        setFacilitytype(facilitytype);
        setFacilityname(facilityname);
        setDate(date);
        setMarnum(marnum);
        setTo(to);
        setFrom(from);
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
    
    public String getMarnum()
    {
        return marnum;
    }
    
    public void setMarnum(String marnum)
    {
        this.marnum = marnum;
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
    
    public void setUser(String user)
    {
    	this.user = user;
    }
    
    public String getUser()
    {
    	return user;
    }
    
    public static String userReserve(ArrayList<RepairerViewReserved> reservedListInDB, String currentUser)
    {
    	String ret = "TRUE";
    	for(int i = 0; i < reservedListInDB.size(); i++)
    	{
    		if(reservedListInDB.get(i).getUser().equals(currentUser))
    		{
    			ret = "FALSE";
    		}
    	}
    	return ret;
    }
}