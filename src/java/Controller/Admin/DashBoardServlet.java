/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.AccountDao;
import DAO.ClubDao;
import DAO.FormDao;
import DAO.SettingDaoClass;
import Model.Accounts;
import Model.Clubs;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DashBoardServlet", urlPatterns = {"/dashboardAdmin"})
public class DashBoardServlet extends HttpServlet {

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
            out.println("<title>Servlet DashBoardServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DashBoardServlet at " + request.getContextPath() + "</h1>");
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
        SettingDaoClass daoSetting = new SettingDaoClass();
        Accounts acc = (Accounts) session.getAttribute("curruser");
        FormDao daoForm = new FormDao();
        String category = daoForm.getCategoryFormDong(String.valueOf(acc.getId()));

        AccountDao daoAcc = new AccountDao();
        ClubDao daoClub = new ClubDao();
        int numberForm = daoForm.countFormDong(category);
        int numberAcc = daoAcc.countStudentDong();
        int numberClub = daoClub.countNumberClubDong();
        int numberClubRes = daoClub.countNumberClubResDong();

        int numberStudentGroupNull = daoClub.countStudentNoClubDong();// student club is null

        List<Accounts> listAccNew = daoAcc.get5AccountDong(); // 5 new Account

        HashMap<String, String> listStudentClub = daoClub.countStudentInClubDong();
        listStudentClub.put("Non-Member", String.valueOf(numberStudentGroupNull));//add data student club null

        Gson gson = new Gson();
        String jsonDataChart = gson.toJson(listStudentClub);
        request.setAttribute("numberForm", numberForm);
        request.setAttribute("listAccNew", listAccNew);
        request.setAttribute("chartData", jsonDataChart);
        request.setAttribute("numberClubRes", numberClubRes);
        request.setAttribute("numberClub", numberClub);
        request.setAttribute("numberAcc", numberAcc);
        request.getRequestDispatcher("View/ViewAdmin/Dashboard.jsp").forward(request, response);
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
