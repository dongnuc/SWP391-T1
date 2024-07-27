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
       <div class="ttr-sidebar">
    <div class="ttr-sidebar-wrapper content-scroll">
        <!-- side menu logo start -->
        <div class="ttr-sidebar-logo">
            <a href="home">
                <img alt="" src="images/logo3.png" width="122" height="27" style=" position: absolute;
                     top: 10px;
                     left: 10px;">
            </a>
            <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                    <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                    <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
            </div> -->
            <div class="ttr-sidebar-toggle-button">
                <i class="ti-arrow-left"></i>
            </div>
        </div>
        <!-- side menu logo end -->
        <!-- sidebar menu start -->
        <nav class="ttr-sidebar-navi">
            <ul>
                <li>
                    <a href="<c:url value='/ManagerDashBoardServlet' />"" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-home"></i></span>
                        <span class="ttr-label">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-book"></i></span>
                        <span class="ttr-label">Blog</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul>
                        <li>
                            <a href="<c:url value='/UploadServlet?from=Blog_PostList.jsp' />" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Blog Upload</span>
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value='/BlogPostListServlet' />" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Post List</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-book"></i></span>
                        <span class="ttr-label">Event</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul>
                        <li>
                            <a href="<c:url value='/EventUploadServlet?from=Event_ListManager.jsp' />" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Event Upload</span>
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value='/EventPostListServlet' />" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">My Event'CLB List</span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="<c:url value='/EventGiveTaskListServlet' />" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-book"></i></span>
                        <span class="ttr-label">Event Task List</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/ListMember" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-comments"></i></span>
                        <span class="ttr-label">List Participate Member</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-calendar"></i></span>
                        <span class="ttr-label">Clubs</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                        
                    </a>
                    <ul>
                        <li>
                            <a href="StudentClubServlet?id=${id}" class="ttr-material-button"><span class="ttr-label">Student in Club</span></a>
                        </li>
                        <li>
                            <a href="ClubStudentRegistrationAdminServlet?id=${id}" class="ttr-material-button"><span class="ttr-label">Club Student Registration</span></a>
                        </li>
                        <li>
                            <a href="EventClubStudentRegistrationServlet?id=${id}">Student Recruitment Event</a>
                        </li>
                    </ul>
                </li>



                <li class="ttr-seperate"></li>
            </ul>
            <!-- sidebar menu end -->
        </nav>
        <!-- sidebar menu end -->
    </div>
</div>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <form action="ManagerDashBoardServlet">
                <div class="container-fluid">
                    <div class="db-breadcrumb">
                        <h4 class="breadcrumb-title">Dashboard</h4>
                        <ul class="db-breadcrumb-list">
                            <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                            <li>Dashboard</li>
                        </ul>
                        <c:if test="${listManager.size() > 1}">
                                <div class="NameClub">
                                    <select name="idClub" onchange="return this.closest('form').submit()">
                                        <c:forEach var="listmanager" items="${listManager}">
                                            <option value="${listmanager.key}" ${listmanager.key eq idClub ? 'selected':''}>${listmanager.value}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                        </c:if>
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
                        <div class="col-lg-6 m-b30">
                            <div class="widget-box">
                                <div class="wc-title">
                                    <h4>Role Member</h4>
                                </div>
                                <div class="widget-inner">
                                    <canvas id="myPieChart" width="50%" height="10"></canvas>
                                </div>
                            </div>
                        </div>
                        <!-- Your Profile Views Chart END-->
                        <!-- Your Profile Views Chart -->
                        <div class="col-lg-6 m-b30">
                            <div class="widget-box">
                                    <div class="wc-title" style="display: flex; justify-content: space-between;">
                                        <h4>Event Overall</h4>
                                        <select name="year" onchange="return this.closest('form').submit()">
                                            <option value="2024" ${year eq "2024"?'selected':''}>2024</option>
                                            <option value="2023" ${year eq "2023"?'selected':''}>2023</option>
                                        </select>
                                    </div>
                                <div class="widget-inner">
                                    <canvas id="myLineChart" width="100%" height="100%"></canvas>
                                </div>
                            </div>
                        </div>
                        <!-- Your Profile Views Chart END-->
                        


                    </div>
                </div>
            </form>



        </main>
        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="${pageContext.request.contextPath}/assets_admin/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap/js/bootstrap.min.js"></script>
        <!--<script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap-select/bootstrap-select.min.js"></script>-->
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
        <script src='${pageContext.request.contextPath}/View/ViewManager/JsManager/ChartPieManager.js'></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script type="application/json" id="chartData">
            ${chartData}
        </script>
        <script>
// Lấy dữ liệu JSON từ servlet
                                        var chartDataJson = '${reportEvent}';
                                        console.log("JSON Data: " + chartDataJson);

// Phân tích chuỗi JSON
                                        var chartData = JSON.parse(chartDataJson);

// Tạo nhãn và dữ liệu cho biểu đồ
                                        var labels = [];
                                        var data = [];

// Chắc chắn rằng các quý đều được lấy, kể cả những quý không có dữ liệu
                                        var quarters = ['Q0', 'Q1', 'Q2', 'Q3'];
                                        for (var i = 0; i < quarters.length; i++) {
                                            var quarter = quarters[i];
                                            if (chartData.hasOwnProperty(quarter)) {
                                                labels.push(quarter);
                                                data.push(chartData[quarter]);
                                            } else {
                                                labels.push(quarter);
                                                data.push(0); // Nếu không có dữ liệu, thêm giá trị 0
                                            }
                                        }

// Kiểm tra nhãn và dữ liệu
                                        console.log("Labels: ", labels);
                                        console.log("Data: ", data);

// Vẽ biểu đồ đường
                                        var ctx = document.getElementById('myLineChart').getContext('2d');

                                        var myLineChart = new Chart(ctx, {
                                            type: 'line',
                                            data: {
                                                labels: labels,
                                                datasets: [{
                                                        label: 'Number of Events',
                                                        data: data,
                                                        backgroundColor: 'rgba(54, 162, 235, 0.2)',
                                                        borderColor: 'rgba(54, 162, 235, 1)',
                                                        borderWidth: 1,
                                                        fill: false
                                                    }]
                                            },
                                            options: {
                                                responsive: true,
                                                scales: {
                                                    x: {
                                                        beginAtZero: true,
                                                        title: {
                                                            display: true,
                                                            text: 'Quarter'
                                                        }
                                                    },
                                                    y: {
                                                        beginAtZero: true,
                                                        title: {
                                                            display: true,
                                                            text: 'Number of Events'
                                                        }
                                                    }
                                                }
                                            }
                                        });
        </script>

    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
