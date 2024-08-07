/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.*;
import Model.*;
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
@WebServlet(name="Event_PostListServlet", urlPatterns={"/EventPostListServlet"})
public class Event_PostListServlet extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<Event> EventByIDList = (List<Event>) request.getAttribute("EventByIDList");
        String idClub = request.getParameter("idClub");
        String name = request.getParameter("name");
        String from = request.getParameter("from");
        
        Accounts account = (Accounts) request.getSession().getAttribute("curruser");
        StudentClubDao studentClubDAO = new StudentClubDao();
        List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(account.getId());
        
        if (EventByIDList == null) {

            EventDAO eventDao = new EventDAO();
            EventByIDList = new ArrayList<>();

            if (studentClubList != null) {
                for (StudentClub studentclub : studentClubList) {
                    if (studentclub.getLeader()== 1 && studentclub.getStatus() == 1) {
                        List<Event> events = eventDao.getEventsByClubId(studentclub.getIdClub());
                        if (events != null) {
                            EventByIDList.addAll(events);
                        }
                    }
                }
            }
            EventByIDList.sort((Event b1, Event b2) -> b2.getDatecreate().compareTo(b1.getDatecreate()));
        }
        
        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int start = (page - 1) * recordsPerPage;
        int end = Math.min(start + recordsPerPage, EventByIDList.size());
        List<Event> paginatedList = EventByIDList.subList(start, end);

        int noOfRecords = EventByIDList.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        SettingDAO settingsDAO = new SettingDAO();
        ClubDao clubDAO = new ClubDao();

        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("settingsDAO", settingsDAO);
        request.setAttribute("studentClubList", studentClubList);
        request.setAttribute("EventByIDList", paginatedList);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("idClub", idClub);
        request.setAttribute("name", name);
        request.setAttribute("from", from);
        
        request.getRequestDispatcher("/View/ViewManager/Event_ListManager.jsp").forward(request, response);
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

}
