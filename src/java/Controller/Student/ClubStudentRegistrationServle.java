/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Student;

import Algorithm.SendMail;
import DAO.AccountDao;
import DAO.ClubDao;
import DAO.StudentClubDao;
import Model.ClubStudentRegistration;
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
 * @author Nguyen Hau
 */
@WebServlet(name = "ClubStudentRegistrationServle", urlPatterns = {"/ClubStudentRegistrationServle"})
public class ClubStudentRegistrationServle extends HttpServlet {

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
            out.println("<title>Servlet ClubStudentRegistrationServle</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClubStudentRegistrationServle at " + request.getContextPath() + "</h1>");
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
        if(request.getParameter("id")!=null){
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("id", id);
        request.getRequestDispatcher("View/ViewStudent/clubStudentRegistration.jsp").forward(request, response);
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
        StudentClubDao stdao = new StudentClubDao();
        String error = null;
        String error1 = null;
        String error2 = null;
        String error3 = null;
        String error4 = null;
        String error5 = null;
        String error7 = null;
        int role = 0;
        String fullname = request.getParameter("fullname");
        if (fullname == null || fullname.trim().isEmpty() || fullname.length() > 35|| !fullname.matches("^[a-zA-Z\\s]*$")) {
            error1 = "Full name cannot be null, length must not exceed 35 characters, and must not contain special characters!";
        }
        String roleparam = request.getParameter("role");
        if (roleparam != null && !roleparam.trim().isEmpty()&&Integer.parseInt(roleparam)!=0) {
            role = Integer.parseInt(request.getParameter("role"));

        } else {
            error5 = "Role must be select !";
        }
        String talent = request.getParameter("talent");
        if (talent == null || talent.trim().isEmpty() || talent.length() > 200) {
            error2 = "Talent cannot be null and lenght must not exceed 200 character !";
        }
        String experience = request.getParameter("experience");
        if (experience == null || experience.trim().isEmpty() || experience.length() > 750) {
            error3 = "Experience cannot be null and lenght must not exceed 750 character !";
        }
        String target = request.getParameter("target");
        if (target == null || target.trim().isEmpty() || target.length() > 750) {
            error4 = "Target cannot be null and lenght must not exceed 750 character !";
        }
        int id = 0;
        HttpSession session = request.getSession();
        if (session.getAttribute("id") != null) {
            id = (int) session.getAttribute("id");
        } else {
            response.sendRedirect("loginf");
            return;
        }

        if (request.getParameter("idclub") != null) {
            int idclub = Integer.parseInt(request.getParameter("idclub"));
            if(stdao.isStudentInClub(id, idclub)){
                error7 = "You are already in this club but cannot register !";
            }
            if (error1 != null || error2 != null || error3 != null || error4 != null || error5 != null||error7 != null) {
                request.setAttribute("error1", error1);
                request.setAttribute("error2", error2);
                request.setAttribute("error3", error3);
                request.setAttribute("error4", error4);
                request.setAttribute("error5", error5);
                request.setAttribute("error7", error7);
                request.setAttribute("fullname", fullname);
                request.setAttribute("role", role);
                request.setAttribute("talent", talent);
                request.setAttribute("id", idclub);
                request.setAttribute("target", target);
                request.setAttribute("experience", experience);
                request.setAttribute("errorr", "Sent application not successfull !");
                request.getRequestDispatcher("View/ViewStudent/clubStudentRegistration.jsp").forward(request, response);
                return;
            } else {
                request.setAttribute("error", "Sent successfull");
                stdao.insertClubStudentRegistration(new ClubStudentRegistration(0, id, idclub, role, null, fullname, talent, experience, target, null));
                SendMail sendMail = new SendMail();
                String title = "The club has a student registered in the club !";
                String content = "The club has a student registered in the club!";
                AccountDao acdao = new AccountDao();
                request.setAttribute("id", idclub);
                sendMail.sendMailDefault(title, content, acdao.getEmailbyID(stdao.getManagerinClub(idclub).getIdStudent()));
                request.getRequestDispatcher("View/ViewStudent/clubStudentRegistration.jsp").forward(request, response);
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
