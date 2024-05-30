/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.*;
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.text.SimpleDateFormat;

/**
 *
 * @author 10t1q
 */
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class UploadServlet extends HttpServlet {

    private static final String SAVE_DIR = "web/images";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xappPath = request.getServletContext().getRealPath("");
        String appPath = xappPath.substring(0, xappPath.length() - 11);
        System.out.println(appPath);
        String savePath = appPath + File.separator + SAVE_DIR;
        
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        String fileName = null;
        for (Part part : request.getParts()) {
            if (part.getName().equals("file")) {
                fileName = extractFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    part.write(savePath + File.separator + fileName);
                }
            }
        }

        if (fileName != null) {
            String Tittle = request.getParameter("tittle");
            String Description = request.getParameter("description");
            
            java.util.Date date = new java.util.Date();
            
            String xShow = request.getParameter("visibility");
            int Show = Integer.parseInt(xShow);
            String xStatus = request.getParameter("status");
            int Status =Integer.parseInt(xStatus);
            String xIDClub = request.getParameter("idclub");
            int IDClub = Integer.parseInt(xIDClub);
            
            Blog post = new Blog( Tittle,"images" + "/" + fileName,Description,date,date,IDClub,Show,Status);
            BlogDAO postDAO = new BlogDAO();
            postDAO.insertPost(post);
            
            getServletContext().getRequestDispatcher("/View/ViewManager/Upload_Noti.jsp").forward(request, response);
        } else {
            response.getWriter().println("Error: File upload failed.");
        }
    }

    private String extractFileName(Part part) {
        BlogDAO postDAO = new BlogDAO();
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String filename = s.substring(s.indexOf("=") + 2, s.length() - 1);
                return postDAO.getAllPosts().size()+filename ;
            }
        }
        return null;
    }
}