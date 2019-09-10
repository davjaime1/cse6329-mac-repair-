
package mac_repair.model;

public class CompanyErrorMsgs {

	private String errorMsg;
	private String companyIDerror;
	private String companyNameError;
	private String phoneError;
	private String emailError;
	
	public CompanyErrorMsgs() {
		this.errorMsg = "";
		this.companyIDerror = "";
		this.companyNameError = "";
		this.phoneError = "";
		this.emailError = "";
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!companyIDerror.equals("") || !companyNameError.equals("") || !phoneError.equals("") || !emailError.equals(""))
			this.errorMsg = "Please correct the following errors";
	}
	public String getCompanyIDerror() {
		return companyIDerror;
	}
	public void setCompanyIDerror(String companyIDerror) {
		this.companyIDerror = companyIDerror;
	}
	public String getCompanyNameError() {
		return companyNameError;
	}
	public void setCompanyNameError(String companyNameError) {
		this.companyNameError = companyNameError;
	}
	public String getPhoneError() {
		return phoneError;
	}
	public void setPhoneError(String phoneError) {
		this.phoneError = phoneError;
	}
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
}