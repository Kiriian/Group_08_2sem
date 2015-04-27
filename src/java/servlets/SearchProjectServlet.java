/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.Controller;
import control.InvalidDataException;
import data.Mapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pernille
 */
@WebServlet(name = "searchProject", urlPatterns =
{
    "/searchProject"
})
public class SearchProjectServlet extends HttpServlet
{
    private Controller ctrl = new Controller();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidDataException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().getAttribute("user");
        String status = request.getParameter("status");
        int partnerID = Integer.valueOf(request.getParameter("hiddenPartnerID"));
        try
        {
            if (partnerID == 0)
            {
                request.setAttribute("projects", ctrl.getAllProjects(status));
            }
            else
            {
                request.setAttribute("projects", ctrl.getAllPartnerProjects(status, partnerID));
            }

        } catch (InvalidDataException ide)
        {
            System.err.println(ide);
        }

        request.getRequestDispatcher("SearchProject.jsp").forward(request, response);
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
        } catch (InvalidDataException ide)
        {
            Logger.getLogger(SearchProjectServlet.class.getName()).log(Level.SEVERE, null, ide);
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
        } catch (InvalidDataException ide)
        {
            Logger.getLogger(SearchProjectServlet.class.getName()).log(Level.SEVERE, null, ide);
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
