package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_repair.model.AssignedMAR;
import mac_repair.model.MAR;
import mac_repair.util.SQLConnection;

public class AssignedMARDOA {


	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<AssignedMAR> ReturnMatchingCompaniesList (String queryString) {
		ArrayList<AssignedMAR> marListInDB = new ArrayList<AssignedMAR>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet marList = stmt.executeQuery(queryString);
			while (marList.next()) {
				AssignedMAR mar = new AssignedMAR(); 
				mar.setMarID(marList.getString("assignedmar"));
				mar.setFacilityName(marList.getString("facilitytype"));
				mar.setFacilityType(marList.getString("facilityname"));
				mar.setUrgency(marList.getString("urgency"));  
				mar.setDescription(marList.getString("description"));  
				mar.setAssigneddate(marList.getString("assignedto"));  
				mar.setAssignedTo(marList.getString("assignedto"));  
				mar.setEstimateOfRepair(marList.getString("estimateOfRepair"));  
				marListInDB.add(mar);	
			}
		} catch (SQLException e) {}
		return marListInDB;
	}
	
	private static void StoreListinDB (AssignedMAR mar,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = queryString + " VALUES ('"  
					+ mar.getMarID()  + "','"
					+ mar.getFacilityType() + "','"
					+ mar.getFacilityName() + "',"
					+ mar.getDescription() + "',"
					+ mar.getUrgency() + "',"
					+ mar.getAssignedTo() + "',"
					+ mar.getAssigneddate() + "',"
					+ mar.getEstimateOfRepair() + ")";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}
	private static void UpdateinDB (AssignedMAR mar) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = "UPDATE mar " + " SET "
					+ "description = "+ mar.getDescription() + ","
					+ "estimateOfRepair = "+ mar.getEstimateOfRepair() + ","
					+ "assignedto = "+ mar.getAssignedTo() + ","
					+ "assignedDate = "+ mar.getAssigneddate() + ","
					+ "urgency = "+ mar.getUrgency()  + " WHERE assignedmar = " + mar.getMarID();
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}


	public static void insertAssignedMAR(AssignedMAR mar) {  
		StoreListinDB(mar,"INSERT INTO assignedmar (assignedmar,facilitytype,facilityname,description,urgency,assignedto,assignedDate,estimateOfRepair) ");
	} 
	
	public static ArrayList<AssignedMAR>  listAssignedMARs() {  
			return ReturnMatchingCompaniesList(" SELECT * from assignedmar ORDER BY assignedmar");
	}
	
	//search companies
	public static ArrayList<AssignedMAR>  searchAssignedMAR(String assignedmar)  {  
			return ReturnMatchingCompaniesList(" SELECT * from assignedmar WHERE assignedmar LIKE '%"+assignedmar+"%' ORDER BY idcompany");
	}
	
	//determine if companyID is unique
	public static Boolean CompanyIDunique(String assignedmar)  {  
			return (ReturnMatchingCompaniesList(" SELECT * from assignedmar WHERE assignedmar = '"+assignedmar+"' ORDER BY company_name").isEmpty());
	}
	//search company with company ID
	public static ArrayList<AssignedMAR>   searchAMARByFacilityType (String facilitytype)  {  
			return ReturnMatchingCompaniesList(" SELECT * from assignedmar WHERE facilitytype = '"+facilitytype+"' ORDER BY company_name");
	}
	public static ArrayList<AssignedMAR>   searchAMARByFacilityName (String facilityname)  {  
		return ReturnMatchingCompaniesList(" SELECT * from assignedmar WHERE facilityname = '"+facilityname+"' ORDER BY company_name");
    }

	public static ArrayList<AssignedMAR>   searchAMARByAssignedRepairer (String assignedTo)  {  
		return ReturnMatchingCompaniesList(" SELECT * from assignedmar WHERE assignedto = '"+assignedTo+"' ORDER BY company_name");
	}
}
