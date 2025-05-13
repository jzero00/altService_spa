<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diebock</title>
<%-- <%@ include file="/WEB-INF/views/include/head.jsp"%> --%>
<script>
	function registMenu() {
		document.menuManageVO.action = "<c:url value='/sys/menuRegView.do'/>";
		menuManageVO.submit();
	}

	function menuManageDtl(e) {
		document.menuManageVO.action = "<c:url value='/sys/menuModDtl.do'/>";
		document.menuManageVO.querySelector("input[id=menu_no]").value = e.id;
		menuManageVO.submit();
	}
	
	function registMenuExcel(){
		document.menuManageVO.action = "<c:url value='/sys/registMenuExcelView.do'/>";
		menuManageVO.submit();
	}
</script>
</head>
<body>
	<section class="content">
		<div class="container-fluid">
			<table class="table">
				<tr>
					<th>
						<div class="row">
							<div class="col-5"></div>
							<div class="col-3">
								<div class="form-group row">
									<label for="menu" class="col-sm-3 col-form-label">메뉴명 : </label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="menu">
									</div>
								</div>
							</div>
							<div class="col-4">
								<div class="btn-group">
									<button type="button" class="btn bg-gradient-primary">조회</button>
								</div>
								<div class="btn-group">
									<button type="button" class="btn bg-gradient-primary" onclick="registMenuExcel(); return false;">일괄등록</button>
								</div>
								<div class="btn-group">
									<button type="button" class="btn bg-gradient-primary" onclick="registMenu(); return false;">등록</button>
								</div>
								<div class="btn-group">
									<button type="button" class="btn bg-gradient-primary">삭제</button>
								</div>
							</div>
						</div>
					</th>
				</tr>
			</table>
			<table class="table">
				<thead>
					<tr>
						<th  class="text-center" style="width: 10px"><input type="checkbox"></th>
						<th  class="text-center">메뉴 No</th>
						<th  class="text-center">메뉴 한글명</th>
						<th  class="text-center">프로그램 파일 명</th>
						<th  class="text-center">메뉴설명</th>
						<th  class="text-center">상위메뉴No</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="list">
						<tr id="${list.menu_no }" onclick="menuManageDtl(this); return false;">
							<td  class="text-center"><input type="checkbox"></td>
							<td  class="text-center">${list.menu_no }</td>
							<td  class="text-center">${list.menu_nm }</td>
							<td  class="text-center">${list.progrm_file_nm }</td>
							<td  class="text-center">${list.menu_dc }</td>
							<td  class="text-center">${list.upper_menu_no }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form name="menuManageVO" action="<c:url value='/sys/menuRegView.do' />" method="post">
				<input type="hidden" id="menu_no" name="menu_no" value="">
			</form>
			<ul class="pagination m-0 justify-content-center">
				<%@include file="/WEB-INF/views/include/pagination.jsp" %>
			</ul>
		</div>
	</section>
</body>
</html>