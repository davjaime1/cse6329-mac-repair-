package mac_repair.model;

public class FM_MARErrorMsgs {



	private String errorMsg;
	private String marNumberError;
	private String facilityTypeError;
	private String facilityNameError;
	
	public FM_MARErrorMsgs() {
		this.errorMsg = "";
		this.marNumberError = "";
		this.facilityNameError = "";
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
		if (!marNumberError.equals("") || !facilityNameError.equals(""))
			errorMsg = "Please correct the following errors";
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

	public String getMarNumberError() {
		return marNumberError;
	}

	public void setMarNumberError(String marNumberError) {
		this.marNumberError = marNumberError;
	}
}