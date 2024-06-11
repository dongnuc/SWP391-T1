<%-- 
    Document   : ClubDetail
    Created on : Jun 8, 2024, 9:26:24 PM
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
                        </ul>
                    </div>
                </div>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
                <div class="content-block">
                    <!-- About Us -->
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row d-flex flex-row-reverse">
                                <div class="col-lg-3 col-md-4 col-sm-12 m-b30">
                                    <div class="course-detail-bx">

                                        <div class="course-buy-now text-center">
                                            <a href="#" class="btn radius-xl text-uppercase">Managerment</a>
                                        </div>
                                        <div class="teacher-bx">
                                            <div class="teacher-info">
                                                <div class="teacher-thumb">
                                                    <img src="assets/images/testimonials/pic1.jpg" alt=""/>
                                                </div>
                                                <c:set var="acc" value="${requestScope.acc}"/>
                                                <div class="teacher-name">
                                                    <h5>${acc.getName()}</h5>
                                                    <span>${acc.getDatecreate()}</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="cours-more-info">
                                            <div class="review">
                                                <span>3 Review</span>
                                                <ul class="cours-star">
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li class="active"><i class="fa fa-star"></i></li>
                                                    <li><i class="fa fa-star"></i></li>
                                                    <li><i class="fa fa-star"></i></li>
                                                </ul>
                                            </div>
                                            <div class="price categories">
                                                <span>${acc.getDatemodify()}</span>
                                                <h5 class="text-primary">Create</h5>
                                            </div>
                                        </div>
                                        <div class="course-info-list scroll-pag">
                                            <ul class="navbar">
                                                <li><a class="nav-link" href="#overview"><i class="ti-zip"></i>Overview</a></li>

                                                <li><a class="nav-link" href="#instructor"><i class="ti-user"></i>Member</a></li>

                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <c:set var="club" value="${requestScope.club}"/>
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
                                                <p>Welcome to the ${club.getNameclub()} Our club is a vibrant community dedicated to [brief description of the club’s focus, e.g., promoting environmental awareness, exploring the arts, developing tech skills]. We offer a range of activities, events, and projects designed to engage, inspire, and empower our members. Whether you’re a seasoned enthusiast or just starting out, you’ll find a supportive and dynamic environment here. Join us to learn, grow, and make a positive impact together!</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="courese-overview" id="overview">
                                        <h4>Overview</h4>
                                        <div class="row">
                                            <div class="col-md-12 col-lg-4">
                                                <ul class="course-features">
                                                    <li><i class="ti-book"></i> <span class="label">Lectures</span> <span class="value">8</span></li>
                                                    <li><i class="ti-help-alt"></i> <span class="label">${acc.getPassword()}</span> <span class="value"></span></li>
                                                    <li><i class="ti-time"></i> <span class="label">Date create</span> <span class="value">${club.getDatecreate()}</span></li>
                                                    <li><i class="ti-stats-up"></i> <span class="label">Skill level</span> <span class="value">Beginner</span></li>
                                                    <li><i class="ti-smallcap"></i> <span class="label">Language</span> <span class="value">English</span></li>
                                                    <li><i class="ti-user"></i> <span class="label">Member</span> <span class="value">${club.getSizeClub()}</span></li>

                                                </ul>
                                            </div>
                                            <div class="col-md-12 col-lg-8">
                                                <h5 class="m-b5">Club Description</h5>
                                                <p>${club.getDescription()}</p>
                                                <h5 class="m-b5">Clubs Rule</h5>
                                                <ul class="list-checked primary">
                                                    <li>Respect all members and their opinions.</li>
                                                    <li>Attend meetings regularly and punctually.</li>
                                                    <li>Participate actively in club activities.</li>
                                                    <li>Maintain academic integrity and prioritize studies.</li>
                                                    <li>Keep club materials and spaces clean.</li>
                                                    <li>Communicate respectfully and constructively.</li>
                                                    <li>Adhere to the university's code of conduct.</li>
                                                    <li>Report any issues or concerns to club leaders.</li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="" id="instructor">
                                        <h4>Member</h4>
                                        
                                        <table>
                                            <tr>
                                                <th>Name</th>
                                                <th>Date Create</th>
                                                <th>Point</th>
                                            </tr>
                                            <c:forEach var="student" items="${requestScope.liststudent}">
                                                <tr>
                                                    <td>${student.getNamebyId()}</td>
                                                    <td>${student.getDateCreate()}</td>
                                                    <td>${student.getPoint()}</td>
                                                </tr>
                                            </c:forEach>
                                        </table>
                                       
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
