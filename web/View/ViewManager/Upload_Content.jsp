<%-- 
    Document   : In4_Event
    Created on : May 20, 2024, 4:31:54 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*" %>
<%@page import="DAO.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Blog Details</title>
    <style>
        img{
            width: 150px;
        }
    </style>
</head>
<body>
    <%
        Blog post = (Blog) request.getAttribute("x");
        if (post != null) {
    %>
    <h1><%= post.getTitleBlog()%></h1>
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
