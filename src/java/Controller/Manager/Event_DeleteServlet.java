/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.EventDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author 10t1q
 */
@WebServlet(name="Event_DeleteServlet", urlPatterns={"/EventDeleteServlet"})
public class Event_DeleteServlet extends HttpServlet {
   
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String fromPage = request.getParameter("from");
        
        String xID = request.getParameter("idEvent");
        int Id = Integer.parseInt(xID);
        
        EventDAO eventDAO = new EventDAO();
        eventDAO.deleteEvent(Id);
        
        if ("Event_List.jsp".equals(fromPage)) {
        response.sendRedirect(request.getContextPath() + "/EventSerlet");
        }
    } 

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

}
