package mac_repair.selenium;

import static org.junit.Assert.fail;
import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
  
  /*public String formatInsert(String insert)
  {
	  insert = insert.replace("\"\"", "\"");
	  insert = insert.replace("#",",");
	  
	  return insert;
  }
  
  public void insertMarData(String insert1, String insert2)
  {
      Statement stmt = null;
	  insert1 = formatInsert(insert1);
	  insert2 = formatInsert(insert2);
	  

      Connection conn = SQLConnection.getDBConnection();
      try
      {
          stmt = conn.createStatement();
          stmt.executeUpdate(insert1);
          conn.commit();
          stmt = conn.createStatement();
          stmt.executeUpdate(insert2);
          conn.commit();
      }
      catch (SQLException e)
      {
          System.out.println("Could not insert MAR into database\n" + e.getMessage());
      }
  }
  
  public void insertRepairScheduleData(String insert3, String insert4)
  {
		Statement stmt = null;
		  insert3 = formatInsert(insert3);
		  insert4 = formatInsert(insert4);
		  System.out.println(insert3);
		  System.out.println(insert4);
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(insert3);	
			conn.commit(); 
			stmt = conn.createStatement();
			stmt.executeUpdate(insert4);	
			conn.commit(); 
		} catch (SQLException e) {System.out.println("Could not add");}
  }
  
  public void insertFacilityReservationData(String insert5, String insert6)
  {
	  
      Statement stmt = null;
	  insert5 = formatInsert(insert5);
	  insert6 = formatInsert(insert6);
      Connection conn = SQLConnection.getDBConnection();
      try
      {
          stmt = conn.createStatement();
          stmt.executeUpdate(insert5);
          conn.commit();
          stmt = conn.createStatement();
          stmt.executeUpdate(insert6);
          conn.commit();
      }
      catch (SQLException e)
      {
          System.out.println("Could not insert MAR into database\n" + e.getMessage());
      }
  }
  */
  
  //====================================AO5 Tests ===========================================


  //Register a new repairer and then login
  @Test
  @FileParameters("test/mac_repair/selenium/TC02_test_cases.csv")
  public void TC02(int testCaseNumber, String username, String utaID, String first, String last, String password, 
			String address, String city, String zip, String state, String phone, String email, String role) throws Exception
  {
	  driver.get(sAppURL);
	  //Commented Out for now
	  MR_Register(driver, username, utaID, first, last, password, address, city, zip, state, phone, email, role);
	  MR_Login(driver, username, password);
	  takeScreenShot(driver, "TC02_Register_1");
  }
  
  //Login and test headers on Mac Repair page
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
	  takeScreenShot(driver, "TCO2b_VerifyRepairerHomePageHeaderValues_1");
	  Repairer_Logout(driver);
  }
  
  //Test to check View Assigned Repair List Headers
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
	  takeScreenShot(driver, "TC02d_VerifyAssignedRepairsHeaderValues_1");
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
  }
  
  //Verify View Assigned List
  @Test
  @FileParameters("test/mac_repair/selenium/TC02c_test_cases.csv")
  public void TC02c(int testCaseNumber, String username, String password, String expMar1, String expMar2, String expName1, String expName2, String expDate1, String expDate2) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_View_Assigned(driver);
	  printAssignedMAR(driver);
	  assertEquals(expMar1, driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[1]")).getText());
	  assertEquals(expName1,driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[2]")).getText());
	  assertEquals(expDate1, driver.findElement(By.xpath("html/body/form/table/tbody/tr[2]/td[8]")).getText());
	  assertEquals(expMar2, driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[1]")).getText());
	  assertEquals(expName2,driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[2]")).getText());
	  assertEquals(expDate2, driver.findElement(By.xpath("html/body/form/table/tbody/tr[3]/td[8]")).getText());
	  takeScreenShot(driver, "TC02c_VerifyViewAssignedRepairsValues_1");
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
  }
  
  //Verify View Specific Details Headers
  @Test
  @FileParameters("test/mac_repair/selenium/TC02e_test_cases.csv")
  public void TC02e(int testCaseNumber, String username, String password, String ExpMarNum, String ExpFacilityName, 
		  			String ExpFacilityType, String ExpUrgency, String ExpDescription, String ExpReportedDate, 
		  			String ExpReportedBy, String ExpAssignedDate, String ExpEstimate) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_View_Assigned(driver);
	  Repairer_View_Specific_Assigned(driver);
	  //Verify View Specific Assigned Headers
	  assertEquals(ExpMarNum,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_MarNumHeader"))).getText());
	  assertEquals(ExpFacilityName,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_FacilityNameHeader"))).getText());
	  assertEquals(ExpFacilityType,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_FacilityTypeHeader"))).getText());
	  assertEquals(ExpUrgency,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_UrgencyHeader"))).getText());
	  assertEquals(ExpDescription,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_DescriptionHeader"))).getText());
	  assertEquals(ExpReportedDate,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_ReportedDateHeader"))).getText());
	  assertEquals(ExpReportedBy,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_ReportedByHeader"))).getText());
	  assertEquals(ExpAssignedDate,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_AssignedDateHeader"))).getText());
	  assertEquals(ExpEstimate,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_EestimateHeader"))).getText());
	  takeScreenShot(driver, "TC02e_VerifySpecificAssignHeaderValues_1");
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
  }
  
  //Verify View Specific Details Values
  @Test
  @FileParameters("test/mac_repair/selenium/TC02f_test_cases.csv")
  public void TC02f(int testCaseNumber, String username, String password, String ExpMarNum, String ExpFacilityName, 
		  			String ExpFacilityType, String ExpUrgency, String ExpDescription, String ExpReportedDate, 
		  			String ExpReportedBy, String ExpAssignedDate, String ExpEstimate) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_View_Assigned(driver);
	  Repairer_View_Specific_Assigned(driver);
	  //Verify View Specific Assigned Headers
	  assertEquals(ExpMarNum,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_MarNum"))).getText());
	  assertEquals(ExpFacilityName,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_FacilityName"))).getText());
	  assertEquals(ExpFacilityType,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_FacilityType"))).getText());
	  assertEquals(ExpUrgency,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_Urgency"))).getText());
	  assertEquals(ExpDescription,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_Description"))).getText());
	  assertEquals(ExpReportedDate,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_ReportedDate"))).getText());
	  assertEquals(ExpReportedBy,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_ReportedBy"))).getText());
	  assertEquals(ExpAssignedDate,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_AssignedDate"))).getText());
	  assertEquals(ExpEstimate,driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificAssigned_Eestimate"))).getText());
	  takeScreenShot(driver, "TC02f_VerifySpecificAssignValues_1");
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
  }
  
  //View Assigned Repairs and View Specific Repair Scenarios, also prints out repair list
  @Test
  @FileParameters("test/mac_repair/selenium/TC02g_test_cases.csv")
  public void TC02g(int testCaseNumber, String username, String password) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_View_Assigned(driver);
	  Repairer_View_Specific_Assigned(driver);
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
	  //Just gonna take a screenshot of the login page (where the full scenario ends)
	  takeScreenShot(driver, "TC02g_EntireScenario_1");
  }
  
  //====================================AO6 Tests ===========================================
 
  //Verify make a reservation headers and data values and make a reservation
  @Test
  @FileParameters("test/mac_repair/selenium/TC02h_test_cases.csv")
  public void TC02h(int testCaseNumber, String username, String password, String expfacilityname, String expfacilitytype, String expdate, String expfrom, String expto, String tag) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_View_Assigned(driver);
	  Repairer_View_Specific_Assigned(driver);
	  Repairer_ViewMakeReservation(driver);
	  int i = 2;
	  assertEquals(expfacilityname, driver.findElement(By.xpath(prop.getProperty("Txt_MakeReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expfacilitytype, driver.findElement(By.xpath(prop.getProperty("Txt_MakeReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expdate, driver.findElement(By.xpath(prop.getProperty("Txt_MakeReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expfrom, driver.findElement(By.xpath(prop.getProperty("Txt_MakeReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expto, driver.findElement(By.xpath(prop.getProperty("Txt_MakeReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  
	  if(tag.equals("td"))
	  {
		  Repairer_MakeReservation(driver);
	  }
	  
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
	  //Just gonna take a screenshot of the login page (where the full scenario ends)
	  takeScreenShot(driver, "TC02g_EntireScenario_1");
  }
  
  
  //Verify view my reservations headers and values
  @Test
  @FileParameters("test/mac_repair/selenium/TC02i_test_cases.csv")
  public void TC02i(int testCaseNumber, String username, String password, String expDate, String expMarnum, String expFacilitytype, String expFacilityname, String expFrom, String expTo, String tag) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_ViewReserved(driver);
	  
	  int i = 1;
	  assertEquals(expDate, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expMarnum, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expFacilitytype, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expFacilityname, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expFrom, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expTo, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_Xpaths") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
	  //Just gonna take a screenshot of the login page (where the full scenario ends)
	  takeScreenShot(driver, "TC02g_EntireScenario_1");
  }
  
  
  //Verify specific reservation header and values
  @Test
  @FileParameters("test/mac_repair/selenium/TC02j_test_cases.csv")
  public void TC02j(int testCaseNumber, String username, String password, String expDate, String expMarnum, String expFacilitytype, String expFacilityname, String expFrom, String expTo) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_ViewReserved(driver);
	  Repairer_ViewSpecificReserved(driver);
	  
	  int i = 1;
	  assertEquals(expDate, driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificReserved_Xpath") + i++ + "]/td[" + testCaseNumber + "]")).getText());
	  assertEquals(expMarnum, driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificReserved_Xpath") + i++ + "]/td[" + testCaseNumber + "]")).getText());
	  assertEquals(expFacilitytype, driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificReserved_Xpath") + i++ + "]/td[" + testCaseNumber + "]")).getText());
	  assertEquals(expFacilityname, driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificReserved_Xpath") + i++ + "]/td[" + testCaseNumber + "]")).getText());
	  assertEquals(expFrom, driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificReserved_Xpath") + i++ + "]/td[" + testCaseNumber + "]")).getText());
	  assertEquals(expTo, driver.findElement(By.xpath(prop.getProperty("Txt_ViewSpecificReserved_Xpath") + i++ + "]/td[" + testCaseNumber + "]")).getText());
	  
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
	  //Just gonna take a screenshot of the login page (where the full scenario ends)
	  takeScreenShot(driver, "TC02g_EntireScenario_1");
  }
  
  
  //Verify modify reservations header and values
  @Test
  @FileParameters("test/mac_repair/selenium/TC02k_test_cases.csv")
  public void TC02k(int testCaseNumber, String username, String password, String expFacilityname, String expFacilitytype, String expDate, String expFrom, String expTo, String tag) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_ViewReserved(driver);
	  Repairer_ViewSpecificReserved(driver);
	  Repairer_ViewModifyReservation(driver);
	  
	  int i = 2;
	  assertEquals(expFacilityname, driver.findElement(By.xpath(prop.getProperty("Txt_ModifyReservation_Xpath") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expFacilitytype, driver.findElement(By.xpath(prop.getProperty("Txt_ModifyReservation_Xpath") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expDate, driver.findElement(By.xpath(prop.getProperty("Txt_ModifyReservation_Xpath") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expFrom, driver.findElement(By.xpath(prop.getProperty("Txt_ModifyReservation_Xpath") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  assertEquals(expTo, driver.findElement(By.xpath(prop.getProperty("Txt_ModifyReservation_Xpath") + testCaseNumber + "]/" + tag + "["+ i++ +"]")).getText());
	  
	  if(tag.equals("td"))
	  {
		  Repairer_ModifyReservation(driver);
	  }
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
	  //Just gonna take a screenshot of the login page (where the full scenario ends)
	  takeScreenShot(driver, "TC02g_EntireScenario_1");
  }
  
  
  //Verify cancel request
  @Test
  @FileParameters("test/mac_repair/selenium/TC02l_test_cases.csv")
  public void TC02l(int testCaseNumber, String username, String password, String expDate, String expMarnum, String expFacilitytype, String expFacilityname, String expFrom, String expTo) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_ViewReserved(driver);
	  Repairer_ViewSpecificReserved(driver);
	  Repairer_CancelReservation(driver);
	  Repairer_ViewReserved(driver);
	  
	  assertEquals(expDate, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_CancelChecks") + "1]")).getText());
	  assertEquals(expMarnum, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_CancelChecks") + "2]")).getText());
	  assertEquals(expFacilitytype, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_CancelChecks") + "3]")).getText());
	  assertEquals(expFacilityname, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_CancelChecks") + "4]")).getText());
	  assertEquals(expFrom, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_CancelChecks") + "5]")).getText());
	  assertEquals(expTo, driver.findElement(By.xpath(prop.getProperty("Txt_ViewReservation_CancelChecks") + "6]")).getText());
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
	  //Just gonna take a screenshot of the login page (where the full scenario ends)
	  takeScreenShot(driver, "TC02g_EntireScenario_1");
  }
  
  /*
  //Full Scenario run through, no verifications
  @Test
  @FileParameters("test/mac_repair/selenium/TC02g_test_cases.csv")
  public void TC02m(int testCaseNumber, String username, String password) throws Exception
  {
	  driver.get(sAppURL);
	  MR_Login(driver, username, password);
	  Repairer_View_Assigned(driver);
	  Repairer_View_Specific_Assigned(driver);
	  Repairer_Homepage(driver);
	  Repairer_Logout(driver);
	  //Just gonna take a screenshot of the login page (where the full scenario ends)
	  takeScreenShot(driver, "TC02g_EntireScenario_1");
  }
*/
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }
}
