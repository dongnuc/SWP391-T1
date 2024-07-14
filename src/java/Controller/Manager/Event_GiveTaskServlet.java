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
        String nameTask = request.getParameter("nametask");
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        String xdepartment = request.getParameter("department");
        int department = Integer.parseInt(xdepartment);
        String xdeadline = request.getParameter("deadline");
        String xbudget = request.getParameter("budget");
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
        if ("Event_ListManager.jsp".equals(from)) {
                request.getRequestDispatcher("/EventPostListServlet").forward(request, response);
            }
        
    }

}
