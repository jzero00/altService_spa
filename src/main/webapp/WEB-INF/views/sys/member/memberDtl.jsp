<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diebock</title>
<script>
	function modifyMember(){
/* 		document.memberVO.action = "<c:url value="/sys/memberModView.do"/>";
		memberVO.submit(); */
		let formData = $("#form").serialize();
		postUrl("/sys/memberModView.do",formData);
	}
	
	function listMenu(){
		getUrl("/sys/memberManage.do");
// 		document.memberVO.action = "<c:url value="/sys/memberManage.do"/>";
// 		memberVO.submit();
	}
</script>
</head>
<body>
	<section class="content">
		<form name="memberVO" action="" method="post" id="form">
			<div class="container-fluid">
				<div class="card card-info">
					<div class="card-header">
						<h3 class="card-title">회원관리 등록</h3>
					</div>
					<div class="card-body">
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="emplyr_id" class="col-form-label">회원ID</label>
								</div>
								<div class="col-9">${vo.emplyr_id }</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="user_nm" class="col-form-label">회원이름</label>
								</div>
								<div class="col-9">${vo.user_nm }</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="upper_menu_no" class="col-form-label">성별</label>
								</div>
								<div class="col-9">
									<c:if test="${vo.sexdstn_code eq 'm'}">
									남자
									</c:if>
									<c:if test="${vo.sexdstn_code eq 'f'}">
									여자
									</c:if>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="" class="col-form-label">전화번호</label>
								</div>
								<div class="col-9">
									<div class="col-12">
										<div class="form-group row">
<%-- 											${vo.area_no } - ${vo.house_middle_telno } - ${vo.house_end_telno } --%>
											${vo.moblphon_no }
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="email_adres" class="col-form-label">이메일주소</label>
								</div>
								<div class="col-9">
									${vo.email_adres }
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="zip" class="col-form-label">우편번호</label>
								</div>
								<div class="col-9">
									${vo.zip }
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="house_adres" class="col-form-label">주소</label>
								</div>
								<div class="col-9">
									${vo.house_adres }
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="detail_adres" class="col-form-label">상세주소</label>
								</div>
								<div class="col-9">
									${vo.detail_adres }
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="emplyr_sttus_code" class="col-form-label">회원상태</label>
								</div>
								<div class="col-9">
									<c:if test="${vo.lock_cnt >= 5 }">
										잠김
									</c:if>
									<c:if test="${vo.lock_cnt < 5 }">
										<c:if test="${vo.emplyr_sttus_code eq 'a' }">승인</c:if>
										<c:if test="${vo.emplyr_sttus_code eq 'n' }">미승인</c:if>
									</c:if>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-9"></div>
							<div class="col-3">
								<div>
									<button type="button" class="btn bg-gradient-primary" style="margin-right: 10px;" onclick="modifyMember(); return false;">수정</button>
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
			<input type="hidden" name="emplyr_id" value="${vo.emplyr_id}">
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