<%-- 
    Document   : In4_Event
    Created on : May 20, 2024, 4:31:54 PM
    Author     : 10t1q
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.*" %>
<%@ page import="DAO.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Blog Details</title>
        <style>
            img {
                width: 150px;
            }
        </style>
    </head>
    <body>
        <%
            Accounts acc = (Accounts) session.getAttribute("curruser");
            Blog post = (Blog) request.getAttribute("x");
            if (post != null) {
        %>
                <% if (acc != null && acc.getRole() == 1) { %>
                    <a href="<%= request.getContextPath() %>/BlogUpdateServlet?idBlog=<%= post.getIdBlog() %>">Edit</a>
                    <a href="<%= request.getContextPath() %>/BlogDeleteServlet?idBlog=<%= post.getIdBlog() %>">Delete</a>
                <% } %>
                <h1><%= post.getTitleBlog() %></h1>
                <img src="<%= request.getContextPath() %>/<%= post.getImage() %>" alt="Uploaded Image"><br>
                <p><%= post.getContent() %></p>
        <%
            } else {
        %>
                <p>Event không hợp lệ.</p>
        <%
            }
        %>
    </body>
</html>
