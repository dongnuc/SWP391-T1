package Controller.Manager;

import DAO.BlogDAO;
import DAO.StudentClubDAO;
import Model.Accounts;
import Model.Blog;
import Model.StudentClub;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Blog_SearchServlet", urlPatterns = {"/BlogSearchServlet"})
public class Blog_SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchKeyword = request.getParameter("searchKeyword");
        String from = request.getParameter("from");

        BlogDAO blogDAO = new BlogDAO();

        if ("Blog_PostList.jsp".equals(from)) {
            Accounts account = (Accounts) request.getSession().getAttribute("curruser");
            StudentClubDAO studentClubDAO = new StudentClubDAO();
            List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(account.getId());
            
            List<Blog> BlogByIDList = new ArrayList<>();

            if (studentClubList != null) {
                for (StudentClub studentclub : studentClubList) {
                    List<Blog> blogs = blogDAO.getBlogByIdClub(studentclub.getIdclub());
                    if (blogs != null) {
                        BlogByIDList.addAll(blogs);
                    }
                }
            }
            BlogByIDList.sort((Blog b1, Blog b2) -> b2.getDateCreate().compareTo(b1.getDateCreate()));
            
            List<Blog> searchResults = new ArrayList<>();
            
            if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
                searchResults = BlogByIDList;
                request.setAttribute("errorMessage", "Search ìnormation cant not empty");
            } else {
                for (Blog blog : BlogByIDList) {
                    if (blog.getTitleBlog().toLowerCase().contains(searchKeyword.toLowerCase())) {
                        searchResults.add(blog);
                    }
                }
                if (searchResults.isEmpty()) {
                    request.setAttribute("errorMessage", "Cant finf title: " + searchKeyword);
                }
            }
            request.setAttribute("BlogByIDList", searchResults);
            request.getRequestDispatcher("/BlogPostListServlet").forward(request, response);
        } else if ("Blog_List.jsp".equals(from)) {
            List<Blog> searchResults = blogDAO.searchBlogsByTitle(searchKeyword);
            if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
                request.setAttribute("errorMessage", "Search ìnormation cant not empty.");
            } else if (searchResults.isEmpty()) {
                request.setAttribute("errorMessage", "Cant finf title: " + searchKeyword);
            }
            request.setAttribute("BlogByIDList", searchResults);
            request.getRequestDispatcher("/BlogListServlet").forward(request, response);
        }
    }
}
