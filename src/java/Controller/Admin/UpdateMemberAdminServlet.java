/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.ClubDao;
import DAO.StudentClubDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UpdateMemberAdminServlet", urlPatterns = {"/updateMember"})
public class UpdateMemberAdminServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateMemberAdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateMemberAdminServlet at " + request.getContextPath() + "</h1>");
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
        StudentClubDao daoMember = new StudentClubDao();
        String idClub = request.getParameter("idClub");
        String idStudent = request.getParameter("idStudent");
        String status = request.getParameter("status");
        if (status.equals("1")) {
            status = "0";
        } else {
            status = "1";
        }
        daoMember.updateMemberClubDong(idStudent, idClub, "", "", "", status);
        response.sendRedirect("memberClubAdmin?idClub=" + idClub + "&statusUpdate=success");
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
        StudentClubDao dao = new StudentClubDao();
        String idClub = request.getParameter("idClub");
        String name = request.getParameter("name");
        String idStudent = request.getParameter("idStudent");
        String role = request.getParameter("role");
        String leader = request.getParameter("leader");
        String status = request.getParameter("status");
        String pointsRaw = request.getParameter("points");
        int count = 0;
        if (role == null) {
            count++;
            request.setAttribute("errorRole", "You must be choose 1 option");
        }
        int points = 0;
        if (pointsRaw == null) {
            count++;
            request.setAttribute("errorPoint", "Points is not empty");
        } else {
            try {
                points = Integer.parseInt(pointsRaw);
                if (points > 0 || points < 1000) {
                    count++;
                    request.setAttribute("errorPoint", "Points must be a positive number and < 1000");
                }
            } catch (Exception e) {
                
                request.setAttribute("errorPoint", "Points is not empty");
            }
        }
        System.out.println(count);
        if (count > 0) {
            request.setAttribute("name", name);
            request.getRequestDispatcher("View/ViewAdmin/MemberClubAdminDetail.jsp").forward(request, response);
        } else {
            System.out.println("1");
            dao.updateMemberClubDong(idStudent, idClub, pointsRaw, role, leader, status);
            response.sendRedirect("memberClubAdmin?idClub=" + idClub + "&statusUpdate=success");
        }
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
