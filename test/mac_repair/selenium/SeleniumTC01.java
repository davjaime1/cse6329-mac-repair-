package mac_repair.selenium;

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

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import mac_repair.MRFunctions;
import mac_repair.model.User;
import mac_repair.model.UserTest;
import mac_repair.util.SQLConnection;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // the test methods in this test file can run in any order but I prefer a fixed order
public class SeleniumTC01 extends MRFunctions {
  static SQLConnection DBMgr = SQLConnection.getInstance();
  private StringBuffer verificationErrors = new StringBuffer();
  public String sAppURL, sSharedUIMapPath, testDelay;
  User u;
  UserTest error;
  
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
  
  //Login Validations
  @Test
  @FileParameters("test/mac_repair/selenium/TC01_test_cases.csv")
  public void TC01(int testCaseNumber, String username, String password, String errorMessage ) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  //Need to pull login error message from get method, but it doesn't exist anymore after the clean
	  //assertTrue(errorMessage.equals())
  }
  
  //Register Validations
  @Test
  @FileParameters("test/mac_repair/selenium/TC01b_test_cases.csv")
  public void TC01b(int testCaseNumber, String username, String utaID, String first, String last, String password, 
					String address, String city, String zip, String state, String phone, String email, String role) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Register(driver, username, utaID, first, last, password, address, city, zip, state, phone, email, role);
	  try{ Thread.sleep(3000);}catch (InterruptedException e) {}
	  MR_Login(driver, username, password);
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
