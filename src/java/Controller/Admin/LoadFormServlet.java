/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.FormDao;
import Model.Accounts;
import Model.Form;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoadFormServlet", urlPatterns = {"/loadForm"})
public class LoadFormServlet extends HttpServlet {

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
            out.println("<title>Servlet LoadFormServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoadFormServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Accounts acc = (Accounts) session.getAttribute("curruser");
        FormDao daoForm = new FormDao();
        String pageNumberRaw = request.getParameter("pageNumber");
        int pageCurrent = 0;
        if(pageNumberRaw == null){
            pageCurrent = 1;
        }else{
            pageCurrent = Integer.parseInt(pageNumberRaw);
        }
        String idAcc = String.valueOf(acc.getId());
        String categoryId = daoForm.getCategoryFormDong(idAcc);
        int numberPage = daoForm.numberPageFormDong(categoryId,"1");
        
        List<Form> getFormAll = daoForm.getListFormDong(pageCurrent,categoryId,"","1");
        int totalForm = daoForm.countFormDong(categoryId);
        int formInPage = 0;
        if(pageCurrent == 1){
            formInPage = getFormAll.size();
        }else{
            formInPage = (pageCurrent - 1) * 4 + getFormAll.size();
        }

        int noRead = daoForm.countFormNoReadDong(categoryId);
        request.setAttribute("formInPage", formInPage);
        request.setAttribute("totalForm", totalForm);
        request.setAttribute("pageCurrent", pageCurrent);
        request.setAttribute("numberPage", numberPage);
        request.setAttribute("noRead", noRead);
        request.setAttribute("listForm", getFormAll);
        request.getRequestDispatcher("View/ViewAdmin/FeedbackForm.jsp").forward(request, response);
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
