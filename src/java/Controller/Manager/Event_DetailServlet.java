package Controller.Manager;

import DAO.EventDAO;
import DAO.StudentClubDao;
import DAO.ClubDao;
import Model.Event;
import Model.Accounts;
import Model.StudentClub;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="Event_DetailServlet", urlPatterns={"/EventDetailServlet"})
public class Event_DetailServlet extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String ID = request.getParameter("idEvent");
        int xId = Integer.parseInt(ID);

        EventDAO eventDAO = new EventDAO();
        Event event = eventDAO.getEventById(xId);
        List<Event> recentEvents = eventDAO.getRecentEvents(5);
        request.setAttribute("event", event);
        
        Accounts acc = (Accounts) request.getSession().getAttribute("curruser");
        if (acc != null) {
            StudentClubDao studentClubDAO = new StudentClubDao();
            List<StudentClub> studentClubList = studentClubDAO.getStudentClubs(acc.getId());
            request.setAttribute("studentClubList", studentClubList);
        }
        
        ClubDao clubDao = new ClubDao();
        String clubName = clubDao.getClubNameByID(event.getIdClub());
        request.setAttribute("clubName", clubName);
        
        request.setAttribute("recentEvents", recentEvents);
        request.setAttribute("clubDao", clubDao);
       
        request.getRequestDispatcher("/View/ViewManager/Event_Detail.jsp").forward(request, response);
    } 
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    }
}
