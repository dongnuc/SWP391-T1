
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.AccountDao;
import DAO.FormDao;
import Model.Accounts;
import Model.Form;
import Services.SendMail;
import Services.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ReplyFormServlet", urlPatterns = {"/replyForm"})
public class ReplyFormServlet extends HttpServlet {

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
            out.println("<title>Servlet ReplyFormServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ReplyFormServlet at " + request.getContextPath() + "</h1>");
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
        FormDao daoForm = new FormDao();
        AccountDao daoAcc = new AccountDao();
        Validation validationInput = new Validation();
        PrintWriter out = response.getWriter();
        String contentReply = request.getParameter("contentReply").trim();
        String idForm = request.getParameter("idForm");
        System.out.println(contentReply.trim());
        String getPath = request.getContextPath();
        if (contentReply.isEmpty()) {
            System.out.println("hello World");
            request.setAttribute("errorReply", "You must input before submition");
            request.getRequestDispatcher("formdetail?idForm=" + idForm).forward(request, response);
//            response.sendRedirect("formdetail?idForm=" + idForm);
        } else {
            System.out.println("Hello else");
            String checkLength = validationInput.checkLength(contentReply, 1000);
            if (!checkLength.equals(contentReply)) {
                System.out.println("Hello else2");
                request.setAttribute("errorReply", checkLength);
                request.getRequestDispatcher("formdetail?idForm=" + idForm).forward(request, response);
            } else {
                Form getForm = daoForm.getFormByID(idForm);
                SendMail replyMail = new SendMail();
                HttpSession session = request.getSession();
                Accounts acc = (Accounts) session.getAttribute("curruser");
                int idAccount = acc.getId();
                String idAccountSetting = String.valueOf(idAccount);
                String tittleFormReply = "Reply question: " + getForm.getTitleForm();
                Accounts accSendMail = daoAcc.getAccountByIdSetting(idAccountSetting);
                replyMail.replyMailForm(tittleFormReply, contentReply, getForm.getEmail(),
                        accSendMail.getEmail(), accSendMail.getTokenEmail());
                daoForm.insertFormReply(contentReply, idForm);
                response.sendRedirect("formdetail?idForm=" + idForm);
            }
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
