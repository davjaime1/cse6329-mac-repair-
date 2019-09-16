package mac_repair.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.UserDAO;
import mac_repair.model.User;

@WebServlet("/AdminSpecificUserController")
public class AdminSpecificUserController extends HttpServlet
{
    private static final long serialVersionUID = -617967594294823878L;
    
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
            User selectedUser = UserDAO.listUserWithUsername(usernameStr).get(0);
            
            session.setAttribute("ad_user_username", selectedUser.getUsername());
            session.setAttribute("ad_user_id", selectedUser.getId());
            session.setAttribute("ad_user_firstname", selectedUser.getFirstname());
            session.setAttribute("ad_user_lastname", selectedUser.getLastname());
            session.setAttribute("ad_user_password", selectedUser.getPassword());
            session.setAttribute("ad_user_role", selectedUser.getRole());
            session.setAttribute("ad_user_address", selectedUser.getAddress());
            session.setAttribute("ad_user_city", selectedUser.getCity());
            session.setAttribute("ad_user_state", selectedUser.getState());
            session.setAttribute("ad_user_zip", selectedUser.getZip());
            session.setAttribute("ad_user_phone", selectedUser.getPhone());
            session.setAttribute("ad_user_email", selectedUser.getEmail());
            
            getServletContext().getRequestDispatcher("/AdminSpecificUser.jsp").forward(request, response);
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
            String newFirstName = request.getParameter("firstnameTextBox").trim();
            String newRoleId = request.getParameter("roleDropDown");
            
            /* In the event that no fields are changed, then just show the same page
             * with a red error message. */
            if (newFirstName.isEmpty() &&
                    newRoleId.equalsIgnoreCase("default"))
            {
                request.setAttribute("ERR_MSG", "No change made.");
                getServletContext().getRequestDispatcher("/AdminSpecificUser.jsp").forward(request, response);
            }
            else
            {
                User updatedUser = UserDAO.listUserWithUsername((String) session.getAttribute("ad_user_username")).get(0);
                
                /* Check fields one by one. If they have data, use the new data. If they are empty,
                 * use the original value. */
                if (!newFirstName.isEmpty())
                {
                    updatedUser.setFirstname(newFirstName);
                }
                
                if (!newRoleId.equalsIgnoreCase("default"))
                {
                    updatedUser.setRole(newRoleId);
                }
                
                
                /* Send update to the database. */
                UserDAO.updateUser(updatedUser);
                
                /* Refresh the page with the new changes.. */
                response.sendRedirect("/mac_repair/AdminSpecificUserController?action=ListSpecificUserAction&username=" + updatedUser.getUsername());
            }
        }
        else
        {
            System.out.println("ERROR: AdminSpecificUserController: INCORRECT ACTION at doPost()");
            response.getWriter().append("Served at: ").append(request.getContextPath());
        }
    }
}
