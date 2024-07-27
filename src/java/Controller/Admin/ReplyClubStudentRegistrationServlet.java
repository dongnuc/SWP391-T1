/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import Algorithm.SendMail;
import DAO.AccountDao;
import DAO.StudentClubDao;
import Model.Accounts;
import Model.ClubStudentRegistration;
import Model.StudentClub;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Nguyen Hau
 */
@WebServlet(name = "ReplyClubStudentRegistrationServlet", urlPatterns = {"/ReplyClubStudentRegistrationServlet"})
public class ReplyClubStudentRegistrationServlet extends HttpServlet {

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
            out.println("<title>Servlet ReplyClubStudentRegistrationServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReplyClubStudentRegistrationServlet at " + request.getContextPath() + "</h1>");
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
        String error = null;
        String error1 = null;
        String error2 = null;

        AccountDao db = new AccountDao();
        StudentClubDao stdao = new StudentClubDao();
        int a = Integer.parseInt(request.getParameter("a"));
        if (request.getParameter("idclub") != null && request.getParameter("idstudent") != null) {
            if (a == 1) {
                int idclub = Integer.parseInt(request.getParameter("idclub"));
                int idstudent = Integer.parseInt(request.getParameter("idstudent"));
                ClubStudentRegistration registration = stdao.getClubStudentRegistration(idstudent, idclub);
                ClubStudentRegistration registrationold = new ClubStudentRegistration();
                if (registration == null) {
                    request.setAttribute("registration", registrationold);
                }
                System.out.println(registration.getFullname());
                String reply = request.getParameter("reply");
                if (reply == null || reply.trim().isEmpty() || reply.length() > 750) {
                    error = "Reply Information can not be null";
                }
                if (error != null) {
                    request.setAttribute("registration", registration);
                    request.setAttribute("error", error);
                    request.setAttribute("reply", reply);
                    request.setAttribute("list", registration);
                    request.getRequestDispatcher("View/ViewAdmin/clubStudentRegistrationDetail.jsp").forward(request, response);

                } else {
                    stdao.insertStudentClub(new StudentClub(registration.getIdstudent(), registration.getIdclub(), 0, registration.getRole(), 0, null, null, 1));
                    Accounts acc = db.getAccountbyID(registration.getIdstudent());
                    SendMail sendMail = new SendMail();
                    String title = "Email reply to club student registration application";
                    String content = "You application " + registration.getNameClubbyId() + " club successfully because :"+ reply +" !";
                    String sendToEmail = acc.getEmail();
                    System.out.println(sendMail);
                    sendMail.sendMailDefault(title, content, sendToEmail);
                    request.setAttribute("error1", "You application " + registration.getNamebyId() + " club successfully!");
                    stdao.removeClubStudentRegistration(idstudent, idclub);
                    request.getRequestDispatcher("View/ViewAdmin/clubStudentRegistrationDetail.jsp").forward(request, response);
                }
            } else {
                int idclub = Integer.parseInt(request.getParameter("idclub"));
                int idstudent = Integer.parseInt(request.getParameter("idstudent"));
                ClubStudentRegistration registration = stdao.getClubStudentRegistration(idstudent, idclub);
                ClubStudentRegistration registrationold = new ClubStudentRegistration();
                if (registration == null) {
                    request.setAttribute("registration", registrationold);
                }
                String reply = request.getParameter("reply");
                if (reply == null || reply.trim().isEmpty() || reply.length() > 750) {
                    error = "Reply Information can not be null";
                }
                if (error != null) {
                    request.setAttribute("registration", registration);
                    request.setAttribute("error", error);
                    request.setAttribute("reply", reply);
                    request.setAttribute("list", registration);
                    request.getRequestDispatcher("View/ViewAdmin/clubStudentRegistrationDetail.jsp").forward(request, response);

                } else {
                    Accounts acc = db.getAccountbyID(registration.getIdstudent());
                    SendMail sendMail = new SendMail();
                    String title = "Email reply to club student registration application";
                    String content = "failure! You cannot application " + registration.getNameClubbyId() + "because :"+ reply +" !";
                    String sendToEmail = acc.getEmail();
                    sendMail.sendMailDefault(title, content, sendToEmail);
                    request.setAttribute("error2", " You refuse " + registration.getNamebyId() + " successfully !");
                    stdao.removeClubStudentRegistration(idstudent, idclub);
                    request.getRequestDispatcher("View/ViewAdmin/clubStudentRegistrationDetail.jsp").forward(request, response);
                }
            }
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
