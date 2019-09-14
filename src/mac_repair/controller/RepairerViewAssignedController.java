package mac_repair.controller;


import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import cse6329.model.Repairer;
import mac_repair.data.RepairerViewAssignedDAO;
import mac_repair.model.*;

@WebServlet("/RepairerViewAssignedController")
public class RepairerViewAssignedController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		//session.removeAttribute("errorMsgs");
//		List companies
		if (action.equalsIgnoreCase("listReservedRepairers")) {
			ArrayList<RepairerViewAssigned> reservedListInDB = new ArrayList<RepairerViewAssigned>();
			reservedListInDB=RepairerViewAssignedDAO.listReservedRepairs();
			session.setAttribute("REPAIRERS", reservedListInDB);				
			getServletContext().getRequestDispatcher("/ViewReservedRepairs.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		RepairerViewAssigned res = new RepairerViewAssigned();
		int selectedReservedIndex;
		session.removeAttribute("errorMsgs");

		if (action.equalsIgnoreCase("listSpecificReservedRepairs") )
		{
			//action=listSpecificCompany
			ArrayList<RepairerViewAssigned> reservedListInDB = new ArrayList<RepairerViewAssigned>();
			RepairerViewAssigned selectedReservation = new RepairerViewAssigned();

			//view button was used instead of radio button
			reservedListInDB=RepairerViewAssignedDAO.searchReservedRepair(request.getParameter("id"));
			selectedReservation.setReserved(	reservedListInDB.get(0).getDate(), reservedListInDB.get(0).getMarnum(), reservedListInDB.get(0).getFacilitytype(), reservedListInDB.get(0).getFacilityname(),
												reservedListInDB.get(0).getTo(), reservedListInDB.get(0).getFrom());
			session.setAttribute("REPAIRERS", selectedReservation);
			url="/ListSpecificReservedRepair.jsp";					
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}
}