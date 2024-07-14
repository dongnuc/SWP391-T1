/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.EventDAO;
import Model.Event;
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
@WebServlet(name="Event_FilterByCLBServlet", urlPatterns={"/EventFilterByCLBServlet"})
public class Event_FilterByCLBServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String ID = request.getParameter("idClub");
        int xId = Integer.parseInt(ID);
        
        EventDAO eventDAO = new EventDAO();
        List<Event> EventByIDList = eventDAO.getEventsByClubId(xId);
        
        EventByIDList.sort((Event b1, Event b2) -> b2.getDatecreate().compareTo(b1.getDatecreate()));
        
         request.setAttribute("EventByIDList", EventByIDList);
         request.getRequestDispatcher("/EventPostListServlet").forward(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

}
