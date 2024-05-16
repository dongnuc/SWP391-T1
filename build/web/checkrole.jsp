<%-- 
    Document   : checkrole
    Created on : May 15, 2024, 9:01:26 PM
    Author     : 84358
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Club: ${requestScope.myclub} Role ${requestScope.role}<br>
        <c:if test="${requestScope.role=='Manager'}">
            <a href="">Tao Bog</a>
            <a href="">Task for ABC</a>
            <a href="">Poin for ABC</a>
            </c:if>
    </body>
</html>
