<%-- 
    Document   : Hompage
    Created on : May 13, 2024, 3:07:14 PM
    Author     : 10t1q
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@page import = "Model.*" %>
<%@page import = "DAO.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
    BlogDAO postDAO = new BlogDAO();
    List<Blog> postList = postDAO.getAllPosts();
%>
<html>
<head>
    <title>Tải lên hình ảnh</title>
    <style>
        img{
            width: 150px;
        }
    </style>
</head>
<body>
    
      <form action="<%= request.getContextPath() %>/UploadServlet" method="post" enctype="multipart/form-data">
        Tittle : <input type="text" name="tittle" value="" required><br>
        Img: <input type="file" name="file" accept="image/*" required><br>
        Description : <input type="text" name="description" value="" required><br>
        Show: 
        <input type="radio" id="public" name="visibility" value="public" required>
        <label for="public">Public</label>
        <input type="radio" id="private" name="visibility" value="private">
        <label for="private">Private</label><br>
        Status : <input type="text" name="status" value="" required=""><br>
        Id Club : <input type="text" name="idclub" value="" required=""><br>
        <input type="submit" value="Tải lên">
       
    </form>
    <h2>Uploaded Image:</h2>
    <%
              for(Blog x: postList) {
            %>
        
        <a href="<%= request.getContextPath() %>/UploadContent?idBlog=<%=x.getIdBlog() %>">
             <img src="<%= request.getContextPath() %>/<%= x.getImage() %>" alt="Uploaded Image"><br>
        </a>
        <% } %>
</body>
</html>


