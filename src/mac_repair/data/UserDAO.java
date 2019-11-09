package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_repair.model.User;
import mac_repair.util.SQLConnection;

public class UserDAO
{
    private static SQLConnection DBMgr = SQLConnection.getInstance();
    
    
    private static ArrayList<User> getUserListFromQuery(String queryString)
    {
        ArrayList<User> userListInDB = new ArrayList<User>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            ResultSet userList = stmt.executeQuery(queryString);
            while (userList.next())
            {
                User user = new User();
                user.setUsername(userList.getString("username"));
                user.setId(userList.getString("id"));
                user.setFirstname(userList.getString("firstname"));
                user.setLastname(userList.getString("lastname"));
                user.setPassword(userList.getString("password"));
                user.setRole(userList.getString("role"));
                user.setAddress(userList.getString("address"));
                user.setCity(userList.getString("city"));
                user.setState(userList.getString("state"));
                user.setZip(userList.getString("zip"));
                user.setPhone(userList.getString("phone"));
                user.setEmail(userList.getString("email"));
                
                userListInDB.add(user);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO\n" + e.getMessage());
        }
        
        return userListInDB;
    }
    
    
    private static void StoreListinDB(User user, String queryString)
    {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();  
        try
        {
            stmt = conn.createStatement();
            String insertmar = queryString + " VALUES ('"
                    + user.getUsername() + "','"
                    + user.getId() + "','"
                    + user.getFirstname() + "','"
                    + user.getLastname() + "','"
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
        }
        catch (SQLException e)
        {
        }
    }
    
    public static ArrayList<User> returnUserListWithCredentials(String u, String p)
    {
        return getUserListFromQuery(String.format("SELECT * FROM users where "
                + "username='%s' AND "
                + "password='%s'", u, p));
    }
    
    public static ArrayList<User> returnProfile(String username)
    {
        ArrayList<User> fetch_profile = new ArrayList<User>();
        
        User res = new User();
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        
        String queryString = "SELECT * from users where username = '" + username + "'";
        
        try
        {
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(queryString);
            
            while (resultSet.next())
            {
                res.setUsername(resultSet.getString("username"));
                res.setId(resultSet.getString("id"));
                res.setFirstname(resultSet.getString("firstname"));
                res.setLastname(resultSet.getString("lastname"));
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
        }
        catch (SQLException e)
        {
        }
        return fetch_profile;
    }
    
    public static void UpdateinDB(User user)
    {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            String insertmar = "UPDATE users SET firstname = '" + user.getFirstname()
                    + "'," + "lastname = '" + user.getLastname()
                    + "'," + "password = '" + user.getPassword()
                    + "'," + "address = '" + user.getAddress()
                    + "'," + "city = '" + user.getCity()
                    + "'," + "state = '" + user.getState()
                    + "', " + "zip = '" + user.getZip()
                    + "', " + "phone = '" + user.getPhone()
                    + "', " + "role = '" + user.getRole()
                    + "', " + " email = '" + user.getEmail() + "' WHERE username = '" + user.getUsername() + "'";
            stmt.executeUpdate(insertmar);
            conn.commit();
        }
        catch (SQLException e)
        {
        }
    }
    
    public static void updatetUser(User user)
    {
        UpdateinDB(user);
    }
    
    public static void insertUser(User user)
    {
        StoreListinDB(user, "INSERT INTO `users` (username,id,firstname,lastname,password,role,address,city,state,zip,phone,email) ");
    }
    
    public static boolean isUsernameUnique(String name)
    {
        return returnProfile(name).isEmpty();
    }
    
    
    public static ArrayList<User> listAllUsers()
    {
        return getUserListFromQuery("SELECT * FROM users ORDER BY username");
    }
    
    public static ArrayList<User> listUserWithUsername(String us)
    {
        return getUserListFromQuery(String.format("SELECT * FROM users WHERE username='%s'", us));
    }
    
    public static ArrayList<User> listUsersWithRole(String rs)
    {
        return getUserListFromQuery(String.format("SELECT * FROM users WHERE role='%s' ORDER BY username", rs));
    }
    
    public static ArrayList<User> listUsers()
    {
        return getUserListFromQuery("SELECT * FROM users ORDER BY username");
    }
    
    public static void updateUser(User u)
    {
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        try
        {
            stmt = conn.createStatement();
            stmt.executeUpdate(String.format(
                    "UPDATE users " +
                            "SET "
                            + "id='%s',"
                            + "firstname='%s',"
                            + "lastname='%s',"
                            + "password='%s',"
                            + "role='%s',"
                            + "address='%s',"
                            + "city='%s',"
                            + "state='%s',"
                            + "zip='%s',"
                            + "phone='%s',"
                            + "email='%s' "
                            + "WHERE username='%s'",
                    u.getId(),
                    u.getFirstname(),
                    u.getLastname(),
                    u.getPassword(),
                    u.getRole(),
                    u.getAddress(),
                    u.getCity(),
                    u.getState(),
                    u.getZip(),
                    u.getPhone(),
                    u.getEmail(),
                    u.getUsername()));
            
            conn.commit();
        }
        catch (SQLException e)
        {
            System.out.println("Error in UserDAO updating user\n" + e.getMessage());
        }
    }
}
