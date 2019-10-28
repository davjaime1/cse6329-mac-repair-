package mac_repair.model;

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
    @FileParameters("test/RepairerViewReserved_test_cases.csv")
    public void test(String testNum, String facilitytype, String facilityname, String date, String to, String from, String marnum)
    {
        ob.setReserved(date, marnum, facilitytype, facilityname, to, from);
        
        Assert.assertTrue(facilitytype.equals(ob.getFacilitytype()));
        Assert.assertTrue(facilityname.equals(ob.getFacilityname()));
        Assert.assertTrue(date.equals(ob.getDate()));
        Assert.assertTrue(to.equals(ob.getTo()));
        Assert.assertTrue(from.equals(ob.getFrom()));
        Assert.assertTrue(marnum.equals(ob.getMarnum()));

    }
    
}
