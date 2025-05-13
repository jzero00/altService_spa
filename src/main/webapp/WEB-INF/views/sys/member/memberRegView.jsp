<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Diebock</title>
<script>
	document.addEventListener("DOMContentLoaded", function(){
		let checkDupleButton = document.querySelector("button[id=checkDupleId]");
		checkDupleButton.addEventListener('click',checkDupleId);
		let idInput = document.querySelector("input[name=emplyr_id]");
		idInput.addEventListener('keydown',changeDupleCheck);
		let passwordChkInput = document.querySelector("input[name=password_chk]");
		passwordChkInput.addEventListener('keyup',passwordCheckAlarm);
	});

	function registMember() {
// 		document.memberVO.action = "<c:url value="/sys/memberReg.do"/>";
		let flag = passwordCheck();
		if(flag){
			console.log("통과");
		} else {
			console.log("비밀번호 확인");
		}
		
		let dupleCheckFlag = passDupleId();
		if(!dupleCheckFlag) {
			console.log("ID 중복체크 필요")
			return false;
		}
// 		memberVO.submit();
		let formData = $("#form").serialize();
		$.ajax({
			url : "/sys/memberReg.do",
			data : formData,
			type : "post",
			success : function(res){
				console.log(res);
				alert("사용자 등록 완료되었습니다.");
				getUrl("/sys/memberManage.do");
			}
		})
	}
	
	function passwordCheckAlarm(){
		const passwordInput = document.querySelector("input[name=password]");
		const passwordChkInput = document.querySelector("input[name=password_chk]");
		const resultP = document.querySelector("p[id=pwd_res]");
		
		const passwordInputVal = passwordInput.value;
		const passwordChkInputVal = passwordChkInput.value;
		
		if(passwordInputVal != passwordChkInputVal){
			if (passwordChkInputVal == null || passwordChkInputVal == ''){
				resultP.innerHTML = "비밀번호확인란을 입력해주십시오.";
				resultP.style.color = "red";
				return;
			}
			resultP.innerHTML = "비밀번호가 일치하지 않습니다.";
			resultP.style.color = "red";
		} else if(passwordInputVal == passwordChkInputVal){
			resultP.innerHTML =  "비밀번호가 일치합니다.";
			resultP.style.color = "green";
		}
	}

	function listMenu() {
/* 		document.memberVO.action = "<c:url value="/sys/memberManage.do"/>";
		memberVO.submit(); */
		getUrl("/sys/memberManage.do");
	}
	
	function passwordCheck(){
		let flag = false;
		let password = document.querySelector("input[name=password]").value;
		let password_chk = document.querySelector("input[name=password_chk]").value;
		
		if(password == password_chk) flag = true;
		return flag;
	} 
	
	function checkDupleId(){
		let id = document.querySelector("input[name=emplyr_id]").value;
		$.ajax({
			url : 'checkDupleId.do',
			type : 'post',
			data : {
				"id" : id
			},
			success : function(data) {
				console.log(data);
				if (data.status == "OK" && data.result == "사용가능") {
					alert(data.result);
					document.querySelector("input[name=checkDupleId]").value = 1;
				} else if (data.status == "OK" && data.result == "사용불가"){
					alert(data.result);
				} else {
					alert("내부서버 오류입니다. 관리자에게 문의하십시오");
				}
			}
		})
	}
	
	function changeDupleCheck(){
		let checkDuple = document.querySelector("input[name=checkDupleId]");
		checkDuple.value = "";
	}
	
	function passDupleId(){
		let checkDuple = document.querySelector("input[name=checkDupleId]").value;
		if(checkDuple == 1) {
			return true;
		}
		return false;
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
								<div class="col-9 input-group">
									<input type="text" class="form-control" name="emplyr_id" value="${vo.emplyr_id }">
									<div class="input-group-append">
										<button type="button" class="btn btn-md btn-default" id="checkDupleId">중복확인</button>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="user_nm" class="col-form-label">회원이름</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="user_nm" value="${vo.user_nm }">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="password" class="col-form-label">비밀번호</label>
								</div>
								<div class="col-9">
									<input type="password" class="form-control" name="password">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="password_chk" class="col-form-label">비밀번호확인</label>
								</div>
								<div class="col-9">
									<input type="password" class="form-control" name="password_chk">
									<br>
									<p id="pwd_res"></p>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="password_hint" class="col-form-label">비밀번호힌트</label>
								</div>
								<div class="col-9">
									<select class="custom-select" name="password_hint">
										<option>--선택하세요--</option>
										<option>기억에 남는 추억의 장소는?</option>
										<option>자신의 인생 좌우명은?</option>
										<option>가작 기억에 남는 선생님 성함은?</option>
										<option>타인이 모르는 신체 비밀이 있다면?</option>
										<option>받았던 선물 중 기억에 남는 독특한 선물은?</option>
										<option>유년시절 가작 생각나는 친구 이릉은?</option>
										<option>인상 깊게 읽은 책 이름은?</option>
										<option>읽은 책 중에서 좋아하는 구절이 있다면?</option>
										<option>자신이 두 번째로 존경하는 인물은?</option>
										<option>친구들에게 공개하지 않은 어릴 적 별명이 있다면?</option>
										<option>초등학교 때 기억에 남는 짝꿍 이름은?</option>
										<option>내가 좋아하는 캐릭터는?</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="password_cnsr" class="col-form-label">비밀번호정답</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="password_cnsr" value="${vo.password_cnsr }">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="upper_menu_no" class="col-form-label">성별</label>
								</div>
								<div class="col-9">
									<select class="custom-select" name="sexdstn_code">
										<option>--선택하세요--</option>
										<option value="m">남자</option>
										<option value="f">여자</option>
									</select>
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
											<input type="text" class="form-control" name="area_no" style="width: 100px;"> - <input type="text" class="form-control" name="house_middle_telno" style="width: 100px;"> - <input type="text" class="form-control" name="house_end_telno" style="width: 100px;">
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
									<input type="text" class="form-control" name="email_adres">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="zip" class="col-form-label">우편번호</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="zip" value="${vo.zip }">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="house_adres" class="col-form-label">주소</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="house_adres" value="${vo.house_adres }">
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="detail_adres" class="col-form-label">상세주소</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="detail_adres" value="${vo.detail_adres }">
								</div>
							</div>
						</div>
						<%-- 						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<label for="emplyr_sttus_code" class="col-form-label">회원상태</label>
								</div>
								<div class="col-9">
									<input type="text" class="form-control" name="emplyr_sttus_code" value="${vo.emplyr_sttus_code }">
								</div>
							</div>
						</div> --%>

						<div class="row">
							<div class="col-9"></div>
							<div class="col-3">
								<div>
									<button type="button" class="btn bg-gradient-primary" style="margin-right: 10px;" onclick="registMember(); return false;">등록</button>
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
			<input type="hidden" name="checkDupleId">
		</form>
	</section>
</body>
</html>