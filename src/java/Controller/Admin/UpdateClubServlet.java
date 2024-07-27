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
@WebServlet(name = "UpdateClubServlet", urlPatterns = {"/updateClub"})
public class UpdateClubServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateClubServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateClubServlet at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        ClubDao dao = new ClubDao();
        String idClub = request.getParameter("idClub");
        String nameClub = request.getParameter("nameClub");
        String pointClub = request.getParameter("points");
        String typeClub = request.getParameter("typeClub");
        String status = request.getParameter("status");
//        out.println("Before: " + status);
        if (nameClub == null) {
            nameClub = "";
        }
        if (pointClub == null) {
            pointClub = "";
        }
        if (typeClub == null) {
            typeClub = "";
        }

//        out.println(status);
        dao.updateClubDong(idClub, nameClub, pointClub, typeClub, status);
//        request.getRequestDispatcher("managerClub").forward(request, response);
//        response.sendRedirect("managerClub");
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
        PrintWriter out = response.getWriter();
        Validation validation = new Validation();
        ClubDao dao = new ClubDao();
        AccountDao daoAccount = new AccountDao();
        // list Account manager
        List<Accounts> listManager = new ArrayList<>();
        HashMap<String, String> listCategoryClub = dao.getAllCategoryClubDong("1");
        String idClub = request.getParameter("idClub");
        String nameClub = request.getParameter("nameClub");
        String pointClub = request.getParameter("points");
        String typeClub = request.getParameter("typeClub");
        String status = request.getParameter("status");
        String idAccount = request.getParameter("idAccount");
        List<String> listAccountManager = daoAccount.getListManagerClubDong("Manager");
        for (String idAcc : listAccountManager) {
            Accounts getAcc = daoAccount.getAccountByIdDong(idAcc);
            listManager.add(getAcc);
        }
        String checkNameClub = validation.checkLength(nameClub, 32);
        int error = 0;
        if (!checkNameClub.equals(nameClub)) {
            error++;
            request.setAttribute("errorName", checkNameClub);
        }
        boolean checkDupitName = validation.checkNameClubDuplicate(nameClub, idClub);
        if (checkDupitName) {
            error++;
            request.setAttribute("errorName", "Name CLub is exist");
        }
        System.out.println("No point" + pointClub);
        if (pointClub.isBlank()) {
            error++;
            request.setAttribute("errorPoint", "Points is not empty");
        } else {
            try {
                int points = Integer.parseInt(pointClub);
                if (points > 1000 || points < 0) {
                    request.setAttribute("errorPoint", "Points must be a positive number and < 1000");
                }
            } catch (Exception e) {
                System.out.println("hello try catch");
                request.setAttribute("errorPoint", "Points must be a positive number and < 1000");
            }
        }
        if (status == null) {
            error++;
            request.setAttribute("errorStatus", "Please choose 1 option");
        }
        request.setAttribute("nameClub", nameClub);
        request.setAttribute("status", status);
        request.setAttribute("listType", listCategoryClub);
        request.setAttribute("listAccount", listManager);
        request.setAttribute("typeClub", typeClub);
        System.out.println("idClub: " + idClub);
        if (error > 0) {
            Clubs getClub = dao.getClubByIdDong(idClub);
            request.setAttribute("idClub", getClub.getClub());
            request.setAttribute("dateCreate", getClub.getDatecreate());
            request.setAttribute("dateModify", getClub.getModify());
            request.setAttribute("points", pointClub);
            request.getRequestDispatcher("View/ViewAdmin/EditClub.jsp").forward(request, response);
        } else {
            //        out.println(status);
            dao.updateClubDong(idClub, nameClub, pointClub, typeClub, status);
//        request.getRequestDispatcher("managerClub").forward(request, response);
            response.sendRedirect("getClub?idClub=" + idClub + "&statusUpdate=success");
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
