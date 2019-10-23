package mac_repair.model;

public class RepairScheduleErrorMsgs {

	private String errorMsg;
	private String marNumberError;
	private String usernameError;
	
	public RepairScheduleErrorMsgs() {
		this.errorMsg = "";
		this.marNumberError = "";
		this.usernameError = "";
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
		if (!marNumberError.equals("") || !usernameError.equals(""))
			errorMsg = "Please correct the following errors";
	}

	public String getMarNumberError() {
		return marNumberError;
	}

	public void setMarNumberError(String marNumberError) {
		this.marNumberError = marNumberError;
	}

	public String getUsernameError() {
		return usernameError;
	}

	public void setUsernameError(String usernameError) {
		this.usernameError = usernameError;
	}
}