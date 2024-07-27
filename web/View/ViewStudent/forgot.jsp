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
        <a href="<%= request.getContextPath() %>/home" class="btn btn-icon btn-primary"><i data-feather="home" class="icons"></i></a>
    </div>

    <!-- Hero Start -->
    <section class="bg-home d-flex bg-light align-items-center" style="background: url('<%= request.getContextPath() %>/assets/images/bg/bg-lines-one.png') center;">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-5 col-md-8">
                    <img src="<%= request.getContextPath() %>/assets/images/logo-dark.png" height="24" class="mx-auto d-block" alt="">
                    <div class="card login-page bg-white shadow mt-4 rounded border-0">
                        <div class="card-body">
                            <h4 class="text-center">Recover Account</h4>
                            <form action="<%= request.getContextPath() %>/forgot" method="post" class="login-form mt-4">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <p class="text-muted">Please enter your email address. You will receive a link to create a new password via email.</p>
                                        <div class="mb-3">
                                            <label class="form-label">Email address <span class="text-danger">*</span></label>
                                            <input type="text" class="form-control"  name="email" value="${email}">
                                        </div>
                                    </div>
                                    <h6 style="color: red;">${requestScope.error}</h6>
                                    <div class="col-lg-12">
                                        <div class="d-grid">
                                            <button class="btn btn-primary">Send</button>
                                        </div>
                                    </div>
                                    <div class="mx-auto">
                                        <p class="mb-0 mt-3"><small class="text-dark me-2">Remember your password?</small> <a href="View/ViewStudent/login.jsp" class="text-dark h6 mb-0">Sign in</a></p>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div><!---->
                </div> <!-- end col -->
            </div><!-- end row -->
        </div> <!-- end container -->
    </section><!-- end section -->
    <!-- Hero End -->

    <!-- javascript -->
    <script src="<%= request.getContextPath() %>/js/bootstrap.bundle.min.js"></script>
    <!-- Icons -->
    <script src="<%= request.getContextPath() %>/js/feather.min.js"></script>
    <!-- Main Js -->
    <script src="<%= request.getContextPath() %>/js/app.js"></script>

</body>
${requestScope.error}
</html>
