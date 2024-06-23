/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.SettingDaoClass;
import Services.Validation;
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
        String nameSetting = request.getParameter("nameSetting");
        String idSetting = request.getParameter("idSetting");
        String idType = request.getParameter("idType");
        String idForm = request.getParameter("idForm");
        String idClub = request.getParameter("idClub");
        String idBlog = request.getParameter("idBlog");
        String idStudent = request.getParameter("idAccAss");
        String idEvent = request.getParameter("idEvent");
        if (nameSetting == null) {
            nameSetting = "";
        }
        out.println(nameSetting);
        if (idType == null) {
            idType = "";
        }
        if (idForm == null) {
            idForm = "";
        }
        if (idClub == null) {
            idClub = "";
        }
        if (idBlog == null) {
            idBlog = "";
        }
        if (idStudent == null) {
            idStudent = "";
        }
        if (idEvent == null) {
            idEvent = "";
        }
        String checkString = validatonInput.checkLength(nameSetting, 32);
        if (!checkString.equals(nameSetting)) {
            request.setAttribute("nameSetting", nameSetting);
            request.setAttribute("errorName", checkString);
            request.getRequestDispatcher("editSetting?idSetting=" + idSetting).forward(request, response);
        }
        daoSetting.updateSetting(nameSetting, idType, idForm, idClub, idBlog, idStudent, idEvent, status, idSetting);
        response.sendRedirect("settingList");
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
