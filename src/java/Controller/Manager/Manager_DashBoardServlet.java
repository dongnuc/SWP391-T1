/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import DAO.ClubDao;
import DAO.EventDAO;
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
        String idClubGet = request.getParameter("idClub");
        String year = request.getParameter("year");
        HttpSession session = request.getSession();
        ClubDao daoClub = new ClubDao();
        System.out.println("idRaw: "+idClubGet);
        System.out.println("year raw: "+year);
        EventDAO eventDao = new EventDAO();
        Gson gson = new Gson();
        Accounts acc = (Accounts) session.getAttribute("curruser");
        if (acc == null) {
            response.sendRedirect("loginf");
        } else {
            HashMap<String, String> listManagerClub = daoClub.getListClubManagerByIdAccDong(String.valueOf(acc.getId()));
            int idClubInt = daoClub.getClubManagerByIdAccDong(String.valueOf(acc.getId()));

            if (idClubGet != null && listManagerClub.size() > 1) {
                try {
                    idClubInt = Integer.parseInt(idClubGet.trim());
                    System.out.println("idClubget: " +idClubInt);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            String idClub = String.valueOf(idClubInt);
            if (!daoClub.checkManagerClub(String.valueOf(acc.getId()), idClub)) {
                response.sendRedirect("home");
            }
            System.out.println(idClub);
            int numberMemeber = daoClub.countStudentInClubDong(idClub);
            int numberBlog = daoClub.countBlogInClubDong(idClub);
            int numberEvent = daoClub.countEventInClubDong(idClub);
            if (year == null) {
                year = "2024";
            }
            HashMap<String, String> listEventReport = eventDao.eventReportDong(idClub, year);
            HashMap<String, String> listRoleNumber = daoClub.numberRoleInClubDong(idClub);//draw pie chart
            List<Accounts> listNewAcc = daoClub.getAccountsNewInClubDong(idClub); // new Member in club

            String jsonData = gson.toJson(listRoleNumber);
            String jsonEventData = gson.toJson(listEventReport);
            System.out.println(idClub);
            request.setAttribute("year", year);
            request.setAttribute("idClub", idClub);
            request.setAttribute("reportEvent", jsonEventData);
            request.setAttribute("listManager", listManagerClub);
            request.setAttribute("listAcc", listNewAcc);
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
