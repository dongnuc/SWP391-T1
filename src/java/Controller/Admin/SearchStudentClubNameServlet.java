/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Admin;

import DAO.StudentClubDao;
import Model.StudentClub;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Nguyen Hau
 */
@WebServlet(name="SearchStudentClubNameServlet", urlPatterns={"/SearchStudentClubNameServlet"})
public class SearchStudentClubNameServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchStudentClubNameServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchStudentClubNameServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String page = request.getParameter("page");
        int pageNumber = 1;
        if (page != null) {
            pageNumber = Integer.parseInt(page);
        }
         String searchQuery = request.getParameter("search");
         StudentClubDao stdao = new StudentClubDao();
         List<StudentClub> list;
         if(request.getParameter("id")!=null){
             int id = Integer.parseInt(request.getParameter("id"));
          if (searchQuery != null && !searchQuery.trim().isEmpty()) {
            list = stdao.searchStudentClubsByName(id, searchQuery, pageNumber);
            request.setAttribute("searchQuery", searchQuery);
        } else {
            list = stdao.getTenStudentClub(id, pageNumber);
        }
          request.setAttribute("search", searchQuery);
           request.setAttribute("list", list);
           request.setAttribute("role", 0);
            request.setAttribute("numberOfPage", (int) Math.ceil(stdao.countSearchStudentName(id, searchQuery, pageNumber) * 1.0 / 10));
        request.getRequestDispatcher("View/ViewAdmin/studentClubAdmin.jsp").forward(request, response);
         }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
