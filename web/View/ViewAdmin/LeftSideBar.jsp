<%-- 
    Document   : LeftSideBar
    Created on : May 21, 2024, 3:24:47 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="ttr-sidebar">
    <div class="ttr-sidebar-wrapper content-scroll">
        <!-- side menu logo start -->

        <div class="ttr-sidebar-logo">
            <a href="dashboardAdmin">
                <img alt="" src="images/logo3.png" width="122" height="27" style=" position: absolute;
                     top: 10px;
                     left: 10px;">
            </a>
            <!-- <div class="ttr-sidebar-pin-button" title="Pin/Unpin Menu">
                    <i class="material-icons ttr-fixed-icon">gps_fixed</i>
                    <i class="material-icons ttr-not-fixed-icon">gps_not_fixed</i>
            </div> -->
            <div class="ttr-sidebar-toggle-button">
                <i class="ti-arrow-left"></i>
            </div>
        </div>
        <!-- side menu logo end -->
        <!-- sidebar menu start -->

        <!-- sidebar menu end -->
        <!--<h5 style="margin: 5px 5px;">Admin</h5>-->
        <nav class="ttr-sidebar-navi">
            <ul>
                <li>
                    <a href="dashboardAdmin" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-home"></i></span>
                        <span class="ttr-label">Dashborad</span>
                    </a>
                </li>          
                <li>

                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-list"></i></span>
                        <span class="ttr-label">List Setting</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul>
                        <li>
                            <a href="settingList" class="ttr-material-button"><span class="ttr-label">List Setting</span></a>
                        </li>
                        <li>
                            <a href="addSetting" class="ttr-material-button"><span class="ttr-label">Add Setting</span></a>
                        </li>

                    </ul>
                </li>  
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-email"></i></span>
                        <span class="ttr-label">Mailbox</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul>
                        <li>
                            <a href="loadForm" class="ttr-material-button"><span class="ttr-label">Mail Box</span></a>
                        </li>
                        <li>
                            <a href="home" class="ttr-material-button"><span class="ttr-label">Compose</span></a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-calendar"></i></span>
                        <span class="ttr-label">Clubs</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>

                    </a>
                    <ul>
                        <li>
                            <a href="RegisterclubAdmin" class="ttr-material-button"><span class="ttr-label">Register Club</span></a>
                        </li>
                        <li>
                            <a href="managerClub" class="ttr-material-button"><span class="ttr-label">List Clubs</span></a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-user"></i></span>
                        <span class="ttr-label">User Account</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/listaccount" class="ttr-material-button"><span class="ttr-label">List Account </span></a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/adduser" class="ttr-material-button"><span class="ttr-label">New Account</span></a>
                        </li>

                    </ul>

                </li>
                <li class="ttr-seperate"></li>
            </ul>
            <!-- sidebar menu end -->
        </nav>

    </div>

</div>

