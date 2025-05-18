<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diebock</title>
<script>
	function registRole() {
		let formData = $("#form").serialize();
		$.ajax({
			url : "/sys/roleManageReg.do",
			data : formData,
			type : "post",
			success : function(res){
				console.log(res);
				alert("롤 등록 완료되었습니다.");
				getUrl("/sys/roleManage.do");
			}
		});
	}

	function getRoleList() {
		getUrl("/sys/roleManage.do");
	}
</script>
</head>
<body>
	<section class="content">
		<form name="roleVO" action="" method="post" id="form">
			<div class="container-fluid">
				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">롤관리 등록</h3>
					</div>
					<div class="card-body">
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="role_code" class="col-form-label">롤 ID</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="role_code">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="role_nm" class="col-form-label">롤 명</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="role_nm">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="role_pttrn" class="col-form-label">롤 패턴</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="role_pttrn">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="role_dc" class="col-form-label">롤 설명</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="role_dc">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="role_ty" class="col-form-label">롤 타입</label>
								</div>
								<div class="col-9">
									<select class="form-control" name="role_ty">
										<option value="URL">URL</option>
										<option value="method">method</option>
										<option value="pointcut">pointcut</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="role_sort" class="col-form-label">롤 sort</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="role_sort" value="${vo.role_sort }">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-9"></div>
							<div class="col-3">
								<div>
									<button type="button" class="btn bg-gradient-primary" style="margin-right: 10px;" onclick="registRole(); return false;">등록</button>
									<button type="button" class="btn bg-gradient-primary" onclick="getRoleList(); return false;">목록</button>
								</div>
							</div>
						</div>
						<!-- /.row -->

						<!-- /input-group -->
					</div>
					<!-- /.card-body -->
				</div>
			</div>
		</form>
		<%-- 		<form id="searchForm">
			<input type='hidden' name="page" value="${pageMaker.cri.page }" />
			<input type="hidden" id="searchType" name="searchType" value="${cri.searchType }">
			<input type="hidden" id="keyword" name="keyword" value="${cri.keyword }">
			<input type="hidden" id="id" name="id" value="">
			<input type="hidden" id="stts" name="stts" value="${cri.stts }">
		</form> --%>
	</section>
</body>
</html>