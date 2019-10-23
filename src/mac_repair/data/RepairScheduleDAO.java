package mac_repair.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.MAR;
public class RepairScheduleDAO {



	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<MAR> ReturnRepairScheduleList (String queryString) {
		ArrayList<MAR> repairScheduleInDB = new ArrayList<MAR>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet assignedmarList = stmt.executeQuery(queryString);
			while (assignedmarList.next()) {
				MAR assignedmar = new MAR(); 
				assignedmar.setMarID(assignedmarList.getString("marnumber"));
				assignedmar.setDate(assignedmarList.getString("reporteddate"));
				assignedmar.setFacilityType(assignedmarList.getString("facilitytype"));
				assignedmar.setFacilityName(assignedmarList.getString("facilityname"));  
				assignedmar.setDescription(assignedmarList.getString("description"));  
				assignedmar.setUrgency(assignedmarList.getString("urgency"));  
				assignedmar.setAssignedTo(assignedmarList.getString("assignedto"));  
				assignedmar.setAssignedDate(assignedmarList.getString("assignedDate"));  
				assignedmar.setReportedUser(assignedmarList.getString("reportedby"));  
				assignedmar.setEstimateOfRepair(assignedmarList.getString("estimateofrepair"));  

				repairScheduleInDB.add(assignedmar);	
			}
		} catch (SQLException e) {}
		return repairScheduleInDB;
	}
	

	

	public static ArrayList<MAR>  listRepairSchedule() {  
			return ReturnRepairScheduleList(" SELECT * from mar WHERE assignedto IS NOT NULL AND assignedDate = CURDATE() ORDER BY assignedto");
	}
	
	//search companies
	
	public static ArrayList<MAR>  searchScheduleDate(String date)  {  
		return ReturnRepairScheduleList(" SELECT * from mar WHERE assignedto IS NOT NULL AND assignedDate ='"+date+"' ORDER BY assignedto");
	}

	public static boolean  validRepairSchedule(String username, Date assignedDate)  {  
		String assignedDateStr = assignedDate.toString();
		Date assignedEndDate= new Date( assignedDate.getTime() + 7*24*60*60*1000);
		String assignedEndDateStr = assignedEndDate.toString();
		String QueryString1 = "SELECT * FROM mar WHERE assignedto IS NOT NULL AND assignedto = '"+username+ "' AND assignedDate = '" + assignedDateStr+"'";

		String QueryString2 = "SELECT * FROM mar WHERE assignedto IS NOT NULL AND assignedto = '"+username+ "' AND assignedDate >= '" + assignedDateStr + "'  AND assignedDate < '" + assignedEndDateStr+ "'"; 

		ArrayList<MAR> repairToday = ReturnRepairScheduleList(QueryString1);
		ArrayList<MAR> reapairweekly= ReturnRepairScheduleList(QueryString2);
		if(repairToday.size()>=5) return true;
		if(reapairweekly.size()>=7) return true;
		return false;
	}


	//determine if companyID is unique

}
