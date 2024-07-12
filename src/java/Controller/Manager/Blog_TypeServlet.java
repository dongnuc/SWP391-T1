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
@WebServlet(name="Blog_TypeServlet", urlPatterns={"/BlogTypeServlet"})
public class Blog_TypeServlet extends HttpServlet {
   
 
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
        String ID = request.getParameter("idBlogType");
        int xId = Integer.parseInt(ID);
        
        String from = request.getParameter("from");
   
        BlogDAO blogDAO = new BlogDAO();
        List<Blog> post =  blogDAO.getBlogListByType(xId);
        
        SettingDAO settingDAO = new SettingDAO();
        Settings setting = settingDAO.getSettingById(xId);
        List<Settings> settingsList = settingDAO.getSettingsBlog();
        
        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
        List<StudentClub> studentClubList = null;
        if (acc != null) {
            StudentClubDAO studentClubDAO = new StudentClubDAO();
            studentClubList = studentClubDAO.getStudentClubs(acc.getId());
        }
        
        request.setAttribute("BlogByIDList", post);
        request.setAttribute("StudentClubList", studentClubList);
        request.setAttribute("blogDAO", blogDAO);
        request.setAttribute("curruser", acc);
        request.setAttribute("setting", setting);
        request.setAttribute("settingsList", settingsList);

        if ("Blog_PostList.jsp".equals(from)){
            request.getRequestDispatcher("/BlogPostListServlet").forward(request, response);
        }
        else if ("Blog_List.jsp".equals(from)) {
        request.getRequestDispatcher("/BlogListServlet").forward(request, response);
        }
    }


  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         
    }

 
}
