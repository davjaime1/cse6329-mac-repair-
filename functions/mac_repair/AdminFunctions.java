package mac_repair;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//@SuppressWarnings("unused")
public class AdminFunctions {
	
	private SnapshotFunction snap = new SnapshotFunction();
	public WebDriver driver;
	public Properties prop;	  
	public WebDriver invokeCorrectBrowser ()
	{
		System.setProperty("webdriver.chrome.driver", "D:/Program Files/ChromeDriver/chromedriver.exe");
		return new ChromeDriver();
	}

	public void takeScreenShot (WebDriver driver, String snapShotName)
	{
		snap.takeScreenshot(driver, snapShotName);
		try
		{
//			    Change the thread value to run test files with delay
				Thread.sleep(0);
		} catch (InterruptedException e) {}
	}
	
	public void MR_Login (WebDriver driver, String sUserName, String sPassword)
	{
		// Provide user name.
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);

		 // Provide Password.
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);

		 // Click on Login button.
		driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login"))).click();

		try
		{
//			  Change the delay value to 1_000 to insert a 1 second delay after 
//			  each screenshot
			  Thread.sleep(0);
		} catch (InterruptedException e) {}
		// We will put the verification of the Welcome message in the JUnit test file instead of here
	}
	
	public void MR_Register (WebDriver driver, String username, String utaID, String first, String last, String password, 
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
	}

	public void MR_ListAndFilterUser (WebDriver driver, String filterName)
	{
	
	 	driver.findElement(By.xpath(prop.getProperty("Txt_Search_User_Home_Admin"))).click();
	    driver.findElement(By.name(prop.getProperty("Txt_RoleDropDown_Admin"))).click();
	    new Select(driver.findElement(By.name(prop.getProperty("Txt_RoleDropDown_Admin")))).selectByVisibleText(filterName);
	    driver.findElement(By.name(prop.getProperty("Txt_RoleDropDown_Admin"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Txt_Update_User_Admin"))).click();

//		tryTxt_UserList_Submit_Admin
//		{
////			  Change the delay value to 1_000 to insert a 1 second delay after 
////			  each screenshot
//			  Thread.sleep(0);
//		} catch (InterruptedException e) {}
		// We will put the verification of the Welcome message in the JUnit test file instead of here
	}
	
	public void MR_ChangeUserRole(WebDriver driver, String role) throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("Txt_List_User_Home_Admin"))).click();
		driver.findElement(By.xpath(prop.getProperty("Txt_Click_First_User_Admin"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Txt_User_Role_Dropdown_Admin"))).click();
		  Thread.sleep(2000);
	    new Select(driver.findElement(By.xpath(prop.getProperty("Txt_User_Role_Dropdown_Admin")))).selectByVisibleText(role);
		  Thread.sleep(2000);
	    driver.findElement(By.xpath(prop.getProperty("Txt_User_Role_Dropdown_Admin"))).click();
	    driver.findElement(By.xpath(prop.getProperty("Txt_Update_User_Admin"))).click();
	    
	}
	

	
}