package mac_repair.model;

import java.io.Serializable;

public class UserErrorMsgs implements Serializable
{
    private static final long serialVersionUID = -433281019234295890L;
    
    
    private String errorMsg;
    private String usernameError;
    private String idError;
    private String firstnameError;
    private String lastnameError;
    private String passwordError;
    private String addressError;
    private String cityError;
    private String zipError;
    private String phoneError;
    private String emailError;
    
    public String getErrorMsg()
    {
        return errorMsg;
    }
    
    public void setErrorMsg()
    {
        if (usernameError.isEmpty()
                && idError.isEmpty()
                && firstnameError.isEmpty()
                && lastnameError.isEmpty()
                && passwordError.isEmpty()
                && addressError.isEmpty()
                && cityError.isEmpty()
                && zipError.isEmpty()
                && phoneError.isEmpty()
                && emailError.isEmpty())
        {
            this.errorMsg = "";
        }
        else
        {
            this.errorMsg = "Fields have errors";
        }
        
    }
    
    public String getIdError()
    {
        return idError;
    }
    
    
    public void setIdError(String utaidError)
    {
        this.idError = utaidError;
    }
    
    
    public String getFirstnameError()
    {
        return firstnameError;
    }
    
    
    public void setFirstnameError(String firstnameError)
    {
        this.firstnameError = firstnameError;
    }
    
    
    public String getLastnameError()
    {
        return lastnameError;
    }
    
    
    public void setLastnameError(String lastnameError)
    {
        this.lastnameError = lastnameError;
    }
    
    
    public String getPasswordError()
    {
        return passwordError;
    }
    
    
    public void setPasswordError(String passwordError)
    {
        this.passwordError = passwordError;
    }
    
    public String getAddressError()
    {
        return addressError;
    }
    
    
    public void setAddressError(String addressError)
    {
        this.addressError = addressError;
    }
    
    public String getCityError()
    {
        return cityError;
    }
    
    
    public void setCityError(String cityError)
    {
        this.cityError = cityError;
    }
    
    
    public String getZipError()
    {
        return zipError;
    }
    
    
    public void setZipError(String zipError)
    {
        this.zipError = zipError;
    }
    
    
    public String getEmailError()
    {
        return emailError;
    }
    
    
    public void setEmailError(String emailError)
    {
        this.emailError = emailError;
    }
    
    
    public String getPhoneError()
    {
        return phoneError;
    }
    
    
    public void setPhoneError(String phoneError)
    {
        this.phoneError = phoneError;
    }
    
    
    public String getUsernameError()
    {
        return usernameError;
    }
    
    
    public void setUsernameError(String userNameError)
    {
        this.usernameError = userNameError;
    }
}