package mac_repair.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class UserTest
{
    
    User u;
    UserErrorMsgs uem;
    
    @Before
    public void setUp() throws Exception
    {
        u = new User();
        uem = new UserErrorMsgs();
    }
    
    @Test
    @FileParameters("test/User_test_cases.csv")
    public void test(
            int tNo,
            String username,
            String id,
            String firstName,
            String lastName,
            String password,
            String address,
            String city,
            String zip,
            String phone,
            String email,
            String errorMsg,
            String usernameError,
            String idError,
            String firstNameError,
            String lastNameError,
            String passwordError,
            String addressError,
            String cityError,
            String zipError,
            String phoneError,
            String emailError)
    {
        u.setUser(username, id, firstName, lastName, password, "U", address, "TX", city, zip, phone, email);
        u.validateUser(u, uem);
        
        Assert.assertFalse(u.getRole().isEmpty());
        Assert.assertFalse(u.getState().isEmpty());
        
        Assert.assertTrue(errorMsg.equals(uem.getErrorMsg()));
        Assert.assertTrue(usernameError.equals(uem.getUsernameError()));
        Assert.assertTrue(idError.equals(uem.getIdError()));
        Assert.assertTrue(firstNameError.equals(uem.getFirstNameError()));
        Assert.assertTrue(lastNameError.equals(uem.getLastNameError()));
        Assert.assertTrue(passwordError.equals(uem.getPasswordError()));
        Assert.assertTrue(addressError.equals(uem.getAddressError()));
        Assert.assertTrue(cityError.equals(uem.getCityError()));
        Assert.assertTrue(zipError.equals(uem.getZipError()));
        Assert.assertTrue(phoneError.equals(uem.getPhoneError()));
        Assert.assertTrue(emailError.equals(uem.getEmailError()));
    }
    
}
