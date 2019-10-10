package mac_repair.model;
public class UserErrorMsgs{



	private String errorMsg;
	private String utaidError;
	private String firstnameError;
	private String lastnameError;
	private String passwordError;
	private String roleError;
	private String addressError;
	private String stateError;
	private String cityError;
	private String zipError;
	private String phoneError;
	private String emailError;
	private String userNameError;

	
	public UserErrorMsgs() {

		this.setUserNameError("");
//		this.usernameError = "";
		this.setUtaidError("");
		this.setFirstnameError("");
		this.setLastnameError("");
		this.setPasswordError("");
		this.setRoleError("");
		this.setAddressError("");
		this.setStateError("");
		this.setCityError("");
		this.setZipError("");
		this.setPhoneError("");
		this.setEmailError("");
		this.setErrorMsg("");
		}


	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String action) {
		if (action.contains("registerUser") || action.contains("update")|| action.contains("ApplyNew")) {

			if(!userNameError.equals("") || !utaidError.equals("")|| !firstnameError.equals("") || !lastnameError.equals("") || !passwordError.equals("") 
					|| !roleError.equals("")|| !addressError.equals("") || !stateError.equals("") || !cityError.equals("")|| !zipError.equals("")
					|| !phoneError.equals("")|| !emailError.equals("") 	) {
				this.errorMsg = "Fields cannot be left empty ";
			System.out.println("Inside setErrorMsg(): set errorMsg: "+this.errorMsg);
			}
			else
				this.errorMsg = "";
		}
		else {
			if(!userNameError.equals("") || !passwordError.equals(""))

				this.errorMsg = "Invalid Login";
			else
				this.errorMsg = "";
		}
	}


	public String getUtaidError() {
		return utaidError;
	}


	public void setUtaidError(String utaidError) {
		this.utaidError = utaidError;
	}


	public String getFirstnameError() {
		return firstnameError;
	}


	public void setFirstnameError(String firstnameError) {
		this.firstnameError = firstnameError;
	}


	public String getLastnameError() {
		return lastnameError;
	}


	public void setLastnameError(String lastnameError) {
		this.lastnameError = lastnameError;
	}


	public String getPasswordError() {
		return passwordError;
	}


	public void setPasswordError(String passwordError) {
		this.passwordError = passwordError;
	}


	public String getRoleError() {
		return roleError;
	}


	public void setRoleError(String roleError) {
		this.roleError = roleError;
	}


	public String getAddressError() {
		return addressError;
	}


	public void setAddressError(String addressError) {
		this.addressError = addressError;
	}


	public String getStateError() {
		return stateError;
	}


	public void setStateError(String stateError) {
		this.stateError = stateError;
	}


	public String getCityError() {
		return cityError;
	}


	public void setCityError(String cityError) {
		this.cityError = cityError;
	}


	public String getZipError() {
		return zipError;
	}


	public void setZipError(String zipError) {
		this.zipError = zipError;
	}


	public String getEmailError() {
		return emailError;
	}


	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}


	public String getPhoneError() {
		return phoneError;
	}


	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}


	public String getUserNameError() {
		return userNameError;
	}


	public void setUserNameError(String userNameError) {
		this.userNameError = userNameError;
	}

//	public String getErrorMsg() {
//		return this.errorMsg;
//	}
//	public void setErrorMsg(String action) {

//	}



	
}