/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Guest;

import DAO.AccountDao;
import Model.Accounts;
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
@WebServlet(name="profile", urlPatterns={"/profile"})
public class profile extends HttpServlet {
   
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
            out.println("<title>Servlet profile</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profile at " + request.getContextPath () + "</h1>");
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
        
        AccountDao accountdao=new AccountDao();
        HttpSession session=request.getSession();
        String email=(String) session.getAttribute("account");
        Accounts accountprofile=accountdao.getAccount(email);
        session.setAttribute("accountprofile", accountprofile);
        request.getRequestDispatcher("View/ViewStudent/profile.jsp").forward(request, response);
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
        String dob_raw="";
        String gender_raw="";
        String email_raw=request.getParameter("email");
        HttpSession session=request.getSession();
        AccountDao acc=new AccountDao();
        try {
            name_raw=request.getParameter("name");
        } catch (Exception e) {
        }
        try {
            phone_raw=request.getParameter("phone");
        } catch (Exception e) {
        }  
        try {
            dob_raw=request.getParameter("dob");
        } catch (Exception e) {
        }
        try {
            gender_raw=request.getParameter("gender");
        } catch (Exception e) {
        }
        request.setAttribute("name", name_raw);
        request.setAttribute("phone", phone_raw);
        request.setAttribute("dob", dob_raw);
            
        int check=0;
        if(name_raw.length()>35){
            request.setAttribute("errorname", "Name must not exceed 35 characters");
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
        String regex = "^[a-zA-Z\\p{L}\\s]+$";
        if(!name_raw.matches(regex)){
           request.setAttribute("errorname", "Name cannot special Character and Digit");
           check++; 
        }
        int gender=Integer.parseInt(gender_raw);
        SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
        Date date1=new Date();
        Date date2 = null;
        try {
             date2=simple.parse(dob_raw);
        } catch (ParseException ex) {
            Logger.getLogger(profile.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            if(date1.compareTo(date2)<0){
            check++;
            request.setAttribute("errordob", "DOB must before Today");
        }
        } catch (Exception e) {
        }
        if(dob_raw.isEmpty()){
            request.setAttribute("errordob", "DOB can not empty");
        }
        
        if(name_raw.isEmpty()||phone_raw.isEmpty()||dob_raw.isEmpty()){
            check++;
            request.setAttribute("error", "Please input full information");
        }
        if(check!=0){
        request.setAttribute("huy", 1);
        session.setAttribute("success", "");
        request.getRequestDispatcher("View/ViewStudent/profile.jsp").forward(request, response);
        }
        if(check==0){
            acc.UpdateAccount(email_raw, name_raw, phone_raw, gender, dob_raw);
            session.setAttribute("success", "Change Succcess");
            response.sendRedirect("profile");
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
