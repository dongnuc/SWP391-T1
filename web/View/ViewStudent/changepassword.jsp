<%-- 
    Document   : changepassword
    Created on : May 14, 2024, 5:47:29 PM
    Author     : 84358
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="<%= request.getContextPath() %>/newpassword" method="post">
            Enter Old Password <input type="text" name="oldpassword" ><br>
            Enter New Password <input type="text" name="newpassword" ><br>
            Confirm Password <input type="text" name="confirm" ><br>
            ${error}
            <input type="submit" value="Change">
        </form>
    </body>
</html>
