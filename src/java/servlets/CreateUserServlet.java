/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.Controller;
import control.InvalidDataException;
import control.UserDTO;
import control.UserValidator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pernille
 */
@WebServlet(name = "CreateUserServlet", urlPatterns
        = {
            "/CreateUserServlet"
        })
public class CreateUserServlet extends HttpServlet {

    UserValidator uv = new UserValidator();
    Controller ctrl = new Controller();
    private String answer = null;

    private int employeeID;
    private int partnerID;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String userType;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidDataException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().getAttribute("user");
    try{
        try {
            firstname = request.getParameter("firstname");
            lastname = request.getParameter("lastname");
            username = request.getParameter("username");
            password = request.getParameter("password");
            String repeatPassword = request.getParameter("repeatPassword");
            try {
                partnerID = Integer.valueOf(request.getParameter("partnerID"));

            } catch (NumberFormatException nfe) {
                request.setAttribute("validateMsg", "partnerID must not contain letters");
                request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
            }
            try {
                employeeID = Integer.valueOf(request.getParameter("employeeID"));

            } catch (NumberFormatException nfe) {
                request.setAttribute("validateMsg", "employeeID must not contain letters");
                request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
            }
                
            answer = uv.userValidator(firstname, lastname, username, password, repeatPassword, partnerID, employeeID);
        } catch (InvalidDataException ide) {
            request.setAttribute("validateMsg", ide.getMessage());
            request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
        }
        userType = request.getParameter("userType");
        UserDTO user = new UserDTO(username, password, partnerID, employeeID, firstname, lastname, userType);
        UserDTO user2 = ctrl.createUser(user);
        request.setAttribute("user", user2);
        request.setAttribute("validateMsg", "User created");
        request.getRequestDispatcher("ViewUserCreated.jsp").forward(request, response);
    }
    catch(Exception e)
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InvalidDataException ex) {
            Logger.getLogger(CreateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CreateUserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
