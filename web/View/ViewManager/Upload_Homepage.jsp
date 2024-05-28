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
    <title>Blog Homepage</title>
    <style>
        img {
            width: 150px;
        }
    </style>
</head>
<body>
    <%
        Accounts acc = (Accounts) session.getAttribute("curruser");
        StudentClubDAO studentClubDAO = new StudentClubDAO();
        List<StudentClub> studentClubList = null;
        int userClubId = 0; 
        if (acc != null) {
            studentClubList = studentClubDAO.getStudentClubs(acc.getId());
            if (studentClubList != null && !studentClubList.isEmpty()) {
                userClubId = studentClubList.get(0).getIdClub();
            }
        }
        if (acc != null && acc.getRole() == 1) {
    %>
    <form action="<%= request.getContextPath() %>/UploadServlet" method="post" enctype="multipart/form-data">
        Tittle : <input type="text" name="tittle" value="" required><br>
        Image: <input type="file" name="file" accept="image/*" required><br>
        Description : <input type="text" name="description" value="" required><br>
        Show:
        <input type="radio" id="public" name="visibility" value="1" required>
        <label for="public">Public</label>
        <input type="radio" id="private" name="visibility" value="0">
        <label for="private">Private</label><br>
        <input type="hidden" name="status" value="1">
        <input type="hidden" name="idclub" value="<%= userClubId %>" required>
        <input type="submit" value="Tải lên">
    </form>
    <% } %>
    <h2>Uploaded Image:</h2>
    <%
        for (Blog x : postList) {
            boolean canView = false;
            if (x.getShow() == 1) {
                canView = true; 
            } else if (acc != null) {
                for (StudentClub y : studentClubList) {
                    if (y.getIdClub() == x.getIdClub()) {
                        canView = true; 
                        break;
                    }
                }
            }
            if (canView) {
    %>
    <a href="<%= request.getContextPath() %>/UploadContentBlog?idBlog=<%= x.getIdBlog() %>">
        <img src="<%= request.getContextPath() %>/<%= x.getImage() %>" alt="Uploaded Image"><br>
    </a>
    <%
            }
        }
    %>
</body>
</html>
