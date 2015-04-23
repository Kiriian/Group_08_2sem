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

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int employeeID;
    int partnerID;
    String answer = null;
    Controller ctrl = new Controller();
    String firstname;
    String lastname;
    String username;
    String password;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidDataException {
        response.setContentType("text/html;charset=UTF-8");
        UserValidator uv = new UserValidator();

        try {

            firstname =request.getParameter("firstname");
            lastname = request.getParameter("lastname");
            username = request.getParameter("username");
            password = request.getParameter("password");
            String repeatPassword = request.getParameter("reapeatPassword");
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
            request.setAttribute("validateMsg", answer);
            request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
        }
        UserDTO user = new UserDTO(username, password,  partnerID, employeeID,firstname, lastname);
        ctrl.createUser(user);
        request.setAttribute("validateMsg", "User created");
        request.getRequestDispatcher("CreateUser.jsp").forward(request, response);
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
