package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_repair.model.FM_MAR;
import mac_repair.util.SQLConnection;

public class FM_MARDAO
{
    
    
    static SQLConnection DBMgr = SQLConnection.getInstance();
    
    private static ArrayList<FM_MAR> ReturnMatchingMARList(String queryString)
    {
        ArrayList<FM_MAR> marListInDB = new ArrayList<FM_MAR>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet marList = stmt.executeQuery(queryString);
            while (marList.next())
            {
                FM_MAR mar = new FM_MAR();
                mar.setMarID(marList.getString("marnumber"));
                mar.setFacilityName(marList.getString("facilityname"));
                mar.setFacilityType(marList.getString("facilitytype"));
                mar.setUrgency(marList.getString("urgency"));
                mar.setDescription(marList.getString("description"));
                mar.setReportedUser(marList.getString("reportedby"));
                mar.setDate(marList.getString("assigneddate"));
                marListInDB.add(mar);
            }
        }
        catch (SQLException e)
        {
        }
        return marListInDB;
    }
    
    private static void StoreListinDB(FM_MAR mar, String queryString)
    {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            String insertmar = queryString + " VALUES ('"
                    + mar.getMarID() + "','"
                    + mar.getDate() + "','"
                    + mar.getFacilityType() + "','"
                    + mar.getFacilityName() + "','"
                    + mar.getDescription() + "','"
                    + mar.getUrgency() + "','"
                    + mar.getReportedUser() + "')";
            
            stmt.executeUpdate(insertmar);
            conn.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Could not insert MAR into database\n" + e.getMessage());
        }
    }
    
    
    public static void UpdateinDB(FM_MAR mar)
    {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            String insertmar = "UPDATE mar SET description = '" + mar.getDescription() + "',"
                    + "urgency = '" + mar.getUrgency() + "' WHERE marnumber = '" + mar.getMarID() + "'";
            stmt.executeUpdate(insertmar);
            conn.commit();
        }
        catch (SQLException e)
        {
        }
    }
    
    public static void deleteMAR(String marID)
    {
        String queryString = "DELETE FROM mar WHERE marnumber = '" + marID + "'";
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            stmt.executeUpdate(queryString);
            conn.commit();
        }
        catch (SQLException e)
        {
        }
        
    }
    
    public static void insertMAR(FM_MAR mar)
    {
        StoreListinDB(mar, "INSERT INTO mar (marnumber,reporteddate,facilitytype,facilityname,description,urgency,reportedby) ");
    }
    
    
    public static FM_MAR getSpecificMar(String marid)
    {
        return ReturnMatchingMARList(String.format(
                "SELECT * FROM mar WHERE marnumber='%s'", marid)).get(0);
    }
    
    public static ArrayList<FM_MAR> listMarsReportedBy(String userString)
    {
        return ReturnMatchingMARList(String.format("SELECT * FROM mar WHERE reportedby='%s' ORDER BY marnumber", userString));
    }
    
    public static ArrayList<FM_MAR> listMarsWithFacilityNameAndUsername(
            String facilityName,
            String username)
    {
        return ReturnMatchingMARList(
                String.format("SELECT * FROM mar WHERE " +
                        "facilityname='%s' " +
                        "AND reportedby='%s' " +
                        "ORDER BY marnumber",
                        facilityName,
                        username));
    }
    
    public static ArrayList<FM_MAR> listMARs()
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE assigneddate = CURDATE() ORDER BY marnumber");
    }
    
    // search companies
    public static ArrayList<FM_MAR> searchMARByNumber(String marnumber)
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE marnumber LIKE '%" + marnumber + "%' ORDER BY marnumber");
    }
    
    public static ArrayList<FM_MAR> searchMARByFacilityType(String facilitytype)
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE facilitytype LIKE '%" + facilitytype + "%' ORDER BY marnumber");
    }
    
    public static ArrayList<FM_MAR> searchMARByFacilityName(String facilityName)
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE facilityname LIKE '%" + facilityName + "%' ORDER BY marnumber");
    }
    
    
    // determine if companyID is unique
    public static Boolean marIDunique(String marnumber)
    {
        return (ReturnMatchingMARList(" SELECT * from mar WHERE marnumber = '" + marnumber + "' ORDER BY marnumber").isEmpty());
    }
    
    
    /**
     * Gets the current unused MAR number.
     * 
     * @return an unused int for the MAR number
     */
    public static int getCurrentMarNumber()
    {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        int result = -1;
        try
        {
            stmt = conn.createStatement();
            String query = "SELECT * FROM marnumber";
            ResultSet marNumberList = stmt.executeQuery(query);
            
            // Goes to the first and only item.
            marNumberList.first();
            result = marNumberList.getInt("current");
            
            /* After getting the MAR number, automatically increment
             * for the next MAR form. */
            query = "UPDATE marnumber SET current=" + (result + 1);
            stmt.executeUpdate(query);
            conn.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Could not retrieve/update current MAR number from database\n" + e.getMessage());
        }
        
        return result;
    }
}
