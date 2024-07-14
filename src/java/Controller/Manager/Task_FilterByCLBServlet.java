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
@WebServlet(name="Task_FilterByCLBServlet", urlPatterns={"/TaskFilterByCLBServlet"})
public class Task_FilterByCLBServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        String ID = request.getParameter("idClub");
        int idClub = Integer.parseInt(ID);
        
        EventTaskDAO eventTaskDAO = new EventTaskDAO();
        List<EventTask> EventTaskByIDList = eventTaskDAO.getEventTaskByIdClub(idClub);
        
        EventTaskByIDList.sort((EventTask b1, EventTask b2) -> b2.getDateCreate().compareTo(b1.getDateCreate()));
        request.setAttribute("EventTaskByIDList", EventTaskByIDList);
        request.getRequestDispatcher("/EventGiveTaskListServlet").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

}
