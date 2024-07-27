<%-- 
    Document   : Blog_List
    Created on : Jun 5, 2024, 2:09:04 PM
    Author     : 10t1q
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <!-- Liên kết tới Font Awesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="shortcut icon" type="image/x-icon"  href="${pageContext.request.contextPath}/images_t/favicon.png" />

        <!-- PAGE TITLE HERE ============================================= -->
        <title>EduChamp : Education HTML Template </title>

        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--[if lt IE 9]>
        <script src="${pageContext.request.contextPath}/js_t/html5shiv.min.js"></script>
        <script src="${pageContext.request.contextPath}/js_t/respond.min.js"></script>
        <![endif]-->

        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css_t/assets.css">

        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css_t/typography.css">

        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css_t/shortcodes/shortcodes.css">

        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css_t/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <style>
            body {
                margin-top: 20px;
                background-color: #f2f6fc;
                color: #69707a;
            }

            .img-account-profile {
                height: 10rem;
            }

            .rounded-circle {
                border-radius: 50% !important;
            }

            .card {
                box-shadow: 0 0.15rem 1.75rem 0 rgb(33 40 50 / 15%);
            }

            .card .card-header {
                font-weight: 500;
            }

            .card-header:first-child {
                border-radius: 0.35rem 0.35rem 0 0;
            }

            .card-header {
                padding: 1rem 1.35rem;
                margin-bottom: 0;
                background-color: rgba(33, 40, 50, 0.03);
                border-bottom: 1px solid rgba(33, 40, 50, 0.125);
            }

            .form-control, .dataTable-input {
                display: block;
                width: 100%;
                padding: 0.875rem 1.125rem;
                font-size: 0.875rem;
                font-weight: 400;
                line-height: 1;
                color: #69707a;
                background-color: #fff;
                background-clip: padding-box;
                border: 1px solid #c5ccd6;
                -webkit-appearance: none;
                -moz-appearance: none;
                appearance: none;
                border-radius: 0.35rem;
                transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
            }

            .nav-borders .nav-link.active {
                color: #0061f2;
                border-bottom-color: #0061f2;
            }

            .nav-borders .nav-link {
                color: #69707a;
                border-bottom-width: 0.125rem;
                border-bottom-style: solid;
                border-bottom-color: transparent;
                padding-top: 0.5rem;
                padding-bottom: 0.5rem;
                padding-left: 0;
                padding-right: 0;
                margin-left: 1rem;
                margin-right: 1rem;
            }

            @media (min-width: 1200px) {
                .col-xl-8 {
                    flex: 0 0 auto;
                    width: 66.66667%;
                }

                .col-xl-4 {
                    flex: 0 0 auto;
                    width: 33.33333%;
                }
            }
        </style>

    </head>
    <body id="bg">
        <div class="page-wraper">
            <div id="loading-icon-bx"></div>

            <!-- Header Top ==== -->
            <%@ include file="Header.jsp" %>
            <!-- header END ==== -->
            <!-- Content -->

            <c:set var="club" value="${requestScope.Club}"/>

            <!-- inner page banner -->
            <div class="page-banner ovbl-dark" style="background-image:url(${pageContext.request.contextPath}/images/banner.png);">
                <div class="container">
                    <div class="page-banner-entry">
                        <h1 class="text-white">Club Profile </h1>
                    </div>
                </div>
            </div>

            <!-- contact area -->
            <div class="container-xl px-4 mt-4">
                <div class="container-xl px-4 mt-4">
                    <div class="back-button">
                        <a href="ClubDetail?id=${club.getClub()}">
                            <i class="fas fa-arrow-left fa-x"></i> Back
                        </a>
                    </div>
                </div>
                <hr class="mt-0 mb-4">
                <div class="row">
                    <form action="UploadImageServlet" method="post" enctype="multipart/form-data" onsubmit="return checkFileSelected()">
                        <input type="hidden" value="${param.id}" name="id"/>
                        <div class="col-xl-4">
                            <!-- Profile picture card-->
                            <div class="card mb-4 mb-xl-0" style="width: 400px">
                                <div class="card-header">Club Picture</div>
                                <div class="card-body text-center" style="width: 400px">
                                    <!-- Profile picture image-->
                                    <img class="img-account-profile rounded-circle mb-2" src="${club.getImage()}" alt="" style="height: 300px;width: 300px">
                                    <!-- Profile picture help block-->
                                    <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                                    <!-- Profile picture upload button-->
                                    <input type="file" id="file" name="file" style="padding-left: 70px" ><br><br>
                                    <button class="btn btn-primary" type="submit" value="Upload">Upload new image</button>
                                </div>
                            </div>
                        </div>
                    </form>
                    </form>
                    <div class="col-xl-8">
                        <!-- Account details card-->
                        <div class="card mb-4">
                            <div class="card-header">Club Profile</div>
                            <div class="card-body">
                                <form action="ClubProfile" method="post">
                                    <input type="hidden" value="${club.getClub()}" name="id"/>
                                    <!-- Form Group (username)-->
                                    <div class="mb-3">
                                        <label class="small mb-1" for="inputUsername">Title</label>
                                        <input class="form-control" id="title" name="title" type="text"  value="${club.getTitle()}" >
                                    </div>
                                    <!-- Form Row-->
                                    <div class="row gx-3 mb-3">
                                        <!-- Form Group (first name)-->
                                        <div class="col-md-6">
                                            <label class="small mb-1" for="inputLocation" >Point</label>
                                            <input class="form-control" id="point" name="point" type="text"  value=${club.getPoint()}>
                                        </div>
                                        <!-- Form Group (last name)-->
                                        <div class="col-md-6">
                                            <label class="small mb-1" for="inputOrgName">Date Create</label>
                                            <input class="form-control" id="datecreate" name="datecreate" type="date"  value="${club.getDatecreate()}">
                                        </div>
                                    </div>
                                    <!-- Form Row-->
                                    <div class="row gx-3 mb-3">
                                        <!-- Form Group (organization name)-->

                                        <!-- Form Group (location)-->
                                        <div class="col-md-6">
                                            <label class="small mb-1" for="inputFirstName" >Type Club</label>
                                            <select name="typeclub" class="form-control">
                                                <c:forEach items="${requestScope.listtypeclub}" var="getTypeClub"> 
                                                    <c:if test="${ club.getTypebyid() == getTypeClub}">
                                                        <option selected="" value="${getTypeClub}">${getTypeClub}</option>
                                                    </c:if>
                                                    <c:if test="${ club.getTypebyid() != getTypeClub}">
                                                        <option value="${getTypeClub}">${getTypeClub}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                        </div>

                                    </div>
                                    <!-- Form Group (email address)-->
                                    <div class="mb-3">
                                        <label class="small mb-1" for="inputEmailAddress" >Desciption</label>
                                        <textarea name="description" id="description"  rows="5" style="width: 100%;">${club.getDescription()}</textarea>
                                    </div>
                                    <!-- Form Row-->
                                    <c:if test="${not empty errorMessage}">
                                        <div style="color: red; font-weight: bold;">${errorMessage}</div>
                                    </c:if>
                                    <c:if test="${not empty successMessage}">
                                        <div style="color: green; font-weight: bold;">${successMessage}</div>
                                    </c:if>
                                    <!-- Save changes button-->
                                    <button class="btn btn-primary" type="submit">Save changes</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Content END-->
            <!-- Footer ==== -->

            <!-- Footer END ==== -->
            <!-- scroll top button -->
            <%@include file="Footer.jsp" %>
            <button class="back-to-top fa fa-chevron-up" ></button>
        </div>
        <!-- External JavaScripts -->
        <script src="${pageContext.request.contextPath}/js_t/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/bootstrap/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/bootstrap/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/bootstrap-select/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/bootstrap-touchspin/jquery.bootstrap-touchspin.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/magnific-popup/magnific-popup.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/counter/waypoints-min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/counter/counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/imagesloaded/imagesloaded.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/masonry/masonry.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/masonry/filter.js"></script>
        <script src="${pageContext.request.contextPath}/vendors/owl-carousel/owl.carousel.js"></script>
        <script src="${pageContext.request.contextPath}/js_t/functions.js"></script>
        <script src="${pageContext.request.contextPath}/js_t/contact.js"></script>
        <!--<script src='${pageContext.request.contextPath}/vendors/switcher/switcher.js'></script>-->
<script>
    function checkFileSelected() {
        const fileInput = document.getElementById('file');
        if (fileInput.files.length === 0) {
            alert('Please select a file to upload.');
            return false; // Prevent form submission
        }
        return true; // Allow form submission
    }
</script>

    </body>

</html>
