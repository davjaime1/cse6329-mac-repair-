package mac_repair.model;


import java.io.Serializable;
import mac_repair.data.RepairerViewReservedDAO;

public class FreeReservations implements Serializable{

	private static final long serialVersionUID = 3L;
	private String facilitytype;
	private String facilityname;
	private String date;
	private String to;
	private String from;
	private String venue;
	private String id;
	
	public void setReserved (String facilitytype, String facilityname, String venue, String date, String to, String from) {
		setFacilitytype(facilitytype);
		setFacilityname(facilityname);
		setDate(date);
		setTo(to);
		setFrom(from);
		setVenue(venue);
	}
	
	public String getFacilitytype() {
		return facilitytype;
	}
	public void setFacilitytype(String facilitytype) {
		this.facilitytype = facilitytype;
	}
	
	public String getFacilityname() {
		return facilityname;
	}
	public void setFacilityname(String facilityname) {
		this.facilityname = facilityname;
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getVenue() {
		return venue;
	}
	
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id= id;
	}
	


//	This section is for general purpose methods used internally in this class
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
}