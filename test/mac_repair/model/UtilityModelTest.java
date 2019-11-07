package mac_repair.model;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class UtilityModelTest
{
    
    UtilityModel model;
    
    @Before
    public void setUp() throws Exception
    {
        model = new UtilityModel();
    }
    
    @Test
    @FileParameters("test/mac_repair/model/UtilityModel_test_cases.csv")
    public void test(int tNo,
            String id,
            String value,
            String expId,
            String expValue)
    {
        model.setId(id);
        model.setValue(value);
        
        assertTrue(expId.equals(model.getId()));
        assertTrue(expValue.equals(model.getValue()));
    }
    
}
