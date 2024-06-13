<%-- 
    Document   : ContactUs
    Created on : May 22, 2024, 2:31:45 AM
    Author     : Nguyen Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
<<<<<<< HEAD
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
        <link rel="icon" href="../error-404.html" type="image/x-icon" />
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->


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

        <!-- SHORTCODES ============================================= -->        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/shortcodes/shortcodes.css">

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
=======
        <link rel="stylesheet" href="css/contactus.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
>>>>>>> 8d31409bbc7395d019269cc4072bfe83377cdc3c
        <title>JSP Page</title>
    </head>
    <body>

<<<<<<< HEAD
        <%@ include file="Header.jsp" %>
        <div class="page-banner ovbl-dark" style="background-image:url(images/banner.png);">
            <div class="container">
                <div class="page-banner-entry">
                    <h1 class="text-white">Contact Us</h1>
=======
        <section class="contact-section">

            <div class="contact-info-box">
                <div class="background">
                    <img src="images/contactus.png" alt="">
                </div>
                <a href="Home.jsp" class="home-link">
                    <img src="images/logo3.png" alt="Logo" class="logo">
                </a>
                <p class="contact-subheading">Any question or remarks? Just write us a message!</p>
            </div>

            <div class="contact-container">
                <div class="contact-inner">
                    <div class="contact-info">
                        <h3 class="contact-info-title">Contact Information</h3>
                        <p class="contact-info-description">Say something to start a live chat!</p>
                        <div class="contact-info-details">
                            <div class="detail-item">
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/16efcee12261d35860456522f48970b4da39ef461d25553ee37bea2a565d1633?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Phone icon" />
                                <span>+1012 3456 789</span>
                            </div>
                            <div class="detail-item">
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/f33a12af71453b99485ac9031fecc220eb9409e1999afd1ffbb8eef1e6b8f8f2?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Email icon" />
                                <span>demo@gmail.com</span>
                            </div>
                            <div class="detail-item">
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/0a95236edbb272ad63891b22868a195f09637d663fca1420ca3cc4475295718e?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Location icon" />
                                <span>132 Dartmouth Street Boston, Massachusetts 02156 United States</span>
                            </div>
                        </div>
                        <div class="social-icons">
                            <div class="social-icons-inner">
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/66ea2ff0f2515af5a51b7f233b1f409d364b5f0df83ffedf8c136b50bc3d9bb9?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Social icon 1" />
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/84bd54cc61c32ab35ff49f9a2f55e95c5923cd3a45cbff32064de123a6557787?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Social icon 2" />
                                <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/bb81d9e3889282d2a223a859cf8071d4c31be8305c4258e539dca8a5efabc91c?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Social icon 3" />
                            </div>
                        </div>
                    </div>
                    <form class="form-section" action="saveForm" method="POST">
                        <div class="form-title">
                            <div class="form-group">
<!--                                <div class="input-wrapper">
                                    <label for="clubId">Name Club</label>                                                                                              
                                    <select id="clubId" name="idClub" class="input-field">
                                        <option>Select club</option>
                                        <c:forEach items="${listClub}" var="listclub"> 
                                        <option value="${listclub.club}">${listclub.nameclub}</option>
                                        </c:forEach>                                  

                                                                           Thêm các tùy chọn khác nếu cần 
                                    </select>                                    
                                </div>-->
                            </div>
                            <div class="name-group">
                                <div class="input-wrapper">
                                    <label for="firstName">FullName</label>
                                    <input type="text" name="fullName" id="firstName" class="input-field" placeholder="Nguyen Duc Hau" />
                                </div>
                                <div class="input-wrapper">
                                    <label for="email">Email</label>
                                    <input type="email" name="email" id="email" class="input-field" placeholder="haundhe176911@fpt.edu.vn" />
                                </div>
                            </div>
                            <div class="input-container">
                                <div class="input-wrapper">
                                    <label for="lastName">Tittle</label>
                                    <input type="text" name="tittle" id="lastName" class="input-field" placeholder="Write here...." />
                                </div>
                            </div>
                            <label class="message-label" for="message"></label>
                            <textarea name="content" id="message" class="message-field" placeholder="Write your message.." rows="5"></textarea>

                            <button type="submit" class="send-button">Send Message</button>
                        </div>
                    </form>
