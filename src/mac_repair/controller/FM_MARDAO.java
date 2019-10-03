package mac_repair.data;

import java.sql.Connection;
import java.sql.Date;
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
                mar.setDate(marList.getString("reporteddate"));
                marListInDB.add(mar);
            }
        }
        catch (SQLException e)
        {
        }
        return marListInDB;
    }
    
	private static void StoreListinDB (FM_MAR assignmar,String queryString) {
		Statement stmt = null;
//		Date assignedDate = FM_UtilityDAO.mysqlDate(assignmar.getAssignedDate());
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = queryString + " VALUES ('"  
					+ assignmar.getMarID()  + "','"	
					+ assignmar.getDate()  + "','"	
					+ assignmar.getFacilityType()  + "','"	
					+ assignmar.getFacilityName()  + "','"	
					+ assignmar.getDescription()  + "','"	
					+ assignmar.getUrgency()  + "','"	
					+ assignmar.getReportedUser() + "')";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
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
		StoreListinDB(mar,"INSERT INTO mar (marnumber,reporteddate,facilitytype,facilityname,description,urgency,reportedby) ");
    }
    
    public static ArrayList<FM_MAR> listMARs()
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE reporteddate = CURDATE() AND assignedto IS NULL ORDER BY marnumber");
    }
    
    // search companies
    public static ArrayList<FM_MAR> searchMARByNumber(String marnumber)
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE marnumber LIKE '%" + marnumber + "%' AND assignedto IS NULL ORDER BY marnumber");
    }
    
    public static ArrayList<FM_MAR> searchMARByFacilityType(String facilitytype)
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE facilitytype LIKE '%" + facilitytype + "%' AND assignedto IS NULL ORDER BY marnumber");
    }
    
    public static ArrayList<FM_MAR> searchMARByFacilityName(String facilityName)
    {
        return ReturnMatchingMARList(" SELECT * from mar WHERE facilityname LIKE '%" + facilityName + "%' AND assignedto IS NULL ORDER BY marnumber");
    }
    
    
    // determine if companyID is unique
    public static Boolean marIDunique(String marnumber)
    {
        return (ReturnMatchingMARList(" SELECT * from mar WHERE marnumber = '" + marnumber + "' ORDER BY marnumber").isEmpty());
    }
}
