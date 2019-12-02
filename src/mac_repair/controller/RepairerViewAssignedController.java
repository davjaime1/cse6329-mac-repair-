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
			ArrayList<MAR> reservedListInDB = new ArrayList<MAR>();
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
		MAR res = new MAR();
		int selectedReservedIndex;
		session.removeAttribute("errorMsgs");

			//action=listSpecificCompany
			ArrayList<MAR> reservedListInDB = new ArrayList<MAR>();
			MAR selectedReservation = new MAR();

			//view button was used instead of radio button
			reservedListInDB=RepairerViewAssignedDAO.searchAssignedRepair(request.getParameter("id"), username);
			selectedReservation.setAssignedMAR(	reservedListInDB.get(0).getMarID(), reservedListInDB.get(0).getFacilityName(), reservedListInDB.get(0).getFacilityType(),
												reservedListInDB.get(0).getUrgency(), reservedListInDB.get(0).getDescription(), reservedListInDB.get(0).getReportedUser(),
												reservedListInDB.get(0).getDate(), reservedListInDB.get(0).getAssignedTo(),reservedListInDB.get(0).getAssignedDate(),
												reservedListInDB.get(0).getEstimateOfRepair());
			session.setAttribute("REPAIRERS", selectedReservation);
			url="/ListSpecificAssignedRepair.jsp";					

		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}
}