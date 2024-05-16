<%-- 
    Document   : home.jsp
    Created on : May 14, 2024, 1:48:25 PM
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
        <c:if test="${sessionScope.account==null}">
                <div class="dangnhap">
                    <a href="login.jsp">Đăng Nhập</a>
                </div>
            </c:if>
            <c:if test="${sessionScope.account!=null}">
                <div class="header3">
                   <p href="">Xin Chào ${sessionScope.account}</p>
                   <div class="header3son">
                   <a href="profile.jsp">Thông tin cá nhân</a><br>
                   <a href="changepassword.jsp">Change Password</a><br>
                   <a href="logout">Logout</a>
                   </div>
                </div>
            </c:if> 
        <c:if test="${sessionScope.id != null}">
        My club
        <c:forEach items="${sessionScope.myclub}" var="x">   
            <a href="getrole?myclub=${x}">${x}</a> <br>   
            </c:forEach>
        </c:if>
        
    </body>
</html>
