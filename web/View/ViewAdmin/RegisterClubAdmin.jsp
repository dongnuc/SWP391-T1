<%-- 
    Document   : RegisterClubAdmin
    Created on : May 29, 2024, 7:15:42 PM
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

    </head>
    <body class="ttr-opened-sidebar ttr-pinned-sidebar">

        <!-- header start -->
        <%@ include file="Navigation.jsp" %>
        <!-- header end -->
        <!-- Left sidebar menu start -->
        <jsp:include page="LeftSideBar.jsp"/>
        <!-- Left sidebar menu end -->

        <!--Main container start -->
        <main class="ttr-wrapper">
            <div class="container-fluid">
                <div class="db-breadcrumb">
                    <h4 class="breadcrumb-title">List Views Calendar</h4>
                    <ul class="db-breadcrumb-list">
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li>List Clubs Register</li>
                    </ul>
                </div>	
                <div class="row">
                    <!-- Your Profile Views Chart -->
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>List Views Calendar</h4>
                            </div>
                            <table id="myTable">
                                <thead>
                                    <tr>
                                        <th>Name Club</th>
                                        <th>Type Club</th>
                                        <th>Date Create</th>
                                        <th>Student</th>
                                        <th></th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="clubRegister" items="${requestScope.list}">
                                        <tr>
                                            <td>${clubRegister.getNameclub()}</td>
                                            <td>${clubRegister.getTypeclub()}</td>
                                            <td>${clubRegister.getDatecreate()}</td>
                                            <td>${clubRegister.getNamebyID()}</td>
                                            <td> 
                                                <a href="RegisterClubDeatailServlet?id=${clubRegister.getIdregister()}" style="margin-right: 5px">
                                                    <i class="fa fa-eye"></i> View
                                                </a>
                                            </td>

                                        </tr>
                                    </c:forEach>



                                </tbody>
                            </table>
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
                position: relative;
                display: inline-block;
                cursor: pointer;
            }

            .popup-text {
                display: none;
                width: 60vw; /* 50% c?a viewport width */
                background-color: #555;
                color: #fff;
                border-radius: 6px;
                padding: 5px;
                position: fixed; /* Fixed position to keep it centered */
                top: 50%;
                left: 51%;
                transform: translate(-50%, -50%); /* Center the popup */
                opacity: 0;
                transition: opacity 0.3s;
                z-index: 1000; /* Ensure it appears above other elements */
            }

            .popup-container .popup-text.show {
                display: block;
                opacity: 1;
            }

            textarea {
                width: 100%;
                height: 50vh; /* 50% c?a viewport height */
                border: none;
                padding: 10px;
                box-sizing: border-box;
                border-radius: 5px;
                resize: none;
                font-family: inherit;
            }

            /* Optional: Style the close button */
            .close-btn {
                position: absolute;
                top: 10px;
                right: 20px;
                background-color: #ff5c5c;
                color: #fff;
                border: none;
                border-radius: 50%;
                width: 25px;
                height: 25px;
                text-align: center;
                line-height: 25px;
                cursor: pointer;
            }
        </style>    

        <!--        <script>
                    // Sample data for demonstration
                    const data = [];
                    for (let i = 1; i <= 50; i++) {
                        data.push([`Item ${i}1`, `Item ${i}2`, `Item ${i}3`, `Item ${i}4`, `Item ${i}5`]);
                    }
        
                    const rowsPerPage = 10;
                    let currentPage = 1;
        
                    function displayTable(page) {
                        const table = document.getElementById('myTable').getElementsByTagName('tbody')[0];
                        table.innerHTML = "";
                        const start = (page - 1) * rowsPerPage;
                        const end = start + rowsPerPage;
                        const paginatedItems = data.slice(start, end);
        
                        for (let row of paginatedItems) {
                            const newRow = table.insertRow();
                            for (let cell of row) {
                                const newCell = newRow.insertCell();
                                newCell.textContent = cell;
                            }
                        }
                    }
        
                    function setupPagination() {
                        const pagination = document.getElementById('pagination');
                        pagination.innerHTML = "";
                        const pageCount = Math.ceil(data.length / rowsPerPage);
        
                        for (let i = 1; i <= pageCount; i++) {
                            const pageButton = document.createElement('a');
                            pageButton.textContent = i;
                            pageButton.href = "#";
                            pageButton.className = i === currentPage ? "active" : "";
                            pageButton.addEventListener('click', (event) => {
                                event.preventDefault();
                                currentPage = i;
                                displayTable(currentPage);
                                setupPagination();
                            });
                            pagination.appendChild(pageButton);
                        }
                    }
        
                    // Initial call to display the table and pagination
                    displayTable(currentPage);
                    setupPagination();
                </script>-->
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
       
        <script>
            function togglePopup(element) {
                var popup = element.querySelector(".popup-text");
                popup.classList.toggle("show");
            }

            // ?óng popup khi click ra ngoài
            window.addEventListener('click', function (event) {
                var containers = document.querySelectorAll('.popup-container');
                containers.forEach(function (container) {
                    var popup = container.querySelector('.popup-text');
                    if (popup.classList.contains('show') && !container.contains(event.target)) {
                        popup.classList.remove('show');
                    }
                });
            });
        </script>

    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/list-view-calendar.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:11:35 GMT -->
</html>