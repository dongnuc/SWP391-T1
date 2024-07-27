<%-- 
    Document   : ContactUs
    Created on : May 22, 2024, 2:31:45 AM
    Author     : Nguyen Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <style>
            .error-message{
                color: red;
                font-style: italic;
                margin-bottom: 0px;
            }
        </style>
        <title>JSP Page</title>
    </head>
    <body>

        <%@ include file="Header.jsp" %>
        <div class="page-banner ovbl-dark" style="background-image:url(images/banner.png);">
            <div class="container">
                <div class="page-banner-entry">
                    <h1 class="text-white">Contact Us</h1>
                </div>
            </div>
        </div>
        <section class="contact-section">           
            <div class="col-lg-12 m-b30">                
                <div class="widget-box">                   
                    <div class="widget-inner">
                        <form action="contactus" method="post" class="edit-profile m-b30">
                            <div class="row">                              
                                <div class="form-group col-6">
                                    <label class="col-form-label">Full Name</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <input class="form-control" name="name" type="text" value="${fullname}">
                                        <p class="error-message">${errorName}</p>
                                    </div>
                                </div>
                                <div class="form-group col-6">
                                    <label class="col-form-label">Email</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <input class="form-control" name="email" type="text" value="${email}">
                                        <p class="error-message">${errorEmail}</p>
                                    </div>
                                </div>
                                <div class="form-group col-6">
                                    <label class="col-form-label">Phone Number</label>                                   
                                    <div>
                                        <input class="form-control" type="text" name="phone" value="${phone}">
                                         <p class="error-message">${errorPhone}</p>
                                    </div>
                                </div>
                                <div class="form-group col-6">
                                    <label class="col-form-label">Choose Application Type</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <select name="typeForm" class="form-control">
                                            <c:set var="count" value="1"/>    
                                            <c:forEach var="listType" items="${listType}">
                                                <option value="${listType.key}">${listType.value}</option>
                                                <c:set var="count" value="${count + 1}"/>
                                            </c:forEach>             
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-12">
                                    <label class="col-form-label">Tittle</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <input class="form-control" name="tittle" type="text" value="${tittle}">
                                         <p class="error-message">${errorTittle}</p>
                                    </div>
                                </div>
                                <div class="form-group col-12">
                                    <label class="col-form-label">Content</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <textarea class="form-control" name="content">
                                            <c:if test="${content != null}">${content}</c:if>
                                        </textarea>
                                         <p class="error-message">${errorContent}</p>
                                    </div>
                                </div>
                                <div class="seperator"></div>
                                <div class="col-12">
                                    <button type="submit" class="btn">Submit</button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>

           
        </section>
        <%@ include file="Footer.jsp" %>
       
        <script>

            // Function thay đổi trang
            function changePage(page) {
                // Ẩn tất cả các trang thông tin hot
                var hotInfos = document.querySelectorAll('.hot-info');
                for (var i = 0; i < hotInfos.length; i++) {
                    hotInfos[i].style.display = 'none';
                }
                // Hiển thị trang được chọn
                document.getElementById('page' + page).style.display = 'block';
            }
            // Mặc định hiển thị trang 1 khi trang được tải
            changePage(1);
        </script>
        <script>
            // JavaScript functions
            var isProfileVisible = false;

            function showProfileInfo() {
                var profileInfo = document.getElementById("profile-info");
                if (!isProfileVisible) {
                    profileInfo.style.display = "block";
                }
            }

            function hideProfileInfo() {
                var profileInfo = document.getElementById("profile-info");
                if (!isProfileVisible) {
                    profileInfo.style.display = "none";
                }
            }

            function toggleProfileInfo() {
                var profileInfo = document.getElementById("profile-info");
                if (!isProfileVisible) {
                    profileInfo.style.display = "block";
                    isProfileVisible = true;
                } else {
                    isProfileVisible = false;
                }
            }

            // Ẩn thông tin người dùng khi click ra ngoài
            document.addEventListener("click", function (event) {
                var profileInfo = document.getElementById("profile-info");
                if (!event.target.closest(".profile-picture") && isProfileVisible) {
                    profileInfo.style.display = "none";
                    isProfileVisible = false;
                }
            });
            document.addEventListener("DOMContentLoaded", function () {
                var paginationLinks = document.querySelectorAll('.pagination a');
                paginationLinks.forEach(function (link) {
                    link.addEventListener('click', function (event) {
                        event.preventDefault();
                        var currentPage = parseInt(this.textContent);
                        setActivePage(currentPage);
                    });
                });

                function setActivePage(pageNumber) {
                    var paginationLinks = document.querySelectorAll('.pagination a');
                    paginationLinks.forEach(function (link) {
                        link.classList.remove('active');
                    });
                    paginationLinks[pageNumber - 1].classList.add('active');

                    // Do something here to load data for the selected page
                }
            });
        </script>
    </body>
</html>
