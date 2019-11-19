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

import mac_repair.AdminFunctions;

import mac_repair.SnapshotFunction;
import mac_repair.model.User;
import mac_repair.model.UserTest;
import mac_repair.util.SQLConnection;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // the test methods in this test file can run in any order but I prefer a fixed order
public class SeleniumTC04 extends AdminFunctions {
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
  
  
  
public void PrintUserTableContents() {
  //Get all rows
  List<WebElement> rows= driver.findElement(By.xpath("/html/body/table/tbody")).findElements(By.tagName("tr"));
  System.out.println(rows.size());
  //print out header row
  for (int i=1;i<6;i++)
	  System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td["+i+"]")).getText()+"\t");
  System. out.println();
 
  //Output data from each row
  for (int i=2;i<=rows.size();i++) {
	  System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[1]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[2]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[3]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[4]")).getText()+"\t");
	  System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td[5]")).getText()+"\t");
	  System. out.println();

  }
}

//  
  @Test
  public void TC04a() throws Exception
  {
	  driver.get(sAppURL);
	  MR_Register(driver, "admin3", "1001526202", "John", "Smith", "password", "address", "Arlington", "76019", "TX", "1231231234", "email@uta.edu", "A");
	  try{ Thread.sleep(3000);}catch (InterruptedException e) {}
	  snap.takeScreenshot(driver, "Admin_Register");
	  driver.quit();
  }
 
  @Test
  public void TC04b() throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, "admin3", "password");
	  snap.takeScreenshot(driver, "Admin_Login");
	  Thread.sleep(2000);
	  driver.quit();
	  //Need to pull login error message from get method, but it doesn't exist anymore after the clean
	  //assertTrue(errorMessage.equals())
  }
 
@Test
@FileParameters("test/mac_repair/selenium/TC04c_test_cases.csv")
  public void TC04c(int TestCase, String filter) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, "admin3", "password");
	  Thread.sleep(2000);
	  MR_ListAndFilterUser(driver, filter);
	  snap.takeScreenshot(driver, "Admin_List_User" + Integer.toString(TestCase));
	  assertEquals(driver.getTitle(),"User List");
	  PrintUserTableContents();
	  Thread.sleep(2000);
	  driver.quit();
	  //Need to pull login error message from get method, but it doesn't exist anymore after the clean
	  //assertTrue(errorMessage.equals())
  }

 
  
//
  @Test
  @FileParameters("test/mac_repair/selenium/TC04d_test_cases.csv")
  public void TC04d(int testCaseNumber,  String role, String Visible) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, "admin3", "password");
	  Thread.sleep(2000);
	  MR_ChangeUserRole(driver, Visible);
	  snap.takeScreenshot(driver, "Change_User_Role");
	  Thread.sleep(10000);
	  assertEquals(driver.findElement(By.xpath(prop.getProperty("Txt_Changed_User_Role_Admin"))).getText(),role);


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
