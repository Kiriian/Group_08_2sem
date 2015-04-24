/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.Controller;
import control.InvalidDataException;
import control.UserDTO;
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
@WebServlet(name = "LogInServlet", urlPatterns =
{
    "/LogInServlet"
})
public class LogInServlet extends HttpServlet
{
    private Controller ctrl = new Controller();
    private String username;
    private String password;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidDataException
    {
        response.setContentType("text/html;charset=UTF-8");

        username = request.getParameter("username");
        password = request.getParameter("password");

        if (username.isEmpty() || password.isEmpty())
        {
            request.setAttribute("validateMsg", "Inputfields cannot be empty");
            request.getRequestDispatcher("LogIn.jsp").forward(request, response);
        }
        UserDTO sessionUser;
        sessionUser = ctrl.validateCheckLogin(username, password);
        request.getSession().setAttribute("user", sessionUser);
        
        if (sessionUser != null)
        {
            request.getRequestDispatcher("Welcome.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("validateMsg", "Login information is incorrect");
            request.getRequestDispatcher("LogIn.jsp").forward(request, response);
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
        } 
         catch (InvalidDataException ide)
        {
            Logger.getLogger(LogInServlet.class.getName()).log(Level.SEVERE, null, ide);
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
            Logger.getLogger(LogInServlet.class.getName()).log(Level.SEVERE, null, ide);
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
