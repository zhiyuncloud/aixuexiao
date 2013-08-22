<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
		<title>爱学校</title>
		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!--basic styles-->
		<link href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link href="<%=request.getContextPath()%>/assets/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/font-awesome.min.css" />
		<!--[if IE 7]>
		  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-fonts.css" />
		<!--ace styles-->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-skins.min.css" />

		<!--[if lte IE 8]>
		  <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ace-ie.min.css" />
		<![endif]-->
	</head>
	<body class="login-layout">
			<br><br>
			<div class="main-container container-fluid">
				<div class="main-content">
					<div class="row-fluid">
						<div class="span12">
							<div class="login-container">
								<div class="row-fluid">
									<div class="center">
										<h1>
											<i class="icon-leaf green"></i>
											<span class="red">&nbsp;爱学校</span>
											<span class="white"></span>
											
										</h1>
										<h4 class="blue">&copy; <a href="http://weibo.com/2098099627" target="_blank">智云同学</a></h4>
									</div>
								</div>
	
								<div class="space-6"></div>
	
								<div class="row-fluid">
									<div class="position-relative">
										<div id="login-box" class="login-box visible widget-box no-border">
											<div class="widget-body">
												<div class="widget-main">
													<c:if test="${message == null }">
													<h4 class="header blue lighter bigger">
														<i class="icon-coffee green"></i>
														Please Enter Your Information
													</h4>
													</c:if>
													<c:if test="${message != null }">
													<h4 class="header red lighter bigger">
														<i class="icon-coffee green"></i>
														&nbsp;${message}
													</h4>
													</c:if>
													<div class="space-6"></div>
	
													<form action="<%=request.getContextPath()%>/login" method="post" id="login" >
														<fieldset>
															<label>
																<span class="block input-icon input-icon-right">
																	<input type="text" class="span12" name="username" <c:if test="${username!=null}">value="${username}"</c:if> placeholder="Username" />
																	<i class="icon-user"></i>
																</span>
															</label>
	
															<label>
																<span class="block input-icon input-icon-right">
																	<input type="password" class="span12" name="password" value="123456" placeholder="Password" />
																	<i class="icon-lock"></i>
																</span>
															</label>
	
															<div class="space"></div>
		
															<div class="clearfix">
																								 
	
																<button onclick="document.getElementById('login').submit();"  class="width-35 pull-right btn btn-small btn-primary">
																	<i class="icon-key"></i>
																	Login
																</button>
															</div>
															
															<div class="space-4"></div>
														</fieldset>
													</form>
													<div class="social-or-login center">
													<span class="bigger-110">爱学校(aixuexiao)</span>
													</div>
													
													<div class="social-login center">
														<img alt="爱学校" src="<%=request.getContextPath()%>/assets/images/getqrcode.jpeg" style="height: 100px;width: 100px;" >
													</div>
													
												</div><!--/widget-main-->
											</div><!--/widget-body-->
										</div><!--/login-box-->
	
									</div><!--/position-relative-->
								</div>
							</div>
						</div><!--/.span-->
					</div><!--/.row-fluid-->
				</div>
			</div><!--/.main-container-->
			<!--basic scripts-->
	
			<!--[if !IE]>-->
	
			<script type="text/javascript">
				window.jQuery || document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
			</script>
			<!--<![endif]-->
	
			<!--[if IE]>
			<script type="text/javascript">
			 window.jQuery || document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
			</script>
			<![endif]-->
	
			<script type="text/javascript">
				if("ontouchend" in document) document.write("<script src='<%=request.getContextPath()%>/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
			</script>
			<script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
	
			<!--page specific plugin scripts-->
	
			<!--ace scripts-->
	
			<script src="<%=request.getContextPath()%>/assets/js/ace-elements.min.js"></script>
			<script src="<%=request.getContextPath()%>/assets/js/ace.min.js"></script>
	
		</body>
</html>