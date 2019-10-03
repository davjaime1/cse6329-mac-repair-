package mac_repair.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.FM_UtilityDAO;
import mac_repair.data.RoleDAO;
import mac_repair.data.UserModelDAO;
import mac_repair.model.Role;
import mac_repair.model.State;
import mac_repair.model.UserErrorMsgs;
import mac_repair.model.UserModel;


/**
 * Servlet implementation class userController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    
    private void userParam(HttpServletRequest request, UserModel user)
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        session.removeAttribute("errorMsgs");
        String url = "";
        
        if (action.equalsIgnoreCase("loginProfile"))
        {
            url = "/index.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if (action.equalsIgnoreCase("logOut"))
        {
            session.invalidate();
            url = "/index.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }
        else if (action.equalsIgnoreCase("ToHomePage"))
        {
            /* This action displays the user's home page based on their role. */
            String roleId = (String) session.getAttribute("LOGIN_ROLE"),
                    homePageUrl;

            if (roleId.equalsIgnoreCase("U"))
            {
                homePageUrl = "/UserHome.jsp";
            }
            else if (roleId.equalsIgnoreCase("FM"))
            {
                homePageUrl = "/FM_Home.jsp";
            }
            else if (roleId.equalsIgnoreCase("A"))
            {
                homePageUrl = "/AdminHome.jsp";
            }
            else if (roleId.equalsIgnoreCase("R"))
            {
                homePageUrl = "/Repairer_Home.jsp";
            }
            else
            {
                /* Just log out the user in case of a bad role. */
                session.removeAttribute("LOGIN_ROLE");
                homePageUrl = "/index.jsp";
            }
            
            getServletContext().getRequestDispatcher(homePageUrl).forward(request, response);
        }
        else
        {
            // redirect all other gets to post
            doPost(request, response);
        }
    }
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        session.removeAttribute("errorMsgs");
        
        
        if (action.equalsIgnoreCase("registerProfile"))
        {
            ArrayList<Role> roleInDB = new ArrayList<Role>();
            ArrayList<State> stateInDB = new ArrayList<State>();
            roleInDB = RoleDAO.listRoles();
            session.setAttribute("ROLE", roleInDB);
            stateInDB = FM_UtilityDAO.listStates();
            session.setAttribute("STATE", stateInDB);
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
        }
        else if (action.equalsIgnoreCase("registerUser"))
        {
            UserModel user = new UserModel();
            UserErrorMsgs CerrorMsgs = new UserErrorMsgs();
            userParam(request, user);
            user.validateUser(action, CerrorMsgs);
            session.setAttribute("user", user);
            if (!CerrorMsgs.getErrorMsg().equals(""))
            {
                // if error messages
                session.setAttribute("errorMsgs", CerrorMsgs);
                getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
            }
            else
            {
                // if no error messages
                UserModelDAO.insertUser(user);
                UserErrorMsgs facerrorMsgs = new UserErrorMsgs();
                facerrorMsgs.setErrorMsg("Facility Added SucessFully");
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }
        else if (action.equalsIgnoreCase("viewProfile"))
        {
            String username = (String) session.getAttribute("username");
            System.out.println(username);
            
            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel currentUser = new UserModel();
            currentUser.setUser(
                    fetch_profile.get(0).getUsername(),
                    fetch_profile.get(0).getUtaId(),
                    fetch_profile.get(0).getFirstName(),
                    fetch_profile.get(0).getLastName(),
                    fetch_profile.get(0).getPassword(),
                    fetch_profile.get(0).getRole(),
                    fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(),
                    fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(),
                    fetch_profile.get(0).getPhone(),
                    fetch_profile.get(0).getEmail());
            
            session.setAttribute("USERS", currentUser);
            getServletContext().getRequestDispatcher("/ViewProfile.jsp").forward(request, response);
        }
        else if (action.equalsIgnoreCase("updateProfileView"))
        {
            String username = (String) session.getAttribute("username");
            System.out.println(username);
            
            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserModel currentUser = new UserModel();
            currentUser.setUser(
                    fetch_profile.get(0).getUsername(),
                    fetch_profile.get(0).getUtaId(),
                    fetch_profile.get(0).getFirstName(),
                    fetch_profile.get(0).getLastName(),
                    fetch_profile.get(0).getPassword(),
                    fetch_profile.get(0).getRole(),
                    fetch_profile.get(0).getAddress(),
                    fetch_profile.get(0).getState(),
                    fetch_profile.get(0).getCity(),
                    fetch_profile.get(0).getZip(),
                    fetch_profile.get(0).getPhone(),
                    fetch_profile.get(0).getEmail());
            
            session.setAttribute("user", currentUser);
            ArrayList<State> stateInDB = new ArrayList<State>();

            stateInDB = FM_UtilityDAO.listStates();
            session.setAttribute("STATE", stateInDB);
            getServletContext().getRequestDispatcher("/UpdateProfile.jsp").forward(request, response);
        }
        else if (action.equalsIgnoreCase("updateProfile"))
        {
            UserModel user = new UserModel();
            UserErrorMsgs CerrorMsgs = new UserErrorMsgs();
            userParam(request, user);
            user.validateUser(action, CerrorMsgs);
            session.setAttribute("user", user);
            if (!CerrorMsgs.getErrorMsg().equals(""))
            {
                // if error messages
                session.setAttribute("errorMsgs", CerrorMsgs);
                getServletContext().getRequestDispatcher("/UpdateProfile.jsp").forward(request, response);
            }
            else
            {
                // if no error messages
                UserModelDAO.updatetUser(user);
				session.setAttribute("USERS", user);
                getServletContext().getRequestDispatcher("/ViewProfile.jsp").forward(request, response);
            }
        }
        
        else // (action == loginUser)
        {
            String username = request.getParameter("idusername");
            String password = request.getParameter("idpassword");
            
            ArrayList<UserModel> fetch_profile = new ArrayList<UserModel>();
            fetch_profile = UserModelDAO.returnProfile(username);
            UserErrorMsgs CerrorMsgs = new UserErrorMsgs();
            UserModel currentUser = new UserModel();
            if (fetch_profile.size() != 0)
            {
                currentUser.setUser(
                        fetch_profile.get(0).getUsername(),
                        fetch_profile.get(0).getUtaId(),
                        fetch_profile.get(0).getFirstName(),
                        fetch_profile.get(0).getLastName(),
                        fetch_profile.get(0).getPassword(),
                        fetch_profile.get(0).getRole(),
                        fetch_profile.get(0).getAddress(),
                        fetch_profile.get(0).getState(),
                        fetch_profile.get(0).getCity(),
                        fetch_profile.get(0).getZip(),
                        fetch_profile.get(0).getPhone(),
                        fetch_profile.get(0).getEmail());
                currentUser.validateLogin(action, password, CerrorMsgs);
            }
            else
            {
                CerrorMsgs.setUserNameError("No user found");
                CerrorMsgs.setErrorMsg(action);
            }
            
            session.setAttribute("errorMsgs", CerrorMsgs);
            if (!CerrorMsgs.getErrorMsg().equals(""))
            {
                // if error messages
                currentUser.setUsername(username);
                currentUser.setPassword(password);
                session.setAttribute("USERS", currentUser);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
            else
            {
                /* Sets the role attribute for the user that just logged in
                 * so that other pages can use the role info. */
                session.setAttribute("LOGIN_ROLE", currentUser.getRole());
                String url;
                
                /* Goes to the home corresponding to the role. */
                if (currentUser.getRole().equals("FM"))
                {
                    url = "/FM_Home.jsp";
                }
                else if (currentUser.getRole().equals("U"))
                {
                    url = "/UserHome.jsp";
                }
                else if (currentUser.getRole().equals("A"))
                {
                    url = "/AdminHome.jsp";
                }
                else /* getRole() == "R" */
                {
                    url = "/Repairer_Home.jsp";
                }
                
                session.setAttribute("username", username);
                request.setAttribute("username", username);
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
        
    }
}