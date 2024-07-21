<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:useBean id="currentDate" class="java.util.Date" scope="page" />
<!DOCTYPE html>
<html lang="en">
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
        <link rel="icon" href="${pageContext.request.contextPath}/images_t/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/images_t/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Event </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="${pageContext.request.contextPath}/js_t/html5shiv.min.js"></script>
        <script src="${pageContext.request.contextPath}/js_t/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css_t/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css_t/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css_t/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css_t/style.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css_t/color/color-1.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

        <style>
            .event-type-list {
                text-align: left;
                color: red;
            }
            .event-type-list a {
                display: block;
                margin-bottom: 5px;
                text-decoration: none; /* Optional: to remove underline from links */
            }
            .toast {
                display: flex !important;
                align-items: center !important;
                background-color: #fff !important;
                border-radius: 2px !important;
                padding: 20px 0 !important;
                min-width: 400px !important;
                max-width: 450px !important;
                border-left: 4px solid !important;
                box-shadow: 0 5px 8px rgba(0, 0, 0, 0.08) !important;
                transition: all linear 0.3s !important;
                background: greenyellow !important;
                z-index: 1001 !important;
                animation: slideInLeft 0.3s ease forwards, fadeOut 0.3s ease forwards 3s;
            }
            .toast_icon {
                font-size: 24px;
                padding: 0 16px;
            }
            .toast_body {
                color: white !important;

            }
            #toast {
                position: fixed;
                top: 124px;
                right: 32px;
                z-index: 1001 !important;

            }
            @keyframes slideInLeft {
                from {
                    opacity: 0;
                    transform: translateX(calc(100% + 32px));
                }
                to {
                    opacity: 1;
                    transform: translateX(0);
                }
            }
            @keyframes fadeOut {
                to {
                    opacity: 0;
                }
            }
        </style>
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
            
        </script>
        <%
        String check = (String) request.getAttribute("showtoast");
        %>
    </head>
    <body id="bg">
        <div id="toast">


        </div>
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <!-- Header Top ==== -->
            <%@ include file="Header.jsp" %>
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner2.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Events</h1>
                        </div>
                    </div>
                </div>

                <!-- contact area -->
                <div class="container">
                    <div class="row">
                        <div class="feature-filters clearfix center m-b40 col-md-3 " style="margin-top:75px">
                            <form action="EventSearchAllServlet" method="GET" style="margin-bottom: 20px">
                                <input type="hidden" name="from" value="Event_List.jsp">
                                <input type="text" name="name" class="form-control" />
                                <input type="submit" value="Search" class="btn btn-primary" style="margin-left:-162px "/>
                            </form>
                            <div class="event-type-list">
                                <p style="color: red">Event Type</p>
                                <a href="<c:url value='/EventSerlet?from=Event_List.jsp' />"><span>All</span></a><br>
                                <c:forEach var="eventType" items="${eventTypeList}">
                                    <a href="${pageContext.request.contextPath}/EventTypeServlet?idEventType=${eventType.idSetting}&from=Event_List.jsp"><span>${eventType.valueSetting}</span></a><br>
                                        </c:forEach>
                            </div>
                        </div>
                        <div class="content-block col-md-9">
                            <div style="margin-top: 75px ; margin-bottom: -45px; margin-left: 15px;">
                                <c:forEach var="studentClub" items="${StudentClubList}">
                                    <c:if test="${studentClub.leader == 1 and studentClub.status == 1 and not printed}">
                                        <div class="widget_tag_cloud">
                                            <div class="tagcloud">
                                                <a href="<c:url value='/EventUploadServlet?from=Event_List.jsp' />"> Upload New Event</a>
                                            </div>
                                        </div>
                                        <c:set var="printed" value="true" />
                                    </c:if>
                                </c:forEach>
                            </div>
                            <div class="section-area section-sp1 gallery-bx">
                                <div class="container">
                                    <div class="clearfix">
                                        <c:if test="${not empty errorMessage}">
                                            <div class="alert alert-danger">${errorMessage}</div>
                                        </c:if>
                                        <ul id="masonry" class="ttr-gallery-listing magnific-image row">
                                            <c:forEach var="event" items="${eventList}">
                                                <c:if test="${event.status != 0}">
                                                    <c:set var="dateStart" value="${event.dateStart}" />
                                                    <c:set var="dateEnd" value="${event.enddate}" />
                                                    <li class="action-card col-lg-6 col-md-6 col-sm-12 happening">
                                                        <div class="event-bx m-b30">
                                                            <div class="action-box">
                                                                <a href="<c:url value='/EventDetailServlet?idEvent=${event.idEvent}' />">
                                                                    <img src="<c:url value='/${event.image}' />" alt="Img">
                                                                </a>
                                                            </div>
                                                            <div class="info-bx d-flex">
                                                                <div style="width: 450px; margin-right:15px ;">
                                                                    <div class="event-time">
                                                                        <div class="event-date"><fmt:formatDate value="${dateStart}" pattern="dd" /></div>
                                                                        <div class="event-month"><fmt:formatDate value="${dateStart}" pattern="MMMM yyyy" /></div>
                                                                        <div class="event-month"><fmt:formatDate value="${dateStart}" pattern="HH:mm" /> to 
                                                                            <fmt:formatDate value="${dateEnd}" pattern="HH:mm" />
                                                                        </div> 
                                                                    </div>
                                                                    <div style="margin-top: 10px">
                                                                        <a href="<c:url value='/EventDetailServlet?idEvent=${event.idEvent}' />">
                                                                            <i class="fa fa-map-marker"></i>
                                                                            <c:out value="${event.address}" />
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                                <div class="event-info">
                                                                    <h4 class="event-title">
                                                                        <a href="<c:url value='/EventDetailServlet?idEvent=${event.idEvent}' />">
                                                                            <c:out value="${event.nameEvent}" />
                                                                        </a>
                                                                    </h4>
                                                                    <ul class="media-post">
                                                                        <li>
                                                                            <a href="<c:url value='/EventDetailServlet?idEvent=${event.idEvent}' />">
                                                                                <i class="fa fa-map-marker"></i>
                                                                                <c:out value="${clubDao.getClubNameByID(event.idClub)}" />
                                                                            </a>
                                                                        </li>
                                                                    </ul>
                                                                    <a href="<c:url value='/EventDetailServlet?idEvent=${event.idEvent}' />">
                                                                        <c:out value="${event.description}" />

                                                                    </a>


                                                                    <c:if test="${event.dateStart.time > currentDate.time}">
                                                                        <a href="<c:url value='/RegisterEvent?idEvent=${event.idEvent}&name=${event.nameEvent}' /> " style="color: red">Register Here</a>
                                                                    </c:if>  

                                                                </div>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>

                                        <div class="pagination-bx rounded-sm gray clearfix">
                                            <ul class="pagination">
                                                <c:if test="${currentPage > 1}">
                                                    <li class="previous"><a href="?page=${currentPage - 1}&idEventType=${idEventType}&from=${from}&name=${name}"><i class="ti-arrow-left"></i> Prev</a></li>
                                                    </c:if>
                                                    <c:forEach begin="1" end="${noOfPages}" var="i">
                                                    <li class="${currentPage == i ? 'active' : ''}"><a href="?page=${i}&idEventType=${idEventType}&from=${from}&name=${name}">${i}</a></li>
                                                    </c:forEach>
                                                    <c:if test="${currentPage < noOfPages}">
                                                    <li class="next"><a href="?page=${currentPage + 1}&idEventType=${idEventType}&from=${from}&name=${name}">Next <i class="ti-arrow-right"></i></a></li>
                                                        </c:if>
                                            </ul>
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
            <footer>
                <div class="footer-top">
                    <div class="pt-exebar">
                        <div class="container">
                            <div class="d-flex align-items-stretch">
                                <div class="pt-logo mr-auto">
                                    <a href="index.html"><img src="${pageContext.request.contextPath}/images_t/logo-white.png" alt=""/></a>
                                </div>
                                <div class="pt-social-link">
                                    <ul class="list-inline m-a0">
                                        <li><a href="#" class="btn-link"><i class="fa fa-facebook"></i></a></li>
                                        <li><a href="#" class="btn-link"><i class="fa fa-twitter"></i></a></li>
                                        <li><a href="#" class="btn-link"><i class="fa fa-linkedin"></i></a></li>
                                        <li><a href="#" class="btn-link"><i class="fa fa-google-plus"></i></a></li>
                                    </ul>
                                </div>
                                <div class="pt-btn-join">
                                    <a href="#" class="btn ">Join Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 col-md-12 col-sm-12 footer-col-4">
                                <div class="widget">
                                    <h5 class="footer-title">Sign Up For A Newsletter</h5>
                                    <p class="text-capitalize m-b20">Weekly Breaking news analysis and cutting edge advices on job searching.</p>
                                    <div class="subscribe-form m-b20">
                                        <form class="subscription-form" action="http://educhamp.themetrades.com/demo/assets/script/mailchamp.php" method="post">
                                            <div class="ajax-message"></div>
                                            <div class="input-group">
                                                <input name="email" required="required"  class="form-control" placeholder="Your Email Address" type="email">
                                                <span class="input-group-btn">
                                                    <button name="submit" value="Submit" type="submit" class="btn"><i class="fa fa-arrow-right"></i></button>
                                                </span> 
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-5 col-md-7 col-sm-12">
                                <div class="row">
                                    <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                        <div class="widget footer_widget">
                                            <h5 class="footer-title">Company</h5>
                                            <ul>
                                                <li><a href="index.html">Home</a></li>
                                                <li><a href="about-1.html">About</a></li>
                                                <li><a href="faq-1.html">FAQs</a></li>
                                                <li><a href="contact-1.html">Contact</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                        <div class="widget footer_widget">
                                            <h5 class="footer-title">Get In Touch</h5>
                                            <ul>
                                                <li><a href="http://educhamp.themetrades.com/admin/index.html">Dashboard</a></li>
                                                <li><a href="blog-classic-grid.html">Blog</a></li>
                                                <li><a href="portfolio.html">Portfolio</a></li>
                                                <li><a href="event.html">Event</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="col-4 col-lg-4 col-md-4 col-sm-4">
                                        <div class="widget footer_widget">
                                            <h5 class="footer-title">Courses</h5>
                                            <ul>
                                                <li><a href="courses.html">Courses</a></li>
                                                <li><a href="courses-details.html">Details</a></li>
                                                <li><a href="membership.html">Membership</a></li>
                                                <li><a href="profile.html">Profile</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-lg-3 col-md-5 col-sm-12 footer-col-4">
                                <div class="widget widget_gallery gallery-grid-4">
                                    <h5 class="footer-title">Our Gallery</h5>
                                    <ul class="magnific-image">
                                        <li><a href="${pageContext.request.contextPath}/images_t/gallery/pic1.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic1.jpg" alt=""></a></li>
                                        <li><a href="${pageContext.request.contextPath}/images_t/gallery/pic2.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic2.jpg" alt=""></a></li>
                                        <li><a href="${pageContext.request.contextPath}/images_t/gallery/pic3.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic3.jpg" alt=""></a></li>
                                        <li><a href="${pageContext.request.contextPath}/images_t/gallery/pic4.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic4.jpg" alt=""></a></li>
                                        <li><a href="${pageContext.request.contextPath}/images_t/gallery/pic5.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic5.jpg" alt=""></a></li>
                                        <li><a href="${pageContext.request.contextPath}/images_t/gallery/pic6.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic6.jpg" alt=""></a></li>
                                        <li><a href="${pageContext.request.contextPath}/images_t/gallery/pic7.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic7.jpg" alt=""></a></li>
                                        <li><a href="${pageContext.request.contextPath}/images_t/gallery/pic8.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic8.jpg" alt=""></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-bottom">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 col-md-12 col-sm-12 text-center"> <a target="_blank" href="https://www.templateshub.net">Templates Hub</a></div>
                        </div>
                    </div>
                </div>
            </footer>
            <!-- Footer END ==== -->
            <button class="back-to-top fa fa-chevron-up" ></button>
        </div>
        <!-- External JavaScripts -->
        <script src="${pageContext.request.contextPath}/js_t/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/bootstrap/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/counter/waypoints-min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/counter/counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/masonry/masonry.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/masonry/filter.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/owl-carousel/owl.carousel.js"></script>
        <script src="${pageContext.request.contextPath}/js_t/functions.js"></script>
        <script src="${pageContext.request.contextPath}/js_t/contact.js"></script>
        <script>
        window.onload = function () {
            var check = '<%= check %>';
            if (check === 'true') {
                const toast = document.getElementById('toast');
                toast.innerHTML = `
                    <div class="toast">
                        <div class="toast_icon">
                            <i class="fa-solid fa-check"></i>
                        </div>
                        <div class="toast_body">
                            <h3> Register Event Success </h3>
                        </div>
                    </div>
                `;

                setTimeout(() => {
                    const toastElement = document.querySelector('.toast');
                    toastElement.classList.add('show');
                }, 100);
            }
        }

        </script>
    </body>

</html>
