
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

import mac_repair.data.FacilityDAO;
import mac_repair.data.UtilityDAO;
import mac_repair.data.RepairerViewReservedDAO;
import mac_repair.model.*;

@WebServlet("/FM_FacilityController")
public class FM_FacilityController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	private void facilityParam (HttpServletRequest request, Facility facility) {
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

		else if (action.equalsIgnoreCase("listfacilities")) {
			ArrayList<Facility> facilityInDB = new ArrayList<Facility>();
			facilityInDB=FacilityDAO.listFacilities();
			session.setAttribute("FACILITIES", facilityInDB);				
			getServletContext().getRequestDispatcher("/FM_ListFacilities.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		Facility facility = new Facility();
		FacilityErrorMsgs CerrorMsgs = new FacilityErrorMsgs();
//		int selectedCompanyIndex;
		session.removeAttribute("errorMsgs");
		if(action.equalsIgnoreCase("searchPage"))
		{
			session.removeAttribute("facility");
			ArrayList<UtilityModel> facilityTypeInDB = new ArrayList<UtilityModel>();	
			facilityTypeInDB= UtilityDAO.listFacilityTypes();	
			session.setAttribute("FACILITYTYPE", facilityTypeInDB);
			url="/FM_SearchFacility.jsp";
			//getServletContext().getRequestDispatcher(url).forward(request, response);
		}
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
				FacilityDAO.insertFacility(facility);
				session.removeAttribute("errorMsgs");
				url="/FM_ViewSpecificFacility.jsp";
			}
		}
		if(action.equalsIgnoreCase("viewSpecificFacility")) {
			String selectedFacility = request.getParameter("id");
			ArrayList<Facility> 	facilityInDB=FacilityDAO.searchFacilityByName(selectedFacility);
			Facility facility1 = facilityInDB.get(0);
			session.setAttribute("facility", facility1);
			url="/FM_ViewSpecificFacility.jsp";
		}
//
//		else 
		  if (action.equalsIgnoreCase("searchFacility") ) {
				String dateVal = request.getParameter("iddateTimePicker");
				Date assignedDate = UtilityDAO.mysqlDate(dateVal);
				String facilityType = request.getParameter("idfacilitytype");
				ArrayList<FreeReservations> freeListPoss = new ArrayList<FreeReservations>();
				ArrayList<FreeReservations> freeListInDB = new ArrayList<FreeReservations>();
				ArrayList<Facility> facilityList = new ArrayList<Facility>();
				facilityList = FacilityDAO.getFacilities(facilityType);
				for(int i=0; i< facilityList.size();i++	) {
					freeListPoss.addAll(RepairerViewReservedDAO.makePossibleFreeList(facilityList.get(i).getFacilityName(), assignedDate.toString()));
					freeListInDB.addAll(RepairerViewReservedDAO.ReservedListInDB(facilityList.get(i).getFacilityName(), assignedDate.toString()));

				}
				RepairerViewReservedDAO.getAvaliableReservations(freeListPoss, freeListInDB);
				
				session.setAttribute("RESERVATION", freeListPoss);
		
				url="/ViewFacilityReservations.jsp";	
		}
		  if (action.equalsIgnoreCase("showaddfacility") ) {
				
				ArrayList<UtilityModel> facilityTypeInDB = new ArrayList<UtilityModel>();
				ArrayList<UtilityModel> timeIntervalInDB = new ArrayList<UtilityModel>();
				ArrayList<UtilityModel> durationInDB = new ArrayList<UtilityModel>();
				ArrayList<UtilityModel> venueInDB = new ArrayList<UtilityModel>();
				facilityTypeInDB= UtilityDAO.listFacilityTypes();				
				session.setAttribute("FACILITYTYPE", facilityTypeInDB);
				timeIntervalInDB= UtilityDAO.listTimeTimeIntervals();			
				session.setAttribute("TIMEINTERVAL", timeIntervalInDB);
				durationInDB= UtilityDAO.listDuration();				
				session.setAttribute("DURATION", durationInDB);
				venueInDB= UtilityDAO.listVenues();				
				session.setAttribute("VENUE", venueInDB);

				url="/FM_AddFacility.jsp";
			}
		  

		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}