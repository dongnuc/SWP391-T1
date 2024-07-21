/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Manager;

import DAO.EventTaskDAO;
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
@WebServlet(name="Task_DeleteServlet", urlPatterns={"/TaskDeleteServlet"})
public class Task_DeleteServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String xID = request.getParameter("idEventTask");
        int idEventTask = Integer.parseInt(xID);
        
        EventTaskDAO eventTaskDAO = new EventTaskDAO();
        eventTaskDAO.deleteEventTaskById(idEventTask);
        request.getRequestDispatcher("/EventGiveTaskListServlet").forward(request, response);
    } 

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }

}
