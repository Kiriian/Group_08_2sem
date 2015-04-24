package servlets;

import control.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import control.InvalidDataException;
import control.ProjectDTO;
import control.Validator;

/**
 *
 * @author Pernille
 */
@WebServlet(name = "CreateProject", urlPatterns =
{
    "/createProject"
})

public class CreateProjectServlet extends HttpServlet
{

    String startDate, endDate, currency, activityDescription, comments,
            targetAudience, objectiveResult, firstname, lastname, phone, status;
    int projectBudget, partnerID;

    Controller controller = new Controller();
    Validator v = new Validator();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().getAttribute("user");
        
        try
        {
            status = request.getParameter("status");
            startDate = request.getParameter("startDate");   //request.getParameter henter string fra tekst feltet som har navnet indskrevet i stringen
            endDate = request.getParameter("endDate");
            try
            {
                projectBudget = Integer.valueOf(request.getParameter("budget"));
            } catch (NumberFormatException ex)
            {
                request.setAttribute("validateMsg", "Budget cannot contain letters");
                RequestDispatcher rd = request.getRequestDispatcher("CreateProject.jsp");
                rd.forward(request, response);
            }
//            String budgetText = request.getParameter("budget");
//            System.out.println("budget: "+budgetText);
//            budget = Integer.valueOf(budgetText);
            currency = request.getParameter("currency");
            activityDescription = request.getParameter("activityDescription");
            comments = request.getParameter("comments");
            targetAudience = request.getParameter("targetAudience");
            objectiveResult = request.getParameter("objectiveResult");
            try
            {
                partnerID = Integer.valueOf(request.getParameter("partnerID"));
            } catch (NumberFormatException nfe)
            {
                request.setAttribute("validateMsg", "PartnerID cannot contain letters");
                RequestDispatcher rd = request.getRequestDispatcher("CreateProject.jsp");
                rd.forward(request, response);
            }
            firstname = request.getParameter("firstName");
            lastname = request.getParameter("lastName");
            phone = request.getParameter("phone");

            try
            {
                v.validator(projectBudget, partnerID, startDate, endDate, activityDescription, targetAudience, objectiveResult, firstname, lastname, phone);
            } catch (InvalidDataException ex)
            {
                request.setAttribute("validateMsg", ex.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("CreateProject.jsp");
                rd.forward(request, response);
            }
            ProjectDTO p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, partnerID, firstname, lastname, phone, projectBudget);
            controller.SaveProject(p);
            request.setAttribute("Project", p);
            request.getRequestDispatcher("projectCreated.jsp").forward(request, response);
        } catch (Exception e)
        {
            PrintWriter out = response.getWriter();
            out.println("<h2>" + e + "</h2>");
            out.print("<pre>");
            e.printStackTrace(out);
            out.println("</pre>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(CreateProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(CreateProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(CreateProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(CreateProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
