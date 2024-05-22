<%-- 
    Document   : Header
    Created on : May 21, 2024, 7:25:43 PM
    Author     : Admin
--%>

<header>
                <div class="top">
                    <div class="container">
                        <c:if test="${sessionScope.account==null}">
                               <div class="top-menu">
                            <a href="View/ViewStudent/login.jsp" class="icon-login">
                             <i class="fa fa-sign-in"></i> ??ng nh?p
                                </a>
                           <span class="separator">|</span>
                            <a href="View/ViewStudent/register.jsp" class="icon-register">
                                <i class="fa fa-user-plus"></i> ??ng ký</a>
 
                        </div>
                               </c:if>
                    </div>
                </div>
                <div class="main-menu-header">
                    <div class="container">   
                        <div id="nav-menu">
                            <ul>
                                <li>
                                    <a href="HomeControl">Trang ch?</a>
                                </li>
                                <</li>
            <li class="dropdown" onclick="toggleClubTable()">
                <a href="#">Các CLB</a>
                <div class="dropdown-content" id="club-table">
                    <!-- Thêm các CLB vào ?ây -->
                    <a class="chu" href="#">CLB Ti?ng Anh</a>
                    <a class="chu" href="#">CLB Ti?ng Nh?t</a>
                    <a class="chu" href="#">CLB Ti?ng Trung</a>
                    <a class="chu" href="#">CLB Ti?ng Hàn</a>
                </div>
            </li>
                                </li>
                                <c:if test="${sessionScope.account!=null}">
                                <li>
                                    <a href="HomeControl">CLB(C?a tôi)</a>
                                    <c:forEach items="${sessionScope.myclub}" var="x">   
                                        <p>${x}</p>  
                                    </c:forEach>
                                </li>
                            </c:if>
                                <li>
                                    <a href="HomeControl">S? ki?n</a>
                                </li>
                                   <li>
                                    <a href="HomeControl">Tuy?n sinh</a>
                                </li>
                            </ul>
                            <div class="clear"></div>
                        </div>
                    </div>
    <div class="user-profile" onmouseover="showProfileInfo()" onmouseout="hideProfileInfo()" onclick="toggleProfileInfo()">
        <c:if test="${sessionScope.account!=null}">
    <div class="profile-picture">
        <img src="images/avatar.png" alt="">
        <div class="profile-info" id="profile-info">
            <h6>Xin chao ${sessionScope.account}</h6>
                                <a href="" id="logout-link">Edit profile</a>
                                <c:if test="${sessionScope.password==null}">
                                    <a href="View/ViewStudent/password.jsp" id="logout-link">Setting password</a>
                                </c:if>
                                <c:if test="${sessionScope.password!=null}">
                                    <a href="View/ViewStudent/changepassword.jsp" id="logout-link">Change Password</a>
                                </c:if>
                                <a href="logout" id="logout-link">??ng Xu?t</a>
        </div>
    </div>
    </c:if>
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