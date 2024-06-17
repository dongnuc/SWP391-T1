<%-- 
    Document   : Event_Homepage
    Created on : May 28, 2024, 2:09:39 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.*" %>
<%@page import = "DAO.*" %>
<%@page import = "java.util.*" %>
<!DOCTYPE html>
<%
    Accounts acc = (Accounts) session.getAttribute("curruser");
    StudentClubDAO studentClubDAO = new StudentClubDAO();
    List<StudentClub> StudentClubList = studentClubDAO.getStudentClubs(acc.getId());
    
    String nameEvent = request.getParameter("nameevent") != null ? request.getParameter("nameevent") : "";
    String description = request.getParameter("description") != null ? request.getParameter("description") : "";
    String content = request.getParameter("content") != null ? request.getParameter("content") : "";
    String address = request.getParameter("address") != null ? request.getParameter("address") : "";
    String dateStart = request.getParameter("datestart") != null ? request.getParameter("datestart") : "";
    String dateEnd = request.getParameter("dateend") != null ? request.getParameter("dateend") : "";
    String idClub = request.getParameter("idclub") != null ? request.getParameter("idclub") : "";
    String eventType = request.getParameter("eventtype") != null ? request.getParameter("eventtype") : "";
    String status = request.getParameter("status") != null ? request.getParameter("status") : "1";
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Homepage</title>
        <script src="https://cdn.ckeditor.com/ckeditor5/41.4.2/classic/ckeditor.js"></script>
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
                    reader.onload = function (e) {
                        const preview = document.getElementById('imagePreview');
                        preview.src = e.target.result;
                        preview.style.display = 'block';
                    };
                    reader.readAsDataURL(file);
                }
            }
        </script>
        <style>
            img {
                width: 150px;
            }
            .preview {
                display: none;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <form action="<%= request.getContextPath() %>/EventUploadServlet" method="post" enctype="multipart/form-data">
            Name event:
            <input type="text" id="nameevent" name="nameevent" value="<%= nameEvent %>"><br>
            Description:
            <input type="text" id="description" name="description" value="<%= description %>"><br>
            Content:
            <div id="editor">
                <textarea id="content" name="content"><%= content %></textarea><br>
            </div>
            Image:
            <input type="file" id="file" name="file" accept="image/*" onchange="previewImage(event)"><br>
            <img id="imagePreview" class="preview" src="#" alt="Image Preview"><br>
            CLUB: <%
                ClubDao clubDAO = new ClubDao();
                for (StudentClub studentClub : StudentClubList) {
                    if (studentClub.getStatus() == 1 && studentClub.getRole() == 1) {
                        boolean checked = String.valueOf(studentClub.getIdClub()).equals(idClub);
            %>
            <input type="radio" name="idclub" value="<%= studentClub.getIdClub() %>" <%= checked ? "checked" : "" %>><%= clubDAO.getNameById(studentClub.getIdClub()) %><br>
            <%      }
                }
            %>
            Date start:
            <input type="date" name="datestart"  value="<%= dateStart %>"><br>
            Date end:
            <input type="date" name="dateend" value="<%= dateEnd %>"><br>
            Event's type:
            <%
                EventTypeDAO eventTypeDAO = new EventTypeDAO();
                List<EventType> eventTypeDAOList = eventTypeDAO.getAllEventTypes();
                for (EventType eventTypeObj : eventTypeDAOList) {
                    boolean checked = String.valueOf(eventTypeObj.getIdEventType()).equals(eventType);
            %>
            <input type="radio" name="eventtype" value="<%= eventTypeObj.getIdEventType() %>" <%= checked ? "checked" : "" %>><%= eventTypeObj.getNameEventType() %><br>
            <% } %>
            
            Address:
            <input type="text" name="address" value="<%= address %>"><br>
            Status: <input type="text" name="status" value="1"><br>
            <p style="color: red;"><%= request.getAttribute("mess") != null ? request.getAttribute("mess") : "" %></p>
            <input type="submit" name="Add">
        </form>
    </body>
</html>
