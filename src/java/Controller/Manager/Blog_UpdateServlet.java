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

/**
 *
 * @author 10t1q
 */
@WebServlet(name="Blog_UpdateServlet", urlPatterns={"/BlogUpdateServlet"})
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class Blog_UpdateServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String xID = request.getParameter("idBlog");
        int ID = Integer.parseInt(xID);

        BlogDAO blogDAO = new BlogDAO();
        Blog blog = blogDAO.getPost(ID);

        
        request.setAttribute("x", blog);
        request.getRequestDispatcher("/View/ViewManager/Blog_Update.jsp").forward(request, response);
        
    } 

  
    private static final String SAVE_DIR = "web/images";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String xappPath = request.getServletContext().getRealPath("");
        String appPath = xappPath.substring(0, xappPath.length() - 11);
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        String fileName = null;
        boolean isFileUpdated = false;

        for (Part part : request.getParts()) {
            if (part.getName().equals("file") && part.getSize() > 0) {
                fileName = extractFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    part.write(savePath + File.separator + fileName);
                    isFileUpdated = true;
                }
            }
        }

        String xID = request.getParameter("idblog");
        int ID = Integer.parseInt(xID);
        String Title = request.getParameter("tittle");
        String Description = request.getParameter("description");
        String Content = request.getParameter("content");

        java.util.Date date = new java.util.Date();
        
        if (!isFileUpdated) {
            fileName = request.getParameter("img");
        } else {
            
            fileName = "images/" + fileName;
        }

        String xShow = request.getParameter("visibility");
        int Show = Integer.parseInt(xShow);
        String xBlogtype = request.getParameter("blogtype");
        int Blogtype = Integer.parseInt(xBlogtype);
        String xStatus = request.getParameter("status");
        int Status = Integer.parseInt(xStatus);
        String xIDClub = request.getParameter("idclub");
        int IDClub = Integer.parseInt(xIDClub);
        
        StringBuilder errorMessage = new StringBuilder();
        boolean hasError = false;

        if (Title == null || Title.isEmpty()) {
            errorMessage.append("Title cannot be empty.<br>");
            hasError = true;
        }
        if (Description == null || Description.isEmpty()) {
            errorMessage.append("Description cannot be empty.<br>");
            hasError = true;
        }
        if (Content == null || Content.isEmpty()) {
            errorMessage.append("Content cannot be empty.<br>");
            hasError = true;
        }
        if (xShow == null || xShow.isEmpty()) {
            errorMessage.append("Visibility must be selected.<br>");
            hasError = true;
        }
        if (xBlogtype == null || xBlogtype.isEmpty()) {
            errorMessage.append("Blog type must be selected.<br>");
            hasError = true;
        }
        if (xStatus == null || xStatus.isEmpty()) {
            errorMessage.append("Status must be provided.<br>");
            hasError = true;
        }
        if (xIDClub == null || xIDClub.isEmpty()) {
            errorMessage.append("Club must be selected.<br>");
            hasError = true;
        }
        if (fileName == null && !fileName.isEmpty()) {    
            errorMessage.append("File must be selected.<br>");
            hasError = true;
            }

        if (hasError) {
            request.setAttribute("mess", errorMessage.toString());
            request.setAttribute("title", Title);
            request.setAttribute("description", Description);
            request.setAttribute("content", Content);
            request.setAttribute("visibility", xShow);
            request.setAttribute("blogtype", xBlogtype);
            request.setAttribute("status", xStatus);
            request.setAttribute("idclub", xIDClub);
            request.getRequestDispatcher("/View/ViewManager/Blog_Update.jsp").forward(request, response);
            return;
        }
        
        Blog post = new Blog( Title, fileName, Description, Content, date, Blogtype,IDClub, Show,Status ,ID);
        BlogDAO postDAO = new BlogDAO();
        postDAO.updatePost(post);

        getServletContext().getRequestDispatcher("/View/ViewManager/Upload_Noti.jsp").forward(request, response);
    }

    private String extractFileName(Part part) {
        BlogDAO postDAO = new BlogDAO();
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String filename = s.substring(s.indexOf("=") + 2, s.length() - 1);
                return postDAO.getAllPosts().size()+filename;  
            }
        }
        return null;
    }

}
