package mac_repair.selenium;

import static org.junit.Assert.fail;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import mac_repair.MRFunctions;
import mac_repair.util.SQLConnection;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // the test methods in this test file can run in any order but I prefer a fixed order
public class SeleniumTC02 extends MRFunctions {
  static SQLConnection DBMgr = SQLConnection.getInstance();
  private StringBuffer verificationErrors = new StringBuffer();
  public String sAppURL, sSharedUIMapPath, testDelay;
  
  @Before
  public void setUp() throws Exception {
//		MAGIC CODE GOES HERE 
    driver = invokeCorrectBrowser();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    prop = new Properties();	  
    prop.load(new FileInputStream("./Configuration/MR_Configuration.properties"));
	sAppURL = prop.getProperty("sAppURL");
	sSharedUIMapPath = prop.getProperty("SharedUIMap");
	testDelay=prop.getProperty("testDelay");
	prop.load(new FileInputStream(sSharedUIMapPath));
  }
  
  public void printAssignedMAR(WebDriver driver)
  {
	  List<WebElement> rows= driver.findElement(By.xpath("html/body/form/table")).findElements(By.tagName("tr"));
	  for (int i = 1;i<10;i++)
	  {
		  if(i == 4)
			  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/th["+ i +"]")).getText()+"\t\t");
		  else
			  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr[1]/th["+ i +"]")).getText()+"\t");

	  }
	  System. out.println();
	  for(int i = 2; i <= rows.size(); i++)
	  {
		  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr["+ i +"]/td[1]")).getText()+"\t\t");
		  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr["+ i +"]/td[2]")).getText()+"\t\t");
		  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr["+ i +"]/td[3]")).getText()+"\t\t");
		  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr["+ i +"]/td[4]")).getText()+"\t\t");
		  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr["+ i +"]/td[5]")).getText()+"\t\t");
		  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr["+ i +"]/td[6]")).getText()+"\t");
		  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr["+ i +"]/td[7]")).getText()+"\t\t");
		  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr["+ i +"]/td[8]")).getText()+"\t");
		  System.out.print(driver.findElement(By.xpath("html/body/form/table/tbody/tr["+ i +"]/td[9]")).getText()+"\t\t");
		  System.out.println();
	  }
  }
    
  @Test
  @FileParameters("test/mac_repair/selenium/TC02_test_cases.csv")
  public void TC02(int testCaseNumber, String username, String utaID, String first, String last, String password, 
			String address, String city, String zip, String state, String phone, String email, String role) throws Exception
  {
	  driver.get(sAppURL);
	  //Commented Out for now
	  MR_Register(driver, username, utaID, first, last, password, address, city, zip, state, phone, email, role);
  }
  
  @Test
  @FileParameters("test/mac_repair/selenium/TC02b_test_cases.csv")
  public void TC02b(int testCaseNumber, String username, String password, String ExpHeader, String ExpLink1, String ExpLink2, String ExpLink3, String ExpLink4, String ExpLink5) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  //Verify Headers Repairer Homepage Links
	  assertEquals(ExpHeader,driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_HomePage"))).getText());
	  assertEquals(ExpLink1,driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_ViewAssignedRepairs"))).getText());
	  assertEquals(ExpLink2,driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_ViewReservedRepairs"))).getText());
	  assertEquals(ExpLink3,driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_ViewProfile"))).getText());
	  assertEquals(ExpLink4,driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_UpdateProfile"))).getText());
	  assertEquals(ExpLink5,driver.findElement(By.xpath(prop.getProperty("Lnk_Repairer_Logout"))).getText());
	  Repairer_Logout(driver);
  }
  
  @Test
  @FileParameters("test/mac_repair/selenium/TC02c_test_cases.csv")
  public void TC02c(int testCaseNumber, String username, String password) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_View_Assigned(driver);
	  printAssignedMAR(driver);
	  Repairer_View_Specific_Assigned(driver);
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
  }
  
  @Test
  @FileParameters("test/mac_repair/selenium/TC02d_test_cases.csv")
  public void TC02d(int testCaseNumber, String username, String password, String ExpHeader, String ExpCol1, String ExpCol2, String ExpCol3, 
		  			String ExpCol4, String ExpCol5, String ExpCol6, String ExpCol7, String ExpCol8, String ExpCol9) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_View_Assigned(driver);
	  
	  //Verify View Assigned Headers
	  assertEquals(ExpHeader,driver.findElement(By.xpath(prop.getProperty("Lnk_ViewAssigned_HomePage"))).getText());
	  assertEquals(ExpCol1,driver.findElement(By.xpath(prop.getProperty("Txt_ViewAssigned_MarNum"))).getText());
	  assertEquals(ExpCol2,driver.findElement(By.xpath(prop.getProperty("Txt_ViewAssigned_FacilityName"))).getText());
	  assertEquals(ExpCol3,driver.findElement(By.xpath(prop.getProperty("Txt_ViewAssigned_FacilityType"))).getText());
	  assertEquals(ExpCol4,driver.findElement(By.xpath(prop.getProperty("Txt_ViewAssigned_Urgency"))).getText());
	  assertEquals(ExpCol5,driver.findElement(By.xpath(prop.getProperty("Txt_ViewAssigned_Description"))).getText());
	  assertEquals(ExpCol6,driver.findElement(By.xpath(prop.getProperty("Txt_ViewAssigned_ReportedDate"))).getText());
	  assertEquals(ExpCol7,driver.findElement(By.xpath(prop.getProperty("Txt_ViewAssigned_ReportedBy"))).getText());
	  assertEquals(ExpCol8,driver.findElement(By.xpath(prop.getProperty("Txt_ViewAssigned_AssignedDate"))).getText());
	  assertEquals(ExpCol9,driver.findElement(By.xpath(prop.getProperty("Txt_ViewAssigned_EstimateOfRepair"))).getText());
	  
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
  }
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
