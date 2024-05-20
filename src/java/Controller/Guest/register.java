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
import java.util.List;

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
        String account=request.getParameter("taikhoan").trim();
        String passwords=request.getParameter("matkhau").trim();
        String confirm=request.getParameter("confirm").trim();
        String error="";
        int check=0;
        if(!account.endsWith("@fpt.edu.vn")){
            request.setAttribute("error", "Please endwith @fpt.edu.vn");
            check++;
            request.getRequestDispatcher("View/ViewStudent/register.jsp").forward(request, response);
        }
        AccountDao db=new AccountDao();
        if(account.length()<6||passwords.length()<6){
            error="Tài khoản và mật khẩu phải có ít nhất 3 kí tự";
            request.setAttribute("error", error);
            check++;
            request.getRequestDispatcher("View/ViewStudent/register.jsp").forward(request, response);
            
        }
        List<Accounts> list=db.getAll();
        for(Accounts k:list){
            if(account.equalsIgnoreCase(k.getAccount())){
            error="Tài khoản đã tồn tại";
            request.setAttribute("error", error);
            check++;
            request.getRequestDispatcher("View/ViewStudent/register.jsp").forward(request, response);
            }
        }
        if(!passwords.equalsIgnoreCase(confirm)){
            error="Mật khẩu mới không khớp";
            request.setAttribute("error", error);
            check++;
            request.getRequestDispatcher("View/ViewStudent/register.jsp").forward(request, response);
        }
        if(check==0){
        int k=db.getidaccount()+1;
        String mahoa =password.getMd5(passwords);
        db.insertAccount(k, account, mahoa, 1);
        request.getRequestDispatcher("Home.jsp").forward(request, response);
        }
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
