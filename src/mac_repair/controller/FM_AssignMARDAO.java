package mac_repair.data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.FM_EstimateOfRepair;
import mac_repair.model.FM_MAR;
import mac_repair.model.FM_Repairers;
public class FM_AssignMARDAO {



	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<FM_MAR> ReturnMatchingAssignedMARList (String queryString) {
		ArrayList<FM_MAR> assignedmarListInDB = new ArrayList<FM_MAR>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet assignedmarList = stmt.executeQuery(queryString);
			while (assignedmarList.next()) {
				FM_MAR assignedmar = new FM_MAR(); 
				assignedmar.setMarID(assignedmarList.getString("marnumber"));
				assignedmar.setDate(assignedmarList.getString("reporteddate"));
				assignedmar.setFacilityType(assignedmarList.getString("facilitytype"));
				assignedmar.setFacilityName(assignedmarList.getString("facilityname"));  
				assignedmar.setDescription(assignedmarList.getString("description"));  
				assignedmar.setUrgency(assignedmarList.getString("urgency"));  
				assignedmar.setAssignedTo(assignedmarList.getString("assignedto"));  
				assignedmar.setAssignedDate(assignedmarList.getString("assignedDate"));  
				assignedmar.setReportedUser(assignedmarList.getString("reportedby"));  
				assignedmar.setEstimateOfRepair(assignedmarList.getString("estimateofrepair"));  
				assignedmarListInDB.add(assignedmar);	
			}
		} catch (SQLException e) {}
		return assignedmarListInDB;
	}
	
	private static void StoreListinDB (FM_MAR assignmar,String queryString) {
		Statement stmt = null;
		Date assignedDate = FM_UtilityDAO.mysqlDate(assignmar.getAssignedDate());
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
					+ assignmar.getReportedUser()  + "','"	
					+ assignmar.getAssignedTo()  + "','"	
					+ assignedDate.toString()  + "','"	
					+ assignmar.getEstimateOfRepair() + "')";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}
	
	

	public static void UpdateinDB (FM_MAR mar) {
		Statement stmt = null;
		Date assignedDate = FM_UtilityDAO.mysqlDate(mar.getAssignedDate());
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = "UPDATE mar SET description = '"+ mar.getDescription()+ "',"
					+ "urgency = '"+ mar.getUrgency() 
					+ "', " + "assignedto = '"+ mar.getAssignedTo() 
					+ "', " + "assignedDate = '"+ assignedDate.toString() 
					+ "', " +" estimateofrepair = '"+ mar.getEstimateOfRepair()  + "' WHERE marnumber = '" + mar.getMarID()+ "'";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}

	public static void insertAssignedMAR(FM_MAR mar) {  
		UpdateinDB(mar);
	} 
	
	public static ArrayList<FM_MAR>  listAssignedMARs() {  
			return ReturnMatchingAssignedMARList(" SELECT * from mar WHERE assigneddate >= CURDATE() AND assignedto IS NOT NULL ORDER BY marnumber");
	}
	
	//search companies
	public static ArrayList<FM_MAR>  searchMARByNumber(String marnumber)  {  
			return ReturnMatchingAssignedMARList(" SELECT * from mar WHERE marnumber LIKE '%"+marnumber+"%' AND assignedto IS NOT NULL ORDER BY marnumber");
	}
	public static ArrayList<FM_MAR>  searchMARByFacilityType(String facilitytype)  {  
		return ReturnMatchingAssignedMARList(" SELECT * from mar WHERE facilitytype LIKE '%"+facilitytype+"%' AND assignedto IS NOT NULL ORDER BY marnumber");
	}
	public static ArrayList<FM_MAR>  searchMARByFacilityName(String facilityName)  {  
		return ReturnMatchingAssignedMARList(" SELECT * from mar WHERE facilityname LIKE '%"+facilityName+"%' AND assignedto IS NOT NULL ORDER BY marnumber");
	}
	public static ArrayList<FM_MAR>  listAssignedMARstoaRepairer(String username)  {  
		return ReturnMatchingAssignedMARList(" SELECT * from mar WHERE assignedto = '"+username+"' AND assignedto IS NOT NULL ORDER BY marnumber");
}
	

	//determine if companyID is unique
	public static Boolean marIDunique(String marnumber)  {  
			return (ReturnMatchingAssignedMARList(" SELECT * from mar WHERE marnumber = '"+marnumber+"' ORDER BY marnumber").isEmpty());
	}
}
