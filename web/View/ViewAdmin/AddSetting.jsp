<%-- 
    Document   : AddSetting
    Created on : Jun 20, 2024, 8:23:22 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
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
        <link rel="shortcut icon" type="image/x-icon" href="assets/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Add Setting</title>

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
            .success-message {
                background-color: #4CAF50; /* Màu nền */
                color: white; /* Màu chữ */
                text-align: center; /* Căn giữa văn bản */
                padding: 10px; /* Khoảng cách padding */
                position: fixed; /* Vị trí cố định */
                top: 0; /* Ở phía trên cùng */
                left: 50%; /* Căn giữa theo chiều ngang */
                transform: translateX(-50%); /* Dịch chuyển về trái 50% */
                z-index: 1000; /* Độ sâu */
                width: 300px; /* Độ rộng */
                box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2); /* Hiệu ứng đổ bóng */
                border-radius: 5px; /* Bo góc */
            }

            /* CSS để ẩn thông báo ban đầu */
            .hidden {
                display: none; /* Ẩn đi */
            }
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
                    <h4 class="breadcrumb-title">Setting List</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="loadForm"><i class="fa fa-home"></i>Home</a></li>
                        <li>Add Setting</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="popUp" style="width: 500px;margin: 0px auto; border: solid 1px black">
                        <form action="addSetting" method="post" class="edit-profile m-b30">
                            <div class="row">
                                <div class="form-group col-6">
                                    <label class="col-form-label">Setting Name</label>
                                    <div>

                                        <input name="nameSetting" id="nameClub" class="form-control" type="text" value="${nameSetting}">
                                        <p class="error-message">${errorName}</p>
                                    </div>
                                </div>


                                <div class="form-group col-6" id="listAccManager" >
                                    <label class="col-form-label">Accounts</label>
                                    <div>
                                        <select class="form-control" id="" name="idAccAss">
                                            <c:forEach var="listAcc" items="${listAccAss}">
                                                <option value="${listAcc.id}" ${listAcc.id eq accManager ? 'selected': ''}>${listAcc.name}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group col-12" >
                                    <label class="col-form-label">Status</label>
                                    <div>
                                        Active <input id="dateCreateClub" name="status" 
                                                      type="radio" ${status == 1 ? 'checked':''} value="1">
                                        Unactive <input id="dateCreateClub" name="status" 
                                                        type="radio" ${status == 0 ? 'checked':''} value="0">
                                        <p class="error-message">${errorStatus}</p>
                                    </div>
                                </div>
                                <div class="form-group col-12">
                                    <label class="col-form-label">Setting Type</label>
                                    <div >
                                        <select class="form-control" id="typeSettings" class="no" name="typeSetting"
                                                style="margin-right: 10px; height: 36px;" onchange="changeTypeForm()">
                                            <c:forEach var="listType" items="${listType}">
                                                <option value="${listType.key}" ${listType.value eq typeSetting ? 'selected':''} >${listType.value}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="seperator"></div>
                                <div class="col-12">
                                    <button type="submit" class="btn">Insert Setting</button>
                                </div>
                            </div>
                        </form> 
                    </div>
                    <!-- Your Profile Views Chart END-->
                </div>
            </div>
            <div id="success-message" class="success-message hidden">
                Add successfully!
            </div>
        </main>
        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/bootstrap/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/bootstrap/js/bootstrap.min.js"></script>
        <!--<script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/bootstrap-select/bootstrap-select.min.js"></script>-->
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
        <!--<script src='assets/vendors/switcher/switcher.js'></script>-->
        <script>

                                                    $(document).ready(function () {
                                                        $('[data-toggle="tooltip"]').tooltip();
                                                    });
                                                    function showNotification() {
                                                        const notification = document.getElementById('success-message');
                                                        notification.style.display = 'block'; // Hiển thị thông báo
                                                        // Ẩn thông báo sau 2 giây (2000ms)
                                                        setTimeout(() => {
                                                            notification.style.display = 'none';
                                                        }, 2000);
                                                    }


                                                    function changeTypeForm() {
                                                        var selectElement = document.getElementById("typeSettings");
                                                        var accAssumeElement = document.getElementById("listAccManager");
                                                        var value = selectElement.value;
                                                        console.log(value);
                                                        if (selectElement.value == "2") {
                                                            console.log("2");
                                                            accAssumeElement.style.display = "block";
                                                        } else {
                                                            console.log("!2");
                                                            accAssumeElement.style.display = "none";
                                                        }
                                                    }
                                                    
                                                        const urlParams = new URLSearchParams(window.location.search);
                                                        if (urlParams.has('statusAdd') && urlParams.get('statusAdd') === 'success') {
                                                            // Hiển thị thông báo
                                                            showNotification();
                                                            urlParams.delete('statusAdd');
                                                            const newUrl = window.location.pathname + '?' + urlParams.toString();
                                                            // Cập nhật URL mà không tải lại trang
                                                            window.history.replaceState({}, document.title, newUrl);
                                                        }

                                                        // Kiểm tra giá trị của select element khi trang được tải
                                                       
                                                    




        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/mailbox.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>
