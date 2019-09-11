package mac_repair.model;

import java.io.Serializable;

public class MAR implements Serializable{

	private static final long serialVersionUID = 3L;
	private String marID;
	private String facilityName;
	private String facilityType;
	private String urgency;
	private String description;
	private String reportedUser;
	private String date;
	
	public void setMAR (String marID, String facilityName,String facilityType, String urgency, String  description, String reportedUser, String date) {
		setMarID(marID);
		setFacilityName(facilityName);
		setFacilityType(facilityType);
		setUrgency(urgency);
		setDescription(description);
		setReportedUser(reportedUser);
		setDate(date);	
	}
	

	public String getMarID() {
		return marID;
	}

	public void setMarID(String marID) {
		this.marID = marID;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
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

	public String getReportedUser() {
		return reportedUser;
	}

	public void setReportedUser(String reportedUser) {
		this.reportedUser = reportedUser;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
}