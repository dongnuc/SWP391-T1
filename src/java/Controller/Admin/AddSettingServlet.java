/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.AccountDao;
import DAO.SettingDaoClass;
import Model.Accounts;
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
@WebServlet(name = "AddSettingServlet", urlPatterns = {"/addSetting"})
public class AddSettingServlet extends HttpServlet {

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
            out.println("<title>Servlet AddSettingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSettingServlet at " + request.getContextPath() + "</h1>");
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
        AccountDao daoAcc = new AccountDao();
        SettingDaoClass daoSet = new SettingDaoClass();
        HashMap hashTypeSetting = daoSet.getAllTypeSettingDong("1");
        List<Accounts> listAccAssume = daoAcc.getAccManagerFormDong();
        request.setAttribute("listAccAss", listAccAssume);
        request.setAttribute("listType", hashTypeSetting);
        request.getRequestDispatcher("View/ViewAdmin/AddSetting.jsp").forward(request, response);
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
        AccountDao daoAcc = new AccountDao();
        Validation validationInput = new Validation();
        SettingDaoClass daoSetting = new SettingDaoClass();
        HashMap hashTypeSetting = daoSetting.getAllTypeSettingDong("1");
        List<Accounts> listAccAssume = daoAcc.getAccManagerFormDong();
        int countError = 0;
        String nameSetting = request.getParameter("nameSetting");
        String idTypeSetting = request.getParameter("typeSetting");
        String idAccount = "";
        String checkName = validationInput.checkLength(nameSetting, 32);
        if (!nameSetting.equals(checkName)) {
                        countError++;
            System.out.println("1");
            request.setAttribute("errorName", checkName);
        }
        if (idTypeSetting.equals("2")) {
            System.out.println("2");
            idAccount = request.getParameter("idAccAss");
        }
        String status = request.getParameter("status");
        if (status == null) {
            System.out.println("3");
            countError++;
            request.setAttribute("errorStatus", "Please choose 1 option");
        }
        if (countError > 0) {
            System.out.println("No");
            String valueType = (String) hashTypeSetting.get(idTypeSetting);
            request.setAttribute("accManager", idAccount);
            request.setAttribute("status", status);
            request.setAttribute("nameSetting", nameSetting);
            request.setAttribute("typeSetting", valueType);
            request.setAttribute("listAccAss", listAccAssume);
            request.setAttribute("listType", hashTypeSetting);
            request.getRequestDispatcher("View/ViewAdmin/AddSetting.jsp").forward(request, response);
        }else{
            System.out.println("helo");
            daoSetting.insertSettingDong(nameSetting, idTypeSetting, idAccount, status);
            response.sendRedirect("addSetting?" +"&statusAdd=success");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
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
