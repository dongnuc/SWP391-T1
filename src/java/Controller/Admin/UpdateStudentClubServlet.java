/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

import DAO.StudentClubDao;
import Model.StudentClub;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nguyen Hau
 */
@WebServlet(name = "UpdateStudentClubServlet", urlPatterns = {"/UpdateStudentClubServlet"})
public class UpdateStudentClubServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateStudentClubServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStudentClubServlet at " + request.getContextPath() + "</h1>");
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
        StudentClubDao stdao = new StudentClubDao();
        if (request.getParameter("idclub") != null && request.getParameter("idstudent") != null) {
            int idclub = Integer.parseInt(request.getParameter("idclub"));
            int idstudent = Integer.parseInt(request.getParameter("idstudent"));
            request.setAttribute("student", stdao.getStudentinClub(idstudent, idclub));
            request.getRequestDispatcher("View/ViewAdmin/updateStudentClub.jsp").forward(request, response);
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
        String error1 = null;
        String error2 = null;
        int point = 0;

        if (request.getParameter("point") != null && !request.getParameter("point").trim().isEmpty()&&request.getParameter("point").matches("\\d+")) {
            point = Integer.parseInt(request.getParameter("point"));
        } else {
            error1 = "Point is number and can not be null";
        }
        int role = Integer.parseInt(request.getParameter("role"));

        int position = Integer.parseInt(request.getParameter("position"));

        Date date = new Date();
        String datecreateStr = request.getParameter("datecreate");

// Định dạng ngày tháng năm
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date datecreate = null;

        try {
            // Chuyển đổi từ chuỗi sang đối tượng Date
            datecreate = dateFormat.parse(datecreateStr);
            if (datecreate.after(date)) {
                error2 = "Date create cannot be in the future.";
            }
        } catch (ParseException e) {
            e.printStackTrace();
            error2 = "Invalid date format: " + e.getMessage();
        }

        StudentClubDao stdao = new StudentClubDao();
        if (request.getParameter("idclub") != null && request.getParameter("idstudent") != null) {
            int idclub = Integer.parseInt(request.getParameter("idclub"));
            int idstudent = Integer.parseInt(request.getParameter("idstudent"));

            if (error1 != null || error2 != null) {
                request.setAttribute("error1", error1);
                request.setAttribute("error2", error2);
                StudentClub student = stdao.getStudentinClub(idstudent, idclub);

                request.setAttribute("student", new StudentClub(idstudent, idclub, point, role, position, datecreate, date, student.getStatus()));

                request.getRequestDispatcher("View/ViewAdmin/updateStudentClub.jsp").forward(request, response);
            } else {
                StudentClub student = stdao.getStudentinClub(idstudent, idclub);
                StudentClub studentnew = new StudentClub(idstudent, idclub, point, role, position, datecreate, date, student.getStatus());
                stdao.updateStudentClub(studentnew);
                request.setAttribute("student", stdao.getStudentinClub(idstudent, idclub));
                request.setAttribute("error", "Update successful !");
                request.getRequestDispatcher("View/ViewAdmin/updateStudentClub.jsp").forward(request, response);
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
