<%-- 
    Document   : Dashboard
    Created on : May 20, 2024, 10:52:00 PM
    Author     : Admin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    </style>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="Navigation.jsp"/>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <jsp:include page="LeftSideBar.jsp"/>
        <!-- Left sidebar menu end -->
        <main class="ttr-wrapper">
            <div class="layout-specing">
                <div class="d-md-flex justify-content-between">
                    <h5 class="mb-0">Account List</h5> 
                    <form action="<%= request.getContextPath() %>/listaccount" method="get" class="form-inline" id="myForm"> 
                        <div class="abc">
                            <div class="xyz">
                                <select name="status" class="custom-select" onchange="submitForm()">
                                    <option value="all" <c:if test="${requestScope.status=='all'}">selected</c:if>>All</option>
                                    <option value="1" <c:if test="${requestScope.status=='1'}">selected</c:if>>Active</option>
                                    <option value="0" <c:if test="${requestScope.status=='0'}">selected</c:if>>Inactive</option>
                                    </select>
                                </div>
                                <div>
                                    <input type="text" name="search" value="${search}"> 
                                <button type="submit"> Search</button>
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

                                            <th class="border-bottom p-3">Status</th>
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
                                                <td class="p-3"><c:choose>
                                                        <c:when test="${x.status == 1}">
                                                            Active
                                                        </c:when>
                                                        <c:otherwise>
                                                            Inactive
                                                        </c:otherwise>
                                                    </c:choose></td>

                                                <td class="text-end p-3">
                                                    <a href="userdetail?emails=${x.email}" class="btn btn-icon btn-pills btn-soft-primary" data-bs-toggle="modal" data-bs-target="#viewprofile"><i class="uil uil-eye"></i></a>
                                                    <span style="display: inline-block; width: 20px;"></span>
                                                    <a href="listaccount?page=${requestScope.page}&search=${search}&status=${status}&email=${x.email}&statuss=${x.status}"> <c:choose>
                                                            <c:when test="${x.status == 0}">
                                                                Active
                                                            </c:when>
                                                            <c:otherwise>
                                                                Inactive
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
                                        <li class="page-item"><a class="page-link" href="listaccount?page=${requestScope.page -1}&search=${search}&status=${status}" aria-label="Previous">Prev</a></li>
                                        </c:if>
                                    <!--<li class="page-item"><a class="page-link" href="javascript:void(0)" aria-label="Previous">Prev</a></li>-->
                                    <li class="page-item active"><a class="page-link" href="listaccount?page=${requestScope.page}&search=${search}&status=${status}">${requestScope.page}</a></li>
                                        <c:if test="${requestScope.pagemax-requestScope.page>=1}">
                                        <li class="page-item"><a class="page-link" href="listaccount?page=${requestScope.page + 1}&search=${search}&status=${status}">${requestScope.page+1}</a></li>
                                        </c:if>
                                        <c:if test="${requestScope.pagemax-requestScope.page>=2}">
                                        <li class="page-item"><a class="page-link" href="listaccount?page=${requestScope.page + 2}&search=${search}&status=${status}">${requestScope.page+2}</a></li>
                                        </c:if>
                                        <c:if test="${requestScope.page<requestScope.pagemax}">
                                        <li class="page-item"><a class="page-link" href="listaccount?page=${requestScope.page + 1}&search=${search}" aria-label="Next">Next</a></li>
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
                                    $(document).ready(function () {

                                        $('#calendar').fullCalendar({
                                            header: {
                                                left: 'prev,next today',
                                                center: 'title',
                                                right: 'month,agendaWeek,agendaDay,listWeek'
                                            },
                                            defaultDate: '2019-03-12',
                                            navLinks: true, // can click day/week names to navigate views

                                            weekNumbers: true,
                                            weekNumbersWithinDays: true,
                                            weekNumberCalculation: 'ISO',

                                            editable: true,
                                            eventLimit: true, // allow "more" link when too many events
                                            events: [
                                                {
                                                    title: 'All Day Event',
                                                    start: '2019-03-01'
                                                },
                                                {
                                                    title: 'Long Event',
                                                    start: '2019-03-07',
                                                    end: '2019-03-10'
                                                },
                                                {
                                                    id: 999,
                                                    title: 'Repeating Event',
                                                    start: '2019-03-09T16:00:00'
                                                },
                                                {
                                                    id: 999,
                                                    title: 'Repeating Event',
                                                    start: '2019-03-16T16:00:00'
                                                },
                                                {
                                                    title: 'Conference',
                                                    start: '2019-03-11',
                                                    end: '2019-03-13'
                                                },
                                                {
                                                    title: 'Meeting',
                                                    start: '2019-03-12T10:30:00',
                                                    end: '2019-03-12T12:30:00'
                                                },
                                                {
                                                    title: 'Lunch',
                                                    start: '2019-03-12T12:00:00'
                                                },
                                                {
                                                    title: 'Meeting',
                                                    start: '2019-03-12T14:30:00'
                                                },
                                                {
                                                    title: 'Happy Hour',
                                                    start: '2019-03-12T17:30:00'
                                                },
                                                {
                                                    title: 'Dinner',
                                                    start: '2019-03-12T20:00:00'
                                                },
                                                {
                                                    title: 'Birthday Party',
                                                    start: '2019-03-13T07:00:00'
                                                },
                                                {
                                                    title: 'Click for Google',
                                                    url: 'http://google.com/',
                                                    start: '2019-03-28'
                                                }
                                            ]
                                        });


                                    });

        </script>
        <script>
            function submitForm() {
                document.forms["myForm"].submit();
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
