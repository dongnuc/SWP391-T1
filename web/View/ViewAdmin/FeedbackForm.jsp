<%-- 
    Document   : FeedbackForm
    Created on : May 21, 2024, 3:29:03 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
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
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

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

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/color/color-1.css">
         <style>
             .success-message {
                background-color: #4CAF50; /* Màu nền */
                color: white; /* Màu chữ */
                text-align: center; /* Căn giữa văn bản */
                padding: 10px; /* Khoảng cách padding */
                position: fixed; /* Vị trí cố định */
                top: 0; /* Ở phía trên cùng */
                left: 50%; /* Căn giữa theo chiều ngang */
                transform: translateX(-50%); /* Dịch chuyển về trái 50% */
                z-index: 1000; /* Độ sâu */
                width: 300px; /* Độ rộng */
                box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2); /* Hiệu ứng đổ bóng */
                border-radius: 5px; /* Bo góc */
            }

            /* CSS để ẩn thông báo ban đầu */
            .hidden {
                display: none; /* Ẩn đi */
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
                    <h4 class="breadcrumb-title">Mailbox</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="loadForm"><i class="fa fa-home"></i>Home</a></li>
                        <li>Inbox</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="email-menu-bar">
                                    <div class="compose-mail">
                                        <a href="mailbox-compose.html" class="btn btn-block">Compose</a>
                                    </div>
                                    <div class="email-menu-bar-inner">
                                        <ul>
                                            <li class="active"><a href="loadForm"><i class="fa fa-envelope-o"></i>Inbox
                                                    <c:if test="${noRead > 0}">
                                                        <span class="badge badge-success">
                                                            ${noRead}
                                                        </span></a></li>
                                                    </c:if>

                                            <li><a href=""><i class="fa fa-send-o"></i>Sent</a></li>
                                            <li><a href="formdelete"><i class="fa fa-trash-o"></i>Trash</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="mail-list-container">
                                    <div class="mail-toolbar">

                                        <div class="mail-search-bar">
                                            <form action="searchForm" style="display: flex;">
                                                <input type="text" name="search" value="${namesearch}" class="form-control"
                                                       placeholder="Search by content"
                                                       style="font-size: 16px;"/>    
                                                <input type="submit" value="Search"
                                                       style="margin-left: 10px;
                                                       padding: 0px 12px;">
                                            </form>

                                        </div>

                                        <div class="next-prev-btn">
                                            <a href="#"><i class="fa fa-angle-left"></i></a>
                                            <a href="#"><i class="fa fa-angle-right"></i></a>
                                        </div>
                                    </div>
                                    <div class="mail-box-list" id="mail-box-list">
                                        <c:forEach var="listform" items="${listForm}">
                                            <div class="mail-list-info" id="idForm${listform.idForm}">
                                                <div class="checkbox-list">
                                                    <div class="custom-control custom-checkbox checkbox-st1">
                                                        <input type="checkbox" class="custom-control-input" id="check2">
                                                        <label class="custom-control-label" for="check2"></label>
                                                    </div>
                                                </div>
                                                <div class="mail-rateing">
                                                    <span><i class="fa fa-star-o"></i></span>
                                                </div>
                                                <div class="mail-list-title">
                                                    <a href="formdetail?idForm=${listform.idForm}">
                                                        <c:if test="${listform.isRead == 0}">
                                                            <h6>${listform.fullName}</h6>
                                                        </c:if>
                                                        <c:if test="${listform.isRead == 1}">
                                                            <span>${listform.fullName}</span>
                                                        </c:if>   

                                                    </a>
                                                </div>
                                                <div class="mail-list-title-info">
                                                    <p>${listform.titleForm}</p>
                                                </div>
                                                <div class="mail-list-time">
                                                    <span>${listform.dateCreate}</span>
                                                </div>
                                                <ul class="mailbox-toolbar">
                                                    <li data-toggle="tooltip" title="Delete"><a onclick="removeForm(${listform.idForm})"><i class="fa fa-trash-o"></i></a></li>
                                                    <li data-toggle="tooltip" title="Archive"><i class="fa fa-arrow-down"></i></li>
                                                    <li data-toggle="tooltip" title="Snooze"><i class="fa fa-clock-o"></i></li>
                                                    <li data-toggle="tooltip" title="Mark as unread"><i class="fa fa-envelope-open"></i></li>
                                                </ul>
                                            </div>
                                        </c:forEach>


                                    </div>
                                </div>
                            </div>
                        </div> 
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
            <div id="success-message" class="success-message hidden">
                Delete successfully!
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
        <!--<script src='assets/vendors/switcher/switcher.js'></script>-->
        <script>
                                                        $(document).ready(function () {
                                                            $('[data-toggle="tooltip"]').tooltip();
                                                        });



                                                        function removeForm(idForm) {
                                                            var element = document.getElementById("idForm" + idForm);
                                                            $.ajax({
                                                                url: "/SWP391/removeForm",
                                                                type: "get", //send it through get method
                                                                data: {
                                                                    idForm: idForm
                                                                },
                                                                success: function (response) {
                                                                    $('#success-message').removeClass('hidden');
                                                                    setTimeout(function () {
                                                                        $('#success-message').addClass('hidden');
                                                                    }, 1000);
                                                                    element.remove();
                                                                },
                                                                error: function (xhr) {
                                                                    //Do Something to handle error
                                                                }
                                                            });
                                                        }

        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>