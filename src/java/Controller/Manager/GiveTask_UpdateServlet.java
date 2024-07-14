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
@WebServlet(name = "GiveTask_Update", urlPatterns = {"/GiveTaskUpdate"})
public class GiveTask_UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String xidEventTasK = request.getParameter("idEventTask");
        int idEventTasK = Integer.parseInt(xidEventTasK);

        EventTaskDAO eventTaskDAO = new EventTaskDAO();
        EventTask EventTask = eventTaskDAO.getEventTaskByIdTask(idEventTasK);

        EventDAO eventDAO = new EventDAO();
        ClubDao clubDao = new ClubDao();

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
        request.setAttribute("clubDao", clubDao);
        request.setAttribute("eventDAO", eventDAO);
        request.setAttribute("EventTask", EventTask);
        request.getRequestDispatcher("/View/ViewManager/Task_Update.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String xidEventTask = request.getParameter("idEventTask");
        String nameTask = request.getParameter("nameTask");
        String description = request.getParameter("description");
        String content = request.getParameter("content");
        String xdepartment = request.getParameter("department");
        String xbudget = request.getParameter("budget");
        String xstatus = request.getParameter("status");
        String xdeadline = request.getParameter("deadline");

        // Validate inputs
        boolean hasError = false;
        StringBuilder errornameTask = new StringBuilder();
        StringBuilder errordescription = new StringBuilder();
        StringBuilder errorcontent = new StringBuilder();
        StringBuilder errorxdepartment = new StringBuilder();
        StringBuilder errorxbudget = new StringBuilder();
        StringBuilder errorxstatus = new StringBuilder();
        StringBuilder errorxdeadline = new StringBuilder();

        if (nameTask == null || nameTask.trim().isEmpty()) {
            hasError = true;
            errornameTask.append("Name Task cannot be empty.<br>");
        }
        if (description == null || description.trim().isEmpty()) {
            hasError = true;
            errordescription.append("Description cannot be empty.<br>");
        }
        if (content == null || content.trim().isEmpty()) {
            hasError = true;
            errorcontent.append("Content cannot be empty.<br>");
        }
        if (xdepartment == null || xdepartment.trim().isEmpty()) {
            hasError = true;
            errorxdepartment.append("Department cannot be empty.<br>");
        }
        if (xbudget == null || xbudget.trim().isEmpty()) {
            hasError = true;
            errorxbudget.append("Budget cannot be empty.<br>");
        }
        if (xstatus == null || xstatus.trim().isEmpty()) {
            hasError = true;
            errorxstatus.append("Status cannot be empty.<br>");
        }
        if (xdeadline == null || xdeadline.trim().isEmpty()) {
            hasError = true;
            errorxdeadline.append("Deadline cannot be empty.<br>");
        }

        float budget = 0;
        int department = 0;
        int status = 0;
        Timestamp deadline = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        if (!hasError) {
            try {
                budget = Float.parseFloat(xbudget);
            } catch (NumberFormatException e) {
                hasError = true;
                errorxbudget.append("Budget must be a valid float number.<br>");
            }

            try {
                department = Integer.parseInt(xdepartment);
            } catch (NumberFormatException e) {
                hasError = true;
                errorxdepartment.append("Department must be a valid integer.<br>");
            }

            try {
                status = Integer.parseInt(xstatus);
            } catch (NumberFormatException e) {
                hasError = true;
                errorxstatus.append("Status must be a valid integer.<br>");
            }

            try {
                Date parsedDeadline = dateFormat.parse(xdeadline);
                deadline = new Timestamp(parsedDeadline.getTime());
            } catch (Exception e) {
                hasError = true;
                errorxdeadline.append("Deadline must be a valid date and time.<br>");
            }
        }

        if (hasError) {
            request.setAttribute("errornameTask", errornameTask.toString());
            request.setAttribute("errordescription", errordescription.toString());
            request.setAttribute("errorcontent", errorcontent.toString());
            request.setAttribute("errorxdepartment", errorxdepartment.toString());
            request.setAttribute("errorxbudget", errorxbudget.toString());
            request.setAttribute("errorxstatus", errorxstatus.toString());
            request.setAttribute("errorxdeadline", errorxdeadline.toString());
            
            doGet(request, response);
            return;
        }

        try {
            int idEventTask = Integer.parseInt(xidEventTask);
            EventTask eventTask = new EventTask(idEventTask, nameTask, description, content, deadline, department, budget, status);
            EventTaskDAO eventTaskDAO = new EventTaskDAO();
            eventTaskDAO.updateEventTask(eventTask);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/EventGiveTaskListServlet").forward(request, response);
    }

}
