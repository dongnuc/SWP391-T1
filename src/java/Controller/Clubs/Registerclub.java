/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Clubs;
import Model.RegisterClub;
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
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.util.List;

/**
 *
 * @author Nguyen Hau
 */
@WebServlet(name="registerclub", urlPatterns={"/registerclub"})
public class Registerclub extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        ClubDao dao = new ClubDao();
        List<TypeClub> getTypeClub = dao.gettypeclubAll();
        request.setAttribute("listtypeclub", getTypeClub);
        request.getRequestDispatcher("View/ViewStudent/registerclub.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String nameClub = request.getParameter("NameClub");
        String reason = request.getParameter("Reason");
        int idtypeclub = Integer.parseInt(request.getParameter("idClub"));
        HttpSession session = request.getSession()  ;
        int id = (int) session.getAttribute("id");
                
        ClubDao dao = new ClubDao();
        dao.insertRegisterClub(nameClub,reason, id,idtypeclub);
        dao.printAllRegisterClub();
        request.getRequestDispatcher("View/ViewStudent/registerclub.jsp").forward(request, response);
    }

 
}
