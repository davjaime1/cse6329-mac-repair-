package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.*;

public class FacilityDAO {



	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<Facility> ReturnMatchingFacilityList (String queryString) {
		ArrayList<Facility> facilityListInDB = new ArrayList<Facility>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet facilityList = stmt.executeQuery(queryString);
			while (facilityList.next()) {
				Facility facility = new Facility(); 
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
				facility.setFacilityName(facilityNames.getString("name"));
				facility.setFacilityType(facilityNames.getString("facilitytype"));
				facilityNamesInDB.add(facility);
			}
		} catch (SQLException e) {}
		return facilityNamesInDB;
	}
	
	

	private static void StoreListinDB (Facility mar,String queryString) {
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
	
	
	
	
	public static void insertFacility(Facility mar) {  
		StoreListinDB(mar,"INSERT INTO facilities (name,facilitytype,time_interval,duration,venue) ");
	} 
	
	public static ArrayList<Facility>  listFacilities() {  
			return ReturnMatchingFacilityList(" SELECT * from facilities ORDER BY name");
	}
	
	//search companies
	public static ArrayList<Facility>  searchFacilityByName(String name)  {  
			return ReturnMatchingFacilityList(" SELECT * from facilities WHERE name LIKE '%"+name+"%' ORDER BY name");
	}

	public static ArrayList<Facility>  searchFacilityType(String facilitytype)  {  
		return ReturnMatchingFacilityList(" SELECT * from facilities WHERE facilitytype LIKE '%"+facilitytype+"%' ORDER BY name");
	}
	public static ArrayList<Facility>  getFacilities(String facilitytype)  {  
		return ReturnMatchingFacilityList(" SELECT * from facilities WHERE facilitytype = '"+facilitytype+"' ORDER BY name");
	}

	//determine if companyID is unique
	public static Boolean facilityNameunique(String name)  {  
			return (ReturnMatchingFacilityList(" SELECT * from facilities WHERE name = '"+name+"' ORDER BY name").size())==0;
	}
	
	public static ArrayList<Facility> listFacilitiesNames(){
		return ReturnMatchingFacilityNames(" SELECT name, facilitytype from facilities");

	}

}
