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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10t1q
 */
@WebServlet(name = "Blog_PostListServlet", urlPatterns = {"/BlogPostListServlet"})
public class Blog_PostListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Blog> BlogByIDList = (List<Blog>) request.getAttribute("BlogByIDList");

        Accounts account = (Accounts) request.getSession().getAttribute("curruser");
        StudentClubDao studentClubDAO = new StudentClubDao();
        List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(account.getId());

        if (BlogByIDList == null) {

            BlogDAO blogDao = new BlogDAO();
            BlogByIDList = new ArrayList<>();

            if (studentClubList != null) {
                for (StudentClub studentclub : studentClubList) {
                    if (studentclub.getLeader()== 1 && studentclub.getStatus() == 1) {
                        List<Blog> blogs = blogDao.getBlogByIdClub(studentclub.getIdClub());
                        if (blogs != null) {
                            BlogByIDList.addAll(blogs);
                        }
                    }
                }
            }
            BlogByIDList.sort((Blog b1, Blog b2) -> b2.getDateCreate().compareTo(b1.getDateCreate()));
        }
        // Phân trang
        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int start = (page - 1) * recordsPerPage;
        int end = Math.min(start + recordsPerPage, BlogByIDList.size());
        List<Blog> paginatedList = BlogByIDList.subList(start, end);

        int noOfRecords = BlogByIDList.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);

        SettingDAO settingsDAO = new SettingDAO();
        ClubDao clubDAO = new ClubDao();

        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("settingsDAO", settingsDAO);
        request.setAttribute("studentClubList", studentClubList);
        request.setAttribute("BlogByIDList", paginatedList);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("/View/ViewManager/Blog_PostList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
