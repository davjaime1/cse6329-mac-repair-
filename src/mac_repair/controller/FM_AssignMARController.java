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
import mac_repair.data.UtilityDAO;
import mac_repair.model.*;

@WebServlet("/FM_AssignMARController")
public class FM_AssignMARController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	private void getAssignedParam (HttpServletRequest request, MAR assignmar) {
		String dateVal = request.getParameter("iddateTimePicker");
		Date assignedDate = UtilityDAO.mysqlDate(dateVal);
		assignmar.setAssignedMAR(request.getParameter("marid"), request.getParameter("fname"), request.getParameter("ftype"), request.getParameter("idUrgency"), request.getParameter("iddescription"), request.getParameter("reportedUser"), request.getParameter("reporteddate"),  request.getParameter("idassignedTo"), assignedDate.toString(), request.getParameter("idestimateofRepair")); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");
//		List companies
		String url= "";
//		List companies
//		if(null == session.getAttribute("username"))
//		{
//			url="/login.jsp";
//			getServletContext().getRequestDispatcher(url).forward(request, response);
//		}
		if(action.equalsIgnoreCase("homepage"))
		{
			url="/FM_Home.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else if(action.equalsIgnoreCase("searchPage"))
		{
			url="/FM_SearchAssignedMAR.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else if(action.equalsIgnoreCase("listSpecificAssignedMAR")){
			ArrayList<MAR> marInDB = new ArrayList<MAR>();
			MAR selectedMAR = new MAR();
			String selectedMARNumber = request.getParameter("id");

			marInDB=FM_AssignMARDAO.searchMARByNumber(selectedMARNumber);
			selectedMAR.setAssignedMAR(marInDB.get(0).getMarID(), marInDB.get(0).getFacilityName(), marInDB.get(0).getFacilityType(), marInDB.get(0).getUrgency(), marInDB.get(0).getDescription(), marInDB.get(0).getReportedUser(), marInDB.get(0).getDate(),marInDB.get(0).getAssignedTo(),marInDB.get(0).getAssignedDate(),marInDB.get(0).getEstimateOfRepair());  
							
			session.setAttribute("ASSIGNEDMARS", selectedMAR);				
			getServletContext().getRequestDispatcher("/FM_ViewSpecificAssignedMAR.jsp").forward(request, response);
			
		}
		else {
			ArrayList<MAR> assignedmarInDB = new ArrayList<MAR>();
			assignedmarInDB=FM_AssignMARDAO.listAssignedMARs();
			session.setAttribute("ASSIGNEDMARS", assignedmarInDB);				
			getServletContext().getRequestDispatcher("/FM_AssignedMARList.jsp").forward(request, response);
		}
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		MAR assignmar = new MAR();
		MARErrorMsgs CerrorMsgs = new MARErrorMsgs();

		  if (action.equalsIgnoreCase("searchAssignedMAR") ) {
				
			String marNumber = request.getParameter("idmarnumber");   
			String facilityName = request.getParameter("idfacilityname");

			session.removeAttribute("errorMsgs");
			assignmar.setAssignedMAR(marNumber, facilityName, "", "", "", "", "","","",""); 
			assignmar.validateMAR(action, CerrorMsgs);

			
			ArrayList<MAR> assignedmarInDB = new ArrayList<MAR>();
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
				url="/FM_SearchAssignedMAR.jsp";				
			}
		}
		else {
			getAssignedParam(request,assignmar);
			assignmar.validateMAR(action, CerrorMsgs); 
			if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
				session.setAttribute("MAR", assignmar);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/FM_AssignMAR.jsp";
			}
			else {// if no error messages

				FM_AssignMARDAO.insertAssignedMAR(assignmar);
				FM_AssignMARDAO.addRepairList(request.getParameter("marid"),  request.getParameter("reporteddate"), request.getParameter("idassignedTo")); 

				session.setAttribute("ASSIGNEDMARS", assignmar);
				url="/FM_ViewSpecificAssignedMAR.jsp";	
			}
		}


		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}