<%-- 
    Document   : updateStudentClub
    Created on : Jul 8, 2024, 2:47:29 PM
    Author     : Nguyen Hau
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <!-- META ============================================= -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="" />
        <meta name="author" content="" />
        <meta name="robots" content="" />

        <!-- DESCRIPTION -->
        <meta name="description" content="EduChamp : Education HTML Template" />

        <!-- OG -->
        <meta property="og:title" content="EduChamp : Education HTML Template" />
        <meta property="og:description" content="EduChamp : Education HTML Template" />
        <meta property="og:image" content="" />
        <meta name="format-detection" content="telephone=no">

        <!-- FAVICONS ICON ============================================= -->
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/assets.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/shortcodes/shortcodes.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/color/color-1.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>
    <body id="bg">

       <header class="ttr-header">
            <div class="ttr-header-wrapper">
            </div>
        </header>
       
        <c:set var="student" value="${requestScope.student}"/>
        <div class="rown" style="display: flex; justify-content: center;padding-top: 70px;">

            <div class="col-xl-8">
                
                        <form action="UpdateStudentClubServlet?idclub=${student.getIdClub()}&&idstudent=${student.getIdStudent()}" method="post">
                            <input type="hidden" value="${club.getClub()}" name="id"/>
                            <!-- Form Group (username)-->

                            <!-- Form Row-->
                            <div class="row gx-3 mb-3">
                                <!-- Form Group (first name)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputLocation" >Point</label>
                                    <input class="form-control" id="point" name="point" type="text"  value=${student.getPoint()}>
                                </div>
                                <!-- Form Group (last name)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputOrgName">Date Entry Club</label>
                                    <input class="form-control" id="datecreate" name="datecreate" type="date"  value="${student.getDatecreate()}">
                                </div>
                            </div>
                            <!-- Form Row-->
                            <div class="row gx-3 mb-3">
                                <!-- Form Group (organization name)-->

                                <!-- Form Group (location)-->
                                <div class="col-md-6">
                                    <label class="small mb-1" for="inputFirstName" >Role</label>
                                    <select name="role" class="form-control">
                                        <option value="1" <c:if test="${student.getRole() == 1}">selected</c:if>>Manager</option>
                                        <option value="2" <c:if test="${student.getRole() == 2}">selected</c:if>>Secretary</option>
                                        <option value="3" <c:if test="${student.getRole() == 3}">selected</c:if>>Treasurer</option>
                                        <option value="4" <c:if test="${student.getRole() == 4}">selected</c:if>>Public Relations officer</option>
                                        <option value="5" <c:if test="${student.getRole() == 5}">selected</c:if>>Member</option>
                                        <option value="6" <c:if test="${student.getRole() == 6}">selected</c:if>>Technical</option>
                                        </select>
                                    </div>
                                    <div class="col-md-6">
                                        <label class="small mb-1" for="inputFirstName" >Role</label>
                                        <select name="position" class="form-control">
                                        <option value="1" <c:if test="${student.getLeader() == 1}">selected</c:if>>Leader</option>
                                        <option value="0" <c:if test="${student.getLeader() == 0}">selected</c:if>>Member</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- Form Group (email address)-->
                                
                            <!-- Form Row-->
                            <c:if test="${not empty error1}">
                                <div style="color: red; font-weight: bold;">${error1}</div>
                            </c:if>
                                <c:if test="${not empty error2}">
                                <div style="color: red; font-weight: bold;">${error2}</div>
                            </c:if>
                            <c:if test="${not empty error}">
                                <div style="color: green; font-weight: bold;">${error}</div>
                            </c:if>
                            <!-- Save changes button-->
                            <button class="btn btn-primary" type="submit">Save changes</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>