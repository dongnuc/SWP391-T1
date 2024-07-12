<%-- 
    Document   : BlogPost
    Created on : Jun 10, 2024, 3:39:59 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
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
        <title>Blog Update </title>
        <script src="https://cdn.ckeditor.com/ckeditor5/41.4.2/classic/ckeditor.js"></script>
        <!-- MOBILE SPECIFIC ============================================= -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--[if lt IE 9]>
        <script src="${pageContext.request.contextPath}/assets_admin/js/html5shiv.min.js"></script>
        <script src="${pageContext.request.contextPath}/assets_admin/js/respond.min.js"></script>
        <![endif]-->
        <!-- All PLUGINS CSS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/assets.css">
        <link rel="stylesheet" type="text/css" src="${pageContext.request.contextPath}/assets_admin/vendors/calendar/fullcalendar.css">
        <!-- TYPOGRAPHY ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/typography.css">
        <!-- SHORTCODES ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/shortcodes/shortcodes.css">
        <!-- STYLESHEETS ============================================= -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/style.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/dashboard.css">
        <link class="skin" rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets_admin/css/color/color-1.css">
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
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 m-b30">
                        <div class="widget-box">
                            <div class="wc-title">
                                <h4>Information Update Blog</h4>
                            </div>
                            <div class="widget-inner">
                                <form class="edit-profile m-b30" action="${pageContext.request.contextPath}/BlogUpdateServlet" method="post" enctype="multipart/form-data">
                                    <input type="hidden" name="from" value="${fromPage}">
                                    <div class="row">
                                        <input type="hidden" name="idblog" value="${x.idBlog}">
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Title</label>
                                            <div>
                                                <textarea type="text" class="form-control" name="tittle">${x.titleBlog}</textarea>
                                            </div>
                                        </div>
                                        <div class="form-group col-6">
                                            <label class="col-form-label">Description</label>
                                            <div>
                                                <textarea type="text" class="form-control" name="description">${x.description}</textarea>
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Image</label>
                                            <div>
                                                <input class="form-control" type="file" id="file" name="file" accept="image/*" onchange="previewImage(event)">
                                                <img id="imagePreview" class="preview" src="${pageContext.request.contextPath}/${x.image}" alt="Image Preview">
                                                <input type="hidden" name="img" value="${x.image}">
                                            </div>
                                        </div>
                                        <div class="form-group col-12">
                                            <label class="col-form-label">Content</label>
                                            <div id="editor">
                                                <textarea class="form-control" name="content">${x.content}</textarea>
                                            </div>
                                            <script>
                                                ClassicEditor
                                                        .create(document.querySelector('#editor textarea'), {
                                                            toolbar: [
                                                                'heading', '|',
                                                                'bold', 'italic', 'link', 'bulletedList', 'numberedList', 'blockQuote', '|',
                                                                'undo', 'redo'
                                                            ]
                                                        })
                                                        .catch(error => {
                                                            console.error(error);
                                                        });

                                                function previewImage(event) {
                                                    const file = event.target.files[0];
                                                    if (file) {
                                                        const reader = new FileReader();
                                                        reader.onload = function (e) {
                                                            const preview = document.getElementById('imagePreview');
                                                            preview.src = e.target.result;
                                                            preview.style.display = 'block';
                                                        };
                                                        reader.readAsDataURL(file);
                                                    }
                                                }
                                                document.addEventListener('DOMContentLoaded', function () {
                                                    const expandableTextareas = document.querySelectorAll('.expandable-textarea');

                                                    expandableTextareas.forEach(textarea => {
                                                        textarea.addEventListener('input', resizeTextarea);
                                                        resizeTextarea.call(textarea);  // Initialize height based on initial content
                                                    });

                                                    function resizeTextarea() {
                                                        this.style.height = 'auto';  // Reset height to calculate new height
                                                        this.style.height = (this.scrollHeight) + 'px';  // Set new height based on scroll height
                                                    }
                                                });
                                            </script>

                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Show : </label>
                                            <div>
                                                <input type="radio" id="public" name="visibility" value="1" ${x.show == 1 ? "checked" : ""}>
                                                <label>Public</label>
                                            </div>
                                            <div>
                                                <input type="radio" id="private" name="visibility" value="0" ${x.show == 0 ? "checked" : ""}>
                                                <label>Private</label>
                                            </div>
                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Club : </label>
                                            <c:forEach var="studentClub" items="${studentClubList}">
                                                <c:choose>
                                                    <c:when test="${studentClub.status == 1 && studentClub.leader == 1}">
                                                        <div>
                                                            <input type="radio" name="idclub" value="${studentClub.idClub}" ${x.idClub == studentClub.idClub ? "checked" : ""}> ${clubDAO.getClubNameByID(studentClub.idClub)}
                                                        </div>
                                                    </c:when>
                                                </c:choose>
                                            </c:forEach>
                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Blog's type : </label>
                                            <c:forEach var="blogType" items="${blogTypeList}">
                                                <div>
                                                    <input type="radio" name="blogtype" value="${blogType.idSetting}" ${x.idBlogType == blogType.idSetting ? "checked" : ""}>${blogType.valueSetting}
                                                </div>
                                            </c:forEach>
                                        </div>
                                        <div class="form-group col-3">
                                            <label class="col-form-label">Status</label>
                                            <div>
                                                <input type="radio" name="status" value="1" ${x.status == 1 ? "checked" : ""}>Active <br> 
                                                <input type="radio" name="status" value="0" ${x.status == 0 ? "checked" : ""}>Stop 
                                            </div>
                                        </div>
                                        <p style="color: red;"><c:out value="${mess}" /></p>
                                        <div class="col-12">
                                            <button type="submit" class="btn-secondry add-item m-r5"><i class="fa fa-fw fa-plus-circle"></i>Update Blog</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
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
        <script src='${pageContext.request.contextPath}/assets_admin/vendors/switcher/switcher.js'></script>
        <script>
                                                // Pricing add
                                                function newMenuItem() {
                                                    var newElem = $('tr.list-item').first().clone();
                                                    newElem.find('input').val('');
                                                    newElem.appendTo('table#item-add');
                                                }
                                                if ($("table#item-add").is('*')) {
                                                    $('.add-item').on('click', function (e) {
                                                        e.preventDefault();
                                                        newMenuItem();
                                                    });
                                                    $(document).on("click", "#item-add .delete", function (e) {
                                                        e.preventDefault();
                                                        $(this).parent().parent().parent().parent().remove();
                                                    });
                                                }
        </script>
    </body>

    <!-- Mirrored from educhamp.themetrades.com/demo/admin/add-listing.html by HTTrack Website Copier/3.x [XR&CO'2014], Fri, 22 Feb 2019 13:09:05 GMT -->
</html>
