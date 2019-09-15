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
				res.setDate(reservedList.getString("scheduleDate"));
				res.setMarnum(reservedList.getString("marnumber"));
				res.setFacilitytype(reservedList.getString("facilitytype"));
				res.setFacilityname(reservedList.getString("facilityname"));
				res.setTo(reservedList.getString("to"));
				res.setFrom(reservedList.getString("from"));
				//res.setPhone(reservedList.getString("phone"));
				//res.setEmail(reservedList.getString("email"));  
				reservedListInDB.add(res);	
			}
		} catch (SQLException e) {}
		return reservedListInDB;
	}
	

	//************************************************8
	public static ArrayList<RepairerViewAssigned>  listReservedRepairs() {  
			return ReturnReservedList("SELECT r.scheduleDate, m.marnumber, m.facilitytype, m.facilityname, f.to, f.from FROM repairschedule r, mar m, facilityreservation f WHERE r.mar = m.marnumber AND r.mar = r.mar AND r.username = \"David\"");
	}
	
	//search company with company ID
	//***************************************************8
	public static ArrayList<RepairerViewAssigned>   searchReservedRepair (String idMarnum)  {  
			return ReturnReservedList(" SELECT r.scheduleDate, m.marnumber, m.facilitytype, m.facilityname, f.to, f.from FROM repairschedule r, mar m, facilityreservation f WHERE r.mar = m.marnumber AND r.mar = r.mar AND r.username = \"David\" AND m.marnumber = '"+idMarnum+"'");
	}
}