package mac_repair.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mac_repair.model.Company;
import mac_repair.util.SQLConnection;
public class CompanyDAO {

	static SQLConnection DBMgr = SQLConnection.getInstance();
	
	private static ArrayList<Company> ReturnMatchingCompaniesList (String queryString) {
		ArrayList<Company> companyListInDB = new ArrayList<Company>();
		
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			ResultSet companyList = stmt.executeQuery(queryString);
			while (companyList.next()) {
				Company company = new Company(); 
				company.setIdcompany(companyList.getString("idcompany"));
				company.setCompany_name(companyList.getString("company_name"));
				company.setPhone(companyList.getString("phone"));
				company.setEmail(companyList.getString("email"));  
				companyListInDB.add(company);	
			}
		} catch (SQLException e) {}
		return companyListInDB;
	}
	
	private static void StoreListinDB (Company company,String queryString) {
		Statement stmt = null;
		Connection conn = SQLConnection.getDBConnection();  
		try {
			stmt = conn.createStatement();
			String insertCompany = queryString + " VALUES ('"  
					+ company.getIdcompany()  + "','"
					+ company.getCompany_name() + "','"		
					+ company.getPhone() + "','"
					+ company.getEmail() + "',"
					+ " SYSDATE())";
			stmt.executeUpdate(insertCompany);	
			conn.commit(); 
		} catch (SQLException e) {}
	}

	public static void insertCompany(Company company) {  
		StoreListinDB(company,"INSERT INTO COMPANY (idcompany,company_name,phone,email,date_ins) ");
	} 
	
	public static ArrayList<Company>  listCompanies() {  
			return ReturnMatchingCompaniesList(" SELECT * from COMPANY ORDER BY company_name");
	}
	
	//search companies
	public static ArrayList<Company>  searchCompanies(String companyname)  {  
			return ReturnMatchingCompaniesList(" SELECT * from COMPANY WHERE company_name LIKE '%"+companyname+"%' ORDER BY idcompany");
	}
	
	//determine if companyID is unique
	public static Boolean CompanyIDunique(String idComp)  {  
			return (ReturnMatchingCompaniesList(" SELECT * from COMPANY WHERE IDCOMPANY = '"+idComp+"' ORDER BY company_name").isEmpty());
	}
	//search company with company ID
	public static ArrayList<Company>   searchCompany (String idComp)  {  
			return ReturnMatchingCompaniesList(" SELECT * from COMPANY WHERE IDCOMPANY = '"+idComp+"' ORDER BY company_name");
	}
}
