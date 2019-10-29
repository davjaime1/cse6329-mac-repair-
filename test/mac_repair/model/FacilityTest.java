package mac_repair.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class FacilityTest
{
    
    Facility fct;
    FacilityErrorMsgs CerrMsgs;
    
    @Before
    public void setUp() throws Exception
    {
        fct = new Facility();
        CerrMsgs = new FacilityErrorMsgs();
    }
    
    @Test
    @FileParameters("test/facilityTest.csv")
    public void test(int testcaseNo, String action, String facilityName, String facilityType, String timeInterval,
            String duration, String venue, String errorMsg,
            String facilityNameError)
    {
        fct.setFacility(facilityName, facilityType, timeInterval, duration, venue);
        
        fct.validateFacility(action, CerrMsgs);
        assertTrue(duration.equals(fct.getDuration()));
        assertTrue(venue.equals(fct.getVenue()));
        assertTrue(timeInterval.equals(fct.getTimeInterval()));
        assertTrue(facilityType.equals(fct.getFacilityType()));
        assertTrue(errorMsg.equals(CerrMsgs.getErrorMsg()));
        assertTrue(facilityNameError.equals(CerrMsgs.getFacilityNameError()));
    }
}