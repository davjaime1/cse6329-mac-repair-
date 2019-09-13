package mac_repair.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.FM_MARDAO;
import mac_repair.data.FM_UtilityDAO;
import mac_repair.model.*;

@WebServlet("/FM_MARController")
public class FM_MARController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
//	private void getCompanyParam (HttpServletRequest request, Company company) {
//		company.setCompany(request.getParameter("idcompany"),request.getParameter("company_name"),request.getParameter("phone"),request.getParameter("email"));  
//	}
//	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");
//		List companies
		if (action.equalsIgnoreCase("listmar")) {
			ArrayList<FM_MAR> marInDB = new ArrayList<FM_MAR>();
			marInDB=FM_MARDAO.listMARs();
			session.setAttribute("MARS", marInDB);				
			getServletContext().getRequestDispatcher("/FM_Listmars.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		FM_MAR mar = new FM_MAR();
		FM_MARErrorMsgs CerrorMsgs = new FM_MARErrorMsgs();
//		int selectedCompanyIndex;
		session.removeAttribute("errorMsgs");

//		if (action.equalsIgnoreCase("saveCompany") ) {  
//			getCompanyParam(request,company);
//			company.validateCompany(action,company,CerrorMsgs);
//			session.setAttribute("company", company);
//			if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
//				getCompanyParam(request,company);
//				session.setAttribute("errorMsgs", CerrorMsgs);
//				url="/formCompany.jsp";
//			}
//			else {// if no error messages
//				CompanyDAO.insertCompany(company);
//				EmployeeErrorMsgs EemperrorMsgs = new EmployeeErrorMsgs();
//				session.setAttribute("errorMsgs", EemperrorMsgs);
//				url="/formEmployee.jsp";
//			}
//		}
//
//		else 
		  if (action.equalsIgnoreCase("searchMAR") ) {
	
			String marNumber = request.getParameter("idmarnumber");   
			String facilityName = request.getParameter("idfacilityname");

			session.removeAttribute("errorMsgs");
			mar.setMAR(marNumber, facilityName, "", "", "", "", ""); 
			mar.validateMAR(action, CerrorMsgs);

			ArrayList<FM_MAR> marInDB = new ArrayList<FM_MAR>();
			if (CerrorMsgs.getErrorMsg().equals("")) {
				if (!marNumber.equals(""))
					marInDB=FM_MARDAO.searchMARByNumber(marNumber);
				else
					marInDB=FM_MARDAO.searchMARByFacilityName(facilityName);

				session.setAttribute("MARS", marInDB);
				url="/FM_Listmars.jsp";
			}
			else {
				session.setAttribute("mar", mar);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/FM_SearchMAR.jsp";				
			}
		}
		else if(action.contains("assignmar")) {
			ArrayList<FM_MAR> marInDB = new ArrayList<FM_MAR>();
			FM_MAR selectedMAR = new FM_MAR();
			String selectedMARNumber = request.getParameter("id");

			marInDB=FM_MARDAO.searchMARByNumber(selectedMARNumber);
			selectedMAR.setMAR(marInDB.get(0).getMarID(), marInDB.get(0).getFacilityName(), marInDB.get(0).getFacilityType(), marInDB.get(0).getUrgency(), marInDB.get(0).getDescription(), marInDB.get(0).getReportedUser(), marInDB.get(0).getDate());  
							
			session.setAttribute("MAR", selectedMAR);

			ArrayList<FM_Urgency> urgencyInDB = new ArrayList<FM_Urgency>();
			ArrayList<FM_Repairers> repairerInDB = new ArrayList<FM_Repairers>();
			ArrayList<FM_EstimateOfRepair> estimateTimeInDB = new ArrayList<FM_EstimateOfRepair>();

			urgencyInDB= FM_UtilityDAO.listUrgencies();				
			session.setAttribute("URGENCY", urgencyInDB);
			repairerInDB= FM_UtilityDAO.listRepairers();			
			session.setAttribute("REPAIRLIST", repairerInDB);
			estimateTimeInDB= FM_UtilityDAO.listEstimateTimes();				
			session.setAttribute("ESTIMATEOFREPAIR", estimateTimeInDB);

			url="/FM_AssignMAR.jsp";	
		}
		else if(action.contains("modify")) {
			ArrayList<FM_MAR> marInDB = new ArrayList<FM_MAR>();
			FM_MAR selectedMAR = new FM_MAR();
			String selectedMARNumber = request.getParameter("id");

			marInDB=FM_MARDAO.searchMARByNumber(selectedMARNumber);
			selectedMAR.setMAR(marInDB.get(0).getMarID(), marInDB.get(0).getFacilityName(), marInDB.get(0).getFacilityType(), marInDB.get(0).getUrgency(), marInDB.get(0).getDescription(), marInDB.get(0).getReportedUser(), marInDB.get(0).getDate());  
							
			session.setAttribute("MAR", selectedMAR);

			ArrayList<FM_Urgency> urgencyInDB = new ArrayList<FM_Urgency>();


			urgencyInDB= FM_UtilityDAO.listUrgencies();				
			session.setAttribute("URGENCY", urgencyInDB);


			url="/FM_ModifyMAR.jsp";	
		}
		  
		else if(action.contains("savemodifiedmar")) {
			FM_MAR selectedMAR = new FM_MAR();
			selectedMAR.setMAR(request.getParameter("marid"), request.getParameter("facilityName"), request.getParameter("facilityType"), request.getParameter("idUrgency"), request.getParameter("iddescription"), request.getParameter("reportedUser"), request.getParameter("reporteddate"));

			FM_MARDAO.UpdateinDB(selectedMAR);				



			ArrayList<FM_MAR> marInDB = new ArrayList<FM_MAR>();
			String selectedMARNumber = request.getParameter("marid");

			marInDB=FM_MARDAO.searchMARByNumber(selectedMARNumber);
			selectedMAR.setMAR(marInDB.get(0).getMarID(), marInDB.get(0).getFacilityName(), marInDB.get(0).getFacilityType(), marInDB.get(0).getUrgency(), marInDB.get(0).getDescription(), marInDB.get(0).getReportedUser(), marInDB.get(0).getDate());  
							
			session.setAttribute("MAR", selectedMAR);
			url="/FM_ViewSpecificMar.jsp";			
		}
		else if(action.contains("deletemar")) {

			String selectedMARNumber = request.getParameter("id");

			FM_MARDAO.deleteMAR(selectedMARNumber);


			url="/FM_Home.jsp";	
		}
		else { //action=listSpecificMAR
			ArrayList<FM_MAR> marInDB = new ArrayList<FM_MAR>();
			FM_MAR selectedMAR = new FM_MAR();
			String selectedMARNumber = request.getParameter("id");

			marInDB=FM_MARDAO.searchMARByNumber(selectedMARNumber);
			selectedMAR.setMAR(marInDB.get(0).getMarID(), marInDB.get(0).getFacilityName(), marInDB.get(0).getFacilityType(), marInDB.get(0).getUrgency(), marInDB.get(0).getDescription(), marInDB.get(0).getReportedUser(), marInDB.get(0).getDate());  
							
			session.setAttribute("MAR", selectedMAR);
			url="/FM_ViewSpecificMar.jsp";					
				
			
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}