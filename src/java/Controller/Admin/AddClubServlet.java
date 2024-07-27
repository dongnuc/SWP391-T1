/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.AccountDao;
import DAO.ClubDao;
import DAO.SettingDaoClass;
import Model.Accounts;
import Model.Clubs;
import Model.SettingSystem;
import Services.SendMail;
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
@WebServlet(name = "AddClubServlet", urlPatterns = {"/addClub"})
public class AddClubServlet extends HttpServlet {

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
            out.println("<title>Servlet AddClubServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddClubServlet at " + request.getContextPath() + "</h1>");
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
        Validation validationInput = new Validation();
        // list Account manager
        List<Accounts> listManager = new ArrayList<>();
        ClubDao dao = new ClubDao();
        String idClub = request.getParameter("idClub");
        Clubs getClub = dao.getClubByIdDong(idClub);
        HashMap<String, String> listCategoryClub = dao.getAllCategoryClubDong("1");
        // list id manager
        List<String> listAccountManager = daoAccount.getListManagerClubDong("Manager");
        for (String idAcc : listAccountManager) {
            Accounts getAcc = daoAccount.getAccountByIdDong(idAcc);
            listManager.add(getAcc);
        }
        request.setAttribute("listAccount", listManager);
        request.setAttribute("listType", listCategoryClub);
        request.getRequestDispatcher("View/ViewAdmin/AddClub.jsp").forward(request, response);
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
        SendMail sendMail = new SendMail();
        ClubDao dao = new ClubDao();
        AccountDao daoAccount = new AccountDao();
        // list Account manager
        List<Accounts> listManager = new ArrayList<>();
        HashMap<String, String> listCategoryClub = dao.getAllCategoryClubDong("1");
        String idClub = request.getParameter("idClub");
        String nameClub = request.getParameter("nameClub");
        String pointClub = request.getParameter("points");
        String dateCreate = request.getParameter("dateCreate");
        String typeClub = request.getParameter("typeClub");
        String status = request.getParameter("status");
        String idAccount = request.getParameter("accManager");
        List<String> listAccountManager = daoAccount.getListManagerClubDong("Manager");
        for (String idAcc : listAccountManager) {
            Accounts getAcc = daoAccount.getAccountByIdDong(idAcc);
            listManager.add(getAcc);
        }
        String checkNameClub = validation.checkLength(nameClub, 32);
        int error = 0;
        //check name start
        if (!checkNameClub.equals(nameClub)) {
            error++;
            request.setAttribute("errorName", checkNameClub);
        }
        boolean checkDupitName = validation.checkNameClubDuplicate(nameClub, "");
        if (checkDupitName) {
            error++;
            request.setAttribute("errorName", "Name CLub is exist");
        }
//        check name end
//          points
        System.out.println("No point" + pointClub);
        if (pointClub.isBlank()) {
            error++;
            request.setAttribute("errorPoint", "Points is not empty");
        } else {
            try {
                int points = Integer.parseInt(pointClub);
                System.out.println("pointPare: " + points);
                if (points > 1000 || points < 0) {
                    request.setAttribute("errorPoint", "Points must be a positive number and < 1000");
                }
            } catch (Exception e) {
                request.setAttribute("errorPoint", "1Points must be a positive number and < 1000");
            }
        }
        //date create
        String checkDate = validation.checkDate(dateCreate);
        if(dateCreate == null || !dateCreate.equals(checkDate)){
            request.setAttribute("errorDate", checkDate);
        }
        
        //acc
        if(idAccount == null){
            error++;
            request.setAttribute("errorAccount", "You must choose 1 option");
        }
        
        //status
        if (status == null) {
            error++;
            request.setAttribute("errorStatus", "Please choose 1 option");
        }
        System.out.println(idAccount);
        request.setAttribute("nameClub", nameClub);
        request.setAttribute("status", status);
        request.setAttribute("listType", listCategoryClub);
        request.setAttribute("listAccount", listManager);
        request.setAttribute("typeClub", typeClub);
        System.out.println(typeClub);
        request.setAttribute("accManager", idAccount);
        if (error > 0) {
            request.setAttribute("dateCreate", dateCreate);
            request.setAttribute("points", pointClub);
            request.getRequestDispatcher("View/ViewAdmin/AddClub.jsp").forward(request, response);
        } else {
            //        out.println(status);
//            dao.updateClubDong(idClub, nameClub, pointClub, typeClub, status);
                dao.insertClubDong(nameClub, pointClub, dateCreate, idAccount, typeClub, status);
                Accounts acc = daoAccount.getAccountByIdDong(idAccount);
                sendMail.sendMailDefault("Club New in Website SWP391", "You have become a Manager of Club "+nameClub+" ,please go to the website to check.", status);
                response.sendRedirect("addClub?"+ "&statusAdd=success");
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
