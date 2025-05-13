<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<script>
function upperMenuNoSearch(){
	let keyword = document.querySelector("input[id=menu]").value;
	$.ajax({
		url : 'upperMenuNoSearch.do',
		type : 'post',
		data : {'keyword' : keyword},
		contentType: "application/json;charset=UTF-8",
		dataType : "text",
		success : function(data){
			console.log(data);
		}
	})
}
</script>
</head>
<body>
	<section class="content">
		<div class="container-fluid">
			<table class="table">
				<tr>
					<th>
						<div class="form-group row">
							<div class="row">
								<div class="col-9">
									<div class="row">
										<div class="col-4">
											<label for="menu" class="col-sm-3 col-form-label">메뉴명 : </label>
										</div>
										<div class="col-8">
											<div class="col-sm-9">
												<input type="text" class="form-control" id="menu">
											</div>
										</div>
									</div>
								</div>
								<div class="col-3">
									<div class="btn-group">
										<button type="button" class="btn bg-gradient-primary" onclick="upperMenuNoSearch(); return false;">조회</button>
									</div>
								</div>
							</div>
						</div>
					</th>
				</tr>
			</table>
			<table class="table">
				<tr>
					<th>프로그램파일명</th>
					<th>프로그램명</th>
				</tr>
				<c:forEach items="${list }" var="list">
				<tr>
					<td>${list.menu_nm }</td>
					<td>${list.menu_dc }</td>
				</tr>
				</c:forEach>
			</table>
			<ul class="pagination m-0 justify-content-center">
				<%@include file="/WEB-INF/views/include/pagination.jsp" %>
			</ul>
		</div>
	</section>
</body>
</html>