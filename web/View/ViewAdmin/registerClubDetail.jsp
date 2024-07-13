<%-- 
    Document   : registerclub
    Created on : May 27, 2024, 8:01:46 AM
    Author     : Nguyen Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
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

        <!-- SHORTCODES ============================================= -->        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/shortcodes/shortcodes.css">

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/style.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/color/color-1.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <title>JSP Page</title>
        <style>.modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0, 0, 0, 0.4);
                
            }

            .modal-content {
                background-color: #fefefe;
                margin: 15% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
                box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
                border-radius: 10px;
            }
            .modal-content p{
                text-align: center;
            }

            .close {
                color: #aaaaaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: #000;
                text-decoration: none;
                cursor: pointer;
            }

            .modal-buttons {
                text-align: center;
                margin-top: 20px;
            }

            .modal-buttons button {
                margin: 0 10px;
            }</style>
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
                height: 15vh; /* 60% of the viewport height */
                width: 100%;
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
        <style>
            .btn {
                padding: 10px 20px;
                font-size: 16px;
                border: none;
                cursor: pointer;
            }
            .btn-success {
                background-color: #28a745;
                color: white;
            }
            .btn-danger {
                background-color: #dc3545;
                color: white;
            }
            .btn + .btn {
                margin-left: 10px;
            }
        </style>
    </head>
    <body>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            
                <div class="aaaa" style="padding-left: 50px;">
                    <a href="RegisterclubAdmin" style="height: 50px;font-size: 15px;margin-top: 15px;">
                        <i class="fa fa-sign-out-alt fa-4x" ></i> 
                    </a>
                </div>
      
            <!-- header END ==== -->
            <!-- Content -->
            <div class="page-content bg-white">
                <!-- inner page banner -->
                <c:set var="club" value="${requestScope.club}"/>
                <!-- Breadcrumb row -->
                <div style="padding-top: 20px;padding-bottom: 20px;" > 


                    <div class="form-container" >
                        <div class="form-group" >
                            <label for="NameClub">Student Name</label>
                            <input  value="${club.getNamebyID()}"/>

                        </div>
                        <div class="form-group" >
                            <label for="NameClub">Club Name</label>
                            <input value="${club.getNameclub()}"/>

                        </div>
                        <div class="form-group">
                            <label for="clubId">Type of Club</label>
                            <select id="clubId" name="idClub" class="input-field" required>
                                <option value="">${club.getTypeclub()}</option>
                                <c:forEach items="${requestScope.listtypeclub}" var="getTypeClub"> 
                                    <option value="${getTypeClub}">${getTypeClub}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group" >
                            <label for="NameClub">Desired Number Of Members</label>
                            <input value="${club.getMember()}"/>
                        </div>
                        <div class="form-group">
                            <label for="Reason">Reason</label>
                            <textarea id="Reason" name="Reason" rows="10" cols="50" >
                                ${club.getReason()}
                            </textarea>
                            <br>
                        </div>
                        <div class="form-group">
                            <label for="Reason">Target</label>
                            <textarea  name="Target" rows="10" cols="50" >
                                ${club.getTarget()}
                            </textarea>
                            <br>
                        </div>
                        <div class="form-group" >
                            <label for="Reason">Plan</label>
                            <textarea  name="Plan" rows="10" cols="50" >
                                ${club.getPlan()}
                            </textarea>
                            <br>
                        </div>
                        <div id="confirmModal" class="modal">
                            <div class="modal-content">
                                <span class="close" onclick="closeModal()">&times;</span>
                                <p id="modalText"></p>
                                <div class="modal-buttons">
                                    <button id="confirmBtn" class="btn btn-success">Confirm</button>
                                    <button class="btn btn-danger" onclick="closeModal()">Cancel</button>
                                </div>
                            </div>
                        </div>

                        <!-- Form -->
                        <form id="clubActionForm" action="" method="POST">
                            <div class="form-group">
                                <label for="Reason">Refuse Reason</label>
                                <textarea name="refuse" rows="10" cols="50">${club.getRefuse()}</textarea>
                                <br>
                                <h6>${error}</h6>
                            </div>
                            <div class="form-group">
                                <!-- Nút "Refuse" -->
                                <button type="button" onclick="openModal('Refuse')" class="btn btn-danger">Refuse</button>
                                <!-- Nút "Accept" -->
                                <button type="button" onclick="openModal('Accept')" class="btn btn-success">Accept</button>
                            </div>
                        </form>

                    </div>    
                    </>
                    <!-- Breadcrumb row END -->
                    <!-- inner page banner END -->

                    <!-- contact area END -->

                </div>
                <!-- Content END-->
                <!-- Footer ==== -->

                <!-- Footer END ==== -->

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

            <script>function openModal(actionType) {
                var modal = document.getElementById('confirmModal');
                modal.style.display = 'block';

                var modalText = document.getElementById('modalText');
                if (actionType === 'Refuse') {
                    modalText.textContent = 'Are you sure you want to refuse this request?';
                    // Thiết lập action của form cho "Refuse"
                    document.getElementById('clubActionForm').action = 'Refuseclub?id=${club.getIdregister()}';
                } else if (actionType === 'Accept') {
                    modalText.textContent = 'Are you sure you want to accept this request?';
                    // Thiết lập action của form cho "Accept"
                    document.getElementById('clubActionForm').action = 'SetStatusClubController?id=${club.getIdregister()}';
                }
            }

// Đóng modal
            function closeModal() {
                var modal = document.getElementById('confirmModal');
                modal.style.display = 'none';
            }

// Xác nhận hành động và submit form
            document.getElementById('confirmBtn').addEventListener('click', function () {
                document.getElementById('clubActionForm').submit();
                closeModal(); // Đóng modal sau khi xác nhận
            });</script>

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
