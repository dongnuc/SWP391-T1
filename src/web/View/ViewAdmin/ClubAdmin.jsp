<%-- 
    Document   : Dashboard
    Created on : May 20, 2024, 10:52:00 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
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
        <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/ClubAdmin.css">-->
        <style>
            /* Reset một số thuộc tính mặc định của bảng */
            table {
                border-collapse: collapse;
                width: 100%;
                margin: 20px 0;
                font-size: 18px;
                text-align: left;
            }

            /* Kiểu dáng cho bảng */
            .styled-table {
                border: 1px solid #dddddd;
                font-family: Arial, sans-serif;
                border-radius: 5px;
                overflow: hidden;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
            }

            /* Kiểu dáng cho hàng đầu tiên (thead) */
            .styled-table thead tr {
                background-color: #009879;
                color: #ffffff;
                text-align: left;
                font-weight: bold;
            }

            /* Kiểu dáng cho các hàng dữ liệu (tbody) */
            .styled-table tbody tr {
                border-bottom: 1px solid #dddddd;
            }

            .styled-table tbody tr:nth-of-type(even) {
                background-color: #f3f3f3;
            }

            .styled-table tbody tr:last-of-type {
                border-bottom: 2px solid #009879;
            }

            /* Thêm hiệu ứng hover */
            .styled-table tbody tr:hover {
                background-color: #f1f1f1;
            }

            /* Kiểu dáng cho các ô (th, td) */
            .styled-table th,
            .styled-table td {
                padding: 12px 15px;
            }

            .data-option {
                display: flex;
                align-items: center; /* Căn giữa các phần tử theo chiều dọc */
            }

            .data-option input[type="text"] {
                height: 36px;
                margin-right: 10px; /* Khoảng cách giữa input và select */
                padding: 5px;
                font-size: 14px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .select-role select {
                padding: 5px;
                font-size: 14px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
        </style>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="Navigation.jsp"/>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <jsp:include page="LeftSideBar.jsp"/>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">Dashboard</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Dashboard</li>
                    </ul>
                </div>	
                <!-- Card -->
                <div class="row">
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg1">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    Total Frofit
                                </h4>
                                <span class="wc-des">
                                    All Customs Value
                                </span>
                                <span class="wc-stats">
                                    $<span class="counter">18</span>M 
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: 78%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Change
                                    </span>
                                    <span class="wc-number ml-auto">
                                        78%
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg2">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    New Feedbacks
                                </h4>
                                <span class="wc-des">
                                    Customer Review
                                </span>
                                <span class="wc-stats counter">
                                    120 
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: 88%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Change
                                    </span>
                                    <span class="wc-number ml-auto">
                                        88%
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg3">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    New Orders 
                                </h4>
                                <span class="wc-des">
                                    Fresh Order Amount 
                                </span>
                                <span class="wc-stats counter">
                                    772 
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: 65%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Change
                                    </span>
                                    <span class="wc-number ml-auto">
                                        65%
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg4">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    New Users 
                                </h4>
                                <span class="wc-des">
                                    Joined New User
                                </span>
                                <span class="wc-stats counter">
                                    350 
                                </span>		
                                <div class="progress wc-progress">
                                    <div class="progress-bar" role="progressbar" style="width: 90%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                                <span class="wc-progress-bx">
                                    <span class="wc-change">
                                        Change
                                    </span>
                                    <span class="wc-number ml-auto">
                                        90%
                                    </span>
                                </span>
                            </div>				      
                        </div>
                    </div>
                </div>
                <!-- Card END -->
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-8 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Your Profile Views</h4>
                            </div>
                            <div class="widget-inner">
                                <canvas id="chart" width="100" height="45"></canvas>
                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->
                    <div class="col-lg-4 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Notifications</h4>
                            </div>
                            <div class="widget-inner">
                                <div class="noti-box-list">
                                    <ul>
                                        <li>
                                            <span class="notification-icon dashbg-gray">
                                                <i class="fa fa-check"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Sneha Jogi</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 02:14</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-yellow">
                                                <i class="fa fa-shopping-cart"></i>
                                            </span>
                                            <span class="notification-text">
                                                <a href="#">Your order is placed</a> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 7 Min</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-red">
                                                <i class="fa fa-bullhorn"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Your item is shipped</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 2 May</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-green">
                                                <i class="fa fa-comments-o"></i>
                                            </span>
                                            <span class="notification-text">
                                                <a href="#">Sneha Jogi</a> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 14 July</span>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="notification-icon dashbg-primary">
                                                <i class="fa fa-file-word-o"></i>
                                            </span>
                                            <span class="notification-text">
                                                <span>Sneha Jogi</span> sent you a message.
                                            </span>
                                            <span class="notification-time">
                                                <a href="#" class="fa fa-close"></a>
                                                <span> 15 Min</span>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>New Users</h4>
                            </div>
                            <div class="widget-inner">
                                <div class="new-user-list">
                                    <ul>
                                        <li>
                                            <span class="new-users-pic">
                                                <img src="assets/images/testimonials/pic1.jpg" alt=""/>
                                            </span>
                                            <span class="new-users-text">
                                                <a href="#" class="new-users-name">Anna Strong </a>
                                                <span class="new-users-info">Visual Designer,Google Inc </span>
                                            </span>
                                            <span class="new-users-btn">
                                                <a href="#" class="btn button-sm outline">Follow</a>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="new-users-pic">
                                                <img src="assets/images/testimonials/pic2.jpg" alt=""/>
                                            </span>
                                            <span class="new-users-text">
                                                <a href="#" class="new-users-name"> Milano Esco </a>
                                                <span class="new-users-info">Product Designer, Apple Inc </span>
                                            </span>
                                            <span class="new-users-btn">
                                                <a href="#" class="btn button-sm outline">Follow</a>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="new-users-pic">
                                                <img src="assets/images/testimonials/pic1.jpg" alt=""/>
                                            </span>
                                            <span class="new-users-text">
                                                <a href="#" class="new-users-name">Nick Bold  </a>
                                                <span class="new-users-info">Web Developer, Facebook Inc </span>
                                            </span>
                                            <span class="new-users-btn">
                                                <a href="#" class="btn button-sm outline">Follow</a>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="new-users-pic">
                                                <img src="assets/images/testimonials/pic2.jpg" alt=""/>
                                            </span>
                                            <span class="new-users-text">
                                                <a href="#" class="new-users-name">Wiltor Delton </a>
                                                <span class="new-users-info">Project Manager, Amazon Inc </span>
                                            </span>
                                            <span class="new-users-btn">
                                                <a href="#" class="btn button-sm outline">Follow</a>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="new-users-pic">
                                                <img src="assets/images/testimonials/pic3.jpg" alt=""/>
                                            </span>
                                            <span class="new-users-text">
                                                <a href="#" class="new-users-name">Nick Stone </a>
                                                <span class="new-users-info">Project Manager, Amazon Inc  </span>
                                            </span>
                                            <span class="new-users-btn">
                                                <a href="#" class="btn button-sm outline">Follow</a>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Orders</h4>
                            </div>
                            <div class="widget-inner">
                                <div class="orders-list">
                                    <ul>
                                        <li>
                                            <span class="orders-title">
                                                <a href="#" class="orders-title-name">Anna Strong </a>
                                                <span class="orders-info">Order #02357 | Date 12/08/2019</span>
                                            </span>
                                            <span class="orders-btn">
                                                <a href="#" class="btn button-sm red">Unpaid</a>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="orders-title">
                                                <a href="#" class="orders-title-name">Revenue</a>
                                                <span class="orders-info">Order #02357 | Date 12/08/2019</span>
                                            </span>
                                            <span class="orders-btn">
                                                <a href="#" class="btn button-sm red">Unpaid</a>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="orders-title">
                                                <a href="#" class="orders-title-name">Anna Strong </a>
                                                <span class="orders-info">Order #02357 | Date 12/08/2019</span>
                                            </span>
                                            <span class="orders-btn">
                                                <a href="#" class="btn button-sm green">Paid</a>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="orders-title">
                                                <a href="#" class="orders-title-name">Revenue</a>
                                                <span class="orders-info">Order #02357 | Date 12/08/2019</span>
                                            </span>
                                            <span class="orders-btn">
                                                <a href="#" class="btn button-sm green">Paid</a>
                                            </span>
                                        </li>
                                        <li>
                                            <span class="orders-title">
                                                <a href="#" class="orders-title-name">Anna Strong </a>
                                                <span class="orders-info">Order #02357 | Date 12/08/2019</span>
                                            </span>
                                            <span class="orders-btn">
                                                <a href="#" class="btn button-sm green">Paid</a>
                                            </span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Student Club</h4>
                            </div>

                            <div class="card-body">
                                <div class="data-option">
                                    <input type="text" placeholder="Search name here">
                                    <div class="select-role">
                                        <select class="no">
                                            <option>Role</option>
                                            <c:forEach var="roleList" items="${listRole}">
                                                <option>${roleList.nameRole}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <table class="styled-table" id="datatablesSimple" border="1px">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Name</th>
                                            <th>Gender</th>
                                            <th>Day of birth</th>
                                            <th>Point</th>
                                            <th>Role</th>
                                            <th>Status</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="listacc" items="${listAcc}">
                                            <tr>
                                                <td>1</td>
                                                <td>${listacc.name}</td>
                                                <c:if test="${listacc.gender != 1}">
                                                    <td>Female</td>
                                                </c:if>

                                                <c:if test="${listacc.gender == 1}">
                                                    <td>Male</td>
                                                </c:if>
                                                <td>${listacc.date}</td>
                                                <td>${listacc.points}</td>
                                                <td>Member</td>

                                                <c:if test="${listacc.status != 1}">
                                                    <td>Unactive</td>
                                                </c:if>

                                                <c:if test="${listacc.status == 1}">
                                                    <td>Active</td>
                                                </c:if>
                                                <td>
                                                    <a href="#" style="margin-right: 5px"><i class="fa fa-edit"> Edit</i></a>
                                                    <a href="#" style="margin-right: 5px"><i class="fa fa-trash-o"> Remove</i></a>
                                                </td>
                                            </c:forEach>

                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/counter/waypoints-min.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/counter/counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/masonry/masonry.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/masonry/filter.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/scroll/scrollbar.min.js'></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/js/functions.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/chart/chart.min.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/js/admin.js"></script>
        <script src='${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/calendar/moment.min.js'></script>
        <script src='${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/calendar/fullcalendar.js'></script>
        <script src='${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/switcher/switcher.js'></script>
        <!--        <script>
                    window.addEventListener('DOMContentLoaded', event => {
                        // Simple-DataTables
                        // https://github.com/fiduswriter/Simple-DataTables/wiki
        
                        const datatablesSimple = document.getElementById('datatablesSimple');
                        if (datatablesSimple) {
                            new simpleDatatables.DataTable(datatablesSimple);
                        }
                    });
                    
                </script>
        -->
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
