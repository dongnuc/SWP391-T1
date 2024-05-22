/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Guest;

import Model.Accounts;
import DAO.AccountDao;
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
@WebServlet(name="register", urlPatterns={"/register"})
public class register extends HttpServlet {
   
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
            out.println("<title>Servlet register</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath () + "</h1>");
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
        HttpSession session = request.getSession();
        String lastname=request.getParameter("lastname");
        String firstname=request.getParameter("firstname");
        String name=firstname+" "+lastname;
        String account=request.getParameter("email").trim();
        String passwords=request.getParameter("password").trim();
        session.setAttribute("account", account);
        session.setAttribute("password", passwords);
        session.setAttribute("name", name);
        String error="";
        int check=0;
        if(!account.endsWith("@fpt.edu.vn")){
            request.setAttribute("error", "Please endwith @fpt.edu.vn");
            check++;
            request.getRequestDispatcher("View/ViewStudent/register.jsp").forward(request, response);
        }
        AccountDao db=new AccountDao();
        if(account.length()<6||passwords.length()<6){
            error="Tài khoản và mật khẩu phải có ít nhất 6 kí tự";
            request.setAttribute("error", error);
            check++;
            request.getRequestDispatcher("View/ViewStudent/register.jsp").forward(request, response);
            
        }
        List<Accounts> list=db.getAll();
        for(Accounts k:list){
            if(account.equalsIgnoreCase(k.getEmail())){
            error="Tài khoản đã tồn tại";
            request.setAttribute("error", error);
            check++;
            request.getRequestDispatcher("View/ViewStudent/register.jsp").forward(request, response);
            }
        }
        if(check==0){
        String email=request.getParameter("email");
        final String from="huytestnguyen@gmail.com";
        final String password="rcjmvvsweiaeuwdt";
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        session.setAttribute("otp", randomNumber);
        Properties prop=new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        javax.mail.Authenticator authenticator;
        authenticator = new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return  new PasswordAuthentication(from,password);
            }
        };
         Session session1 =Session.getInstance(prop, authenticator);
         MimeMessage msg=new MimeMessage(session1);
         try {
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(account,false));
            msg.setSubject("Test Email");
            msg.setSentDate(new Date());
            msg.setText(""+randomNumber);
            javax.mail.Transport.send(msg);
            session.setAttribute("account", email);
            request.getRequestDispatcher("View/ViewStudent/checkotp_1.jsp").forward(request, response);
            
        } catch (Exception e) {
            
        }    
            }
        }
        
        
        
    
////        if(check==0){
////        int k=db.getidaccount()+1;
////        String mahoa =password.getMd5(passwords);
////        db.insertAccount(k, account, mahoa, 1);
////        request.getRequestDispatcher("Home.jsp").forward(request, response);
////        }
//    } 

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
        AccountDao ac=new AccountDao();
        int otp1=(int) session.getAttribute("otp");
        String otp2_raw=request.getParameter("otp");
        int otp2=0;
        otp2=Integer.parseInt(otp2_raw);
        if(otp1==otp2){
            String account=(String) session.getAttribute("account");
            String passwords=(String) session.getAttribute("password");
            String passwordmahoa=password.getMd5(passwords);
            String name=(String) session.getAttribute("name");
            Date date=new Date();
            ac.insertAccount(account, passwordmahoa, date,name);
            request.getRequestDispatcher("Home.jsp").forward(request, response);
        }else{
            request.setAttribute("error", "OTP Wrong");
            request.getRequestDispatcher("View/ViewStudent/checkotp_1.jsp").forward(request, response);
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
