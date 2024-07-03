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
@WebServlet(name="Event_TypeServlet", urlPatterns={"/EventTypeServlet"})
public class Event_TypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ID = request.getParameter("idEventType");
        int xId = Integer.parseInt(ID);
   
        EventTypeDAO eventTypeDAO = new EventTypeDAO();
        EventType eventType = eventTypeDAO.getEventTypeByID(xId);

        EventDAO eventDAO = new EventDAO();
        List<Event> eventList = eventDAO.getEventsByType(xId);

        request.setAttribute("x", eventType);
        request.setAttribute("eventList", eventList);

        List<EventType> eventTypeList = eventTypeDAO.getAllEventTypes();
        request.setAttribute("eventTypeList", eventTypeList);
        
        request.getRequestDispatcher("/View/ViewManager/Event_TypeList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }


}
