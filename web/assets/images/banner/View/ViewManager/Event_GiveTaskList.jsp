<%-- 
    Document   : Manager_DashBoard
    Created on : Jul 5, 2024, 2:11:27 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets_admin/images/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>Event Task List Manager </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="${pageContext.request.contextPath}/assets_admin/js/html5shiv.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/js/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/assets.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/vendors/calendar/fullcalendar.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/style.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/color/color-1.css">
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid black;
                padding: 8px;
                text-align: center;
            }
            th {
                background-color: #009688;
                color: white;
            }
        </style>
        <script>
            function openModal(url, action) {
                document.getElementById('modalAction').textContent = action;
                var confirmBtn = document.getElementById('modalConfirmBtn');
                confirmBtn.onclick = function () {
                    window.location.href = url;
                };
                $('#confirmModal').modal('show');
            }
        </script>
    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="HeaderAdmin.jsp"/>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <jsp:include page="Sidebar.jsp"/>
        <!-- Left sidebar menu end -->
        <!--Main container start -->
        <main class="ttr-wrapper">
            
            <form action="TaskSearchServlet" method="GET" class="form-inline mb-3" ">
                <div class="input-group">
                    <input type="text" name="searchKeyword" class="form-control" placeholder="Search by title" style="width: 400px;">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-primary">Search</button>
                    </div>
                </div>
            </form>
            
            <div class="widget recent-posts-entry">
                <h6 class="widget-title">Task From My Club</h6>
                <div class="widget-post-bx">
                    <div class="widget-post clearfix">
                        <a href="<c:url value='/EventGiveTaskListServlet' />" style="margin-left: 15px "><span>All</span></a><br>
                        <c:forEach var="club" items="${studentClubList}">
                            <ul class="sub-menu">
                                <li style="margin-left: 15px ">
                                    <a href="${pageContext.request.contextPath}/TaskFilterByCLBServlet?idClub=${club.idClub}&from=Blog_PostList.jsp">
                                        ${clubDAO.getClubNameByID(club.idClub)}
                                    </a>
                                </li>
                            </ul>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger">${errorMessage}</div>
            </c:if>

            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                    <tr>
                        <th>Name Task</th>
                        <th>Event Name</th>
                        <th>Club</th>
                        <th>Deadline</th>
                        <th>Department</th>
                        <th>Budget</th>
                        <th>Status</th>
                        <th colspan="2"><a>Action</a></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="EventTask" items="${EventTaskByIDList}">
                        <tr>
                            <td>${EventTask.nameTask}</td>
                            <td>${eventDAO.getEventNameById(EventTask.idEvent)}</td>
                            <td>${clubDAO.getClubNameByID(EventTask.idClub)}</td>
                            <td>${EventTask.deadline}</td>
                            <td>${settingDAO.getValueSettingById(EventTask.department)}</td>
                            <td>${EventTask.budget}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${EventTask.getStatus() == 0}">
                                        Inactive
                                    </c:when>
                                    <c:when test="${EventTask.getStatus() == 1}">
                                        Active
                                    </c:when>
                                </c:choose>
                            </td>
                            <td>
                                <a href="#" class="btn btn-primary btn-sm" onclick="openModal('${pageContext.request.contextPath}/GiveTaskUpdate?idEventTask=${EventTask.idEventTask}', 'update')">Update</a>
                            </td>
                            <td>
                                <a href="#" class="btn btn-danger btn-sm" onclick="openModal('${pageContext.request.contextPath}/TaskDeleteServlet?idEventTask=${EventTask.idEventTask}', 'delete')">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
                
            <div class="pagination-bx rounded-sm gray clearfix">
                <ul class="pagination">
                    <c:if test="${currentPage > 1}">
                        <li class="previous"><a href="?page=${currentPage - 1}&idClub=${idClub}&searchKeyword=${searchKeyword}"><i class="ti-arrow-left"></i> Prev</a></li>
                        </c:if>
                        <c:forEach begin="1" end="${noOfPages}" var="i">
                        <li class="${currentPage == i ? 'active' : ''}"><a href="?page=${i}&idClub=${idClub}&searchKeyword=${searchKeyword}">${i}</a></li>
                        </c:forEach>
                        <c:if test="${currentPage < noOfPages}">
                        <li class="next"><a href="?page=${currentPage + 1}&idClub=${idClub}&searchKeyword=${searchKeyword}">Next <i class="ti-arrow-right"></i></a></li>
                            </c:if>
                </ul>
            </div>
        </main>

        <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="confirmModalLabel">Confirm Action</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Are you sure you want to <span id="modalAction"></span> this blog?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary" id="modalConfirmBtn">Yes</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="ttr-overlay"></div>

        <!-- External JavaScripts -->
        <script src="${pageContext.request.contextPath}/assets_admin/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/counter/waypoints-min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/counter/counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/masonry/masonry.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/masonry/filter.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/owl-carousel/owl.carousel.js"></script>
        <script src='${pageContext.request.contextPath}/assets_admin/vendors/scroll/scrollbar.min.js'></script>
        <script src="${pageContext.request.contextPath}/assets_admin/js/functions.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/vendors/chart/chart.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/js/admin.js"></script>
        <script src='${pageContext.request.contextPath}/assets_admin/vendors/calendar/moment.min.js'></script>
        <script src='${pageContext.request.contextPath}/assets_admin/vendors/calendar/fullcalendar.js'></script>
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
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/index.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
