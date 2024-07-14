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
        <title>Event List Manager </title>

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
            <form action="EventSearchAllServlet" method="post" style="margin-bottom: 20px ;width: 300px">
                <input type="hidden" name="from" value="Event_ListManager.jsp">
                <input type="text" name="name" class="form-control" />
                <input type="submit" value="Search" class="btn btn-primary" />
            </form>
            
            <div class="widget recent-posts-entry">
                <h6 class="widget-title">Event From My Club</h6>
                <div class="widget-post-bx">
                    <div class="widget-post clearfix">
                        <a href="<c:url value='/EventPostListServlet?from=Event_ListManager.jsp' />" style="margin-left: 15px "><span>All</span></a><br>
                        <c:forEach var="club" items="${studentClubList}">
                            <ul class="sub-menu">
                                <li style="margin-left: 15px ">
                                    <a href="${pageContext.request.contextPath}/EventFilterByCLBServlet?idClub=${club.idClub}&from=Event_ListManager.jsp">
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
            <table>
                <thead>
                    <tr>
                        <th>ID Event</th>
                        <th>Image</th>
                        <th>Name Event</th>
                        <th>Description</th>
                        <th>Address</th>
                        <th>Time</th>
                        <th>Club</th>
                        <th>Type Event</th>
                        <th>Date Modify</th>
                        <th>Status</th>
                        <th colspan="3"><a href="#" onclick="openModal('${pageContext.request.contextPath}/EventUploadServlet?from=Event_ListManager.jsp', 'insert')">Insert</a></th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="Event" items="${EventByIDList}">
                        <tr>
                            <td>${Event.idEvent}</td>
                            <td><img src="${pageContext.request.contextPath}/${Event.image}" alt="Uploaded Image"  ></td>
                            <td>${Event.nameEvent}</td>
                            <td>${Event.description}</td>
                            <td>${Event.address}</td>
                            <td>${Event.dateStart} to ${Event.enddate}</td>
                            <td>${clubDAO.getClubNameByID(Event.idClub)}</td>
                            <td>${settingsDAO.getValueSettingById(Event.idEventType)}</td>
                            <td>${Event.dateModify}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${Event.status == 0}">
                                        Inactive
                                    </c:when>
                                    <c:when test="${Event.status == 1}">
                                        Active
                                    </c:when>
                                    <c:when test="${Event.status == 2}">
                                        Coming Soon
                                    </c:when>
                                </c:choose>
                            </td>
                            <td><a href="#" onclick="openModal('${pageContext.request.contextPath}/EventUpdateServlet?idEvent=${Event.idEvent}&from=Event_ListManager.jsp', 'update')">Update</a></td>
                            <td><a href="#" onclick="openModal('${pageContext.request.contextPath}/EventDeleteServlet?idEvent=${Event.idEvent}&from=Event_ListManager.jsp', 'delete')">Delete</a></td>
                            <td><a href="#" onclick="openModal('${pageContext.request.contextPath}/EventGiveTaskServlet?idEvent=${Event.idEvent}&idClub=${Event.idClub}&from=Event_ListManager.jsp', 'give task')">Give Task</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="pagination-bx rounded-sm gray clearfix">
                <ul class="pagination">
                    <c:if test="${currentPage > 1}">
                        <li class="previous"><a href="?page=${currentPage - 1}"><i class="ti-arrow-left"></i> Prev</a></li>
                        </c:if>
                        <c:forEach begin="1" end="${noOfPages}" var="i">
                        <li class="${currentPage == i ? 'active' : ''}"><a href="?page=${i}">${i}</a></li>
                        </c:forEach>
                        <c:if test="${currentPage < noOfPages}">
                        <li class="next"><a href="?page=${currentPage + 1}">Next <i class="ti-arrow-right"></i></a></li>
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
