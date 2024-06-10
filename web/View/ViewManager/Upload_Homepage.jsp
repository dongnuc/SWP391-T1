<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import = "Model.*" %>
<%@ page import = "DAO.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<%
    BlogDAO postDAO = new BlogDAO();
    List<Blog> postList = postDAO.getAllPosts();
    Accounts acc = (Accounts) session.getAttribute("curruser");
    List<StudentClub> StudentClubList = null;
    if (acc != null) {
        StudentClubDAO studentClubDAO = new StudentClubDAO();
        StudentClubList = studentClubDAO.getStudentClubs(acc.getId());
    }
%>
<html>
    <head>
        <title>Blog Homepage</title>
        <script src="https://cdn.ckeditor.com/ckeditor5/41.4.2/classic/ckeditor.js"></script>
        <style>
            img{
                width: 150px;
            }
        </style>

    </head>
    <body>
        <%
            boolean hasRole1 = false;
            if (acc != null ) {
            for(StudentClub studentClubcheckRole : StudentClubList){
                if(studentClubcheckRole.getRole() <= 2 && studentClubcheckRole.getStatus() == 1 ){
                hasRole1 = true;
                    }
                }
            }

            if (hasRole1) {
        %>
        <form action="<%= request.getContextPath() %>/UploadServlet" method="post" enctype="multipart/form-data">
            Title:
            <input type="text" id="title" name="tittle" value=""><br>
            Image:
            <input type="file" id="file" name="file" accept="image/*" ><br>
            Description : <input type="text" name="description"><br>
            Content:
            <div id="editor">
                <textarea name="content"></textarea>
            </div>

            Show:
            <input type="radio" id="public" name="visibility" value="1" >
            <label >Public</label>
            <input type="radio" id="private" name="visibility" value="0">
            <label >Private</label><br>
            <input type="hidden" name="status" value="1">
            CLUB : <%
                    ClubDao clubDAO = new ClubDao();
                    for (StudentClub studentClub : StudentClubList  ){
                        if(studentClub.getStatus() == 1 && studentClub.getRole() <= 2){
            %>
            <input type="radio" name="idclub" value="<%= studentClub.getIdClub()%>" ><%= clubDAO.getNameById(studentClub.getIdClub())%><br>
            <%      }
                }
            %>
            Blog's type : <%
                BlogTypeDAO blogTypeDAO = new BlogTypeDAO();
                List<BlogType> blogTypeList = blogTypeDAO.getAllPosts();
                for(BlogType blogType : blogTypeList){
            %> 
            <input type="radio" name="blogtype" value="<%= blogType.getIdBlogType()%>"><%= blogType.getNameBlogType()%><br>
            <% }%>
            <input type="submit" value="Upload">
        </form>
        <%
}
        %>
        <script>
            ClassicEditor
                    .create(document.querySelector('#editor textarea'))
                    .catch(error => {
                        console.error(error);
                    });

        </script>
        <%
                for (Blog showBlog : postList) {
                boolean canSeeBlog = showBlog.getShow() == 1; 
                if (!canSeeBlog && acc != null) { 
                for (StudentClub studentClub : StudentClubList) {
                    if (studentClub.getIdClub() == showBlog.getIdClub()) { 
                        canSeeBlog = true;
                        break;
                }
            }
        }
                if (canSeeBlog) { 
        %>
        <a href="<%= request.getContextPath() %>/UploadContentBlog?idBlog=<%= showBlog.getIdBlog() %>">
            <img src="<%= request.getContextPath() %>/<%= showBlog.getImage() %>" alt="Uploaded Image"></a><br>
            <%= showBlog.getDateCreate()%>
        <h2 ><%= showBlog.getTitleBlog()%></h2>
        <%      }   
            }
        %>
    </body>
</html>
