package mac_repair.model;


import java.io.Serializable;
import mac_repair.data.RepairerViewReservedDAO;

public class RepairerViewReserved implements Serializable{

	private static final long serialVersionUID = 3L;
	private String facilitytype;
	private String facilityname;
	private String date;
	private String marnum;
	private String to;
	private String from;
	private String phone;
	private String email;
	
	public void setReserved (String date, String marnum, String facilitytype, String facilityname, String to, String from) {
		setFacilitytype(facilitytype);
		setFacilityname(facilityname);
		setDate(date);
		setMarnum(marnum);
		setTo(to);
		setFrom(from);
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
	
	public String getMarnum() {
		return marnum;
	}
	public void setMarnum(String marnum) {
		this.marnum = marnum;
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
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
        this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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