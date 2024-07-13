/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import Algorithm.SendMail;
import DAO.AccountDao;
import DAO.ClubDao;
import DAO.StudentClubDAO;
import Model.Accounts;
import Model.Clubs;
import Model.RegisterClub;
import Model.StudentClub;
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
@WebServlet(name = "SetStatusClubControllerServlet", urlPatterns = {"/SetStatusClubController"})
public class SetStatusClubControllerServlet extends HttpServlet {

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
        StudentClubDAO stdao = new StudentClubDAO();
        AccountDao db = new AccountDao();
        if (request.getParameter("id")!= null) {
            int id = Integer.parseInt(request.getParameter("id"));
            RegisterClub registerclub = dao.getRegisterClubbyId(id);
            Date date1 = new Date();
            String img="";
            String titlee="";
            String description="";
            Clubs clubold = new Clubs(0, registerclub.getNameclub(), 0,registerclub.getCategory(), registerclub.getDatecreate(), registerclub.getDatemodify(), 1 ,img,titlee,description);
            dao.insertClub(clubold);
            Clubs club = dao.getClubbyname(clubold.getNameclub());
            stdao.insertStudentClub(new StudentClub(0, 1, registerclub.getIdstudent(), club.getClub(), date1, date1));
            
            Accounts acc = db.getAccountbyID(registerclub.getIdstudent());
            SendMail sendMail = new SendMail();
            String title = "Email reply to club registration application";
            String content = "Club registration was successful and I hope you have fun moments !";
            String sendToEmail = acc.getEmail();
            System.out.println(sendToEmail);
            sendMail.sendMailDefault(title, content, sendToEmail);
            dao.removeRegisteerClub(id);
        }
        List<RegisterClub> list = dao.printAllRegisterClub();
        request.setAttribute("list", list);
        request.getRequestDispatcher("View/ViewAdmin/RegisterClubAdmin.jsp").forward(request, response);
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
