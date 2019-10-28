package mac_repair.model;

public class MARErrorMsgs {


		private String errorMsg;
		private String assignedToErrorMsgs;
		private String assignedDatErrorMsgs;
		private String marNumberError;
//		private String facilityNameError;
		private String descriptionErrorMsgs;
		
		public MARErrorMsgs() {
			this.errorMsg = "";
			this.marNumberError = "";
			this.assignedDatErrorMsgs="";
			this.assignedToErrorMsgs="";
			this.descriptionErrorMsgs="";


	// Comment out the following to get PIT coverage even though it is not per Oracle
	/*		this.employeeIDerror = "";
			this.firstNameError = "";
			this.lastNameError = "";
			this.companyBadgeError = "";
	*/	}

		public String getErrorMsg() {
			return errorMsg;
		}
		public void setErrorMsg(String action) {
			if (action.contains("saveassignedmar")) {
				if(!assignedToErrorMsgs.equals("") || !assignedDatErrorMsgs.equals("") || !descriptionErrorMsgs.equals("")	)
					errorMsg = "Please correct the following errors";
				else
					errorMsg = "";
			}
			else {
				errorMsg = action;
			}
		}

		public String getAssignedToErrorMsgs() {
			return assignedToErrorMsgs;
		}

		public void setAssignedToErrorMsgs(String assignedToErrorMsgs) {
			this.assignedToErrorMsgs = assignedToErrorMsgs;
		}

		public String getAssignedDatErrorMsgs() {
			return assignedDatErrorMsgs;
		}

		public void setAssignedDatErrorMsgs(String assignedDatErrorMsgs) {
			this.assignedDatErrorMsgs = assignedDatErrorMsgs;
		}



		public String getMarNumberError() {
			return marNumberError;
		}

		public void setMarNumberError(String marNumberError) {
			this.marNumberError = marNumberError;
		}


		public String getDescriptionErrorMsgs() {
			return descriptionErrorMsgs;
		}

		public void setDescriptionErrorMsgs(String descriptionErrorMsgs) {
			this.descriptionErrorMsgs = descriptionErrorMsgs;
		}

		
}
