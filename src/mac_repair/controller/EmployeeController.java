package mac_repair.controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mac_repair.data.EmployeeDAO;
import mac_repair.model.*;

@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet
{
    
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        
        String action = request.getParameter("action"), url = "";
        HttpSession session = request.getSession();
        // insert employee
        if (action.equals("insertEmployee"))
        {
            if (request.getParameter("insertEmpbutton") != null)
            {  // insert employee button pressed
                Employee employee = new Employee();
                Company company = (Company) session.getAttribute("company");
                employee.setEmployee(request.getParameter("idemployee"), request.getParameter("name"), request.getParameter("surname"), request.getParameter("badge"));
                EmployeeErrorMsgs EerrorMsgs = new EmployeeErrorMsgs();
                employee.validateEmployee(employee, EerrorMsgs);
                employee.setFk_company(company.getIdcompany());
                session.setAttribute("employee", employee);
                session.setAttribute("errorMsgs", EerrorMsgs);
                if (EerrorMsgs.getErrorMsg().equals(""))
                {
                    EmployeeDAO.insertEmployee(employee);
                    session.removeAttribute("employee");
                }
                url = "/formEmployee.jsp";
            }
            else
            { // done button pressed
                session.removeAttribute("company");
                session.removeAttribute("employee");
                session.removeAttribute("COMPANIES");
                session.removeAttribute("errorMsgs");
                url = "/index.jsp";
            }
        }
        // list employee
        else
        { // (action.equalsIgnoreCase("searchEmployee") )
            String companyID = request.getParameter("idcompany");
            ArrayList<Employee> employeesInDB = new ArrayList<Employee>();
            Company company = new Company();
            CompanyErrorMsgs CerrorMsgs = new CompanyErrorMsgs();
            company.setIdcompany(request.getParameter("idcompany"));
            company.validateCompany(action, company, CerrorMsgs);
            if (CerrorMsgs.getErrorMsg().equals(""))
            {
                employeesInDB = EmployeeDAO.listEmployees(companyID);
                session.setAttribute("employees", employeesInDB);
                session.removeAttribute("company");
                session.removeAttribute("errorMsgs");
                url = "/listEmployee.jsp";
            }
            else
            {
                session.setAttribute("errorMsgs", CerrorMsgs);
                session.setAttribute("company", company);
                url = "/searchEmployee.jsp";
            }
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}
