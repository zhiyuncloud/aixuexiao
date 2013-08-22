<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="GBK"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>考试详情</title>
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
								<i class="icon-file"></i>
								考试详情
							</small>
						</h1>
					</div> 
					<div class="row-fluid">
						
						<div class="span12">
							<!--PAGE CONTENT BEGINS-->
							<form action="addexammark" id="addexammark" class="form-horizontal" method="post">
									<input type="hidden" name="classid" value="${exam.classid }" />
									<input type="hidden" name="course" value="${exam.course }" />
									<input type="hidden" name="fullmarks" value="${exam.fullmarks }" />
									<input type="hidden" name="remark" value="${exam.remark }" />
									<label for="form-field-8"> &nbsp;&nbsp;&nbsp; <b>${exam.classid}</b> 班 <b>${exam.course}</b> 考试详情  
									（满分<b>${exam.fullmarks}</b>分） &nbsp;&nbsp;
									（平均分<b>${exam.average}</b>分）&nbsp;&nbsp;
									（最高分<b>${exam.topmark}</b>分）&nbsp;&nbsp;
									（最低分<b>${exam.lowestmark}</b>分）&nbsp;&nbsp;
									（备注：${exam.remark}）
									</label><br>
								 	<table  class="table table-striped table-bordered table-hover">
										<thead>
											<tr>
												<th>学生编号</th>
												<th>学生姓名</th>
												<th>排名</th>
												<th>分数</th>
												<th>备注</th>
											</tr>
										</thead>
										<tbody>
										 	<c:forEach items="${exam.examMarks}"  var="em" >
											<tr>
												<td>${em.studentid}</td>
												<td>${em.studentname}</td>
												<td>${em.rank}</td>
												<td>${em.mark}</td>
												<td>${em.remark}</td>
											</tr>
										 	</c:forEach>
										</tbody>
									</table>
								 		
									<button class="btn btn-info" type="button" onclick="location.href='<%=request.getContextPath() %>/manager/exams'" >
										<i class="icon-arrow-left"></i>
										返回
									</button>
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
				var flag = true;
				$(".mark").each(function(){
					if($(this).val() == ""||isNaN($(this).val())||$(this).val() < 0||$(this).val()> ${exam.fullmarks}) {
						alert('分数填写有误！');
						flag = false;
						return false;
					}
				});
				if(flag)$("#addexammark").submit();
			});
		});
		</script>
	</body>
</html>