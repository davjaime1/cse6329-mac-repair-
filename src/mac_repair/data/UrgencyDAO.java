package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_repair.model.Urgency;
import mac_repair.util.SQLConnection;

public class UrgencyDAO
{
    private static SQLConnection DBMgr = SQLConnection.getInstance();
    
    private static ArrayList<Urgency> returnMatchingUrgencyList(String queryString)
    {
        ArrayList<Urgency> urgenciesInDB = new ArrayList<Urgency>();
        
        Statement stmt = null;
        Connection conn = SQLConnection.getDBConnection();
        
        try
        {
            stmt = conn.createStatement();
            ResultSet urgencyList = stmt.executeQuery(queryString);
            while (urgencyList.next())
            {
                Urgency urgency = new Urgency();
                urgency.setId(urgencyList.getString("id"));
                urgency.setUrgency(urgencyList.getString("urgency"));
                urgenciesInDB.add(urgency);
            }
        }
        catch (SQLException e)
        {
        }
        
        return urgenciesInDB;
    }
    
    public static ArrayList<Urgency> listUrgencies()
    {
        return returnMatchingUrgencyList("SELECT * FROM urgency ORDER BY urgency");
    }
}
