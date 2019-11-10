package mac_repair;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//@SuppressWarnings("unused")
public class FMFunctions {
	
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

	public void MR_ListMAR (WebDriver driver)
	{
	
	 	driver.findElement(By.xpath(prop.getProperty("Txt_UnassignedMAR_List"))).click();

//		try
//		{
////			  Change the delay value to 1_000 to insert a 1 second delay after 
////			  each screenshot
//			  Thread.sleep(0);
//		} catch (InterruptedException e) {}
		// We will put the verification of the Welcome message in the JUnit test file instead of here
	}
	
	public void MR_AssignMAR(WebDriver driver, String description, String assignedTo, String assignedDate)
	{
	 	driver.findElement(By.xpath(prop.getProperty("Txt_UnassignedMAR_List"))).click();

	 	driver.findElement(By.xpath(prop.getProperty("Txt_Select_MAR_ID"))).click();
	 	driver.findElement(By.xpath(prop.getProperty("Txt_MAR_View_Button"))).click();

	 	
	 	driver.findElement(By.name(prop.getProperty("Txt_MAR_Description"))).click();
	 	driver.findElement(By.name(prop.getProperty("Txt_MAR_Description"))).clear();
	 	driver.findElement(By.name(prop.getProperty("Txt_MAR_Description"))).sendKeys(description);

	 	
	 	driver.findElement(By.name(prop.getProperty("Txt_MAR_AssignedTo"))).click();
	    new Select(driver.findElement(By.name(prop.getProperty("Txt_MAR_AssignedTo")))).selectByVisibleText(assignedTo);
	 	driver.findElement(By.name(prop.getProperty("Txt_MAR_AssignedTo"))).click();

	    driver.findElement(By.id(prop.getProperty("Txt_MAR_DateTime"))).click();
	    int getDate = Integer.parseInt(assignedDate.split("-")[2]);
	    
	    driver.findElement(By.linkText(Integer.toString(getDate))).click();
	    driver.findElement(By.id(prop.getProperty("Txt_MAR_DateTime"))).click();
	 	driver.findElement(By.xpath(prop.getProperty("Txt_AssignMAR_Button"))).click();

	    
	}
	
	
	
	public void MR_Search_MAR (WebDriver driver, String facilityName, String marID)
	{
		 	driver.findElement(By.xpath(prop.getProperty("Txt_UnassignedMAR_Search"))).click();
		    driver.findElement(By.name(prop.getProperty("Txt_Search_Facility"))).click();
		    driver.findElement(By.name(prop.getProperty("Txt_Search_Facility"))).clear();
		    driver.findElement(By.name(prop.getProperty("Txt_Search_Facility"))).sendKeys(facilityName);
		    

		    driver.findElement(By.name(prop.getProperty("Txt_Search_MAR_Number"))).click();
		    driver.findElement(By.name(prop.getProperty("Txt_Search_MAR_Number"))).clear();
		    driver.findElement(By.name(prop.getProperty("Txt_Search_MAR_Number"))).sendKeys(marID);
		    
		    driver.findElement(By.xpath(prop.getProperty("Txt_Search_Button"))).click();

		    
		 
	}
}