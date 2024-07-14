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

        .close1,
        .close2 {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            position: absolute;
            right: 10px;
            top: 10px;
        }

        .close1:hover,
        .close1:focus,
        .close2:hover,
        .close2:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        .modal-content p {
            margin-top: 30px;
        }

        .button-container {
            display: flex;
            justify-content: center;
            gap: 10px;
            margin-top: 20px;
        }
        .modal-content textarea {
        width: 100%;
        padding: 10px;
        margin-top: 10px;
        resize: vertical; 
    }
    </style>
    <%
    String check = (String) request.getAttribute("showtoast");
    %>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <jsp:include page="HeaderAdmin.jsp"/>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <jsp:include page="Sidebar.jsp"/>
        <!-- Left sidebar menu end -->
        <div id="confirmModalAccept" class="modal">
            <div class="modal-content">
                <span class="close1" style="margin-left: 10px">&times;</span>
                <p>Are you sure you want to Accept this Member ?</p>
                <div class="button-container">
                    <button id="confirmBtnAccept">Yes</button>
                    <button id="cancelBtnAccept">No</button>
                </div>
            </div>
        </div>
        <div id="confirmModalReject" class="modal">
            <div class="modal-content">
                <span class="close2" style="margin-left: 10px">&times;</span>
                <p>Are you sure you want to Reject this member ?</p>
                <textarea id="reasonTextarea" rows="4" placeholder=""></textarea>

                <div class="button-container">

                    <button id="confirmBtnReject">Yes</button>
                    <button id="cancelBtnReject">No</button>
                </div>
            </div>
        </div>
        <main class="ttr-wrapper">
            <div class="layout-specing">
                <div class="d-md-flex justify-content-between">
                    <h5 class="mb-0">Account List</h5> 
                    <form action="<%= request.getContextPath() %>/ListMember" method="get" class="form-inline" id="myForm"> 
                        <div class="abc">
                            <div class="xyz">
                                Time
                                <select name="time" class="custom-select" onchange="submitForm()">
                                    <option value="present" <c:if test="${requestScope.status == 'present'}">selected</c:if> >present</option>
                                    <option value="past" <c:if test="${requestScope.status == 'past'}">selected</c:if>>past</option>
                                    <option value="future"<c:if test="${requestScope.status == 'future'}">selected</c:if>>future</option>
                                    </select>
                                    CLB
                                    <select name="idclub" class="custom-select" onchange="submitForm()">
                                    <c:forEach items="${requestScope.listidclub}" var="x">
                                        <option value="${x}" <c:if test="${requestScope.idclub == x}">selected</c:if>>${x}</option>
                                    </c:forEach>
                                </select>
                                ID Event 

                                <select name="idevent" class="custom-select" onchange="submitForm()">
                                    <c:forEach items="${requestScope.listevent}" var="x">
                                        <option value="${x}"<c:if test="${requestScope.idevent == x}">selected</c:if>>${x}</option>
                                    </c:forEach>
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
                                            <th class="border-bottom p-3" style="min-width: 180px;">NameEvent</th>
                                            <th class="border-bottom p-3">Phone</th>
                                            <th class="border-bottom p-3">Name Member</th>
                                            <th class="border-bottom p-3">Email</th>
                                            <th class="border-bottom p-3">Status</th>
                                            <th class="border-bottom p-3">Action</th>
                                            <th class="border-bottom p-3" style="min-width: 100px;"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.listmember}" var="x">
                                            <tr>
                                                <th class="p-3">${x.idevent}</th>
                                                <th class="p-3">${x.nameevent}</th>
                                                <th class="p-3">${x.phone}</th>
                                                <th class="p-3">${x.name}</th>
                                                <th class="p-3">${x.gmail}</th>
                                                <td class="p-3"><c:choose>
                                                        <c:when test="${x.status == 0}">
                                                            Pending
                                                        </c:when>
                                                        <c:when test="${x.status == 1}">
                                                            Reject
                                                        </c:when>
                                                        <c:otherwise>
                                                            Accept
                                                        </c:otherwise>
                                                    </c:choose></td>
                                                <c:if test="${requestScope.status == 'future'}">
                                                    <c:if test="${x.status == 0}">
                                                    <td><a href="ListMember?page=${requestScope.page}&search=${search}&time=${status}&action=1&idregister=${x.eventregisterid}&gmail=${x.gmail}&idclub=${idclub}&idevent=${idevent}" style="color: red" onclick="confirmActionReject(event, this)">Reject</a></td>
                                                    <td><a href="ListMember?page=${requestScope.page}&search=${search}&time=${status}&action=2&idregister=${x.eventregisterid}&gmail=${x.gmail}&idclub=${idclub}&idevent=${idevent}" style="color: greenyellow"onclick="confirmActionAccept(event, this)">Accept</a></td>
                                                </c:if>
                                                    </c:if>
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
                                        <li class="page-item"><a class="page-link" href="ListMember?page=${requestScope.page -1}&search=${search}&time=${status}&idclub=${idclub}&idevent=${idevent}" aria-label="Previous">Prev</a></li>
                                        </c:if>
                                    <!--<li class="page-item"><a class="page-link" href="javascript:void(0)" aria-label="Previous">Prev</a></li>-->
                                    <li class="page-item active"><a class="page-link" href="ListMember?page=${requestScope.page }&search=${search}&time=${status}&idclub=${idclub}&idevent=${idevent}">${requestScope.page}</a></li>
                                        <c:if test="${requestScope.pagemax-requestScope.page>=1}">
                                        <li class="page-item"><a class="page-link" href="ListMember?page=${requestScope.page + 1}&search=${search}&time=${status}&idclub=${idclub}&idevent=${idevent}">${requestScope.page+1}</a></li>
                                        </c:if>
                                        <c:if test="${requestScope.pagemax-requestScope.page>=2}">
                                        <li class="page-item"><a class="page-link" href="ListMember?page=${requestScope.page + 2}&search=${search}&time=${status}&idclub=${idclub}&idevent=${idevent}">${requestScope.page+2}</a></li>
                                        </c:if>
                                        <c:if test="${requestScope.page<requestScope.pagemax}">
                                        <li class="page-item"><a class="page-link" href="ListMember?page=${requestScope.page + 1}&search=${search}&time=${status}&idclub=${idclub}&idevent=${idevent}" aria-label="Next">Next</a></li>
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
            document.addEventListener('DOMContentLoaded', function () {
                var modalAccept = document.getElementById('confirmModalAccept');
                var modalReject = document.getElementById('confirmModalReject');
                var spanAccept = document.getElementsByClassName('close1')[0];
                var spanReject = document.getElementsByClassName('close2')[0];
                var confirmBtnAccept = document.getElementById('confirmBtnAccept');
                var confirmBtnReject = document.getElementById('confirmBtnReject');
                var cancelBtnAccept = document.getElementById('cancelBtnAccept');
                var cancelBtnReject = document.getElementById('cancelBtnReject');
                var currentLink = null;

                // Function to open modal for Accept action
                window.confirmActionAccept = function (event, link) {
                    event.preventDefault();
                    currentLink = link;
                    modalAccept.style.display = 'block';
                };

                // Function to open modal for Reject action
                window.confirmActionReject = function (event, link) {
                    event.preventDefault();
                    currentLink = link;
                    modalReject.style.display = 'block';
                };

                // Function to close modal
                function closeModal(modal) {
                    modal.style.display = 'none';
                    modal.querySelector('textarea').value = '';
                }

                // Close modal when clicking on the span (x button)
                spanAccept.onclick = function () {
                    closeModal(modalAccept);
                };

                spanReject.onclick = function () {
                    closeModal(modalReject);
                };

                // Close modal when clicking on cancel button (Accept modal)
                cancelBtnAccept.onclick = function () {
                    closeModal(modalAccept);
                };

                // Close modal when clicking on cancel button (Reject modal)
                cancelBtnReject.onclick = function () {
                    closeModal(modalReject);
                };

                // Confirm action when clicking on confirm button (Accept modal)
                confirmBtnAccept.onclick = function () {
                    if (currentLink) {
                        window.location.href = currentLink.href;
                    }
                };

                // Confirm action when clicking on confirm button (Reject modal)
                confirmBtnReject.onclick = function () {
                    if (currentLink) {
            var reason = document.getElementById('reasonTextarea').value; 
            var url = new URL(currentLink.href);
            url.searchParams.set('reason', reason); 
            window.location.href = url.toString(); 
        }
                };

                
                window.onclick = function (event) {
                    if (event.target == modalAccept) {
                        closeModal(modalAccept);
                    } else if (event.target == modalReject) {
                        closeModal(modalReject);
                    }
                };
            });
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
