/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import control.ClaimDTO;
import control.Controller;
import control.ImageDTO;
import control.InvalidDataException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jeanette
 */
@WebServlet(name = "ViewClaimServlet", urlPatterns = {"/ViewClaimServlet"})
public class ViewClaimServlet extends HttpServlet {
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
            throws ServletException, IOException, InvalidDataException {
        response.setContentType("text/html;charset=UTF-8");
        
        int projectID = Integer.valueOf(request.getParameter("projectid"));
        ClaimDTO image = ctrl.getClaim(projectID);
        // vi sætter cpntentType, så siden ved hvilket format den skal forvente.
        response.setContentType(image.getContentType());
        // her efter åbner vi outputStream for at kunne få billedet eller filen læst ud på en hjemmeside
        //så brugerne kan se den.
        try (ServletOutputStream out2 = response.getOutputStream()) {
            //her henter vi inputstreamen fra ImageDTO'en
            InputStream in = image.getInputStream();
            //så sætter vi antallet af bytes den skal læse
            //På grund af vores do while vil den blive ved med at læse fra filen indtil filen er tom.
            byte[] buffer = new byte[1024];
            int count = 0;
            do {
                count = in.read(buffer);
                out2.write(buffer, 0, count);
            } while (count == 1024);
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
            Logger.getLogger(ViewClaimServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewClaimServlet.class.getName()).log(Level.SEVERE, null, ex);
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
