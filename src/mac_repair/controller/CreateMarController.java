package mac_repair.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.FacilityDAO;
import mac_repair.model.Facility;


@WebServlet("/CreateMarController")
public class CreateMarController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        session.removeAttribute("errorMsgs");
        
        // Lists the available facilities to report
        if (action.equalsIgnoreCase("NewMarAction"))
        {
            ArrayList<Facility> facilitiesInDB = new ArrayList<Facility>();
            facilitiesInDB = FacilityDAO.listFacilitiesNameOnly();
            session.setAttribute("FACILITIES", facilitiesInDB);

            ArrayList<Urgency> urgenciesInDB = new ArrayList<Urgency>();
            urgenciesInDB = UrgencyDAO.listUrgencies();
            session.setAttribute("URGENCIES", urgenciesInDB);

            getServletContext().getRequestDispatcher("/CreateMar.jsp").forward(request, response);
        }
        else 
        {
            System.out.println("ERROR: CreateMarController: INCORRECT ACTION");
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    }
    
}
