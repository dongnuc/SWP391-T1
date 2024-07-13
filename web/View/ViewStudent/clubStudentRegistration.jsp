<%-- 
    Document   : clubStudentRegistration
    Created on : Jul 10, 2024, 2:12:50 PM
    Author     : Nguyen Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->


        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="css/main.css ">
        <link class="skin" rel="stylesheet" type="text/css" href="assets/css/color/color-1.css">

        <!-- REVOLUTION SLIDER CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/layers.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/settings.css">
        <link rel="stylesheet" type="text/css" href="assets/vendors/revolution/css/navigation.css">
        <title>JSP Page</title>
        <style>
            .form-container {
                width: 80%;
                height: auto;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 10px;
                background-color: #f9f9f9;
                box-sizing: border-box;
            }

            .form-group {
                margin-bottom: 15px;
            }
            .form-group label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }
            .form-group input, .form-group select {
                width: 100%;
                padding: 8px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            .form-group textarea{
                width: 100%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
            }
            .form-group input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
            }
            .form-group input[type="submit"]:hover {
                background-color: #45a049;
            }
            .form{
                padding-top: 20px;
            }
        </style>
    </head>
    <body>
        <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <%@ include file="Header.jsp" %>
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <div class="page-banner ovbl-dark" style="background-image:url(images/banner.png);">
                    <div class="container">
                        <div class="page-banner-entry">
                            <h1 class="text-white">CLUB STUDENT REGISTRATION</h1>
                        </div>
                    </div>
                </div>
                <!-- Breadcrumb row -->
                <form method="post" action="ClubStudentRegistrationServle?idclub=${id}" style="padding-top: 20px;padding-bottom: 20px;" > 
           

                   <div class="form-container" >

                <div class="form-group" >
                    <label for="NameClub">Full Name</label>
                    <input type="text" id="fullname" name="fullname" value="${fullname}"/>
                    <h6 style="color: red;">${error1}</h6>
                </div>
                <div class="form-group">
                    <label for="clubId">Select Role</label>
                    <select name="role" >
                        <option value="0" <c:if test="${role==0}">selected</c:if>>Select Role</option>
                                    <option value="2" <c:if test="${role==2}">selected</c:if>>Secretary</option>
                                    <option value="3" <c:if test="${role==3}">selected</c:if>>Treasurer</option>
                                    <option value="4" <c:if test="${role==4}">selected</c:if>>Public Relations Officer</option>
                                    <option value="5" <c:if test="${role==5}">selected</c:if>>Member</option>
                                    <option value="6" <c:if test="${role==6}">selected</c:if>>Technical</option>
                                    <!-- Add more options as needed -->
                                </select>
                    <h6 style="color: red;">${error5}</h6>
                </div>
                       <div class="form-group" >
                    <label for="NameClub">Talent</label>
                    <input type="text"  name="talent" value="${talent}"/>
                    <h6 style="color: red;">${error2}</h6>
                </div>
                <div class="form-group">
                    <label for="Reason">Experience</label>
                    <textarea  name="experience" rows="5" cols="50" > ${experience}</textarea>
                    <br>
                    <h6 style="color: red;">${error3}</h6>
                </div>
                 <div class="form-group">
                    <label for="Reason">Target</label>
                    <textarea  name="target" rows="5" cols="50" > ${target}</textarea>
                    <br>
                    
                    <h6 style="color: red;">${error4}</h6>
                </div>  
                <div class="form-group">
                    <input type="submit" value="Register Club"/>
                </div>    
                <h6 style="color: green;">${error}</h6>
                <h6 style="color: red;">${error7}</h6>
                <h6 style="color: red;">${errorr}</h6>
                
            </div>    
        </form>
                <!-- Breadcrumb row END -->
                <!-- inner page banner END -->
               
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
                                <a href="index.html"><img src="assets/images/logo-white.png" alt=""/></a>
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
                                    <li><a href="assets/images/gallery/pic1.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic1.jpg" alt=""></a></li>
                                    <li><a href="assets/images/gallery/pic2.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic2.jpg" alt=""></a></li>
                                    <li><a href="assets/images/gallery/pic3.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic3.jpg" alt=""></a></li>
                                    <li><a href="assets/images/gallery/pic4.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic4.jpg" alt=""></a></li>
                                    <li><a href="assets/images/gallery/pic5.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic5.jpg" alt=""></a></li>
                                    <li><a href="assets/images/gallery/pic6.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic6.jpg" alt=""></a></li>
                                    <li><a href="assets/images/gallery/pic7.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic7.jpg" alt=""></a></li>
                                    <li><a href="assets/images/gallery/pic8.jpg" class="magnific-anchor"><img src="assets/images/gallery/pic8.jpg" alt=""></a></li>
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
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/vendors/bootstrap/js/popper.min.js"></script>
    <script src="assets/vendors/bootstrap/js/bootstrap.min.js"></script>
    <script src="assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>
    <script src="assets/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
    <script src="assets/vendors/magnific-popup/magnific-popup.js"></script>
    <script src="assets/vendors/counter/waypoints-min.js"></script>
    <script src="assets/vendors/counter/counterup.min.js"></script>
    <script src="assets/vendors/imagesloaded/imagesloaded.js"></script>
    <script src="assets/vendors/masonry/masonry.js"></script>
    <script src="assets/vendors/masonry/filter.js"></script>
    <script src="assets/vendors/owl-carousel/owl.carousel.js"></script>
    <script src="assets/js/functions.js"></script>
    <script src="assets/js/contact.js"></script>
    <script src='assets/vendors/switcher/switcher.js'></script>
        


        <script>
            function showSubMenu() {
                var subMenu = document.getElementById("subMenu");
                subMenu.style.display = "block";
            }

            function hideSubMenu() {
                var subMenu = document.getElementById("subMenu");
                subMenu.style.display = "none";
            }
            function showSubMenu1() {
                var subMenu = document.getElementById("subMenu1");
                subMenu.style.display = "block";
            }

            function hideSubMenu1() {
                var subMenu = document.getElementById("subMenu1");
                subMenu.style.display = "none";
            }
            function showSubMenu2() {
                var subMenu = document.getElementById("subMenu2");
                subMenu.style.display = "block";
            }

            function hideSubMenu2() {
                var subMenu = document.getElementById("subMenu2");
                subMenu.style.display = "none";
            }
            function showSubMenu3() {
                var subMenu = document.getElementById("subMenu3");
                subMenu.style.display = "block";
            }

            function hideSubMenu3() {
                var subMenu = document.getElementById("subMenu3");
                subMenu.style.display = "none";
            }
            ;

        </script>



        <script>
            var isClubVisible = false;

            function showClubTable() {
                var profileInfo = document.getElementById("club-table");
                if (!isClubVisible) {
                    profileInfo.style.display = "block";
                }
            }

            function hideClubTable() {
                var profileInfo = document.getElementById("club-table");
                if (!isClubVisible) {
                    profileInfo.style.display = "none";
                }
            }

            function toggleClubTable() {
                var profileInfo = document.getElementById("club-table");
                if (!isClubVisible) {
                    profileInfo.style.display = "block";
                    isClubVisible = true;
                } else {
                    isClubVisible = false;
                }
            }

            // Ẩn thông tin người dùng khi click ra ngoài
            document.addEventListener("click", function (event) {
                var profileInfo = document.getElementById("club-table");
                if (!event.target.closest(".dropdown") && isClubVisible) {
                    profileInfo.style.display = "none";
                    isClubVisible = false;
                }
            });
        </script>
       <script>
    // Wait for the document to load
    document.addEventListener("DOMContentLoaded", function() {
        // Get the textarea element
        var textarea = document.getElementById("experience");

        // Add event listener for mousedown to prevent default behavior
        textarea.addEventListener("mousedown", function(event) {
            event.preventDefault();
        });

        // Add event listener for mouseup to set caret position
        textarea.addEventListener("mouseup", function() {
            // Set the caret position at the start (5 characters from the beginning)
            setCaretPosition(textarea, 5);
        });
    });
    

    // Function to set caret position in textarea
    function setCaretPosition(textarea, position) {
        // Ensure the textarea exists and is focused
        textarea.focus();
        // Set the selection range for the textarea
        textarea.setSelectionRange(position, position);
    }
</script>
<script>

            // Function thay đổi trang
            function changePage(page) {
                // Ẩn tất cả các trang thông tin hot
                var hotInfos = document.querySelectorAll('.hot-info');
                for (var i = 0; i < hotInfos.length; i++) {
                    hotInfos[i].style.display = 'none';
                }
                // Hiển thị trang được chọn
                document.getElementById('page' + page).style.display = 'block';
            }
            // Mặc định hiển thị trang 1 khi trang được tải
            changePage(1);
        </script>
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
            document.addEventListener("DOMContentLoaded", function () {
                var paginationLinks = document.querySelectorAll('.pagination a');
                paginationLinks.forEach(function (link) {
                    link.addEventListener('click', function (event) {
                        event.preventDefault();
                        var currentPage = parseInt(this.textContent);
                        setActivePage(currentPage);
                    });
                });

                function setActivePage(pageNumber) {
                    var paginationLinks = document.querySelectorAll('.pagination a');
                    paginationLinks.forEach(function (link) {
                        link.classList.remove('active');
                    });
                    paginationLinks[pageNumber - 1].classList.add('active');

                    // Do something here to load data for the selected page
                }
            });
        </script>
    </body>
</html>
