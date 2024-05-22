<%-- 
    Document   : In4_Event
    Created on : May 20, 2024, 4:31:54 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.*" %>
<%@page import = "DAO.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Post Details</title>
        <style>
        img{
            width: 150px;
        }
        </style>
    </head>
    <body>
        <h1>Post Details</h1>
        <%
            Blog post = (Blog) request.getAttribute("x");
            if (post != null) {
        %>
        <img src="<%= request.getContextPath() %>/<%= post.getImage() %>" alt="Uploaded Image"><br>
        <p> <%= post.getDescription() %></p>
        <%
            } else {
        %>
        <p>Event not invalid.</p>
        <%
            }
        %>
    </body>
</html>
