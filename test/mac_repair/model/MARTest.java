package mac_repair.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class MARTest
{
    
    MAR mar;
    MARErrorMsgs CerrMsgs;
    
    @Before
    public void setUp() throws Exception
    {
        mar = new MAR();
        CerrMsgs = new MARErrorMsgs();
    }
    
    @Test
    @FileParameters("test/marTest.csv")
    public void test(int testcaseNo, String action, String marID, String facilityName, String facilityType,
            String urgency, String description, String reportedUser, String date, String assignedTo,
            String assignedDate, String estimateOFRepair, String errorMsg,
            String marNumberError, String descriptionError, String assignedDateError, String assignedToError)
    {
        
        mar.setAssignedMAR(marID, facilityName, facilityType, urgency, description, reportedUser, date, assignedTo,
                assignedDate, estimateOFRepair);
        mar.validateMAR(action, CerrMsgs);
        assertTrue(errorMsg.equals(CerrMsgs.getErrorMsg()));
        
        // assertTrue(errorMsg.equals(CerrMsgs.getErrorMsg()));
        assertTrue(marID.equals(mar.getMarID()));
        assertTrue(facilityName.equals(mar.getFacilityName()));
        assertTrue(facilityType.equals(mar.getFacilityType()));
        assertTrue(urgency.equals(mar.getUrgency()));
        assertTrue(reportedUser.equals(mar.getReportedUser()));
        assertTrue(estimateOFRepair.equals(mar.getEstimateOfRepair()));
        assertTrue(date.equals(mar.getDate()));
        
        assertTrue(assignedDateError.equals(CerrMsgs.getAssignedDatErrorMsgs()));
        assertTrue(assignedToError.equals(CerrMsgs.getAssignedToErrorMsgs()));
        assertTrue(descriptionError.equals(CerrMsgs.getDescriptionErrorMsgs()));
        assertTrue(marNumberError.equals(CerrMsgs.getMarNumberError()));
        
    }
}