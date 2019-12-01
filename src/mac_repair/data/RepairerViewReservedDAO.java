package mac_repair.data;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import mac_repair.util.SQLConnection;
import mac_repair.model.RepairerViewReserved;
import mac_repair.model.MAR;
import mac_repair.model.FreeReservations;
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

				res.setDate(reservedList.getString("date"));
				res.setMarnum(reservedList.getString("mar"));
				res.setFacilitytype(reservedList.getString("facilitytype"));
				res.setFacilityname(reservedList.getString("facilityname"));
				res.setTo(reservedList.getString("to").substring(0,19));
				res.setFrom(reservedList.getString("from").substring(0,19)); 
				reservedListInDB.add(res);	
			}
		} catch (SQLException e) {}
		return reservedListInDB;
	}
	
	private static ArrayList<RepairerViewReserved> ReturnReservedList2 (String queryString) {
		ArrayList<RepairerViewReserved> reservedListInDB = new ArrayList<RepairerViewReserved>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet reservedList = stmt.executeQuery(queryString);
			while (reservedList.next()) {
				RepairerViewReserved res = new RepairerViewReserved();

				res.setDate(reservedList.getString("date"));
				res.setMarnum(reservedList.getString("mar"));
				res.setFacilitytype(reservedList.getString("facilitytype"));
				res.setFacilityname(reservedList.getString("facilityname"));
				res.setTo(reservedList.getString("to").substring(0,19));
				res.setFrom(reservedList.getString("from").substring(0,19)); 
				res.setUser(reservedList.getString("reservedUser"));
				reservedListInDB.add(res);	
			}
		} catch (SQLException e) {}
		return reservedListInDB;
	}
	
	private static ArrayList<FreeReservations> ReturnFreeList (String queryString) {
		ArrayList<FreeReservations> ReservedListInDB = new ArrayList<FreeReservations>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet ReservedList = stmt.executeQuery(queryString);
			while (ReservedList.next()) {
				FreeReservations res = new FreeReservations();
			
				res.setDate(ReservedList.getString("date"));
				res.setFacilitytype(ReservedList.getString("facilitytype"));
				res.setFacilityname(ReservedList.getString("facilityname"));
				res.setTo(ReservedList.getString("to"));
				res.setFrom(ReservedList.getString("from")); 
				res.setId(ReservedList.getString("reservationid"));
				ReservedListInDB.add(res);	
			}
		} catch (SQLException e) {}
		return ReservedListInDB;
	}
	
	private static void StoreResInDB(String queryString)
    {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            
            stmt.executeUpdate(queryString);
            conn.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Could not insert MAR into database\n" + e.getMessage());
        }
    }
	

	//************************************************8
	public static ArrayList<RepairerViewReserved>  listReservedRepairs(String username) { 
			return ReturnReservedList("SELECT f.date, f.facilityname, f.facilitytype, f.date, f.to, f.from, r.mar FROM facilityreservation f, repairschedule r WHERE f.reservedUser = \"" + username + "\" AND r.username = \"" + username + "\" AND f.reservationid = r.mar");
	}
	
	//search company with company ID
	//***************************************************
	public static ArrayList<RepairerViewReserved>   searchReservedRepair (String mar, String username)  {  
			return ReturnReservedList2("SELECT f.date, f.facilityname, f.facilitytype, f.date, f.to, f.from, r.mar, f.reservedUser FROM facilityreservation f, repairschedule r WHERE f.reservedUser = \"" + username + "\" AND r.username = \"" + username + "\" AND f.reservationid = \"" + mar + "\" AND r.mar = \"" + mar+ "\"");
	}
	
	public static ArrayList<FreeReservations> ReservedListInDB(String name, String date)
	{
		return ReturnFreeList("SELECT f.facilityname, f.facilitytype, f.date, f.to, f.from, f.reservationid FROM facilityreservation f WHERE f.date = \"" + date +"\" AND f.facilityname = \"" + name + "\"");
	}
	
	public static ArrayList<FreeReservations> IdDB(String name, String date, String username)
	{
		return ReturnFreeList("SELECT f.facilityname, f.facilitytype, f.date, f.to, f.from, f.reservationid FROM facilityreservation f");
	}
	
	
	public static ArrayList<FreeReservations> makePossibleFreeList(String name, String date)
	{
		String name_no_num = name.replaceAll("[0-9]","");
		ArrayList<FreeReservations> possFreeList = new ArrayList<FreeReservations>();
		if(name_no_num.equals("CR")||name_no_num.equals("MR")||name_no_num.equals("IBBC")||name_no_num.equals("IVBC"))
		{
			String fromHour = "06";
			String fromMin = "00";
			String toHour = "06";
			String toMin = "59";
			
			for(int i = 0; i < 18; i++)
			{
				FreeReservations res = new FreeReservations();
				
				res.setDate(date);
				res.setFacilitytype(name);
				res.setFacilityname(name_no_num);
				res.setTo(date + " " + toHour + ":" + toMin + ":59");
				res.setFrom(date + " " + fromHour + ":" + fromMin + ":00");
				res.setVenue("I");
				
				possFreeList.add(res);
				if(Integer.parseInt(fromHour)+1 < 10)
				{
					fromHour = "0" + Integer.toString(Integer.parseInt(fromHour)+1);
				}
				else
				{
					fromHour = Integer.toString(Integer.parseInt(fromHour)+1);
				}
				if(Integer.parseInt(toHour)+1 < 10)
				{
					toHour = "0" + Integer.toString(Integer.parseInt(toHour)+1);
				}
				else
				{
					toHour = Integer.toString(Integer.parseInt(toHour)+1);
				}
			}
		}
		else if(name_no_num.equals("SCG"))
		{
			String fromHour = "06";
			String fromMin = "00";
			String toHour = "07";
			String toMin = "59";
			
			for(int i = 0; i < 9; i++)
			{
				FreeReservations res = new FreeReservations();
				
				res.setDate(date);
				res.setFacilitytype(name);
				res.setFacilityname(name_no_num);
				res.setTo(date + " " + toHour + ":" + toMin + ":59");
				res.setFrom(date + " " + fromHour + ":" + fromMin + ":00");
				res.setVenue("I");
				
				possFreeList.add(res);
				fromHour = Integer.toString(Integer.parseInt(fromHour)+2);
				toHour = Integer.toString(Integer.parseInt(toHour)+2);
				
			}
		}
		else if(name_no_num.equals("OVBC")||name_no_num.equals("OBBC"))
		{
			String fromHour = "06";
			String fromMin = "00";
			String toHour = "07";
			String toMin = "59";
			for(int j = 0; j < 7; j++)
			{
				for(int i = 0; i < 9; i++)
				{
					FreeReservations res = new FreeReservations();
					
					res.setDate(date);
					res.setFacilitytype(name);
					res.setFacilityname(name_no_num);
					res.setTo(date + " " + toHour + ":" + toMin + ":59");
					res.setFrom(date + " " + fromHour + ":" + fromMin + ":00");
					res.setVenue("O");
					
					possFreeList.add(res);
					if(Integer.parseInt(fromHour)+2 < 10)
					{
						fromHour = "0" + Integer.toString(Integer.parseInt(fromHour)+2);
					}
					else
					{
						fromHour = Integer.toString(Integer.parseInt(fromHour)+2);
					}
					if(Integer.parseInt(toHour)+2 < 10)
					{
						toHour = "0" + Integer.toString(Integer.parseInt(toHour)+2);
					}
					else
					{
						toHour = Integer.toString(Integer.parseInt(toHour)+2);
					}
				}
				int intDate = Integer.parseInt(date.substring(8));
				date = date.substring(0,8);
				intDate++;
				if(intDate < 10)
				{
					date = date + "0" + Integer.toString(intDate);
				}
				else
				{
					date = date + Integer.toString(intDate);
				}
				fromHour = "6";
				fromMin = "00";
				toHour = "7";
				toMin = "59";
			}
		}
		else
		{
			String fromHour = "06";
			String fromMin = "00";
			String toHour = "06";
			String toMin = "29";
			
			for(int i = 0; i < 36; i++)
			{
				FreeReservations res = new FreeReservations();
				
				res.setDate(date);
				res.setFacilitytype(name);
				res.setFacilityname(name_no_num);
				res.setTo(date + " " + toHour + ":" + toMin + ":59");
				res.setFrom(date + " " + fromHour + ":" + fromMin + ":00");
				res.setVenue("I");
				
				possFreeList.add(res);
				
				if(fromMin.equals("00"))
				{
					fromMin = "30";
				}
				else
				{
					fromMin = "00";
					if(Integer.parseInt(fromHour)+1<10)
					{
						fromHour = "0" + Integer.toString(Integer.parseInt(fromHour)+1);
					}
					else
					{
						fromHour = Integer.toString(Integer.parseInt(fromHour)+1);
					}
				}
				
				if(toMin.equals("29"))
				{
					toMin = "59";
				}
				else
				{
					toMin = "29";
					if(Integer.parseInt(toHour)+1 < 10)
					{
						toHour = "0" + Integer.toString(Integer.parseInt(toHour)+1);
					}
					else
					{
						toHour = Integer.toString(Integer.parseInt(toHour)+1);
					}
				}
			}
		}
		
		return possFreeList;

	}
	
	public static ArrayList<FreeReservations> getAvaliableReservations(ArrayList<FreeReservations> possible, ArrayList<FreeReservations> inDB)
	{
		int possibleSize = possible.size();
		int inDBSize = inDB.size();
		for(int i = 0; i < possibleSize; i++)
		{
			for(int j = 0; j < inDBSize; j++)
			{
				if(possible.get(i).getTo().equals(inDB.get(j).getTo().substring(0,19)) && possible.get(i).getFrom().equals(inDB.get(j).getFrom().substring(0,19)))
				{
					if(i == 0)
					{
						possible.remove(i);
						possibleSize--;
						
					}
					else
					{
						possible.remove(i);
						i--;
						possibleSize--;
					}
				}
			}
		}
		return possible;
	}
	
	public static void addReservation(FreeReservations res, String id, String username)
	{
		StoreResInDB("INSERT INTO `facilityreservation` VALUES ( '" + id + "', '" + res.getFacilitytype() + "', '" + res.getFacilityname() + "', '" + res.getVenue() + "', '" + username + "', '" + res.getDate() + "', '" + res.getTo() + "', '" + res.getFrom() + "' );");
	}
	
	public static void cancelReservation(String name, String date, String from, String to)
	{
		Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM facilityreservation  WHERE facilityname = \"" + name + "\" AND date = \""+ date +"\" AND `from` = \"" + from + "\" AND `to` = \""+ to + "\"");
            conn.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Could not remove reservation from database\n" + e.getMessage());
        }
	}
	
	public static boolean canMakeRes(String mar, String username)
	{
		ArrayList<RepairerViewReserved> list = new ArrayList<RepairerViewReserved>();
		list = ReturnReservedList("SELECT f.date, f.facilityname, f.facilitytype, f.date, f.to, f.from, r.mar FROM facilityreservation f, repairschedule r WHERE f.reservedUser = \"" + username + "\" AND r.username = \"" + username + "\" AND f.reservationid = \"" + mar + "\" AND r.mar = \"" + mar+ "\"");
		if(list.size()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static void cancelModReservation(String mar)
	{
		Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            
            stmt.executeUpdate("DELETE FROM `facilityreservation`  WHERE reservationid = \"" + mar + "\"");
            conn.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Could not remove reservation from database\n" + e.getMessage());
        }
	}
}