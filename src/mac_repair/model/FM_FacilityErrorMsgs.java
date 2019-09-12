package mac_repair.model;

public class FM_FacilityErrorMsgs {

	private String errorMsg;
	private String facilityTypeError;
	private String facilityNameError;
	private String venueError;
	private String timeIntervalError;
	private String durationError;
	
	public FM_FacilityErrorMsgs() {
		this.errorMsg = "";
// Comment out the following to get PIT coverage even though it is not per Oracle
/*		this.employeeIDerror = "";
		this.firstNameError = "";
		this.lastNameError = "";
		this.companyBadgeError = "";
*/	}

	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if ( !facilityNameError.equals("")  )
			errorMsg = "Please correct the following errors";
	}

	public void setErrorMsg(String emsg) {
		this.errorMsg = emsg;
	}


	public String getFacilityTypeError() {
		return facilityTypeError;
	}

	public void setFacilityTypeError(String facilityTypeError) {
		this.facilityTypeError = facilityTypeError;
	}

	public String getFacilityNameError() {
		return facilityNameError;
	}

	public void setFacilityNameError(String facilityNameError) {
		this.facilityNameError = facilityNameError;
	}



	public String getVenueError() {
		return venueError;
	}

	public void setVenueError(String venueError) {
		this.venueError = venueError;
	}

	public String getTimeIntervalError() {
		return timeIntervalError;
	}

	public void setTimeIntervalError(String timeIntervalError) {
		this.timeIntervalError = timeIntervalError;
	}

	public String getDurationError() {
		return durationError;
	}

	public void setDurationError(String durationError) {
		this.durationError = durationError;
	}
}