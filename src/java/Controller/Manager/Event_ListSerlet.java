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
import java.util.List;

/**
 *
 * @author 10t1q
 */
@WebServlet(name="EventSerlet", urlPatterns={"/EventSerlet"})
public class Event_ListSerlet extends HttpServlet {
   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        List<Event> eventList =(List<Event>) request.getAttribute("eventList");
        String idEventType = request.getParameter("idEventType");
        String name = request.getParameter("name");
        String from = request.getParameter("from");
        
        EventDAO eventDAO = new EventDAO();
        if(eventList == null){
         eventList = eventDAO.getAllEvent();
        }
        System.out.println(eventList.size());
        SettingDAO settingDAO = new SettingDAO();
        
        List<Settings> eventTypeList = settingDAO.getSettingsEvent();
        
        ClubDao clubDao = new ClubDao();
        
        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
        if (acc != null) {
            StudentClubDao studentClubDAO = new StudentClubDao();
            List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(acc.getId());
            request.setAttribute("StudentClubList", studentClubList);
        }
        
        int page = 1;
        int recordsPerPage = 10;
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        
        int start = (page - 1) * recordsPerPage;
        int end = Math.min(start + recordsPerPage, eventList.size());
        List<Event> paginatedList = eventList.subList(start, end);
        
        int noOfRecords = eventList.size();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        request.setAttribute("clubDao", clubDao);
        request.setAttribute("eventList", paginatedList);
        request.setAttribute("eventTypeList", eventTypeList);
        request.setAttribute("currentPage", page);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("idEventType", idEventType);
        request.setAttribute("name", name);
        request.setAttribute("from", from);
        
        request.getRequestDispatcher("/View/ViewManager/Event_List.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
}
