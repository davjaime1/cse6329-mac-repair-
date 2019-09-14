package mac_repair.controller;


import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.FM_AssignMARDAO;
import mac_repair.data.FM_FacilityDAO;
import mac_repair.data.FM_MARDAO;
import mac_repair.data.FM_RepairScheduleDAO;
import mac_repair.data.FM_UtilityDAO;
import mac_repair.model.*;

@WebServlet("/FM_AssignMARController")
public class FM_AssignMARController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	private void getAssignedParam (HttpServletRequest request, FM_AssignMAR assignmar) {
		String dateVal = request.getParameter("iddateTimePicker");
		Date assignedDate = FM_UtilityDAO.mysqlDate(dateVal);
		assignmar.setAssignedMAR(request.getParameter("marid"), request.getParameter("fname"), request.getParameter("ftype"), request.getParameter("idUrgency"), request.getParameter("iddescription"), request.getParameter("reportedUser"), request.getParameter("reporteddate"),  request.getParameter("idassignedTo"), assignedDate.toString(), request.getParameter("idestimateofRepair")); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");
//		List companies
		if (action.equalsIgnoreCase("listassignedmar")) {
			ArrayList<FM_AssignMAR> assignedmarInDB = new ArrayList<FM_AssignMAR>();
			assignedmarInDB=FM_AssignMARDAO.listAssignedMARs();
			session.setAttribute("ASSIGNEDMARS", assignedmarInDB);				
			getServletContext().getRequestDispatcher("/FM_AssignedMARList.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		FM_AssignMAR assignmar = new FM_AssignMAR();
		FM_AssignMARErrorMsgs CerrorMsgs = new FM_AssignMARErrorMsgs();
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
		  if (action.equalsIgnoreCase("assignmar") ) {
	
//			String marNumber = request.getParameter("idmarnumber");   
//			String facilityName = request.getParameter("idfacilityname");
//
//			session.removeAttribute("errorMsgs");
//			mar.setMAR(marNumber, facilityName, "", "", "", "", ""); 
//			mar.validateMAR(action, CerrorMsgs);
//
//			ArrayList<FM_MAR> marInDB = new ArrayList<FM_MAR>();
//			if (CerrorMsgs.getErrorMsg().equals("")) {
//				if (!marNumber.equals(""))
//					marInDB=FM_MARDAO.searchMARByNumber(marNumber);
//				else
//					marInDB=FM_MARDAO.searchMARByFacilityName(facilityName);
//
//				session.setAttribute("MARS", marInDB);
//				url="/FM_MARSearchResults.jsp";
//			}
//			else {
//				session.setAttribute("mar", mar);
//				session.setAttribute("errorMsgs", CerrorMsgs);
//				url="/FM_SearchMAR.jsp";				
			//}
		}
		  if (action.equalsIgnoreCase("searchAssignedMAR") ) {
				
			String marNumber = request.getParameter("idmarnumber");   
			String facilityName = request.getParameter("idfacilityname");

			session.removeAttribute("errorMsgs");
			assignmar.setAssignedMAR(marNumber, facilityName, "", "", "", "", "","","",""); 
			assignmar.validateMAR(action, CerrorMsgs);

			ArrayList<FM_AssignMAR> assignedmarInDB = new ArrayList<FM_AssignMAR>();
			if (CerrorMsgs.getErrorMsg().equals("")) {
				if (!marNumber.equals(""))
					assignedmarInDB=FM_AssignMARDAO.searchMARByNumber(marNumber);
				else
					assignedmarInDB=FM_AssignMARDAO.searchMARByFacilityName(facilityName);

				session.setAttribute("ASSIGNEDMARS", assignedmarInDB);
				url="/FM_AssignedMARList.jsp";
			}
			else {
				session.setAttribute("assignedmar", assignmar);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/FM_SearchMAR.jsp";				
			}
		}
		else if(action.contains("saveassignedmar")) {
			getAssignedParam(request,assignmar);
			assignmar.validateMAR(action, CerrorMsgs); 
			if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
				session.setAttribute("MAR", assignmar);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/FM_AssignMAR.jsp";
			}
			else {// if no error messages

				FM_AssignMARDAO.insertAssignedMAR(assignmar); 
				FM_RepairSchedule repairschedule = new FM_RepairSchedule();	
				repairschedule.setRepairSchedule(assignmar.getAssignedTo(), assignmar.getMarID(), assignmar.getAssignedDate());
				FM_RepairScheduleDAO.insertRepairSchedule(repairschedule);
				FM_MARDAO.deleteMAR(assignmar.getMarID());
				url="/FM_Home.jsp";
			}
		}
		else if(action.contains("modify")) {
			ArrayList<FM_AssignMAR> marInDB = new ArrayList<FM_AssignMAR>();
			FM_AssignMAR selectedMAR = new FM_AssignMAR();
			String selectedMARNumber = request.getParameter("id");

			marInDB=FM_AssignMARDAO.searchMARByNumber(selectedMARNumber);
			selectedMAR.setAssignedMAR(marInDB.get(0).getMarID(), marInDB.get(0).getFacilityName(), marInDB.get(0).getFacilityType(), marInDB.get(0).getUrgency(), marInDB.get(0).getDescription(), marInDB.get(0).getReportedUser(), marInDB.get(0).getDate(),marInDB.get(0).getAssignedTo(),marInDB.get(0).getAssignedDate(),marInDB.get(0).getEstimateOfRepair());  
							
			session.setAttribute("ASSIGNEDMARS", selectedMAR);


			ArrayList<FM_Urgency> urgencyInDB = new ArrayList<FM_Urgency>();
			ArrayList<FM_Repairers> repairerInDB = new ArrayList<FM_Repairers>();
			ArrayList<FM_EstimateOfRepair> estimateTimeInDB = new ArrayList<FM_EstimateOfRepair>();

			urgencyInDB= FM_UtilityDAO.listUrgencies();				
			session.setAttribute("URGENCY", urgencyInDB);
			repairerInDB= FM_UtilityDAO.listRepairers();			
			session.setAttribute("REPAIRLIST", repairerInDB);
			estimateTimeInDB= FM_UtilityDAO.listEstimateTimes();				
			session.setAttribute("ESTIMATEOFREPAIR", estimateTimeInDB);




			url="/FM_ModifyAssignedMAR.jsp";	
		}
		else if(action.contains("savemodifiedassignedmar")) {
			getAssignedParam(request,assignmar);
			assignmar.validateMAR(action, CerrorMsgs); 
			if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
				session.setAttribute("ASSIGNEDMARS", assignmar);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/FM_ModifyAssignedMAR.jsp";
			}
			
			else {// if no error messages
//				getAssignedParam(request,assignmar);

//				FM_MAR selectedMAR = new FM_MAR();
//				selectedMAR.setMAR(request.getParameter("marid"), request.getParameter("facilityName"), request.getParameter("facilityType"), request.getParameter("idUrgency"), request.getParameter("iddescription"), request.getParameter("reportedUser"), request.getParameter("reporteddate"));

				FM_AssignMARDAO.UpdateinDB(assignmar);				


				FM_RepairSchedule repairschedule = new FM_RepairSchedule();	
				repairschedule.setRepairSchedule(assignmar.getAssignedTo(), assignmar.getMarID(), assignmar.getAssignedDate());
				FM_RepairScheduleDAO.deleteRepairSchedule(assignmar.getMarID());
				FM_RepairScheduleDAO.insertRepairSchedule(repairschedule);
//				FM_MARDAO.deleteMAR(assignmar.getMarID());
				session.setAttribute("ASSIGNEDMARS", assignmar);
				url="/FM_ViewSpecificAssignedMAR.jsp";	

			}
		}
		else { //action=listSpecificMAR
			ArrayList<FM_AssignMAR> marInDB = new ArrayList<FM_AssignMAR>();
			FM_AssignMAR selectedMAR = new FM_AssignMAR();
			String selectedMARNumber = request.getParameter("id");

			marInDB=FM_AssignMARDAO.searchMARByNumber(selectedMARNumber);
			selectedMAR.setAssignedMAR(marInDB.get(0).getMarID(), marInDB.get(0).getFacilityName(), marInDB.get(0).getFacilityType(), marInDB.get(0).getUrgency(), marInDB.get(0).getDescription(), marInDB.get(0).getReportedUser(), marInDB.get(0).getDate(),marInDB.get(0).getAssignedTo(),marInDB.get(0).getAssignedDate(),marInDB.get(0).getEstimateOfRepair());  
							
			session.setAttribute("ASSIGNEDMARS", selectedMAR);
			url="/FM_ViewSpecificAssignedMAR.jsp";					
				
			
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}