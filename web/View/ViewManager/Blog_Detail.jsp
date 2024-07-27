<%-- 
    Document   : Blog_Detail
    Created on : Jun 6, 2024, 10:34:21 AM
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
        <link rel="icon" href="${pageContext.request.contextPath}/images_t/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/images_t/favicon.png" />
        <!-- PAGE TITLE HERE ============================================= -->
        <title>Blog Detail </title>
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
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <!-- jQuery -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <!-- Bootstrap JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>
            <%@ include file="Header.jsp" %>
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(${pageContext.request.contextPath}/images_t/banner/banner2.jpg);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">Blog Details</h1>
                        </div>
                    </div>
                </div>
                <c:if test="${not empty x}">
                    <div class="content-block">
                        <div class="section-area section-sp1">
                            <div class="container">
                                <div class="row">
                                    <!-- Left part start -->
                                    <div class="col-lg-8 col-xl-8">
                                        <!-- blog start -->
                                        <c:choose>
                                            <c:when test="${not empty curruser}">
                                                <c:set var="showTagCloud" value="false" />
                                                <c:forEach var="studentClub" items="${StudentClubList}">
                                                    <c:if test="${x.idClub == studentClub.idClub && studentClub.status == 1 && studentClub.leader == 1}">
                                                        <c:set var="showTagCloud" value="true" />
                                                    </c:if>
                                                </c:forEach>
                                                <c:if test="${showTagCloud}">
                                                    <script>
                                                        function openModal(url, action) {
                                                            document.getElementById('modalAction').textContent = action;
                                                            var confirmBtn = document.getElementById('modalConfirmBtn');
                                                            confirmBtn.onclick = function () {
                                                                window.location.href = url;
                                                            };
                                                            $('#confirmModal').modal('show');
                                                        }
                                                    </script>

                                                    <div class="widget_tag_cloud">
                                                        <div class="tagcloud">
                                                            <a href="#" onclick="openModal('${pageContext.request.contextPath}/BlogUpdateServlet?idBlog=${x.idBlog}&from=Blog_List.jsp', 'update')">Update</a>
                                                            <a href="#" onclick="openModal('${pageContext.request.contextPath}/BlogDeleteServlet?idBlog=${x.idBlog}&from=Blog_List.jsp', 'delete')">Delete</a>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:when>
                                        </c:choose>

                                        <div class="recent-news blog-lg">
                                            <div class="action-box blog-lg">
                                                <img src="${pageContext.request.contextPath}/${x.image}" alt="">
                                            </div>
                                            <div class="info-bx">
                                                <ul class="media-post">
                                                    <li><a><i class="fa fa-calendar"></i>${x.dateCreate}</a></li>
                                                    <i class="fa fa-user"></i>${clubDAO.getClubNameByID(x.idClub)}
                                                </ul>
                                                <h5 class="post-title"><a>${x.titleBlog}</a></h5>
                                                <p>${x.content}</p>

                                            </c:if>
                                            <div class="ttr-divider bg-gray"><i class="icon-dot c-square"></i></div>

                                            <div class="ttr-divider bg-gray"><i class="icon-dot c-square"></i></div>
                                            <!--                                            <h6>SHARE </h6>
                                                                                        <ul class="list-inline contact-social-bx">
                                                                                            <li><a href="#" class="btn outline radius-xl"><i class="fa fa-facebook"></i></a></li>
                                                                                            <li><a href="#" class="btn outline radius-xl"><i class="fa fa-twitter"></i></a></li>
                                                                                            <li><a href="#" class="btn outline radius-xl"><i class="fa fa-linkedin"></i></a></li>
                                                                                            <li><a href="#" class="btn outline radius-xl"><i class="fa fa-google-plus"></i></a></li>
                                                                                        </ul>-->
                                            <div class="ttr-divider bg-gray"><i class="icon-dot c-square"></i></div>
                                        </div>
                                    </div>
                                </div>
                                <!-- Left part END -->
                                <!-- Side bar start -->
                                <div class="col-lg-4 col-xl-4">
                                    <aside  class="side-bar sticky-top">
                                        <div class="widget recent-posts-entry">
                                            <h6 class="widget-title">Recent Posts</h6>
                                            <div class="widget-post-bx">
                                                <c:forEach var="Blog" items="${lastest5Post}">
                                                    <div class="widget-post clearfix">
                                                        <div class="ttr-post-media"> <img src="${pageContext.request.contextPath}/${Blog.image}" alt="Uploaded Image" width="200" height="143" alt=""> </div>
                                                        <div class="ttr-post-info">
                                                            <div class="ttr-post-header">
                                                                <h6 class="post-title"><a href="${pageContext.request.contextPath}/UploadContentBlog?idBlog=${Blog.idBlog}">${Blog.titleBlog}</a></h6>
                                                            </div>
                                                            <ul class="media-post">
                                                                <li><a href="${pageContext.request.contextPath}/UploadContentBlog?idBlog=${Blog.idBlog}"><i class="fa fa-calendar"></i>${Blog.dateCreate}</a></li><br>
                                                                <li><a href="${pageContext.request.contextPath}/UploadContentBlog?idBlog=${Blog.idBlog}"><i class="fa fa-user"></i>${clubDAO.getClubNameByID(Blog.idClub)}</a></li>
                                                            </ul>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>

                                    </aside>
                                </div>
                                <!-- Side bar END -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Content END-->
            <!-- Footer ==== -->
            <!-- Modal -->
            <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="confirmModalLabel">Confirm Action</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Are you sure you want to <span id="modalAction"></span> this blog?
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                            <button type="button" class="btn btn-primary" id="modalConfirmBtn">Yes</button>
                        </div>
                    </div>
                </div>
            </div>

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
    </body>

</html>