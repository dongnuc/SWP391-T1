/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Student;

import Algorithm.SendMail;
import Model.RegisterClub;
import DAO.ClubDao;
import Model.Clubs;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.List;

/**
 *
 * @author Nguyen Hau
 */
@WebServlet(name = "registerclubServlet", urlPatterns = {"/registerclub"})
public class RegisterclubServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClubDao dao = new ClubDao();
        List<String> getTypeClub = dao.gettypeclubAll();
        request.setAttribute("listtypeclub", getTypeClub);
        request.getRequestDispatcher("View/ViewStudent/registerclub.jsp").forward(request, response);
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
        ClubDao dao = new ClubDao();
        String error = null;
        String error1 = null;
        String error2 = null;
        String error3 = null;
        String error4 = null;
        String error5 = null;
        String error6 = null;
        int member = 0;
        String nameClub = request.getParameter("NameClub");
        if (nameClub == null || nameClub.trim().isEmpty() || nameClub.length() > 35) {
            error1 = "Club name cannot be null and lenght must not exceed 35 character !";
        }
        if (dao.isNameClubDuplicate(nameClub)) {
            error1 = "The club name already exists !";
        }
        String memberParam = request.getParameter("Member");
        if (memberParam != null && !memberParam.trim().isEmpty() && memberParam.matches("\\d+")) {
            member = Integer.parseInt(request.getParameter("Member"));
            
        } else {
            error2 = "Desired Number Of Members is a number cannot be nulland must positive number !";
        }

        String reason = request.getParameter("Reason");
        if (reason == null || reason.trim().isEmpty() || reason.length() > 750) {
            error3 = "Reason cannot be null and lenght must not exceed 750 character !";
        }
        String target = request.getParameter("Target");
        if (target == null || target.trim().isEmpty() || target.length() > 750) {
            error4 = "Target cannot be null and lenght must not exceed 750 character !";
        }
        String plan = request.getParameter("Plan");
        if (plan == null || plan.trim().isEmpty() || plan.length() > 750) {
            error5 = "Plan cannot be null and lenght must not exceed 750 character !";
        }

        String typeclub = request.getParameter("idClub");
        if (typeclub == null || typeclub.trim().isEmpty()) {
            error6 = "Type Club must be select !";
        }
        int id = 0;
        HttpSession session = request.getSession();
        if (session.getAttribute("id") != null) {
            id = (int) session.getAttribute("id");
        } else {
            response.sendRedirect("loginf");
            return;
        }

        if (error1 != null || error2 != null || error3 != null || error4 != null || error5 != null || error6 != null) {
            request.setAttribute("error1", error1);
            request.setAttribute("error2", error2);
            request.setAttribute("error3", error3);
            request.setAttribute("error4", error4);
            request.setAttribute("error5", error5);
            request.setAttribute("error6", error6);
            request.setAttribute("nameClub", nameClub);
            request.setAttribute("member", member);
            request.setAttribute("reason", reason);
            request.setAttribute("typeclub", typeclub);
            request.setAttribute("target", target);
            request.setAttribute("plan", plan);
            List<String> getTypeClub = dao.gettypeclubAll();
            request.setAttribute("listtypeclub", getTypeClub);
            request.setAttribute("errorr", "Sent application not successfull !");
            request.getRequestDispatcher("View/ViewStudent/registerclub.jsp").forward(request, response);
            return;
        } else {
            request.setAttribute("error", "Sent successfull");
            int category = dao.getSettingbyValue(typeclub);
            dao.insertRegisterClub(nameClub, reason, member, id, category, target, plan);
            List<String> getTypeClub = dao.gettypeclubAll();
            request.setAttribute("listtypeclub", getTypeClub);
            SendMail sendMail = new SendMail();
            String title = "You have a club application !";
            String content = "You have a club application !";

            sendMail.sendMailDefault(title, content, "haundhe176911@fpt.edu.vn");
            request.getRequestDispatcher("View/ViewStudent/registerclub.jsp").forward(request, response);return;
        }
    }

}
