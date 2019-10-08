package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.*;

public class FM_FacilityDAO {



	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<FM_Facility> ReturnMatchingFacilityList (String queryString) {
		ArrayList<FM_Facility> facilityListInDB = new ArrayList<FM_Facility>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet facilityList = stmt.executeQuery(queryString);
			while (facilityList.next()) {
				FM_Facility facility = new FM_Facility(); 
				facility.setFacilityName(facilityList.getString("name"));
				facility.setFacilityType(facilityList.getString("facilitytype"));
				facility.setTimeInterval(facilityList.getString("time_interval"));  
				facility.setDuration(facilityList.getString("duration"));  
				facility.setVenue(facilityList.getString("venue"));  
				facilityListInDB.add(facility);	
			}
		} catch (SQLException e) {}
		return facilityListInDB;
	}
	
	private static ArrayList<Facility> ReturnMatchingFacilityNames (String queryString) {
		ArrayList<Facility> facilityNamesInDB = new ArrayList<Facility>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet facilityNames = stmt.executeQuery(queryString);
			while (facilityNames.next()) {
				Facility facility = new Facility(); 
				facility.setName(facilityNames.getString("name"));
				facility.setType(facilityNames.getString("facilitytype"));
				facilityNamesInDB.add(facility);
			}
		} catch (SQLException e) {}
		return facilityNamesInDB;
	}
	
	

	private static void StoreListinDB (FM_Facility mar,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = queryString + " VALUES ('"  
					+ mar.getFacilityName()  + "','"	
					+ mar.getFacilityType() + "','"
					+ mar.getTimeInterval() + "','"
					+ mar.getDuration() + "','"
					+ mar.getVenue() + "')";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}
	
	
	
	
	public static void insertFacility(FM_Facility mar) {  
		StoreListinDB(mar,"INSERT INTO facilities (name,facilitytype,time_interval,duration,venue) ");
	} 
	
	public static ArrayList<FM_Facility>  listFacilities() {  
			return ReturnMatchingFacilityList(" SELECT * from facilities ORDER BY name");
	}
	
	//search companies
	public static ArrayList<FM_Facility>  searchFacilityByName(String name)  {  
			return ReturnMatchingFacilityList(" SELECT * from facilities WHERE name LIKE '%"+name+"%' ORDER BY name");
	}

	public static ArrayList<FM_Facility>  searchFacilityType(String facilitytype)  {  
		return ReturnMatchingFacilityList(" SELECT * from facilities WHERE facilitytype LIKE '%"+facilitytype+"%' ORDER BY name");
	}

	//determine if companyID is unique
	public static Boolean facilityNameunique(String name)  {  
			return (ReturnMatchingFacilityList(" SELECT * from facilities WHERE name = '"+name+"' ORDER BY name").isEmpty());
	}
	
	public static ArrayList<Facility> listFacilitiesNames(){
		return ReturnMatchingFacilityNames(" SELECT name, facilitytype from facilities");

	}
}
