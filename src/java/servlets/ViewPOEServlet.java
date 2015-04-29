package servlets;

import control.Controller;
import control.ImageDTO;
import control.InvalidDataException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
    "/ViewPOEServlet"
})
@MultipartConfig
public class ViewPOEServlet extends HttpServlet
{

    private static final int BUFFER_SIZE = 4096;
    private Controller ctrl = new Controller();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InvalidDataException
    {
        response.setContentType("text/html;charset=UTF-8");
        request.getSession().getAttribute("user");
        ArrayList<ImageDTO> imageOut;
        int projectID = Integer.valueOf(request.getParameter("projectid"));

        imageOut = ctrl.getImage(projectID);

        for (ImageDTO image : imageOut)
        {
            response.setContentType(image.getContentType());
            try (OutputStream out = response.getOutputStream())
            {
                InputStream in = image.getInputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                do
                {
                    count = in.read(buffer);
                    out.write(buffer, 0, count);
                } while (count == 1024);
                in.close();
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
            throws ServletException, IOException
    {
        try
        {
            processRequest(request, response);

        } catch (InvalidDataException ex)
        {
            Logger.getLogger(ViewPOEServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ViewPOEServlet.class
                    .getName()).log(Level.SEVERE, null, ex);
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
