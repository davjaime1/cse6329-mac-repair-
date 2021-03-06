package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_repair.model.MAR;
import mac_repair.util.SQLConnection;

public class MARDAO
{
    
    
    static SQLConnection DBMgr = SQLConnection.getInstance();
    
    private static ArrayList<MAR> ReturnMatchingMARList(String queryString)
    {
        ArrayList<MAR> marListInDB = new ArrayList<MAR>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet marList = stmt.executeQuery(queryString);
            while (marList.next())
            {
                MAR mar = new MAR();
                mar.setMarID(marList.getString("marnumber"));
                mar.setFacilityName(marList.getString("facilityname"));
                mar.setFacilityType(marList.getString("facilitytype"));
                mar.setUrgency(marList.getString("urgency"));
                mar.setDescription(marList.getString("description"));
                mar.setReportedUser(marList.getString("reportedby"));
                mar.setDate(marList.getString("reporteddate"));
                marListInDB.add(mar);
            }
        }
        catch (SQLException e)
        {
        }
        return marListInDB;
    }
    
    private static void StoreListinDB(MAR mar, String queryString)
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
    
       
    public static void insertMAR(MAR mar)
    {
        StoreListinDB(mar, "INSERT INTO mar (marnumber,reporteddate,facilitytype,facilityname,description,urgency,reportedby) ");
    }
    
    
    public static MAR getSpecificMar(String marid)
    {
        return ReturnMatchingMARList(String.format(
                "SELECT * FROM mar WHERE marnumber='%s'", marid)).get(0);
    }
    
    public static ArrayList<MAR> listMarsReportedBy(String userString)
    {
        return ReturnMatchingMARList(String.format("SELECT * FROM mar WHERE reportedby='%s' ORDER BY marnumber", userString));
    }
    
    public static ArrayList<MAR> listMarsWithFacilityNameAndUsername(
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
    
    public static ArrayList<MAR> listMARs()
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE assignedto IS NULL ORDER BY marnumber");
    }
    
    // search companies
    public static ArrayList<MAR> searchMARByNumber(String marnumber)
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE marnumber LIKE '%" + marnumber + "%' AND assignedto IS NULL ORDER BY marnumber");
    }
    

    
    public static ArrayList<MAR> searchMARByFacilityName(String facilityName)
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE facilityname LIKE '%" + facilityName + "%' AND assignedto IS NULL ORDER BY marnumber");
    }
    
    
    // determine if companyID is unique
//    public static Boolean marIDunique(String marnumber)
//    {
//        return (ReturnMatchingMARList(" SELECT * from mar WHERE marnumber = '" + marnumber + "' ORDER BY marnumber").isEmpty());
//    }
//    
    
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
