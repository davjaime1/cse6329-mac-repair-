package mac_repair.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.RepairerViewAssigned;
public class RepairerViewAssignedDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<RepairerViewAssigned> ReturnReservedList (String queryString) {
		ArrayList<RepairerViewAssigned> reservedListInDB = new ArrayList<RepairerViewAssigned>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet reservedList = stmt.executeQuery(queryString);
			while (reservedList.next()) {
				RepairerViewAssigned res = new RepairerViewAssigned();
				//java.sql.Timestamp dbSqlTimestamp = reservedList.getTimestamp(1);
				//res.setDate(dbSqlTimestamp);
				res.setAssignedmar(reservedList.getString("marnumber"));
				res.setFacilityname(reservedList.getString("facilityname"));
				res.setFacilitytype(reservedList.getString("facilitytype"));
				res.setUrgency(reservedList.getString("urgency"));
				res.setDescription(reservedList.getString("description"));
				res.setReporteddate(reservedList.getString("reporteddate"));
				res.setReportedby(reservedList.getString("reportedby"));
				res.setAssignedDate(reservedList.getString("assignedDate"));
				res.setEstimateofrepair(reservedList.getString("estimateofrepair"));
				//res.setPhone(reservedList.getString("phone"));
				//res.setEmail(reservedList.getString("email"));  
				reservedListInDB.add(res);	
			}
		} catch (SQLException e) {}
		return reservedListInDB;
	}
	

	//************************************************8
	public static ArrayList<RepairerViewAssigned>  listAssignedRepairs(String username) { 
			return ReturnReservedList("SELECT a.marnumber, a.facilityname, a.facilitytype, a.urgency, a.description, a.reporteddate, a.reportedby, "
					+ "a.assignedDate, a.estimateofrepair FROM mar a WHERE a.assignedTo = \"" + username + "\"");
	}
	
	//search company with company ID
	//***************************************************8
	public static ArrayList<RepairerViewAssigned>   searchAssignedRepair (String idMarnum, String username)  {  
			return ReturnReservedList("SELECT a.marnumber, a.facilityname, a.facilitytype, a.urgency, a.description, a.reporteddate, a.reportedby,"
					+ " a.assignedDate, a.estimateofrepair FROM mar a WHERE a.assignedTo = \"" + username + "\" AND a.marnumber = \""+idMarnum+"\"");
	}
}