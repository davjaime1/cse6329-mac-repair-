package mac_repair.data;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
//import mac_repair.model.FM_MAR;
import mac_repair.model.MAR;
public class FM_AssignMARDAO {



	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<MAR> ReturnMatchingAssignedMARList (String queryString) {
		ArrayList<MAR> assignedmarListInDB = new ArrayList<MAR>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet assignedmarList = stmt.executeQuery(queryString);
			while (assignedmarList.next()) {
				MAR assignedmar = new MAR(); 
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
	

	public static void UpdateinDB (MAR mar) {
		Statement stmt = null;
		Date assignedDate = UtilityDAO.mysqlDateassignmar(mar.getAssignedDate());
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

	public static void insertAssignedMAR(MAR mar) {  
		UpdateinDB(mar);
		//StoreListinDB(mar,"INSERT INTO mar (marnumber,reporteddate,facilitytype,facilityname,description,urgency,reportedby,assignedto,assignedDate,estimateofrepair) ");
	} 
	
	public static ArrayList<MAR>  listAssignedMARs() {  
			return ReturnMatchingAssignedMARList(" SELECT * from mar WHERE assignedto IS NOT NULL ORDER BY marnumber");
	}
	
	//search companies
	public static ArrayList<MAR>  searchMARByNumber(String marnumber)  {  
			return ReturnMatchingAssignedMARList(" SELECT * from mar WHERE marnumber LIKE '%"+marnumber+"%' ORDER BY marnumber");
	}
//	public static ArrayList<FM_MAR>  searchMARByFacilityType(String facilitytype)  {  
//		return ReturnMatchingAssignedMARList(" SELECT * from mar WHERE facilitytype LIKE '%"+facilitytype+"%' ORDER BY marnumber");
//	}
	public static ArrayList<MAR>  searchMARByFacilityName(String facilityName)  {  
		return ReturnMatchingAssignedMARList(" SELECT * from mar WHERE facilityname LIKE '%"+facilityName+"%' ORDER BY marnumber");
	}

	
	public static void addRepairList(String mar, String date, String rep)
	{
		Statement stmt = null;
		String queryString = "INSERT INTO `repairschedule` VALUES ('" + rep + "', '" + mar + "' , '" + date + "')";
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(queryString);	
			conn.commit(); 
		} catch (SQLException e) {System.out.println("Could not add");}
	}
	

	//determine if companyID is unique
//	public static Boolean marIDunique(String marnumber)  {  
//			return (ReturnMatchingAssignedMARList(" SELECT * from mar WHERE marnumber = '"+marnumber+"' ORDER BY assignedmar").isEmpty());
//	}
}
