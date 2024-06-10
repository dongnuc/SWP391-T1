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
        <!-- REVOLUTION SLIDER END -->	
    </head>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<header class="header rs-nav header-transparent">
                <div class="top-bar">
                    <div class="container">
                        <div class="row d-flex justify-content-between">
                            <div class="topbar-left">
                                <ul>
                                    <li><a href="faq-1.html"><i class="fa fa-question-circle"></i>Ask a Question</a></li>
                                    <li><a href="javascript:;"><i class="fa fa-envelope-o"></i>Support@website.com</a></li>
                                </ul>
                            </div>
                            <c:if test="${sessionScope.account==null}">
                                <div class="topbar-right">
                                    <ul>

                                        <li><a href="View/ViewStudent/login.jsp">Login</a></li>
                                        <li><a href="register">Register</a></li>

                                    </ul>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="sticky-header navbar-expand-lg">
                    <div class="menu-bar clearfix">
                        <div class="container clearfix">
                            <!-- Header Logo ==== -->
                            
                            
                            <div class="menu-logo">
                                <a href="Home.jsp"><img src="images/logo3.png" alt=""></a>
                            </div>
                            <!-- Mobile Nav Button ==== -->
                            <button class="navbar-toggler collapsed menuicon justify-content-end" type="button" data-toggle="collapse" data-target="#menuDropdown" aria-controls="menuDropdown" aria-expanded="false" aria-label="Toggle navigation">
                                <span></span>
                                <span></span>
                                <span></span>
                            </button>
                            <!-- Author Nav ==== -->
                            <div class="secondary-menu">
                                <div class="secondary-inner">

                                    <c:if test="${sessionScope.account!=null}">
                                        <div class="profile-picture" onmouseover="showProfileInfo()" onmouseout="hideProfileInfo()" onclick="toggleProfileInfo()" >
                                            <img src="images/avatar.png" alt="">
                                            <div class="profile-info" id="profile-info">
                                                <h6>${sessionScope.account}</h6>
                                                <a href="profile/edit" id="edit-profile-link">Edit Profile</a><br>

                                                <c:if test="${sessionScope.password == null}">
                                                    <a href="View/ViewStudent/password.jsp" id="set-password-link">Set Password</a><br>
                                                </c:if>

                                                <c:if test="${sessionScope.password != null}">
                                                    <a href="View/ViewStudent/changepassword.jsp" id="change-password-link">Change Password</a><br>
                                                </c:if>
                                                <c:if test="${sessionScope.role == 2}">
                                                    <a href="dashboardAdmin" id="change-password-link">Dashboard</a><br>
                                                </c:if>
                                                <c:if test="${sessionScope.role == 1}">
                                                    <a href="#" id="change-password-link">My Club</a><br>
                                                </c:if>

                                                <a href="logout" id="logout-link">Log Out</a>
                                            </div>
                                        </div>
                                    </c:if>



                                </div>
                            </div>
                            <!-- Search Box ==== -->
                            <div class="nav-search-bar">
                                <form action="#">
                                    <input name="search" value="" type="text" class="form-control" placeholder="Type to search">
                                    <span><i class="ti-search"></i></span>
                                </form>
                                <span id="search-remove"><i class="ti-close"></i></span>
                            </div>
                            <!-- Navigation Menu ==== -->
                            <div class="menu-links navbar-collapse collapse justify-content-start" id="menuDropdown">
                                <div class="menu-logo">
                                    <a href="index.html"><img src="assets/images/logo.png" alt=""></a>
                                </div>
                                <ul class="nav navbar-nav">	
                                    <li><a href="Home.jsp">Home</a></li>
                                    <li><a href="View/ViewManager/Blog_List.jsp">Blog</a></li>
                                    <li><a href="PublicClubs">Clubs</a></li>
                                     <c:if test="${sessionScope.account!=null}"> 
                                        <li><a href="registerclub">REGISTER CLUB</a></li>
                                        </c:if> 


                                </ul>
                                <div class="nav-social-link">
                                    <a href="javascript:;"><i class="fa fa-facebook"></i></a>
                                    <a href="javascript:;"><i class="fa fa-google-plus"></i></a>
                                    <a href="javascript:;"><i class="fa fa-linkedin"></i></a>
                                </div>
                            </div>
                            <!-- Navigation Menu END ==== -->
                        </div>
                    </div>
                </div>
                                        
            </header>