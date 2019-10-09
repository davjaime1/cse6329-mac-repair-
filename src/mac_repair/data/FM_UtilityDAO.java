package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import mac_repair.model.FM_Duration;
import mac_repair.model.FM_EstimateOfRepair;
import mac_repair.model.FM_FacilityType;
import mac_repair.model.FM_Repairers;
import mac_repair.model.FM_TimeInterval;
import mac_repair.model.FM_Urgency;
import mac_repair.model.FM_Venue;
import mac_repair.util.SQLConnection;
import mac_repair.model.State;

public class FM_UtilityDAO {
	public static ArrayList<FM_Repairers>  listRepairers()  {  
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");

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

	private static ArrayList<FM_Repairers> ReturnMatchingRepaierList(String queryString) {
		// TODO Auto-generated method stub
		ArrayList<FM_Repairers> repairListInDB = new ArrayList<FM_Repairers>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet repairList = stmt.executeQuery(queryString);
			while (repairList.next()) {
				FM_Repairers repairer = new FM_Repairers(); 
				repairer.setUsername(repairList.getString("username"));
				repairListInDB.add(repairer);	
			}
		} catch (SQLException e) {}
		return repairListInDB;
	}
	public static ArrayList<FM_EstimateOfRepair>  listEstimateTimes()  {  
		return ReturnMatchingEstimateTimeList(" SELECT * from estimateofrepair ORDER BY id");
	}


	private static ArrayList<FM_EstimateOfRepair> ReturnMatchingEstimateTimeList(String queryString) {
		// TODO Auto-generated method stub
		ArrayList<FM_EstimateOfRepair> estimateRepairListInDB = new ArrayList<FM_EstimateOfRepair>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet estimateTimeList = stmt.executeQuery(queryString);
			while (estimateTimeList.next()) {
				FM_EstimateOfRepair estimateTime = new FM_EstimateOfRepair(); 
				estimateTime.setId(estimateTimeList.getString("id"));
				estimateTime.setRepairTime(estimateTimeList.getString("repairtime"));
				estimateRepairListInDB.add(estimateTime);	
			}
		} catch (SQLException e) {}
		return estimateRepairListInDB;
	}
	
	private static ArrayList<FM_FacilityType> ReturnMatchingFacilityTypeList (String queryString) {
		ArrayList<FM_FacilityType> facilityTypeListInDB = new ArrayList<FM_FacilityType>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet facilityTypeList = stmt.executeQuery(queryString);
			while (facilityTypeList.next()) {
				FM_FacilityType facilityType = new FM_FacilityType(); 
				facilityType.setId(facilityTypeList.getString("id"));
				facilityType.setFacilityType(facilityTypeList.getString("name"));

				facilityTypeListInDB.add(facilityType);	
			}
		} catch (SQLException e) {}
		return facilityTypeListInDB;
	}
	
	private static ArrayList<FM_TimeInterval> ReturnMatchingTimeIntervalList (String queryString) {
		ArrayList<FM_TimeInterval> timeIntervalListInDB = new ArrayList<FM_TimeInterval>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet timeIntervalList = stmt.executeQuery(queryString);
			while (timeIntervalList.next()) {
				FM_TimeInterval timeInterval = new FM_TimeInterval(); 
				timeInterval.setId(timeIntervalList.getString("id"));
				timeInterval.setTimeInterval(timeIntervalList.getString("name"));

				timeIntervalListInDB.add(timeInterval);	
			}
		} catch (SQLException e) {}
		return timeIntervalListInDB;
	}
	
	private static ArrayList<FM_Venue> ReturnMatchingVenueList (String queryString) {
		ArrayList<FM_Venue> venueListInDB = new ArrayList<FM_Venue>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet venueList = stmt.executeQuery(queryString);
			while (venueList.next()) {
				FM_Venue venue = new FM_Venue(); 
				venue.setId(venueList.getString("id"));
				venue.setVenue(venueList.getString("name"));

				venueListInDB.add(venue);	
			}
		} catch (SQLException e) {}
		return venueListInDB;
	}
	
	private static ArrayList<FM_Duration> ReturnMatchingDurationList (String queryString) {
		ArrayList<FM_Duration> durationListInDB = new ArrayList<FM_Duration>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet durationList = stmt.executeQuery(queryString);
			while (durationList.next()) {
				FM_Duration duration = new FM_Duration(); 
				duration.setId(durationList.getString("id"));
				duration.setDuration(durationList.getString("name"));

				durationListInDB.add(duration);	
			}
		} catch (SQLException e) {}
		return durationListInDB;
	}
	
	public static ArrayList<FM_FacilityType>  listFacilityTypes()  {  
		return ReturnMatchingFacilityTypeList(" SELECT * from facilitytypes ORDER BY id");
	}

	public static ArrayList<FM_TimeInterval>  listTimeTimeIntervals()  {  
		return ReturnMatchingTimeIntervalList(" SELECT * from intervals ORDER BY id");
	}
	public static ArrayList<FM_Duration>  listDuration()  {  
		return ReturnMatchingDurationList(" SELECT * from durations ORDER BY id");
	}
	public static ArrayList<FM_Venue>  listVenues()  {  
		return ReturnMatchingVenueList(" SELECT * from venues ORDER BY id");
	}
	public static ArrayList<FM_Urgency>  listUrgencies()  {  
		return ReturnMatchingUrgencyList(" SELECT * from urgency ORDER BY id");
	}


	private static ArrayList<FM_Urgency> ReturnMatchingUrgencyList(String queryString) {
		// TODO Auto-generated method stub
		ArrayList<FM_Urgency> urgencyListInDB = new ArrayList<FM_Urgency>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet urgencyList = stmt.executeQuery(queryString);
			while ( urgencyList.next()) {
				FM_Urgency urgency = new FM_Urgency(); 
				urgency.setId( urgencyList.getString("id"));
				urgency.setUrgency( urgencyList.getString("urgency"));

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
