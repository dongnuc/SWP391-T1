/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.*;
import Model.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.sql.Timestamp;
import java.util.List;

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
        
        String fromPage = request.getParameter("from");
        request.setAttribute("fromPage", fromPage);

        String xID = request.getParameter("idBlog");
        int ID = Integer.parseInt(xID);
        
        ClubDao clubDAO = new ClubDao();
        BlogDAO blogDAO = new BlogDAO();
        
        Blog blog = blogDAO.getPost(ID);
        
        SettingDAO settingDAO = new SettingDAO();
        List<Settings> blogTypeList = settingDAO.getSettingsBlog();

        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
            StudentClubDAO studentClubDAO = new StudentClubDAO();
            List<StudentClub> StudentClubList = studentClubDAO.getStudentClubs(acc.getId());

            boolean restricted = true;
            for (StudentClub studentClub : StudentClubList) {
                if (studentClub.getStatus() == 1 && studentClub.getRole() == 1) {
                    restricted = false;
                    break;
                }
            }

            if (restricted) {
                response.sendRedirect(request.getContextPath() + "/View/ViewManager/404.html");
                return;
            }
            request.setAttribute("clubDAO", clubDAO);
            request.setAttribute("studentClubList", StudentClubList);
            request.setAttribute("blogTypeList", blogTypeList);
            request.setAttribute("x", blog);
            request.getRequestDispatcher("/View/ViewManager/Blog_Update.jsp").forward(request, response);
    }

  
    private static final String SAVE_DIR = "web/images_blog";

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
        String fromPage = request.getParameter("from");
        String xID = request.getParameter("idblog");
        int ID = Integer.parseInt(xID);
        String Title = request.getParameter("tittle");
        String Description = request.getParameter("description");
        String Content = request.getParameter("content");

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        if (!isFileUpdated) {
            fileName = request.getParameter("img");
        } else {
            
            fileName = "images_blog/" + fileName;
        }

        String xShow = request.getParameter("visibility");
        int Show = Integer.parseInt(xShow);
        String xBlogtype = request.getParameter("blogtype");
        int Blogtype = Integer.parseInt(xBlogtype);
        String xStatus = request.getParameter("status");
        int Status = Integer.parseInt(xStatus);
        String xIDClub = request.getParameter("idclub");
        int IDClub = Integer.parseInt(xIDClub);
        
        StringBuilder messTitle = new StringBuilder();
            StringBuilder messDescription = new StringBuilder();
            StringBuilder messContent = new StringBuilder();
            StringBuilder messxShow = new StringBuilder();
            StringBuilder messxBlogtype = new StringBuilder();
            StringBuilder messxStatus = new StringBuilder();
            StringBuilder messxIDClub = new StringBuilder();
            StringBuilder messfileName = new StringBuilder();
        boolean hasError = false;

        if (Title == null || Title.isEmpty()) {
                messTitle.append("Title cannot be empty.<br>");
                hasError = true;
            } else if (Title.length() > 128) {
                messTitle.append("Title cannot exceed 128 characters.<br>");
                hasError = true;
            }
        if (Description == null || Description.isEmpty()) {
                messDescription.append("Description cannot be empty.<br>");
                hasError = true;
            } else if (Description.length() > 256) {
                messDescription.append("Description cannot exceed 128 characters.<br>");
                hasError = true;
            }
            if (Content == null || Content.isEmpty()) {
                messContent.append("Content cannot be empty.<br>");
                hasError = true;
            }
            if (xShow == null || xShow.isEmpty()) {
                messxShow.append("Visibility must be selected.<br>");
                hasError = true;
            }
            if (xBlogtype == null || xBlogtype.isEmpty()) {
                messxBlogtype.append("Blog type must be selected.<br>");
                hasError = true;
            }
            if (xStatus == null || xStatus.isEmpty()) {
                messxStatus.append("Status must be provided.<br>");
                hasError = true;
            }
            if (xIDClub == null || xIDClub.isEmpty()) {
                messxIDClub.append("Club must be selected.<br>");
                hasError = true;
            }
        if (fileName == null && !fileName.isEmpty()) {    
            messfileName.append("File must be selected.<br>");
            hasError = true;
            }

        if (hasError) {
            request.setAttribute("messTitle", messTitle);
                request.setAttribute("messDescription", messDescription);
                request.setAttribute("messContent", messContent);
                request.setAttribute("messxShow", messxShow);
                request.setAttribute("messxBlogtype", messxBlogtype);
                request.setAttribute("messxStatus", messxStatus);
                request.setAttribute("messxIDClub", messxIDClub);
                request.setAttribute("messfileName", messfileName);
                
            BlogDAO blogDAO = new BlogDAO();
            Blog blog = blogDAO.getPost(ID);
            request.setAttribute("x", blog);
            
            Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
            
            StudentClubDAO studentClubDAO = new StudentClubDAO();
            List<StudentClub> StudentClubList = studentClubDAO.getStudentClubs(acc.getId());
            
            SettingDAO settingDAo = new SettingDAO();
            List<Settings> blogTypeList = settingDAo.getSettingsBlog();
            
            ClubDao clubDAO = new ClubDao();
            
            request.setAttribute("studentClubList", StudentClubList);
            request.setAttribute("blogTypeList", blogTypeList);
            request.setAttribute("clubDAO", clubDAO);
            request.setAttribute("fromPage", fromPage);
            request.getRequestDispatcher("/View/ViewManager/Blog_Update.jsp").forward(request, response);
            return;
        }
        
        Blog post = new Blog( Title, fileName, Description, Content, timestamp, Blogtype,IDClub, Show,Status ,ID);
        BlogDAO postDAO = new BlogDAO();
        postDAO.updatePost(post);

        if ("Blog_PostList.jsp".equals(fromPage)) {
        request.getRequestDispatcher("/BlogPostListServlet").forward(request, response);
    } if ("Blog_List.jsp".equals(fromPage)) {
        request.getRequestDispatcher("/BlogListServlet").forward(request, response);
    }
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
