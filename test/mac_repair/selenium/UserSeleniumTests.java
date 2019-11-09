package mac_repair.selenium;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
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
import mac_repair.MRFunctions;
import mac_repair.util.SQLConnection;


@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserSeleniumTests extends MRFunctions
{
    static SQLConnection DBMgr = SQLConnection.getInstance();
    private StringBuffer verificationErrors = new StringBuffer();
    public String sAppURL, sSharedUIMapPath, testDelay;
    
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
        MR_Register_Click_Register_Button();
        
        /* Verify error messages.
         * Only check errors if the page is still register. The last test case
         * takes us back to the login due to a successful registration and breaks this test. */
        if (driver.getTitle().equals("Register"))
        {
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_Fields"))).getText().equalsIgnoreCase(fieldError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_Username"))).getText().equalsIgnoreCase(usernameError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_ID"))).getText().equalsIgnoreCase(idError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_Firstname"))).getText().equalsIgnoreCase(firstnameError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_Lastname"))).getText().equalsIgnoreCase(lastnameError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_Password"))).getText().equalsIgnoreCase(passwordError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_Address"))).getText().equalsIgnoreCase(addressError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_City"))).getText().equalsIgnoreCase(cityError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_Zip"))).getText().equalsIgnoreCase(zipError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_Phone"))).getText().equalsIgnoreCase(phoneError));
            assertTrue(driver.findElement(By.xpath(prop.getProperty("Txt_Error_Email"))).getText().equalsIgnoreCase(emailError));
        }
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
        }
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
