<%-- 
    Document   : Dashboard
    Created on : May 20, 2024, 10:52:00 PM
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
                    <h4 class="breadcrumb-title">Club List</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="dashboardAdmin"><i class="fa fa-home"></i>Home</a></li>
                        <li>Club List</li>
                    </ul>
                </div>	
                <!-- Card -->

                <!-- Card END -->
                <div class="row">
                    <!-- Your Profile Views Chart -->

                    <!-- Your Profile Views Chart END-->



                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">

                            <form action="managerClub">
                                <div class="card-body">
                                    <div class="data-option">
                                        <input name="nameSearch" type="text" value="${nameSearch}" placeholder="Search name here">
                                        <div class="select-role" >
                                            <select class="no" name="typeClub"
                                                    style="margin-right: 10px; height: 36px;"
                                                    onchange="return this.closest('form').submit()" >
                                                <option value="">Select All</option>
                                                <c:forEach var="listType" items="${listType}">
                                                    <option value="${listType}" ${listType eq option ? 'selected' : ''} >${listType}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <input type="submit" value="Search" >

                                    </div>

                                    <table class="styled-table" id="datatablesSimple" border="1px" style="margin-bottom: 0px">
                                        <thead>
                                            <tr>
                                                <th>ID</th>
                                                <th>Name Club</th>
                                                <th>Point</th>
                                                <th>Type Club</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="listclub" items="${listClub}">
                                                <tr id="idClub${listclub.club}">
                                                    <td>${listclub.club}</td>
                                                    <td>${listclub.nameclub}</td>
                                                    <td>${listclub.point}</td>
                                                    <td>${listclub.typeClub}</td>
                                                    <c:if test="${listclub.status != 1}">
                                                        <td>Unactive</td>
                                                    </c:if>

                                                    <c:if test="${listclub.status == 1}">
                                                        <td>Active</td>
                                                    </c:if>
                                                    <td>
                                                        
                                                            <a href="getClub?idClub=${listclub.club}"
                                                               style="margin-right: 5px"><i class="fa fa-edit">Edit</i></a>
                                                        </button>
                                                        <c:if test="${listclub.status == 1}">
                                                            <a href="updateClub?idClub=${listclub.club}&status=${listclub.status}"
                                                               style="margin-right: 5px"><i class="fa fa-trash-o"> Unactive</i></a>
                                                        </c:if>

                                                        <c:if test="${listclub.status != 1}">
                                                            <a href="updateClub?idClub=${listclub.club}&status=${listclub.status}"
                                                               style="margin-right: 5px"><i class="fa fa-trash-o"> Active</i></a>
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
                                                                                 href="managerClub?page=${pageCurrent - 1}&nameSearch=${nameSearch}&option=${option}"
                                                                                 aria-label="Previous">Prev</a></li>
                                                        </c:if>
                                                        <c:if test="${numberPage-pageCurrent>=1}">
                                                        <li class="page-item"><a class="page-link"
                                                                                 href="managerClub?page=${pageCurrent + 1}&nameSearch=${nameSearch}&option=${option}">
                                                                ${pageCurrent+1}</a></li>
                                                            </c:if>
                                                            <c:if test="${numberPage - pageCurrent>=2}">
                                                        <li class="page-item"><a class="page-link"
                                                                                 href="managerClub?page=${pageCurrent + 2}&nameSearch=${nameSearch}&option=${option}">
                                                                ${pageCurrent+2}</a></li>
                                                            </c:if>
                                                            <c:if test="${pageCurrent < numberPage}">
                                                        <li class="page-item"><a class="page-link"
                                                                                 href="managerClub?page=${pageCurrent + 1}&nameSearch=${nameSearch}&option=${option}"
                                                                                 aria-label="Next">Next</a></li>
                                                        </c:if>


                                                </ul>
                                            </div>
                                        </div><!--end col
                                        <!-- PAGINATION END -->
                                    </div><!--end row-->        

                                </div>
                            </form>
                            <div class="popUp" style="width: 500px;margin: 0px auto; border: solid 1px black">
                                <form action="updateClub" class="edit-profile m-b30">
                                    <div class="row">
                                        <div class="form-group col-12" style="left: 32px;bottom: 48px;">
                                            <button type="button" onclick="closeFormEdit()" class="closeForm btn-close"><i class="fa fa-close"></i></button>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Name Club</label>
                                            <div>
                                                <input name="nameClub" id="nameClub" class="form-control" type="text" value="">
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Points</label>
                                            <div>
                                                <input name="points" id="pointsClub" class="form-control" type="text" value="">
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Date Create</label>
                                            <div>
                                                <input id="dateCreateClub" class="form-control" type="text" value="">
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Date Modify</label>
                                            <div>
                                                <input id="dateModifyClub" class="form-control" type="text" value="">
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Type Club</label>
                                            <div >
                                                <select id="typeClubForm" class="no" name="typeClub"
                                                        style="margin-right: 10px; height: 36px;">
                                                    <c:forEach var="listType" items="${listType}">
                                                        <option value="${listType}" ${listType eq option ? 'selected' : ''} >${listType}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                        <input type="hidden" id="idClubForm" name="idClub">
                                        <div class="seperator"></div>
                                        <div class="col-12">
                                            <button type="submit" class="btn">Save changes</button>
                                        </div>
                                    </div>
                                </form> 
                            </div>
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
                                                function openFormEdit(idClub) {
                                                    var popUpForm = document.getElementsByClassName("popUp")[0];
                                                    var overLay = document.getElementsByClassName("overlay")[0];
                                                    var optionsClub = document.getElementById("typeClubForm");
                                                    var optionClubValue = optionsClub.options;

                                                    console.log(idClub);
                                                    popUpForm.style.display = "block";
                                                    overLay.style.display = "block";

                                                    $.ajax({
                                                        url: "/SWP391/getClub",
                                                        type: "get", //send it through get method
                                                        data: {
                                                            idClub: idClub
                                                        },
                                                        success: function (response) {
                                                            console.log(response);
                                                            var lines = response.split("\n");
                                                            var nameClub = lines[0];
                                                            var points = lines[1];
                                                            var typeClub = lines[2];
                                                            var dateCreate = lines[3];
                                                            var dateModify = lines[4];
                                                            $('#idClubForm').val(idClub);
                                                            $('#nameClub').val(nameClub);
                                                            $('#pointsClub').val(points);
                                                            $('#dateCreateClub').val(dateCreate);
                                                            $('#dateModifyClub').val(dateModify);
                                                            console.log(typeClub);
                                                            for (var i = 0; i < optionClubValue.length; i++) {
                                                                console.log(optionClubValue[i].value);
                                                                var testSelected = optionClubValue[i].value + "\r";
                                                                if (testSelected == typeClub) {
                                                                    console.log("selected");
                                                                    optionClubValue[i].selected = true;
                                                                }

                                                            }
                                                        },
                                                        error: function (xhr) {
                                                            //Do Something to handle error
                                                        }
                                                    });
                                                }
                                                function closeFormEdit() {
                                                    var popUpForm = document.getElementsByClassName("popUp")[0];
                                                    var overLay = document.getElementsByClassName("overlay")[0];
                                                    popUpForm.style.display = "none";
                                                    overLay.style.display = "none";
                                                }


        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
