/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Guest;

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

/**
 *
 * @author 84358
 */
@WebServlet(name="checkotp1", urlPatterns={"/checkotp1"})
public class checkotp1 extends HttpServlet {
   
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
            out.println("<title>Servlet checkotp1</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet checkotp1 at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        AccountDao ac=new AccountDao();
        HttpSession session=request.getSession();
        int otp_first=(int) session.getAttribute("otp");
        String otp1_raw=request.getParameter("otp1");
        String otp2_raw=request.getParameter("otp2");
        String otp3_raw=request.getParameter("otp3");
        String otp4_raw=request.getParameter("otp4");
        try {
            request.setAttribute("otp1", otp1_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("otp2", otp2_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("otp3", otp3_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("otp4", otp4_raw);
        } catch (Exception e) {
        }
        
        if(otp1_raw.isEmpty()||otp2_raw.isEmpty()||otp3_raw.isEmpty()||otp4_raw.isEmpty()){       
            request.setAttribute("error", "Please Input Full OTP");
            request.getRequestDispatcher("View/ViewStudent/checkotp_1.jsp").forward(request, response);
        }
        String otpinput_raw=otp1_raw+otp2_raw+otp3_raw+otp4_raw;
        int otpinput=Integer.parseInt(otpinput_raw);
        if(otp_first==otpinput){
            String accounts=(String) session.getAttribute("accounts");
            String passwords=(String) session.getAttribute("password");
            String passwordmahoa=password.getMd5(passwords);
            String name=(String) session.getAttribute("name");
            Date date=new Date();
            ac.insertAccount(accounts, passwordmahoa, date,name);
            request.getRequestDispatcher("View/ViewStudent/login.jsp").forward(request, response);
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
