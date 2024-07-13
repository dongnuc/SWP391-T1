/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import Algorithm.SendMail;
import DAO.AccountDao;
import DAO.ClubDao;
import Model.Accounts;
import Model.RegisterClub;
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
 * @author Nguyen Hau
 */
@WebServlet(name = "Refuseclub", urlPatterns = {"/Refuseclub"})
public class RefuseclubServlet extends HttpServlet {

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
            out.println("<title>Servlet Refuseclub</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Refuseclub at " + request.getContextPath() + "</h1>");
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
         ClubDao dao = new ClubDao();
        AccountDao db = new AccountDao();
        String error = null;
        String refuse = request.getParameter("refuse");
        if (refuse == null || refuse.trim().isEmpty() || refuse.length() > 750) {
            error = "you must be write reason refuse and sorter 750 character refuse !";
        }
        System.out.println(error);
        if (error == null) {
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                RegisterClub club = dao.getRegisterClubbyId(id);

                Accounts acc = db.getAccountbyID(club.getIdstudent());
                SendMail sendMail = new SendMail();
                String title = "Email reply to club registration application";
                String content = "Your club registration application is broken for the following reasons:"+refuse;

                String sendToEmail = acc.getEmail();
                sendMail.sendMailDefault(title, content, sendToEmail);
                dao.removeRegisteerClub(id);
            }
            List<String> getTypeClub = dao.gettypeclubAll();
            request.setAttribute("listtypeclub", getTypeClub);
            response.sendRedirect("RegisterclubAdmin");
        } else {
            if (request.getParameter("id") != null) {
                int id = Integer.parseInt(request.getParameter("id"));
                RegisterClub register = dao.getRegisterClubbyId(id);
                request.setAttribute("club", register);
                request.setAttribute("error", error);
                request.getRequestDispatcher("View/ViewAdmin/registerClubDetail.jsp").forward(request, response);
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
