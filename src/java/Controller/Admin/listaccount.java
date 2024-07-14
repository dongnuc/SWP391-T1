/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.Admin;

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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 84358
 */
@WebServlet(name = "listaccount", urlPatterns = {"/listaccount"})
public class listaccount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
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
            out.println("<title>Servlet listaccount</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet listaccount at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDao acc = new AccountDao();
        int page = 1;
        String search_raw = "";
        String page_raw = "";
        String status_raw = "all";
        String email="";
        String statuss="";
        String sort_raw="IdStudent";
        try {
            status_raw = request.getParameter("status");
            if (status_raw == null) {
                status_raw = "all"; 
            }
            request.setAttribute("status", status_raw);
        } catch (Exception e) {
        }
        try {
            sort_raw = request.getParameter("sort");
            if (sort_raw == null) {
                sort_raw = "IdStudent"; 
            }
            request.setAttribute("sort", sort_raw);
        } catch (Exception e) {
        }
        try {
            email=request.getParameter("email");
            statuss=request.getParameter("statuss");
            acc.UpdateStatus(email, statuss);
        } catch (Exception e) {
        }
        try {
            search_raw = request.getParameter("search");

        } catch (Exception e) {
        }
        System.out.println(status_raw);
        int numberpage = acc.numberpage(search_raw, status_raw);
        try {
            page_raw = request.getParameter("page");
        } catch (Exception e) {
        }
        try {
            request.setAttribute("search", search_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("pagemax", numberpage);
        } catch (Exception e) {
        }
        try {
            page = Integer.parseInt(page_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("page", page);
        } catch (Exception e) {
        }
        System.out.println("Page :" + page + " PageMax : " + numberpage + " Search " + search_raw);

        List<Accounts> listaccount = acc.getbypage(page, search_raw, status_raw,sort_raw);
        HttpSession session = request.getSession();
        
        session.setAttribute("listaccount", listaccount);
        request.getRequestDispatcher("View/ViewAdmin/listaccount.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountDao acc = new AccountDao();
        int page = 1;
        String search_raw = "";
        String page_raw = "";
        String status_raw = "all";
        String email="";
        String statuss="";
        String sort_raw="IdStudent";
        try {
            status_raw = request.getParameter("status");
            if (status_raw == null) {
                status_raw = "all"; 
            }
            request.setAttribute("status", status_raw);
        } catch (Exception e) {
        }
        try {
            sort_raw = request.getParameter("sort");
            if (sort_raw == null) {
                sort_raw = "IdStudent"; 
            }
            request.setAttribute("sort", sort_raw);
        } catch (Exception e) {
        }
        try {
            email=request.getParameter("email");
            statuss=request.getParameter("statuss");
            acc.UpdateStatus(email, statuss);
        } catch (Exception e) {
        }
        try {
            search_raw = request.getParameter("search");

        } catch (Exception e) {
        }
        System.out.println(status_raw);
        int numberpage = acc.numberpage(search_raw, status_raw);
        try {
            page_raw = request.getParameter("page");
        } catch (Exception e) {
        }
        try {
            request.setAttribute("search", search_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("pagemax", numberpage);
        } catch (Exception e) {
        }
        try {
            page = Integer.parseInt(page_raw);
        } catch (Exception e) {
        }
        try {
            request.setAttribute("page", page);
        } catch (Exception e) {
        }
        System.out.println("Page :" + page + " PageMax : " + numberpage + " Search " + search_raw);

        List<Accounts> listaccount = acc.getbypage(page, search_raw, status_raw,sort_raw);
        HttpSession session = request.getSession();
        try {
            String showtoast=(String) request.getAttribute("showtoast");
            if(showtoast.equals("true")){
            request.setAttribute("showtoast", "true");
        }
        } catch (Exception e) {
        }
        session.setAttribute("listaccount", listaccount);
        request.getRequestDispatcher("View/ViewAdmin/listaccount.jsp").forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
