package mac_repair;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//@SuppressWarnings("unused")
public class MRFunctions
{
    
    private SnapshotFunction snap = new SnapshotFunction();
    public WebDriver driver;
    public Properties prop;
    
    public WebDriver invokeCorrectBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "D:/Program Files/ChromeDriver/chromedriver.exe");
        return new ChromeDriver();
    }
    
    public void takeScreenShot(WebDriver driver, String snapShotName)
    {
        snap.takeScreenshot(driver, snapShotName);
    }
    
    public void sleepyTime()
    {
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
        }
    }
    
    public void MR_Login(WebDriver driver, String sUserName, String sPassword)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Txt_Login_Username"))));
        
        // Provide user name.
        driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);
        
        // Provide Password.
        driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);
        
        // Click on Login button.
        driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login"))).click();
        
        sleepyTime();
        // We will put the verification of the Welcome message in the JUnit test file instead of here
    }
    
    public void MR_Register(WebDriver driver, String username, String utaID, String first, String last, String password,
            String address, String city, String zip, String state, String phone, String email, String role)
    {
        driver.findElement(By.xpath(prop.getProperty("Lnk_Login_Register"))).click();
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Username"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Username"))).sendKeys(username);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_UTAID"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_UTAID"))).sendKeys(utaID);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_FirstName"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_FirstName"))).sendKeys(first);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_LastName"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_LastName"))).sendKeys(last);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Password"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Password"))).sendKeys(password);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Address"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Address"))).sendKeys(address);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_City"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_City"))).sendKeys(city);
        
        Select statedrop = new Select(driver.findElement(By.xpath(prop.getProperty("Txt_Register_State"))));
        statedrop.selectByValue(state);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Zip"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Zip"))).sendKeys(zip);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Phone"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Phone"))).sendKeys(phone);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Email"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Email"))).sendKeys(email);
        
        Select roledrop = new Select(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Role"))));
        roledrop.selectByValue(role);
        
        driver.findElement(By.xpath(prop.getProperty("Btn_Register_Register"))).click();
        sleepyTime();
    }
    
    
    /**
     * This function acts exactly like MR_Register, but does not click
     * the register button at the end.
     */
    public void MR_Register_No_Click(WebDriver driver,
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
            String role)
    {
        driver.findElement(By.xpath(prop.getProperty("Lnk_Login_Register"))).click();
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Username"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Username"))).sendKeys(username);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_UTAID"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_UTAID"))).sendKeys(utaID);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_FirstName"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_FirstName"))).sendKeys(first);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_LastName"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_LastName"))).sendKeys(last);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Password"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Password"))).sendKeys(password);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Address"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Address"))).sendKeys(address);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_City"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_City"))).sendKeys(city);
        
        Select statedrop = new Select(driver.findElement(By.xpath(prop.getProperty("Txt_Register_State"))));
        statedrop.selectByValue(state);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Zip"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Zip"))).sendKeys(zip);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Phone"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Phone"))).sendKeys(phone);
        
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Email"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_Register_Email"))).sendKeys(email);
        
        Select roledrop = new Select(driver.findElement(By.xpath(prop.getProperty("Txt_Register_Role"))));
        roledrop.selectByValue(role);
    }
    
    /**
     * Simple function that clicks the register button.
     */
    public void MR_Register_Click_Register_Button()
    {
        driver.findElement(By.xpath(prop.getProperty("Btn_Register_Register"))).click();
        sleepyTime();
    }
    
    
    public void MR_CreateMar(
            String facility,
            String urgency,
            String description)
    {
        // Go to create mar page.
        driver.findElement(By.xpath(prop.getProperty("Lnk_User_CreateMAR"))).click();
        
        // Enter in MAR info.
        new Select(driver.findElement(By.xpath(prop.getProperty("Sel_CreateMar_Facility")))).selectByValue(facility);
        new Select(driver.findElement(By.xpath(prop.getProperty("Sel_CreateMar_Urgency")))).selectByValue(urgency);
        driver.findElement(By.xpath(prop.getProperty("Txt_CreateMar_Description"))).sendKeys(description);
        
        // Press the submit button.
        sleepyTime();
        driver.findElement(By.xpath(prop.getProperty("Btn_CreateMar_Submit"))).click();
    }
    
    
    public void MR_UserUpdateProfile(WebDriver driver,
            String first,
            String last,
            String password,
            String address,
            String city,
            String zip,
            String state,
            String phone,
            String email)
    {
        // Go to update page
        driver.findElement(By.xpath(prop.getProperty("Lnk_User_UpdateProfile"))).click();
        
        // Enter in the test data
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Firstname"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Firstname"))).sendKeys(first);
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Lastname"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Lastname"))).sendKeys(last);
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Password"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Password"))).sendKeys(password);
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Address"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Address"))).sendKeys(address);
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_City"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_City"))).sendKeys(city);
        new Select(driver.findElement(By.xpath(prop.getProperty("Sel_UserUpdate_State")))).selectByValue(state);
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Zip"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Zip"))).sendKeys(zip);
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Phone"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Phone"))).sendKeys(phone);
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Email"))).clear();
        driver.findElement(By.xpath(prop.getProperty("Txt_UserUpdate_Email"))).sendKeys(email);
        
        // Press the submit button
        driver.findElement(By.xpath(prop.getProperty("Btn_UserUpdate_Submit"))).click();
        sleepyTime();
    }
    
    
    public void Repairer_View_Assigned(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_ViewAssignedRepairs"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_ViewAssignedRepairs"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_Repairer_ViewAssignedRepairs"))));
        // Click on the View Assigned Repairs Link
        // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page_loader")));
        driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_ViewAssignedRepairs"))).click();
        sleepyTime();
    }
    
    public void Repairer_View_Specific_Assigned(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewAssigned_ViewSpecific"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewAssigned_ViewSpecific"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_ViewAssigned_ViewSpecific"))));
        driver.findElement(By.xpath(prop.getProperty("Lnk_ViewAssigned_ViewSpecific"))).click();
        sleepyTime();
    }
    
    public void Repairer_Homepage(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewSpecificAssigned_Homepage"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewSpecificAssigned_Homepage"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_ViewSpecificAssigned_Homepage"))));
        driver.findElement(By.xpath(prop.getProperty("Lnk_ViewSpecificAssigned_Homepage"))).click();
        sleepyTime();
    }
    
    public void Repairer_Logout(WebDriver driver)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_Logout"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_Logout"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_Repairer_Logout"))));
        driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_Logout"))).click();
        sleepyTime();
    }
    
    public void Repairer_ViewMakeReservation(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Btn_ViewSpecificAssigned_MakeReservation"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Btn_ViewSpecificAssigned_MakeReservation"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Btn_ViewSpecificAssigned_MakeReservation"))));
        driver.findElement(By.xpath(prop.getProperty("Btn_ViewSpecificAssigned_MakeReservation"))).click();
        sleepyTime();
    }
    
    public void Repairer_MakeReservation(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Rad_MakeReservation_Index1"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Rad_MakeReservation_Index1"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Rad_MakeReservation_Index1"))));
        driver.findElement(By.xpath(prop.getProperty("Rad_MakeReservation_Index1"))).click();
  	    driver.findElement(By.xpath(prop.getProperty("Btn_MakeReservation_Submit"))).click();
        sleepyTime();
    }
    
    public void Repairer_ViewReserved(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_ViewReservedRepairs"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_ViewReservedRepairs"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_Repairer_ViewReservedRepairs"))));
        driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_ViewReservedRepairs"))).click();
        sleepyTime();
    }
    
    public void Repairer_ViewSpecificReserved(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewReserved_ViewSpecificReservation"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewReserved_ViewSpecificReservation"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_ViewReserved_ViewSpecificReservation"))));
        driver.findElement(By.xpath(prop.getProperty("Lnk_ViewReserved_ViewSpecificReservation"))).click();
        sleepyTime();
    }
    
    public void Repairer_ViewModifyReservation(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Btn_ViewSpecificReserved_Modify"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Btn_ViewSpecificReserved_Modify"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Btn_ViewSpecificReserved_Modify"))));
        driver.findElement(By.xpath(prop.getProperty("Btn_ViewSpecificReserved_Modify"))).click();
        sleepyTime();
    }
    
    public void Repairer_ModifyReservation(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Rad_ModifyReservation_Select"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Rad_ModifyReservation_Select"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Rad_ModifyReservation_Select"))));
        driver.findElement(By.xpath(prop.getProperty("Rad_ModifyReservation_Select"))).click();
        driver.findElement(By.xpath(prop.getProperty("Btn_ModifyReservation_Submit"))).click();
        sleepyTime();
    }
    
    public void Repairer_CancelReservation(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Btn_ViewSpecificReserved_Cancel"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Btn_ViewSpecificReserved_Cancel"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Btn_ViewSpecificReserved_Cancel"))));
        driver.findElement(By.xpath(prop.getProperty("Btn_ViewSpecificReserved_Cancel"))).click();
        sleepyTime();
    }
    
    public void Repairer_RadioSubmit(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Rad_MakeReservation_Index1"))));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Rad_MakeReservation_Index1"))));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Rad_MakeReservation_Index1"))));
  	    driver.findElement(By.xpath(prop.getProperty("Btn_MakeReservation_Submit"))).click();
        sleepyTime();
    }
    
    /**
     * Helper function to deal with logging out from different pages.
     */
    public void MR_Logout(LogOutFlag flag)
    {
        if (flag == LogOutFlag.USER_HOME)
        {
            driver.findElement(By.xpath(prop.getProperty("Lnk_User_Logout")));
        }
        else if (flag == LogOutFlag.USER_CREATE_MAR)
        {
            driver.findElement(By.xpath(prop.getProperty("Lnk_CreateMar_Home"))).click();
            driver.findElement(By.xpath(prop.getProperty("Lnk_User_Logout"))).click();
        }
        else if (flag == LogOutFlag.USER_MAR_DETAILS)
        {
            driver.findElement(By.xpath(prop.getProperty("Lnk_MarDetails_Home"))).click();
            driver.findElement(By.xpath(prop.getProperty("Lnk_User_Logout"))).click();
        }
        else if (flag == LogOutFlag.USER_UPDATE)
        {
            driver.findElement(By.xpath(prop.getProperty("Lnk_UserUpdate_Home"))).click();
            sleepyTime();
            driver.findElement(By.xpath(prop.getProperty("Lnk_User_Logout"))).click();
            sleepyTime();
        }
        else if (flag == LogOutFlag.VIEW_PROFILE)
        {
            driver.findElement(By.xpath(prop.getProperty("Lnk_ViewProfile_Home"))).click();
            sleepyTime();
            driver.findElement(By.xpath(prop.getProperty("Lnk_User_Logout"))).click();
            sleepyTime();
        }
        else if (flag == LogOutFlag.REGISTRATION)
        {
            driver.findElement(By.xpath(prop.getProperty("Lnk_Register_BackToLogin"))).click();
        }
    }
}
