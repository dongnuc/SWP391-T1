/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import DAO.ClubDao;
import Model.Clubs;
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
@WebServlet(name = "ClubProfile", urlPatterns = {"/ClubProfile"})
public class ClubProfileServlet extends HttpServlet {

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
            out.println("<title>Servlet ClubProfile</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClubProfile at " + request.getContextPath() + "</h1>");
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
        if(request.getParameter("id")!=null){
        int id = Integer.parseInt(request.getParameter("id"));
        Clubs club = dao.getClubbyId(id);
        List<String> typeclub = dao.gettypeclubAll();
        request.setAttribute("listtypeclub", typeclub);
        request.setAttribute("Club", club);
        }
        request.getRequestDispatcher("View/ViewManager/ClubProfile.jsp").forward(request, response);
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
    int id;
    String errorMessage = null;

    if (request.getParameter("id") != null) {
        id = Integer.parseInt(request.getParameter("id"));
    } else {
        id = 0;
    }
    Clubs club1 = dao.getClubbyId(id);

    String title = request.getParameter("title");

    if (title.length() > 250||title.trim().isEmpty()||title==null) {
        errorMessage = "Title must not be null and must be less than or equal to 250 characters.";
    }

    int point;
    if (request.getParameter("point") != null) {
        point = Integer.parseInt(request.getParameter("point"));
    } else {
        point = club1.getPoint();
    }

    
   String type = request.getParameter("typeclub");

    Date date = new Date();
    String datecreateStr = request.getParameter("datecreate");

    // Định dạng ngày tháng năm
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date datecreate = null;

    try {
        // Chuyển đổi từ chuỗi sang đối tượng Date
        datecreate = dateFormat.parse(datecreateStr);
        if (datecreate.after(date)) {
            errorMessage = "Date create cannot be in the future.";
        }
    } catch (Exception e) {
        e.printStackTrace();
        errorMessage = "Invalid date format.";
    }

    String img = "";
    String name ="";
    int category=dao.getSettingbyValue(type);
    String description = request.getParameter("description");

    if (description != null && description.length() > 1000) {
        errorMessage = "Description must be less than or equal to 1000 characters.";
    }

    if (errorMessage != null) {
        // Nếu có lỗi, thiết lập thông báo lỗi và chuyển tiếp lại trang JSP
        List<String> typeclub = dao.gettypeclubAll();
        request.setAttribute("listtypeclub", typeclub);
        request.setAttribute("Club", club1);
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("View/ViewManager/ClubProfile.jsp").forward(request, response);
    } else {
        // Nếu không có lỗi, cập nhật thông tin và chuyển tiếp lại trang JSP với thông báo thành công
        dao.updateClub(new Clubs(id, name, point,category, datecreate, date, 1, img,title, description));
        Clubs club = dao.getClubbyId(id);
        List<String> typeclub = dao.gettypeclubAll();
        request.setAttribute("listtypeclub", typeclub);
        request.setAttribute("Club", club);
        request.setAttribute("successMessage", "Update successful");
        request.getRequestDispatcher("View/ViewManager/ClubProfile.jsp").forward(request, response);
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
