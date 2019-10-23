package mac_repair.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import mac_repair.model.Repairers;
import mac_repair.model.UtilityModel;
import mac_repair.util.SQLConnection;
import mac_repair.model.State;

public class UtilityDAO {
	public static ArrayList<Repairers>  listRepairers()  {  
		return ReturnMatchingRepaierList(" SELECT * from users WHERE role ='R' ORDER BY username");
	}

	public static Date mysqlDate(String dateString) {
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");

			Date date = new Date(System.currentTimeMillis());
			try {
				java.util.Date utiDate = format.parse(dateString);
				date = new java.sql.Date(utiDate.getTime());
				//System.out.println(date);  
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return date;		
	}
	public static Date mysqlDateassignmar(String dateString) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Date date = new Date(System.currentTimeMillis());
		try {
			java.util.Date utiDate = format.parse(dateString);
			date = new java.sql.Date(utiDate.getTime());
			//System.out.println(date);  
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;		
}

	private static ArrayList<Repairers> ReturnMatchingRepaierList(String queryString) {
		// TODO Auto-generated method stub
		ArrayList<Repairers> repairListInDB = new ArrayList<Repairers>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet repairList = stmt.executeQuery(queryString);
			while (repairList.next()) {
				Repairers repairer = new Repairers(); 
				repairer.setUsername(repairList.getString("username"));
				repairListInDB.add(repairer);	
			}
		} catch (SQLException e) {}
		return repairListInDB;
	}
	public static ArrayList<UtilityModel>  listEstimateTimes()  {  
		return ReturnMatchingEstimateTimeList(" SELECT * from estimateofrepair ORDER BY id");
	}


	private static ArrayList<UtilityModel> ReturnMatchingEstimateTimeList(String queryString) {
		// TODO Auto-generated method stub
		ArrayList<UtilityModel> estimateRepairListInDB = new ArrayList<UtilityModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet estimateTimeList = stmt.executeQuery(queryString);
			while (estimateTimeList.next()) {
				UtilityModel estimateTime = new UtilityModel(); 
				estimateTime.setId(estimateTimeList.getString("id"));
				estimateTime.setValue(estimateTimeList.getString("repairtime"));
				estimateRepairListInDB.add(estimateTime);	
			}
		} catch (SQLException e) {}
		return estimateRepairListInDB;
	}
	
	private static ArrayList<UtilityModel> ReturnMatchingFacilityTypeList (String queryString) {
		ArrayList<UtilityModel> facilityTypeListInDB = new ArrayList<UtilityModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet facilityTypeList = stmt.executeQuery(queryString);
			while (facilityTypeList.next()) {
				UtilityModel facilityType = new UtilityModel(); 
				facilityType.setId(facilityTypeList.getString("id"));
				facilityType.setValue(facilityTypeList.getString("name"));

				facilityTypeListInDB.add(facilityType);	
			}
		} catch (SQLException e) {}
		return facilityTypeListInDB;
	}
	
	private static ArrayList<UtilityModel> ReturnMatchingTimeIntervalList (String queryString) {
		ArrayList<UtilityModel> timeIntervalListInDB = new ArrayList<UtilityModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet timeIntervalList = stmt.executeQuery(queryString);
			while (timeIntervalList.next()) {
				UtilityModel timeInterval = new UtilityModel(); 
				timeInterval.setId(timeIntervalList.getString("id"));
				timeInterval.setValue(timeIntervalList.getString("name"));

				timeIntervalListInDB.add(timeInterval);	
			}
		} catch (SQLException e) {}
		return timeIntervalListInDB;
	}
	
	private static ArrayList<UtilityModel> ReturnMatchingVenueList (String queryString) {
		ArrayList<UtilityModel> venueListInDB = new ArrayList<UtilityModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet venueList = stmt.executeQuery(queryString);
			while (venueList.next()) {
				UtilityModel venue = new UtilityModel(); 
				venue.setId(venueList.getString("id"));
				venue.setValue(venueList.getString("name"));

				venueListInDB.add(venue);	
			}
		} catch (SQLException e) {}
		return venueListInDB;
	}
	
	private static ArrayList<UtilityModel> ReturnMatchingDurationList (String queryString) {
		ArrayList<UtilityModel> durationListInDB = new ArrayList<UtilityModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet durationList = stmt.executeQuery(queryString);
			while (durationList.next()) {
				UtilityModel duration = new UtilityModel(); 
				duration.setId(durationList.getString("id"));
				duration.setValue(durationList.getString("name"));

				durationListInDB.add(duration);	
			}
		} catch (SQLException e) {}
		return durationListInDB;
	}
	
	public static ArrayList<UtilityModel>  listFacilityTypes()  {  
		return ReturnMatchingFacilityTypeList(" SELECT * from facilitytypes ORDER BY id");
	}

	public static ArrayList<UtilityModel>  listTimeTimeIntervals()  {  
		return ReturnMatchingTimeIntervalList(" SELECT * from intervals ORDER BY id");
	}
	public static ArrayList<UtilityModel>  listDuration()  {  
		return ReturnMatchingDurationList(" SELECT * from durations ORDER BY id");
	}
	public static ArrayList<UtilityModel>  listVenues()  {  
		return ReturnMatchingVenueList(" SELECT * from venues ORDER BY id");
	}
	public static ArrayList<UtilityModel>  listUrgencies()  {  
		return ReturnMatchingUrgencyList(" SELECT * from urgency ORDER BY id");
	}


	private static ArrayList<UtilityModel> ReturnMatchingUrgencyList(String queryString) {
		// TODO Auto-generated method stub
		ArrayList<UtilityModel> urgencyListInDB = new ArrayList<UtilityModel>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet urgencyList = stmt.executeQuery(queryString);
			while ( urgencyList.next()) {
				UtilityModel urgency = new UtilityModel(); 
				urgency.setId( urgencyList.getString("id"));
				urgency.setValue(urgencyList.getString("urgency"));

				urgencyListInDB.add(urgency);	
			}
		} catch (SQLException e) {}
		return urgencyListInDB;
	}
	
	public static ArrayList<State>  listStates()  {  
		return ReturnMatchingStates(" SELECT * from states ORDER BY id");
	}


	private static ArrayList<State> ReturnMatchingStates(String queryString) {
		// TODO Auto-generated method stub
		ArrayList<State> urgencyListInDB = new ArrayList<State>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet urgencyList = stmt.executeQuery(queryString);
			while ( urgencyList.next()) {
				State urgency = new State(); 
				urgency.setId( urgencyList.getString("id"));
				urgency.setName( urgencyList.getString("name"));

				urgencyListInDB.add(urgency);	
			}
		} catch (SQLException e) {}
		return urgencyListInDB;
	}
}
