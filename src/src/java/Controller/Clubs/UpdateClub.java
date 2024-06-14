/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Clubs;

import DAO.ClubDao;
import Model.Clubs;
import Model.TypeClub;
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
@WebServlet(name = "UpdateClub", urlPatterns = {"/UpdateClub"})
public class UpdateClub extends HttpServlet {

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
            out.println("<title>Servlet UpdateClub</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateClub at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("id"));
        Clubs club = dao.getClubbyId(id);
        List<TypeClub> typeclub = dao.gettypeclubAll();
        request.setAttribute("listtypeclub", typeclub);
        request.setAttribute("Club", club);
        request.getRequestDispatcher("View/ViewAdmin/UpdateClub.jsp").forward(request, response);
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
        int id ;
        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
        }else{
           id=0; 
        }
            
            String nameclub = request.getParameter("nameclub");
            String datecreate = request.getParameter("datecreate");
            int point = Integer.parseInt(request.getParameter("point"));
        
            Clubs club = dao.getClubbyId(id);
            int idtype;
            if (request.getParameter("idtypeclub") != null) {
                idtype = Integer.parseInt(request.getParameter("idtypeclub"));
            } else {
                
                idtype = club.getType();
            }
            Date date = new Date();
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//            String datemodify = formatter.format(date);
            String img="";
            String description="";
            dao.updateClub(new Clubs(id, nameclub, point, date, date, 0, idtype,img,description));
        
        
        response.sendRedirect("ClubController");

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
