package mac_repair.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.UserDAO;
import mac_repair.data.UtilityDAO;
import mac_repair.model.User;

@WebServlet("/AdminController")
public class AdminController extends HttpServlet
{
    private static final long serialVersionUID = 8863805250639561263L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("SearchUsersAction"))
        {
            session.setAttribute("ROLES", UtilityDAO.listRoles());
            getServletContext().getRequestDispatcher("/AdminSearchUsers.jsp").forward(request, response);
        }
        else 
        {
            ArrayList<User> usersInDB = UserDAO.listAllUsers();
            
            /* Removes self from user list before displaying it. */
            String loginUsername = (String) session.getAttribute("username");
            usersInDB.removeIf(u -> (u.getUsername().equals(loginUsername)));
            
            session.setAttribute("USERS", usersInDB);
            getServletContext().getRequestDispatcher("/AdminUserList.jsp").forward(request, response);
        }
  
    }
    
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException
    {
        final String ERROR_ATTR = "ERR_MSG";
        HttpSession session = request.getSession();
        session.removeAttribute(ERROR_ATTR);
     
        
        
      
            String roleIdStr = request.getParameter("roleDropDown");
 
                ArrayList<User> usersInDB = UserDAO.listUsersWithRole(roleIdStr);
                session.setAttribute("USERS", usersInDB);
                getServletContext().getRequestDispatcher("/AdminUserList.jsp").forward(request, response);
      }
  
    
}
