package mac_repair.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import mac_repair.model.UtilityModel;
import mac_repair.util.SQLConnection;
import mac_repair.model.User;

public class UtilityDAO {
	public static ArrayList<User>  listRepairers()  {  
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

	private static ArrayList<User> ReturnMatchingRepaierList(String queryString) {
		// TODO Auto-generated method stub
		ArrayList<User> repairListInDB = new ArrayList<User>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet userList = stmt.executeQuery(queryString);
			while (userList.next()) {
	               User user = new User();
	                user.setUsername(userList.getString("username"));
	                user.setId(userList.getString("id"));
	                user.setFirstName(userList.getString("firstname"));
	                user.setLastName(userList.getString("lastname"));
	                user.setPassword(userList.getString("password"));
	                user.setRole(userList.getString("role"));
	                user.setAddress(userList.getString("address"));
	                user.setCity(userList.getString("city"));
	                user.setState(userList.getString("state"));
	                user.setZip(userList.getString("zip"));
	                user.setPhone(userList.getString("phone"));
	                user.setEmail(userList.getString("email"));
	                
	                //userListInDB.add(user);
	 				repairListInDB.add(user);	
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
	
	public static ArrayList<UtilityModel>  listStates()  {  
		return ReturnMatchingStates(" SELECT * from states ORDER BY id");
	}


	private static ArrayList<UtilityModel> ReturnMatchingStates(String queryString) {
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
				urgency.setValue( urgencyList.getString("name"));

				urgencyListInDB.add(urgency);	
			}
		} catch (SQLException e) {}
		return urgencyListInDB;
	}
	   private static ArrayList<UtilityModel> getMatchingRoleList(String query)
	    {
	        ArrayList<UtilityModel> roleListInDB = new ArrayList<UtilityModel>();
	        
	        Statement stmt = null;
	        Connection conn = SQLConnection.getDBConnection();
	        try
	        {
	            stmt = conn.createStatement();
	            ResultSet roleSet = stmt.executeQuery(query);
	            while (roleSet.next())
	            {
	            	UtilityModel role = new UtilityModel();
	                role.setId(roleSet.getString("id"));
	                role.setValue(roleSet.getString("name"));
	                
	                roleListInDB.add(role);
	            }
	        }
	        catch (SQLException e)
	        {
	            System.out.println("Error in RoleDAO\n" + e.getMessage());
	        }
	        
	        return roleListInDB;
	    }
	    
	    
	    public static ArrayList<UtilityModel> listRoleWithId(String id)
	    {
	        return getMatchingRoleList(String.format(
	                "SELECT * from roles WHERE id='%s'", id));
	    }
	    
	    public static ArrayList<UtilityModel> listRoles()
	    {
	        return getMatchingRoleList("SELECT * from roles ORDER BY id");
	    }

}
