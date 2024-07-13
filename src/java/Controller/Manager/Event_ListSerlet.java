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
        
        EventDAO eventDAO = new EventDAO();
        if(eventList == null){
         eventList = eventDAO.getAllEvent();
        }
        SettingDAO settingDAO = new SettingDAO();
        
        List<Settings> eventTypeList = settingDAO.getSettingsEvent();
        
        ClubDao clubDao = new ClubDao();
        
        request.setAttribute("clubDao", clubDao);
        request.setAttribute("eventList", eventList);
        request.setAttribute("eventTypeList", eventTypeList);
        System.out.println(eventTypeList.size()); 
        request.getRequestDispatcher("/View/ViewManager/Event_List.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }
}
