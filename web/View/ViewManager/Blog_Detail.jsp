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
                                                <c:if test="${x.idClub == studentClub.idClub && studentClub.status == 1 && studentClub.role == 1}">
                                                    <c:set var="showTagCloud" value="true" />
                                                </c:if>
                                            </c:forEach>
                                            <c:if test="${showTagCloud}">
                                                <script>
                                                    function confirmAction(url, action) {
                                                        var message = "Do you want to " + action + " ?";
                                                        if (confirm(message)) {
                                                            window.location.href = url;
                                                        }
                                                    }
                                                </script>
                                                <div class="widget_tag_cloud">
                                                    <div class="tagcloud">
                                                        <a href="#" onclick="confirmAction('${pageContext.request.contextPath}/BlogUpdateServlet?idBlog=${x.idBlog}', 'update')">Update</a>
                                                        <a href="#" onclick="confirmAction('${pageContext.request.contextPath}/BlogDeleteServlet?idBlog=${x.idBlog}', 'delete')">Delete</a>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${x.status == 0}">
                                        <p>Event was stopped</p>
                                    </c:if>
                                    <div class="recent-news blog-lg">
                                        <div class="action-box blog-lg">
                                            <img src="${pageContext.request.contextPath}/${x.image}" alt="">
                                        </div>
                                        <div class="info-bx">
                                            <ul class="media-post">
                                                <li><a><i class="fa fa-calendar"></i>${x.dateCreate}</a></li>
                                            </ul>
                                            <h5 class="post-title"><a>${x.titleBlog}</a></h5>
                                            <p>${x.content}</p>

                                            </c:if>
                                            <div class="ttr-divider bg-gray"><i class="icon-dot c-square"></i></div>

                                            <div class="ttr-divider bg-gray"><i class="icon-dot c-square"></i></div>
                                            <h6>SHARE </h6>
                                            <ul class="list-inline contact-social-bx">
                                                <li><a href="#" class="btn outline radius-xl"><i class="fa fa-facebook"></i></a></li>
                                                <li><a href="#" class="btn outline radius-xl"><i class="fa fa-twitter"></i></a></li>
                                                <li><a href="#" class="btn outline radius-xl"><i class="fa fa-linkedin"></i></a></li>
                                                <li><a href="#" class="btn outline radius-xl"><i class="fa fa-google-plus"></i></a></li>
                                            </ul>
                                            <div class="ttr-divider bg-gray"><i class="icon-dot c-square"></i></div>
                                        </div>
                                    </div>
                                    <div class="clear" id="comment-list">
                                        <div class="comments-area" id="comments">
                                            <h2 class="comments-title">8 Comments</h2>
                                            <div class="clearfix m-b20">
                                                <!-- comment list END -->
                                                <ol class="comment-list">
                                                    <li class="comment">
                                                        <div class="comment-body">
                                                            <div class="comment-author vcard"> <img  class="avatar photo" src="${pageContext.request.contextPath}/images_t/testimonials/pic1.jpg" alt=""> <cite class="fn">John Doe</cite> <span class="says">says:</span> </div>
                                                            <div class="comment-meta"> <a href="#">December 02, 2019 at 10:45 am</a> </div>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae neqnsectetur adipiscing elit. Nam viae neqnsectetur adipiscing elit.
                                                                Nam vitae neque vitae sapien malesuada aliquet. </p>
                                                            <div class="reply"> <a href="#" class="comment-reply-link">Reply</a> </div>
                                                        </div>
                                                        <ol class="children">
                                                            <li class="comment odd parent">
                                                                <div class="comment-body">
                                                                    <div class="comment-author vcard"> <img  class="avatar photo" src="${pageContext.request.contextPath}/images_t/testimonials/pic2.jpg" alt=""> <cite class="fn">John Doe</cite> <span class="says">says:</span> </div>
                                                                    <div class="comment-meta"> <a href="#">December 02, 2019 at 10:45 am</a> </div>
                                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae neque vitae sapien malesuada aliquet. 
                                                                        In viverra dictum justo in vehicula. Fusce et massa eu ante ornare molestie. Sed vestibulum sem felis, 
                                                                        ac elementum ligula blandit ac.</p>
                                                                    <div class="reply"> <a href="#" class="comment-reply-link">Reply</a> </div>
                                                                </div>
                                                                <ol class="children">
                                                                    <li class="comment odd parent">
                                                                        <div class="comment-body">
                                                                            <div class="comment-author vcard"> <img  class="avatar photo" src="${pageContext.request.contextPath}/images_t/testimonials/pic3.jpg" alt=""> <cite class="fn">John Doe</cite> <span class="says">says:</span> </div>
                                                                            <div class="comment-meta"> <a href="#">December 02, 2019 at 10:45 am</a> </div>
                                                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae neque vitae sapien malesuada aliquet. 
                                                                                In viverra dictum justo in vehicula. Fusce et massa eu ante ornare molestie. Sed vestibulum sem felis, 
                                                                                ac elementum ligula blandit ac.</p>
                                                                            <div class="reply"> <a href="#" class="comment-reply-link">Reply</a> </div>
                                                                        </div>
                                                                    </li>
                                                                </ol>
                                                                <!-- list END -->
                                                            </li>
                                                        </ol>
                                                        <!-- list END -->
                                                    </li>
                                                    <li class="comment">
                                                        <div class="comment-body">
                                                            <div class="comment-author vcard"> <img  class="avatar photo" src="${pageContext.request.contextPath}/images_t/testimonials/pic1.jpg" alt=""> <cite class="fn">John Doe</cite> <span class="says">says:</span> </div>
                                                            <div class="comment-meta"> <a href="#">December 02, 2019 at 10:45 am</a> </div>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae neque vitae sapien malesuada aliquet. 
                                                                In viverra dictum justo in vehicula. Fusce et massa eu ante ornare molestie. Sed vestibulum sem felis, 
                                                                ac elementum ligula blandit ac.</p>
                                                            <div class="reply"> <a href="#" class="comment-reply-link">Reply</a> </div>
                                                        </div>
                                                    </li>
                                                    <li class="comment">
                                                        <div class="comment-body">
                                                            <div class="comment-author vcard"> <img  class="avatar photo" src="${pageContext.request.contextPath}/images_t/testimonials/pic2.jpg" alt=""> <cite class="fn">John Doe</cite> <span class="says">says:</span> </div>
                                                            <div class="comment-meta"> <a href="#">December 02, 2019 at 10:45 am</a> </div>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae neque vitae sapien malesuada aliquet. 
                                                                In viverra dictum justo in vehicula. Fusce et massa eu ante ornare molestie. Sed vestibulum sem felis, 
                                                                ac elementum ligula blandit ac.</p>
                                                            <div class="reply"> <a href="#" class="comment-reply-link">Reply</a> </div>
                                                        </div>
                                                    </li>
                                                    <li class="comment">
                                                        <div class="comment-body">
                                                            <div class="comment-author vcard"> <img  class="avatar photo" src="${pageContext.request.contextPath}/images_t/testimonials/pic3.jpg" alt=""> <cite class="fn">John Doe</cite> <span class="says">says:</span> </div>
                                                            <div class="comment-meta"> <a href="#">December 02, 2019 at 10:45 am</a> </div>
                                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae neque vitae sapien malesuada aliquet. 
                                                                In viverra dictum justo in vehicula. Fusce et massa eu ante ornare molestie. Sed vestibulum sem felis, 
                                                                ac elementum ligula blandit ac.</p>
                                                            <div class="reply"> <a href="#" class="comment-reply-link">Reply</a> </div>
                                                        </div>
                                                    </li>
                                                </ol>
                                                <!-- comment list END -->
                                                <!-- Form -->
                                                <div class="comment-respond" id="respond">
                                                    <h4 class="comment-reply-title" id="reply-title">Leave a Reply <small> <a style="display:none;" href="#" id="cancel-comment-reply-link" rel="nofollow">Cancel reply</a> </small> </h4>
                                                    <form class="comment-form" id="commentform" method="post">
                                                        <p class="comment-form-author">
                                                            <label for="author">Name <span class="required">*</span></label>
                                                            <input type="text" value="" name="Author"  placeholder="Author" id="author">
                                                        </p>
                                                        <p class="comment-form-email">
                                                            <label for="email">Email <span class="required">*</span></label>
                                                            <input type="text" value="" placeholder="Email" name="email" id="email">
                                                        </p>
                                                        <p class="comment-form-url">
                                                            <label for="url">Website</label>
                                                            <input type="text"  value=""  placeholder="Website"  name="url" id="url">
                                                        </p>
                                                        <p class="comment-form-comment">
                                                            <label for="comment">Comment</label>
                                                            <textarea rows="8" name="comment" placeholder="Comment" id="comment"></textarea>
                                                        </p>
                                                        <p class="form-submit">
                                                            <input type="submit" value="Submit Comment" class="submit" id="submit" name="submit">
                                                        </p>
                                                    </form>
                                                </div>
                                                <!-- Form -->
                                            </div>
                                        </div>
                                    </div>
                                    <!-- blog END -->
                                </div>
                                <!-- Left part END -->
                                <!-- Side bar start -->
                                <div class="col-lg-4 col-xl-4">
                                    <aside  class="side-bar sticky-top">
                                        <div class="widget">
                                            <h6 class="widget-title">Search</h6>
                                            <div class="search-bx style-1">
                                                <form role="search" method="post">
                                                    <div class="input-group">
                                                        <input name="text" class="form-control" placeholder="Enter your keywords..." type="text">
                                                        <span class="input-group-btn">
                                                            <button type="submit" class="fa fa-search text-primary"></button>
                                                        </span> 
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="widget recent-posts-entry">
                                            <h6 class="widget-title">Recent Posts</h6>
                                            <div class="widget-post-bx">
                                                <div class="widget-post clearfix">
                                                    <div class="ttr-post-media"> <img src="${pageContext.request.contextPath}/images_t/blog/recent-blog/pic1.jpg" width="200" height="143" alt=""> </div>
                                                    <div class="ttr-post-info">
                                                        <div class="ttr-post-header">
                                                            <h6 class="post-title"><a href="blog-details.html">This Story Behind Education Will Haunt You Forever.</a></h6>
                                                        </div>
                                                        <ul class="media-post">
                                                            <li><a href="#"><i class="fa fa-calendar"></i>Oct 23 2019</a></li>
                                                            <li><a href="#"><i class="fa fa-comments-o"></i>15 Comment</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="widget-post clearfix">
                                                    <div class="ttr-post-media"> <img src="${pageContext.request.contextPath}/images_t/blog/recent-blog/pic2.jpg" width="200" height="160" alt=""> </div>
                                                    <div class="ttr-post-info">
                                                        <div class="ttr-post-header">
                                                            <h6 class="post-title"><a href="blog-details.html">What Will Education Be Like In The Next 50 Years?</a></h6>
                                                        </div>
                                                        <ul class="media-post">
                                                            <li><a href="#"><i class="fa fa-calendar"></i>May 14 2019</a></li>
                                                            <li><a href="#"><i class="fa fa-comments-o"></i>23 Comment</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                                <div class="widget-post clearfix">
                                                    <div class="ttr-post-media"> <img src="${pageContext.request.contextPath}/images_t/blog/recent-blog/pic3.jpg" width="200" height="160" alt=""> </div>
                                                    <div class="ttr-post-info">
                                                        <div class="ttr-post-header">
                                                            <h6 class="post-title"><a href="blog-details.html">Eliminate Your Fears And Doubts About Education.</a></h6>
                                                        </div>
                                                        <ul class="media-post">
                                                            <li><a href="#"><i class="fa fa-calendar"></i>June 12 2019</a></li>
                                                            <li><a href="#"><i class="fa fa-comments-o"></i>27 Comment</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="widget widget-newslatter">
                                            <h6 class="widget-title">Newsletter</h6>
                                            <div class="news-box">
                                                <p>Enter your e-mail and subscribe to our newsletter.</p>
                                                <form class="subscription-form" action="http://educhamp.themetrades.com/demo/assets/script/mailchamp.php" method="post">
                                                    <div class="ajax-message"></div>
                                                    <div class="input-group">
                                                        <input name="dzEmail" required="required" type="email" class="form-control" placeholder="Your Email Address"/>
                                                        <button name="submit" value="Submit" type="submit" class="btn black radius-no">
                                                            <i class="fa fa-paper-plane-o"></i>
                                                        </button>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                        <div class="widget widget_gallery gallery-grid-4">
                                            <h6 class="widget-title">Our Gallery</h6>
                                            <ul>
                                                <li><div><a href="#"><img src="${pageContext.request.contextPath}/images_t/gallery/pic2.jpg" alt=""></a></div></li>
                                                <li><div><a href="#"><img src="${pageContext.request.contextPath}/images_t/gallery/pic1.jpg" alt=""></a></div></li>
                                                <li><div><a href="#"><img src="${pageContext.request.contextPath}/images_t/gallery/pic5.jpg" alt=""></a></div></li>
                                                <li><div><a href="#"><img src="${pageContext.request.contextPath}/images_t/gallery/pic7.jpg" alt=""></a></div></li>
                                                <li><div><a href="#"><img src="${pageContext.request.contextPath}/images_t/gallery/pic8.jpg" alt=""></a></div></li>
                                                <li><div><a href="#"><img src="${pageContext.request.contextPath}/images_t/gallery/pic9.jpg" alt=""></a></div></li>
                                                <li><div><a href="#"><img src="${pageContext.request.contextPath}/images_t/gallery/pic3.jpg" alt=""></a></div></li>
                                                <li><div><a href="#"><img src="${pageContext.request.contextPath}/images_t/gallery/pic4.jpg" alt=""></a></div></li>
                                            </ul>
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