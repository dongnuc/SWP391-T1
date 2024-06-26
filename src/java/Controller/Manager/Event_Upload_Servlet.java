package Controller.Manager;

import DAO.*;
import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "Event_Upload_Servlet", urlPatterns = {"/EventUploadServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)   // 50MB
public class Event_Upload_Servlet extends HttpServlet {

    private static final String SAVE_DIR = "web/images_event";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();
        
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
        String filenamecheck =Integer.toString(eventDAO.getAllEvent().size());
                
        if (fileName != null) {
            String nameEvent = request.getParameter("nameevent");
            String description = request.getParameter("description");
            String content = request.getParameter("content");
            String xIDClub = request.getParameter("idclub");
            String xEventType = request.getParameter("eventtype");
            String address = request.getParameter("address");
            String xStatus = request.getParameter("status");
            String dateStartStr = request.getParameter("datestart");
            String dateEndStr = request.getParameter("dateend");
            

            StringBuilder errorMessage = new StringBuilder();
            boolean hasError = false;

            if (nameEvent == null || nameEvent.isEmpty()) {
                errorMessage.append("Name event cannot be empty.<br>");
                hasError = true;
            }
            if (description == null || description.isEmpty()) {
                errorMessage.append("Description cannot be empty.<br>");
                hasError = true;
            }
            if (content == null || content.isEmpty()) {
                errorMessage.append("Content cannot be empty.<br>");
                hasError = true;
            }
            if (xIDClub == null || xIDClub.isEmpty()) {
                errorMessage.append("Club must be selected.<br>");
                hasError = true;
            }
            if (dateStartStr == null || dateStartStr.isEmpty()) {
                errorMessage.append("Date start must be selected.<br>");
                hasError = true;
            }
            if (dateEndStr == null || dateEndStr.isEmpty()) {
                errorMessage.append("Date end must be selected.<br>");
                hasError = true;
            }
            if (xStatus == null || xStatus.isEmpty()) {
                errorMessage.append("Status must be provided.<br>");
                hasError = true;
            }
            if (xEventType == null || xEventType.isEmpty()) {
                errorMessage.append("Event type must be selected.<br>");
                hasError = true;
            }
            if ( fileName.equals(filenamecheck) || fileName.isEmpty() ) {
                errorMessage.append("File must be selected.<br>");
                hasError = true;
            }
            if (address == null || address.isEmpty()) {
                errorMessage.append("Address cannot be empty.<br>");
                hasError = true;
            }

            if (hasError) {
                request.setAttribute("mess", errorMessage.toString());
                request.setAttribute("nameevent", nameEvent);
                request.setAttribute("description", description);
                request.setAttribute("content", content);
                request.setAttribute("idclub", xIDClub);
                request.setAttribute("eventtype", xEventType);
                request.setAttribute("address", address);
                request.setAttribute("status", xStatus);
                request.setAttribute("datestart", dateStartStr);
                request.setAttribute("dateend", dateEndStr);
                request.getRequestDispatcher("/View/ViewManager/Event_Post.jsp").forward(request, response);
                return;
            }

            int IDClub = Integer.parseInt(xIDClub);
            int eventType = Integer.parseInt(xEventType);
            int status = Integer.parseInt(xStatus);
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateStart = null;
            Date dateEnd = null;
            try {
                dateStart = formatter.parse(dateStartStr);
                dateEnd = formatter.parse(dateEndStr);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Date currentDate = new Date();

            Event event = new Event(nameEvent, currentDate, currentDate, status, address, dateEnd, IDClub, dateStart, "images_event/" + fileName, eventType, description, content);
            eventDAO.addEvent(event);

            getServletContext().getRequestDispatcher("/View/ViewManager/Event_List.jsp").forward(request, response);
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
