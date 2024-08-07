/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Admin;

import DAO.SettingDaoClass;
import Model.SettingSystem;
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
@WebServlet(name="SettingListServlet", urlPatterns={"/settingList"})
public class SettingListServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet SettingListServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SettingListServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String idType = request.getParameter("idType");
        String search = request.getParameter("search");
        String pageRaw = request.getParameter("page");
        String status = request.getParameter("status");
        if(idType == null){
            idType = "All";
        }
        if(search == null){
            search = "";
        }
        int page = 0;
        if(pageRaw == null){
            page = 1;
        }else{
            page = Integer.parseInt(pageRaw);
        }
        if(status == null){
            status = "1";
        }        
        SettingDaoClass daoSet = new SettingDaoClass();
        HashMap hashTypeSetting = daoSet.getAllTypeSettingDong("1");
        SettingDaoClass daoSetting = new SettingDaoClass();
        int numberPage = daoSetting.namePageSetting(idType, search, status);
       
        List<SettingSystem> listSetting = daoSetting.getAllSettingDong(idType, search, status, page);
        
       
        request.setAttribute("pageCurrent", page);
        request.setAttribute("numberPage", numberPage);
        request.setAttribute("status", status);
        request.setAttribute("search", search);
        request.setAttribute("typeSetting", idType);
        request.setAttribute("listType", hashTypeSetting);
        request.setAttribute("listSetting", listSetting);
        request.getRequestDispatcher("View/ViewAdmin/SettingList.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
