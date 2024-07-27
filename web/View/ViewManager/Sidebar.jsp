<%-- 
    Document   : Sidebar
    Created on : Jul 10, 2024, 7:31:53 PM
    Author     : 10t1q
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<div class="ttr-sidebar">
    <div class="ttr-sidebar-wrapper content-scroll">
        <!-- side menu logo start -->
        <div class="ttr-sidebar-logo">
            <a href="#">
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
        <nav class="ttr-sidebar-navi">
            <ul>
                <li>
                    <a href="<c:url value='/ManagerDashBoardServlet' />"" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-home"></i></span>
                        <span class="ttr-label">Dashboard</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-book"></i></span>
                        <span class="ttr-label">Blog</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul>
                        <li>
                            <a href="<c:url value='/UploadServlet?from=Blog_PostList.jsp' />" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Blog Upload</span>
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value='/BlogPostListServlet' />" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Post List</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-book"></i></span>
                        <span class="ttr-label">Event</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                    </a>
                    <ul>
                        <li>
                            <a href="<c:url value='/EventUploadServlet?from=Event_ListManager.jsp' />" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">Event Upload</span>
                            </a>
                        </li>
                        <li>
                            <a href="<c:url value='/EventPostListServlet' />" class="ttr-material-button">
                                <span class="ttr-icon"><i class="ti-book"></i></span>
                                <span class="ttr-label">My Event'CLB List</span>
                            </a>
                        </li>

                    </ul>
                </li>
                <li>
                    <a href="<c:url value='/EventGiveTaskListServlet' />" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-book"></i></span>
                        <span class="ttr-label">Event Task List</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/ListMember" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-comments"></i></span>
                        <span class="ttr-label">List Participate Member</span>
                    </a>
                </li>
                <li>
                    <a href="#" class="ttr-material-button">
                        <span class="ttr-icon"><i class="ti-calendar"></i></span>
                        <span class="ttr-label">Clubs</span>
                        <span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
                        
                    </a>
                    <ul>
                        <li>
                            <a href="StudentClubServlet?id=${param.id}" class="ttr-material-button"><span class="ttr-label">Student in Club</span></a>
                        </li>
                        <li>
                            <a href="ClubStudentRegistrationAdminServlet?id=${param.id}" class="ttr-material-button"><span class="ttr-label">Club Student Registration</span></a>
                        </li>
                        <li>
                            <a href="EventClubStudentRegistrationServlet?id=${param.id}">Student Recruitment Event</a>
                        </li>
                    </ul>
                </li>



                <li class="ttr-seperate"></li>
            </ul>
            <!-- sidebar menu end -->
        </nav>
        <!-- sidebar menu end -->
    </div>
</div>