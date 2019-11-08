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
    @FileParameters("test/mac_repair/model/User_test_cases.csv")
    public void test(
            int tNo,
            String username,
            boolean checkUnique,
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
        u.setUser(username,
                id,
                firstName,
                lastName,
                password,
                role,
                address,
                city,
                state,
                zip,
                phone,
                email);
        Assert.assertTrue(u.getRole().equals(role));
        Assert.assertTrue(u.getState().equals(state));
        
//         System.out.println(tNo);
//         System.out.println("E: " + errorMsg);
//         System.out.println("E: " + usernameError);
//         System.out.println("A: " + uem.getErrorMsg());
//         System.out.println("A: " + uem.getUsernameError());
        
        u.validateUser(u, uem, checkUnique);
        
        Assert.assertTrue(errorMsg.equals(uem.getErrorMsg()));
        Assert.assertTrue(usernameError.equals(uem.getUsernameError()));
        Assert.assertTrue(idError.equals(uem.getIdError()));
        Assert.assertTrue(firstNameError.equals(uem.getFirstnameError()));
        Assert.assertTrue(lastNameError.equals(uem.getLastnameError()));
        Assert.assertTrue(passwordError.equals(uem.getPasswordError()));
        Assert.assertTrue(addressError.equals(uem.getAddressError()));
        Assert.assertTrue(cityError.equals(uem.getCityError()));
        Assert.assertTrue(zipError.equals(uem.getZipError()));
        Assert.assertTrue(phoneError.equals(uem.getPhoneError()));
        Assert.assertTrue(emailError.equals(uem.getEmailError()));
    }
    
}
