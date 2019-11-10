package mac_repair;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//@SuppressWarnings("unused")
public class MRFunctions {
	
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
	}
	
	public void sleepyTime()
	{
		try{ Thread.sleep(1000);}catch (InterruptedException e) {}
	}
	
	public void MR_Login (WebDriver driver, String sUserName, String sPassword)
	{
		WebDriverWait wait = new WebDriverWait(driver , 10);
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
		sleepyTime();
	}
	
	public void Repairer_View_Assigned (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver , 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_ViewAssignedRepairs"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_ViewAssignedRepairs"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_Repairer_ViewAssignedRepairs"))));
		//Click on the View Assigned Repairs Link
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("page_loader")));
		driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_ViewAssignedRepairs"))).click();	
		sleepyTime();
	}
	
	public void Repairer_View_Specific_Assigned (WebDriver driver)
	{
		  WebDriverWait wait = new WebDriverWait(driver , 10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewAssigned_ViewSpecific"))));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewAssigned_ViewSpecific"))));
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_ViewAssigned_ViewSpecific"))));
		  driver.findElement(By.xpath(prop.getProperty("Lnk_ViewAssigned_ViewSpecific"))).click();
		  sleepyTime();
	}
	
	public void Repairer_Homepage (WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver , 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewSpecificAssigned_Homepage"))));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_ViewSpecificAssigned_Homepage"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_ViewSpecificAssigned_Homepage"))));
		driver.findElement(By.xpath(prop.getProperty("Lnk_ViewSpecificAssigned_Homepage"))).click();
		sleepyTime();
	}
	
	public void Repairer_Logout (WebDriver driver)
	{
		  WebDriverWait wait = new WebDriverWait(driver , 10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_Logout"))));
		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("Lnk_Repairer_Logout"))));
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("Lnk_Repairer_Logout"))));
		  driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_Logout"))).click();
		  sleepyTime();
	}
}