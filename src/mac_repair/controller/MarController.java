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


@WebServlet("/MarController")
public class MarController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        session.removeAttribute("errorMsgs");
        
        // Lists the available facilities to report in the form of
        // Facility Type | Facility Name
        if (action.equalsIgnoreCase("listFacilities"))
        {
            ArrayList<Facility> facilitiesInDB = new ArrayList<Facility>();
            facilitiesInDB = FacilityDAO.listFacilities();
        }
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
}
