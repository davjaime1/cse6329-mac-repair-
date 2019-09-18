package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_repair.model.User;
import mac_repair.model.UserModel;
import mac_repair.util.SQLConnection;

public class UserModelDAO {
	private static SQLConnection DBMgr = SQLConnection.getInstance();
	private static void StoreListinDB (UserModel user,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertmar = queryString + " VALUES ('"  
					+ user.getUsername()  + "','"	
					+ user.getUtaId()  + "','"	
					+ user.getFirstName() + "','"
					+ user.getLastName() + "','"
					+ user.getPassword() + "','"
					+ user.getRole() + "','"
					+ user.getAddress() + "','"
					+ user.getCity() + "','"
					+ user.getState() + "','"
					+ user.getZip() + "','"
					+ user.getPhone() + "','"
					+ user.getEmail() + "')";
			stmt.executeUpdate(insertmar);	
			conn.commit(); 
		} catch (SQLException e) {}
	}
	
	public static ArrayList<UserModel> returnProfile (String username) 
	{
	 ArrayList<UserModel> fetch_profile= new ArrayList<UserModel>();
	 	
	 UserModel res=new UserModel();	
     Statement stmt = null;
     Connection conn = SQLConnection.getDBConnection();

     String queryString = "SELECT * from users where username = '"+username +"'";
	 
		try {
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(queryString);

			while (resultSet.next()) {
				
		
				
				res.setUsername(resultSet.getString("username"));
				res.setUtaId(resultSet.getString("id"));
				res.setFirstName(resultSet.getString("firstname"));
				res.setLastName(resultSet.getString("lastname"));
				res.setPassword(resultSet.getString("password"));
				res.setRole(resultSet.getString("role"));
				res.setAddress(resultSet.getString("address"));
				res.setState(resultSet.getString("state"));
				res.setCity(resultSet.getString("city"));
				res.setZip(resultSet.getString("zip"));
				res.setPhone(resultSet.getString("phone"));
				res.setEmail(resultSet.getString("email"));
				fetch_profile.add(res);		
				
				
			}
		} catch (SQLException e) {}
		return fetch_profile;
	}
	
	
	public static void insertUser(UserModel user) {  
		StoreListinDB(user,"INSERT INTO users (username,id,firstname,lastname,password,role,address,city,state,zip,phone,email) ");
	} 
    
	public static Boolean userNameunique(String name)  {  
		return (returnProfile(name).isEmpty());
	}
 
}
