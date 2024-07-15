/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.AccountDao;
import DAO.ClubDao;
import Model.Accounts;
import Model.Clubs;
import Services.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "GetClubServlet", urlPatterns = {"/getClub"})
public class GetClubServlet extends HttpServlet {

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
            out.println("<title>Servlet GetClubServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetClubServlet at " + request.getContextPath() + "</h1>");
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
        AccountDao daoAccount = new AccountDao();
        // list Account manager
        List<Accounts> listManager = new ArrayList<>();
        ClubDao dao = new ClubDao();
        String idClub = request.getParameter("idClub");
        Clubs getClub = dao.getClubByIdDong(idClub);
        HashMap<String,String> listCategoryClub = dao.getAllCategoryClubDong("1");
        // list id manager
        List<String> listAccountManager = daoAccount.getListManagerClubDong("Manager");
        for (String idAcc : listAccountManager) {
            Accounts getAcc = daoAccount.getAccountByIdDong(idAcc);
            listManager.add(getAcc);
        }
        Accounts accManager = daoAccount.getAccountManagerByIdClubDong(idClub);
        request.setAttribute("idClub", getClub.getClub());
        request.setAttribute("accManager", accManager);
        request.setAttribute("listAccount", listManager);
        request.setAttribute("listType", listCategoryClub);
        request.setAttribute("nameClub", getClub.getNameclub());
        request.setAttribute("points", getClub.getPoint());
        request.setAttribute("dateCreate", getClub.getDatecreate());
        request.setAttribute("dateModify", getClub.getModify());
        request.setAttribute("status", getClub.getStatus());
        request.setAttribute("typeClub", getClub.getTypeClub());
        request.getRequestDispatcher("View/ViewAdmin/EditClub.jsp").forward(request, response);
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
