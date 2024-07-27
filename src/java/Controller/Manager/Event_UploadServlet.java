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

@WebServlet(name = "Event_Upload_Servlet", urlPatterns = {"/EventUploadServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class Event_UploadServlet extends HttpServlet {

    private static final String SAVE_DIR = "web/images_event";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fromPage = request.getParameter("from");
        request.setAttribute("from", fromPage);

        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
        List<StudentClub> StudentClubList = null;

        boolean restricted = true;

        if (acc != null) {
            StudentClubDao studentClubDAO = new StudentClubDao();
            StudentClubList = studentClubDAO.getStudentClubs(acc.getId());

            for (StudentClub studentClub : StudentClubList) {
                if (studentClub.getStatus() == 1 && studentClub.getRole() == 1) {
                    restricted = false;
                    break;
                }
            }
        }

        if (restricted) {
            response.sendRedirect(request.getContextPath() + "/View/ViewManager/404.html");
            return;
        }

        SettingDAO settingDAO = new SettingDAO();
        List<Settings> eventTypeList = settingDAO.getSettingsEvent();

        ClubDao clubDAO = new ClubDao();

        request.setAttribute("clubDAO", clubDAO);
        request.setAttribute("eventTypeList", eventTypeList);
        request.setAttribute("StudentClubList", StudentClubList);
        request.getRequestDispatcher("/View/ViewManager/Event_Post.jsp").forward(request, response);
    }

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
        for (Part part : request.getParts()) {
            if (part.getName().equals("file")) {
                fileName = extractFileName(part);
                if (fileName != null && !fileName.isEmpty()) {
                    part.write(savePath + File.separator + fileName);
                }
            }
        }
        EventDAO eventDAO = new EventDAO();
        String filenamecheck = Integer.toString(eventDAO.getAllEvent().size());

        if (fileName != null) {
            String fromPage = request.getParameter("from");
            request.setAttribute("from", fromPage);
            String nameEvent = request.getParameter("nameevent");
            String description = request.getParameter("description");
            String content = request.getParameter("content");
            String xIDClub = request.getParameter("idclub");
            String xEventType = request.getParameter("eventtype");
            String address = request.getParameter("address");
            String xStatus = request.getParameter("status");
            String dateStartStr = request.getParameter("datestart");
            String dateEndStr = request.getParameter("dateend");

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
            
            List<Event> eventList = eventDAO.getAllEvent();
            for (Event event : eventList) {
                if (event.getNameEvent().equals(nameEvent)) {
                    errorNameEvent.append("Name event is exist.<br>");
                    hasError = true;
                }
            }

            if (nameEvent == null || nameEvent.isEmpty()) {
                errorNameEvent.append("Name event cannot be empty.<br>");
                hasError = true;
            } else if (nameEvent.length() > 128) {
                errorNameEvent.append("Name event cannot exceed 128 characters.<br>");
                hasError = true;
            }
            if (description == null || description.isEmpty()) {
                errorDescription.append("Description cannot be empty.<br>");
                hasError = true;
            } else if (description.length() > 128) {
                errorDescription.append("Description cannot exceed 128 characters.<br>");
                hasError = true;
            }
            if (content == null || content.isEmpty()) {
                errorContent.append("Content cannot be empty.<br>");
                hasError = true;
            }
            if (xIDClub == null || xIDClub.isEmpty()) {
                errorClub.append("Club must be selected.<br>");
                hasError = true;
            }
            if (dateStartStr == null || dateStartStr.isEmpty()) {
                errorDateStart.append("Date start must be selected.<br>");
                hasError = true;
            }
            if (dateEndStr == null || dateEndStr.isEmpty()) {
                errorDateEnd.append("Date end must be selected.<br>");
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
            if (fileName.equals(filenamecheck) || fileName.isEmpty()) {
                errorFile.append("File must be selected.<br>");
                hasError = true;
            }
            if (address == null || address.isEmpty()) {
                errorAddress.append("address cannot be empty.<br>");
                hasError = true;
            } else if (address.length() > 128) {
                errorAddress.append("address cannot exceed 128 characters.<br>");
                hasError = true;
            }

            if (hasError) {
                request.setAttribute("from", fromPage);

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

                request.setAttribute("nameevent", nameEvent);
                request.setAttribute("description", description);
                request.setAttribute("content", content);
                request.setAttribute("idclub", xIDClub);
                request.setAttribute("eventtype", xEventType);
                request.setAttribute("address", address);
                request.setAttribute("status", xStatus);
                request.setAttribute("datestart", dateStartStr);
                request.setAttribute("dateend", dateEndStr);

                SettingDAO settingDAO = new SettingDAO();
                List<Settings> eventTypeList = settingDAO.getSettingsBlog();

                ClubDao clubDAO = new ClubDao();

                Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
                StudentClubDao studentClubDAO = new StudentClubDao();
                List<StudentClub> StudentClubList = studentClubDAO.getStudentClubs(acc.getId());

                request.setAttribute("clubDAO", clubDAO);
                request.setAttribute("eventTypeList", eventTypeList);
                request.setAttribute("StudentClubList", StudentClubList);

                request.getRequestDispatcher("/View/ViewManager/Event_Post.jsp").forward(request, response);
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

                Event event = new Event(nameEvent, timestamp, timestamp, status, address, dateEnd, IDClub, dateStart, "images_event/" + fileName, eventType, description, content);
                eventDAO.addEvent(event);

            } catch (Exception e) {
                e.printStackTrace();
            }

            if ("Event_ListManager.jsp".equals(fromPage)) {
                response.sendRedirect(request.getContextPath() + "/EventPostListServlet");
            } else {
                response.sendRedirect(request.getContextPath() + "/EventSerlet");
            }
        } else {
            response.getWriter().println("Error: File upload failed.");
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
