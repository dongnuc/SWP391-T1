/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import DAO.ClubDao;
import DAO.StudentClubDao;
import Model.Accounts;
import Model.StudentClub;
import com.google.gson.Gson;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
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
        HttpSession session = request.getSession();
        Accounts acc = (Accounts) session.getAttribute("curruser");
        if (acc == null) {
            response.sendRedirect("loginf");
        } else {
            ClubDao daoClub = new ClubDao();
            int idClubInt = daoClub.getClubManagerByIdAccDong(String.valueOf(acc.getId()));
            String idClub = String.valueOf(idClubInt);
            System.out.println(idClub);
            int numberMemeber = daoClub.countStudentInClubDong(idClub);
            int numberBlog = daoClub.countBlogInClubDong(idClub);
            int numberEvent = daoClub.countEventInClubDong(idClub);
            HashMap<String, String> listRoleNumber = daoClub.numberRoleInClubDong(idClub);
            List<Accounts> listNewAcc = daoClub.getAccountsNewInClub(idClub);
            System.out.println(listRoleNumber);
            Gson gson = new Gson();
            String jsonData = gson.toJson(listRoleNumber);
            request.setAttribute("listAcc", listNewAcc);
            System.out.println(listNewAcc.size());
            request.setAttribute("chartData", jsonData);
            request.setAttribute("numberEvent", numberEvent);
            request.setAttribute("numberBlog", numberBlog);
            request.setAttribute("numberMemeber", numberMemeber);
            request.getRequestDispatcher("/View/ViewManager/Manager_DashBoard.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
