package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_repair.model.Facility;
import mac_repair.util.SQLConnection;

public class FacilityDAO
{
    private static SQLConnection DBMgr = SQLConnection.getInstance();
    
    private static ArrayList<Facility> returnMatchingFacilitiesList(String queryString)
    {
        ArrayList<Facility> facilityListInDB = new ArrayList<Facility>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet facilityList = stmt.executeQuery(queryString);
            while (facilityList.next())
            {
                Facility facility = new Facility();
                facility.setName(facilityList.getString("name"));
                System.out.println("Facility Name: " + facility.getName());
                facilityListInDB.add(facility);
            }
        }
        catch (SQLException e)
        {
        }
        
        
        return facilityListInDB;
    }
    
    
    public static ArrayList<Facility> listFacilitiesNameOnly()
    {
        return returnMatchingFacilitiesList("SELECT name FROM facilities ORDER BY name");
    }
}
