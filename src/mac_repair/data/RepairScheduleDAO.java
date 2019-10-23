package mac_repair.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.RepairSchedule;
public class RepairScheduleDAO {



	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<RepairSchedule> ReturnRepairScheduleList (String queryString) {
		ArrayList<RepairSchedule> repairScheduleInDB = new ArrayList<RepairSchedule>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet repairScheudleList = stmt.executeQuery(queryString);
			while (repairScheudleList.next()) {
				RepairSchedule repairSchedule = new RepairSchedule(); 
				repairSchedule.setUsername(repairScheudleList.getString("username"));
				repairSchedule.setMarID(repairScheudleList.getString("mar"));
				repairSchedule.setScheduleDate(repairScheudleList.getString("scheduledate"));

				repairScheduleInDB.add(repairSchedule);	
			}
		} catch (SQLException e) {}
		return repairScheduleInDB;
	}
	

	private static void StoreListinDB (RepairSchedule repSchedule,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		Date assignedDate = UtilityDAO.mysqlDateassignmar(repSchedule.getScheduleDate());
		try {
			stmt = conn.createStatement();
			String insertmar = queryString + " VALUES ('"  
					+ repSchedule.getUsername()  + "','"	
					+ repSchedule.getMarID() + "','"
					+ assignedDate.toString() + "')";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}
	
	
	public static void deleteRepairSchedule(String marID) {  
		String queryString ="DELETE FROM repairSchedule WHERE mar = '" + marID+ "'";
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(queryString);	
			conn.commit(); 
		}catch (SQLException e) {}
	
	} 
		
	
	public static void insertRepairSchedule(RepairSchedule repSchedule) {  
		StoreListinDB(repSchedule,"INSERT INTO repairSchedule (username,mar,scheduleDate) ");
	} 

	public static ArrayList<RepairSchedule>  listRepairSchedule() {  
			return ReturnRepairScheduleList(" SELECT * from repairSchedule WHERE scheduleDate= CURDATE() ORDER BY username");
	}
	
	//search companies
	public static ArrayList<RepairSchedule>  searchScheduleByUser(String username)  {  
			return ReturnRepairScheduleList(" SELECT * from repairSchedule WHERE username LIKE '%"+username+"%' ORDER BY username");
	}
	
	public static ArrayList<RepairSchedule>  searchScheduleDate(String date)  {  
		return ReturnRepairScheduleList(" SELECT * from repairSchedule WHERE scheduleDate='"+date+"' ORDER BY username");
}

	public static boolean  validRepairSchedule(String username, Date assignedDate)  {  
		String assignedDateStr = assignedDate.toString();
		Date assignedEndDate= new Date( assignedDate.getTime() + 7*24*60*60*1000);
		String assignedEndDateStr = assignedEndDate.toString();
		String QueryString1 = "SELECT * FROM repairSchedule WHERE username = '"+username+ "' AND scheduleDate = '" + assignedDateStr+"'";

		String QueryString2 = "SELECT * FROM repairSchedule WHERE username = '"+username+ "' AND scheduleDate >= '" + assignedDateStr + "'  AND scheduleDate < '" + assignedEndDateStr+ "'"; 

		ArrayList<RepairSchedule> repairToday = ReturnRepairScheduleList(QueryString1);
		ArrayList<RepairSchedule> reapairweekly= ReturnRepairScheduleList(QueryString2);
		if(repairToday.size()>=3) return true;
		if(repairToday.size()>=7) return true;
		return false;
	}


	//determine if companyID is unique

}
