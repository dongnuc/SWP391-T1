/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Guest;

import Model.Accounts;
import Model.GoogleAccount;
import DAO.AccountDao;
import DAO.StudentClubDao;
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
        StudentClubDao scb=new StudentClubDao();
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
//        if(!account.endsWith("@fpt.edu.vn")){
//            request.setAttribute("error", "Account not permit login with web");
//            request.getRequestDispatcher("login.jsp").forward(request, response);
//        }
        session.setAttribute("account", account);
        AccountDao db=new AccountDao();
        List<Accounts> listaccount=db.getAll();
        
        int check=0;
        for(Accounts ac: listaccount){
            if(account.equals(ac.getAccount())){
                check++;
            }
        }
        int id=0;
        if(check==0){
            id=db.getidaccount()+1;
            db.insertAccountGoogle(id, account, 1);
            String password=db.getoldpassword(account);
            session.setAttribute("id", id);
            session.setAttribute("password", password);
        }
        if(check!=0){
            String password=db.getoldpassword(account);
            id =db.getidofaccount(account);
            session.setAttribute("password", password);
            session.setAttribute("id", id);
        }
        List<String> listclub=scb.getclubbtid(id);
        session.setAttribute("myclub", listclub);
        session.setAttribute("account", account);      
        request.getRequestDispatcher("Home.jsp").forward(request, response);
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
         AccountDao acc = new AccountDao();
    StudentClubDao st = new StudentClubDao();
    AccountDao db = new AccountDao();
    HttpSession session = request.getSession();
    List<Accounts> list = acc.getAll();
    Cookie[] cookies = request.getCookies();
    String email = request.getParameter("email");
    String passwords = request.getParameter("password");
    String mahoa = password.getMd5(passwords);
    String remember = "";

    try {
        remember = request.getParameter("remember");
        if ("1".equalsIgnoreCase(remember)) {
            Cookie accountx = new Cookie("account", email);
            Cookie Passwordx = new Cookie("password", passwords);
            accountx.setMaxAge(1000);
            Passwordx.setMaxAge(1000);
            response.addCookie(accountx);
            response.addCookie(Passwordx);
        }
    } catch (Exception e) {
        // Log exception (optional)
    }

    boolean loginSuccessful = false;
    for (Accounts ac : list) {
        if (email.equals(ac.getAccount()) && mahoa.equals(ac.getPassword())) {
            session.setAttribute("account", email);
            session.setAttribute("id", ac.getId());
            List<String> listclub = st.getclubbtid(ac.getId());
            session.setAttribute("myclub", listclub);
            session.setAttribute("password", mahoa);
            loginSuccessful = true;
            break;
        }
    }

    if (loginSuccessful) {
        response.sendRedirect("Home.jsp");
    } else {
        session.setAttribute("error", "Account or Password not Correct");
        request.getRequestDispatcher("View/ViewStudent/login.jsp").forward(request, response);
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
