/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Guest;

import DAO.AccountDao;
import Model.Accounts;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

/**
 *
 * @author 84358
 */
@WebServlet(name = "uploadavatar", urlPatterns = {"/uploadavatar"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class uploadavatar extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet uploadavatar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet uploadavatar at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
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
        Part filePart = request.getPart("input-file");
        String x = request.getParameter("x");
        String y = request.getParameter("y");
        System.out.println(x);
        String width = request.getParameter("width");
        String height = request.getParameter("height");
        AccountDao acc = new AccountDao();
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("account");
        if (filePart != null && x != null && y != null && width != null && height != null) {
            Accounts account = acc.getAccount(email);
            int id=account.getId();
            String fileName = id + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String appPath = request.getServletContext().getRealPath("");
            appPath = appPath.substring(0, appPath.length() - 11) + "/web/images";
            fileName = fileName.replaceAll("\\s", "");
            String filePath = appPath + "/" + fileName;
            try (InputStream fileContent = filePart.getInputStream()) {
                BufferedImage originalImage = ImageIO.read(fileContent);
                int cropX = Math.round(Float.parseFloat(x));
                int cropY = Math.round(Float.parseFloat(y));
                int cropWidth = Math.round(Float.parseFloat(width));
                int cropHeight = Math.round(Float.parseFloat(height));
                BufferedImage croppedImage = originalImage.getSubimage(cropX, cropY, cropWidth, cropHeight);
                File outputfile = new File(filePath);
                ImageIO.write(croppedImage, "png", outputfile);
                
                String oldImage = account.getImage();
                
                if(oldImage!=null){
                String result = oldImage.substring(oldImage.lastIndexOf("/") + 1);
                File oldFile = new File(appPath + "/" + result);
                if (oldFile.exists()) {
                    oldFile.delete();
                }
                }
                

                String newFilePath = "images/" + fileName;
                acc.UpdateImage(email, newFilePath);
                try {
                    
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                response.sendRedirect("profile");
            } catch (IOException e) {
                response.getWriter().println("Error processing file: " + e.getMessage());
            }
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
