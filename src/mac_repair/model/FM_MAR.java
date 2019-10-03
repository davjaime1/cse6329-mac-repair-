package mac_repair.model;

import java.io.Serializable;


public class FM_MAR implements Serializable
{
    
    private static final long serialVersionUID = 3L;
    private String marID;
    private String facilityName;
    private String facilityType;
    private String urgency;
    private String description;
    private String reportedUser;
    private String date;
    
    public void setMAR(String marID, String facilityName, String facilityType, String urgency, String description, String reportedUser, String date)
    {
        setMarID(marID);
        setFacilityName(facilityName);
        setFacilityType(facilityType);
        setUrgency(urgency);
        setDescription(description);
        setReportedUser(reportedUser);
        setDate(date);
    }
    
    
    public String getMarID()
    {
        return marID;
    }
    
    public void setMarID(String marID)
    {
        this.marID = marID;
    }
    
    public String getFacilityName()
    {
        return facilityName;
    }
    
    public void setFacilityName(String facilityName)
    {
        this.facilityName = facilityName;
    }
    
    public String getFacilityType()
    {
        return facilityType;
    }
    
    public void setFacilityType(String facilityType)
    {
        this.facilityType = facilityType;
    }
    
    public String getUrgency()
    {
        return urgency;
    }
    
    public void setUrgency(String urgency)
    {
        this.urgency = urgency;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public String getReportedUser()
    {
        return reportedUser;
    }
    
    public void setReportedUser(String reportedUser)
    {
        this.reportedUser = reportedUser;
    }
    
    
    public String getDate()
    {
        return date;
    }
    
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public void validateMAR(String action, FM_MARErrorMsgs errorMsgs)
    {
        if (action.equals("saveMAR"))
        {
            errorMsgs.setMarNumberError(validateMARNumber(this.getMarID()));
            errorMsgs.setFacilityNameError(validateFacilityName(this.getFacilityName()));
            errorMsgs.setFacilityTypeError(validateFacilityType(this.getFacilityType()));
            errorMsgs.setErrorMsg();
        }
        else if (action.equals("searchMAR"))
        {
            if (this.marID.equals("") && this.facilityName.equals(""))
                errorMsgs.setMarNumberError("Both MAR Number and Facility Name cannot be blank");
            
            errorMsgs.setErrorMsg();
        }
        
    }
    
    
    private String validateMARNumber(String marNumber)
    {
        String result = "";
        if (!stringSize(marNumber, 3, 16))
            result = "Your MAR Number must between 3 and 16 character";
        // else
        // if (!isTextAnInteger(marNumber))
        // result="Your Employee ID must be a number";
        // else
        // if (!EmployeeDAO.uniqueEmpID(marNumber))
        // result="Employee ID already in database";
        return result;
    }
    
    private String validateFacilityName(String name)
    {
        String result = "";
        if (!stringSize(name, 1, 45))
            result = "Your Facility Name must between 1 and 45 character";
        // else
        // if (Character.isLowerCase(name.charAt(0)))
        // result="Your First Name must start with a capital letter";
        return result;
    }
    
    private String validateFacilityType(String surname)
    {
        String result = "";
        if (!stringSize(surname, 1, 45))
            result = "Your Facility Type must between 1 and 45 character";
        // else
        // if (Character.isLowerCase(surname.charAt(0)))
        // result="Your Last Name must start with a capital letter";
        return result;
    }
    
    // private String validateBadgeNo (String badge) {
    // String result="";
    // if (!stringSize(badge,3,5))
    // result= "Your Badge Number must between 3 and 5 digits";
    // else
    // if (!isTextAnInteger(badge))
    // result="Your Badge number must be a number";
    // return result;
    // }
    //
    private boolean stringSize(String string, int min, int max)
    {
        return string.length() >= min && string.length() <= max;
    }
    // private boolean isTextAnInteger (String string) {
    // boolean result;
    // try
    // {
    // Long.parseLong(string);
    // result=true;
    // }
    // catch (NumberFormatException e)
    // {
    // result=false;
    // }
    // return result;
    // }
}