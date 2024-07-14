/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Guest;

import DAO.AccountDao;
import DAO.EventRegistrationDao;
import Model.Accounts;
import Model.EventRegistration;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import jdk.jshell.EvalException;

/**
 *
 * @author 84358
 */
@WebServlet(name="MyRegistration", urlPatterns={"/MyRegistration"})
public class MyRegistration extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            out.println("<title>Servlet MyRegistration</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MyRegistration at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        boolean huycheck=false;
        HttpSession session=request.getSession();
        try {
            huycheck=(boolean) session.getAttribute("huycheck");
        } catch (Exception e) {
        }
        if(huycheck==true){
        request.setAttribute("showtoast", "true");
        session.setAttribute("huycheck", false);
        }
        EventRegistrationDao db=new EventRegistrationDao();
        String search_raw=null;
        String sort_raw="present"; 
        int page=1;
        try {
            page=Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
        }
        try {
            sort_raw = request.getParameter("sort");
            if (sort_raw == null) {
                sort_raw = "present"; 
            }
            
        } catch (Exception e) {
        }
        try {
            search_raw=request.getParameter("search");
        } catch (Exception e) {
        }
        request.setAttribute("sort", sort_raw);
        request.setAttribute("search", search_raw);
        
        
        Accounts account=(Accounts) session.getAttribute("accountprofile");
        String gmail=account.getEmail();
        request.setAttribute("page", page);
        int pagemax=db.numberpage(gmail,sort_raw,search_raw);
        request.setAttribute("pagemax", pagemax);
        List<EventRegistration> list=db.getbypage(page,sort_raw,gmail,search_raw);
        
        request.setAttribute("listevent", list);
        request.getRequestDispatcher("View/ViewStudent/MyRegistration.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
