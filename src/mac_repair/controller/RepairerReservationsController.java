package mac_repair.controller;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.UtilityDAO;
import mac_repair.data.RepairerViewAssignedDAO;
import mac_repair.data.RepairerViewReservedDAO;
//import cse6329.model.Repairer;
import mac_repair.data.FacilityDAO;
import mac_repair.model.*;

@WebServlet("/RepairerReservationsController")
public class RepairerReservationsController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action"), url="";
		session.removeAttribute("errorMsgs");
		
		
		//if 
		//else // redirect all other gets to post*/
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		session.removeAttribute("errorMsgs");
		ArrayList<FreeReservations> freeListPoss = new ArrayList<FreeReservations>();
		ArrayList<FreeReservations> freeListInDB = new ArrayList<FreeReservations>();
		ArrayList<FreeReservations> idDB = new ArrayList<FreeReservations>();
		

		/*if (action.equalsIgnoreCase("searchOptions"))
		{
			ArrayList<Facility> facilitiesInDB = new ArrayList<Facility>();
            facilitiesInDB = FM_FacilityDAO.listFacilitiesNames();
            session.setAttribute("FACILTIIES", facilitiesInDB);
            
            getServletContext().getRequestDispatcher("/SearchFreeFacilities.jsp").forward(request, response);
		}
		else*/ if (action.equalsIgnoreCase("searchFreeFacilities"))
        {
			String username = (String)session.getAttribute("username");
			if(RepairerViewReservedDAO.canMakeRes(request.getParameter("mar"), username))
			{
				//action=listSpecificCompany
				ArrayList<FreeReservations> freeReservations = new ArrayList<FreeReservations>();
				//Use a java class to make a list of possible reservations
				freeListPoss = RepairerViewReservedDAO.makePossibleFreeList(request.getParameter("id"), request.getParameter("date"));
				//Then Access the database to remove ones that are already in the database for that particualar date
				freeListInDB = RepairerViewReservedDAO.ReservedListInDB(request.getParameter("id"), request.getParameter("date"));
				//Then display the free reservations like you normaly would
				RepairerViewReservedDAO.getAvaliableReservations(freeListPoss, freeListInDB);
				//Now using the radio button, add the selected reservation to database
				session.setAttribute("FREEREPAIRERS", freeListPoss);
				session.setAttribute("mar", request.getParameter("mar"));
				url="/SearchFreeFacilities.jsp";
			}
			else
			{
				//Stay on the page
				url="/ListSpecificAssignedRepair.jsp";
			}
        }
		else if(action.equalsIgnoreCase("modifyReservations"))
		{
			//action=listSpecificCompany
			ArrayList<FreeReservations> freeReservations = new ArrayList<FreeReservations>();
			String username = (String)session.getAttribute("username");
			//Use a java class to make a list of possible reservations
			freeListPoss = RepairerViewReservedDAO.makePossibleFreeList(request.getParameter("id"), request.getParameter("date"));
			//Then Access the database to remove ones that are already in the database for that particualar date
			freeListInDB = RepairerViewReservedDAO.ReservedListInDB(request.getParameter("id"), request.getParameter("date"));
			//Then display the free reservations like you normaly would
			RepairerViewReservedDAO.getAvaliableReservations(freeListPoss, freeListInDB);
			//Now using the radio button, add the selected reservation to database
			session.setAttribute("FREEREPAIRERS", freeListPoss);
			session.setAttribute("mar", request.getParameter("mar"));
			url="/modifySearchFreeFacilities.jsp";
		}
		else if(action.equalsIgnoreCase("cancelReservations")) {
			RepairerViewReservedDAO.cancelReservation(request.getParameter("id"), request.getParameter("date"),  request.getParameter("from"),  request.getParameter("to"));
			url="/Repairer_Home.jsp";
			//getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else
		{
			//action=Add New Reservation
			
			String username = (String)session.getAttribute("username");
			if (request.getParameter("radioRes")!=null) {
				int selResIndex = Integer.parseInt(request.getParameter("radioRes")) - 1;
				
				freeListPoss = RepairerViewReservedDAO.makePossibleFreeList(request.getParameter("id"), request.getParameter("date"));
				//Then Access the database to remove ones that are already in the database for that particualar date
				freeListInDB = RepairerViewReservedDAO.ReservedListInDB(request.getParameter("id"), request.getParameter("date"));
				idDB = RepairerViewReservedDAO.IdDB(request.getParameter("id"), request.getParameter("date"), username);
				String id = request.getParameter("");
				//Then display the free reservations like you normaly would
				RepairerViewReservedDAO.getAvaliableReservations(freeListPoss, freeListInDB);
				if(action.equalsIgnoreCase("cancelReservation"))
				{
					//Need to delete previous reservation
					System.out.println("Cancel Reservation" + request.getParameter("mar"));
					RepairerViewReservedDAO.cancelModReservation(request.getParameter("mar"));
				}
				//Display Added Reservation
				FreeReservations sel = new FreeReservations();
				sel.setReserved(	freeListPoss.get(selResIndex).getFacilitytype(), freeListPoss.get(selResIndex).getFacilityname(), 
						freeListPoss.get(selResIndex).getVenue(), freeListPoss.get(selResIndex).getDate(), freeListPoss.get(selResIndex).getTo(), freeListPoss.get(selResIndex).getFrom());
				//Add the Reservation
				RepairerViewReservedDAO.addReservation(sel, request.getParameter("mar"), username);
				session.setAttribute("RESERVATION", sel);
				url="/AddNewReservation.jsp";					
			}
			else 
			{ // determine if Submit button was clicked without selecting a reservation
				if (request.getParameter("ListSelectedResButton")!=null) {
					String errorMsgs =  "Please select a Reservation";
					session.setAttribute("errorMsgs",errorMsgs);
					url="/SearchFreeFacilities.jsp";					
				}
			}
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}
}