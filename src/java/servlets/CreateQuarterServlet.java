/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.Controller;
import control.InvalidDataException;
import control.QuarterDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeanette
 */
@WebServlet(name = "CreateQuarterServlet", urlPatterns =
{
    "/CreateQuarterServlet"
})
public class CreateQuarterServlet extends HttpServlet
{

    Controller ctrl = new Controller();

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
            throws ServletException, IOException, InvalidDataException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().getAttribute("user");
        try
        {
            int quarterBudget = 0;
            String quarterName = request.getParameter("quarterName");
            if (quarterName.isEmpty())
            {
                request.setAttribute("validateMsg", "Quarter name cannot be empty");
                request.getRequestDispatcher("CreateQuarter.jsp").forward(request, response);
            }
            try
            {
                quarterBudget = Integer.valueOf(request.getParameter("quarterBudget"));
            } catch (NumberFormatException nfe)
            {
                request.setAttribute("validateMsg", "Quarter budget cannot contain letters or be empty");
                request.getRequestDispatcher("CreateQuarter.jsp").forward(request, response);
            }

            QuarterDTO quarter = new QuarterDTO(quarterName, quarterBudget);
            QuarterDTO quarter2 = ctrl.createQuarter(quarter);
            request.setAttribute("quarter", quarter2);
            request.getRequestDispatcher("ViewCreatedQuarter.jsp").forward(request, response);
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
        } catch (InvalidDataException ex)
        {
            Logger.getLogger(CreateQuarterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InvalidDataException ex)
        {
            Logger.getLogger(CreateQuarterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