>>>>>>> 8d31409bbc7395d019269cc4072bfe83377cdc3c
                </div>
            </div>
        </div>
        <section class="contact-section">           
            <div class="col-lg-12 m-b30">                
                <div class="widget-box">                   
                    <div class="widget-inner">
                        <form action="contactus" method="post" class="edit-profile m-b30">
                            <div class="row">                              
                                <div class="form-group col-6">
                                    <label class="col-form-label">Full Name</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <input class="form-control" name="name" type="text" value="${fullname}">
                                        <p class="error-message">${errorName}</p>
                                    </div>
                                </div>
                                <div class="form-group col-6">
                                    <label class="col-form-label">Email</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <input class="form-control" name="email" type="text" value="${email}">
                                        <p class="error-message">${errorEmail}</p>
                                    </div>
                                </div>
                                <div class="form-group col-6">
                                    <label class="col-form-label">Phone Number</label>                                   
                                    <div>
                                        <input class="form-control" type="text" name="phone" value="${phone}">
                                         <p class="error-message">${errorPhone}</p>
                                    </div>
                                </div>
                                <div class="form-group col-6">
                                    <label class="col-form-label">Choose Application Type</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <select name="typeForm" class="form-control">
                                            <c:set var="count" value="1"/>    
                                            <c:forEach var="listType" items="${listType}">
                                                <option value="${listType.key}">${listType.value}</option>
                                                <c:set var="count" value="${count + 1}"/>
                                            </c:forEach>             
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group col-12">
                                    <label class="col-form-label">Tittle</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <input class="form-control" name="tittle" type="text" value="${tittle}">
                                         <p class="error-message">${errorTittle}</p>
                                    </div>
                                </div>
                                <div class="form-group col-12">
                                    <label class="col-form-label">Content</label>
                                    <span style="color: red">*</span>
                                    <div>
                                        <textarea class="form-control" name="content">
                                            <c:if test="${content != null}">${content}</c:if>
                                        </textarea>
                                         <p class="error-message">${errorContent}</p>
                                    </div>
                                </div>
                                <div class="seperator"></div>
                                <div class="col-12">
                                    <button type="submit" class="btn">Submit</button>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <!--<div class="contact-container">-->
            <!--<div class="contact-inner">-->
            <!--                    <div class="contact-info">
                                    <h3 class="contact-info-title">Contact Information</h3>
                                    <p class="contact-info-description">Say something to start a live chat!</p>
                                    <div class="contact-info-details">
                                        <div class="detail-item">
                                            <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/16efcee12261d35860456522f48970b4da39ef461d25553ee37bea2a565d1633?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Phone icon" />
                                            <span>+1012 3456 789</span>
                                        </div>
                                        <div class="detail-item">
                                            <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/f33a12af71453b99485ac9031fecc220eb9409e1999afd1ffbb8eef1e6b8f8f2?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Email icon" />
                                            <span>demo@gmail.com</span>
                                        </div>
                                        <div class="detail-item">
                                            <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/0a95236edbb272ad63891b22868a195f09637d663fca1420ca3cc4475295718e?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Location icon" />
                                            <span>132 Dartmouth Street Boston, Massachusetts 02156 United States</span>
                                        </div>
                                    </div>
                                    <div class="social-icons">
                                        <div class="social-icons-inner">
                                            <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/66ea2ff0f2515af5a51b7f233b1f409d364b5f0df83ffedf8c136b50bc3d9bb9?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Social icon 1" />
                                            <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/84bd54cc61c32ab35ff49f9a2f55e95c5923cd3a45cbff32064de123a6557787?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Social icon 2" />
                                            <img src="https://cdn.builder.io/api/v1/image/assets/TEMP/bb81d9e3889282d2a223a859cf8071d4c31be8305c4258e539dca8a5efabc91c?apiKey=9802f090930545ed9e8e7106f2abf67d&" alt="Social icon 3" />
                                        </div>
                                    </div>
                                </div>-->
            <!--                    <form class="form-section" action="saveForm" method="POST">
                                    <div class="form-title">
            
                                        <div class="name-group">
                                            <div class="input-wrapper">
                                                <label for="firstName">FullName</label>
                                                <input type="text" name="fullName" id="firstName" class="input-field" placeholder="Nguyen Duc Hau" />
                                            </div>
                                            <div class="input-wrapper">
                                                <label for="email">Email</label>
                                                <input type="email" name="email" id="email" class="input-field" placeholder="haundhe176911@fpt.edu.vn" />
                                            </div>
                                        </div>
                                        <div class="input-container">
                                            <div class="input-wrapper">
                                                <label for="lastName">Tittle</label>
                                                <input type="text" name="tittle" id="lastName" class="input-field" placeholder="Write here...." />
                                            </div>
                                        </div>
                                        <label class="message-label" for="message"></label>
                                        <textarea name="content" id="message" class="message-field" placeholder="Write your message.." rows="5"></textarea>
            
                                        <button type="submit" class="send-button">Send Message</button>
                                    </div>
                                </form>-->



            <!--</div>-->
            <!--</div>-->
        </section>
