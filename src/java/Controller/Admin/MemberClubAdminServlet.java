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
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "MemberClubAdminServlet", urlPatterns = {"/memberClubAdmin"})
public class MemberClubAdminServlet extends HttpServlet {

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
            out.println("<title>Servlet MemberClubAdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MemberClubAdminServlet at " + request.getContextPath() + "</h1>");
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
        String idClub = request.getParameter("idClub");
        String search = request.getParameter("search");
        String role = request.getParameter("role");
        String status = request.getParameter("status");
        String page = request.getParameter("page");
        if (search == null) {
            search = "";
        }
        if (role == null) {
            role = "All";
        }
        if (status == null) {
            status = "1";
        }
        int pageCurrent = 0;
//        System.out.println(page);
        if (page == null) {
            pageCurrent = 1;
        }else{
            try {
                pageCurrent = Integer.parseInt(page);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        HashMap<String, String> listRole = daoClub.getAllRoleDong("1");
        int numberPage = daoClub.pagetMemberInClubDong(idClub, search, role, status);
        String nameClub = daoClub.getClubByIdDong(idClub).getNameclub();
        List<Accounts> listAccount = daoClub.getMemberInClubDong(idClub, search, role, status, pageCurrent);
        request.setAttribute("listMember", listAccount);
        request.setAttribute("pagerCurrent", pageCurrent);
        request.setAttribute("numberPage", numberPage);
        request.setAttribute("listRole", listRole);
        request.setAttribute("nameClub", nameClub);
//        System.out.println(listAccount.size());
//        System.out.println(numberPage);
//        System.out.println(pageCurrent);
        request.setAttribute("status", status);
        request.setAttribute("role", role);
        request.setAttribute("search", search);
        request.setAttribute("idClub", idClub);
        request.getRequestDispatcher("View/ViewAdmin/MemberClubAdmin.jsp").forward(request, response);
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
