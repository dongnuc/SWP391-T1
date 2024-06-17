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
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 10t1q
 */
@WebServlet(name = "Event_UpdateServlet", urlPatterns = {"/EventUpdateServlet"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50)
public class Event_UpdateServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Event_UpdateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Event_UpdateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pr = response.getWriter();

        String xID = request.getParameter("idEvent");
        int ID = Integer.parseInt(xID);

        EventDAO eventDAO = new EventDAO();
        Event event = eventDAO.getEventById(ID);

        request.setAttribute("x", event);
        request.getRequestDispatcher("/View/ViewManager/Event_Update.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

        StringBuilder errorMessage = new StringBuilder();
        boolean hasError = false;

        if (nameEvent == null || nameEvent.isEmpty()) {
            errorMessage.append("Name Event cannot be empty.<br>");
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
        if (address == null || address.isEmpty()) {
            errorMessage.append("Address must be selected.<br>");
            hasError = true;
        }
        if (dateStartStr == null || dateStartStr.isEmpty()) {
            errorMessage.append("Date Start must be selected.<br>");
            hasError = true;
        }
        if (dateEndStr == null || dateEndStr.isEmpty()) {
            errorMessage.append("Date End must be selected.<br>");
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
        if (fileName.equals("images_event/" + filenamecheck) || fileName.isEmpty()) {
            errorMessage.append("File must be selected.<br>");
            hasError = true;
        }

        if (hasError) {
            request.setAttribute("mess", errorMessage.toString());

            EventDAO eD = new EventDAO();
            Event e = eD.getEventById(ID);
            request.setAttribute("x", e);
            request.getRequestDispatcher("/View/ViewManager/Event_Update.jsp").forward(request, response);
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

        Event event = new Event(ID, nameEvent, currentDate, status, address, dateEnd, IDClub, dateStart, fileName, eventType, description, content);
        eventDAO.updateEvent(event);

        getServletContext().getRequestDispatcher("/View/ViewManager/Event_List.jsp").forward(request, response);
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
