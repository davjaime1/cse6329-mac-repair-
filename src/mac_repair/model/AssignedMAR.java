package mac_repair.model;
import java.io.Serializable;
public class AssignedMAR  implements Serializable{
	private static final long serialVersionUID = 3L;
	private String marID;
	private String facilityName;
	private String facilityType;
	private String urgency;
	private String description;
	private String assignedTo;
	private String assigneddate;
	private String estimateOfRepair;
	
	public void setMAR (String marID, String facilityName,String facilityType, String urgency, String  description, String assignedTo, String assigneddate,String estimateOfRepair ) {
		setMarID(marID);
		setFacilityName(facilityName);
		setFacilityType(facilityType);
		setUrgency(urgency);
		setDescription(description);
		setAssignedTo(assignedTo);
		setAssigneddate(assigneddate);	
		setEstimateOfRepair(estimateOfRepair);
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


	public String getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}


	public String getAssigneddate() {
		return assigneddate;
	}


	public void setAssigneddate(String assigneddate) {
		this.assigneddate = assigneddate;
	}


	public String getEstimateOfRepair() {
		return estimateOfRepair;
	}


	public void setEstimateOfRepair(String estimateOfRepair) {
		this.estimateOfRepair = estimateOfRepair;
	}
}
