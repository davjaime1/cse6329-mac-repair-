
package mac_repair.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.FM_FacilityDAO;
import mac_repair.data.FM_UtilityDAO;
import mac_repair.model.*;

@WebServlet("/FM_FacilityController")
public class FM_FacilityController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	private void facilityParam (HttpServletRequest request, FM_Facility facility) {
		facility.setFacility(request.getParameter("idfacilityname"), request.getParameter("idfacilitytype"), request.getParameter("idtimeinterval"), request.getParameter("idduration"), request.getParameter("idvenue"));  
	}
//	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");
//		List companies
		String url= "";
//		List companies
		if(null == session.getAttribute("username"))
		{
			url="/login.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else if(action.equalsIgnoreCase("homepage"))
		{
			url="/FM_Home.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else if(action.equalsIgnoreCase("searchPage"))
		{
			url="/FM_SearchFacility.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else if (action.equalsIgnoreCase("listfacilities")) {
			ArrayList<FM_Facility> facilityInDB = new ArrayList<FM_Facility>();
			facilityInDB=FM_FacilityDAO.listFacilities();
			session.setAttribute("FACILITIES", facilityInDB);				
			getServletContext().getRequestDispatcher("/FM_ListFacilities.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		FM_Facility facility = new FM_Facility();
		FM_FacilityErrorMsgs CerrorMsgs = new FM_FacilityErrorMsgs();
//		int selectedCompanyIndex;
		session.removeAttribute("errorMsgs");

		if (action.equalsIgnoreCase("saveFacility") ) {  
			facilityParam(request,facility);
			facility.validateFacility(action, CerrorMsgs);
			session.setAttribute("facility", facility);
			if (!CerrorMsgs.getErrorMsg().equals("")) {// if error messages
				facilityParam(request,facility);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/FM_AddFacility.jsp";
			}
			else {// if no error messages
				FM_FacilityDAO.insertFacility(facility);
				FM_FacilityErrorMsgs facerrorMsgs = new FM_FacilityErrorMsgs();
				facerrorMsgs.setErrorMsg("Facility Added SucessFully");
				facerrorMsgs.setFacilityNameError("");
				facility.setFacilityName("");
				session.setAttribute("facility", facility);
				session.setAttribute("errorMsgs", facerrorMsgs);
				url="/FM_AddFacility.jsp";
			}
		}
//
//		else 
		  if (action.equalsIgnoreCase("searchFacility") ) {
	
			String facilityName = request.getParameter("idname");   
			String facilityType = request.getParameter("idfacilitytype");

			session.removeAttribute("errorMsgs");
			facility.setFacility(facilityName, facilityType, "", "", ""); 
			facility.validateFacility(action, CerrorMsgs);

			ArrayList<FM_Facility> facilityInDB = new ArrayList<FM_Facility>();
			if (CerrorMsgs.getErrorMsg().equals("")) {
				if (!facilityName.equals(""))
					facilityInDB=FM_FacilityDAO.searchFacilityByName(facilityName);
				else
					facilityInDB=FM_FacilityDAO.searchFacilityType(facilityType);

				session.setAttribute("FACILITIES", facilityInDB);
				url="/FM_FacilityeSarchResults.jsp";
			}
			else {
				session.setAttribute("facility", facility);
				session.setAttribute("errorMsgs", CerrorMsgs);
				url="/FM_SearchFacility.jsp";				
			}
		}
		  if (action.equalsIgnoreCase("showaddfacility") ) {
				
				ArrayList<FM_FacilityType> facilityTypeInDB = new ArrayList<FM_FacilityType>();
				ArrayList<FM_TimeInterval> timeIntervalInDB = new ArrayList<FM_TimeInterval>();
				ArrayList<FM_Duration> durationInDB = new ArrayList<FM_Duration>();
				ArrayList<FM_Venue> venueInDB = new ArrayList<FM_Venue>();
				facilityTypeInDB= FM_UtilityDAO.listFacilityTypes();				
				session.setAttribute("FACILITYTYPE", facilityTypeInDB);
				timeIntervalInDB= FM_UtilityDAO.listTimeTimeIntervals();			
				session.setAttribute("TIMEINTERVAL", timeIntervalInDB);
				durationInDB= FM_UtilityDAO.listDuration();				
				session.setAttribute("DURATION", durationInDB);
				venueInDB= FM_UtilityDAO.listVenues();				
				session.setAttribute("VENUE", venueInDB);

				url="/FM_AddFacility.jsp";
			}
		  

		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}