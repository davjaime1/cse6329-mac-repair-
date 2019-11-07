package mac_repair.model;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class RepairerViewReservedTest
{
    
    RepairerViewReserved ob;
    
    @Before
    public void setUp() throws Exception
    {
        ob = new RepairerViewReserved();
    }
    
    @Test
    @FileParameters("test/mac_repair/model/RepairerViewReserved_test_cases.csv")
    public void test(String testNum, String facilitytype, String facilityname, String date, String to, String from, String marnum, String user, String user2, 
    		         String expfacilitytype, String expfacilityname, String expdate, String expto, String expfrom, String expmarnum, String expuser, String expbool)
    {
        ob.setReserved(date, marnum, facilitytype, facilityname, to, from);
        ob.setUser(user);
        
        Assert.assertTrue(expfacilitytype.equals(ob.getFacilitytype()));
        Assert.assertTrue(expfacilityname.equals(ob.getFacilityname()));
        Assert.assertTrue(expdate.equals(ob.getDate()));
        Assert.assertTrue(expto.equals(ob.getTo()));
        Assert.assertTrue(expfrom.equals(ob.getFrom()));
        Assert.assertTrue(expmarnum.equals(ob.getMarnum()));
        Assert.assertTrue(expuser.equals(ob.getUser()));
        
        ArrayList<RepairerViewReserved> possible = new ArrayList<RepairerViewReserved>();
        possible.add(ob);
        Assert.assertEquals(RepairerViewReserved.userReserve(possible, user2), expbool);
        
    }
    
}
