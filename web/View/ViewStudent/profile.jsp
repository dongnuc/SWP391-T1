<%-- 
    Document   : testfrofile
    Created on : Jun 11, 2024, 1:02:52 PM
    Author     : 84358
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.css" rel="stylesheet">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.12/cropper.min.js"></script>
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
            .father {
                position: relative;
                
            }
            .son {
                display: none;
                position: absolute;
                margin-top: 150px;
                width: 70%;
                height: auto;
                margin-left: 15%;
                margin-right: 15%;
                top: 20px;
                left: 20px;
                background: white;
                box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            }
            .son img {
                width: 50%;
                height: auto;
                display: block;
            }
            .img1 {
                margin-top: 5%;
                margin-bottom: 2%;
                background: white;
            }
            .canok {
                display: flex;
                margin-left: 89%;
            }
            .huy2{
                margin-left: 20px;
            }
            .overlay {
                display: none;
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                background-color: rgba(0, 0, 0, 0.5);
                z-index: 1000;
            }
            .header{
/*                background: lightblue;*/
            }
        </style>
    </head>
    <c:if test="${requestScope.huy == 1}">
        <c:set var="phoneValue" value="${phone}" />
        <c:set var="names" value="${name}" />
        <c:set var="dates" value="${dob}" />
    </c:if>
    <c:if test="${requestScope.huy != 1}">
        <c:set var="phoneValue" value="${accountprofile.sdt}" />
        <c:set var="names" value="${accountprofile.name}" />
        <c:set var="dates" value="${accountprofile.date}" />
    </c:if>


    <body>
        <%@ include file="Header.jsp"%>
        <div class="page-banner ovbl-dark" style="background-image:url(${pageContext.request.contextPath}/images_t/banner/banner2.jpg);
             height: 150px;">
                <div class="container">
                    <div class="page-banner-entry">
                        
                    </div>
                </div>
            </div>
        <div class="container-xl px-4 mt-4 father">
            
            <!-- Account page navigation-->
            <!--    <nav class="nav nav-borders">
                    <a class="nav-link active ms-0" href="https://www.bootdey.com/snippets/view/bs5-edit-profile-account-details" target="__blank">Profile</a>
                    <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-billing-page" target="__blank">Billing</a>
                    <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-profile-security-page" target="__blank">Security</a>
                    <a class="nav-link" href="https://www.bootdey.com/snippets/view/bs5-edit-notifications-page"  target="__blank">Notifications</a>
                </nav>-->
            <hr class="mt-0 mb-4">
            <div class="row">
                <div class="col-xl-4">
                    <!-- Profile picture card-->
                    <div class="card mb-4 mb-xl-0">
                        <div class="card-header">Profile Picture</div>
                        <form id="avatar-form" action="uploadavatar" method="post" enctype="multipart/form-data">
                            <div class="card-body text-center">

                                <img class="img-account-profile  mb-2" src="${accountprofile.image != null ? accountprofile.image : 'images/avatar.png'}" alt="" id="profile-pic">

                                <div class="small font-italic text-muted mb-4"></div>
                                <input type="hidden" id="x" name="x">
                                <input type="hidden" id="y" name="y">
                                <input type="hidden" id="width" name="width">
                                <input type="hidden" id="height" name="height">
                                <input type="file" id="input-file" style="display: none" name="input-file" accept="image/*">
                                <button class="btn btn-primary" type="button" id="upload-button">Upload new image</button>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-xl-5">
                    <!-- Account details card-->
                    <div class="card mb-4">
                        <div class="card-header">Account Details</div>
                        <div class="card-body">
                            <form action="profile" method="post">
                                <!-- Form Group (username)-->
                                <div class="mb-3">
                                    <label class="small mb-1" for="inputUsername">Email</label>
                                    <input class="form-control" id="inputUsername" name="email" type="text" value="${accountprofile.email}" readonly="" >
                                </div>
                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (first name)-->
                                    <div class="col-md-12">
                                        <label class="small mb-1" for="inputFirstName">Name</label> 
                                        <input class="form-control" id="inputFirstName" name="name" type="text" value="${names}">
                                        <div style="color: red">${errorname}</div>
                                    </div>

                                </div>
                                <!-- Form Row        -->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (organization name)-->
                                    <div class="col-md-12">
                                        <label class="small mb-1" for="inputOrgName">Phone</label>
                                        <input class="form-control" id="inputOrgName" name="phone" type="text" value="${phoneValue}">
                                        <div style="color: red">${errorphone}</div>
                                    </div>

                                </div>
                                    

                                <!-- Form Row-->
                                <div class="row gx-3 mb-3">
                                    <!-- Form Group (phone number)-->

                                    <!-- Form Group (birthday)-->
                                    <div class="col-md-12">
                                        <label class="small mb-1" for="inputBirthday">Birthday</label>
                                        <input class="form-control" id="inputBirthday" name="dob" type="date" name="birthday"  value="${dates}">
                                        <div style="color: red">${errordob}</div>
                                    </div>
                                </div>
                                    <div class="row gx-3 mb-3">
                                    <!-- Form Group (organization name)-->
                                    <div class="col-md-12">
                                    <input type="radio" id="gender1" name="gender" value="1" ${accountprofile.gender == 1 ? 'checked' : ''} >
                                    <label for="male">Male</label>
                                    <input type="radio" id="gender2" name="gender" value="0" ${accountprofile.gender == 0 ? 'checked' : ''} >
                                    <label for="female">Female</label>
                                    </div>

                                </div>
                                <!-- Save changes button-->
                                
                                <button class="btn btn-primary" type="submit">Save changes</button>
                            </form>
                                    <div style="color: green">
                                        ${sessionScope.success}
                                    </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="overlay"></div>
        <div class="son"  style="z-index: 1001; border-radius: 5px; ">
            <div>
                <h3>Crop Profile Image</h3>
            </div>
            <div class="img1"><img src="" id="output"></div>
            <div class="canok">
                <div class="huy1"><button id="cancel">Cancel</button></div>
                <div class="huy2"><button id="ok">OK</button></div>
            </div>
        </div>
    </body>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css'>
    <script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js'></script>
