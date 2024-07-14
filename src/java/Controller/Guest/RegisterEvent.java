/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Guest;

import DAO.AccountDao;
import DAO.EventRegistrationDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 84358
 */
@WebServlet(name="RegisterEvent", urlPatterns={"/RegisterEvent"})
public class RegisterEvent extends HttpServlet {
   
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
            out.println("<title>Servlet RegisterEvent</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterEvent at " + request.getContextPath () + "</h1>");
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
        HttpSession session=request.getSession();
        String nameevent=request.getParameter("name");
        String idEvent=request.getParameter("idEvent");
        session.setAttribute("idEvents", idEvent);
        request.setAttribute("nameevent", nameevent);
        request.getRequestDispatcher("View/ViewStudent/RegisterEvent.jsp").forward(request, response);
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
        String name_raw="";
        String phone_raw="";
        String email_raw="";
        HttpSession session=request.getSession();
        AccountDao acc=new AccountDao();
        EventRegistrationDao ev=new EventRegistrationDao();
        try {
            name_raw=request.getParameter("name");
        } catch (Exception e) {
        }
        try {
            phone_raw=request.getParameter("phone");
        } catch (Exception e) {
        }  
        try {
            email_raw=request.getParameter("email");
        } catch (Exception e) {
        }
        String NameEvent=request.getParameter("nameevent");
        String idevent=(String) session.getAttribute("idEvents");
        request.setAttribute("nameevent", NameEvent);
        
        request.setAttribute("name", name_raw);
        request.setAttribute("phone", phone_raw);
        request.setAttribute("email", email_raw);
            
        int check=0;
        if(name_raw.length()>35){
            request.setAttribute("errorname", "Name must not exceed 35 characters");
            check++;
        }
        String regax="[^@]{2,64}@[^.]{2,253}\\.[0-9a-z-.]{2,63}";
        if(!email_raw.matches(regax)){
            request.setAttribute("erroremail", "Please input Email Valid");
            check=1;
        }
        if(ev.CheckregisterEvent(idevent, email_raw)){
            request.setAttribute("erroremail", "This Email had Register Event");

            check++;
        }
        if(name_raw.isEmpty()){
            request.setAttribute("errorname", "Name cannot Empty");
            check++;
        }
        if(phone_raw.length() != 10 || !phone_raw.matches("\\d{10}")){
            check++;
            request.setAttribute("errorphone", "Please input Phone 10 digits");
        }
        String regex = "^[a-zA-Z ]+$";
        if(!name_raw.matches(regex)){
           request.setAttribute("errorname", "Name cannot special Character and Digit");
           check++; 
        } 
        if(name_raw.isEmpty()||phone_raw.isEmpty()||email_raw.isEmpty()){
            check++;
            request.setAttribute("error", "Please input full information");
        }
        if(check!=0){
        request.setAttribute("huy", 1);
        request.getRequestDispatcher("View/ViewStudent/RegisterEvent.jsp").forward(request, response);
        }
        if(check==0){
            request.setAttribute("showtoast", "true");
            ev.insertMemberEvent(phone_raw, idevent, name_raw, email_raw,0);
            request.getRequestDispatcher("EventSerlet").forward(request, response);
        }
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
