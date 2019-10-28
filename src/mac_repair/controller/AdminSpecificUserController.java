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
import mac_repair.data.UserDAO;
import mac_repair.model.User;
import mac_repair.model.UserErrorMsgs;
import mac_repair.model.UtilityModel;

@WebServlet("/AdminSpecificUserController")
public class AdminSpecificUserController extends HttpServlet
{
    private static final long serialVersionUID = -617967594294823878L;
    
    private void userParam(HttpServletRequest request, User user)
    {
        user.setUser(
                request.getParameter("idusername"),
                request.getParameter("idutaID"),
                request.getParameter("idfirstname"),
                request.getParameter("idlastname"),
                request.getParameter("idpassword"),
                request.getParameter("idrole"),
                request.getParameter("idaddress"),
                request.getParameter("idstate"),
                request.getParameter("idcity"),
                request.getParameter("idzip"),
                request.getParameter("idphone"),
                request.getParameter("idemail"));
    }
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("ListSpecificUserAction"))
        {
            String usernameStr = request.getParameter("username");
            
            ArrayList<User> fetch_profile = new ArrayList<User>();
            fetch_profile = UserDAO.returnProfile(usernameStr);
            User currentUser = new User();
            currentUser.setUser(
                    fetch_profile.get(0).getUsername(),
                    fetch_profile.get(0).getId(),
                    fetch_profile.get(0).getFirstname(),
                    fetch_profile.get(0).getLastname(),
                    fetch_profile.get(0).getPassword(),
                    fetch_profile.get(0).getRole(),
                    fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(),
                    fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(),
                    fetch_profile.get(0).getPhone(),
                    fetch_profile.get(0).getEmail());
            
            session.setAttribute("olduser", currentUser);
            session.setAttribute("user", currentUser);
            
            ArrayList<UtilityModel> stateInDB = new ArrayList<UtilityModel>();
            ArrayList<UtilityModel> roleInDB = new ArrayList<UtilityModel>();
            roleInDB = UtilityDAO.listRoles();
            session.setAttribute("ROLE", roleInDB);
            stateInDB = UtilityDAO.listStates();
            session.setAttribute("STATE", stateInDB);
            
            getServletContext().getRequestDispatcher("/AdminUpdateProfile.jsp").forward(request, response);
        }
        else
        {
            System.out.println("ERROR: AdminSpecificUserController: INCORRECT ACTION at doGet()");
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("ApplyNewValuesAction"))
        {
            session.removeAttribute("user");
            session.removeAttribute("errorMsgs");
            User user = new User();
            UserErrorMsgs CerrorMsgs = new UserErrorMsgs();
            userParam(request, user);
            user.validateUser(user, CerrorMsgs, false);
            session.setAttribute("user", user);
            if (!CerrorMsgs.getErrorMsg().equals(""))
            {
                // if error messages
                session.setAttribute("errorMsgs", CerrorMsgs);
                getServletContext().getRequestDispatcher("/AdminUpdateProfile.jsp").forward(request, response);
            }
            else
            {
                // if no error messages
                UserDAO.updatetUser(user);
                String usernameStr = request.getParameter("idusername");
                
                ArrayList<User> fetch_profile = new ArrayList<User>();
                fetch_profile = UserDAO.returnProfile(usernameStr);
                User currentUser = new User();
                currentUser.setUser(
                        fetch_profile.get(0).getUsername(),
                        fetch_profile.get(0).getId(),
                        fetch_profile.get(0).getFirstname(),
                        fetch_profile.get(0).getLastname(),
                        fetch_profile.get(0).getPassword(),
                        fetch_profile.get(0).getRole(),
                        fetch_profile.get(0).getAddress(),
                        fetch_profile.get(0).getState(),
                        fetch_profile.get(0).getCity(),
                        fetch_profile.get(0).getZip(),
                        fetch_profile.get(0).getPhone(),
                        fetch_profile.get(0).getEmail());
                
                session.setAttribute("olduser", currentUser);
                
                ArrayList<UtilityModel> stateInDB = new ArrayList<UtilityModel>();
                ArrayList<UtilityModel> roleInDB = new ArrayList<UtilityModel>();
                roleInDB = UtilityDAO.listRoles();
                session.setAttribute("ROLE", roleInDB);
                stateInDB = UtilityDAO.listStates();
                session.setAttribute("STATE", stateInDB);
                session.removeAttribute("errorMsgs");
                getServletContext().getRequestDispatcher("/AdminUpdateProfile.jsp").forward(request, response);
                
            }
            
        }
        else
        {
            System.out.println("ERROR: AdminSpecificUserController: INCORRECT ACTION at doPost()");
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }
}
