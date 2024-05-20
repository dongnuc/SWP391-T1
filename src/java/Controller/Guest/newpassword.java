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

/**
 *
 * @author 84358
 */
@WebServlet(name="newpassword", urlPatterns={"/newpassword"})
public class newpassword extends HttpServlet {
   
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
            out.println("<title>Servlet newpassword</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet newpassword at " + request.getContextPath () + "</h1>");
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
        PrintWriter out = response.getWriter();
        String passwords=request.getParameter("newpassword");
        String confirm=request.getParameter("confirm");
        if(!passwords.equals(confirm)){
            request.setAttribute("error", "Password and Confirm should same");
            request.getRequestDispatcher("View/ViewStudent/newpassword.jsp").forward(request, response);
        }
        if(passwords.length()<6){
            request.setAttribute("error", "Password more than 6 characters");
            request.getRequestDispatcher("View/ViewStudent/newpassword.jsp").forward(request, response);
        }
        String mahoa=password.getMd5(confirm);
        HttpSession session=request.getSession();
        String email=(String) session.getAttribute("account");
        AccountDao db=new AccountDao();
        db.Resetpassword(mahoa, email);
        
        request.getRequestDispatcher("View/ViewStudent/login.jsp").forward(request, response);
        
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
        AccountDao db=new AccountDao();
        HttpSession session=request.getSession();
        String old_raw=request.getParameter("oldpassword").trim();
        String mahoa1=password.getMd5(old_raw);
        String new_raw=request.getParameter("newpassword").trim();
        String mahoa2=password.getMd5(new_raw);
        String confirm=request.getParameter("confirm").trim();
        String account=(String) session.getAttribute("account");
        String x=db.getoldpassword(account);
        if(!mahoa1.equalsIgnoreCase(x)){
            request.setAttribute("error", "Mật khẩu cũ không chính xác");
            request.getRequestDispatcher("View/ViewStudent/changepassword.jsp").forward(request, response);
        }
        if(!new_raw.equalsIgnoreCase(confirm)){
            request.setAttribute("error", "Mật khẩu mới không khớp");
            request.getRequestDispatcher("View/ViewStudent/changepassword.jsp").forward(request, response);
        }
        if(new_raw.length()<6){
            request.setAttribute("error", "Mật Khẩu mới phải lớn hơn 6 kí tự");
            request.getRequestDispatcher("View/ViewStudent/changepassword.jsp").forward(request, response);
        }
        db.Resetpassword(mahoa2, account);
        response.sendRedirect("View/ViewStudent/login.jsp");
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
