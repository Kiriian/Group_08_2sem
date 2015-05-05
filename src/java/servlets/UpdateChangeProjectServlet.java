/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.Controller;
import control.InvalidDataException;
import control.ProjectDTO;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeanette
 */
@WebServlet(name = "UpdateChangeProjectServlet", urlPatterns
        = {
            "/UpdateChangeProjectServlet"
        })
public class UpdateChangeProjectServlet extends HttpServlet {

    private Controller ctrl = new Controller();
    private int projectCost;
    private int projectBudget;
    private int partnerID;
    private int projectID;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws control.InvalidDataException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidDataException {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().getAttribute("user");
        String types = request.getParameter("usertype");
        if (types.equalsIgnoreCase("dell")) {
            String status = request.getParameter("status");
            if (!status.equals("Project proposal") && !status.equals("POE uploaded") && !status.equals("Execution") && !status.equals("Claim uploaded")) {
                String startDate = request.getParameter("startDate");   //request.getParameter henter string fra tekst feltet som har navnet indskrevet i stringen
                String endDate = request.getParameter("endDate");
                try {
                    projectBudget = Integer.valueOf(request.getParameter("budget"));
                } catch (NumberFormatException ex) {
                    request.setAttribute("validateMsg", "Budget cannot contain letters");
                    RequestDispatcher rd = request.getRequestDispatcher("ChangeProject.jsp");
                    rd.forward(request, response);
                }
                String currency = request.getParameter("currency");
                String activityDescription = request.getParameter("activityDescription");
                String comments = request.getParameter("comments");
                String targetAudience = request.getParameter("targetAudience");
                String objectiveResult = request.getParameter("objectiveResult");
                try {
                    partnerID = Integer.valueOf(request.getParameter("partnerID"));
                } catch (NumberFormatException nfe) {
                    request.setAttribute("validateMsg", "PartnerID cannot contain letters");
                    RequestDispatcher rd = request.getRequestDispatcher("ChangeProject.jsp");
                    rd.forward(request, response);
                }
                String requiredPOE = request.getParameter("requiredPOE");
                try {
                    projectCost = Integer.valueOf(request.getParameter("cost"));
                } catch (NumberFormatException nfe) {
                    request.setAttribute("validateMsg", "Cost cannot contain letters");
                    RequestDispatcher rd = request.getRequestDispatcher("ChangeProject.jsp");
                    rd.forward(request, response);
                }
                int employeeID = Integer.valueOf(request.getParameter("employeeID"));
                String quarter = request.getParameter("quarter");
                projectID = Integer.valueOf(request.getParameter("projectID"));

                ProjectDTO p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, partnerID, projectBudget, projectCost, requiredPOE, employeeID, projectID, quarter);
                ctrl.updateProject(p);
                String confirm = "Project " + projectID + " have been changed, you can now view the changed project by doing a search";
                request.setAttribute("projectHaveBeenChanged", confirm);
                request.getRequestDispatcher("SearchProject.jsp").forward(request, response);
            } else {
                request.setAttribute("validateMsg", "You do not have the credentials to use the status: " + status);
                RequestDispatcher rd = request.getRequestDispatcher("ChangeProject.jsp");
                rd.forward(request, response);
            }
        } else {
            String status = request.getParameter("status");
            if (!status.equals("Project approval") && !status.equals("POE approval") && !status.equals("Reimburse") && !status.equals("Claim approved")) {
                String startDate = request.getParameter("startDate");   //request.getParameter henter string fra tekst feltet som har navnet indskrevet i stringen
                String endDate = request.getParameter("endDate");
                try {
                    projectBudget = Integer.valueOf(request.getParameter("budget"));
                } catch (NumberFormatException ex) {
                    request.setAttribute("validateMsg", "Budget cannot contain letters");
                    RequestDispatcher rd = request.getRequestDispatcher("ChangeProject.jsp");
                    rd.forward(request, response);
                }
                String currency = request.getParameter("currency");
                String activityDescription = request.getParameter("activityDescription");
                String comments = request.getParameter("comments");
                String targetAudience = request.getParameter("targetAudience");
                String objectiveResult = request.getParameter("objectiveResult");
                try {
                    partnerID = Integer.valueOf(request.getParameter("partnerID"));
                } catch (NumberFormatException nfe) {
                    request.setAttribute("validateMsg", "PartnerID cannot contain letters");
                    RequestDispatcher rd = request.getRequestDispatcher("ChangeProject.jsp");
                    rd.forward(request, response);
                }
                String requiredPOE = request.getParameter("requiredPOE");
                try {
                    projectCost = Integer.valueOf(request.getParameter("cost"));
                } catch (NumberFormatException nfe) {
                    request.setAttribute("validateMsg", "Cost cannot contain letters");
                    RequestDispatcher rd = request.getRequestDispatcher("ChangeProject.jsp");
                    rd.forward(request, response);
                }
                int employeeID = Integer.valueOf(request.getParameter("employeeID"));
                String quarter = request.getParameter("quarter");
                projectID = Integer.valueOf(request.getParameter("projectID"));

                ProjectDTO p = new ProjectDTO(status, startDate, endDate, currency, activityDescription, comments, targetAudience, objectiveResult, partnerID, projectBudget, projectCost, requiredPOE, employeeID, projectID, quarter);
                ctrl.updateProject(p);
                String confirm = "Project " + projectID + " have been changed, you can now view the changed project by doing a search";
                request.setAttribute("projectHaveBeenChanged", confirm);
                request.getRequestDispatcher("SearchProject.jsp").forward(request, response);
            } else {
                request.setAttribute("validateMsg", "You do not have the credentials to use the status: " + status);
                RequestDispatcher rd = request.getRequestDispatcher("ChangeProject.jsp");
                rd.forward(request, response);
            }

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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InvalidDataException ex) {
            Logger.getLogger(UpdateChangeProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InvalidDataException ex) {
            Logger.getLogger(UpdateChangeProjectServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
