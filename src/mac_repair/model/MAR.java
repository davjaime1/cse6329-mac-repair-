package mac_repair.model;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import mac_repair.data.RepairScheduleDAO;
import mac_repair.data.UtilityDAO;
public class MAR implements Serializable{

	private static final long serialVersionUID = 3L;
	private String marID;
	private String facilityName;
	private String facilityType;
	private String urgency;
	private String description;
	private String reportedUser;
	private String date;
	private String assignedTo;
	private String assignedDate;
	private String estimateOfRepair;
	
	
	public void setAssignedMAR (String marID, String facilityName,String facilityType, String urgency, String  description, String reportedUser, String date, String assignedTo, String assignedDate, String estimateOFRepair) {
		setMAR(marID, facilityName, facilityType, urgency, description, reportedUser,date);
		setAssignedTo(assignedTo);
		setAssignedDate(assignedDate);
		setEstimateOfRepair(estimateOFRepair);
		
	}
	public void setMAR (String marID, String facilityName,String facilityType, String urgency, String  description, String reportedUser, String date) {
		setMarID(marID);
		setFacilityName(facilityName);
		setFacilityType(facilityType);
		setUrgency(urgency);
		setDescription(description);
		setReportedUser(reportedUser);
		setDate(date);	
	}
	
	public String getAssignedTo() {
		return assignedTo;
	}


	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}


	public String getAssignedDate() {
		return assignedDate;
	}


	public void setAssignedDate(String assignedDate) {
		this.assignedDate = assignedDate;
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
	public void validateMAR (String action, MARErrorMsgs errorMsgs) {
		if (action.contains("saveassignedmar")) {
			errorMsgs.setAssignedDatErrorMsgs(validateAssignedDate(this.getAssignedDate()));
			errorMsgs.setAssignedToErrorMsgs(validateAssignedTo(this.getAssignedTo(),this.getAssignedDate()));
			errorMsgs.setDescriptionErrorMsgs(validateDescription(this.getDescription()));

			errorMsgs.setErrorMsg(action);
		}
		else if (action.equals("searchMAR")) {
			if (this.marID.equals("") && this.facilityName.equals("")) 
				errorMsgs.setMarNumberError("Both MAR Number and Facility Name cannot be blank");

			errorMsgs.setErrorMsg(action);				
		}
		else if (action.equals("savemar")) {
			if (this.description.equals("")) 
				errorMsgs.setDescriptionErrorMsgs("Description should not be null");

			errorMsgs.setErrorMsg(action);				
		}

		else
				if (this.marID.equals("") && this.facilityName.equals("")) 
					errorMsgs.setMarNumberError("Both MAR Number and Facility Name cannot be blank");

				errorMsgs.setErrorMsg(action);				

	}
	
	
	private String validateDescription (String description) {
		String result="";
		if (description.isEmpty()){
			result= "Description should not be null";
		}
		return result;				
	}
	private String validateAssignedDate (String assignedDate) {
		String result="";
		Date assgnDate = UtilityDAO.mysqlDateassignmar(assignedDate);
		LocalDate  loccurDate = LocalDate.now();
		LocalDate  locassgnDate = assgnDate.toLocalDate();
		if (locassgnDate.isBefore(loccurDate)){
			result= "Assign Date Should be current of future";
		}

		return result;				
	}
	private String validateAssignedTo (String assignedTo, String assignedDate) {
		String result="";
		Date assgnDate = UtilityDAO.mysqlDateassignmar(assignedDate);
		System.out.println(assignedDate);
		System.out.println(assgnDate);
		if (RepairScheduleDAO.validRepairSchedule(assignedTo, assgnDate))
			result= "Your Repair Schedule Overloaded";
		return result;
	}
	

	public String getEstimateOfRepair() {
		return estimateOfRepair;
	}

	public void setEstimateOfRepair(String estimateOfRepair) {
		this.estimateOfRepair = estimateOfRepair;
	}



}