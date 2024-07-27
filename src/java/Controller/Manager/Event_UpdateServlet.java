/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import DAO.*;
import Model.*;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 10t1q
 */
@WebServlet(name = "Event_UpdateServlet", urlPatterns = {"/EventUpdateServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class Event_UpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fromPage = request.getParameter("from");
        request.setAttribute("from", fromPage);
        
        String xID = request.getParameter("idEvent");
        int ID = Integer.parseInt(xID);

        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
        StudentClubDao studentClubDAO = new StudentClubDao();
        List<StudentClub> StudentClubList = studentClubDAO.getStudentClubs(acc.getId());

        boolean restricted = true;
        for (StudentClub studentClub : StudentClubList) {
            if (studentClub.getStatus() == 1 && studentClub.getRole() == 1) {
                restricted = false;
                break;
            }
        }

        if (restricted) {
            response.sendRedirect(request.getContextPath() + "/View/ViewManager/404.html");
            return;
        }

        EventDAO eventDAO = new EventDAO();
        Event event = eventDAO.getEventById(ID);

        SettingDAO settingDao = new SettingDAO();
        List<Settings> eventTypeList = settingDao.getSettingsEvent();

        ClubDao clubDAO = new ClubDao();

        request.setAttribute("studentClubList", StudentClubList);
        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("event", event);
        request.setAttribute("eventTypeList", eventTypeList);
        request.setAttribute("idEvent", xID);

        request.getRequestDispatcher("/View/ViewManager/Event_Update.jsp").forward(request, response);
    }

    private static final String SAVE_DIR = "web/images_event";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String xappPath = request.getServletContext().getRealPath("");
        String appPath = xappPath.substring(0, xappPath.length() - 11);
        String savePath = appPath + File.separator + SAVE_DIR;

        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }

        String fileName = null;
        boolean isFileUpdated = false;

        for (Part part : request.getParts()) {
            if (part.getName().equals("file") && part.getSize() > 0) {
                fileName = extractFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    part.write(savePath + File.separator + fileName);
                    isFileUpdated = true;
                }
            }
        }

        String frompage = request.getParameter("from");
        String xID = request.getParameter("idEvent");
        int ID = Integer.parseInt(xID);
        String nameEvent = request.getParameter("nameevent");
        String xStatus = request.getParameter("status");
        String address = request.getParameter("address");
        String dateStartStr = request.getParameter("datestart");
        String dateEndStr = request.getParameter("dateend");
        String xIDClub = request.getParameter("idclub");
        String xEventType = request.getParameter("eventtype");
        String description = request.getParameter("description");
        String content = request.getParameter("content");

        if (!isFileUpdated) {
            fileName = request.getParameter("img");
        } else {
            fileName = "images_event/" + fileName;
        }

        EventDAO eventDAO = new EventDAO();
        String filenamecheck = Integer.toString(eventDAO.getAllEvent().size());

        StringBuilder errorNameEvent = new StringBuilder();
        StringBuilder errorDescription = new StringBuilder();
        StringBuilder errorContent = new StringBuilder();
        StringBuilder errorClub = new StringBuilder();
        StringBuilder errorDateStart = new StringBuilder();
        StringBuilder errorDateEnd = new StringBuilder();
        StringBuilder errorStatus = new StringBuilder();
        StringBuilder errorEventType = new StringBuilder();
        StringBuilder errorFile = new StringBuilder();
        StringBuilder errorAddress = new StringBuilder();
        boolean hasError = false;

        Event curEvent = eventDAO.getEventById(ID);
        List<Event> eventList = eventDAO.getAllEvent();
        for (Event event : eventList) {
            if (event.getNameEvent().equals(nameEvent) && !event.getNameEvent().equals(curEvent.getNameEvent())) {
                errorNameEvent.append("Name event is exist.<br>");
                hasError = true;
            }
        }

        if (nameEvent == null || nameEvent.isEmpty()) {
            errorNameEvent.append("Name Event cannot be empty.<br>");
            hasError = true;
        } else if (nameEvent.length() > 128) {
                errorNameEvent.append("Name event cannot exceed 128 characters.<br>");
                hasError = true;
            }
        if (description == null || description.isEmpty()) {
            errorDescription.append("Description cannot be empty.<br>");
            hasError = true;
        } else if (description.length() > 256) {
                errorDescription.append("Description cannot exceed 128 characters.<br>");
                hasError = true;
            }
        if (content == null || content.isEmpty()) {
            errorContent.append("Content cannot be empty.<br>");
            hasError = true;
        }
        if (address == null || address.isEmpty()) {
            errorClub.append("Address must be selected.<br>");
            hasError = true;
        }
        if (dateStartStr == null || dateStartStr.isEmpty()) {
            errorDateStart.append("Date Start must be selected.<br>");
            hasError = true;
        }
        if (dateEndStr == null || dateEndStr.isEmpty()) {
            errorDateEnd.append("Date End must be selected.<br>");
            hasError = true;
        }
        if (xStatus == null || xStatus.isEmpty()) {
            errorStatus.append("Status must be provided.<br>");
            hasError = true;
        }
        if (xEventType == null || xEventType.isEmpty()) {
            errorEventType.append("Event type must be selected.<br>");
            hasError = true;
        }
        if (fileName.equals("images_event/" + filenamecheck) || fileName.isEmpty()) {
            errorFile.append("File must be selected.<br>");
            hasError = true;
        }
        if (address == null || address.isEmpty()) {
            errorAddress.append("Address cannot be empty.<br>");
            hasError = true;
        }

        if (hasError) {
            request.setAttribute("errorNameEvent", errorNameEvent.toString());
            request.setAttribute("errorDescription", errorDescription.toString());
            request.setAttribute("errorContent", errorContent.toString());
            request.setAttribute("errorClub", errorClub.toString());
            request.setAttribute("errorDateStart", errorDateStart.toString());
            request.setAttribute("errorDateEnd", errorDateEnd.toString());
            request.setAttribute("errorStatus", errorStatus.toString());
            request.setAttribute("errorEventType", errorEventType.toString());
            request.setAttribute("errorFile", errorFile.toString());
            request.setAttribute("errorAddress", errorAddress.toString());

            EventDAO eD = new EventDAO();
            Event event = eD.getEventById(ID);
            ClubDao clubDAO = new ClubDao();
            SettingDAO settingDao = new SettingDAO();
            List<Settings> eventTypeList = settingDao.getSettingsEvent();
            StudentClubDao studentClubDAO = new StudentClubDao();
            Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
            List<StudentClub> StudentClubList = studentClubDAO.getStudentClubs(acc.getId());

            request.setAttribute("studentClubList", StudentClubList);
            request.setAttribute("eventTypeList", eventTypeList);
            request.setAttribute("clubDAO", clubDAO);
            request.setAttribute("event", event);
            request.setAttribute("idEvent", xID);

            request.getRequestDispatcher("/View/ViewManager/Event_Update.jsp").forward(request, response);
            return;
        }

        int IDClub = Integer.parseInt(xIDClub);
        int eventType = Integer.parseInt(xEventType);
        int status = Integer.parseInt(xStatus);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");

        try {
            Date parsedDateStart = dateFormat.parse(dateStartStr);
            Date parsedDateEnd = dateFormat.parse(dateEndStr);

            Timestamp dateStart = new Timestamp(parsedDateStart.getTime());
            Timestamp dateEnd = new Timestamp(parsedDateEnd.getTime());

            Event event = new Event(ID, nameEvent, timestamp, status, address, dateEnd, IDClub, dateStart, fileName, eventType, description, content);
            eventDAO.updateEvent(event);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if ("Event_ListManager.jsp".equals(frompage)) {
            response.sendRedirect(request.getContextPath() + "/EventPostListServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/EventSerlet");
        }
    }

    private String extractFileName(Part part) {
        EventDAO eventDAO = new EventDAO();
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                String filename = s.substring(s.indexOf("=") + 2, s.length() - 1);
                return eventDAO.getAllEvent().size() + filename;
            }
        }
        return null;
    }
}
