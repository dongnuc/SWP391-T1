<%-- 
    Document   : Dashboard
    Created on : May 20, 2024, 10:52:00 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

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

        <!-- Day la css
        <link rel="shortcut icon" href="../assets/images/favicon.ico.png">
        <!-- Bootstrap -->
        <link href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- simplebar -->
        <link href="<%= request.getContextPath() %>/assets/css/simplebar.css" rel="stylesheet" type="text/css" />
        <!-- Icons -->
        <link href="<%= request.getContextPath() %>/assets/css/materialdesignicons.min.css" rel="stylesheet" type="text/css" />
        <link href="<%= request.getContextPath() %>/assets/css/remixicon.css" rel="stylesheet" type="text/css" />
        <link href="https://unicons.iconscout.com/release/v3.0.6/css/line.css"  rel="stylesheet">
        <!-- Css -->
        <link href="<%= request.getContextPath() %>/assets/css/style.min.css" rel="stylesheet" type="text/css" id="theme-opt" />

    </head>
    <style>
        .abc{
            display: flex;
        }
        .xyz{
            margin-right: 20px;
        }
        select, input ,button {
            height: 100%;
        }
        .modal {
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
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto; /* Căn giữa modal */
            padding: 25px;
            border: 1px solid #888;
            width: 80%; /* Độ rộng của modal */
            max-width: 300px;
            text-align: center;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            position: absolute;
            right: 10px;
            top: 10px;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
        .toast {
            display: flex !important;
            align-items: center !important;
            background-color: #fff !important;
            border-radius: 2px !important;
            padding: 20px 0 !important;
            min-width: 400px !important;
            max-width: 450px !important;
            border-left: 4px solid !important;
            box-shadow: 0 5px 8px rgba(0, 0, 0, 0.08) !important;
            transition: all linear 0.3s !important;
            background: greenyellow !important;
            animation: slideInLeft 0.3s ease forwards, fadeOut 0.3s ease forwards 3s; 
        }
        .toast_icon {
            font-size: 24px;
            padding: 0 16px;
        }
        .toast_body {
            color: white !important;
            
        }
        #toast {
            position: fixed;
            top: 64px;
            right: 32px;

        }
        @keyframes slideInLeft {
            from {
                opacity: 0;
                transform: translateX(calc(100% + 32px));
            }
            to {
                opacity: 1;
                transform: translateX(0);
            }
        }
        @keyframes fadeOut {
            to {
                opacity: 0;
            }
        }
        .modal-content p {
            margin-top: 30px; 
        }
        .button-container {
            display: flex;
            justify-content: center;
            gap: 10px; /* Khoảng cách giữa các nút */
            margin-top: 20px; /* Khoảng cách từ đoạn văn tới nút */
        }

    </style>
    <%
    String check = (String) request.getAttribute("showtoast");
    %>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="Navigation.jsp"/>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <jsp:include page="LeftSideBar.jsp"/>
        <div id="confirmModal" class="modal">
            <div class="modal-content">
                <span class="close" style="margin-left: 10px">&times;</span>
                <p>Are you sure you want to change the status ?</p>
                <div class="button-container">
            <button id="confirmBtn">Yes</button>
            <button id="cancelBtn">No</button>
        </div>
            </div>
        </div>
        <!-- Left sidebar menu end -->
        <main class="ttr-wrapper">

            <div class="layout-specing">
                <div class="d-md-flex justify-content-between">
                    <h5 class="mb-0">Account List</h5> 
                    <form action="<%= request.getContextPath() %>/listaccount" method="get" class="form-inline" id="myForm"> 
                        <div class="abc">
                            <div class="xyz">
                                Sort By
                                <select name="sort" class="custom-select" onchange="submitForm()">
                                    <option value="IdStudent" <c:if test="${requestScope.sort=='IdStudent'}">selected</c:if>>ID</option>
                                    <option value="NameStudent" <c:if test="${requestScope.sort=='NameStudent'}">selected</c:if>>Name</option>
                                    <option value="Email" <c:if test="${requestScope.sort=='Email'}">selected</c:if>>Email</option>
                                    <option value="Phone" <c:if test="${requestScope.sort=='Phone'}">selected</c:if>>Mobile</option>
                                    </select>

                                    Status
                                    <select name="status" class="custom-select" onchange="submitForm()">
                                        <option value="all" <c:if test="${requestScope.status=='all'}">selected</c:if>>All</option>
                                    <option value="1" <c:if test="${requestScope.status=='1'}">selected</c:if>>Active</option>
                                    <option value="0" <c:if test="${requestScope.status=='0'}">selected</c:if>>Inactive</option>
                                    </select>
                                </div>

                                <div>
                                    <input type="text" name="search" value="${search}"> 
                                <button type="submit"> Search</button>
                                <div id="toast">

                                </div>


                            </div>
                        </div>

                    </form>
                    <nav aria-label="breadcrumb" class="d-inline-block mt-4 mt-sm-0">
                        <ul class="breadcrumb bg-transparent rounded mb-0 p-0">

                        </ul>
                    </nav>
                </div>
                <c:if test="${requestScope.pagemax!=0}">


                    <div class="row">
                        <div class="col-12 mt-4">
                            <div class="table-responsive shadow rounded">
                                <table class="table table-center bg-white mb-0">
                                    <thead>
                                        <tr>
                                            <th class="border-bottom p-3" style="min-width: 50px;">Id</th>
                                            <th class="border-bottom p-3" style="min-width: 180px;">Name</th>
                                            <th class="border-bottom p-3">Email</th>
                                            <th class="border-bottom p-3">Mobile</th>
                                            <th class="border-bottom p-3">Status</th>
                                            <th class="border-bottom p-3">Role</th>
                                            <th class="border-bottom p-3">Action</th>
                                            <th class="border-bottom p-3" style="min-width: 100px;"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${sessionScope.listaccount}" var="x">
                                            <tr>
                                                <th class="p-3">${x.id}</th>
                                                <td class="py-3">
                                                    <a href="#" class="text-dark">
                                                        <div class="d-flex align-items-center">
                                                            <span class="ms-2">${x.name}</span>
                                                        </div>
                                                    </a>
                                                </td>
                                                <td class="p-3">${x.email}</td>
                                                <td class="p-3">${x.sdt}</td>
                                                <td class="p-3"><c:choose>
                                                        <c:when test="${x.status == 1}">
                                                            Active
                                                        </c:when>
                                                        <c:otherwise>
                                                            Inactive
                                                        </c:otherwise>
                                                    </c:choose></td>
                                                <td class="p-3"><c:choose>
                                                        <c:when test="${x.role == 1}">
                                                            Admin
                                                        </c:when>
                                                        <c:otherwise>
                                                            User
                                                        </c:otherwise>
                                                    </c:choose></td>

                                                <td class="text-end p-3">
                                                    <a href="userdetail?emails=${x.email}" class="btn btn-icon btn-pills btn-soft-primary" data-bs-toggle="modal" data-bs-target="#viewprofile"><i class="uil uil-eye"></i></a>
                                                    <span style="display: inline-block; width: 20px;"></span>
                                                    <a href="listaccount?page=${requestScope.page}&search=${search}&status=${status}&email=${x.email}&statuss=${x.status}&sort=${sort}" onclick="confirmAction(event, this)"> <c:choose>
                                                            <c:when test="${x.status == 0}">
                                                                Activate
                                                            </c:when>
                                                            <c:otherwise>
                                                                Inactivate
                                                            </c:otherwise>
                                                        </c:choose></a>               
                                                </td>
                                            </c:forEach>
                                        </tr>


                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div><!--end row-->




                    <div class="row text-center">
                        <!-- PAGINATION START -->
                        <div class="col-12 mt-4">
                            <div class="d-md-flex align-items-center text-center justify-content-between">

                                <ul class="pagination justify-content-center mb-0 mt-3 mt-sm-0">
                                    <c:if test="${requestScope.page>1}">
                                        <li class="page-item"><a class="page-link" href="listaccount?page=${requestScope.page -1}&search=${search}&status=${status}&sort=${sort}" aria-label="Previous">Prev</a></li>
                                        </c:if>
                                    <!--<li class="page-item"><a class="page-link" href="javascript:void(0)" aria-label="Previous">Prev</a></li>-->
                                    <li class="page-item active"><a class="page-link" href="listaccount?page=${requestScope.page}&search=${search}&status=${status}&sort=${sort}">${requestScope.page}</a></li>
                                        <c:if test="${requestScope.pagemax-requestScope.page>=1}">
                                        <li class="page-item"><a class="page-link" href="listaccount?page=${requestScope.page + 1}&search=${search}&status=${status}&sort=${sort}">${requestScope.page+1}</a></li>
                                        </c:if>
                                        <c:if test="${requestScope.pagemax-requestScope.page>=2}">
                                        <li class="page-item"><a class="page-link" href="listaccount?page=${requestScope.page + 2}&search=${search}&status=${status}&sort=${sort}">${requestScope.page+2}</a></li>
                                        </c:if>
                                        <c:if test="${requestScope.page<requestScope.pagemax}">
                                        <li class="page-item"><a class="page-link" href="listaccount?page=${requestScope.page + 1}&search=${search}&sort=${sort}" aria-label="Next">Next</a></li>
                                        </c:if>


                                </ul>
                            </div>
                        </div><!--end col
                        <!-- PAGINATION END -->
                    </div><!--end row-->
                </div>
            </c:if>
            <c:if test="${requestScope.pagemax==0}">
                Not Found
            </c:if>

        </main>
        <!--Main container start --F


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
                                                        function submitForm() {
                                                            document.forms["myForm"].submit();
                                                        }
                                                        document.addEventListener('DOMContentLoaded', function () {
                                                            var modal = document.getElementById('confirmModal');
                                                            var span = document.getElementsByClassName('close')[0];
                                                            var confirmBtn = document.getElementById('confirmBtn');
                                                            var cancelBtn = document.getElementById('cancelBtn');
                                                            var currentLink = null;

                                                            // Mở modal khi nhấn vào link có xác nhận
                                                            window.confirmAction = function (event, link) {
                                                                event.preventDefault();
                                                                currentLink = link;
                                                                modal.style.display = 'block';
                                                            };

                                                            // Đóng modal khi nhấn vào dấu x
                                                            span.onclick = function () {
                                                                modal.style.display = 'none';
                                                            };

                                                            // Đóng modal khi nhấn vào nút No
                                                            cancelBtn.onclick = function () {
                                                                modal.style.display = 'none';
                                                            };


                                                            confirmBtn.onclick = function () {
                                                                if (currentLink) {
                                                                    window.location.href = currentLink.href;
                                                                }
                                                            };

                                                            // Đóng modal khi nhấn vào bất kỳ đâu ngoài modal
                                                            window.onclick = function (event) {
                                                                if (event.target == modal) {
                                                                    modal.style.display = 'none';
                                                                }
                                                            };
                                                        });
        </script>
        <script>
            window.onload = function () {
                var check = '<%= check %>';
                if (check === 'true') {
                    const toast = document.getElementById('toast');
                    toast.innerHTML = `
                    <div class="toast">
                        <div class="toast_icon">
                            <i class="fa-solid fa-check"></i>
                        </div>
                        <div class="toast_body">
                            <h3> Add Account Success </h3>
                        </div>
                    </div>
                `;

                    setTimeout(() => {
                        const toastElement = document.querySelector('.toast');
                        toastElement.classList.add('show');
                    }, 100);
                }
            }

        </script>


        <script src="<%= request.getContextPath() %>/assets/js/bootstrap.bundle.min.js"></script>
        <!-- simplebar -->
        <script src="<%= request.getContextPath() %>/assets/js/simplebar.min.js"></script>
        <!-- Icons -->
        <script src="<%= request.getContextPath() %>/assets/js/feather.min.js"></script>
        <!-- Main Js -->
        <script src="<%= request.getContextPath() %>/assets/js/app.js"></script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
