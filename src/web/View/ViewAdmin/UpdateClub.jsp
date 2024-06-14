<%-- 
    Document   : UpdateClub
    Created on : Jun 2, 2024, 4:02:25 PM
    Author     : Nguyen Hau
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <title>Doctris - Doctor Appointment Booking System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Premium Bootstrap 4 Landing Page Template" />
        <meta name="keywords" content="Appointment, Booking, System, Dashboard, Health" />
        <meta name="author" content="Shreethemes" />
        <meta name="email" content="support@shreethemes.in" />
        <meta name="website" content="https://shreethemes.in" />
        <meta name="Version" content="v1.2.0" />
        <!-- favicon -->
        <link rel="shortcut icon" href="<%= request.getContextPath() %>/assets/images/favicon.ico.png">
        <!-- Bootstrap -->
        <link href="<%= request.getContextPath() %>/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- Icons -->
        <link href="<%= request.getContextPath() %>/css/materialdesignicons.min.css" rel="stylesheet" type="text/css" />
        <link href="<%= request.getContextPath() %>/css/remixicon.css" rel="stylesheet" type="text/css" />
        <link href="https://unicons.iconscout.com/release/v3.0.6/css/line.css" rel="stylesheet">
        <!-- Css -->
        <link href="<%= request.getContextPath() %>/css/style.min.css" rel="stylesheet" type="text/css" id="theme-opt" />
    </head>

    <body>
        <!-- Loader -->
        <div id="preloader">
            <div id="status">
                <div class="spinner">
                    <div class="double-bounce1"></div>
                    <div class="double-bounce2"></div>
                </div>
            </div>
        </div>
        <!-- Loader -->

        <div class="back-to-home rounded d-none d-sm-block">
            <a href="SWP392/ClubController" class="btn btn-icon btn-primary"><i data-feather="home" class="icons"></i></a>
        </div>


        <!-- Hero Start -->
        <section class="bg-half-150 d-table w-100 bg-light" style="background: url('<%= request.getContextPath() %>/assets/images/bg/bg-lines-one.png') center;">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5 col-md-8">
                        <img src="<%= request.getContextPath() %>/assets/images/logo-dark.png" height="24" class="mx-auto d-block" alt="">
                        <div class="card login-page bg-white shadow mt-4 rounded border-0">
                            <div class="card-body">
                                <h4 class="text-center">Update Club</h4>  
                                <c:set var="club" value="${requestScope.Club}"/>
                                <c:set var="type" value="${requestScope.type}"/>
                                <form action="<%= request.getContextPath() %>/UpdateClub" method="post">
                                    <div class="row">
                                        <input type="hidden" name="id" value="${club.getClub()}">
                                        <div class="col-md-12">
                                            <div class="mb-3">
                                                <label class="form-label">Name Club <span class="text-danger">*</span></label>
                                                <input type="text" class="form-control"  name="nameclub" value="${club.getNameclub()}">
                                            </div>
                                        </div>

                                        <div class="col-md-6">
                                            <div class="mb-3">                                               
                                                <label class="form-label">Date create <span class="text-danger">*</span></label>
                                                <input type="text" class="form-control" value="${club.getDatecreate()}" name="datecreate" >
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="mb-3">                                                
                                                <label class="form-label">Point <span class="text-danger">*</span></label>
                                                <input type="text" class="form-control" value="${club.getPoint()}" name="point" >
                                            </div>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="mb-3">
                                                <label class="form-label">Select type club <span class="text-danger">*</span></label>
                                                <select id="clubId" name="idypleclub" class="input-field">

                                                    <option>${club.getStringType()}</option>
                                                    <c:forEach items="${requestScope.listtypeclub}" var="getTypeClub"> 
                                                        <option value="${getTypeClub.getIdTypeClub()}">${getTypeClub.getNameTypeClub()}</option>
                                                    </c:forEach> 
                                                </select>
                                            </div>
                                            <h6 style="color: red;">${requestScope.error}</h6>
                                        </div>


                                        <div class="col-md-12">
                                            <div class="d-grid"> 

                                                <button type="submit" class="btn btn-primary">Update</button>

                                            </div>
                                        </div>


                                    </div>
                                </form>
                            </div>
                        </div><!---->
                    </div> <!--end col-->
                </div><!--end row-->
            </div> <!--end container-->
        </section><!--end section-->
        <!-- Hero End -->

        <!-- javascript -->
        <script src="<%= request.getContextPath() %>/js/bootstrap.bundle.min.js"></script>
        <!-- Icons -->
        <script src="<%= request.getContextPath() %>/assets/js/feather.min.js"></script>
        <!-- Main Js -->
        <script src="<%= request.getContextPath() %>/js/app.js"></script>

    </body>


</html>
