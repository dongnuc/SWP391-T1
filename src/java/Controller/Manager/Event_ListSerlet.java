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

        EventDAO eventDAO = new EventDAO();
        List<Event> eventList = eventDAO.getAllEvent();

        SettingDAO settingDAO = new SettingDAO();
        List<Settings> eventTypeList = settingDAO.getSettingsEvent();
          

        request.setAttribute("eventList", eventList);
        request.setAttribute("eventTypeList", eventTypeList);

        request.getRequestDispatcher("/View/ViewManager/Event_List.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }
}