</html>
<script>
    document.getElementById('upload-button').addEventListener('click', function () {
        document.getElementById('input-file').click();
    });
    let profilePic = document.getElementById("profile-pic");
    let inputFile = document.getElementById("input-file");
    let picoutput = document.getElementById("output");
    let cropper;
    inputFile.onchange = function () {
        if (inputFile.files && inputFile.files[0]) {
            picoutput.src = URL.createObjectURL(inputFile.files[0]);
            if (cropper) {
                cropper.destroy();
            }
            picoutput.onload = function () {
                document.querySelector('.son').style.display = 'block';
                document.querySelector('.overlay').style.display = 'block';

                cropper = new Cropper(picoutput, {
                    aspectRatio: 1,
                    viewMode: 1,
                    crop(event) {
                        document.getElementById('x').value = event.detail.x;
                        document.getElementById('y').value = event.detail.y;
                        document.getElementById('width').value = event.detail.width;
                        document.getElementById('height').value = event.detail.height;
                    }
                });
            };
        }
    };
    document.querySelector('#cancel').addEventListener('click', function () {
        document.querySelector('.son').style.display = 'none';
        document.querySelector('.overlay').style.display = 'none';
        document.body.style.backgroundColor = '';
        if (cropper) {
            cropper.destroy();
        }
    });
    document.querySelector('#ok').addEventListener('click', function () {
        if (cropper) {
            document.getElementById('avatar-form').submit();
        }
    });

</script>
<script>
            // JavaScript functions
            var isProfileVisible = false;

            function showProfileInfo() {
                var profileInfo = document.getElementById("profile-info");
                if (!isProfileVisible) {
                    profileInfo.style.display = "block";
                }
            }

            function hideProfileInfo() {
                var profileInfo = document.getElementById("profile-info");
                if (!isProfileVisible) {
                    profileInfo.style.display = "none";
                }
            }

            function toggleProfileInfo() {
                var profileInfo = document.getElementById("profile-info");
                if (!isProfileVisible) {
                    profileInfo.style.display = "block";
                    isProfileVisible = true;
                } else {
                    isProfileVisible = false;
                }
            }

// Ẩn thông tin người dùng khi click ra ngoài
            document.addEventListener("click", function (event) {
                var profileInfo = document.getElementById("profile-info");
                if (!event.target.closest(".profile-picture") && isProfileVisible) {
                    profileInfo.style.display = "none";
                    isProfileVisible = false;
                }
            });
            document.addEventListener("DOMContentLoaded", function () {
                var paginationLinks = document.querySelectorAll('.pagination a');
                paginationLinks.forEach(function (link) {
                    link.addEventListener('click', function (event) {
                        event.preventDefault();
                        var currentPage = parseInt(this.textContent);
                        setActivePage(currentPage);
                    });
                });

                function setActivePage(pageNumber) {
                    var paginationLinks = document.querySelectorAll('.pagination a');
                    paginationLinks.forEach(function (link) {
                        link.classList.remove('active');
                    });
                    paginationLinks[pageNumber - 1].classList.add('active');

                    // Do something here to load data for the selected page
                }
            });
        </script>