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
@WebServlet(name="BlogListServlet", urlPatterns={"/BlogListServlet"})
public class Blog_ListServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Blog> postList = (List<Blog>) request.getAttribute("BlogByIDList");
        String idBlogType = request.getParameter("idBlogType");
        String searchKeyword = request.getParameter("searchKeyword");
        String from = request.getParameter("from");
        String idblog = request.getParameter("idBlog");
        
        BlogDAO postDAO = new BlogDAO();
        if(postList == null ){
          postList = postDAO.getAllPosts();
        }
        
        ClubDao clubDAO = new ClubDao();
        SettingDAO settingDAO = new SettingDAO();
        
        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
        if (acc != null) {
            StudentClubDao studentClubDAO = new StudentClubDao();
            List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(acc.getId());
            request.setAttribute("StudentClubList", studentClubList);
        }
        
        List<Settings> settingsList = settingDAO.getSettingsBlog();

        int page = 1;
        int recordsPerPage = 10;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        
        int start = (page - 1) * recordsPerPage;
        int end = Math.min(start + recordsPerPage, postList.size());
        List<Blog> paginatedList = postList.subList(start, end);
        
        int noOfRecords = postList.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        request.setAttribute("settingsList", settingsList);
        request.setAttribute("BlogByIDList", paginatedList);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("curruser", acc);
        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("currentPage", page);
        request.setAttribute("idBlogType", idBlogType);
        request.setAttribute("searchKeyword", searchKeyword);
        request.setAttribute("from", from);
        request.setAttribute("idBlog", idblog);

        request.getRequestDispatcher("/View/ViewManager/Blog_List.jsp").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

 
}
