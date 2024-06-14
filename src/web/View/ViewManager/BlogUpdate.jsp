<%-- 
    Document   : Blog_Update
    Created on : Jun 9, 2024, 3:29:45 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Model.*" %>
<%@ page import="DAO.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script src="https://cdn.ckeditor.com/ckeditor5/41.4.2/classic/ckeditor.js"></script>
        <style>
            img {
                width: 150px;
            }
        </style>
    </head>
    <body>
        <%        Blog post = (Blog) request.getAttribute("x");
                  Accounts acc = (Accounts) session.getAttribute("curruser");
                  StudentClubDAO studentClubDAO = new StudentClubDAO();
                  List<StudentClub> StudentClubList = studentClubDAO.getStudentClubs(acc.getId());
        %>
        <form method="POST" action="BlogUpdateServlet">
            Tittle : <input type="text" name="tittle" value="<%= post.getTitleBlog()%>"><br>
            Image :
            <input type="file" id="file" name="file" accept="image/*" onchange="previewImage(event)"><br>
            <img id="imagePreview" class="preview" src="<%= request.getContextPath() %>/<%= post.getImage() %>" alt="Image Preview"><br>
            Description : <input type="text" name="description" value="<%= post.getDescription()%>"><br>
            Content:
            <div id="editor">
                <textarea name="content"><%= post.getContent()%></textarea>
            </div>
            Show:
            <input type="radio" id="public" name="visibility" value="1" <%= post.getShow() == 1 ? "checked" : "" %>>
            <label>Public</label>
            <input type="radio" id="private" name="visibility" value="0" <%= post.getShow() == 0 ? "checked" : "" %>>
            <label>Private</label><br>
            <input type="hidden" name="status" value="1">
            Blog's type : <%
                BlogTypeDAO blogTypeDAO = new BlogTypeDAO();
                List<BlogType> blogTypeList = blogTypeDAO.getAllPosts();
                for (BlogType blogType : blogTypeList) {
            %>
            <input type="radio" name="blogtype" value="<%= blogType.getIdBlogType() %>" <%= post.getIdBlogType() == blogType.getIdBlogType() ? "checked" : "" %>><%= blogType.getNameBlogType() %><br>
            <% } %>
            CLUB : <%
                ClubDao clubDAO = new ClubDao();
                for (StudentClub studentClub : StudentClubList) {
                    if (studentClub.getStatus() == 1 && studentClub.getRole() <= 2) {
            %>
            <input type="radio" name="idclub" value="<%= studentClub.getIdClub() %>" <%= post.getIdClub() == studentClub.getIdClub() ? "checked" : "" %>><%= clubDAO.getNameById(studentClub.getIdClub()) %><br>
            <%      }
                }
            %>
            Status : <input type="radio" name="status" value="1" <%= post.getStatus() == 1 ? "checked" : "" %> >Active <br> 
                     <input type="radio" name="status" value="0" <%= post.getStatus() == 0 ? "checked" : "" %> >Stop <br> 
            <input type="submit" value="Update">
        </form>
            <script>
            ClassicEditor
                .create(document.querySelector('#editor textarea'), {
                    toolbar: [
                        'heading', '|',
                        'bold', 'italic', 'link', 'bulletedList', 'numberedList', 'blockQuote', '|',
                        'undo', 'redo'
                    ]
                })
                .catch(error => {
                    console.error(error);
                });

            function previewImage(event) {
                const file = event.target.files[0];
                if (file) {
                    const reader = new FileReader();
                    reader.onload = function(e) {
                        const preview = document.getElementById('imagePreview');
                        preview.src = e.target.result;
                        preview.style.display = 'block';
                    };
                    reader.readAsDataURL(file);
                }
            }
        </script>
    </body>
</html>
