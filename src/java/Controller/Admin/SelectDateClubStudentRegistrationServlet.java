/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.StudentClubDao;
import Model.ClubStudentRegistration;
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
@WebServlet(name = "SelectDateClubStudentRegistrationServlet", urlPatterns = {"/SelectDateClubStudentRegistrationServlet"})
public class SelectDateClubStudentRegistrationServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet SelectDateClubStudentRegistrationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SelectDateClubStudentRegistrationServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
        String nu = null;
        if (page != null) {
            pageNumber = Integer.parseInt(page);
        }
        StudentClubDao stdao = new StudentClubDao();
        if (request.getParameter("id") != null && request.getParameter("leader") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            int leader = Integer.parseInt(request.getParameter("leader"));
            if (leader == 1) {
                List<ClubStudentRegistration> list = stdao.getTenClubStudentRegistrationbyASC(id, pageNumber);
                request.setAttribute("list", list);
                request.setAttribute("search", null);
                request.setAttribute("leader", leader);
                request.setAttribute("numberOfPage", (int) Math.ceil(stdao.getNumberOfClubStudentRegistration(id) * 1.0 / 10));
                request.getRequestDispatcher("View/ViewAdmin/clubStudenRegistrationAdmin.jsp").forward(request, response);
            } else {
                List<ClubStudentRegistration> list = stdao.getTenClubStudentRegistrationbyDESC(id, pageNumber);
                request.setAttribute("list", list);
                request.setAttribute("search", null);
                request.setAttribute("leader", leader);
                request.setAttribute("numberOfPage", (int) Math.ceil(stdao.getNumberOfClubStudentRegistration(id) * 1.0 / 10));
                request.getRequestDispatcher("View/ViewAdmin/clubStudenRegistrationAdmin.jsp").forward(request, response);
            }
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
