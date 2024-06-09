/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Clubs;

import Algorithm.SendMail;
import DAO.AccountDao;
import DAO.ClubDao;
import Model.Accounts;
import Model.Clubs;
import Model.RegisterClub;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Nguyen Hau
 */
@WebServlet(name = "SetStatusClubController", urlPatterns = {"/SetStatusClubController"})
public class SetStatusClubController extends HttpServlet {

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
            out.println("<title>Servlet SetStatusClubController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SetStatusClubController at " + request.getContextPath() + "</h1>");
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
        AccountDao db = new AccountDao();
        if (request.getParameter("id")!= null) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.setStatusClub(id);
            RegisterClub registerclub = dao.getRegisterClubbyId(id);
            Date date1 = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String datecreate = formatter.format(date1);
            String datemodify = formatter.format(date1);
            String img="";
            String description="";
            dao.insertClub(new Clubs(0, registerclub.getNameclub(), 0, datecreate, datemodify, 0, registerclub.getIdtypeclub(),img,description));
           
            
            Accounts acc = db.getAccountbyID(registerclub.getIdStudent());
            SendMail sendMail = new SendMail();
            String title = "Tra lo dang ky cau lac bo";
            String content = "Dang ky cau lac bo thanh cong chuc cac ban co nhung phut giay hoat dong vui ve";
            String sendToEmail = acc.getPassword();
            System.out.println(sendToEmail);
            sendMail.sendMailDefault(title, content, sendToEmail);
        }
        List<RegisterClub> list = dao.printAllRegisterClub();
        request.setAttribute("list", list);
        request.getRequestDispatcher("View/ViewAdmin/RegisterClubAdmin.jsp").forward(request, response);
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
