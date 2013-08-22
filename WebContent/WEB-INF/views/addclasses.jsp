<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>添加班级</title>
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<%@include file="/WEB-INF/views/common/css.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/common/navbar.jsp" %>
		<div class="main-container container-fluid">
			<a class="menu-toggler" id="menu-toggler" href="#">
				<span class="menu-text"></span>
			</a>
			<%@ include file="/WEB-INF/views/common/sidebar.jsp" %>
			<div class="main-content">
				 
				<div class="page-content">
					<div class="page-header position-relative">
						<h1>
							<small>
								<i class="icon-list-alt"></i>
								添加班级
							</small>
						</h1>
					</div> 
					<div class="row-fluid">
						
						<div class="span12">
							<!--PAGE CONTENT BEGINS-->
							<form action="addclasses" id="addclasses" class="form-horizontal" method="post">
								<div class="control-group">
									<label class="control-label" for="id">班级编号</label>
									<div class="controls">
										<input type="text" name="id" id="id" placeholder=班级编号>*
										<span class="help-inline"><c:if test="${param.notice==null}">例：三年级二班编号为302</c:if>  <font color="red"><c:if test="${param.notice!=null}">${param.notice}</c:if></font></span>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"  for="name">班级名称</label>
									<div class="controls">
										<input type="text" id="name" value="${param.name}" name="name" placeholder="班级名称">*
									</div>
								</div>
								<div class="control-group">
									<label class="control-label"  for="headteacher">班主任姓名</label>
									<div class="controls">
										<input type="text" value="${param.headteacher}" name="headteacher" id="headteacher" placeholder="班主任姓名">*
									</div>
								</div>
									<div class="form-actions">
									<button class="btn btn-info" id="add" type="button">
										<i class="icon-ok bigger-110"></i>
										添加班级
									</button>
									&nbsp; &nbsp; &nbsp;
									<button class="btn btn-info" type="button" onclick="location.href='<%=request.getContextPath() %>/manager/classes'" >
										<i class="icon-arrow-left"></i>
										返回
									</button>
								</div>
							</form>
							<!--PAGE CONTENT ENDS-->
					</div><!--/.span-->
				</div><!--/.row-fluid-->
			</div><!--/.page-content-->
		</div><!--/.main-content-->
	</div><!--/.main-container-->
	<%@include file="/WEB-INF/views/common/js.jsp" %>
	<script type="text/javascript">
		$(function() {
			$('#add').on('click', function() {
				if($.trim($("#id").val())==''||isNaN($('#id').val())){
					alert('请输入正确的班级编号！');
					return;
				}else if($.trim($("#name").val())==''){
					alert('请输入班级名称！');
					return;
				}else if($.trim($("#headteacher").val())==''){
					alert('请输入班主任名称！');
					return;
				}else{
					$("#addclasses").submit();
				}
			});
			
		});
		</script>
	</body>
</html>