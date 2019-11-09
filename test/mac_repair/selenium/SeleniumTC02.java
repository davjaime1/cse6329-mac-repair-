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
import org.openqa.selenium.WebDriver;

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
  public void TC02b(int testCaseNumber, String username, String utaID, String first, String last, String password, 
			String address, String city, String zip, String state, String phone, String email, String role) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_View_Assigned(driver);
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
