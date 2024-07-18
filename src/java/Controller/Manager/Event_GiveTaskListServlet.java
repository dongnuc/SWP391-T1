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
@WebServlet(name="Event_GiveTaskListServlet", urlPatterns={"/EventGiveTaskListServlet"})
public class Event_GiveTaskListServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        List<EventTask> EventTaskByIDList = (List<EventTask>) request.getAttribute("EventTaskByIDList");
        
        Accounts account = (Accounts) request.getSession().getAttribute("curruser");
        StudentClubDao studentClubDAO = new StudentClubDao();
        List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(account.getId());
        
        if (EventTaskByIDList == null) {

            EventTaskDAO evenTaskDAO = new EventTaskDAO();
            EventTaskByIDList = new ArrayList<>();

            if (studentClubList != null) {
                for (StudentClub studentclub : studentClubList) {
                    if (studentclub.getLeader()== 1 && studentclub.getStatus() == 1) {
                        List<EventTask> eventTask = evenTaskDAO.getEventTaskByIdClub(studentclub.getIdClub());
                        if (eventTask != null) {
                            EventTaskByIDList.addAll(eventTask);
                        }
                    }
                }
            }
            EventTaskByIDList.sort((EventTask b1, EventTask b2) -> b2.getDateCreate().compareTo(b1.getDateCreate()));
        }
        int page = 1;
        int recordsPerPage = 5;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int start = (page - 1) * recordsPerPage;
        int end = Math.min(start + recordsPerPage, EventTaskByIDList.size());
        List<EventTask> paginatedList = EventTaskByIDList.subList(start, end);

        int noOfRecords = EventTaskByIDList.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        EventDAO eventDAO = new EventDAO();
        ClubDao clubDAO = new ClubDao();
        SettingDAO settingDAO = new SettingDAO();
        
        request.setAttribute("settingDAO", settingDAO);
        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("eventDAO", eventDAO);
        request.setAttribute("studentClubList", studentClubList);
        request.setAttribute("EventTaskByIDList", paginatedList);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.getRequestDispatcher("/View/ViewManager/Event_GiveTaskList.jsp").forward(request, response);
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

  
}
