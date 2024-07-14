/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Manager;

import DAO.EventRegistrationDao;
import Model.Accounts;
import Model.EventRegistration;
import Services.SendEmailHuy;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84358
 */
@WebServlet(name = "ListMember", urlPatterns = {"/ListMember"})
public class ListMember extends HttpServlet {

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
            out.println("<title>Servlet ListMember</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListMember at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        EventRegistrationDao d = new EventRegistrationDao();
        SendEmailHuy send=new SendEmailHuy();
        HttpSession session=request.getSession();
        Accounts ac=(Accounts) session.getAttribute("accountprofile");
        int idstudent=ac.getId();
        List<String> listidclub = d.GetClubofManager(idstudent);
        
        request.setAttribute("listidclub", listidclub);
        int page=1;
        String gmail="";
        String action=null;
        SendEmailHuy s=new SendEmailHuy();
        try {
            action= request.getParameter("action");
            int idregister=Integer.parseInt(request.getParameter("idregister"));
            String reason=request.getParameter("reason");
            gmail=request.getParameter("gmail");
            if(action.equals("1")){
                send.sendemailfail(gmail, reason);
                System.out.println("Huy123");
            }else{
                send.sendemailsuccess(gmail);
                
            }
            d.UpdateStatus(idregister, action,reason);
            
        } catch (Exception e) {
        }
        String page_raw = "";
        System.out.println("action là : "+action+"  ");
        try {
            page_raw = request.getParameter("page");
        } catch (Exception e) {
        }
        try {
            page = Integer.parseInt(page_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("page", page);
        } catch (Exception e) {
        }
      
        
        String idclubmodern = request.getParameter("idclub");
        String status = request.getParameter("time");
        String idevent = request.getParameter("idevent");

        try {
            if (idclubmodern == null || idclubmodern.isEmpty()) {
                idclubmodern = "1";
            } else {
                if (idevent == null || idevent.isEmpty()) {
                    // Nếu idevent chưa được chọn, đặt nó thành sự kiện đầu tiên của CLB hiện tại
                    List<Integer> listevent = d.getIDEvent(idclubmodern, status);
                    if (!listevent.isEmpty()) {
                        idevent = listevent.get(0).toString();
                    }
                } else {
                    // Nếu idevent đã được chọn, giữ lại nó
                    List<Integer> listevent = d.getIDEvent(idclubmodern, status);
                    if (!listevent.contains(Integer.parseInt(idevent))) {
                        idevent = listevent.get(0).toString();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (status == null || status.isEmpty()) {
                status = "past";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("status", status);
        request.setAttribute("idclub", idclubmodern);
        request.setAttribute("idevent", idevent);
        request.setAttribute("idclubmodern", idclubmodern);

        List<Integer> listevent = d.getIDEvent(idclubmodern, status);
        try {
            if (idevent == null || idevent.isEmpty()) {
                if (!listevent.isEmpty()) {
                    idevent = listevent.get(0).toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int pagemax=d.numberpages(status, idevent);
        request.setAttribute("pagemax", pagemax);
        List<EventRegistration> listmember = d.getmemberclub(page, status, idevent);
        request.setAttribute("listmember", listmember);
        request.setAttribute("listevent", listevent);
        request.getRequestDispatcher("View/ViewManager/ListMember.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
