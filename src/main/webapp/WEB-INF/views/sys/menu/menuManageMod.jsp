<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diebock</title>
<script>
function modifyMenu(){
	document.menuManageVO.action = "<c:url value="/sys/menuMod.do"/>";
	menuManageVO.submit();
}

function open_upper_menu_no(){
	window.open("/sys/upperMenuNoSearchView.do","popup","width=500, height=700, history=no, resizable=no, status=no, scrollbars=yes, menubar=no");
}

function listMenu(){
	document.menuManageVO.action = "<c:url value="/sys/menuManage.do"/>";
	menuManageVO.submit();
}
</script>
</head>
<body>
	<section class="content">
		<form name="menuManageVO" action="" method="post">
			<div class="container-fluid">
				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">메뉴정보등록</h3>
					</div>
					<div class="card-body">
						<div class="form-group">
							<div class="row">
								<div class="col-2">
									<label for="menu_no" class="col-form-label">메뉴No *</label>
								</div>
								<div class="col-4">
									<input type="text" class="form-control" name="menu_no" value="${vo.menu_no }">
								</div>
								<div class="col-2">
									<label for="menu_ordr" class="col-form-label">메뉴순서 *</label>
								</div>
								<div class="col-4">
									<input type="text" class="form-control" name="menu_ordr" value="${vo.menu_ordr }">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-2">
									<label for="menu_nm" class="col-form-label">메뉴명 *</label>
								</div>
								<div class="col-4">
									<input type="text" class="form-control" name="menu_nm" value="${vo.menu_nm }">
								</div>
								<div class="col-2">
									<label for="upper_menu_no" class="col-form-label">상위메뉴No *</label>
								</div>
								<div class="col-4 input-group">
									<input type="text" class="form-control" name="upper_menu_no" value="${vo.upper_menu_no }">
									<div class="input-group-append">
										<button type="submit" class="btn btn-md btn-default" onclick="open_upper_menu_no()">
											<i class="fa fa-search"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-2">
									<label for="progrm_file_nm" class="col-form-label">파일명 *</label>
								</div>
								<div class="col-10">
									<input type="text" class="form-control" name="progrm_file_nm">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-2">
									<label for="relate_image_nm" class="col-form-label">관련이미지명 *</label>
								</div>
								<div class="col-4">
									<input type="text" class="form-control" name="relate_image_nm" value="${vo.relate_image_nm }">
								</div>
								<div class="col-2">
									<label for="relate_image_path" class="col-form-label">관련이미지경로 *</label>
								</div>
								<div class="col-4">
									<input type="text" class="form-control" name="relate_image_path" value="${vo.relate_image_path }">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-2">
									<label for="menu_dc" class="col-form-label">메뉴설명 *</label>
								</div>
								<div class="col-10">
									<textarea class="form-control" rows="3" name="menu_dc">${vo.menu_dc }</textarea>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-9"></div>
							<div class="col-3">
								<div>
									<button type="button" class="btn bg-gradient-primary" style="margin-right: 10px;" onclick="modifyMenu(); return false;">수정</button>
									<button type="button" class="btn bg-gradient-primary" onclick="listMenu(); return false;">목록</button>
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
	</section>
</body>
</html>