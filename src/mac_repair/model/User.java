package mac_repair.model;

import java.io.Serializable;

import mac_repair.data.UserDAO;

public class User implements Serializable
{
    private static final long serialVersionUID = -4594567443904550524L;
    
    private String username;
    private String id;
    private String firstname;
    private String lastname;
    private String password;
    private String role;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    
    
    public void setUser(
            String username,
            String utaId,
            String firstName,
            String lastName,
            String password,
            String role,
            String address,
            String state,
            String city,
            String zip,
            String phone,
            String email)
    {
        setUsername(username);
        setId(utaId);
        setFirstName(firstName);
        setLastName(lastName);
        setPassword(password);
        setRole(role);
        setAddress(address);
        setState(state);
        setCity(city);
        setZip(zip);
        setPhone(phone);
        setEmail(email);
    }
    
    
    public void validateUser(String action, UserErrorMsgs errorMsgs)
    {
        if (action.contains("updateProfile"))
        {
            errorMsgs.setFirstnameError(validateFirstName(this.getFirstName()));
            errorMsgs.setLastnameError(validateLastName(this.getLastName()));
            errorMsgs.setPasswordError(validatePassword(this.getPassword()));
            errorMsgs.setAddressError(validateAddress(this.getAddress()));
            errorMsgs.setCityError(validateCity(this.getCity()));
            errorMsgs.setZipError(validateZip(this.getZip()));
            errorMsgs.setPhoneError(validatePhone(this.getPhone()));
            errorMsgs.setEmailError(validateEmail(this.getEmail()));
            errorMsgs.setErrorMsg(action);
        }
        else
        {
            errorMsgs.setUserNameError(validateUsername(action, this.getUsername()));
            errorMsgs.setUtaidError(validateUtaId(this.getId()));
            errorMsgs.setFirstnameError(validateFirstName(this.getFirstName()));
            errorMsgs.setLastnameError(validateLastName(this.getLastName()));
            errorMsgs.setPasswordError(validatePassword(this.getPassword()));
            errorMsgs.setAddressError(validateAddress(this.getAddress()));
            errorMsgs.setCityError(validateCity(this.getCity()));
            errorMsgs.setZipError(validateZip(this.getZip()));
            errorMsgs.setPhoneError(validatePhone(this.getPhone()));
            errorMsgs.setEmailError(validateEmail(this.getEmail()));
            errorMsgs.setErrorMsg(action);
        }
    }
    
    public void validateLogin(String action, String pssd, UserErrorMsgs errorMsgs)
    {
        errorMsgs.setPasswordError(matchPassword(pssd));
        errorMsgs.setErrorMsg(action);
    }
    
    private String matchPassword(String psswd)
    {
        String result = "";
        if (!password.equals(psswd))
        {
            
            result = "Incorrect password";
        }
        else if (password == null || password.equals(""))
        {
            result = "Password is empty";
        }
        return result;
    }
    
    private String validateUsername(String action, String username)
    {
        String result = "";
        if (username == null || username.equals("") && action.contains("registerUser"))
        {
            result = "Username is empty";
        }
        else if (!UserDAO.userNameunique(username) && action.contains("registerUser"))
        {
            result = "Username already exists";
        }
        else if (username == null || username.equals(""))
        {
            result = "No user Found";
        }
        
        return result;
    }
    
    
    private String validateUtaId(String utaId)
    {
        String regex = "\\d{10}";
        String result = "";
        if (!utaId.equals("") && utaId.matches(regex))
        {
            
            result = "";
        }
        else
        {
            result = "Incorrect UTA ID";
        }
        return result;
    }
    
    private String validateFirstName(String firstName)
    {
        String result = "";
        String regex = "^[a-zA-Z]*$";
        if (!firstName.equals("") && firstName.matches(regex))
        {
            // result="Valid FirstName";
            result = "";
        }
        else
        {
            result = "Invalid LastName";
        }
        return result;
    }
    
    private String validateLastName(String lastName)
    {
        String result = "";
        String regex = "^[a-zA-Z]*$";
        if (!lastName.equals("") && lastName.matches(regex))
        {
            result = "";
        }
        else
        {
            result = "Invalid LastName";
        }
        return result;
    }
    
    private String validatePassword(String password)
    {
        String result = "";
        if (!password.equals("") && password.length() > 6)
        {
            result = "";
        }
        else
        {
            result = "Invalid Password";
        }
        return result;
    }
    
    private String validateAddress(String address)
    {
        String result = "";
        if (address == null || username.equals(""))
        {
            result = "Address is empty";
        }
        return result;
    }
    
    
    private String validateCity(String city)
    {
        String result = "";
        String regex = "^[a-zA-Z]*$";
        if (!city.equals("") && city.matches(regex))
        {
            result = "";
        }
        else
        {
            result = "Invalid City Name";
        }
        return result;
    }
    
    private String validateZip(String zip)
    {
        String result = "";
        String regex = "\\d{5}";
        if (!zip.equals("") && zip.matches(regex))
        {
            result = "";
        }
        else
        {
            result = "Invalid Zip";
        }
        return result;
    }
    
    private String validatePhone(String phone)
    {
        String result = "";
        String regex = "\\d{10}";
        if (!phone.equals("") && phone.matches(regex))
        {
            result = "";
        }
        else
        {
            result = "Invalid Phone";
        }
        return result;
    }
    
    private String validateEmail(String email)
    {
        String result = "";
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!email.equals("") && email.matches(regex) && email.contains("uta.edu"))
        {
            result = "";
        }
        else
        {
            result = "Invalid Email";
        }
        return result;
    }
    
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public void setFirstName(String s)
    {
        firstname = s;
    }
    
    public String getFirstName()
    {
        return firstname;
    }
    
    public void setLastName(String s)
    {
        lastname = s;
    }
    
    public String getLastName()
    {
        return lastname;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setRole(String s)
    {
        role = s;
    }
    
    public String getRole()
    {
        return role;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public String getCity()
    {
        return city;
    }
    
    public void setCity(String city)
    {
        this.city = city;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public String getZip()
    {
        return zip;
    }
    
    public void setZip(String zip)
    {
        this.zip = zip;
    }
    
    public String getPhone()
    {
        return phone;
    }
    
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
}
