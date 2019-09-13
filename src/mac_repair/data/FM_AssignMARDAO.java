package mac_repair.data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.FM_AssignMAR;
import mac_repair.model.FM_EstimateOfRepair;
import mac_repair.model.FM_MAR;
import mac_repair.model.FM_Repairers;
public class FM_AssignMARDAO {



	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<FM_AssignMAR> ReturnMatchingAssignedMARList (String queryString) {
		ArrayList<FM_AssignMAR> assignedmarListInDB = new ArrayList<FM_AssignMAR>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet assignedmarList = stmt.executeQuery(queryString);
			while (assignedmarList.next()) {
				FM_AssignMAR assignedmar = new FM_AssignMAR(); 
				assignedmar.setMarID(assignedmarList.getString("assignedmar"));
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
	
	private static void StoreListinDB (FM_AssignMAR assignmar,String queryString) {
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
	
	

	public static void UpdateinDB (FM_AssignMAR mar) {
		Statement stmt = null;
		Date assignedDate = FM_UtilityDAO.mysqlDate(mar.getAssignedDate());
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = "UPDATE assignedmar SET description = '"+ mar.getDescription()+ "',"
					+ "urgency = '"+ mar.getUrgency() 
					+ "', " + "assignedto = '"+ mar.getAssignedTo() 
					+ "', " + "assignedDate = '"+ assignedDate.toString() 
					+ "', " +" estimateofrepair = '"+ mar.getEstimateOfRepair()  + "' WHERE assignedmar = '" + mar.getMarID()+ "'";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}

	public static void insertAssignedMAR(FM_AssignMAR mar) {  
		StoreListinDB(mar,"INSERT INTO assignedmar (assignedmar,reporteddate,facilitytype,facilityname,description,urgency,reportedby,assignedto,assignedDate,estimateofrepair) ");
	} 
	
	public static ArrayList<FM_AssignMAR>  listAssignedMARs() {  
			return ReturnMatchingAssignedMARList(" SELECT * from assignedmar WHERE assigneddate >= CURDATE() ORDER BY assignedmar");
	}
	
	//search companies
	public static ArrayList<FM_AssignMAR>  searchMARByNumber(String marnumber)  {  
			return ReturnMatchingAssignedMARList(" SELECT * from assignedmar WHERE assignedmar LIKE '%"+marnumber+"%' ORDER BY assignedmar");
	}
	public static ArrayList<FM_AssignMAR>  searchMARByFacilityType(String facilitytype)  {  
		return ReturnMatchingAssignedMARList(" SELECT * from assignedmar WHERE facilitytype LIKE '%"+facilitytype+"%' ORDER BY assignedmar");
	}
	public static ArrayList<FM_AssignMAR>  searchMARByFacilityName(String facilityName)  {  
		return ReturnMatchingAssignedMARList(" SELECT * from assignedmar WHERE facilityname LIKE '%"+facilityName+"%' ORDER BY assignedmar");
	}


	//determine if companyID is unique
	public static Boolean marIDunique(String marnumber)  {  
			return (ReturnMatchingAssignedMARList(" SELECT * from assignedmar WHERE assignedmar = '"+marnumber+"' ORDER BY assignedmar").isEmpty());
	}
}
