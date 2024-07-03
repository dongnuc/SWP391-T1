/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.EventDAO;
import DAO.EventTypeDAO;
import Model.Event;
import Model.EventType;
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

        // Fetch the list of events
        EventDAO eventDAO = new EventDAO();
        List<Event> eventList = eventDAO.getAllEvent();

        // Fetch the list of event types
        EventTypeDAO eventTypeDAO = new EventTypeDAO();
        List<EventType> eventTypeList = eventTypeDAO.getAllEventTypes();

        // Set the attributes to be used in the JSP
        request.setAttribute("eventList", eventList);
        request.setAttribute("eventTypeList", eventTypeList);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/View/ViewManager/Event_List.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }
}
