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

/**
 *
 * @author 10t1q
 */
@WebServlet(name="Event_SearchAllServlet", urlPatterns={"/EventSearchAllServlet"})
public class Event_SearchAllServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        SettingDAO settingDAO = new SettingDAO();
        List<Settings> eventTypeList = settingDAO.getSettingsEvent();
        
        request.setAttribute("eventTypeList", eventTypeList);
        request.getRequestDispatcher("/View/ViewManager/Event_SearchAll.jsp").forward(request, response);
        
    } 

    
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter pr = response.getWriter();

    String nameEvent = request.getParameter("name");
    if (nameEvent == null || nameEvent.isEmpty()) {
        String mess = "Event not exist";
        
        request.setAttribute("mess", mess);
        
        SettingDAO settingDAO = new SettingDAO();
        List<Settings> eventTypeList = settingDAO.getSettingsEvent();
        
        request.setAttribute("eventTypeList", eventTypeList);
        
        request.getRequestDispatcher("/View/ViewManager/Event_SearchAll.jsp").forward(request, response);
        return; 
    }

    EventDAO eventDAO = new EventDAO();
    List<Event> event = eventDAO.getEventsByName(nameEvent);

    SettingDAO settingDAO = new SettingDAO();
    List<Settings> eventTypeList = settingDAO.getSettingsEvent();
    
    request.setAttribute("eventTypeList", eventTypeList);
    request.setAttribute("eventList", event);
    request.getRequestDispatcher("/View/ViewManager/Event_SearchAll.jsp").forward(request, response);
}

}