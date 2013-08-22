<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="sidebar" id="sidebar">
	<ul class="nav nav-list">
		<li <c:if test="${sidebar=='students'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/manager/students">
				<i class="icon-user"></i>
				<span class="menu-text"> 学生列表 </span>
			</a>
		</li>
		<li <c:if test="${sidebar=='classes'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/manager/classes">
				<i class="icon-list-alt"></i>
				<span class="menu-text"> 班级列表 </span>
			</a>
		</li>
		<li <c:if test="${sidebar=='exams'}">class="active"</c:if> >
			<a href="<%=request.getContextPath()%>/manager/exams">
				<i class="icon-file"></i>
				<span class="menu-text"> 考试列表 </span>
			</a>
		</li>
		<li <c:if test="${sidebar=='messages'||sidebar=='replys'}">class="active"</c:if>>
			<a href="#" class="dropdown-toggle">
				<i class="icon-comment"></i>
				<span class="menu-text"> 微信消息 </span>

				<b class="arrow icon-angle-down"></b>
			</a>
			<ul class="submenu">
				<li <c:if test="${sidebar=='messages'}">class="active"</c:if> >
					<a href="<%=request.getContextPath()%>/manager/messages">
						<i class="icon-double-angle-right"></i>
						接收消息
					</a>
				</li>
				<li <c:if test="${sidebar=='replys'}">class="active"</c:if> >
					<a href="<%=request.getContextPath()%>/manager/replys">
						<i class="icon-double-angle-right"></i>
						回复消息
					</a>
				</li>
			</ul>
		</li>
		 
	</ul><!--/.nav-list-->
	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left"></i>
	</div>
</div>