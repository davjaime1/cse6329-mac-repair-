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
		String action = request.getParameter("action"), url="";
		String username = (String)session.getAttribute("username");
		//session.removeAttribute("errorMsgs");
//		List companies
		if (action.equalsIgnoreCase("listAssignedRepairers")) {
			ArrayList<RepairerViewAssigned> reservedListInDB = new ArrayList<RepairerViewAssigned>();
			reservedListInDB=RepairerViewAssignedDAO.listAssignedRepairs(username);
			session.setAttribute("REPAIRERS", reservedListInDB);				
			getServletContext().getRequestDispatcher("/ViewAssignedRepairs.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		RepairerViewAssigned res = new RepairerViewAssigned();
		int selectedReservedIndex;
		session.removeAttribute("errorMsgs");

		if (action.equalsIgnoreCase("listSpecificAssignedRepairs") )
		{
			//action=listSpecificCompany
			ArrayList<RepairerViewAssigned> reservedListInDB = new ArrayList<RepairerViewAssigned>();
			RepairerViewAssigned selectedReservation = new RepairerViewAssigned();

			//view button was used instead of radio button
			reservedListInDB=RepairerViewAssignedDAO.searchAssignedRepair(request.getParameter("id"), username);
			selectedReservation.setReserved(	reservedListInDB.get(0).getAssignedmar(), reservedListInDB.get(0).getFacilityname(), reservedListInDB.get(0).getFacilitytype(),
												reservedListInDB.get(0).getUrgency(), reservedListInDB.get(0).getDescription(), reservedListInDB.get(0).getReporteddate(),
												reservedListInDB.get(0).getReportedby(), reservedListInDB.get(0).getAssignedDate(),
												reservedListInDB.get(0).getEstimateofrepair());
			session.setAttribute("REPAIRERS", selectedReservation);
			url="/ListSpecificAssignedRepair.jsp";					
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}
}