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
				<a href="#"><img alt="" src="${pageContext.request.contextPath}/assets_admin/images/logo.png" width="122" height="27"></a>
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
						<a href="<c:url value='/UploadServlet' />" class="ttr-material-button">
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
						<a href="<c:url value='/EventUploadServlet' />" class="ttr-material-button">
							<span class="ttr-icon"><i class="ti-book"></i></span>
		                	<span class="ttr-label">Event Upload</span>
		                </a>
		            </li>
<!--					<li>
						<a href="<c:url value='/EventUploadServlet' />" class="ttr-material-button">
							<span class="ttr-icon"><i class="ti-book"></i></span>
		                	<span class="ttr-label">Event Upload</span>
		                </a>
		            </li>-->
		                </ul>
		            </li>
					<li>
						<a href="bookmark.html" class="ttr-material-button">
							<span class="ttr-icon"><i class="ti-bookmark-alt"></i></span>
		                	<span class="ttr-label">Bookmarks</span>
		                </a>
		            </li>
					<li>
						<a href="review.html" class="ttr-material-button">
							<span class="ttr-icon"><i class="ti-comments"></i></span>
		                	<span class="ttr-label">Review</span>
		                </a>
		            </li>
					<li>
						<a href="add-listing.html" class="ttr-material-button">
							<span class="ttr-icon"><i class="ti-layout-accordion-list"></i></span>
		                	<span class="ttr-label">Add listing</span>
		                </a>
		            </li>
					<li>
						<a href="#" class="ttr-material-button">
							<span class="ttr-icon"><i class="ti-book"></i></span>
		                	<span class="ttr-label">Event</span>
		                	<span class="ttr-arrow-icon"><i class="fa fa-angle-down"></i></span>
		                </a>
		                <ul>
		                	<li>
						<a href="<c:url value='/EventUploadServlet' />" class="ttr-material-button">
							<span class="ttr-icon"><i class="ti-book"></i></span>
		                	<span class="ttr-label">Event Upload</span>
		                </a>
		            </li>
<!--					<li>
						<a href="<c:url value='/EventUploadServlet' />" class="ttr-material-button">
							<span class="ttr-icon"><i class="ti-book"></i></span>
		                	<span class="ttr-label">Event Upload</span>
		                </a>
		            </li>-->
		                </ul>
		            </li>
		            <li class="ttr-seperate"></li>
				</ul>
				<!-- sidebar menu end -->
			</nav>
			<!-- sidebar menu end -->
		</div>
	</div>