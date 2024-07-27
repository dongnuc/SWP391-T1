<%-- 
    Document   : Clubs
    Created on : Jun 5, 2024, 10:15:18 PM
    Author     : Nguyen Hau
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">


        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>


        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

    </head>
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
                            <h1 class="text-white">Club Details</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <div class="breadcrumb-row">
                    <div class="container">
                        <ul class="list-inline">
                            <li><a href="#">Home</a></li>
                            <li>Our Club</li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                                    <div class="widget courses-search-bx placeani">
                                        <div class="form-group">
                                            <form action="SearchClubServlet?page=1" method="get" style="margin-bottom: 20px;">
                                                <input name="page" type="hidden" value="1">
                                                <label>Search Club</label>
                                                <div class="input-group" style="display: flex; align-items: center;">
                                                    <input name="search" type="text" value="${searchQuery}" required class="form-control" style="flex: 1; margin-right: -1px;">
                                                    <div class="input-group-append">
                                                        <button class="btn btn-primary" type="submit" style="border-radius: 0; padding: 10px 20px;">Search</button>
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="widget widget_archive">
                                        <h5 class="widget-title style-1">TYPE CLUB</h5>
                                        <ul>
                                            <li class="active"><a href="PublicClubs?page=1">General</a></li>
                                                <c:forEach var="typeclub" items="${requestScope.listtypeclub}">
                                                <li><a href="ClubTypeController?id=${typeclub}&&page=1">${typeclub}</a></li>
                                                </c:forEach>

                                        </ul>
                                    </div>


                                </div>
                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <div class="row" >
                                        <c:forEach var="club" items="${requestScope.listclub}">
                                            <c:if test="${club.getStatus()==1}">
                                                <div class="col-md-6 col-lg-4 col-sm-6 m-b30" style="height: 400px">
                                                    <div class="cours-bx">
                                                        <div class="action-box">
                                                            <img src="${club.getImage()}" style="width: 350px;height: 200px">
                                                            <a href="ClubDetail?id=${club.getClub()}" class="btn">Read More</a>
                                                        </div>
                                                        <div class="info-bx text-center" style="text-align: right;height: 110px;">
                                                            <h5><a href="#">${club.getNameclub()}</a></h5>
                                                            <span style="text-align: left;">The ${club.getTitle()} </span>
                                                        </div>

                                                        <div class="cours-more-info">
                                                            <div class="review" style="padding-left: 5px;">
                                                                <span>${club.getTypebyid()}</span>

                                                            </div>
                                                            <div class="price">

                                                                <h5>${club.getSizeClub()} Member</h5>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>



                                    </div>
                                    <div class="col-lg-12 m-b20">
                                        <div class="pagination-bx rounded-sm gray clearfix">
                                            <ul class="pagination">
                                                <c:if test="${requestScope.i==null}">
                                                    <c:if test="${param.page!=1}">
                                                    <li class="previous"><a href="PublicClubs?page=${(param.page==null||param.page==1)?1:param.page-1}"><i class="ti-arrow-left"></i> Prev</a></li>
                                                    </c:if>    
                                                    <c:forEach begin="1" end="${requestScope.numberOfPage}" step="1" var="i">
                                                        <li><a href="PublicClubs?page=${i}">${i}</a></li>
                                                        </c:forEach>
                                                        <c:if test="${param.page!=requestScope.numberOfPage}">
                                                        <li class="next"><a href="PublicClubs?page=${(param.page==requestScope.numberOfPage)?requestScope.numberOfPage:param.page+1}">Next <i class="ti-arrow-right"></i></a></li>
                                                        </c:if>
                                                </c:if>
                                                <c:if test="${requestScope.ty==null}">
                                                    <c:if test="${param.page!=1}">
                                                        <li class="previous"><a href="ClubTypeController?id=${requestScope.category}&&page=${(param.page==null||param.page==1)?1:param.page-1}"><i class="ti-arrow-left"></i> Prev</a></li>
                                                        </c:if>  
                                                        <c:forEach begin="1" end="${requestScope.numberOfPage}" step="1" var="i">
                                                        <li><a href="ClubTypeController?id=${requestScope.category}&&page=${i}">${i}</a></li>
                                                        </c:forEach>
                                                        <c:if test="${param.page!=requestScope.numberOfPage}">
                                                        <li class="next"><a href="ClubTypeController?id=${requestScope.category}&&page=${(param.page==requestScope.numberOfPage)?requestScope.numberOfPage:param.page+1}">Next <i class="ti-arrow-right"></i></a></li>
                                                            </c:if>
                                                        </c:if>
                                                        <c:if test="${requestScope.se==null}">
                                                            <c:if test="${param.page!=1}">
                                                        <li class="previous"><a href="SearchClubServlet?search=${searchQuery}&&page=${(param.page==null||param.page==1)?1:param.page-1}"><i class="ti-arrow-left"></i> Prev</a></li>
                                                        </c:if>
                                                        <c:forEach begin="1" end="${requestScope.numberOfPage}" step="1" var="i">
                                                        <li><a href="SearchClubServlet?search=${searchQuery}&&page=${i}">${i}</a></li>
                                                        </c:forEach>
                                                        <c:if test="${param.page!=requestScope.numberOfPage}">
                                                        <li class="next"><a href="SearchClubServlet?search=${searchQuery}&&page=${(param.page==requestScope.numberOfPage)?requestScope.numberOfPage:param.page+1}">Next <i class="ti-arrow-right"></i></a></li>
                                                            </c:if>
                                                        </c:if>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- contact area END 

        </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <%@include file="Footer.jsp" %>
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
//            document.addEventListener("DOMContentLoaded", function () {
//                var paginationLinks = document.querySelectorAll('.pagination a');
//                paginationLinks.forEach(function (link) {
//                    link.addEventListener('click', function (event) {
//                        event.preventDefault();
//                        var currentPage = parseInt(this.textContent);
//                        setActivePage(currentPage);
//                    });
//                });
//
//                function setActivePage(pageNumber) {
//                    var paginationLinks = document.querySelectorAll('.pagination a');
//                    paginationLinks.forEach(function (link) {
//                        link.classList.remove('active');
//                    });
//                    paginationLinks[pageNumber - 1].classList.add('active');
//
//                    // Do something here to load data for the selected page
//                }
//            });
        </script>
    </body>
</html>

