/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import Entity.Accounts;
import Entity.GoogleAccount;
import dal.AccountDao;
import dal.StudentClubDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author 84358
 */
@WebServlet(name="login", urlPatterns={"/login"})
public class login extends HttpServlet {
   
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
        HttpSession session=request.getSession();
        Cookie[] cookies = request.getCookies();
        String code=request.getParameter("code");
        PrintWriter out = response.getWriter();
        googlelogin gg=new googlelogin();
        String accesstoken= gg.getToken(code);
        System.out.println(accesstoken);
        GoogleAccount acc= gg.getUserInfo(accesstoken);
        String account=acc.getEmail();
        System.out.println(acc.toString());
        if(!account.endsWith("@fpt.edu.vn")){
            request.setAttribute("error", "Account not permit login with web");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        session.setAttribute("account", account);
        AccountDao db=new AccountDao();
        List<Accounts> listaccount=db.getAll();
        for(Accounts ac:listaccount){
            if(ac.getAccount().equals(account)){
                session.setAttribute("account", account);
                session.setAttribute("id", ac.getId());
                request.getRequestDispatcher("home.jsp").forward(request, response);
        }
        }
        request.getRequestDispatcher("password.jsp").forward(request, response);
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
        AccountDao acc=new AccountDao();
        StudentClubDao st=new StudentClubDao();
        HttpSession session=request.getSession();
        List<Accounts> list=acc.getAll();
        Cookie[] cookies = request.getCookies();
        String email=request.getParameter("email");
        String passwords=request.getParameter("password");
        String mahoa=password.getMd5(passwords);
        String remember="";
        
        try {
            remember=request.getParameter("remember");
            if(remember.equalsIgnoreCase("1")){
            Cookie accountx = new Cookie("account", email);
            Cookie Passwordx = new Cookie("password", passwords);
            accountx.setMaxAge(1000);
            Passwordx.setMaxAge(1000);
            response.addCookie(accountx);
            response.addCookie(Passwordx);
        }
        } catch (Exception e) {
        }
        for (Accounts ac : list) {
        if (email.equals(ac.getAccount()) && mahoa.equals(ac.getPassword())) 
        {
        session.setAttribute("account", email);
        session.setAttribute("id", ac.getId());
        List<String> listclub=st.getclubbtid(ac.getId());
        session.setAttribute("myclub", listclub);
        request.getRequestDispatcher("home.jsp").forward(request, response);
                   }
        }
        request.setAttribute("error", "Account or Password not Correct");
        request.getRequestDispatcher("login.jsp").forward(request, response);
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
