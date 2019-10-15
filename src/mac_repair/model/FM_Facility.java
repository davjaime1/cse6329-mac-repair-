package mac_repair.model;
import java.io.Serializable;

import mac_repair.data.FM_FacilityDAO;
public class FM_Facility implements Serializable{

		private static final long serialVersionUID = 3L;
		private String facilityName;
		private String facilityType;
		private String timeInterval;
		private String duration;
		private String venue;

		
		public void setFacility (String facilityName, String facilityType,String timeInterval, String duration, String  venue) {

			setFacilityName(facilityName);
			setFacilityType(facilityType);
			setTimeInterval(timeInterval);
			setDuration(duration);
			setVenue(venue);	
		}
		
		public String getTimeInterval() {
			return timeInterval;
		}


		public void setTimeInterval(String timeInterval) {
			this.timeInterval = timeInterval;
		}


		public String getDuration() {
			return duration;
		}


		public void setDuration(String duration) {
			this.duration = duration;
		}


		public String getVenue() {
			return venue;
		}


		public void setVenue(String venue) {
			this.venue = venue;
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



		public void validateFacility (String action, FM_FacilityErrorMsgs errorMsgs) {
			if (action.equals("saveFacility")) {
				errorMsgs.setFacilityNameError(validateFacilityName(this.getFacilityName()));
				errorMsgs.setErrorMsg();
			}
			else
		//		if (action.equals("searchFacility")) {
					if (this.facilityType.equals("") && this.facilityName.equals("")) 
						errorMsgs.setFacilityNameError("Both Name and Type cannot be blank");

					errorMsgs.setErrorMsg();				
//				}

		}
		


		private String validateFacilityName (String name) {
			String result="";
			if (!stringSize(name,1,45))
				result= "Your Facility Name must between 1 and 45 character";
			else
				if (!FM_FacilityDAO.facilityNameunique(name))
					result = "Facility Name already Exists";
			return result;
		}
		
//		private String validateFacilityType (String surname) {
//			String result="";
//			if (!stringSize(surname,1,45))
//				result= "Your Facility Type must between 1 and 45 character";
////			else
////				if (Character.isLowerCase(surname.charAt(0)))
////					result="Your Last Name must start with a capital letter";
//			return result;
//		}

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
//		private boolean isTextAnInteger (String string) {
//	        boolean result;
//			try
//	        {
//	            Long.parseLong(string);
//	            result=true;
//	        } 
//	        catch (NumberFormatException e) 
//	        {
//	            result=false;
//	        }
//			return result;
//		}


	
	}
