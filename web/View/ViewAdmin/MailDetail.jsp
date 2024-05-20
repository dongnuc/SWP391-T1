<%-- 
    Document   : MailDetail
    Created on : May 19, 2024, 12:39:21 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

        <link href="${pageContext.request.contextPath}/View/ViewAdmin/css/Mail.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/View/ViewAdmin/css/Event.css" rel="stylesheet" />       
        <link href="css/styles.css" rel="stylesheet" />
        <style>
            .button {
                display: inline-block;
                padding: 5px 10px;
                background-color: #007bff;
                color: #ffffff;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
                text-align: center;
                text-decoration: none;
                transition: background-color 0.3s ease;
                margin: 10px 0px;
            }

            .button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <jsp:include page="Navigation.jsp"/>
        <div id="layoutSidenav">
            <jsp:include page="SideBar.jsp"/>

            <div id="layoutSidenav_content">
                <main class="ttr-wrapper">
                    <div class="container-fluid">
                        <div class="db-breadcrumb">
                            <h4 class="breadcrumb-title">Mail Read</h4>
                            <ul class="db-breadcrumb-list">
                                <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                                <li>Mail Read</li>
                            </ul>
                        </div>	
                        <div class="row">
                            <!-- Your Profile Views Chart -->
                            <div class="col-lg-12 m-b30">
                                <div class="widget-box">
                                    <div class="email-wrapper">

                                        <div class="mail-list-container">

                                            <div class="mailbox-view">
                                                <div class="mailbox-view-title">
                                                    <h5 class="send-mail-title">Your message title goes here</h5>
                                                </div>
                                                <div class="send-mail-details">
                                                    <div class="d-flex" style="justify-content: space-between;">
                                                        <div class="send-mail-user">
                                                            <div class="send-mail-user-pic">
                                                                <img src="assets/images/testimonials/pic3.jpg" alt="">
                                                            </div>
                                                            <div class="send-mail-user-info">
                                                                <h4>Pavan kumar</h4>
                                                                <h5>From: example@info.com</h5>
                                                            </div>
                                                        </div>
                                                        <div class="ml-auto send-mail-full-info">
                                                            <div class="time"><span>10:25 PM</span></div>
                                                           
                                                        </div>
                                                    </div>
                                                    <div class="read-content-body">
                                                        <h5 class="read-content-title">Hi,Ingredia,</h5>
                                                        <p><strong>Ingredia Nutrisha,</strong> A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture</p>
                                                        <p>Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of
                                                            Grammar. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus.
                                                        </p>
                                                        <p>Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet.
                                                            Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero,
                                                            sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar,</p>

                                                        <h5 class="read-content-title">Kind Regards</h5>
                                                        <p class="read-content-name">Mr Smith</p>
                                                        <hr>
                                                        <h6> <i class="fa fa-download m-r5"></i> Attachments <span>(3)</span></h6>
                                                        <div class="mailbox-download-file">
                                                            <a href="#"><i class="fa fa-file-image-o"></i> photo.png</a>
                                                            <a href="#"><i class="fa fa-file-text-o"></i> dec.text</a>
                                                            <a href="#"><i class="fa fa-file"></i> video.mkv</a>
                                                        </div>
                                                        <hr>
                                                        <div class="form-group">
                                                            <h6>Reply Message</h6>
                                                            <div class="m-b15">
                                                                <textarea class="form-control"> </textarea>
                                                            </div>
                                                            <button class="button">Reply Now</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div> 
                            </div>
                            <!-- Your Profile Views Chart END-->
                        </div>
                    </div>
                </main>
            </div>


            <div class="ttr-overlay"></div>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
            <script src="js/scripts.js"></script>
            <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>

    </body>
</html>
