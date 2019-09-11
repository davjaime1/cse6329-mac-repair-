package mac_repair.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.MAR;


public class MARDAO {


	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<MAR> ReturnMatchingCompaniesList (String queryString) {
		ArrayList<MAR> marListInDB = new ArrayList<MAR>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet marList = stmt.executeQuery(queryString);
			while (marList.next()) {
				MAR mar = new MAR(); 
				mar.setMarID(marList.getString("marnumber"));
				mar.setFacilityName(marList.getString("facilitytype"));
				mar.setFacilityType(marList.getString("facilityname"));
				mar.setUrgency(marList.getString("urgency"));  
				mar.setDescription(marList.getString("description"));  
				mar.setReportedUser(marList.getString("reportedby"));  
				mar.setDate(marList.getString("date"));  
				marListInDB.add(mar);	
			}
		} catch (SQLException e) {}
		return marListInDB;
	}
	
	private static void StoreListinDB (MAR mar,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = queryString + " VALUES ('"  
					+ mar.getMarID()  + "','"
					+ "CURDATE()" + "','"		
					+ mar.getFacilityType() + "','"
					+ mar.getFacilityName() + "',"
					+ mar.getDescription() + "',"
					+ mar.getUrgency() + "',"
					+ mar.getReportedUser() + ")";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}
	
	
	private static void UpdateinDB (MAR mar) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = "UPDATE mar " + " SET "
					+ "description = "+ mar.getDescription() + ","
					+ "urgency = "+ mar.getUrgency()  + " WHERE marnumber = " + mar.getMarID();
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}

	
	public static void insertMAR(MAR mar) {  
		StoreListinDB(mar,"INSERT INTO mar (marnumber,date,facilitytype,facilityname,description,urgency,reportedby) ");
	} 
	
	public static ArrayList<MAR>  listMARs() {  
			return ReturnMatchingCompaniesList(" SELECT * from mar WHERe date = CURDATE() ORDER BY marnumber");
	}
	
	//search companies
	public static ArrayList<MAR>  searchMARByNumber(String marnumber)  {  
			return ReturnMatchingCompaniesList(" SELECT * from mar WHERE marnumber LIKE '%"+marnumber+"%' ORDER BY idcompany");
	}
	public static ArrayList<MAR>  searchMARByFacilityType(String facilitytype)  {  
		return ReturnMatchingCompaniesList(" SELECT * from mar WHERE facilityname LIKE '%"+facilitytype+"%' ORDER BY idcompany");
	}
	public static ArrayList<MAR>  searchMARByFacilityName(String facilityName)  {  
		return ReturnMatchingCompaniesList(" SELECT * from mar WHERE facilityname LIKE '%"+facilityName+"%' ORDER BY idcompany");
	}


	//determine if companyID is unique
	public static Boolean marIDunique(String marnumber)  {  
			return (ReturnMatchingCompaniesList(" SELECT * from mar WHERE marnumber = '"+marnumber+"' ORDER BY company_name").isEmpty());
	}
}
