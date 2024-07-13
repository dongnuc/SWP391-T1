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
@WebServlet(name="Event_TypeServlet", urlPatterns={"/EventTypeServlet"})
public class Event_TypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String from = request.getParameter("from");
        
        String ID = request.getParameter("idEventType");
        int xId = Integer.parseInt(ID);
   
        
        SettingDAO settingDAO = new SettingDAO();
        Settings settings = settingDAO.getSettingById(xId);

        EventDAO eventDAO = new EventDAO();
        List<Event> eventList = eventDAO.getEventsByType(xId);

        request.setAttribute("settings", settings);
        request.setAttribute("eventList", eventList);

        List<Settings> eventTypeList = settingDAO.getSettingsEvent();
        request.setAttribute("eventTypeList", eventTypeList);
        
        if ("Event_List.jsp".equals(from)) {
        request.getRequestDispatcher("/EventSerlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }


}