<<<<<<< HEAD
        <%@ include file="Footer.jsp" %>
        <!--        <style>
                    .contact-info-box {
                        width: 100%;
                        background-position: center;
                        margin-bottom: 40px;
        
                    }
                    .contact-info-box .background img{
                        position: absolute;
                        top: 0;
                        left: 0;
                        width: 100%;
                        height: 100%;
                        z-index: -1;
                        object-fit: cover;
                        opacity: 0.8;
                    }
                    .contact-section {
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                        padding: 0 20px;
                    }
                    .home-link {
                        display: inline-block; /* Đảm bảo liên kết và ảnh được hiển thị theo hàng ngang */
                    }
        
                    .contact-subheading {
                        color: #fff;
                        text-align: center;
                        margin-top: 32px;
                        font: 500 35px Poppins, sans-serif;
                        font-weight: bold;
        
                    }
                    @media (max-width: 991px) {
                        .contact-subheading {
                            max-width: 100%;
                        }
                    }
                    .contact-container {
                        border-radius: 10px;
                        box-shadow: 0px 0px 60px 30px rgba(0, 0, 0, 0.03);
                        background-color: #fff;
                        width: 100%;
                        margin-top: 52px;
                        padding: 20px 50px;
                    }
                    @media (max-width: 991px) {
                        .contact-container {
                            max-width: 100%;
                            padding-right: 20px;
                        }
                    }
                    .contact-inner {
                        display: flex;
                        gap: 20px;
                    }
                    @media (max-width: 991px) {
                        .contact-inner {
                            flex-direction: column;
                            gap: 0;
                        }
                    }
                    .contact-info {
                        background-color: #FFA500;
                        border-radius: 10px;
                        display: flex;
                        flex-direction: column;
                        width: 45%;
                        padding: 0 39px ;
                        margin-top: -10px;
                    }
                    @media (max-width: 991px) {
                        .contact-info {
                            width: 100%;
                            margin-top: 40px;
                        }
                    }
                    .contact-info-title {
                        color: #fff;
                        font: 600 28px Poppins, sans-serif;
                    }
                    .contact-info-description {
                        color: #c9c9c9;
                        margin-top: 23px;
                        font: 400 18px Poppins, sans-serif;
                    }
                    .contact-info-details {
                        display: flex;
                        flex-direction: column;
                        margin-top: 40px;
                        font-size: 16px;
                        color: #fff;
                        font-weight: 400;
                    }
                    .detail-item {
                        display: flex;
                        align-items: center;
                        margin-top: 20px;
                        gap: 20px;
                    }
                    .detail-item img {
                        aspect-ratio: 1;
                        width: 24px;
                    }
                    .social-icons {
                        margin-top: 48px;
                    }
                    .social-icons-inner {
                        display: flex;
                        gap: 20px;
                    }
                    .social-icons-inner img {
                        width: 30px;
                        aspect-ratio: 1;
                    }
                    .form-section {
                        width: 55%;
                        display: flex;
                        flex-direction: column;
                    }
                    @media (max-width: 991px) {
                        .form-section {
                            width: 100%;
                        }
                    }
                    .form-title {
                        margin-top: 55px;
                        font-weight: 500;
                    }
                    @media (max-width: 991px) {
                        .form-title {
                            margin-top: 40px;
                        }
                    }
                    .form-group {
                        display: flex;
                        gap: 20px;
                    }
                    @media (max-width: 991px) {
                        .form-group {
                            flex-wrap: wrap;
                        }
                    }
                    .input-wrapper {
                        display: flex;
                        flex-direction: column;
                        font-size: 12px;
                        color: #8d8d8d;
                        flex-grow: 1;
        
                    }
                    .input-wrapper label {
                        font-family: Poppins, sans-serif;
        
                    }
        
                    .name-group *{
                        margin-top: 20px; /* Đặt khoảng cách 20px giữa phần name-group và phần form-group bên trên */
                    }
        
        
                    .input-field {
                        margin-top: 15px;
                        padding: 10px;
                        border: 1px solid #8d8d8d;
                        border-radius: 5px;
                    }
                    .input-container {
                        display: flex;
                        gap: 20px;
                        margin-top: 49px;
                    }
                    .input-info {
                        display: flex;
                        flex-direction: column;
                        color: #000;
                    }
                    .input-info label {
                        font: 12px/167% Poppins, sans-serif;
                    }
                    .input-info div {
                        margin-top: 16px;
                        font: 14px/143% Poppins, sans-serif;
                    }
                    .option-item {
                        display: flex;
                        gap: 10px;
                    }
                    .option-item img {
                        aspect-ratio: 1;
                        width: 13px;
                    }
                    .message-label {
                        margin-top: 54px;
                        font: 12px/167% Poppins, sans-serif;
                        color: #8d8d8d;
                    }
                    .message-field {
                        margin-top: 13px;
                        padding: 15px;
                        border: 1px solid #8d8d8d;
                        border-radius: 5px;
                        font: 14px/143% Poppins, sans-serif;
                        color: #8d8d8d;
                        margin-bottom: 40px;
                        width: 510px;
                    }
                    .send-button {
                        margin-top: 20px; /* Khoảng cách từ phía trên */
                        margin-left: auto; /* Căn giữa theo trục ngang */
                        margin-right: auto; /* Căn giữa theo trục ngang */
                        padding: 15px 48px;
                        background-color: #FFA500;
                        color: #fff;
                        text-align: center;
                        font: 16px Poppins, sans-serif;
                        border-radius: 5px;
                        cursor: pointer;
                        box-shadow: 0px 0px 14px 0px rgba(0, 0, 0, 0.12);
                        margin-right: 100px;
                    }
                    .send-button:focus {
                        outline: none;
                    }
                    @media (max-width: 991px) {
                        .send-button {
                            margin-top: 40px;
                            padding: 0 20px;
                        }
                    }
                </style>-->
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
=======

>>>>>>> 8d31409bbc7395d019269cc4072bfe83377cdc3c
    </body>
</html>
