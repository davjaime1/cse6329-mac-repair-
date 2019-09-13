package mac_repair.model;


import java.io.Serializable;

public class FM_RepairSchedule  implements Serializable{

		private static final long serialVersionUID = 3L;
		private String username;
		private String marID;
		private String scheduleDate;
		public void setRepairSchedule(String username, String marID, String scheduleDate) {
			setUsername(username);
			setScheduleDate(scheduleDate);
			setMarID(marID);
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}

		public String getScheduleDate() {
			return scheduleDate;
		}
		public void setScheduleDate(String scheduleDate) {
			this.scheduleDate = scheduleDate;
		}
		public String getMarID() {
			return marID;
		}
		public void setMarID(String marID) {
			this.marID = marID;
		}
		public void validateRepairSchedule (String action, FM_RepairScheduleErrorMsgs errorMsgs) {

				if (action.equals("searchrepairschedule")) {
					if (this.marID.equals("") && this.username.equals("")) 
						errorMsgs.setMarNumberError("Both MAR Number and Facility Name cannot be blank");

					errorMsgs.setErrorMsg();				
				}

		}
		

		private String validateMARNumber (String marNumber) {
			String result="";
			if (!stringSize(marNumber,3,16))
				result= "Your MAR Number must between 3 and 16 character";
//			else
//				if (!isTextAnInteger(marNumber))
//					result="Your Employee ID must be a number";
//				else
//					if (!EmployeeDAO.uniqueEmpID(marNumber))
//						result="Employee ID already in database";
			return result;				
		}
		private String validateFacilityName (String name) {
			String result="";
			if (!stringSize(name,1,45))
				result= "Your Facility Name must between 1 and 45 character";
//			else
//				if (Character.isLowerCase(name.charAt(0)))
//					result="Your First Name must start with a capital letter";
			return result;
		}
		
		private String validateFacilityType (String surname) {
			String result="";
			if (!stringSize(surname,1,45))
				result= "Your Facility Type must between 1 and 45 character";
//			else
//				if (Character.isLowerCase(surname.charAt(0)))
//					result="Your Last Name must start with a capital letter";
			return result;
		}

//		private String validateBadgeNo (String badge) {
//			String result="";
//			if (!stringSize(badge,3,5))
//				result= "Your Badge Number must between 3 and 5 digits";
//			else
//				if (!isTextAnInteger(badge))
//					result="Your Badge number must be a number";
//			return result;
//		}
	//	
		private boolean stringSize(String string, int min, int max) {
			return string.length()>=min && string.length()<=max;
		}
//		private boolean isTe
}
