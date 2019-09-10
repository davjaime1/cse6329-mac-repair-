package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_repair.model.Employee;
import mac_repair.util.SQLConnection;

public class EmployeeDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	public static void insertEmployee(Employee employee) {
		Statement stmt = null;   
		Connection conn = SQLConnection.getDBConnection();  
		String insertEmployee = "INSERT INTO EMPLOYEE (idemployee,surname,name,badge,FK_company,date_ins) ";					
		insertEmployee += " VALUES ('"  
				+ employee.getIdemployee()  + "','"
				+ employee.getSurname() + "','"
				+ employee.getName() + "','"		
				+ employee.getBadge() + "','"
				+ employee.getFk_company() + "'," 
				+ " SYSDATE())";
		conn = SQLConnection.getDBConnection();  
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			stmt = conn.createStatement();
			stmt.executeUpdate(insertEmployee);
			conn.commit();					 
		} catch (SQLException e) {}   
	}
	
	//unique employeeID
	//list employees
	public static Boolean uniqueEmpID(String idEmp) {  
		Statement stmt = null;   
		Connection conn = null;  
		conn = SQLConnection.getDBConnection();  
		ArrayList<Employee> employeeListInDB = new ArrayList<Employee>();
		try {
			stmt = conn.createStatement();
			String searchEmployee = " SELECT * from EMPLOYEE WHERE IDEMPLOYEE = '"+idEmp+"' ORDER BY surname";
			ResultSet employeeList = stmt.executeQuery(searchEmployee);
			while (employeeList.next()) {
				Employee employee = new Employee(); 
				String idemployee = employeeList.getString("idemployee");
				String name  = employeeList.getString("name");
				String surname  = employeeList.getString("surname");
				String badge  = employeeList.getString("badge");				 
				employee.setIdemployee(idemployee);  
				employee.setName(name);
				employee.setSurname(surname);
				employee.setBadge(badge);
				employeeListInDB.add(employee);	 
			} 
		} catch (SQLException e) {}    
		return employeeListInDB.isEmpty();
	}
	
	//list employees
	public static ArrayList<Employee> listEmployees(String idComp) {  
		Statement stmt = null;   
		Connection conn = null;  
		ArrayList<Employee> employeeListInDB = new ArrayList<Employee>();
		conn = SQLConnection.getDBConnection(); 
		try {
		stmt = conn.createStatement();
		String searchEmployee = " SELECT * from EMPLOYEE WHERE FK_COMPANY = '"+idComp+"' ORDER BY surname";

		ResultSet employeeList = stmt.executeQuery(searchEmployee);

		while (employeeList.next()) {
			Employee employee = new Employee(); 
			String idemployee = employeeList.getString("idemployee");
			String name  = employeeList.getString("name");
			String surname  = employeeList.getString("surname");
			String badge  = employeeList.getString("badge");				 
			employee.setIdemployee(idemployee);  
			employee.setName(name);
			employee.setSurname(surname);
			employee.setBadge(badge);
			employeeListInDB.add(employee);	 
		} 
		} catch (SQLException e) {}    
		return employeeListInDB;
	}
}
