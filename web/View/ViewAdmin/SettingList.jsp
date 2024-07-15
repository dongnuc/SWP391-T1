<%-- 
    Document   : SettingList
    Created on : Jun 17, 2024, 6:11:44 AM
    Author     : Admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:08:15 GMT -->
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
        <!--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/View/ViewAdmin/assets/css/ClubAdmin.css">-->
        <style>
            /* Reset một số thuộc tính mặc định của bảng */
            table {
                border-collapse: collapse;
                width: 100%;
                margin: 20px 0;
                font-size: 18px;
                text-align: left;
            }

            /* Kiểu dáng cho bảng */
            .styled-table {
                border: 1px solid #dddddd;
                font-family: Arial, sans-serif;
                border-radius: 5px;
                overflow: hidden;
                box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
            }

            /* Kiểu dáng cho hàng đầu tiên (thead) */
            .styled-table thead tr {
                background-color: #009879;
                color: #ffffff;
                text-align: left;
                font-weight: bold;
            }

            /* Kiểu dáng cho các hàng dữ liệu (tbody) */
            .styled-table tbody tr {
                border-bottom: 1px solid #dddddd;
            }

            .styled-table tbody tr:nth-of-type(even) {
                background-color: #f3f3f3;
            }

            .styled-table tbody tr:last-of-type {
                border-bottom: 2px solid #009879;
            }

            /* Thêm hiệu ứng hover */
            .styled-table tbody tr:hover {
                background-color: #f1f1f1;
            }

            /* Kiểu dáng cho các ô (th, td) */
            .styled-table th,
            .styled-table td {
                padding: 12px 15px;
            }

            .data-option {
                display: flex;
                align-items: center; /* Căn giữa các phần tử theo chiều dọc */
            }

            .data-option input[type="text"] {
                height: 36px;
                margin-right: 10px; /* Khoảng cách giữa input và select */
                padding: 5px;
                font-size: 14px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .select-role select {
                padding: 5px;
                font-size: 14px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .popUp {
                display: none;
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                width: 500px;
                margin: 0 auto;
                border: solid 1px black;
                background-color: white;
                z-index: 1000;
                padding: 20px;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            }

            .overlay {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.5);
                z-index: 999;
            }

            .btn-close {
                background: none;
                border: none;
                font-size: 20px;
                cursor: pointer;
                position: absolute;
                top: 10px;
                right: 10px;
            }
            .modal-content {
                background-color: #fefefe;
                margin: 5% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 80%;
                max-width: 500px;
            }

            /* Close button */
            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: black;
                text-decoration: none;
                cursor: pointer;
            }
            .modalForm{
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgb(0,0,0);
                background-color: rgba(0,0,0,0.4);
                padding-top: 60px;
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
                        <li><a href="dashboardAdmin"><i class="fa fa-home"></i>Home</a></li>
                        <li>Setting List</li>
                    </ul>
                </div>	
                <!-- Card -->

                <!-- Card END -->
                <div class="row">
                    <!-- Your Profile Views Chart -->

                    <!-- Your Profile Views Chart END-->



                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">

                            <form action="settingList">
                                <div class="card-body">
                                    <div class="data-option">
                                        <input name="search" type="text" value="${search}" placeholder="Search name here">
                                        <div class="select-role" >
                                            <select class="no" name="idType"
                                                    style="margin-right: 10px; height: 36px;"
                                                    onchange="return this.closest('form').submit()" >
                                                <option value="All" ${listType.value eq typeSetting ? 'selected' : ''} >All</option>
                                                <c:forEach var="listType" items="${listType}">
                                                    <option value="${listType.key}" ${listType.key eq typeSetting ? 'selected' : ''} >${listType.value}</option>
                                                </c:forEach>
                                            </select>
                                            <select class="no" name="status"
                                                    style="margin-right: 10px; height: 36px;"
                                                    onchange="return this.closest('form').submit()" >
                                                <option value="1" ${status eq '1' ? 'selected':''}>Active</option>
                                                <option value="0" ${status eq '0' ? 'selected':''}>Inactive</option>
                                            </select>
                                        </div>
                                        <input type="submit" value="Search" >

                                    </div>

                                    <table class="styled-table" id="datatablesSimple" border="1px" style="margin-bottom: 0px">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name Setting</th>
                                                <th>Type Setting</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach var="listSetting" items="${listSetting}">
                                                <tr>
                                                    <td>${listSetting.idSetting}</td>
                                                    <td>${listSetting.nameSetting}</td>                                                    
                                                    <td>${listSetting.typeSetting}</td>
                                                    <c:if test="${listSetting.status != 1}">
                                                        <td>Inactive</td>
                                                    </c:if>

                                                    <c:if test="${listSetting.status == 1}">
                                                        <td>Active</td>
                                                    </c:if>
                                                    <td>       
                                                        <button type="button" onclick="editSetting(${listSetting.idSetting})" style="border: none;"><i class="fa fa-edit">Edit</i></button>
                                                        <c:if test="${listSetting.status == 1}">
                                                            <button id="confirmButton" type="button" onclick="showConfirmationModal(${listSetting.idSetting},${listSetting.status})" style="border: none;">
                                                                <i class="fa fa-edit">Inactive</i>
                                                            </button>
                                                        </c:if>

                                                        <c:if test="${listSetting.status != 1}">
                                                            <button id="confirmButton" type="button" onclick="showConfirmationModal(${listSetting.idSetting},${listSetting.status})" style="border: none;">
                                                                <i class="fa fa-edit">Active</i>
                                                            </button>
                                                        </c:if>
                                                    </td>

                                                </c:forEach>

                                            </tr>
                                        </tbody>
                                    </table>
                                    <div class="row text-center">
                                        <!-- PAGINATION START -->
                                        <div class="col-12 mt-4">
                                            <div class="d-md-flex align-items-center text-center justify-content-between">
                                                <ul class="pagination justify-content-center mb-0 mt-3 mt-sm-0">
                                                    <c:if test="${pageCurrent>1}">
                                                        <li class="page-item"><a class="page-link" 
                                                                                 href="settingList?page=${pageCurrent - 1}&search=${search}&status=${status}&idType=${typeSetting}"
                                                                                 aria-label="Previous">Prev</a></li>
                                                        </c:if>
                                                        <c:if test="${numberPage-pageCurrent>=1}">
                                                        <li class="page-item"><a class="page-link"
                                                                                 href="settingList?page=${pageCurrent + 1}&search=${search}&status=${status}&idType=${typeSetting}">
                                                                ${pageCurrent+1}</a></li>
                                                            </c:if>
                                                            <c:if test="${numberPage - pageCurrent>=2}">
                                                        <li class="page-item"><a class="page-link"
                                                                                 href="settingList?page=${pageCurrent + 2}&search=${search}&status=${status}&idType=${typeSetting}">
                                                                ${pageCurrent+2}</a></li>
                                                            </c:if>
                                                            <c:if test="${pageCurrent < numberPage}">
                                                        <li class="page-item"><a class="page-link"
                                                                                 href="settingList?page=${pageCurrent + 1}&search=${search}&status=${status}&idType=${typeSetting}"
                                                                                 aria-label="Next">Next</a></li>
                                                        </c:if>
                                                </ul>
                                            </div>
                                        </div><!--end col
                                        <!-- PAGINATION END -->
                                    </div><!--end row-->        
                                    <div id="confirmationModal" class="modalForm" >
                                        <div class="modal-content">
                                            <span class="close" onclick="closeModal()">&times;</span>
                                            <p>Are you sure you want to perform this action?</p>
                                            <button type="button" onclick="confirmAction()">Yes</button>
                                            <button type="button" onclick="closeModal()">Cancel</button>
                                        </div>
                                    </div>
                                </div>

                            </form>

                        </div>

                    </div>
                </div>

            </div>

        </main>

        <div class="overlay"></div>
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
        <script src='${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/calendar/moment.min.js'></script>
        <script src='${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/calendar/fullcalendar.js'></script>
        <script src='${pageContext.request.contextPath}/View/ViewAdmin/assets/vendors/switcher/switcher.js'></script>
        <script>
                                                var confirmButton = document.getElementById("confirmButton");
                                                function editSetting(idSetting) {

                                                    var hrefEdit = "http://localhost:9999/SWP391/editSetting?idSetting=" + idSetting;
                                                    window.location.href = hrefEdit;
                                                }
                                                function showConfirmationModal(idSetting, status) {
                                                    console.log(idSetting);
                                                    console.log(status)
                                                    var modal = document.getElementById("confirmationModal");
                                                    confirmButton.setAttribute("data-idSetting", idSetting);
                                                    confirmButton.setAttribute("data-status", status);
                                                    modal.style.display = "block";
                                                }
                                                function closeModal() {
                                                    var modal = document.getElementById("confirmationModal");
                                                    modal.style.display = "none";
                                                }
                                                function confirmAction() {
                                                    var idsetting = confirmButton.getAttribute("data-idSetting");
                                                    var statusRaw = confirmButton.getAttribute("data-status");
                                                    changeStatus(idsetting, statusRaw);
                                                    closeModal();
                                                }

                                                function changeStatus(idsetting, status) {
                                                    var statusUpdate;

                                                    if (status == 1) {
                                                        statusUpdate = 0;
                                                    } else {
                                                        statusUpdate = 1;
                                                    }

                                                    $.ajax({
                                                        url: "/SWP391/updateSetting",
                                                        type: "get", //send it through get method
                                                        data: {
                                                            idSetting: idsetting,
                                                            status: statusUpdate
                                                        },
                                                        success: function (response) {
                                                            location.reload();
                                                        },
                                                        error: function (xhr) {
                                                            //Do Something to handle error
                                                        }
                                                    });
                                                }


        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>

