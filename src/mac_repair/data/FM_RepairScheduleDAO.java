package mac_repair.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.FM_EstimateOfRepair;
import mac_repair.model.FM_Facility;
import mac_repair.model.FM_MAR;
import mac_repair.model.FM_RepairSchedule;
import mac_repair.model.FM_Repairers;
public class FM_RepairScheduleDAO {



	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<FM_RepairSchedule> ReturnRepairScheduleList (String queryString) {
		ArrayList<FM_RepairSchedule> repairScheduleInDB = new ArrayList<FM_RepairSchedule>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet repairScheudleList = stmt.executeQuery(queryString);
			while (repairScheudleList.next()) {
				FM_RepairSchedule repairSchedule = new FM_RepairSchedule(); 
				repairSchedule.setUsername(repairScheudleList.getString("username"));
				repairSchedule.setMarID(repairScheudleList.getString("mar"));
				repairSchedule.setScheduleDate(repairScheudleList.getString("scheduledate"));

				repairScheduleInDB.add(repairSchedule);	
			}
		} catch (SQLException e) {}
		return repairScheduleInDB;
	}
	

	private static void StoreListinDB (FM_RepairSchedule repSchedule,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		Date assignedDate = FM_UtilityDAO.mysqlDateassignmar(repSchedule.getScheduleDate());
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
		
	
	public static void insertRepairSchedule(FM_RepairSchedule repSchedule) {  
		StoreListinDB(repSchedule,"INSERT INTO repairSchedule (username,mar,scheduleDate) ");
	} 

	public static ArrayList<FM_RepairSchedule>  listRepairSchedule() {  
			return ReturnRepairScheduleList(" SELECT * from repairSchedule ORDER BY username");
	}
	
	//search companies
	public static ArrayList<FM_RepairSchedule>  searchScheduleByUser(String username)  {  
			return ReturnRepairScheduleList(" SELECT * from repairSchedule WHERE username LIKE '%"+username+"%' ORDER BY username");
	}
	
	public static ArrayList<FM_RepairSchedule>  searchScheduleByMAR(String marnumber)  {  
		return ReturnRepairScheduleList(" SELECT * from repairSchedule WHERE mar LIKE '%"+marnumber+"%' ORDER BY username");
}

	public static boolean  validRepairSchedule(String username, Date assignedDate)  {  
		String assignedDateStr = assignedDate.toString();
		Date assignedEndDate= new Date( assignedDate.getTime() + 7*24*60*60*1000);
		String assignedEndDateStr = assignedEndDate.toString();
		String QueryString1 = "SELECT * FROM repairSchedule WHERE username = '"+username+ "' AND scheduleDate = '" + assignedDateStr+"'";

		String QueryString2 = "SELECT * FROM repairSchedule WHERE username = '"+username+ "' AND scheduleDate >= '" + assignedDateStr + "'  AND scheduleDate < '" + assignedEndDateStr+ "'"; 

		ArrayList<FM_RepairSchedule> repairToday = ReturnRepairScheduleList(QueryString1);
		ArrayList<FM_RepairSchedule> reapairweekly= ReturnRepairScheduleList(QueryString2);
		if(repairToday.size()>=3) return true;
		if(repairToday.size()>=7) return true;
		return false;
	}


	//determine if companyID is unique

}
