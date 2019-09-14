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
    
    /**
     * Returns an ArrayList of all facilities in the database based on query string.
     */
    private static ArrayList<Facility> returnMatchingFacilitiesList(String queryString)
    {
        ArrayList<Facility> facilityListInDB = new ArrayList<Facility>();
        
        // Attempt to connect to the database.
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            // Execute query to get results from database.
            stmt = conn.createStatement();
            ResultSet facilityList = stmt.executeQuery(queryString);

            // Go through SQL list, make a facility from the info, and put into array list.
            while (facilityList.next())
            {
                Facility facility = new Facility();
                facility.setName(facilityList.getString("name"));
                facility.setType(facilityList.getString("facilitytype"));
                facility.setInterval(facilityList.getString("time_interval"));
                facility.setDuration(facilityList.getString("duration"));
                facility.setVenue(facilityList.getString("venue"));
                
                facilityListInDB.add(facility);
            }
        }
        catch (SQLException e)
        {
        }
        
        
        return facilityListInDB;
    }
    
    /**
     * Gets all the facilities and related information currently stored in the database.
     */
    public static ArrayList<Facility> listFacilities()
    {
        return returnMatchingFacilitiesList("SELECT * FROM facilities ORDER BY name");
    }
}
