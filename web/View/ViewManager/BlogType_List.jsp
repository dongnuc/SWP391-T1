<%-- 
    Document   : Blog_List
    Created on : Jun 5, 2024, 2:09:04 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "Model.*" %>
<%@ page import = "DAO.*" %>
<%@ page import = "java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%  
    BlogDAO blogDAO = new BlogDAO();
    ClubDao clubDAO = new ClubDao();
    BlogTypeDAO blogTypeDAO = new BlogTypeDAO();
    List<BlogType> blogTypeList = blogTypeDAO.getAllPosts();
    BlogType post = (BlogType) request.getAttribute("x");
    Accounts acc = (Accounts) session.getAttribute("curruser");
    List<StudentClub> StudentClubList = null;
    if (acc != null) {
        StudentClubDAO studentClubDAO = new StudentClubDAO();
        StudentClubList = studentClubDAO.getStudentClubs(acc.getId());
    }
%>
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
        <title><%= post.getNameBlogType()%></title>

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
                            <h1 class="text-white"><%= post.getNameBlogType()%> </h1>
                        </div>
                    </div>
                </div>

                <!-- contact area -->
                <div class="content-block">
                    <div class="section-area section-sp1">
                        <div class="container">
                            <div class="row">
                                <!-- Left part start -->
                                <div class="col-lg-8">
                                    <%
                                    if (post != null) {
                                        List<Blog> blogListByID = blogDAO.getBlogListByType(post.getIdBlogType());
                                        for(Blog blog : blogListByID){
                                        boolean canSeeBlog = blog.getShow() == 1;
                                        if (!canSeeBlog && acc != null) {
                                            for (StudentClub studentClub : StudentClubList) {
                                            if (studentClub.getIdClub() == blog.getIdClub()) { 
                                                canSeeBlog = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (canSeeBlog) {
                                    %>
                                    <div class="blog-post blog-md clearfix">
                                        <div class="ttr-post-media"> 
                                            <a href="<%= request.getContextPath() %>/UploadContentBlog?idBlog=<%= blog.getIdBlog() %>"><img src="<%= request.getContextPath() %>/<%= blog.getImage() %>" alt="Uploaded Image"></a><br></a> 
                                        </div>
                                        <div class="ttr-post-info">
                                            <ul class="media-post">
                                                <li><a href="<%= request.getContextPath() %>/UploadContentBlog?idBlog=<%= blog.getIdBlog() %>"><i class="fa fa-calendar"></i><%= blog.getDateCreate()%></a></li>
                                                <li><a href="<%= request.getContextPath() %>/UploadContentBlog?idBlog=<%= blog.getIdBlog() %>"><i class="fa fa-user"></i><%= clubDAO.getNameById(blog.getIdClub())%></a></li>

                                            </ul>
                                            <h5 class="post-title"><a href="<%= request.getContextPath() %>/UploadContentBlog?idBlog=<%= blog.getIdBlog() %>"><%= blog.getTitleBlog()%></a></h5>
                                            <p><%= blog.getDescription()%></p>
                                            <div class="post-extra">
                                                <a href="<%= request.getContextPath() %>/UploadContentBlog?idBlog=<%= blog.getIdBlog() %>" class="btn-link">READ MORE</a>
                                            </div>
                                        </div>
                                    </div>
                                    <%      }
                                        }
                                    }
                                    %>
                                    <!-- Pagination start -->
                                    <div class="pagination-bx rounded-sm gray clearfix">
                                        <ul class="pagination">
                                            <li class="previous"><a href="#"><i class="ti-arrow-left"></i> Prev</a></li>
                                            <li class="active"><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                            <li class="next"><a href="#">Next <i class="ti-arrow-right"></i></a></li>
                                        </ul>
                                    </div>
                                    <!-- Pagination END -->
                                </div>
                                <!-- Left part END -->
                                <!-- Side bar start -->
                                <div class="col-lg-4 sticky-top">
                                    <aside class="side-bar sticky-top">
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
                                            <h6 class="widget-title">Blog's Type</h6>
                                            <div class="widget-post-bx">

                                                <div class="widget-post clearfix">
                                                    <% for(BlogType blogType : blogTypeList){ 
                                                    %>
                                                    <ul class="sub-menu">
                                                        <li><a href="<%= request.getContextPath() %>/BlogTypeServlet?idBlogType=<%= blogType.getIdBlogType() %>"><%= blogType.getNameBlogType()%></a></li>
                                                    </ul>
                                                    <% }
                                                    %>
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
                                        <div class="widget widget_tag_cloud">
                                            <h6 class="widget-title">Tags</h6>
                                            <div class="tagcloud"> 
                                                <a href="#">Design</a> 
                                                <a href="#">User interface</a> 
                                                <a href="#">SEO</a> 
                                                <a href="#">WordPress</a> 
                                                <a href="#">Development</a> 
                                                <a href="#">Joomla</a> 
                                                <a href="#">Design</a> 
                                                <a href="#">User interface</a> 
                                                <a href="#">SEO</a> 
                                                <a href="#">WordPress</a> 
                                                <a href="#">Development</a> 
                                                <a href="#">Joomla</a> 
                                                <a href="#">Design</a> 
                                                <a href="#">User interface</a> 
                                                <a href="#">SEO</a> 
                                                <a href="#">WordPress</a> 
                                                <a href="#">Development</a> 
                                                <a href="#">Joomla</a> 
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
