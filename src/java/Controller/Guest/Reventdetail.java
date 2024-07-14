/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Guest;

import DAO.EventRegistrationDao;
import Model.EventRegistration;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.Session;

/**
 *
 * @author 84358
 */
@WebServlet(name="Reventdetail", urlPatterns={"/Reventdetail"})
public class Reventdetail extends HttpServlet {
   
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
            out.println("<title>Servlet Reventdetail</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Reventdetail at " + request.getContextPath () + "</h1>");
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
        EventRegistrationDao d=new EventRegistrationDao();
        String idregiste=request.getParameter("idregister");
        String nameEvent=request.getParameter("nameevent");
        request.setAttribute("nameevent", nameEvent);
        int x=Integer.parseInt(idregiste);
        EventRegistration my=d.getEventRegistration(x);
        request.setAttribute("my", my);
        request.setAttribute("email", my.getGmail());
        request.setAttribute("phone", my.getPhone());
        request.setAttribute("name", my.getName());
        request.setAttribute("ideventregister", my.getEventregisterid());
        request.getRequestDispatcher("View/ViewStudent/Reventdetail.jsp").forward(request, response);
        
        
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
                HttpSession session=request.getSession();

        EventRegistrationDao d=new EventRegistrationDao();
        String nameevent=request.getParameter("nameevent");
        String gmail=request.getParameter("email");
        String phone_raw= request.getParameter("phone");
        String name_raw=request.getParameter("name");
        String ideventregister=request.getParameter("ideventregister");
        request.setAttribute("nameevent", nameevent);
        request.setAttribute("email", gmail);
        request.setAttribute("phone", phone_raw);
        request.setAttribute("name", name_raw);
        request.setAttribute("ideventregister", ideventregister);
        int check=0;
        
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
        if(name_raw.isEmpty()||phone_raw.isEmpty()){
            check++;
            request.setAttribute("error", "Please input full information");
        }
        if(check!=0){
        request.setAttribute("huy", 1);
        request.getRequestDispatcher("View/ViewStudent/Reventdetail.jsp").forward(request, response);
        }else{
            d.UpdateNameandPhone(ideventregister, phone_raw, name_raw);
            session.setAttribute("huycheck", true);
            response.sendRedirect("MyRegistration");
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
