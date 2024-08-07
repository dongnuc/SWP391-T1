<%-- 
    Document   : MailDetail
    Created on : May 21, 2024, 3:42:44 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox-read.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:45 GMT -->
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

        <!-- SHORTCODES ============================================= -->
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
                    <h4 class="breadcrumb-title">Mail Read</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>Mail Read</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="email-wrapper">
                                <div class="email-menu-bar">
                                    <div class="email-menu-bar-inner">
                                        <ul>
                                            <li class=""><a href="loadForm"><i class="fa fa-envelope-o"></i>Inbox
                                                    <c:if test="${noRead > 0}">
                                                        <span class="badge badge-success">
                                                            ${noRead}
                                                        </span></a></li>
                                                    </c:if>
                                            <li><a href="mailbox.html"><i class="fa fa-send-o"></i>Sent</a></li>
                                            <li><a href="formdelete"><i class="fa fa-trash-o"></i>Trash</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="mail-list-container">
                                    <div class="mail-toolbar next-prev-btn" >                                      
                                        <a href="loadForm"><i class="fa fa-angle-left"></i></a>                           
                                    </div>
                                    <div class="mailbox-view">
                                        <div class="mailbox-view-title">
                                            <h5 class="send-mail-title">${formDetail.titleForm}</h5>
                                        </div>
                                        <div id="send-mail-details" class="send-mail-details">
                                            <div class="d-flex">
                                                <div class="send-mail-user">
                                                    <div class="send-mail-user-pic">
                                                        <img src="assets/images/testimonials/pic3.jpg" alt="">
                                                    </div>
                                                    <div class="send-mail-user-info">
                                                        <h4>${formDetail.fullName}</h4>
                                                        <h5>From: ${formDetail.email}</h5>
                                                    </div>
                                                </div>
                                                <div class="ml-auto send-mail-full-info">
                                                    <div class="time"><span>${formDetail.dateCreate}</span></div>
<!--                                                    <div class="dropdown all-msg-toolbar ml-auto">
                                                        <span class="btn btn-info-icon" data-toggle="dropdown"><i class="fa fa-ellipsis-v"></i></span>
                                                        <ul class="dropdown-menu dropdown-menu-right">
                                                            <c:if test="${formDetail.status == 1}">
                                                                <li><a href="#"><i class="fa fa-trash-o"></i> Delete</a></li>
                                                                </c:if>
                                                                <c:if test="${formDetail.status == 0}">
                                                                <li><a href="#"><i class="fa fa-trash-o"></i> Recover</a></li>
                                                                </c:if>
                                                        </ul>
                                                    </div>-->
                                                </div>
                                            </div>
                                            <div class="read-content-body">
                                                <p>${formDetail.contentForm}</p>                                                
                                            </div>

                                            <div class="read-content-body">
                                                <p>Contact other: ${formDetail.phoneNumber}</p>                                                
                                            </div>
                                        </div>
                                        <c:if test="${listReply.size() > 0}">
                                            <c:forEach var="listReplyF" items="${listReply}">
                                                <div id="send-mail-details" class="send-mail-details"
                                                     style="border-top: 1px solid black">
                                                    <div style="margin-bottom: 10px"></div>
                                                    <div class="d-flex">
                                                        <div class="send-mail-user">
                                                            <div class="send-mail-user-pic">
                                                                <img src="assets/images/testimonials/pic3.jpg" alt="">
                                                            </div>
                                                            <div class="send-mail-user-info">
                                                                <h4>${sessionScope.curruser.name}</h4>
                                                                <h5>From: ${sessionScope.curruser.email}</h5>
                                                            </div>
                                                        </div>
                                                        <div class="ml-auto send-mail-full-info">
                                                            <div class="time"><span>${listReplyF.dateCreate}</span></div>
<!--                                                            <div class="dropdown all-msg-toolbar ml-auto">
                                                                <span class="btn btn-info-icon" data-toggle="dropdown"><i class="fa fa-ellipsis-v"></i></span>
                                                                <ul class="dropdown-menu dropdown-menu-right">
                                                                    <c:if test="${formDetail.status == 1}">
                                                                        <li><a href="#"><i class="fa fa-trash-o"></i> Delete</a></li>
                                                                        </c:if>
                                                                        <c:if test="${formDetail.status == 0}">
                                                                        <li><a href="#"><i class="fa fa-trash-o"></i> Recover</a></li>
                                                                        </c:if>
                                                                </ul>
                                                            </div>-->
                                                        </div>
                                                    </div>
                                                    <div class="read-content-body">
                                                        <p>${listReplyF.contentForm}</p>                                                
                                                    </div>

                                                </div>
                                            </c:forEach>
                                        </c:if>

                                        <c:if test="${formDetail.status == 1}">
                                            <div class="form-group">
                                                <form action="replyForm" method="get">
                                                    <h6>Reply Message</h6>                                                      
                                                    <div class="m-b15">
                                                        <textarea id="replyForm" name="contentReply" class="form-control"> </textarea>
                                                        <p class="error-message">${errorReply}</p>
                                                    </div>
                                                    <input type="hidden" name="idForm" value="${formDetail.idForm}">
                                                    <input  type="submit" class="btn" value="Reply Now">  
                                                </form>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div> 
                    </div>
                    <!-- Your Profile Views Chart END-->
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
        <script src='${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/switcher/switcher.js'></script>
        <script>
            $(document).ready(function () {
                $('[data-toggle="tooltip"]').tooltip();
            });

        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox-read.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:45 GMT -->
</html>