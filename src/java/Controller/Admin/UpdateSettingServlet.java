/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.AccountDao;
import DAO.SettingDaoClass;
import Model.Accounts;
import Model.SettingSystem;
import Services.Validation;
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
@WebServlet(name = "UpdateSettingServlet", urlPatterns = {"/updateSetting"})
public class UpdateSettingServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateSettingServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateSettingServlet at " + request.getContextPath() + "</h1>");
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
        Validation validatonInput = new Validation();
        SettingDaoClass daoSetting = new SettingDaoClass();
        String status = request.getParameter("status");
        String idSetting = request.getParameter("idSetting");
        daoSetting.updateSettingDong(idSetting, "", "", "", status);
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
        Validation validationInput = new Validation();
        SettingDaoClass daoSetting = new SettingDaoClass();
        AccountDao daoAcc = new AccountDao();
        HashMap<String, String> hashTypeSetting = daoSetting.getAllTypeSettingDong("1");
        String idSetting = request.getParameter("idSetting");
        String nameSetting = request.getParameter("nameSetting");
        String idTypeSetting = request.getParameter("typeSetting");
        String status = request.getParameter("status");
        String idAccountManager = request.getParameter("idAccAss");
        if(idAccountManager == null){
            idAccountManager = "";
        }
            
        int countError = 0;
        if (nameSetting == null) {
            countError++;
            request.setAttribute("errorName", "Name input is not empty");
        }
        String checkName = validationInput.checkNameDong(nameSetting, 50);
        if (!nameSetting.equals(checkName)) {
            countError++;
            request.setAttribute("errorName", checkName);
        } 
        if (status == null) {
            countError++;
            request.setAttribute("errorSatus", "Please choose 1 option");
        }
        String valueType = (String) hashTypeSetting.get(idTypeSetting);
        if (valueType.equals("Type Form")) {
            // get All account has role = 1
            List<Accounts> getAllAcc = daoAcc.getAccManagerFormDong();
            request.setAttribute("accManager", idAccountManager);
            request.setAttribute("listAccAss", getAllAcc);
        }
        SettingSystem getGetting = daoSetting.getSettingByIdDong(idSetting);
        request.setAttribute("status", status);
        request.setAttribute("listType", hashTypeSetting);
        request.setAttribute("typeSetting", valueType);
        request.setAttribute("dateCreate", getGetting.getDateCreate());
        request.setAttribute("dateModify", getGetting.getDateModify());
        System.out.println(getGetting.getDateCreate());
        if (countError > 0) {
            request.setAttribute("nameSetting", nameSetting);
            request.getRequestDispatcher("View/ViewAdmin/EditSetting.jsp").forward(request, response);
        } else {
            daoSetting.updateSettingDong(idSetting, nameSetting, idTypeSetting, idAccountManager, status);
            response.sendRedirect("editSetting?idSetting=" + idSetting + "&statusUpdate=success");
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
