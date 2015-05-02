/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.Controller;
import control.EmployeeDTO;
import control.InvalidDataException;
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
 * @author Pernille
 */
@WebServlet(name = "CreateEmployeeServlet", urlPatterns =
{
    "/CreateEmployeeServlet"
})
public class CreateEmployeeServlet extends HttpServlet
{

    Controller ctrl = new Controller();
    private String firstname;
    private String lastname;
    private String country;
    private String employeeType;

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
        try {
            firstname = request.getParameter("firstname");
            lastname = request.getParameter("lastname");
            country = request.getParameter("country");
            employeeType = request.getParameter("employeeType");
            if(firstname.isEmpty()|| lastname.isEmpty())
            {
                request.setAttribute("validateMsg", "Enter data in all fields");
                request.getRequestDispatcher("CreateEmployee.jsp").forward(request, response);
            }
        EmployeeDTO emp = new EmployeeDTO(firstname,lastname, country, employeeType);
        EmployeeDTO emp2 = ctrl.createEmployee(emp);
            System.out.println("emp er her: " + emp2.toString());
        request.setAttribute("emp", emp2);
        request.getRequestDispatcher("ViewCreatedEmployee.jsp").forward(request, response);
        }
        catch (Exception e)
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
            Logger.getLogger(CreateEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CreateEmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
