/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import DAO.*;
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author 10t1q
 */
@WebServlet(name = "Event_SearchAllServlet", urlPatterns = {"/EventSearchAllServlet"})
public class Event_SearchAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String from = request.getParameter("from");

        String nameEvent = request.getParameter("name");

        if ("Event_List.jsp".equals(from)) {
            EventDAO eventDAO = new EventDAO();
            List<Event> searchResults = null;

            if (nameEvent == null || nameEvent.trim().isEmpty()) {
                request.setAttribute("errorMessage", "Name Event can't be null.");
            } else {
                searchResults = eventDAO.getEventsByName(nameEvent);
                if (searchResults.isEmpty()) {
                    request.setAttribute("errorMessage", "Can't find event with name: " + nameEvent);
                }
            }

            SettingDAO settingDAO = new SettingDAO();
            List<Settings> eventTypeList = settingDAO.getSettingsEvent();

            request.setAttribute("eventTypeList", eventTypeList);
            request.setAttribute("eventList", searchResults);
            
            request.getRequestDispatcher("/EventSerlet").forward(request, response);
        }
        else if ("Event_ListManager.jsp".equals(from)) {
            
            Accounts account = (Accounts) request.getSession().getAttribute("curruser");
            StudentClubDAO studentClubDAO = new StudentClubDAO();
            List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(account.getId());
            
            List<Event> EventByIDList = new ArrayList<>();
            EventDAO eventDAO = new EventDAO();
            
            if (studentClubList != null) {
                for (StudentClub studentclub : studentClubList) {
                    if (studentclub.getLeader()== 1 && studentclub.getStatus() == 1) {
                        List<Event> events = eventDAO.getEventsByClubId(studentclub.getIdClub());
                        if (events != null) {
                            EventByIDList.addAll(events);
                        }
                    }
                }
            }
            EventByIDList.sort((Event b1, Event b2) -> b2.getDatecreate().compareTo(b1.getDatecreate()));
            
            List<Event> searchResults = new ArrayList<>();
            
            if (nameEvent == null || nameEvent.trim().isEmpty()) {
                searchResults = EventByIDList;
                request.setAttribute("errorMessage", "Search information cant not empty");
            } else {
                for (Event event : EventByIDList) {
                    if (event.getNameEvent().toLowerCase().contains(nameEvent.toLowerCase())) {
                        searchResults.add(event);
                    }
                }
                if (searchResults.isEmpty()) {
                    request.setAttribute("errorMessage", "Cant finf name event: " + nameEvent);
                }
            }
            request.setAttribute("EventByIDList", searchResults);
            request.getRequestDispatcher("/EventPostListServlet").forward(request, response);
        }
    }
}
