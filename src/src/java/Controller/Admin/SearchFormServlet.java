/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.FormDao;
import Model.Form;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SearchFormServlet", urlPatterns = {"/searchForm"})
public class SearchFormServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchFormServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchFormServlet at " + request.getContextPath() + "</h1>");
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
        String search = request.getParameter("search");
        FormDao dao = new FormDao();
        List<Form> getFormSearch = dao.searchByTittleExist(search);
        request.setAttribute("namesearch", search);
        for (int i = 0; i < getFormSearch.size(); i++) {
            out.println("<div class=\"mail-list-info\">\n"
                    + "                                                <div class=\"checkbox-list\">\n"
                    + "                                                    <div class=\"custom-control custom-checkbox checkbox-st1\">\n"
                    + "                                                        <input type=\"checkbox\" class=\"custom-control-input\" id=\"check2\">\n"
                    + "                                                        <label class=\"custom-control-label\" for=\"check2\"></label>\n"
                    + "                                                    </div>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"mail-rateing\">\n"
                    + "                                                    <span><i class=\"fa fa-star-o\"></i></span>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"mail-list-title\">\n"
                    + "                                                    <a href=\"formdetail?idForm=" + getFormSearch.get(i).getIdForm() + "\"><h6>" + getFormSearch.get(i).getFullName() + "</h6></a>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"mail-list-title-info\">\n"
                    + "                                                    <p>" + getFormSearch.get(i).getTitleForm() + "</p>\n"
                    + "                                                </div>\n"
                    + "                                                <div class=\"mail-list-time\">\n"
                    + "                                                    <span>" + getFormSearch.get(i).getContentForm() + "</span>\n"
                    + "                                                </div>\n"
                    + "                                                <ul class=\"mailbox-toolbar\">\n"
                    + "                                                    <li data-toggle=\"tooltip\" title=\"Delete\"><i class=\"fa fa-trash-o\"></i></li>\n"
                    + "                                                    <li data-toggle=\"tooltip\" title=\"Archive\"><i class=\"fa fa-arrow-down\"></i></li>\n"
                    + "                                                    <li data-toggle=\"tooltip\" title=\"Snooze\"><i class=\"fa fa-clock-o\"></i></li>\n"
                    + "                                                    <li data-toggle=\"tooltip\" title=\"Mark as unread\"><i class=\"fa fa-envelope-open\"></i></li>\n"
                    + "                                                </ul>\n"
                    + "                                            </div>");
        }
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
