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
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        img {
            display: block;
            margin: 0 auto;
            max-width: 100%;
            height: auto;
        }

        p {
            text-align: justify;
        }
    </style>
</head>
<body>
<div class="container">
    <%
        Blog post = (Blog) request.getAttribute("x");
        if (post != null) {
    %>
    <h1><%= post.getTitleBlog()%></h1>
    <img src="<%= request.getContextPath() %>/<%= post.getImage() %>" alt="Uploaded Image"><br>
    <p><%= post.getDescription() %></p>
    <%
        } else {
    %>
    <p>Event không hợp lệ.</p>
    <%
        }
    %>
</div>
</body>
</html>
