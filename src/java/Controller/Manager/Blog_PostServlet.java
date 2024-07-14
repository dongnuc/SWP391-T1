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
@WebServlet("/UploadServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class Blog_PostServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
        
        String from =  request.getParameter("from");
        request.setAttribute("from", from);
        
        List<StudentClub> StudentClubList = null;

        boolean restricted = true;

        if (acc != null) {
            StudentClubDAO studentClubDAO = new StudentClubDAO();
            StudentClubList = studentClubDAO.getStudentClubs(acc.getId());

            for (StudentClub studentClub : StudentClubList) {
                if (studentClub.getStatus() == 1 && studentClub.getLeader() == 1) {
                    restricted = false;
                    break;
                }
            }
        }

        if (restricted) {
            response.sendRedirect(request.getContextPath() + "/View/ViewManager/404.html");
            return;
        }

        SettingDAO settingDAo = new SettingDAO();
        List<Settings> blogTypeList = settingDAo.getSettingsBlog();

        ClubDao clubDAO = new ClubDao();

        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("StudentClubList", StudentClubList);
        request.setAttribute("blogTypeList", blogTypeList);
        request.getRequestDispatcher("/View/ViewManager/Blog_Post.jsp").forward(request, response);
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
        for (Part part : request.getParts()) {
            if (part.getName().equals("file")) {
                fileName = extractFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    part.write(savePath + File.separator + fileName);
                }
            }
        }

        BlogDAO postDAO = new BlogDAO();
        String filenamecheck = Integer.toString(postDAO.getAllPosts().size());

        if (fileName != null) {
            String from = request.getParameter("from");
            String Title = request.getParameter("title");
            String Description = request.getParameter("description");
            String Content = request.getParameter("content");
            String xShow = request.getParameter("visibility");
            String xBlogtype = request.getParameter("blogtype");
            String xStatus = request.getParameter("status");
            String xIDClub = request.getParameter("idclub");

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
            if (fileName.equals(filenamecheck) || fileName.isEmpty()) {
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

                request.setAttribute("title", Title);
                request.setAttribute("description", Description);
                request.setAttribute("content", Content);
                request.setAttribute("visibility", xShow);
                request.setAttribute("blogtype", xBlogtype);
                request.setAttribute("status", xStatus);
                request.setAttribute("idclub", xIDClub);
                request.setAttribute("fileName", fileName);

                SettingDAO settingDAo = new SettingDAO();
                List<Settings> blogTypeList = settingDAo.getSettingsBlog();

                ClubDao clubDAO = new ClubDao();

                Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
                StudentClubDAO studentClubDAO = new StudentClubDAO();
                List<StudentClub> StudentClubList = studentClubDAO.getStudentClubs(acc.getId());

                request.setAttribute("StudentClubList", StudentClubList);
                request.setAttribute("clubDAO", clubDAO);
                request.setAttribute("blogTypeList", blogTypeList);
                request.getRequestDispatcher("View/ViewManager/Blog_Post.jsp").forward(request, response);
                return;
            }
            int Show = Integer.parseInt(xShow);
            int Blogtype = Integer.parseInt(xBlogtype);
            int Status = Integer.parseInt(xStatus);
            int IDClub = Integer.parseInt(xIDClub);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            Blog post = new Blog(Title, "images_blog" + "/" + fileName, Description, Content, timestamp, timestamp, Blogtype, IDClub, Show, Status);
            postDAO.insertPost(post);

            if ("Blog_PostList.jsp".equals(from)) {
                request.getRequestDispatcher("/BlogPostListServlet").forward(request, response);
            }
            if ("Blog_List.jsp".equals(from)) {
                request.getRequestDispatcher("/BlogListServlet").forward(request, response);
            }
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
                return postDAO.getAllPosts().size() + filename;
            }
        }
        return null;
    }

}
