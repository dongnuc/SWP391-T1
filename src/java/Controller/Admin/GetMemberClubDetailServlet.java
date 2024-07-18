/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.ClubDao;
import Model.Accounts;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
@WebServlet(name = "GetMemberClubDetailServlet", urlPatterns = {"/getMember"})
public class GetMemberClubDetailServlet extends HttpServlet {

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
            out.println("<title>Servlet GetMemberClubDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetMemberClubDetailServlet at " + request.getContextPath() + "</h1>");
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
        ClubDao daoClub = new ClubDao();
        HashMap<String,String> listRole = daoClub.getAllRoleDong("1");
        String idClub = request.getParameter("idClub");
        String idStudent = request.getParameter("idStudent");
        int leader = daoClub.isLeaderInClubDong(idClub, idStudent);
        Accounts accMember = daoClub.getMemberInClubDong(idClub, idStudent);
        request.setAttribute("accMember", accMember);
        request.setAttribute("leader", leader);
        request.setAttribute("role", accMember.getRoleClub());
        System.out.println(accMember.getRoleClub());
        request.setAttribute("idClub", idClub);
        request.setAttribute("idStudent", idStudent);
        request.setAttribute("listRole", listRole);
        request.setAttribute("status", accMember.getStatus());
        request.getRequestDispatcher("View/ViewAdmin/MemberClubAdminDetail.jsp").forward(request, response);
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
