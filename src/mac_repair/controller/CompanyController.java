package mac_repair.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.CompanyDAO;
import mac_repair.model.*;

@WebServlet("/CompanyController")
public class CompanyController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	private void getCompanyParam (HttpServletRequest request, Company company) {
		company.setCompany(request.getParameter("idcompany"),request.getParameter("company_name"),request.getParameter("phone"),request.getParameter("email"));  
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");
//		List companies
		if (action.equalsIgnoreCase("listCompany")) {
			ArrayList<Company> companyInDB = new ArrayList<Company>();
			companyInDB=CompanyDAO.listCompanies();
			session.setAttribute("COMPANIES", companyInDB);				
			getServletContext().getRequestDispatcher("/listCompany.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		Company company = new Company();
		CompanyErrorMsgs CerrorMsgs = new CompanyErrorMsgs();
		int selectedCompanyIndex;
		session.removeAttribute("errorMsgs");

		if (action.equalsIgnoreCase("saveCompany") ) {  
			getCompanyParam(request,company);
			company.validateCompany(action,company,CerrorMsgs);
			session.setAttribute("company", company);
			if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
				getCompanyParam(request,company);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/formCompany.jsp";
			}
			else {// if no error messages
				CompanyDAO.insertCompany(company);
				EmployeeErrorMsgs EemperrorMsgs = new EmployeeErrorMsgs();
				session.setAttribute("errorMsgs", EemperrorMsgs);
				url="/formEmployee.jsp";
			}
		}

		else 
		  if (action.equalsIgnoreCase("searchCompany") ) {
			String companyname = request.getParameter("company_name");   
			String companyID = request.getParameter("idcompany");
			session.removeAttribute("errorMsgs");
			company.setCompany(companyID,companyname,"","");
			company.validateCompany(action,company, CerrorMsgs);

			ArrayList<Company> companyInDB = new ArrayList<Company>();
			if (CerrorMsgs.getErrorMsg().equals("")) {
				if (!companyID.equals(""))
					companyInDB=CompanyDAO.searchCompany(companyID);
				else
					companyInDB=CompanyDAO.searchCompanies(companyname);

				session.setAttribute("COMPANIES", companyInDB);
				session.removeAttribute("company");
				url="/companySearchResults.jsp";
			}
			else {
				session.setAttribute("company", company);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/searchCompany.jsp";				
			}
		}
		else { //action=listSpecificCompany
			ArrayList<Company> companyInDB = new ArrayList<Company>();
			Company selectedCompany = new Company();
			if (request.getParameter("radioCompany")!=null) {
				selectedCompanyIndex = Integer.parseInt(request.getParameter("radioCompany")) - 1;
				companyInDB=CompanyDAO.listCompanies(); 
				selectedCompany.setCompany(	companyInDB.get(selectedCompanyIndex).getIdcompany(), companyInDB.get(selectedCompanyIndex).getCompany_name(), 
						companyInDB.get(selectedCompanyIndex).getPhone(), companyInDB.get(selectedCompanyIndex).getEmail());
				session.setAttribute("COMPANIES", selectedCompany);
				url="/ListSpecificCompany.jsp";					
			}
			else { // determine if Submit button was clicked without selecting a company
				if (request.getParameter("ListSelectedCompanyButton")!=null) {
					String errorMsgs =  "Please select a company";
					session.setAttribute("errorMsgs",errorMsgs);
					url="/listCompany.jsp";					
				}
				else { //view button was used instead of radio button
					companyInDB=CompanyDAO.searchCompany(request.getParameter("id"));
					selectedCompany.setCompany(	companyInDB.get(0).getIdcompany(), companyInDB.get(0).getCompany_name(), 
							companyInDB.get(0).getPhone(), companyInDB.get(0).getEmail());
					session.setAttribute("COMPANIES", selectedCompany);
					url="/ListSpecificCompany.jsp";					
				}
			}
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}