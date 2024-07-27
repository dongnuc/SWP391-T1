<%-- 
    Document   : Blog_List
    Created on : Jun 5, 2024, 2:09:04 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <link rel="icon"  href="${pageContext.request.contextPath}/images_t/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon"  href="${pageContext.request.contextPath}/images_t/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Blog List </title>

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
    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <%@ include file="Header.jsp" %>
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white" >
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(assets/images/banner/banner5.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Blog List </h1>
                        </div>
                    </div>
                </div>

                <!-- contact area -->
                <div class="content-block" style="margin-top: -50px;">
                    <div class="section-area section-sp1">
                        <div class="container">

                            <div class="row">
                                <!-- Left part start -->
                                <div class="col-lg-8">
                                    <c:if test="${empty errorMessage}">
                                        <c:forEach var="showBlog" items="${BlogByIDList}">
                                            <c:set var="canSeeBlog" value="${showBlog.show == 1}" />
                                            <c:if test="${not canSeeBlog and not empty curruser}">
                                                <c:forEach var="studentClub" items="${StudentClubList}">
                                                    <c:if test="${studentClub.idClub == showBlog.idClub}">
                                                        <c:set var="canSeeBlog" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                            </c:if>
                                            <c:if test="${canSeeBlog and showBlog.status == 1}">
                                                <div class="blog-post blog-md clearfix">
                                                    <div class="ttr-post-media"> 
                                                        <a href="${pageContext.request.contextPath}/UploadContentBlog?idBlog=${showBlog.idBlog}">
                                                            <img src="${pageContext.request.contextPath}/${showBlog.image}" alt="Uploaded Image">
                                                        </a>
                                                    </div>
                                                    <div class="ttr-post-info">
                                                        <ul class="media-post">
                                                            <li>
                                                                <a href="${pageContext.request.contextPath}/UploadContentBlog?idBlog=${showBlog.idBlog}">
                                                                    <i class="fa fa-calendar"></i>${showBlog.dateCreate}
                                                                </a>
                                                            </li>
                                                            <li>
                                                                <a href="${pageContext.request.contextPath}/UploadContentBlog?idBlog=${showBlog.idBlog}">
                                                                    <i class="fa fa-user"></i>${clubDAO.getClubNameByID(showBlog.idClub)}
                                                                </a>
                                                            </li>
                                                        </ul>
                                                        <h5 class="post-title">
                                                            <a href="${pageContext.request.contextPath}/UploadContentBlog?idBlog=${showBlog.idBlog}">
                                                                ${showBlog.titleBlog}
                                                            </a>
                                                        </h5>
                                                        <p>${showBlog.description}</p>
                                                        <div class="post-extra">
                                                            <a href="${pageContext.request.contextPath}/UploadContentBlog?idBlog=${showBlog.idBlog}" class="btn-link">READ MORE</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                        <!-- Pagination start -->
                                        <div class="pagination-bx rounded-sm gray clearfix">
                                            <ul class="pagination">
                                                <c:if test="${currentPage > 1}">
                                                    <li class="previous"><a href="?page=${currentPage - 1}&idBlogType=${idBlogType}&from=${from}&searchKeyword=${searchKeyword}"><i class="ti-arrow-left"></i> Prev</a></li>
                                                    </c:if>
                                                    <c:forEach begin="1" end="${noOfPages}" var="i">
                                                    <li class="${currentPage == i ? 'active' : ''}"><a href="?page=${i}&idBlogType=${idBlogType}&from=${from}&searchKeyword=${searchKeyword}">${i}</a></li>
                                                    </c:forEach>
                                                    <c:if test="${currentPage < noOfPages}">
                                                    <li class="next"><a href="?page=${currentPage + 1}&idBlogType=${idBlogType}&from=${from}&searchKeyword=${searchKeyword}">Next <i class="ti-arrow-right"></i></a></li>
                                                        </c:if>
                                            </ul>
                                        </div>
                                        <!-- Pagination END -->
                                    </c:if>
                                </div>
                                <!-- Left part END -->
                                <!-- Side bar start -->
                                <div class="col-lg-4 sticky-top">
                                    <aside class="side-bar sticky-top">
                                        <c:set var="printed" value="false" />
                                        <c:forEach var="studentClub" items="${StudentClubList}">
                                            <c:if test="${studentClub.leader == 1 and studentClub.status == 1 and not printed}">
                                                <div class="widget_tag_cloud">
                                                    <div class="tagcloud">
                                                        <a href="<c:url value='/UploadServlet?from=Blog_List.jsp' />"> Upload New Blog</a>
                                                    </div>
                                                </div>
                                                <c:set var="printed" value="true" />
                                            </c:if>
                                        </c:forEach>
                                        <div class="widget">
                                            <h6 class="widget-title">Search</h6>
                                            <div class="search-bx style-1">
                                                <form role="search" action="BlogSearchServlet" method="POST">
                                                    <input type="hidden" name="from" value="Blog_List.jsp">
                                                    <div class="input-group">
                                                        <input name="searchKeyword" class="form-control" placeholder="Enter title blog" type="text">
                                                        <span class="input-group-btn">
                                                            <button type="submit" class="fa fa-search text-primary"></button>
                                                        </span> 
                                                    </div>
                                                </form>
                                                <c:if test="${not empty errorMessage}">
                                                    <div class="alert alert-danger">${errorMessage}</div>
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="widget recent-posts-entry">
                                            <h6 class="widget-title">Blog's Type</h6>
                                            <div class="widget-post-bx">

                                                <div class="widget-post clearfix">
                                                    <a href="<c:url value='/BlogListServlet?from=Blog_List.jsp' />"><span>All</span></a><br>
                                                    <c:forEach var="settingBlogType" items="${settingsList}">
                                                        <ul class="sub-menu">
                                                            <li>
                                                                <a href="${pageContext.request.contextPath}/BlogTypeServlet?idBlogType=${settingBlogType.idSetting}&from=Blog_List.jsp">
                                                                    ${settingBlogType.valueSetting}
                                                                </a>
                                                            </li>
                                                        </ul>
                                                    </c:forEach>
                                                </div>

                                            </div>
                                        </div>
                                    </aside>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
                                        <li><a  href="${pageContext.request.contextPath}/images_t/gallery/pic1.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic1.jpg" alt=""></a></li>
                                        <li><a  href="${pageContext.request.contextPath}/images_t/gallery/pic2.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic2.jpg" alt=""></a></li>
                                        <li><a  href="${pageContext.request.contextPath}/images_t/gallery/pic3.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic3.jpg" alt=""></a></li>
                                        <li><a  href="${pageContext.request.contextPath}/images_t/gallery/pic4.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic4.jpg" alt=""></a></li>
                                        <li><a  href="${pageContext.request.contextPath}/images_t/gallery/pic5.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic5.jpg" alt=""></a></li>
                                        <li><a  href="${pageContext.request.contextPath}/images_t/gallery/pic6.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic6.jpg" alt=""></a></li>
                                        <li><a  href="${pageContext.request.contextPath}/images_t/gallery/pic7.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic7.jpg" alt=""></a></li>
                                        <li><a  href="${pageContext.request.contextPath}/images_t/gallery/pic8.jpg" class="magnific-anchor"><img src="${pageContext.request.contextPath}/images_t/gallery/pic8.jpg" alt=""></a></li>
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
            </footer>
            <!-- Footer END ==== -->
            <!-- scroll top button -->
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
        <!--<script src='${pageContext.request.contextPath}/vendors/switcher/switcher.js'></script>-->
    </body>

</html>
