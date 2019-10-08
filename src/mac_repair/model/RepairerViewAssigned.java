package mac_repair.model;


import java.io.Serializable;
import mac_repair.data.RepairerViewAssignedDAO;

public class RepairerViewAssigned implements Serializable{

	private static final long serialVersionUID = 3L;
	private String assignedmar;
	private String facilitytype;
	private String facilityname;
	private String urgency;
	private String description;
	private String reporteddate;
	private String reportedby;
	private String assignedDate;
	private String estimateofrepair;
	
	public void setReserved (String assignedmar, String facilityname, String facilitytype, String urgency, String description, String reporteddate, String reportedby, String assignedDate, String estimateofrepair) {
		setFacilitytype(facilitytype);
		setFacilityname(facilityname);
		setAssignedmar(assignedmar);
		setUrgency(urgency);
		setDescription(description);
		setReporteddate(reporteddate);
		setReportedby(reportedby);
		setAssignedDate(assignedDate);
		setEstimateofrepair(estimateofrepair);
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
	
	public String getAssignedmar() {
		return assignedmar;
	}
	public void setAssignedmar(String assignedmar) {
		this.assignedmar = assignedmar;
	}
	
	public String getUrgency() {
		return urgency;
	}
	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getReporteddate()
	{
		return reporteddate;
	}
	
	public void setReporteddate(String reporteddate) {
		this.reporteddate = reporteddate;
	}
	
	public String getReportedby() {
		return reportedby;
	}
	
	public void setReportedby(String reportedby)
	{
		this.reportedby = reportedby;
	}
	
	public String getAssignedDate() {
		return assignedDate;
	}
	
	public void setAssignedDate(String assigneddate) {
		this.assignedDate = assigneddate;
	}
	
	public String getEstimateofrepair() {
		return estimateofrepair;
	}
	
	public void setEstimateofrepair(String estimateofrepair) {
		this.estimateofrepair = estimateofrepair;
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