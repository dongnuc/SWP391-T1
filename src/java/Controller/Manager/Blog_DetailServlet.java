/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.*;
import Model.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author 10t1q
 */
@WebServlet(name="Upload_Content_Blog", urlPatterns={"/UploadContentBlog"})
public class Blog_DetailServlet extends HttpServlet {
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ID = request.getParameter("idBlog");
        int xId = Integer.parseInt(ID);
        
        BlogDAO postDAO = new BlogDAO();
        Blog post = postDAO.getPost(xId);
        List<Blog> lastest5Post = postDAO.getLatestPosts(5);
        
        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
        List<StudentClub> studentClubList = null;
        if (acc != null) {
            StudentClubDAO studentClubDAO = new StudentClubDAO();
            studentClubList = studentClubDAO.getStudentClubs(acc.getId());
        }
        
        ClubDao clubDAO = new ClubDao();
        
        request.setAttribute("x", post);
        request.setAttribute("lastest5Post", lastest5Post);
        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("StudentClubList", studentClubList);
        request.setAttribute("curruser", acc);

        request.getRequestDispatcher("/View/ViewManager/Blog_Detail.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

}
