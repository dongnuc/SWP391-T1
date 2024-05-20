<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Tables - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/View/ViewAdmin/css/Event.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
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
            }

            .button:hover {
                background-color: #0056b3;
            }

            .form-reply {
                width: 400px;
                height: 200px;
                display: none; /* Initially hide the form */
                position: fixed;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                z-index: 999; /* Ensure it's on top of other elements */
                /* Add your desired styles for the form */
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
            }

            .form-reply.active {
                display: flex; /* Show the form when it has the "active" class */
            }

            .modal-dialog {
                margin: 0; /* Reset margin */
            }

            .modal-content {
                position: relative; /* Relative positioning */
            }

            .modal-header {
                border-bottom: 1px solid black;
                display: flex;
                padding: 15px 20px; /* Padding */
                border-bottom: 1px solid #ccc; /* Bottom border */
            }

            .modal-title {
                margin: 0; /* Reset margin */
            }

            .close {

                position: absolute; /* Absolute positioning */
                top: 15px; /* Distance from top */
                right: 20px; /* Distance from right */
                cursor: pointer; /* Cursor style */
            }

            .close:hover {
                color: #ff0000; /* Change color on hover */
            }
        </style>

    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="Navigation.jsp"/>
        <div id="layoutSidenav">
            <jsp:include page="SideBar.jsp"/>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Event</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="Dashboard.jsp">Dashboard</a></li>
                            <li class="breadcrumb-item active">Event</li>
                        </ol>
                        <div class="row">
                            <!-- Your Profile Views Chart -->
                            <div class="col-lg-12 m-b30">
                                <div class="widget-box">
                                    <div class="wc-title">
                                        <h4>Event Request</h4>
                                    </div>
                                    <div class="widget-inner">
                                        <div class="card-courses-list admin-review">
                                            <div class="card-courses-full-dec">
                                                <div class="card-courses-title">
                                                    <h4>Become a PHP Master and Make Money</h4>
                                                </div>
                                                <div class="card-courses-list-bx">
                                                    <ul class="card-courses-view">
                                                        <li class="card-courses-user">
                                                            <div class="card-courses-user-pic">
                                                                <img src="${pageContext.request.contextPath}/View/ViewAdmin/assets/img/H1.jpg" alt="Hello"/>
                                                            </div>
                                                            <div class="card-courses-user-info">
                                                                <h5>Reviewer</h5>
                                                                <h4>Keny White</h4>
                                                            </div>
                                                        </li>                                                       
                                                        <li class="card-courses-categories">
                                                            <h5>Date Start</h5>
                                                            <h4>10/12/2019</h4>
                                                        </li>

                                                        <li class="card-courses-categories">
                                                            <h5>Date End</h5>
                                                            <h4>10/12/2019</h4>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="row card-courses-dec">
                                                    <div class="col-md-12">
                                                        <h6 class="m-b10">Best Quality Product</h6>
                                                        <p>Lorem ipsum dolor sit amet, est ei idque voluptua copiosae, pro detracto disputando reformidans at, ex vel suas eripuit. Vel alii zril maiorum ex, mea id sale eirmod epicurei. Sit te possit senserit, eam alia veritus maluisset ei, id cibo vocent ocurreret per. Te qui doming doctus referrentur, usu debet tamquam et. Sea ut nullam aperiam, mei cu tollit salutatus delicatissimi. </p>	
                                                    </div>
                                                    <div class="col-md-12">
                                                        <button class="button toggle-form-reply" data-toggle="modal" data-target="#exampleModal" >Reply Review</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="widget-inner">
                                        <div class="card-courses-list admin-review">
                                            <div class="card-courses-full-dec">
                                                <div class="card-courses-title">
                                                    <h4>Become a PHP Master and Make Money</h4>
                                                </div>
                                                <div class="card-courses-list-bx">
                                                    <ul class="card-courses-view">
                                                        <li class="card-courses-user">
                                                            <div class="card-courses-user-pic">
                                                                <img src="${pageContext.request.contextPath}/View/ViewAdmin/assets/img/H1.jpg" alt="Hello"/>
                                                            </div>
                                                            <div class="card-courses-user-info">
                                                                <h5>Reviewer</h5>
                                                                <h4>Keny White</h4>
                                                            </div>
                                                        </li>
                                                        <li class="card-courses-review" style="text-align: center">
                                                            <h5>3 Review</h5>
                                                            <ul class="cours-star" style="display: flex; list-style-type: none;">
                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                <li class="active"><i class="fa fa-star"></i></li>
                                                                <li><i class="fa fa-star"></i></li>
                                                                <li><i class="fa fa-star"></i></li>
                                                            </ul>
                                                        </li>
                                                        <li class="card-courses-categories">
                                                            <h5>Date</h5>
                                                            <h4>10/12/2019</h4>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="row card-courses-dec">
                                                    <div class="col-md-12">
                                                        <h6 class="m-b10">Best Quality Product</h6>
                                                        <p>Lorem ipsum dolor sit amet, est ei idque voluptua copiosae, pro detracto disputando reformidans at, ex vel suas eripuit. Vel alii zril maiorum ex, mea id sale eirmod epicurei. Sit te possit senserit, eam alia veritus maluisset ei, id cibo vocent ocurreret per. Te qui doming doctus referrentur, usu debet tamquam et. Sea ut nullam aperiam, mei cu tollit salutatus delicatissimi. </p>	
                                                    </div>
                                                    <div class="col-md-12">
                                                        <button class="button toggle-form-reply" data-toggle="modal" data-target="#exampleModal" >Reply Review</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>


                                    <div class="form-reply" id="exampleModal" >
                                        <div class="modal-dialog" role="document" style="margin: 0 auto;">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Reply to review</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <form>
                                                        <input type="text">
                                                        <input type="submit" value="Reply"/>
                                                    </form>
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
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; Your Website 2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>

        <script>
            document.addEventListener("DOMContentLoaded", function () {
                // Get the form-reply element
                var formReply = document.querySelector('.form-reply');
                
                // Add click event listener to toggle the "active" class
                document.addEventListener("click", function (event) {
                    // Check if the clicked element has the class "toggle-form-reply"
                    if (event.target.classList.contains('toggle-form-reply')) {
                        // Toggle the "active" class of the form-reply element
                        formReply.classList.toggle('active');
                    }

                    if (event.target.classList.contains('close')) {
                        // Hide the form-reply element
                        formReply.classList.remove('active');
                    }
                });
            });

        </script>
    </body>
</html>
