    <%-- 
    Document   : HomePage
    Created on : May 15, 2024, 10:18:35 AM
    Author     : Nguyen Hau
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>HomePage</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,500i">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/responsive.css">
    </head>
   <div id="wallpaper">
            <header>
                <div class="top">
                    <div class="container">
                               <div class="top-menu">
                            <a href="login.jsp" class="icon-login">
                             <i class="fa fa-sign-in"></i> Đăng nhập
                                </a>
                           <span class="separator">|</span>
                            <a href="register.jsp" class="icon-register">
                                <i class="fa fa-user-plus"></i> Đăng ký</a>
 
                        </div>
                    </div>
                </div>
               
                
                
                <div class="main-menu-header">
                    <div class="container">   
                        <div id="nav-menu">
                            <ul>
                                <li>
                                    <a href="HomeControl">Trang chủ</a>
                                </li>
                                <</li>
            <li class="dropdown" onclick="toggleClubTable()">
                <a href="#">Các CLB</a>
                <div class="dropdown-content" id="club-table">
                    <!-- Thêm các CLB vào đây -->
                    <a class="chu" href="#">CLB Tiếng Anh</a>
                    <a class="chu" href="#">CLB Tiếng Nhật</a>
                    <a class="chu" href="#">CLB Tiếng Trung</a>
                    <a class="chu" href="#">CLB Tiếng Hàn</a>
                </div>
            </li>
                                </li>
                                <li>
                                    <a href="HomeControl">CLB(Của tôi)</a>
                                </li>
                                <li>
                                    <a href="HomeControl">Sự kiện</a>
                                </li>
                                   <li>
                                    <a href="HomeControl">Tuyển sinh</a>
                                </li>
                            </ul>
                            <div class="clear"></div>
                        </div>
                    </div>
                   <div class="user-profile" onmouseover="showProfileInfo()" onmouseout="hideProfileInfo()" onclick="toggleProfileInfo()">
    <div class="profile-picture">
        <img src="images/avatar.png" alt="">
        <div class="profile-info" id="profile-info">
            <a href="#" id="logout-link">Edit profile</a>
            <h3>User Name</h3>
            <p>Email: example@example.com</p>
            <p>Role: Admin</p>
            <a href="#" id="logout-link">Đăng Xuất</a>
        </div>
    </div>
</div>
 </div>
                
                
                                             <div class="main-header">
                    <div class="container">
                        <div class="row">
                            <div class="col-6 col-xs-6 col-sm-6 col-md-3 col-lg-3 order-md-0 order-0">
                                <div class="logo">
                                    <a href="HomeControl"><img src="images/logo3.png" alt=""></a>
                                </div>
                            </div>
                            <div class="col-12 col-xs-12 col-sm-12 col-md-6 col-lg-6 order-md-1 order-2">
                                <div class="form-seach-product">
                                    <form action="SearchProduct" method="post" role="form">
                                        <div class="input-seach">
                                            <input type="text" name="search" id="" class="form-control">
                                            <button type="submit" class="btn-search-pro"><i class="fa fa-search"></i></button>
                                        </div>
                                        <div class="clear"></div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
</header>
       
       
            <div id="content">
              <div class="container-fluid">
    <div id="carouselExampleControls" class="carousel slide vw-95" style="height: 800px;" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleControls" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleControls" data-slide-to="1"></li>
            <li data-target="#carouselExampleControls" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner" style="height: 100%;">
            <div class="carousel-item active" style="height: 100%;">
                <img class="d-block w-100" src="images/123.png" alt="First slide">
            </div>
            <div class="carousel-item" style="height: 100%;">
                <img class="d-block w-100" src="images/1234.png" alt="Second slide">
            </div>
            <div class="carousel-item" style="height: 100%;">
                <img class="d-block w-100" src="images/123456.png" alt="Third slide">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>    
 </div>
           
       
       
       <div class="container">
        <div class="row">
            <!-- Khung chứa thông báo (nửa bên trái) -->
            <div class="col-md-6">
               <div class="table-container" id="table-container">
                   <h2>Thông báo chung</h2>
    <table class="table">
        <!-- Nội dung của bảng -->
        <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 1</span></td>
        </tr>
        <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 2</span></td>
        </tr>
        <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 3</span></td>
        </tr>
        <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 4</span></td>
        </tr>
        <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 5</span></td>
        </tr>
         <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 6</span></td>
        </tr>
         <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 7</span></td>
        </tr>
         <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 8</span></td>
        </tr>
         <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 9</span></td>
        </tr>
         <tr>
            <td><span class="bullet"></span><span class="content">Thông báo 10</span></td>
        </tr>
        <tr>
            <td colspan="1">
                <div class="pagination">
                    <a href="#" class="active">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                </div>
            </td>
        </tr>
    </table>
</div>
            </div>
            <!-- Khung chứa thông tin hot (nửa bên phải) -->
            <div class="col-md-6">
                <!-- Thông tin hot -->
                <div class="hot-info" id="page1">
                    <!-- Các thông tin hot của trang 1 -->
                    <div class="blog-item">
                        <h2>Thông tin hot 1</h2>
                        <p>Nhập nội dung</p>
                    </div>
                    <div class="blog-item">
                        <h2>Thông tin hot 2</h2>
                        <p>Nhập nội dung</p>
                    </div>    
                    <div class="blog-item">
                        <h2>Thông tin hot 3</h2>
                        <p>Nhập nội dung</p>
                    </div>
                    <div class="blog-item">
                        <h2>Thông tin hot 4</h2>
                        <p>Nhập nội dung</p>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
       
       
       
      <div class="white-frame">
    <div class="button1">
        <div class="button-container">
            <a href="/path/to/all" class="view-all-button">Xem tất cả</a>
        </div>
    </div>
