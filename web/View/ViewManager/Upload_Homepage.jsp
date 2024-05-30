<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import = "Model.*" %>
<%@ page import = "DAO.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<%
    BlogDAO postDAO = new BlogDAO();
    List<Blog> postList = postDAO.getAllPosts();
%>
<html>
    <head>
        <title>Blog Homepage</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f9f9f9;
                margin: 0;
                padding: 0;
            }

            .form-container {
                max-width: 600px;
                margin: 50px auto;
                padding: 20px;
                background: #fff;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
                border-radius: 8px;
            }

            .form-container h2 {
                text-align: center;
                margin-bottom: 20px;
                font-size: 24px;
                color: #333;
            }

            .form-group {
                margin-bottom: 15px;
            }

            .form-group label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
                color: #555;
            }

            .form-group input[type="text"],
            .form-group input[type="file"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ddd;
                border-radius: 4px;
                font-size: 16px;
            }

            .form-group input[type="radio"] {
                margin-right: 5px;
            }

            .form-group .radio-group {
                display: flex;
                align-items: center;
                margin-top: 5px;
            }

            .form-group .radio-group label {
                margin-right: 15px;
                font-weight: normal;
                color: #555;
            }

            .form-group input[type="submit"] {
                display: block;
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                border: none;
                border-radius: 4px;
                color: #fff;
                font-size: 18px;
                cursor: pointer;
                transition: background-color 0.3s;
            }

            .form-group input[type="submit"]:hover {
                background-color: #0056b3;
            }

            .blog-posts-container {
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
                justify-content: center;
                margin: 0 auto;
                max-width: 1200px;
                padding: 20px;
            }

            .blog-post {
                background: #fff;
                border: 1px solid #ddd;
                border-radius: 5px;
                display: flex;
                flex-direction: column;
                overflow: hidden;
                width: calc(33.333% - 20px);
                box-shadow: 0 4px 8px rgba(0,0,0,0.1);
                margin-bottom: 20px;
                position: relative;
            }

            /* First in row */
            .blog-post:nth-child(3n+1) {
                align-self: flex-start;
            }

            /* Second in row */
            .blog-post:nth-child(3n+2) {
                align-self: center;
            }

            /* Third in row */
            .blog-post:nth-child(3n) {
                align-self: flex-end;
            }

            .post-image {
                width: 100%;
                height: 250px;
                overflow: hidden;
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .post-image img {
                width: 100%;
                height: 100%;
                object-fit: cover;
            }

            .post-content {
                padding: 20px;
            }

            .post-meta {
                font-size: 14px;
                color: #777;
                margin-bottom: 10px;
            }

            .post-meta .post-date,
            .post-meta .post-author {
                margin-right: 15px;
            }

            .post-title {
                font-size: 24px;
                color: #333;
                margin-bottom: 10px;
            }

            .post-description {
                font-size: 16px;
                color: #555;
                margin-bottom: 20px;
            }

            .post-footer {
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .read-more {
                font-size: 16px;
                color: #007bff;
                text-decoration: none;
            }

            .read-more:hover {
                text-decoration: underline;
            }

            .post-comments {
                font-size: 16px;
                color: #777;
            }

            /* Responsive Adjustments */
            @media (max-width: 992px) {
                .blog-post {
                    width: calc(50% - 20px);
                }
            }

            @media (max-width: 600px) {
                .blog-post {
                    width: 100%;
                }
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
        <div class="form-container">
            <h2>Upload Blog Post</h2>
            <form action="<%= request.getContextPath() %>/UploadServlet" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="title">Title:</label>
                    <input type="text" id="title" name="tittle" value="" required>
                </div>
                <div class="form-group">
                    <label for="file">Image:</label>
                    <input type="file" id="file" name="file" accept="image/*" required>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" id="description" name="description" value="" required>
                </div>
                <div class="form-group">
                    <label>Show:</label>
                    <div class="radio-group">
                        <input type="radio" id="public" name="visibility" value="1" required>
                        <label for="public">Public</label>
                        <input type="radio" id="private" name="visibility" value="0">
                        <label for="private">Private</label>
                    </div>
                </div>
                <input type="hidden" name="status" value="1">
                <input type="hidden" name="idclub" value="<%= userClubId %>" required>
                <div class="form-group">
                    <input type="submit" value="Upload">
                </div>
            </form>
        </div>
        <% } %>
        <div class="blog-posts-container">
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
            <div class="blog-post">
                <a href="<%= request.getContextPath() %>/UploadContentBlog?idBlog=<%= x.getIdBlog() %>">
                    <div class="post-image">
                        <img src="<%= request.getContextPath() %>/<%= x.getImage() %>" alt="Uploaded Image">
                    </div>
                </a>
                <div class="post-content">
                    <div class="post-meta">
                        <span class="post-date"><%= x.getDateCreate()%></span>
                    </div>
                    <h2 class="post-title"><%= x.getTitleBlog()%></h2>
                    <div class="post-footer">
                        <a href="<%= request.getContextPath() %>/UploadContentBlog?idBlog=<%= x.getIdBlog() %>" class="read-more">READ MORE</a>
                    </div>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </body>
</html>
