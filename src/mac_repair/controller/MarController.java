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
import mac_repair.util.MarValidator;


@WebServlet("/MarController")
public class MarController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private static final String classname = MarController.class.getName();
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        session.removeAttribute("ERR_MSG");
        String action = request.getParameter("action");
        
        /* Action occurs when a user creates a MAR. */
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
        
        /* Shows a list of MARs created by the user. */
        else if (action.equalsIgnoreCase("ListMarsAction"))
        {
            session.setAttribute("MARS", FM_MARDAO.listMarsReportedBy((String) session.getAttribute("username")));
            session.setAttribute("FACILITIES", FacilityDAO.listFacilities());
            session.getServletContext().getRequestDispatcher("/MarList.jsp").forward(request, response);
        }
        
        /* Show more details of the MAR selected by the user. */
        else if (action.equalsIgnoreCase("ViewSpecificMar"))
        {
            FM_MAR mar = FM_MARDAO.getSpecificMar(request.getParameter("marid"));
            
            // Sets the values for the results page after the user has submitted a MAR.
            session.setAttribute("cmr_facilitytype", mar.getFacilityType());
            session.setAttribute("cmr_facilityname", mar.getFacilityName());
            session.setAttribute("cmr_urgency", mar.getUrgency());
            session.setAttribute("cmr_description", mar.getDescription());
            session.setAttribute("cmr_reportedby", mar.getReportedUser());
            session.setAttribute("cmr_date", mar.getDate());
            session.setAttribute("cmr_marnumber", mar.getMarID());
            
            getServletContext().getRequestDispatcher("/SpecificMar.jsp").forward(request, response);
            
        }
        
        /* Occurs only if a non-existent action is executed. */
        else
        {
            System.out.println("ERROR: " + classname + ": INCORRECT ACTION at doGet()");
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        session.removeAttribute("ERR_MSG");
        String action = request.getParameter("action");
        
        
        /* After the user clicks the select button after
         * filling in the value for the MAR creation,
         * this action occurs. */
        if (action.equalsIgnoreCase("SubmitMarAction"))
        {
            // If description box is empty, set error message.
            String descriptionStr = request.getParameter("descriptionTextArea");
            if (!MarValidator.validDescription(descriptionStr))
            {
                session.setAttribute("ERR_MSG", "Description cannot be empty.");
                getServletContext().getRequestDispatcher("/CreateMar.jsp").forward(request, response);
            }
            else
            {
                String facilityName = request.getParameter("facilityDropDown");
                String urgencyStr = request.getParameter("urgencyDropDown");
                
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
                
                // Gets the current date.
                String dateStr = DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now()).toString();
                
                // Getting the current username for the session.
                String reportedByStr = (String) session.getAttribute("username");
                
                // Gets the current MAR number from the database.
                int marNum = FM_MARDAO.getCurrentMarNumber();
                
                // Creating the MAR object to insert into the database.
                FM_MAR marObj = new FM_MAR();
                marObj.setMarID(Integer.toString(marNum));
                marObj.setFacilityName(selectedFacility.getName());
                marObj.setFacilityType(selectedFacility.getType());
                marObj.setUrgency(selectedUrgency.getId());
                marObj.setDescription(descriptionStr);
                marObj.setReportedUser(reportedByStr);
                marObj.setDate(dateStr);
                
                // Insert the MAR object into the database.
                FM_MARDAO.insertMAR(marObj);
                
                
                // Sets the values for the results page after the user has submitted a MAR.
                session.setAttribute("cmr_facilitytype", selectedFacility.getType());
                session.setAttribute("cmr_facilityname", selectedFacility.getName());
                session.setAttribute("cmr_urgency", selectedUrgency.getUrgency());
                session.setAttribute("cmr_description", descriptionStr);
                session.setAttribute("cmr_reportedby", reportedByStr);
                session.setAttribute("cmr_date", dateStr);
                session.setAttribute("cmr_marnumber", marNum);
                
                getServletContext().getRequestDispatcher("/SpecificMar.jsp").forward(request, response);
            }
            
        }
        else if (action.equalsIgnoreCase("ApplyMarFilterAction"))
        {
            /* Check if a selection has been made. If not -- default value selected -- then
             * show an error message.
             * 
             * Else, show a new list of MARs with the filter applied. */
            String facilityName = request.getParameter("facilityNameDropDown");
            if (facilityName.equalsIgnoreCase("default"))
            {
                /* Show same page with error message. */
                session.setAttribute("ERR_MSG", "No facility name selected!");
                getServletContext().getRequestDispatcher("/MarList.jsp").forward(request, response);
            }
            else
            {
                session.setAttribute("MARS", FM_MARDAO.listMarsWithFacilityNameAndUsername(
                        facilityName,
                        (String) session.getAttribute("username")));
                getServletContext().getRequestDispatcher("/MarList.jsp").forward(request, response);
            }
        }
        else
        {
            System.out.println("ERROR: " + classname + ": INCORRECT ACTION at doPost()");
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }
    
}
