<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>班级动态</title>
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
								<i class="icon-comment"></i>
								发布动态
							</small>
						</h1>
					</div> 
					<div class="row-fluid">
						
						<div class="span12">
							<!--PAGE CONTENT BEGINS-->
							<form action="addclassesnews" id="addclassesnews" method="post">
									<label for="form-field-8">为 <b>${cls.name}</b> 发布班级动态（班主任:<b>${cls.headteacher}</b>） </label>
									<input type="hidden" name="classid" value="${cls.id}">
									<textarea class="span12" name="content" id="content" rows="4" placeholder="动态内容"></textarea>
									<br>
									<button class="btn btn-info" id="leavemessage" type="button">
										<i class="icon-inbox"></i>
										发布
									</button>
									<button class="btn btn-info" type="button" onclick="location.href='<%=request.getContextPath() %>/manager/classes'" >
										<i class="icon-arrow-left"></i>
										返回
									</button>
									<br><br>
									<c:if test="${param.notice != null}">
										<div class="alert alert-info">
											<button type="button" class="close" data-dismiss="alert">
												<i class="icon-remove"></i>
											</button>
											<i class="icon-ok"></i>
											<strong>${param.notice}</strong>
										</div>
									</c:if>
							</form>
							 
							<table id="sample-table-1" class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th width="6%">编号</th>
										<th width="20%">留言时间</th>
										<th>内容</th>
										<th width="10%">操作</th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${cnlist}"  var="cn" varStatus="sta" >
									<tr>
										<td>${sta.index+1}</td>
										<td>${cn.inserttime}</td>
										<td>${cn.content}</td>
										<td><button class="btn btn-mini btn-danger" onclick="if(window.confirm('确认删除这条动态？')==true)location.href='<%=request.getContextPath() %>/manager/deleteclassesnews?classesid=${cn.classid}&id=${cn.id}'"><i class="icon-remove"></i>删除动态</button></td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							 
							<!--PAGE CONTENT ENDS-->
					</div><!--/.span-->
				</div><!--/.row-fluid-->
			</div><!--/.page-content-->
		</div><!--/.main-content-->
	</div><!--/.main-container-->

		<%@include file="/WEB-INF/views/common/js.jsp" %>
		<script type="text/javascript">
		$(function() {
			$('#leavemessage').on('click', function() {
				if($.trim($("#content").val())==''){
					alert('请输入留言内容');
					return;
				}else{
					$("#addclassesnews").submit();
				}
			});
			
		});
		</script>
	</body>
</html>