package mac_repair.model;

public class FacilityErrorMsgs {

	private String errorMsg;
	private String facilityNameError;
	
	public FacilityErrorMsgs() {
		this.errorMsg = "";
// Comment out the following to get PIT coverage even though it is not per Oracle
		this.facilityNameError = "";

	}

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


	public String getFacilityNameError() {
		return facilityNameError;
	}

	public void setFacilityNameError(String facilityNameError) {
		this.facilityNameError = facilityNameError;
	}

}