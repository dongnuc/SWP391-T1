/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Admin;

import Controller.Guest.password;
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
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author 84358
 */
@WebServlet(name="adduser", urlPatterns={"/adduser"})
public class adduser extends HttpServlet {
   
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
            out.println("<title>Servlet adduser</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adduser at " + request.getContextPath () + "</h1>");
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
        request.getRequestDispatcher("View/ViewAdmin/adduser.jsp").forward(request, response);
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
        String name_raw=request.getParameter("name");
        String email_raw=request.getParameter("email");
        String phone_raw=request.getParameter("phone");
        String status_raw=request.getParameter("status");
        String role_raw=request.getParameter("role");
        String gender_raw=request.getParameter("gender");
        int check=0;
        AccountDao acc=new AccountDao();
        String regax="[^@]{2,64}@[^.]{2,253}\\.[0-9a-z-.]{2,63}";
        if(!email_raw.matches(regax)){
            request.setAttribute("erroremail", "Please input Email Valid");
            check=1;
        }
        List<Accounts> list=acc.getAll();
        for(Accounts a:list){
            if(a.getEmail().equals(email_raw)){
            check=2;
            request.setAttribute("erroremail", "Email is exsit");
            }
        }
        if(phone_raw.length()!=10|| !phone_raw.matches("\\d{10}")){
            request.setAttribute("errorphone", "Phone must 10 digits");
            check=3;
        }
        if(name_raw.length()>35){
            request.setAttribute("errorname", "Name must not exceed 35 characters");
            check=4;
        }
        String regex = "^[a-zA-Z\\p{L}\\s]+$";
        if(!name_raw.matches(regex)){
           request.setAttribute("errorname", "Name cannot special Character ");
           check=5; 
        }
        try {
            request.setAttribute("name", name_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("email", email_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("phone", phone_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("status", status_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("role", role_raw);
        } catch (Exception e) {
        }
        
        
        if(name_raw.isEmpty()||email_raw.isEmpty()||phone_raw.isEmpty()){
            check=6;
            request.setAttribute("error", "Please input full Information");
        }
        request.setAttribute("check", check);
        if(check!=0){
        request.getRequestDispatcher("View/ViewAdmin/adduser.jsp").forward(request, response);
        }
        if(check==0){
        final String from="huytestnguyen@gmail.com";
        final String passwords="rcjmvvsweiaeuwdt";
        Random random = new Random();
        int min = 100000;
        int max = 999999;
        int randomNumber = random.nextInt((max - min) + 1) + min;
        Properties prop=new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        javax.mail.Authenticator authenticator;
        authenticator = new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return  new PasswordAuthentication(from,passwords);
            }
        };
         Session session1 =Session.getInstance(prop, authenticator);
         MimeMessage msg=new MimeMessage(session1);
         try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email_raw,false));
            msg.setSubject("Pass Word");
            msg.setSentDate(new Date());
            msg.setText(""+randomNumber);
            javax.mail.Transport.send(msg);
        } catch (Exception e) {
            
        } 
         
        String passworde=String.valueOf(randomNumber);       
        String passwordmahoa=password.getMd5(passworde);
        request.setAttribute("name", "");
        request.setAttribute("email", "");
        request.setAttribute("phone", "");
        acc.insertAccountadmin(email_raw, passwordmahoa, name_raw, gender_raw, status_raw, role_raw, phone_raw);
        request.setAttribute("showtoast", "true");
        request.getRequestDispatcher("listaccount").forward(request, response);
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
