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
            .popup-overlay {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.5); /* Transparent black */
                z-index: 1; /* Ensure it's on top of everything */
            }

            /* Styling for the popup itself */
            .popup {
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                background-color: white;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            }

            /* Show the popup when active */
            .popup-overlay.active {
                display: block;
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
                    <div class="col-lg-12 m-b30">
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



                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Club List</h4>
                            </div>
                            <form action="managerClub">
                                <div class="card-body">
                                    <div class="data-option">
                                        <input name="nameSearch" type="text" value="${nameSearch}" placeholder="Search name here">
                                        <div class="select-role" >
                                            <select class="no" name="typeClub" style="margin-right: 10px; height: 36px;">
                                                <option value="">Select All</option>
                                                <c:forEach var="listType" items="${listType}">
                                                    <option value="${listType}" ${listType eq option ? 'selected' : ''} >${listType}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <input type="submit" value="Search" >

                                    </div>

                                    <table class="styled-table" id="datatablesSimple" border="1px">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name Club</th>
                                                <th>Point</th>
                                                <th>Type Club</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:set var="pos" value="1"/>
                                            <c:forEach var="listclub" items="${listClub}">
                                                <tr>
                                                    <td>${pos}</td>
                                                    <td>${listclub.nameclub}</td>

                                                    <td>${listclub.point}</td>
                                                    <td>${listclub.typeClub}</td>
                                                    <c:if test="${listclub.status != 1}">
                                                        <td>Unactive</td>
                                                    </c:if>

                                                    <c:if test="${listclub.status == 1}">
                                                        <td>Active</td>
                                                    </c:if>
                                                    <td>
                                                         <a href="#" style="margin-right: 5px"><i class="fa fa-edit"> Edit</i></a>    
                                                        <a href="#" style="margin-right: 5px"><i class="fa fa-trash-o"> Unactive</i></a>
                                                    </td>
                                                    <c:set var="pos" value="${pos + 1}"/>
                                                </c:forEach>

                                            </tr>
                                        </tbody>
                                    </table>

                                </div>
                            </form>
                        </div>
                        <div class="popUp" style="width: 500px;margin: 0px auto; border: solid 1px black">
                            <form class="edit-profile m-b30">
                                <div class="row">
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Name Club</label>
                                        <div>
                                            <input class="form-control" type="text" value="">
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Points</label>
                                        <div>
                                            <input class="form-control" type="text" value="">
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Date Create</label>
                                        <div>
                                            <input class="form-control" type="text" value="">
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <label class="col-form-label">Date Modify</label>
                                        <div>
                                            <input class="form-control" type="text" value="">
                                        </div>
                                    </div>
                                    <div class="form-group col-12">
                                        <label class="col-form-label">Teacher name</label>
                                        <div>
                                            <select class="form-control">
                                                <option>Hello</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="seperator"></div>

                                    <div class="col-12">
                                        <button type="button" class="btn-secondry add-item m-r5"><i class="fa fa-fw fa-plus-circle"></i>Add Item</button>
                                        <button type="reset" class="btn">Save changes</button>
                                    </div>
                                </div>
                            </form> 
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
        <!--<script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>-->
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
