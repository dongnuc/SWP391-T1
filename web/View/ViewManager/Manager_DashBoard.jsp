<%-- 
    Document   : Manager_DashBoard
    Created on : Jul 5, 2024, 2:11:27 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets_admin/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Dash Board Manager</title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="${pageContext.request.contextPath}/assets_admin/js/html5shiv.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/assets.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/style.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/color/color-1.css">

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="HeaderAdmin.jsp"/>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <jsp:include page="Sidebar.jsp"/>
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
                                    Memeber
                                </h4>
                                <span class="wc-des">
                                    All Customs Value
                                </span>
                                <span class="wc-stats">
                                    <span class="counter">${numberMemeber}</span>
                                </span>		
                                <div class="wc-item">
                                    <a class="" href="listaccount" style="color: #F0F0F0;">View All</a>
                                </div>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg2">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    Blogs
                                </h4>
                                <span class="wc-des">
                                    All Customs Value
                                </span>
                                <span class="wc-stats">
                                    <span class="counter">${numberBlog}</span>
                                </span>		
                                <div class="wc-item">
                                    <a class="" href="BlogPostListServlet" style="color: #F0F0F0;">View All</a>
                                </div>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg3">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    Event
                                </h4>
                                <span class="wc-des">
                                    All Customs Value
                                </span>
                                <span class="wc-stats">
                                    <span class="counter">${numberEvent}</span>
                                </span>		
                                <div class="wc-item">
                                    <a class="" href="EventPostListServlet" style="color: #F0F0F0;">View All</a>
                                </div>
                            </div>				      
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3 col-xl-3 col-sm-6 col-12">
                        <div class="widget-card widget-bg4">					 
                            <div class="wc-item">
                                <h4 class="wc-title">
                                    Form Feedback
                                </h4>
                                <span class="wc-des">
                                    All Customs Value
                                </span>
                                <span class="wc-stats">
                                    <span class="counter">${numberForm}</span>
                                </span>		
                                <div class="wc-item">
                                    <a class="" href="loadForm" style="color: #F0F0F0;">View All</a>
                                </div>
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
                                <h4>Role Member</h4>
                            </div>
                            <div class="widget-inner">
                                <canvas id="myPieChart" width="100" height="45"></canvas>
                            </div>
                        </div>
                    </div>
                    <!-- Your Profile Views Chart END-->

                    <div class="col-lg-4 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>New Users</h4>
                            </div>
                            <div class="widget-inner">
                                <div class="new-user-list">
                                    <ul>
                                        <c:forEach var="listAcc" items="${listAcc}">
                                            <li>
                                                <span class="new-users-pic">
                                                    <img src="${pageContext.request.contextPath}/assets_admin/images/testimonials/pic1.jpg" alt=""/>
                                                </span>
                                                <span class="new-users-text">
                                                    <a href="#" class="new-users-name">${listAcc.name}</a>
                                                    <span class="new-users-info">${listAcc.roleClub}</span>
                                                </span>
                                                <span class="new-users-btn">
                                                    <a href="#" class="btn button-sm outline">Follow</a>
                                                </span>
                                            </li>
                                        </c:forEach>


                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                   

                </div>
            </div>
        </main>
        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="${pageContext.request.contextPath}/assets_admin/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/magnific-popup/magnific-popup.js"></script>
        <!--<script src="${pageContext.request.contextPath}/assets_admin/vendors/counter/waypoints-min.js"></script>-->
        <!--<script src="${pageContext.request.contextPath}/assets_admin/vendors/counter/counterup.min.js"></script>-->
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/masonry/masonry.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/masonry/filter.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='${pageContext.request.contextPath}/assets_admin/vendors/scroll/scrollbar.min.js'></script>
        <script src="${pageContext.request.contextPath}/assets_admin/js/functions.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/chart/chart.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/js/admin.js"></script>
        <script src='${pageContext.request.contextPath}/assets_admin/vendors/calendar/moment.min.js'></script>
        <script src='${pageContext.request.contextPath}/assets_admin/vendors/calendar/fullcalendar.js'></script>
        <script src='${pageContext.request.contextPath}/assets_admin/vendors/switcher/switcher.js'></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>
            var chartDataJson = '${chartData}';
            var chartData = JSON.parse(chartDataJson);

            // Tạo nhãn và dữ liệu cho biểu đồ
            var labels = [];
            var data = [];

            for (var key in chartData) {
                if (chartData.hasOwnProperty(key)) {
                    labels.push(key);
                    data.push(chartData[key]);
                }
            }
            console.log(data)
            // Vẽ biểu đồ tròn
            var ctx = document.getElementById('myPieChart').getContext('2d');

            var myPieChart = new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: labels,
                    datasets: [{
                            data: data,
                            backgroundColor: [
                                'rgba(255, 99, 132, 0.2)',
                                'rgba(54, 162, 235, 0.2)',
                                'rgba(255, 206, 86, 0.2)',
                                'rgba(75, 192, 192, 0.2)',
                                'rgba(153, 102, 255, 0.2)',
                                'rgba(255, 159, 64, 0.2)'
                            ],
                            borderColor: [
                                'rgba(255, 99, 132, 1)',
                                'rgba(54, 162, 235, 1)',
                                'rgba(255, 206, 86, 1)',
                                'rgba(75, 192, 192, 1)',
                                'rgba(153, 102, 255, 1)',
                                'rgba(255, 159, 64, 1)'
                            ],
                            borderWidth: 1
                        }]
                },
                options: {
                    responsive: true
                }
            });
        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
