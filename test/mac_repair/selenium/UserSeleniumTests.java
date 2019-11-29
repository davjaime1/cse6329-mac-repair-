package mac_repair.selenium;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import mac_repair.LogOutFlag;
import mac_repair.MRFunctions;
import mac_repair.util.SQLConnection;


@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserSeleniumTests extends MRFunctions
{
    static SQLConnection DBMgr = SQLConnection.getInstance();
    private StringBuffer verificationErrors = new StringBuffer();
    public String sAppURL, sSharedUIMapPath, testDelay;
    
    /**
     * Helper function for naming snapshots.
     */
    private void snapshot(String methodName, int tNo)
    {
        takeScreenShot(driver, UserSeleniumTests.class.getSimpleName() + "_" + methodName + "_" + tNo);
    }
    
    @Before
    public void setUp() throws Exception
    {
        driver = invokeCorrectBrowser();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        prop = new Properties();
        prop.load(new FileInputStream("./Configuration/MR_Configuration.properties"));
        sAppURL = prop.getProperty("sAppURL");
        sSharedUIMapPath = prop.getProperty("SharedUIMap");
        testDelay = prop.getProperty("testDelay");
        prop.load(new FileInputStream(sSharedUIMapPath));
    }
    
    /**
     * Testing registration and validataion of a user.
     */
    @Test
    @FileParameters("test/mac_repair/selenium/UserTC01TestCases.csv")
    public void userTC01(
            int tNo,
            String username,
            String utaID,
            String first,
            String last,
            String password,
            String address,
            String city,
            String zip,
            String state,
            String phone,
            String email,
            String role,
            String fieldError,
            String usernameError,
            String idError,
            String firstnameError,
            String lastnameError,
            String passwordError,
            String addressError,
            String cityError,
            String zipError,
            String phoneError,
            String emailError) throws Exception
    {
        // Go to web page.
        driver.get(sAppURL);
        
        // Attempt registration.
        MR_Register_No_Click(driver,
                username,
                utaID,
                first,
                last,
                password,
                address,
                city,
                zip,
                state,
                phone,
                email,
                role);
        
        // BEFORE clicking register, make sure that the dropdown boxes are selected correctly.
        assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_State"))).getAttribute("value").equals(state));
        assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Role"))).getAttribute("value").equals(role));
        
        // Click register button.
        sleepyTime();
        MR_Register_Click_Register_Button();
        
        /* Verify error messages.
         * Only check errors if the page is still register. The last test case
         * takes us back to the login due to a successful registration and breaks this test. */
        if (driver.getTitle().equals("Register"))
        {
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_Fields"))).getText().equalsIgnoreCase(fieldError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_Username"))).getText().equalsIgnoreCase(usernameError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_ID"))).getText().equalsIgnoreCase(idError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_Firstname"))).getText().equalsIgnoreCase(firstnameError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_Lastname"))).getText().equalsIgnoreCase(lastnameError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_Password"))).getText().equalsIgnoreCase(passwordError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_Address"))).getText().equalsIgnoreCase(addressError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_City"))).getText().equalsIgnoreCase(cityError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_Zip"))).getText().equalsIgnoreCase(zipError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_Phone"))).getText().equalsIgnoreCase(phoneError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Error_Email"))).getText().equalsIgnoreCase(emailError));
            
            // Snapshot the expected results.
            snapshot(new Throwable().getStackTrace()[0].getMethodName(), tNo);
            
            MR_Logout(LogOutFlag.REGISTRATION);
        }
        else
        {
            // A good registration will go to back to the login.
            // Snapshot the expected results.
            snapshot(new Throwable().getStackTrace()[0].getMethodName(), tNo);
        }
        
        sleepyTime();
    }
    
    /**
     * Testing the login and validation of a user.
     */
    @Test
    @FileParameters("test/mac_repair/selenium/UserTC02TestCases.csv")
    public void userTC02(
            int tNo,
            String username,
            String password,
            String loginError) throws Exception
    {
        // Go to web page.
        driver.get(sAppURL);
        
        // Attempt login.
        MR_Login(driver, username, password);
        
        // Verifying errors.
        if (driver.getTitle().equals("Login"))
        {
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Login_BadCreditenials"))).getText().equalsIgnoreCase(loginError));
            
            // Snapshot the expected results.
            snapshot(new Throwable().getStackTrace()[0].getMethodName(), tNo);
        }
        else
        {
            // Snapshot the expected results.
            snapshot(new Throwable().getStackTrace()[0].getMethodName(), tNo);
            
            // On a good login, we get into the user home page.
            MR_Logout(LogOutFlag.USER_HOME);
        }
        
        sleepyTime();
    }
    
    /**
     * Creating a MAR, show validations, and logging out.
     */
    @Test
    @FileParameters("test/mac_repair/selenium/UserTC03TestCases.csv")
    public void userTC03(
            int tNo,
            String username,
            String password,
            String facility,
            String urgency,
            String description,
            String errorMsg,
            String facilityType)
    {
        // Go to web page.
        driver.get(sAppURL);
        
        // Login.
        MR_Login(driver, username, password);
        
        // Create a MAR.
        MR_CreateMar(facility, urgency, description);
        
        
        if (driver.getTitle().equals("Create MAR"))
        {
            // If an error occurred.
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_CreateMar_Error"))).getText().equals(errorMsg));
            
            // Snapshot the expected results.
            snapshot(new Throwable().getStackTrace()[0].getMethodName(), tNo);
            
            // Logout.
            sleepyTime();
            MR_Logout(LogOutFlag.USER_CREATE_MAR);
        }
        else
        {
            // No errors, we have proceeded to the results pages.
            // Verify the table data.
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_MarDetails_Date"))).getText().equals(
                    LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_MarDetails_FacilityType"))).getText().equals(facilityType));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_MarDetails_FacilityName"))).getText().equals(facility));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_MarDetails_Urgency"))).getText().equals(urgency));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_MarDetails_ReportedBy"))).getText().equals(username));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_MarDetails_Description"))).getText().equals(description));
            
            // Snapshot the expected results.
            snapshot(new Throwable().getStackTrace()[0].getMethodName(), tNo);
            
            // Logout.
            sleepyTime();
            MR_Logout(LogOutFlag.USER_MAR_DETAILS);
        }
    }
    
    /**
     * Login and update the user profile.
     */
    @Test
    @FileParameters("test/mac_repair/selenium/UserTC04TestCases.csv")
    public void userTC04(
            int tNo,
            String loginUser,
            String loginPass,
            String first,
            String last,
            String password,
            String address,
            String city,
            String zip,
            String state,
            String phone,
            String email,
            String fieldError,
            String firstnameError,
            String lastnameError,
            String passwordError,
            String addressError,
            String cityError,
            String zipError,
            String phoneError,
            String emailError)
    {
        // Go to web page.
        driver.get(sAppURL);
        
        // Login
        MR_Login(driver, loginUser, loginPass);
        sleepyTime();
        
        // Update Profile
        MR_UserUpdateProfile(driver,
                first,
                last,
                password,
                address,
                city,
                zip,
                state,
                phone,
                email);
        
        // Snapshot the results.
        snapshot(new Throwable().getStackTrace()[0].getMethodName(), tNo);
        
        // Check the current page and verify the information accordingly.
        if (driver.getTitle().equals("Update Profile"))
        {
            // This means we have an error during update. Verify the
            // error messages.
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Error_Fields"))).getText().equalsIgnoreCase(fieldError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Error_Firstname"))).getText().equalsIgnoreCase(firstnameError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Error_Lastname"))).getText().equalsIgnoreCase(lastnameError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Error_Password"))).getText().equalsIgnoreCase(passwordError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Error_Address"))).getText().equalsIgnoreCase(addressError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Error_City"))).getText().equalsIgnoreCase(cityError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Error_Zip"))).getText().equalsIgnoreCase(zipError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Error_Phone"))).getText().equalsIgnoreCase(phoneError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Error_Email"))).getText().equalsIgnoreCase(emailError));
            
            MR_Logout(LogOutFlag.USER_UPDATE);
        }
        else
        {
            // On a successful update, the view profile page should be shown.
            // Verify the table info matches the input.
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_ViewProfile_Firstname"))).getText().equalsIgnoreCase(first));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_ViewProfile_Lastname"))).getText().equalsIgnoreCase(last));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_ViewProfile_Password"))).getText().equalsIgnoreCase(password));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_ViewProfile_Address"))).getText().equalsIgnoreCase(address));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_ViewProfile_City"))).getText().equalsIgnoreCase(city));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_ViewProfile_State"))).getText().equalsIgnoreCase(state));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_ViewProfile_Zip"))).getText().equalsIgnoreCase(zip));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_ViewProfile_Phone"))).getText().equalsIgnoreCase(phone));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_ViewProfile_Email"))).getText().equalsIgnoreCase(email));
            
            MR_Logout(LogOutFlag.VIEW_PROFILE);
        }
    }
    
    /**
     * Other needed tests to get full coverage for user controller.
     * 
     * @param tNo
     * @param loginUser
     * @param loginPass
     */
    @Test
    @FileParameters("test/mac_repair/selenium/UserTC05TestCases.csv")
    public void userTC05(
            int tNo,
            String loginUser,
            String loginPass)
    {
        // Go to web page.
        driver.get(sAppURL);
        
        // Login
        MR_Login(driver, loginUser, loginPass);
        sleepyTime();
        
        // View the user profile and take snapshot.
        MR_ViewUserProfile();
        snapshot(new Throwable().getStackTrace()[0].getMethodName(), tNo);
        
        // Verify on correct page.
        assertTrue(driver.getTitle().equals("View Profile"));
        
        // Logout
        MR_Logout(LogOutFlag.VIEW_PROFILE);
    }
    
    
    @After
    public void tearDown() throws Exception
    {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString))
        {
            fail(verificationErrorString);
        }
    }
}
