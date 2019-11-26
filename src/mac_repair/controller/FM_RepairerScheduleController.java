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

import mac_repair.data.RepairScheduleDAO;
import mac_repair.data.UtilityDAO;
import mac_repair.model.*;

@WebServlet("/FM_RepairerScheduleController")
public class FM_RepairerScheduleController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");
		String url= "";
		if(action.equalsIgnoreCase("homepage"))
		{
			url="/FM_Home.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else if(action.equalsIgnoreCase("searchPage"))
		{
			url="/FM_SearchRepairSchedule.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else{
			ArrayList<MAR> repairscheduleInDB = new ArrayList<MAR>();
			repairscheduleInDB=RepairScheduleDAO.listRepairSchedule();
			session.setAttribute("REPAIRSCHEDULE", repairscheduleInDB);				
			getServletContext().getRequestDispatcher("/FM_RepairScheduleList.jsp").forward(request, response);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url="";
		HttpSession session = request.getSession();
		session.removeAttribute("errorMsgs");
		String dateVal = request.getParameter("iddateTimePicker");
		Date assignedDate = UtilityDAO.mysqlDate(dateVal);
		ArrayList<MAR> repaierscheduleInDB = new ArrayList<MAR>();
		repaierscheduleInDB=RepairScheduleDAO.searchScheduleDate(assignedDate.toString());
		session.setAttribute("REPAIRSCHEDULE", repaierscheduleInDB);
		url="/FM_RepairScheduleList.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}