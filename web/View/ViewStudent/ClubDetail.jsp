<%-- 
    Document   : ClubDetail
    Created on : Jun 8, 2024, 9:26:24 PM
    Author     : Nguyen Hau
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid black;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
        <style>
            .blog-container {
                border: 1px solid #ddd;
                border-radius: 5px;
                padding: 15px;
                margin-bottom: 20px;
                display: flex;
                align-items: flex-start;
            }

            .blog-image {
                width: 150px;
                height: 100px;
                object-fit: cover;
                margin-right: 15px;
            }

            .blog-details {
                flex: 1;
            }

            .blog-title {
                margin: 0 0 5px 0;
                font-size: 18px;
                font-weight: bold;
            }

            .blog-date {
                margin: 0 0 10px 0;
                color: #888;
                font-size: 14px;
            }

            .blog-description {
                margin: 0;
                font-size: 16px;
            }
        </style>
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
                            <li>Club Details</li>
                            <li><c:if test="${sessionScope.id eq acc.id}">
                                    <a href="EventUploadServlet">Student Recruitment Event</a>
                                </c:if></li>
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->  <c:set var="club" value="${requestScope.club}"/>
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row d-flex flex-row-reverse" style="display: flex;">
                                <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                                    <div class="course-detail-bx">
                                        <c:set var="acc" value="${requestScope.acc}"/>
                                        <div class="course-buy-now text-center">
                                            <c:if test="${sessionScope.id eq acc.id}">
                                                <a href="ClubProfile?id=${club.getClub()}" class="btn radius-xl text-uppercase">Club Profile</a>
                                            </c:if>

                                        </div>
                                        <div class="teacher-bx">
                                            <div class="teacher-info">
                                                <div class="teacher-thumb">
                                                    <img src="${acc.getImage()}" alt=""/>
                                                </div>

                                                <div class="teacher-name">
                                                    <h5>${acc.getName()}</h5>
                                                    <span>${acc.getDatecreate()}</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cours-more-info">
                                            <div class="review">
                                                <span>Phone Number</span>
                                                <ul class="cours-star">

                                                    <span>${acc.getSdt()}</span>

                                                </ul>
                                            </div>
                                            <div class="price categories">
                                                <span>${acc.getDatemodify()}</span>
                                                <h5 class="text-primary">Create</h5>
                                            </div>
                                        </div>
                                        <div class="course-info-list scroll-pag">
                                            <ul class="navbar">
                                                <li><a class="nav-link" href="#overview"><i class="ti-zip"></i>Nofications</a></li>

                                                <li><a class="nav-link" href="#instructor"><i class="ti-user"></i>Ranking Member</a></li>

                                            </ul>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-lg-9 col-md-8 col-sm-12">
                                    <div class="courses-post">
                                        <div class="ttr-post-media media-effect">
                                            <a href="#"><img src="${club.getImage()}" alt="" style="width: 950px;height: 600px"></a>
                                        </div>
                                        <div class="ttr-post-info">
                                            <div class="ttr-post-title ">
                                                <h2 class="post-title">${club.getNameclub()}</h2>
                                            </div>
                                            <div class="ttr-post-text">
                                                <p> ${club.getTitle()} </p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="courese-overview" id="overview" style="">
                                        <h4>Latest Event</h4>
                                        <c:set var="event" value="${requestScope.event}"/>
                                        <div class="row">
                                            <div class="col-md-6 col-lg-4 col-sm-6 m-b30" style="height: 500px">
                                                <div class="cours-bx">
                                                    <div class="action-box">
                                                        <img src="${event.getImage()}" style="width: 350px;height: 350px">
                                                        <a href=# class="btn">Read More</a>
                                                    </div>
                                                    <div class="info-bx text-center" style="text-align: right;height: 90px;">
                                                        <h5><a href="#">${event.getNameEvent()}</a></h5>
                                                        <span style="text-align: left;"> </span>
                                                    </div>

                                                    <div class="cours-more-info">
                                                        <div class="review" style="padding-left: 5px;width: 100%;text-align: center;">
                                                            <h6>Datecreate : ${event.getDatecreate()}</h6>

                                                        </div>

                                                    </div>
                                                </div>
                                            </div>

                                            <div class="col-md-12 col-lg-8" style="width: 500px;">
                                                <h5 class="m-b5">Club Description</h5>
                                                <p>${club.getDescription()}</p>
                                                <h5 class="m-b5">New Blogs</h5>
                                                <c:forEach var="blog" items="${requestScope.blog}">
                                                    <div class="blog-container">
                                                        <img src="${blog.getImage()}"  class="blog-image">
                                                        <div class="blog-details">
                                                            <h6 class="blog-title"><a href="#">${blog.getTitleBlog()}</a></h6>
                                                            <p class="blog-date">Date Created: ${blog.getDateCreate()}</p>
                                                            <p class="blog-description">${blog.getDescription()}</p>
                                                        </div>
                                                    </div>
                                                </c:forEach>

                                            </div>

                                        </div>
                                    </div>

                                    <div class="" id="instructor">
                                        <h4>Member Ranking</h4>

                                        <table>
                                            <tr>
                                                <th>Name</th>
                                                <th>Date Create</th>
                                                <th>Point</th>
                                            </tr>
                                            <c:forEach var="student" items="${requestScope.liststudent}">
                                                <tr>
                                                    <td>${student.getNamebyId()}</td>
                                                    <td>${student.getDatecreate()}</td>
                                                    <td>${student.getPoint()}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>

                                    </div>

                                </div>
                                <div class="" id="instructor" style="width: 100%;padding-top: 20px ;padding-right: 10%;;">
                                    <h4 >OTHER CLUB</h4>

                                    <br>
                                    <div class="row" >
                                        <c:forEach var="club" items="${requestScope.otherclub}">
                                            <c:if test="${club.getClub()!=param.id}">
                                                <div class="col-md-6 col-lg-4 col-sm-6 m-b30" style="height: 400px;width: 300px;padding-top: 20px;">
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
                                </div> 
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
        <!-- contact area END -->

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