package mac_repair.model;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import mac_repair.data.FM_RepairScheduleDAO;
import mac_repair.data.FM_UtilityDAO;
public class FM_MAR implements Serializable{

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
		setMarID(marID);
		setFacilityName(facilityName);
		setFacilityType(facilityType);
		setUrgency(urgency);
		setDescription(description);
		setReportedUser(reportedUser);
		setDate(date);	
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
	public void validateMAR (String action, FM_MARErrorMsgs errorMsgs) {
		if (action.contains("saveassignedmar")) {
			errorMsgs.setAssignedDatErrorMsgs(validateAssignedDate(this.getAssignedDate()));
			errorMsgs.setAssignedToErrorMsgs(validateAssignedTo(this.getAssignedTo(),this.getAssignedDate()));
			errorMsgs.setErrorMsg(action);
		}
		else if (action.contains("savemodifiedassignedmar")) {
			errorMsgs.setAssignedDatErrorMsgs(validateAssignedDate(this.getAssignedDate()));
			errorMsgs.setAssignedToErrorMsgs(validateAssignedTo(this.getAssignedTo(),this.getAssignedDate()));
			errorMsgs.setErrorMsg(action);
		}
		else if (action.equals("searchMAR")) {
			if (this.marID.equals("") && this.facilityName.equals("")) 
				errorMsgs.setMarNumberError("Both MAR Number and Facility Name cannot be blank");

			errorMsgs.setErrorMsg(action);				
		}

		else
			if (action.equals("searchAssignMAR")) {
				if (this.marID.equals("") && this.facilityName.equals("")) 
					errorMsgs.setMarNumberError("Both MAR Number and Facility Name cannot be blank");

				errorMsgs.setErrorMsg(action);				
			}

	}
	

	private String validateAssignedDate (String assignedDate) {
		String result="";
		Date date = new Date(System.currentTimeMillis());
		Date assgnDate = FM_UtilityDAO.mysqlDate(assignedDate);
		LocalDate  loccurDate = date.toLocalDate();
		LocalDate  locassgnDate = assgnDate.toLocalDate();
		if (loccurDate.compareTo(locassgnDate)>0){
			result= "Assign Date Should be current of future";
		}
//		else
//			if (!isTextAnInteger(marNumber))
//				result="Your Employee ID must be a number";
//			else
//				if (!EmployeeDAO.uniqueEmpID(marNumber))
//					result="Employee ID already in database";
		return result;				
	}
	private String validateAssignedTo (String assignedTo, String assignedDate) {
		String result="";
		Date assgnDate = FM_UtilityDAO.mysqlDate(assignedDate);
		if (FM_RepairScheduleDAO.validRepairSchedule(assignedTo, assgnDate))
			result= "Your Repair Schedule Overloaded";
//		else
//			if (Character.isLowerCase(name.charAt(0)))
//				result="Your First Name must start with a capital letter";
		return result;
	}
	

//	private String validateBadgeNo (String badge) {
//		String result="";
//		if (!stringSize(badge,3,5))
//			result= "Your Badge Number must between 3 and 5 digits";
//		else
//			if (!isTextAnInteger(badge))
//				result="Your Badge number must be a number";
//		return result;
//	}
//	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
//	private boolean isTextAnInteger (String string) {
//        boolean result;
//		try
//        {
//            Long.parseLong(string);
//            result=true;
//        } 
//        catch (NumberFormatException e) 
//        {
//            result=false;
//        }
//		return result;
//	}

	public String getEstimateOfRepair() {
		return estimateOfRepair;
	}

	public void setEstimateOfRepair(String estimateOfRepair) {
		this.estimateOfRepair = estimateOfRepair;
	}



}