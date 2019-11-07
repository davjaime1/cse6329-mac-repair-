package mac_repair;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

	  public void takeScreenShot (WebDriver driver, String snapShotName) {
		    snap.takeScreenshot(driver, snapShotName);
		    try {
//			    Change the thread value to run test files with delay
				Thread.sleep(0);
			} catch (InterruptedException e) {}
	  }
	  
	   public void MR_Login (WebDriver driver, String sUserName, String sPassword ) {
			
		// Provide user name.
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys(sUserName);;

		 // Provide Password.
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).clear();
		driver.findElement(By.xpath(prop.getProperty("Txt_Login_Password"))).sendKeys(sPassword);

		 // Click on Login button.
		driver.findElement(By.xpath(prop.getProperty("Btn_Login_Login"))).click();

		try {
//			  Change the delay value to 1_000 to insert a 1 second delay after 
//			  each screenshot
			  Thread.sleep(6000);
		} catch (InterruptedException e) {}
		// We will put the verification of the Welcome message in the JUnit test file instead of here
	  }	
}