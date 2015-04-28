package servlets;

import control.Controller;
import control.InvalidDataException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
@WebServlet(name = "ViewPOE", urlPatterns =
{
    "/ViewPOE"
})
public class ViewPOEServlet extends HttpServlet
{

    private static final int BUFFER_SIZE = 4096;
    private Controller ctrl = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidDataException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().getAttribute("user");
        InputStream inputStream = null;
        OutputStream outStream = null;
        int projectID = Integer.valueOf(request.getParameter("projectid"));

        inputStream = ctrl.getImage(projectID);
        if (inputStream != null)
        {
            int fileLength = inputStream.available();

            response.setContentLength(fileLength);
            outStream = response.getOutputStream();

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;

            while ((bytesRead = inputStream.read(buffer)) > 0)
            {
                outStream.write(buffer, 0, bytesRead);
            }
        }
        else
        {
            request.setAttribute("validateMsg", "Image not found");
            request.getRequestDispatcher("ViewPOE.jsp").forward(request, response);
        }
            request.getRequestDispatcher("ViewPOE.jsp").forward(request, response);
            inputStream.close();
            outStream.close();
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
            Logger.getLogger(ViewPOEServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewPOEServlet.class.getName()).log(Level.SEVERE, null, ex);
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
