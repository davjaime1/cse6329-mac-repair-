package mac_repair.model;


import java.io.Serializable;

import mac_repair.data.EmployeeDAO;

public class Employee implements Serializable {

	private static final long serialVersionUID = 2L;
	private String idemployee;
	private String name;
	private String surname;
	private String badge;
	private String fk_company;
	public String getIdemployee() {
		return idemployee;
	}
	public void setEmployee (String idemployee, String name, String surname, String badge) {
		this.setIdemployee(idemployee);
		this.setName(name);
		this.setSurname(surname);
		this.setBadge(badge);
	}
	
	public void setIdemployee(String idemployee) {
		this.idemployee = idemployee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public String getFk_company() {
		return fk_company;
	}
	public void setFk_company(String fk_company) {
		this.fk_company = fk_company;
	}
	public void validateEmployee (Employee employee, EmployeeErrorMsgs errorMsgs) {
		errorMsgs.setEmployeeIDerror(validateIDemployee(employee.getIdemployee()));
		errorMsgs.setFirstNameError(validateFirstName(employee.getName()));
		errorMsgs.setLastNameError(validateLastName(employee.getSurname()));
		errorMsgs.setCompanyBadgeError(validateBadgeNo(employee.getBadge()));
		errorMsgs.setErrorMsg();
	}
	private String validateIDemployee (String idemployee) {
		String result="";
		if (!stringSize(idemployee,3,16))
			result= "Your Employee Id must between 3 and 16 digits";
		else
			if (!isTextAnInteger(idemployee))
				result="Your Employee ID must be a number";
			else
				if (!EmployeeDAO.uniqueEmpID(idemployee))
					result="Employee ID already in database";
		return result;				
	}
	private String validateFirstName (String name) {
		String result="";
		if (!stringSize(name,1,45))
			result= "Your First Name must between 1 and 45 digits";
		else
			if (Character.isLowerCase(name.charAt(0)))
				result="Your First Name must start with a capital letter";
		return result;
	}
	
	private String validateLastName (String surname) {
		String result="";
		if (!stringSize(surname,1,45))
			result= "Your Last Name must between 1 and 45 digits";
		else
			if (Character.isLowerCase(surname.charAt(0)))
				result="Your Last Name must start with a capital letter";
		return result;
	}

	private String validateBadgeNo (String badge) {
		String result="";
		if (!stringSize(badge,3,5))
			result= "Your Badge Number must between 3 and 5 digits";
		else
			if (!isTextAnInteger(badge))
				result="Your Badge number must be a number";
		return result;
	}
	
	private boolean stringSize(String string, int min, int max) {
		return string.length()>=min && string.length()<=max;
	}
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}
}