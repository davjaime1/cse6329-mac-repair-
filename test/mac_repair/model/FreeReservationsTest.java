package mac_repair.model;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import mac_repair.data.RepairerViewReservedDAO;

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
    @FileParameters("test/mac_repair/model/FreeReservations_test_cases.csv")
    public void test(String testNum, String facilitytype, String facilityname, String date, String from, String to, String venue, String id,
    		         String expfacilitytype, String expfacilityname, String expdate, String expfrom, String expto, String expvenue, String expid)
    {
        ob.setReserved(facilitytype, facilityname, venue, date, to, from);
        ob.setId(id);
        ArrayList<FreeReservations> possible = new ArrayList<FreeReservations>();
        possible = RepairerViewReservedDAO.makePossibleFreeList(facilityname, date);
        ArrayList<FreeReservations> inDB = new ArrayList<FreeReservations>();
       
        //inDB = RepairerViewReservedDAO.ReservedListInDB(facilityname, date);
        //FreeReservations.getAvaliableReservations(possible, inDB);
        
        Assert.assertTrue(expfacilitytype.equals(ob.getFacilitytype()));
        Assert.assertTrue(expfacilityname.equals(ob.getFacilityname()));
        Assert.assertTrue(expdate.equals(ob.getDate()));
        Assert.assertTrue(expto.equals(ob.getTo()));
        Assert.assertTrue(expfrom.equals(ob.getFrom()));
        Assert.assertTrue(expvenue.equals(ob.getVenue()));
        Assert.assertTrue(expid.equals(ob.getId()));
     }
    
}
