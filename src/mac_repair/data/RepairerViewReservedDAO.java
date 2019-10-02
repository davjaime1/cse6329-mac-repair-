package mac_repair.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.RepairerViewReserved;
public class RepairerViewReservedDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<RepairerViewReserved> ReturnReservedList (String queryString) {
		ArrayList<RepairerViewReserved> reservedListInDB = new ArrayList<RepairerViewReserved>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet reservedList = stmt.executeQuery(queryString);
			while (reservedList.next()) {
				RepairerViewReserved res = new RepairerViewReserved();
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
	public static ArrayList<RepairerViewReserved>  listReservedRepairs(String username) { 
			return ReturnReservedList("SELECT r.scheduleDate, m.marnumber, m.facilitytype, m.facilityname, f.to, f.from FROM repairschedule r, mar m, facilityreservation f WHERE r.mar = m.marnumber AND f.reservedUser = r.username AND m.facilityname = f.facilityname AND r.username = \"" + username + "\"");
	}
	
	//search company with company ID
	//***************************************************8
	public static ArrayList<RepairerViewReserved>   searchReservedRepair (String idMarnum, String username)  {  
			return ReturnReservedList("SELECT r.scheduleDate, m.marnumber, m.facilitytype, m.facilityname, f.to, f.from FROM repairschedule r, mar m, facilityreservation f WHERE r.mar = m.marnumber AND f.reservedUser = r.username AND m.facilityname = f.facilityname AND r.username = \""+ username +"\" AND m.marnumber = \""+idMarnum+"\"");
	}
}