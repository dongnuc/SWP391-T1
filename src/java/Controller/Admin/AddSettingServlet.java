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
        HashMap hashTypeSetting = daoSet.getAllTypeSetting();
        List<String> listAccAssume = daoAcc.getAccAssumeForm();
        List<Accounts> getAllAcc = new ArrayList<>();
        for (int i = 0; i < listAccAssume.size(); i++) {
            String idAcc = listAccAssume.get(i);
            Accounts acc = daoAcc.getAccountByIdSetting(idAcc);
            getAllAcc.add(acc);
        }
        request.setAttribute("listAccAss", getAllAcc);
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
        String nameSetting = request.getParameter("nameSetting");
        String idType = request.getParameter("typeSetting");
        String idAccount = "";
        if (idType == "2") {
            idAccount = request.getParameter("idAccAss");
        }
        String status = request.getParameter("status");
        
        String checkName = validationInput.checkLength(nameSetting, 32);
        if (!checkName.equals(nameSetting) || status.isBlank() || status == null) {
            HashMap hashTypeSetting = daoSetting.getAllTypeSetting();
            List<String> listAccAssume = daoAcc.getAccAssumeForm();
            List<Accounts> getAllAcc = new ArrayList<>();
            for (int i = 0; i < listAccAssume.size(); i++) {
                String idAcc = listAccAssume.get(i);
                Accounts acc = daoAcc.getAccountByIdSetting(idAcc);
                getAllAcc.add(acc);
            }
            request.setAttribute("nameSetting", nameSetting);
            request.setAttribute("errorName", checkName);
            request.setAttribute("idType", idType);
            request.setAttribute("listAccAss", getAllAcc);
            request.setAttribute("listType", hashTypeSetting);
            request.getRequestDispatcher("View/ViewAdmin/AddSetting.jsp").forward(request, response);
        }

        daoSetting.insertSetting(nameSetting, idType, "", "", "", idAccount, "", status);
        response.sendRedirect("addSetting");
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
