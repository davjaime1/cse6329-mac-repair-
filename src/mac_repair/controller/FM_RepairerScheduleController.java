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

import mac_repair.data.FM_MARDAO;
import mac_repair.data.FM_RepairScheduleDAO;
import mac_repair.data.FM_UtilityDAO;
import mac_repair.model.*;

@WebServlet("/FM_RepairerScheduleController")
public class FM_RepairerScheduleController extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
//	private void getCompanyParam (HttpServletRequest request, Company company) {
//		company.setCompany(request.getParameter("idcompany"),request.getParameter("company_name"),request.getParameter("phone"),request.getParameter("email"));  
//	}
//	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		session.removeAttribute("errorMsgs");
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
			url="/FM_SearchRepairSchedule.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else if (action.equalsIgnoreCase("listRepaierschedule")) {
			ArrayList<FM_RepairSchedule> repairscheduleInDB = new ArrayList<FM_RepairSchedule>();
			repairscheduleInDB=FM_RepairScheduleDAO.listRepairSchedule();
			session.setAttribute("REPAIRSCHEDULE", repairscheduleInDB);				
			getServletContext().getRequestDispatcher("/FM_RepairScheduleList.jsp").forward(request, response);
		}
		else // redirect all other gets to post
			doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		FM_RepairSchedule repairschedule = new FM_RepairSchedule();
		FM_RepairScheduleErrorMsgs CerrorMsgs = new FM_RepairScheduleErrorMsgs();
//		int selectedCompanyIndex;
		session.removeAttribute("errorMsgs");


		  if (action.equalsIgnoreCase("searchrepairschedule") ) {
			String dateVal = request.getParameter("iddateTimePicker");
			Date assignedDate = FM_UtilityDAO.mysqlDate(dateVal);

	

			ArrayList<FM_RepairSchedule> repaierscheduleInDB = new ArrayList<FM_RepairSchedule>();
//			if (CerrorMsgs.getErrorMsg().equals("")) {
//				if (!username.equals(""))
					repaierscheduleInDB=FM_RepairScheduleDAO.searchScheduleDate(assignedDate.toString());
//				else
//					repaierscheduleInDB=FM_RepairScheduleDAO.searchScheduleByUser(username);

				session.setAttribute("REPAIRSCHEDULE", repaierscheduleInDB);
				url="/FM_RepairScheduleList.jsp";
//			}
//			else {
//				session.setAttribute("repairschedule", repairschedule);
//				session.setAttribute("errorMsgs", CerrorMsgs);
//				url="/FM_SearchRepairSchedule.jsp";				
//			}
		}

		getServletContext().getRequestDispatcher(url).forward(request, response);		
	}
}