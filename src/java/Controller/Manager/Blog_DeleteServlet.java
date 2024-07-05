/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.BlogDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author 10t1q
 */
@WebServlet(name="Blog_DeleteServlet", urlPatterns={"/BlogDeleteServlet"})
public class Blog_DeleteServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String xID = request.getParameter("idBlog");
        int Id = Integer.parseInt(xID);
        
        BlogDAO blogDAO = new BlogDAO();
        blogDAO.deletePost(Id);
        
        response.sendRedirect(request.getContextPath() + "/BlogListServlet");
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

   
}
