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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author 10t1q
 */
@WebServlet(name = "Event_GiveTaskServlet", urlPatterns = {"/EventGiveTaskServlet"})
public class Event_GiveTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String from = request.getParameter("from");
        String xIdEvent = request.getParameter("idEvent");
        String xIdClub = request.getParameter("idClub");

        ClubDao clubDAO = new ClubDao();
        EventDAO eventDAO = new EventDAO();

        SettingDAO settingDAO = new SettingDAO();
        List<Settings> settingList = settingDAO.getSettingsClub();

        Iterator<Settings> iterator = settingList.iterator();
        while (iterator.hasNext()) {
            Settings setting = iterator.next();
            if (setting.getValueSetting().equals("Manager")) {
                iterator.remove();
            }
        }

        request.setAttribute("settingList", settingList);
        request.setAttribute("from", from);
        request.setAttribute("idEvent", xIdEvent);
        request.setAttribute("idClub", xIdClub);
        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("eventDAO", eventDAO);

        request.getRequestDispatcher("/View/ViewManager/Event_GiveTask.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String from = request.getParameter("from");
        
        String xnameEvent = request.getParameter("eventname");
        int nameEvent = Integer.parseInt(xnameEvent);
        String xclub = request.getParameter("club");
        int club = Integer.parseInt(xclub);
        
        ClubDao clubDAO = new ClubDao();
        EventDAO eventDAO = new EventDAO();
        SettingDAO settingDAO = new SettingDAO();
        List<Settings> settingList = settingDAO.getSettingsClub();
        
        StringBuilder messnameTask = new StringBuilder();
        StringBuilder messdescription = new StringBuilder();
        StringBuilder messcontent = new StringBuilder();
        StringBuilder messxdepartment = new StringBuilder();
        StringBuilder messxdeadline = new StringBuilder();
        StringBuilder messxbudget = new StringBuilder();
        boolean hasError = false;
        
        String nameTask = request.getParameter("nametask");
         if (nameTask == null || nameTask.isEmpty()) {
                messnameTask.append("Name task cannot be empty.<br>");
                hasError = true;
            } else if (nameTask.length() > 128) {
                messnameTask.append("Name task cannot exceed 128 characters.<br>");
                hasError = true;
            }
        
        String description = request.getParameter("description");
        if (description == null || description.isEmpty()) {
                messdescription.append("Description cannot be empty.<br>");
                hasError = true;
            } else if (description.length() > 128) {
                messdescription.append("Name task cannot exceed 128 characters.<br>");
                hasError = true;
            }
        
        String content = request.getParameter("content");
        if (content == null || content.isEmpty()) {
                messcontent.append("Content cannot be empty.<br>");
                hasError = true;
            }
        
        String xdepartment = request.getParameter("department");
        if (xdepartment == null || xdepartment.isEmpty()) {
                messxdepartment.append("Department cannot be empty.<br>");
                hasError = true;
            }
        
        String xdeadline = request.getParameter("deadline");
        if (xdeadline == null || xdeadline.isEmpty()) {
                messxdeadline.append("Deadline cannot be empty.<br>");
                hasError = true;
            }
        
        String xbudget = request.getParameter("budget");
        if (xbudget == null || xbudget.isEmpty()) {
                messxbudget.append("Budget cannot be empty.<br>");
                hasError = true;
            }
        else {
    try {
        float budget = Float.parseFloat(xbudget);
        if (budget < 0) {
            messxbudget.append("Budget cannot be negative.<br>");
            hasError = true;
        }
    } catch (NumberFormatException e) {
        messxbudget.append("Budget must be a valid number.<br>");
        hasError = true;
    }
}
        
        if (hasError) {
        request.setAttribute("messnameTask", messnameTask);
        request.setAttribute("messdescription", messdescription);
        request.setAttribute("messcontent", messcontent);
        request.setAttribute("messxdepartment", messxdepartment);
        request.setAttribute("messxdeadline", messxdeadline);
        request.setAttribute("messxbudget", messxbudget);
        
        request.setAttribute("nameTask", nameTask);
        request.setAttribute("description", description);
        request.setAttribute("content", content);
        request.setAttribute("xdepartment", xdepartment);
        request.setAttribute("xdeadline", xdeadline);
        request.setAttribute("xbudget", xbudget);
            
        request.setAttribute("idEvent", xnameEvent);
        request.setAttribute("idClub", xclub);
        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("eventDAO", eventDAO);
        request.setAttribute("settingList", settingList);
        request.setAttribute("from", from);
        request.getRequestDispatcher("View/ViewManager/Event_GiveTask.jsp").forward(request, response);
        return;
        }
        int department = Integer.parseInt(xdepartment);
        float budget = Float.parseFloat(xbudget);
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        
        try{
        Date parsedDeadline = dateFormat.parse(xdeadline);
        Timestamp deadline = new Timestamp(parsedDeadline.getTime());
        
        EventTask eventTask = new EventTask(nameTask,description,content,nameEvent,club,deadline,department,budget,1);
        EventTaskDAO eventTaskDAO = new EventTaskDAO();
        eventTaskDAO.insertEventTask(eventTask);
        
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        if ("Event_GiveTaskList.jsp".equals(from)) {
                request.getRequestDispatcher("/EventGiveTaskListServlet").forward(request, response);
            }
        
    }

}
