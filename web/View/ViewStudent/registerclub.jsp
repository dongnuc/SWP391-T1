<%-- 
    Document   : registerclub
    Created on : May 27, 2024, 8:01:46 AM
    Author     : Nguyen Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->


        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="css/main.css ">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

        <!-- REVOLUTION SLIDER CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/layers.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/settings.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/navigation.css">
        <title>JSP Page</title>
        <style>
            .form-container {
                width: 80%;
                height: auto;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 10px;
                background-color: #f9f9f9;
                box-sizing: border-box;
            }

            .form-group {
                margin-bottom: 15px;
            }
            .form-group label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }
            .form-group input, .form-group select {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            .form-group textarea{
                height: 15vh; /* 60% of the viewport height */
                width: 100%;
            }
            .form-group input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
            }
            .form-group input[type="submit"]:hover {
                background-color: #45a049;
            }
            .form{
                padding-top: 20px;
            }
            .error-message {
                font-size: 14px;
                margin: 5px 0;
            }
        </style>
    </head>
    <body>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <%@ include file="Header.jsp" %>
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(images/banner.png);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">REGISTER CLUB</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <form method="post" action="/SWP391/registerclub" style="padding-top: 20px;padding-bottom: 20px;" > 


                    <div class="form-container" >

                        <div class="form-group" >
                            <label for="NameClub">Club Name</label>
                            <input type="text" id="NameClub" name="NameClub" value="${nameClub}"/>
                            <h6 class="error-message" style="color: red;">${error1}</h6>
                        </div>
                        <div class="form-group">
                            <label for="clubId">Type of Club</label>
                            <select id="clubId" name="idClub" class="input-field" >
                                <option value="">Select Type Club</option>
                                <c:forEach items="${requestScope.listtypeclub}" var="getTypeClub"> 
                                    <option value="${getTypeClub}"
                                            <c:if test="${getTypeClub == requestScope.typeclub}">selected</c:if>
                                            >${getTypeClub}</option>
                                </c:forEach>
                            </select>
                            <h6 class="error-message" style="color: red;">${error6}</h6>
                        </div>
                        <div class="form-group" >
                            <label for="NameClub">Desired Number Of Members</label>
                            <input type="text" id="NameClub" name="Member" value="${member}"/>
                            <h6 style="color: red;">${error2}</h6>
                        </div>
                        <div class="form-group">
                            <label for="Reason">Reason</label>
                            <textarea id="Reason" name="Reason" rows="10" cols="50" >
                                ${reason}
                            </textarea>
                            <br>
                            <h6 class="error-message" style="color: red;">${error3}</h6>
                        </div>
                        <div class="form-group">
                            <label for="Reason">Target</label>
                            <textarea  name="Target" rows="10" cols="50" >
                                ${target}
                            </textarea>
                            <br>
                            <h6 class="error-message" style="color: red;">${error4}</h6>
                        </div>
                        <div class="form-group" >
                            <label for="Reason">Plan</label>
                            <textarea  name="Plan" rows="10" cols="50" >
                                ${plan}
                            </textarea>
                            <br>
                            <h6 class="error-message" style="color: red;">${error5}</h6>
                        </div>
                        <h6 class="error-message" style="color: green;">${error}</h6>

                        <h6 class="error-message" style="color: red;">${errorr}</h6>
                        <div class="form-group">
                            <input type="submit" value="Register Club"/>
                        </div>    
                        
                    </div>    
                </form>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->

                <!-- contact area END -->

            </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <%@ include file="Footer.jsp" %>
            <!-- Footer END ==== -->
            <button class="back-to-top fa fa-chevron-up" ></button>
        </div>
        <!-- External JavaScripts -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="assets/vendors/counter/waypoints-min.js"></script>
        <script src="assets/vendors/counter/counterup.min.js"></script>
        <script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="assets/vendors/masonry/masonry.js"></script>
        <script src="assets/vendors/masonry/filter.js"></script>
        <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src="assets/js/functions.js"></script>
        <script src="assets/js/contact.js"></script>
        <script src='assets/vendors/switcher/switcher.js'></script>



        <script>
            function showSubMenu() {
                var subMenu = document.getElementById("subMenu");
                subMenu.style.display = "block";
            }

            function hideSubMenu() {
                var subMenu = document.getElementById("subMenu");
                subMenu.style.display = "none";
            }
            function showSubMenu1() {
                var subMenu = document.getElementById("subMenu1");
                subMenu.style.display = "block";
            }

            function hideSubMenu1() {
                var subMenu = document.getElementById("subMenu1");
                subMenu.style.display = "none";
            }
            function showSubMenu2() {
                var subMenu = document.getElementById("subMenu2");
                subMenu.style.display = "block";
            }

            function hideSubMenu2() {
                var subMenu = document.getElementById("subMenu2");
                subMenu.style.display = "none";
            }
            function showSubMenu3() {
                var subMenu = document.getElementById("subMenu3");
                subMenu.style.display = "block";
            }

            function hideSubMenu3() {
                var subMenu = document.getElementById("subMenu3");
                subMenu.style.display = "none";
            }
            ;

        </script>



        <script>
            var isClubVisible = false;

            function showClubTable() {
                var profileInfo = document.getElementById("club-table");
                if (!isClubVisible) {
                    profileInfo.style.display = "block";
                }
            }

            function hideClubTable() {
                var profileInfo = document.getElementById("club-table");
                if (!isClubVisible) {
                    profileInfo.style.display = "none";
                }
            }

            function toggleClubTable() {
                var profileInfo = document.getElementById("club-table");
                if (!isClubVisible) {
                    profileInfo.style.display = "block";
                    isClubVisible = true;
                } else {
                    isClubVisible = false;
                }
            }

            // Ẩn thông tin người dùng khi click ra ngoài
            document.addEventListener("click", function (event) {
                var profileInfo = document.getElementById("club-table");
                if (!event.target.closest(".dropdown") && isClubVisible) {
                    profileInfo.style.display = "none";
                    isClubVisible = false;
                }
            });
        </script>
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