</div>
       
<div class="full-screen-container">
    <h1 class="title">Sự kiện nổi bật qua các tháng</h1>
    <div class="background">
    <img src="images/banner.png" alt="">
    </div>
     <div class="events-container">
        <div class="event">
            <img src="images/11.png" alt="Tháng 1" class="event-image">
            <h2>Tháng 1</h2>
            <p>Sự kiện A, Sự kiện B, Sự kiện C...</p>
        </div>
        <div class="event">
            <img src="images/22.png" alt="Tháng 2" class="event-image">
            <h2>Tháng 2</h2>
            <p>Sự kiện D, Sự kiện E, Sự kiện F...</p>
        </div>
        <div class="event">
            <img src="images/33.png" alt="Tháng 3" class="event-image">
            <h2>Tháng 3</h2>
            <p>Sự kiện G, Sự kiện H, Sự kiện I...</p>
        </div>
        <div class="event">
            <img src="images/44.png" alt="Tháng 4" class="event-image">
            <h2>Tháng 4</h2>
            <p>Sự kiện J, Sự kiện K, Sự kiện L...</p>
        </div>
        <!-- Thêm các tháng khác theo định dạng tương tự -->
    </div>
</div>
       
       <div class="full-height-container">
            <div class="inner-container">
           <table>
        <tr>
            <td class="left-column" >
                <div class="left-content">
                    <h3>CÙNG NHAU CHIA SẺ, CÙNG NHAU PHÁT TRIỂN.</h3>
                    <img src="images/bannercuoi.png" alt="">
                </div>
            </td>
            <td class="right-column">
                <div class="right-content">
                    <h2>NỘI QUY CHUNG:</h2>
                    <ul s>
                         <li><span class="bold-before-colon">Tôn trọng và hợp tác:</span> Tôn trọng lẫn nhau và hỗ trợ đồng nghiệp.</li>
                         <li><span class="bold-before-colon">Đạo đức học thuật:</span> Tuân thủ nguyên tắc không gian lận và gian lận.</li>
                         <li><span class="bold-before-colon">Tuân thủ quy định trường:</span> Tuân thủ các quy định và chính sách của trường.</li>
                         <li><span class="bold-before-colon">An toàn và bảo mật:</span> Đảm bảo an toàn cho bản thân và người khác.</li>
                         <li><span class="bold-before-colon">Tham gia và xây dựng cộng đồng:</span> Tham gia tích cực xây dựng cộng đồng.</li>
                         <li><span class="bold-before-colon">Trách nhiệm tài chính:</span> Chịu trách nhiệm về tài chính cá nhân.</li>
                         <li><span class="bold-before-colon">Quản lý thời gian:</span> Quản lý thời gian và công việc hiệu quả.</li>
                    </ul>
                </div>
            </td>
        </tr>
    </table>
    </div>
</div>
       
       
            <footer>
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
                            <div class="box-footer info-contact">
                                <h3>Thông tin khác</h3>
                                <div class="content-list">
                                    <ul>
                                        <li><a href="#"><i class="fa fa-angle-double-right"></i>Tổng đài: 024 7300 5588</a></li>
                                        <li><a href="#"><i class="fa fa-angle-double-right"></i>Chỉ dùng với mail : @fpt.edu.vn </a></li>
                                       <li><a href="https://www.facebook.com/DaihocFPTHaNoi" target="_blank"><i class="fa fa-angle-double-right"></i>Fanpage</a></li>
                                        <h2>We Accept:</h2>
                            <img src="images/logo.png" alt="Payment Method" />
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>

        </div>
    
    
    
    
    
    
    <script>
        function toggleClubTable() {
    var clubTable = document.getElementById("club-table");
    if (clubTable.style.display === "block") {
        clubTable.style.display = "none";
    } else {
        clubTable.style.display = "block";
    }
}
                    // Function thay đổi trang
                    function changePage(page) {
                        // Ẩn tất cả các trang thông tin hot
                        var hotInfos = document.querySelectorAll('.hot-info');
                        for (var i = 0; i < hotInfos.length; i++) {
                            hotInfos[i].style.display = 'none';
                        }
                        // Hiển thị trang được chọn
                        document.getElementById('page' + page).style.display = 'block';
                    }
                    // Mặc định hiển thị trang 1 khi trang được tải
                    changePage(1);
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
document.addEventListener("click", function(event) {
    var profileInfo = document.getElementById("profile-info");
    if (!event.target.closest(".user-profile") && isProfileVisible) {
        profileInfo.style.display = "none";
        isProfileVisible = false;
    }
});
document.addEventListener("DOMContentLoaded", function() {
    var paginationLinks = document.querySelectorAll('.pagination a');
    paginationLinks.forEach(function(link) {
        link.addEventListener('click', function(event) {
            event.preventDefault();
            var currentPage = parseInt(this.textContent);
            setActivePage(currentPage);
        });
    });

    function setActivePage(pageNumber) {
        var paginationLinks = document.querySelectorAll('.pagination a');
        paginationLinks.forEach(function(link) {
            link.classList.remove('active');
        });
        paginationLinks[pageNumber - 1].classList.add('active');

        // Do something here to load data for the selected page
    }
});
</script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
        <div id="fb-root"></div>
        <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v6.0"></script>
    </body>
</html>
