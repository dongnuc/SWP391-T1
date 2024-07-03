/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.BlogDAO;
import DAO.BlogTypeDAO;
import DAO.ClubDao;
import DAO.StudentClubDAO;
import Model.Accounts;
import Model.Blog;
import Model.BlogType;
import Model.StudentClub;
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
@WebServlet(name="BlogListServlet", urlPatterns={"/BlogListServlet"})
public class Blog_ListServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        BlogDAO postDAO = new BlogDAO();
        ClubDao clubDAO = new ClubDao();
        BlogTypeDAO blogTypeDAO = new BlogTypeDAO();
        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");

        List<BlogType> blogTypeList = blogTypeDAO.getAllPosts();
        List<Blog> postList = postDAO.getAllPosts();

        request.setAttribute("blogTypeList", blogTypeList);
        request.setAttribute("postList", postList);
        request.setAttribute("curruser", acc);
        request.setAttribute("clubDAO", clubDAO);

        if (acc != null) {
            StudentClubDAO studentClubDAO = new StudentClubDAO();
            List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(acc.getId());
            request.setAttribute("StudentClubList", studentClubList);
        }
        
        request.getRequestDispatcher("/View/ViewManager/Blog_List.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

 
}
