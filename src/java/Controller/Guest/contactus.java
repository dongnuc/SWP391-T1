/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controller.Guest;

import DAO.ClubDao;
import DAO.FormDao;
import Model.Accounts;
import Model.Clubs;
import Services.Validation;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author 84358
 */
@WebServlet(name="contactus", urlPatterns={"/contactus"})
public class Contactus extends HttpServlet {
   
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
            out.println("<title>Servlet contactus</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet contactus at " + request.getContextPath () + "</h1>");
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
         FormDao dao = new FormDao();
        HashMap<String, String> typeForm = dao.typeForm();
        request.setAttribute("listType", typeForm);
        request.getRequestDispatcher("View/ViewStudent/ContactUs.jsp").forward(request, response);       
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
         FormDao dao = new FormDao();
        HttpSession session = request.getSession();
        HashMap<String, String> listtypeForm = dao.typeForm();
        request.setAttribute("listType", listtypeForm);
        Validation validationInput = new Validation();
        String fullName = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String typeForm = request.getParameter("typeForm");
        String tittle = request.getParameter("tittle");
        String content = request.getParameter("content");
        Accounts acc = (Accounts) session.getAttribute("acc");
        int countError = 0;
        String checkFullName = validationInput.checkLength(fullName, 32);
        String checkEmail = validationInput.checkGmail2(email);

        if (!checkFullName.equals(fullName)) {

            request.setAttribute("errorName", checkFullName);
            countError++;
        }
        if (!checkEmail.equals(email)) {

            request.setAttribute("errorEmail", checkEmail);
            countError++;
        }
        if (!phone.isEmpty()) {
            String checkPhone = validationInput.checkPhoneNumber(phone);
            if (!checkPhone.equals(phone)) {

                request.setAttribute("errorPhone", checkPhone);
                countError++;
            }
        }
        String checkTittle = validationInput.checkLength(tittle, 32);
        if (!checkTittle.equals(tittle)) {
            request.setAttribute("errorTittle", checkTittle);

            countError++;
        }
        String checkContent = validationInput.checkLength(content, 1000);
        if (!checkContent.equals(content)) {
            request.setAttribute("errorContent", checkContent);

            countError++;
        }

        if (countError > 0) {
            request.setAttribute("fullname", fullName);
            request.setAttribute("email", email);
            request.setAttribute("phone", phone);
            request.setAttribute("tittle", tittle);
            request.setAttribute("content", content);
            request.getRequestDispatcher("View/ViewStudent/ContactUs.jsp").forward(request, response);
        } else {
            dao.insertForm(fullName, tittle, content, email, phone);
            String idStudent = null;
            if (acc != null) {
                try {
                    idStudent = String.valueOf(acc.getId());
                } catch (Exception e) {
                }
            }
            String nameForm = listtypeForm.get(typeForm);
            dao.insertSettingForm(nameForm, idStudent);
            response.sendRedirect("Home.jsp");
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
