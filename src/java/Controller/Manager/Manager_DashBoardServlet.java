/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import DAO.StudentClubDao;
import Model.Accounts;
import Model.StudentClub;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author 10t1q
 */
@WebServlet(name = "Manager_DashBoardServlet", urlPatterns = {"/ManagerDashBoardServlet"})
public class Manager_DashBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
        List<StudentClub> StudentClubList = null;
        boolean restricted = true;
        int id = 0;
        HttpSession session = request.getSession();
        if (session.getAttribute("id") != null) {
            id = (int) session.getAttribute("id");
        } else {
            response.sendRedirect("loginf");
            return;
        }
        StudentClubDao studentClubDAO = new StudentClubDao();
        StudentClubList = studentClubDAO.getStudentClubs(id);
        int idclub = 0;
        
        for (StudentClub studentClub : StudentClubList) {
            if (studentClub.getStatus() == 1 && studentClub.getLeader()== 1) {
                idclub =studentClub.getIdClub();
            }
        }
        if (acc != null) {
            StudentClubList = studentClubDAO.getStudentClubs(acc.getId());

            for (StudentClub studentClub : StudentClubList) {
                if (studentClub.getStatus() == 1 && studentClub.getLeader() == 1) {
                    restricted = false;
                    break;
                }
            }
        }

        if (restricted) {
            response.sendRedirect(request.getContextPath() + "/View/ViewManager/404.html");
            return;
        }

        request.setAttribute("id", idclub);
        request.getRequestDispatcher("/View/ViewManager/Manager_DashBoard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
