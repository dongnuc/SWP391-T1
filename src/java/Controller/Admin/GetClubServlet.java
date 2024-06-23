/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.ClubDao;
import Model.Clubs;
import Services.Validation;
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
@WebServlet(name = "GetClubServlet", urlPatterns = {"/getClub"})
public class GetClubServlet extends HttpServlet {

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
            out.println("<title>Servlet GetClubServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetClubServlet at " + request.getContextPath() + "</h1>");
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
        ClubDao dao = new ClubDao();
        String idClub = request.getParameter("idClub");
        Clubs getClub = dao.getClubByIdSetting(idClub);
        List<String> nameType = dao.getTypeClub();
        request.setAttribute("listType", nameType);
        request.setAttribute("nameClub", getClub.getNameclub());
        request.setAttribute("points", getClub.getPoint());
        request.setAttribute("dateCreate", getClub.getDatecreate());
        request.setAttribute("typeClub", getClub.getTypeClub());
        System.out.println(getClub);
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
        ClubDao dao = new ClubDao();
        String idClub = request.getParameter("idClub");
        String nameClub = request.getParameter("nameClub");
        String pointClub = request.getParameter("points");
        String typeClub = request.getParameter("typeClub");
//        out.println("Before: " + status);
        String checkNameClub = validation.checkLength(nameClub, 32);
        int error = 0;
        if (!checkNameClub.equals(nameClub)) {
            error++;
            request.setAttribute("errorName", checkNameClub);
        }
        boolean checkDupitName = dao.checkNameClub(nameClub);
        if (checkDupitName) {
            error++;
            request.setAttribute("errorName", "Name CLub is exist");
        }
        if(pointClub == null){
            error++;
            request.setAttribute("Points is not empty", "errorPoint");
        }
        
        if(error > 0){
            request.getRequestDispatcher("View/ViewAdmin/AddClub.jsp").forward(request, response);
        }
//        out.println(status);
        dao.updateClub(idClub, nameClub, pointClub, typeClub, "");
//        request.getRequestDispatcher("managerClub").forward(request, response);
        response.sendRedirect("managerClub");
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
