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
@WebServlet(name = "FormSentServlet", urlPatterns = {"/formSent"})
public class FormSentServlet extends HttpServlet {

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
            out.println("<title>Servlet FormSentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormSentServlet at " + request.getContextPath() + "</h1>");
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
        if(acc == null){
            response.sendRedirect("home");
        }
        String search = request.getParameter("search");
        if(search == null){
            search = "";
        }
        FormDao dao = new FormDao();
        String pageRaw = request.getParameter("page");
        int page = 0;
        if(pageRaw == null){
            page = 1;
        }else{
            page = Integer.parseInt(pageRaw);
        }
        String idAcc = String.valueOf(acc.getId());
        String categoryId = dao.getCategoryFormDong(idAcc);
        List<Form> getFormSent = dao.getFormSentDong(categoryId,search,page);
        int numberPageSent = dao.numberPageFormSent(categoryId);
        request.setAttribute("pageCurrent", page);
        request.setAttribute("pageSent", numberPageSent);
        request.setAttribute("listFormSent", getFormSent);
        int noRead = dao.countFormNoReadDong(categoryId);
        request.setAttribute("noRead", noRead);
        request.setAttribute("search", search);
        request.getRequestDispatcher("View/ViewAdmin/FormSent.jsp").forward(request, response);
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
