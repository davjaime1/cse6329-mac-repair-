package mac_repair.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class FreeReservationsTest
{
    
    FreeReservations ob;
    
    @Before
    public void setUp() throws Exception
    {
        ob = new FreeReservations();
    }
    
    @Test
    @FileParameters("test/FreeReservations_test_cases.csv")
    public void test(String testNum, String facilitytype, String facilityname, String date, String to, String from, String venue, String id)
    {
        ob.setReserved(facilitytype, facilityname, venue, date, to, from);
        ob.setId(id);
        
        Assert.assertTrue(facilitytype.equals(ob.getFacilitytype()));
        Assert.assertTrue(facilityname.equals(ob.getFacilityname()));
        Assert.assertTrue(date.equals(ob.getDate()));
        Assert.assertTrue(to.equals(ob.getTo()));
        Assert.assertTrue(from.equals(ob.getFrom()));
        Assert.assertTrue(venue.equals(ob.getVenue()));
        Assert.assertTrue(id.equals(ob.getId()));

    }
    
}
