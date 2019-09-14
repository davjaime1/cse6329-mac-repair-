package mac_repair.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mac_repair.data.FM_MARDAO;
import mac_repair.data.FacilityDAO;
import mac_repair.data.UrgencyDAO;
import mac_repair.model.FM_MAR;
import mac_repair.model.Facility;
import mac_repair.model.Urgency;
import mac_repair.util.MarNumber;


@WebServlet("/CreateMarController")
public class CreateMarController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("NewMarAction"))
        {
            // Lists the available facilities to report
            ArrayList<Facility> facilitiesInDB = new ArrayList<Facility>();
            facilitiesInDB = FacilityDAO.listFacilities();
            session.setAttribute("FACILITIES", facilitiesInDB);
            
            // Lists the available urgencies the user can select.
            ArrayList<Urgency> urgenciesInDB = new ArrayList<Urgency>();
            urgenciesInDB = UrgencyDAO.listUrgencies();
            session.setAttribute("URGENCIES", urgenciesInDB);
            
            getServletContext().getRequestDispatcher("/CreateMar.jsp").forward(request, response);
        }
        else
        {
            System.out.println("ERROR: CreateMarController: INCORRECT ACTION at doGet()");
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("action"),
                url = "";
        HttpSession session = request.getSession();
        
        /*
         * After the user clicks the select button after
         * filling in the value for the MAR creation,
         * this action occurs.
         */
        if (action.equalsIgnoreCase("SubmitMarAction"))
        {
            String facilityName = request.getParameter("facilityDropDown");
            String urgencyStr = request.getParameter("urgencyDropDown");
            String descriptionStr = request.getParameter("descriptionTextArea");
            
            Facility selectedFacility = new Facility();
            Urgency selectedUrgency = new Urgency();
            for (Facility f : FacilityDAO.listFacilities())
            {
                if (f.getName().equalsIgnoreCase(facilityName))
                {
                    selectedFacility = f;
                    break;
                }
            }
            for (Urgency u : UrgencyDAO.listUrgencies())
            {
                if (u.getUrgency().equalsIgnoreCase(urgencyStr))
                {
                    selectedUrgency = u;
                    break;
                }
            }
            
            // Gets the current user off the session attribute. TODO
            String reportedByStr = "TO BE FILLED IN";
            
            // Gets the current date.
            String dateStr = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now()).toString();
            
            // Gets the MAR number.
            int marNum = MarNumber.num.getAndIncrement();
            
            
            // Creating the MAR object to insert into the database.
            FM_MAR marObj = new FM_MAR();
            marObj.setMarID(Integer.toString(marNum));
            marObj.setFacilityName(selectedFacility.getName());
            marObj.setFacilityType(selectedFacility.getType());
            marObj.setUrgency(selectedUrgency.getUrgency());
            marObj.setDescription(descriptionStr);
            marObj.setReportedUser(reportedByStr);
            marObj.setDate(dateStr);
            
            
            FM_MARDAO.insertMAR(marObj);
            
            
            // Sets the values for the results page after the user has submitted a MAR.
            session.setAttribute("cmr_facilitytype", selectedFacility.getType());
            session.setAttribute("cmr_facilityname", selectedFacility.getName());
            session.setAttribute("cmr_urgency", selectedUrgency.getUrgency());
            session.setAttribute("cmr_description", descriptionStr);
            session.setAttribute("cmr_reportedby", reportedByStr);
            session.setAttribute("cmr_date", dateStr);
            session.setAttribute("cmr_marnumber", marNum);
            
            getServletContext().getRequestDispatcher("/CreateMarResult.jsp").forward(request, response);
        }
        else
        {
            System.out.println("ERROR: CreateMarController: INCORRECT ACTION at doPost()");
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }
    
}
