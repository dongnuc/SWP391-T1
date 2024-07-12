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
        <title>Dash Board </title>

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
            <form action="BlogSearchServlet" method="POST" style="width: 300px ; margin-bottom: 30px">
                <input type="hidden" name="from" value="Blog_PostList.jsp">
                <input type="text" name="searchKeyword" placeholder="Search by title">
                <button type="submit">Search</button>
            </form>
            <div class="widget recent-posts-entry">
                <h6 class="widget-title">Blog From My Club</h6>
                <div class="widget-post-bx">
                    <div class="widget-post clearfix">
                        <a href="<c:url value='/BlogPostListServlet?from=Blog_PostList.jsp' />" style="margin-left: 15px "><span>All</span></a><br>
                            <c:forEach var="club" items="${studentClubList}">
                            <ul class="sub-menu">
                                <li style="margin-left: 15px ">
                                    <a href="${pageContext.request.contextPath}/BlogFilterByClubServlet?idClub=${club.idClub}&from=Blog_PostList.jsp">
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

                <c:if test="${empty errorMessage}">
                    <thead>
                        <tr>
                            <th>ID Blog</th>
                            <th>Image</th>
                            <th>Title</th>
                            <th>Show</th>
                            <th>Club</th>
                            <th>Category Blog</th>
                            <th>Date Modify</th>
                            <th>Status</th>
                            <th colspan="2"><a href="<c:url value='/UploadServlet' />">Insert</a></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="Blog" items="${BlogByIDList}">
                            <tr>
                                <td>${Blog.idBlog}</td>
                                <td><img src="${pageContext.request.contextPath}/${Blog.image}" alt="Uploaded Image" width="200" ></td>
                                <td>${Blog.titleBlog}</td>
                                <td>${Blog.show}</td>
                                <td>${clubDAO.getClubNameByID(Blog.idClub)}</td>
                                <td>${settingsDAO.getValueSettingById(Blog.idBlogType)}</td>
                                <td>${Blog.dateModify}</td>
                                <td>${Blog.status}</td>
                                <td><a href="<c:url value='/BlogUpdateServlet?idBlog=${Blog.idBlog}&from=Blog_PostList.jsp' />">Edit</a></td>
                                <td><a href="<c:url value='/BlogDeleteServlet?idBlog=${Blog.idBlog}&from=Blog_PostList.jsp' />">Delete</a></td>
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
            </c:if>
        </main>

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
