package mac_repair.model;

import java.io.Serializable;

import mac_repair.data.UserDAO;

public class User implements Serializable
{
    private static final long serialVersionUID = 17594123062502750L;
    
    
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
            String id,
            String firstName,
            String lastName,
            String password,
            String role,
            String address,
            String city,
            String state,
            String zip,
            String phone,
            String email)
    {
        setUsername(username);
        setId(id);
        setFirstname(firstName);
        setLastname(lastName);
        setPassword(password);
        setRole(role);
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setPhone(phone);
        setEmail(email);
    }
    
    
    public void validateUser(User u, UserErrorMsgs uem, boolean checkUnique)
    {
        uem.setUsernameError(validateUsername(u.getUsername()));
        if(checkUnique)
            this.validateUsernameUnique(uem);
        
        uem.setIdError(validateId(u.getId()));
        uem.setFirstnameError(validateFirstName(u.getFirstname()));
        uem.setLastnameError(validateLastName(u.getLastname()));
        uem.setPasswordError(validatePassword(u.getPassword()));
        uem.setAddressError(validateAddress(u.getAddress()));
        uem.setCityError(validateCity(u.getCity()));
        uem.setZipError(validateZip(u.getZip()));
        uem.setPhoneError(validatePhone(u.getPhone()));
        uem.setEmailError(validateEmail(u.getEmail()));
        uem.setErrorMsg();
    }
    
    private String validateUsername(String username)
    {
        String result = "Invalid username";
        String regex = "^[a-zA-Z0-9]{3,16}$";
        if (username.matches(regex))
        {
            result = "";
        }
        return result;
    }
    
    private void validateUsernameUnique(UserErrorMsgs uem)
    {
        if(!UserDAO.isUsernameUnique(this.getUsername()))
            uem.setUsernameError("Username already in database");
    }
    
    private String validateId(String id)
    {
        String result = "Incorrect ID";
        String regex = "^[0-9]{10}$";
        if (id.matches(regex))
        {
            result = "";
        }
        return result;
    }
    
    private String validateFirstName(String firstName)
    {
        String result = "Invalid first name";
        String regex = "^[a-zA-Z]{1,45}$";
        if (firstName.matches(regex))
        {
            result = "";
        }
        return result;
    }
    
    private String validateLastName(String lastName)
    {
        String result = "Invalid last name";
        String regex = "^[a-zA-Z]{1,45}$";
        if (lastName.matches(regex))
        {
            result = "";
        }
        return result;
    }
    
    private String validatePassword(String password)
    {
        String result = "Invalid password";
        String regex = "^.{6,120}$";
        if (password.matches(regex))
        {
            result = "";
        }
        return result;
    }
    
    private String validateAddress(String address)
    {
        String result = "Invalid address";
        String regex = "^[a-zA-Z0-9\\s]{1,120}$";
        if (address.matches(regex))
        {
            result = "";
        }
        return result;
    }
    
    private String validateCity(String city)
    {
        String result = "Invalid city";
        String regex = "^[a-zA-Z]{1,45}$";
        if (city.matches(regex))
        {
            result = "";
        }
        return result;
    }
    
    private String validateZip(String zip)
    {
        String result = "Invalid zip";
        String regex = "\\d{5}";
        if (zip.matches(regex))
        {
            result = "";
        }
        return result;
    }
    
    private String validatePhone(String phone)
    {
        String result = "Invalid phone";
        String regex = "\\d{10}";
        if (phone.matches(regex))
        {
            result = "";
        }
        return result;
    }
    
    private String validateEmail(String email)
    {
        String result = "Invalid email";
        String regex = "^([a-zA-z]+[a-zA-Z0-9]*\\.?[a-zA-Z0-9]*)*[a-zA-Z]+\\@uta\\.edu$";
        if (email.length() <= 45 && email.matches(regex))
        {
            result = "";
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
    
    public void setFirstname(String s)
    {
        firstname = s;
    }
    
    public String getFirstname()
    {
        return firstname;
    }
    
    public void setLastname(String s)
    {
        lastname = s;
    }
    
    public String getLastname()
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
