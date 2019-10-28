package mac_repair.model;
import java.io.Serializable;

import mac_repair.data.FacilityDAO;
public class Facility implements Serializable{

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



		public void validateFacility (String action, FacilityErrorMsgs errorMsgs) {
				errorMsgs.setFacilityNameError(validateFacilityName(this.getFacilityName()));
				errorMsgs.setErrorMsg();
		}
		


		private String validateFacilityName (String name) {
			String result="";
			if (!stringSize(name,1,45))
				result= "Your Facility Name must between 1 and 45 character";
			else if(!FacilityDAO.facilityNameunique(name))
					result = "Facility Name already Exists";
			else 
				result = "";
			return result;
		}
		
		private boolean stringSize(String string, int min, int max) {
			return string.length()>=min && string.length()<=max;
		}
	
	}
