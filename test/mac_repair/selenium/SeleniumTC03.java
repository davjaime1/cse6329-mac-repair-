package mac_repair.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import mac_repair.MRFunctions;
import mac_repair.FMFunctions;

import mac_repair.SnapshotFunction;
import mac_repair.model.User;
import mac_repair.model.UserTest;
import mac_repair.util.SQLConnection;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // the test methods in this test file can run in any order but I prefer a fixed order
public class SeleniumTC03 extends FMFunctions {
  static SQLConnection DBMgr = SQLConnection.getInstance();
  private StringBuffer verificationErrors = new StringBuffer();
  public String sAppURL, sSharedUIMapPath, testDelay;
  User u;
  UserTest error;
  private SnapshotFunction snap = new SnapshotFunction();
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
	u = new User();
	error = new UserTest();
  }
  
  
  
public void PrintMARTableContents() {
  //Get all rows
  List<WebElement> rows= driver.findElement(By.xpath("/html/body/form")).findElements(By.tagName("tr"));
  System.out.println(rows.size());
  //print out header row
  for (int i=1;i<8;i++)
	  System.out.print(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/th["+i+"]")).getText()+"\t");
  System. out.println();
 
  //Output data from each row
  for (int i=2;i<=rows.size();i++) {
	  System.out.print(driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[1]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[2]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[3]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[4]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[5]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[6]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/form/table/tbody/tr["+i+"]/td[7]")).getText()+"\t");
	  System. out.println();

  }
}

  
  @Test
  public void TC03a() throws Exception
  {
	  driver.get(sAppURL);
	  MR_Register(driver, "fm2", "1001526202", "John", "Smith", "password", "address", "Arlington", "76019", "TX", "1231231234", "email@uta.edu", "FM");
	  try{ Thread.sleep(3000);}catch (InterruptedException e) {}
	  snap.takeScreenshot(driver, "Facility_Manager_Register");
	  driver.quit();
  }
 
  @Test
  public void TC03b() throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, "fm2", "password");
	  snap.takeScreenshot(driver, "Facility_Manager_Login");
	  Thread.sleep(2000);
	  driver.quit();
	  //Need to pull login error message from get method, but it doesn't exist anymore after the clean
	  //assertTrue(errorMessage.equals())
  }
 
  @Test
  public void TC03c() throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, "fm2", "password");
	  Thread.sleep(2000);
	  MR_ListMAR(driver);
	  snap.takeScreenshot(driver, "Facility_Manager_List_MARS");
	  
	  assertEquals(driver.getTitle(),"MAR List");
	  PrintMARTableContents();
	  Thread.sleep(2000);
	  driver.quit();
	  //Need to pull login error message from get method, but it doesn't exist anymore after the clean
	  //assertTrue(errorMessage.equals())
  }

  @Test
  public void TC03d1() throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, "fm2", "password");
	  Thread.sleep(2000);
	  MR_Search_MAR(driver, "","");
	  Thread.sleep(2000);
	  snap.takeScreenshot(driver, "Facility_Manager_Failed_Search");
	  System.out.println(driver.findElement(By.name(prop.getProperty("Txt_Search_MAR_Number_Error"))).getAttribute("value"));
	  System.out.println(driver.findElement(By.name(prop.getProperty("Txt_Error_Msgs"))).getAttribute("value"));

	  assertEquals(driver.findElement(By.name(prop.getProperty("Txt_Search_MAR_Number_Error"))).getAttribute("value"),"Both MAR Number and Facility Name cannot be blank");
	  assertEquals(driver.findElement(By.name(prop.getProperty("Txt_Error_Msgs"))).getAttribute("value"),"Please correct the following errors");

	  Thread.sleep(2000);
	  driver.quit();
	  //Need to pull login error message from get method, but it doesn't exist anymore after the clean
	  //assertTrue(errorMessage.equals())
  }
 
  @Test
  @FileParameters("test/mac_repair/selenium/TC03d2_test_cases.csv")
  public void TC03d2(int testCaseNumber, String facilityName, String marID) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, "fm2", "password");
	  Thread.sleep(2000);
	  MR_Search_MAR(driver, facilityName,marID);
	  Thread.sleep(2000);
	  snap.takeScreenshot(driver, "Facility_Manager_Search" + Integer.toString(testCaseNumber));
	  assertEquals(driver.getTitle(),"MAR List");
	  PrintMARTableContents();
	  Thread.sleep(2000);
	  driver.quit();
	  //Need to pull login error message from get method, but it doesn't exist anymore after the clean
	  //assertTrue(errorMessage.equals())
  }
  
  @Test
  @FileParameters("test/mac_repair/selenium/TC03e1_test_cases.csv")
  public void TC03e1(int testCaseNumber, String description, String assignedTo, String assignedDate, String descriptionError, String assignedToError, String assignedDateError) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, "fm2", "password");
	  Thread.sleep(2000);
	  MR_AssignMAR(driver, description,assignedTo,assignedDate);
	  Thread.sleep(2000);
	  snap.takeScreenshot(driver, "UnsuccessFul Assign Mar" + Integer.toString(testCaseNumber));
	  
	  
	  assertEquals(driver.findElement(By.name(prop.getProperty("Txt_MAR_Description_Error"))).getAttribute("value"),descriptionError);
	  assertEquals(driver.findElement(By.name(prop.getProperty("Txt_MAR_AssignTo_Error"))).getAttribute("value"),assignedToError);
	  assertEquals(driver.findElement(By.name(prop.getProperty("Txt_MAR_AssignDate_Error"))).getAttribute("value"),assignedDateError);
	  assertEquals(driver.findElement(By.name(prop.getProperty("Txt_Error_Msgs"))).getAttribute("value"),"Please correct the following errors");
	  driver.quit();
	  //Need to pull login error message from get method, but it doesn't exist anymore after the clean
	  //assertTrue(errorMessage.equals())
  }

  @Test
  @FileParameters("test/mac_repair/selenium/TC03e2_test_cases.csv")
  public void TC03e2(int testCaseNumber,  String description, String assignedTo, String assignedDate) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, "fm2", "password");
	  Thread.sleep(2000);
	  MR_AssignMAR(driver, description,assignedTo,assignedDate);
	  Thread.sleep(2000);
	  snap.takeScreenshot(driver, "SuccessFul Assign Mar");
	  assertEquals(driver.getTitle(),"View Specific Assigned MAR");
	  assertEquals(driver.findElement(By.xpath(prop.getProperty("Txt_AMAR_View_AssignedTo"))).getText(),assignedTo);
	  assertEquals(driver.findElement(By.xpath(prop.getProperty("Txt_AMAR_View_Description"))).getText(),description);
	  assertEquals(driver.findElement(By.xpath(prop.getProperty("Txt_AMAR_View_AssignedDate"))).getText(),assignedDate);


	  //Need to pull login error message from get method, but it doesn't exist anymore after the clean
	  //assertTrue(errorMessage.equals())
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
