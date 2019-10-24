package mac_repair.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.MAR;
public class RepairerViewAssignedDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<MAR> ReturnReservedList (String queryString) {
		ArrayList<MAR> reservedListInDB = new ArrayList<MAR>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet reservedList = stmt.executeQuery(queryString);
			while (reservedList.next()) {
				MAR res = new MAR();
				//java.sql.Timestamp dbSqlTimestamp = reservedList.getTimestamp(1);
				//res.setDate(dbSqlTimestamp);
				res.setMarID(reservedList.getString("marnumber"));
				res.setFacilityName(reservedList.getString("facilityname"));
				res.setFacilityType(reservedList.getString("facilitytype"));
				res.setUrgency(reservedList.getString("urgency"));
				res.setDescription(reservedList.getString("description"));
				res.setDate(reservedList.getString("reporteddate"));
				res.setReportedUser(reservedList.getString("reportedby"));
				res.setAssignedDate(reservedList.getString("assignedDate"));
				res.setEstimateOfRepair(reservedList.getString("estimateofrepair"));
				//res.setPhone(reservedList.getString("phone"));
				//res.setEmail(reservedList.getString("email"));  
				reservedListInDB.add(res);	
			}
		} catch (SQLException e) {}
		return reservedListInDB;
	}
	

	//************************************************8
	public static ArrayList<MAR>  listAssignedRepairs(String username) { 
			return ReturnReservedList("SELECT a.marnumber, a.facilityname, a.facilitytype, a.urgency, a.description, a.reporteddate, a.reportedby, "
					+ "a.assignedDate, a.estimateofrepair FROM mar a WHERE a.assignedTo = \"" + username + "\"");
	}
	
	//search company with company ID
	//***************************************************8
	public static ArrayList<MAR>   searchAssignedRepair (String idMarnum, String username)  {  
			return ReturnReservedList("SELECT a.marnumber, a.facilityname, a.facilitytype, a.urgency, a.description, a.reporteddate, a.reportedby,"
					+ " a.assignedDate, a.estimateofrepair FROM mar a WHERE a.assignedTo = \"" + username + "\" AND a.marnumber = \""+idMarnum+"\"");
	}
}