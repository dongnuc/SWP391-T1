<%-- 
    Document   : studentClubAdmin
    Created on : Jul 8, 2024, 10:09:58 AM
    Author     : Nguyen Hau
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/list-view-calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->

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
    <link href="<%= request.getContextPath() %>/assets/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

</head>
<body class="ttr-opened-sidebar ttr-pinned-sidebar">

    <!-- header start -->
  <jsp:include page="Navigation.jsp"/>
    <!-- header end -->
    <!-- Left sidebar menu start -->
    <jsp:include page="Sidebar.jsp"/>
    <!-- Left sidebar menu end -->

    <!--Main container start -->
    <main class="ttr-wrapper">
        <div class="container-fluid">
            <div class="db-breadcrumb">
                <h4 class="breadcrumb-title">Student In Club</h4>
                <ul class="db-breadcrumb-list">
                    <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                    <li><a href="StudentClubServlet?id=${param.id}"><i class="fa fa-home"></i>Student In Club</a></li>
                </ul>
            </div>	
            <div class="row">
                <!-- Your Profile Views Chart -->
                <div class="col-lg-12 m-b30">
                    <div class="widget-box">
                        <div class="wc-titlee" style="border-bottom-width: 1px;
                             border-bottom-style: solid;
                             border-bottom-color: rgba(0, 0, 0, 0.05);
                             padding-top: 10px;
                             padding-bottom: 10px;">
                            <form action="SearchStudentClubNameServlet" method="get" style="display: flex; align-items: center; gap: 30px;">
                                <div>
                                    <input type="text" name="search" placeholder="Enter name student" value="${searchQuery}">
                                    <input type="hidden" name="id" value="${param.id}">
                                    <button type="submit">Search</button>
                                </div>
                                <select name="club" onchange="window.location.href=this.value;" style="width: max-content;" >
                                    <option value="StudentClubServlet?id=${param.id}" <c:if test="${role==0}">selected</c:if> >All Role</option>
                                    <option value="SelectStudentbyRoleServlet?id=${param.id}&&role=1" <c:if test="${role==1}">selected</c:if>>Manager</option>
                                    <option value="SelectStudentbyRoleServlet?id=${param.id}&&role=2" <c:if test="${role==2}">selected</c:if>>Secretary</option>
                                    <option value="SelectStudentbyRoleServlet?id=${param.id}&&role=3" <c:if test="${role==3}">selected</c:if>>Treasurer</option>
                                    <option value="SelectStudentbyRoleServlet?id=${param.id}&&role=4" <c:if test="${role==4}">selected</c:if>>Public Relations Officer</option>
                                    <option value="SelectStudentbyRoleServlet?id=${param.id}&&role=5" <c:if test="${role==5}">selected</c:if>>Member</option>
                                    <option value="SelectStudentbyRoleServlet?id=${param.id}&&role=6" <c:if test="${role==6}">selected</c:if>>Technical</option>
                                    <!-- Add more options as needed -->
                                </select>
                                <select name="club" onchange="window.location.href=this.value;" style="width: max-content;" >
                                    <option value="StudentClubServlet?id=${param.id}" <c:if test="${leader==null}">selected</c:if>>All Position</option>
                                    <option value="SelectStudentbyPositionServlet?id=${param.id}&&leader=1" <c:if test="${leader==1}">selected</c:if>>Leader</option>
                                    <option value="SelectStudentbyPositionServlet?id=${param.id}&&leader=0" <c:if test="${leader==0}">selected</c:if>>Member</option>
                                    <!-- Add more options as needed -->
                                </select>
                            </form>
                        </div>
                        <div class="overlay" id="overlay"></div>

                        <!-- Popup Container -->
                        <div class="popup-container" id="popup">
                            <button class="popup-close-btn" onclick="closePopup()">X</button>
                            <iframe class="popup-content" id="popupContent"></iframe>
                        </div>
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
                                        Are you sure you want to proceed with this action?
                                    </div>
                                    <div class="modal-footerr" style="padding-top: 1rem;
                                         padding-right: 1rem;
                                         padding-bottom: 1rem;
                                         padding-left: 1rem;border-top-width: 1px;
                                         border-top-style: solid;
                                         border-top-color: rgb(233, 236, 239);">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                        <a href="#" id="confirmAction" class="btn btn-primary">Confirm</a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <table id="myTable">

                            <thead>
                                <tr>
                                    <th>Name Student</th>
                                    <th>Point</th>
                                    <th>Role</th>
                                    <th>Position</th>
                                    <th>Club Entry Date</th>
                                    <th></th>
                                    <th></th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="club" items="${requestScope.list}">
                                    <tr>
                                        <td>${club.getNamebyId()}</td>
                                        <td>${club.getPoint()}</td>
                                        <td>${club.getRolebyID()}</td>
                                        <td>${club.getPosition()}</td>
                                        <td>${club.getDatecreate()}</td>
                                        <td>
                                            <c:if test="${club.getStatus()==1}">
                                                <a href="javascript:void(0)" onclick="openConfirmModal('SetStatusStudentServlet?id=${club.getIdClub()}&&idstudent=${club.getIdStudent()}')" style="margin-right: 5px">
                                                    <i class="fa fa-check"></i> Action
                                                </a>
                                            </c:if>
                                            <c:if test="${club.getStatus()==0}">
                                                <a href="javascript:void(0)" onclick="openConfirmModal('SetStatusStudentServlet?id=${club.getIdClub()}&&idstudent=${club.getIdStudent()}')" style="margin-right: 5px">
                                                    <i class="fa fa-times"></i> Inaction
                                                </a>
                                            </c:if>
                                        </td>
                                        <td>
                                            <a href="javascript:void(0)" onclick="openPopup('UpdateStudentClubServlet?idclub=${club.getIdClub()}&&idstudent=${club.getIdStudent()}')">
                                                <i class="fa fa-pencil"></i> Edit
                                            </a>
                                        </td>
                                    </tr>

                                </c:forEach>

                        </table>
                        <div class="col-lg-12 m-b20">
                            <div class="pagination-bx rounded-sm gray clearfix">
                                <ul class="pagination">
                                    <c:if test="${requestScope.role!=0}">
                                        <li class="previous"><a href="SelectStudentbyRoleServlet?id=${param.id}&&role=${role}&&page=${(param.page==null||param.page==1)?1:param.page-1}"><i class="ti-arrow-left"></i> Prev</a></li>

                                        <c:forEach begin="1" end="${requestScope.numberOfPage}" step="1" var="i">
                                            <li><a href="SelectStudentbyRoleServlet?id=${param.id}&&role=${role}&&page=${i}">${i}</a></li>
                                            </c:forEach>

                                        <li class="next"><a href="SelectStudentbyRoleServlet?id=${param.id}&&role=${role}&&page=${(param.page==requestScope.numberOfPage)?requestScope.numberOfPage:param.page+1}">Next <i class="ti-arrow-right"></i></a></li>
                                            </c:if>
                                        
                                            <c:if test="${requestScope.search!=null}">
                                        <li class="previous"><a href="SearchStudentClubNameServlet?id=${param.id}&&search=${search}&&page=${(param.page==null||param.page==1)?1:param.page-1}"><i class="ti-arrow-left"></i> Prev</a></li>

                                        <c:forEach begin="1" end="${requestScope.numberOfPage}" step="1" var="i">
                                            <li><a href="SearchStudentClubNameServlet?id=${param.id}&&search=${search}&&page=${i}">${i}</a></li>
                                            </c:forEach>

                                        <li class="next"><a href="SearchStudentClubNameServlet?id=${param.id}&&search=${search}&&page=${(param.page==requestScope.numberOfPage)?requestScope.numberOfPage:param.page+1}">Next <i class="ti-arrow-right"></i></a></li>
                                            </c:if>
                                        
                                        <c:if test="${requestScope.leader!=null}">
                                        <li class="previous"><a href="SelectStudentbyPositionServlet?id=${param.id}&&leader=${leader}&&page=${(param.page==null||param.page==1)?1:param.page-1}"><i class="ti-arrow-left"></i> Prev</a></li>

                                        <c:forEach begin="1" end="${requestScope.numberOfPage}" step="1" var="i">
                                            <li><a href="SelectStudentbyPositionServlet?id=${param.id}&&leader=${leader}&&page=${i}">${i}</a></li>
                                            </c:forEach>

                                        <li class="next"><a href="SelectStudentbyPositionServlet?id=${param.id}&&leader=${leader}&&page=${(param.page==requestScope.numberOfPage)?requestScope.numberOfPage:param.page+1}">Next <i class="ti-arrow-right"></i></a></li>
                                            </c:if>
                                        
                                <c:if test="${requestScope.leader==null&&requestScope.role==0&&requestScope.leader==null&&requestScope.leader==null&&requestScope.search==null}">
                                        <li class="previous"><a href="StudentClubServlet?id=${param.id}&&page=${(param.page==null||param.page==1)?1:param.page-1}"><i class="ti-arrow-left"></i> Prev</a></li>

                                        <c:forEach begin="1" end="${requestScope.numberOfPage}" step="1" var="i">
                                            <li><a href="StudentClubServlet?id=${param.id}&&page=${i}">${i}</a></li>
                                            </c:forEach>

                                        <li class="next"><a href="StudentClubServlet?id=${param.id}&&page=${(param.page==requestScope.numberOfPage)?requestScope.numberOfPage:param.page+1}">Next <i class="ti-arrow-right"></i></a></li>
                                            </c:if>
                                </ul>
                            </div>
                        </div>


                        </tbody>

                        <div class="pagination" id="pagination">
                            <!-- Pagination buttons will be inserted here by JavaScript -->
                        </div>
                    </div>
                </div>
                <!-- Your Profile Views Chart END-->
            </div>
        </div>
    </main>
    <div class="ttr-overlay"></div>
    <style>
        .widget-box {
            width: 100%;
            border: 1px solid #ccc;
            padding: 15px;
            box-shadow: 2px 2px 5px rgba(0,0,0,0.1);
        }
        .wc-title h4 {
            margin: 0;
            padding-bottom: 10px;
            border-bottom: 1px solid #ccc;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
        .pagination {
            margin: 10px 0;
            text-align: center;
        }
        .pagination a {
            color: black;
            float: left;
            padding: 8px 16px;
            text-decoration: none;
            border: 1px solid #ccc;
            margin: 0 2px;
        }
        .pagination a.active {
            background-color: #4CAF50;
            color: white;
            border: 1px solid #4CAF50;
        }
        .pagination a:hover:not(.active) {
            background-color: #ddd;
        }
    </style>

    <style>
        .popup-container {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 50vw;
            height: 57vh;
            background-color: white;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0,0,0,0.5);
            z-index: 1001;
        }
        .popup-container.show {
            display: block;
        }
        .popup-close-btn {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: #ff5c5c;
            color: white;
            border: none;
            border-radius: 50%;
            width: 25px;
            height: 25px;
            text-align: center;
            line-height: 25px;
            cursor: pointer;
        }
        .popup-content {
            width: 100%;
            height: 100%;
            border: none;
        }
        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.7);
            z-index: 1000;
        }
        .overlay.show {
            display: block;
        }
        

        /* Existing styles */
    </style>

    <script>
        function openPopup(url) {
            document.getElementById('popupContent').src = url;
            document.getElementById('popup').classList.add('show');
            document.getElementById('overlay').classList.add('show');
        }

        function closePopup() {
            document.getElementById('popup').classList.remove('show');
            document.getElementById('popupContent').src = '';
            document.getElementById('overlay').classList.remove('show');
        }
    </script>
    <script>
        function openConfirmModal(url) {
            document.getElementById('confirmAction').href = url;
            $('#confirmModal').modal('show');
        }
    </script>

    <!--      
    <!-- External JavaScripts -->
    
    <script src="${pageContext.request.contextPath}/View/ViewAdmin/assets/js/bootstrap.min.js"></script>

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

</body>

<!-- Mirrored from educhamp.themetrades.com/demo/admin/list-view-calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>
