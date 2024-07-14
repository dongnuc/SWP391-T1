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
@WebServlet(name="Blog_FilterByClubServlet", urlPatterns={"/BlogFilterByClubServlet"})
public class Blog_FilterByClubServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String ID = request.getParameter("idClub");
        int xId = Integer.parseInt(ID);
        
        BlogDAO blogDAO = new BlogDAO();
        List<Blog> BlogByIDList = blogDAO.getPostsByClubId(xId);
    
        BlogByIDList.sort((Blog b1, Blog b2) -> b2.getDateCreate().compareTo(b1.getDateCreate()));
        
        request.setAttribute("BlogByIDList", BlogByIDList);
        request.getRequestDispatcher("/BlogPostListServlet").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    
}
