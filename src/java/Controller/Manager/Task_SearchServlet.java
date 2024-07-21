/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import DAO.*;
import Model.*;
import Model.StudentClub;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10t1q
 */
@WebServlet(name = "Task_SearchServlet", urlPatterns = {"/TaskSearchServlet"})
public class Task_SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchKeyword = request.getParameter("searchKeyword");

        EventTaskDAO eventTaskDAO = new EventTaskDAO();

        Accounts account = (Accounts) request.getSession().getAttribute("curruser");
        StudentClubDao studentClubDAO = new StudentClubDao();
        List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(account.getId());

        List<EventTask> eventTaskByIDList = new ArrayList<>();

        if (studentClubList != null) {
            for (StudentClub studentClub : studentClubList) {
                List<EventTask> eventTask = eventTaskDAO.getEventTaskByIdClub(studentClub.getIdClub());
                if (eventTask != null) {
                    eventTaskByIDList.addAll(eventTask);
                }
            }
        }
        eventTaskByIDList.sort((EventTask b1, EventTask b2) -> b2.getDateCreate().compareTo(b1.getDateCreate()));

        List<EventTask> searchResults = new ArrayList<>();

        if (searchKeyword == null || searchKeyword.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Search information cannot be empty");
            request.setAttribute("EventTaskByIDList", eventTaskByIDList);  
            request.getRequestDispatcher("/EventGiveTaskListServlet").forward(request, response);
            return;
        }

        for (EventTask eventTask : eventTaskByIDList) {
            if (eventTask.getNameTask().toLowerCase().contains(searchKeyword.toLowerCase())) {
                searchResults.add(eventTask);
            }
        }

        if (searchResults.isEmpty()) {
            request.setAttribute("errorMessage", "Can't find title: " + searchKeyword);
            request.setAttribute("EventTaskByIDList", eventTaskByIDList);  
        } else {
            request.setAttribute("EventTaskByIDList", searchResults);
        }
        request.setAttribute("searchKeyword", searchKeyword);
        request.getRequestDispatcher("/EventGiveTaskListServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
