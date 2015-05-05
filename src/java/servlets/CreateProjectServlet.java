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
    Controller ctrl = new Controller();
    Validator v = new Validator();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().getAttribute("user");
        int projectBudget = 0;
        int partnerID = 0;
        String startDate;
        String endDate;
        String currency;
        String activityDescription;
        String comments;
        String targetAudience;
        String objectiveResult;
        String status;
        
        
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
            try
            {
                //Vi giver validatoren alle variabler, og hvis der er nogen af dem der ikke overholder de kriterier vi har sat op
                // sider den vores egen exception: InvalidDataException, samt en relevant fejl besked.
                v.validator(projectBudget, partnerID, startDate, endDate, activityDescription, targetAudience, objectiveResult);
            } catch (InvalidDataException ex)
            {
                request.setAttribute("validateMsg", ex.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("CreateProject.jsp");
                rd.forward(request, response);
            }
            ProjectDTO p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, partnerID, projectBudget);
            ProjectDTO p2 = ctrl.SaveProject(p);
            request.setAttribute("Project", p2);
            request.getRequestDispatcher("ProjectCreatedView.jsp").forward(request, response);
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
