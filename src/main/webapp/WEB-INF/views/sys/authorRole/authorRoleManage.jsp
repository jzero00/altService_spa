<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<body>
	<div class="container-fluid">
		<table class="table">
			<tr>
				<th>
					<div class="row">
						<div class="col-4">권한롤관리 목록</div>
						<div class="col-4">
							<div class="form-group row">
								<label for="menu" class="col-sm-3 col-form-label">권한코드</label>
								<div class="col-sm-9">
								<input type="text" class="form-control" name="keyword" value="${cri.keyword }" readonly>
								</div>
								</div>
							</div>
						<div class="col-4">
							<div class="btn-group">
								<button type="button" class="btn bg-gradient-primary" onclick="searchAuthorRole(); return false;">조회</button>
							</div>
							<div class="btn-group">
								<button type="button" class="btn bg-gradient-primary" onclick="registMember(); return false;">목록</button>
							</div>
							<div class="btn-group">
								<button type="button" class="btn bg-gradient-primary" onclick="registAuthorRole(); return false;">등록</button>
							</div>
						</div>
					</div>
				</th>
			</tr>
		</table>
		<table class="table">
			<thead>
				<tr>
					<th class="text-center" style="width: 10px"><input type="checkbox"></th>
					<th class="text-center">롤 ID</th>
					<th class="text-center">롤명</th>
					<th class="text-center">롤 타입</th>
					<th class="text-center">롤 sort</th>
					<th class="text-center">롤 설명</th>
					<th class="text-center">등록일</th>
					<th class="text-center">등록여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
					<tr id="" onclick="getAuthDtl(this); return false;">
						<td class="text-center"><input type="checkbox" onclick="checkbox(this,event)" class="checkbox"></td>
						<td class="text-center" id="id">${list.role_code }</td>
						<td class="text-center">${list.role_nm }</td>
						<td class="text-center">${list.role_ty }</td>
						<td class="text-center">${list.role_sort }</td>
						<td class="text-center">${list.role_dc }</td>
						<td class="text-center"><fmt:formatDate value="${list.creat_dt }" pattern="yyyy-MM-dd" /></td>
						<td class="text-center">
							<select class="custom-select" name="sexdstn_code">
								<option <c:if test="${list.creat_dt eq null }">selected</c:if>>미등록</option>
								<option <c:if test="${list.creat_dt ne null }">selected</c:if>>등록</option>
							</select>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form name="authManageVO" method="post" id="form">
			<input type='hidden' name="page" value="${pageMaker.cri.page }" />
			<input type="hidden" id="searchType" name="searchType" value="${cri.searchType }">
			<input type="hidden" id="keyword" name="keyword" value="${cri.keyword }">
<!-- 			<input type="hidden" id="id" name="id" value=""> -->
<%-- 			<input type="hidden" id="stts" name="stts" value="${cri.stts }"> --%>
		</form>
		<ul class="pagination m-0 justify-content-center">
			<%@include file="/WEB-INF/views/include/pagination.jsp"%>
		</ul>
	</div>
</body>
<script>
	function getRole(e, event){
		event.preventDefault();
		let author = $(e).closest("tr").children("td").eq(1).text();
		let data = {"author" : author};
		post("/sys/authorRoleList.do", data);
	}

	function searchMember() {
		let searchType = document.querySelector("select[id=searchType]").value;
		let keyword = document.querySelector("input[id=keyword]").value;
		let emplyrSttusCode = document	.querySelector("select[id=emplyrSttusCode]").value;

		document.memberManageVO.querySelector("input[id=searchType]").value = searchType;
		document.memberManageVO.querySelector("input[id=keyword]").value = keyword;
		document.memberManageVO.querySelector("input[id=stts]").value = emplyrSttusCode;

		
		let formData = $("#form").serialize();
		postUrl("/sys/memberManage.do",formData);
	}

	function resetMember() {
		getUrl("'/sys/memberManage.do'");
	}

	function search_list_go(pageNo) {
		document.memberManageVO.querySelector("input[name=page]").value = pageNo;
		let formData = $("#form").serialize();
		postUrl("/sys/memberManage.do",formData);
	}

	function registAuthorRole() {
		if(confirm("권한 등록하시겠습니까?")){
			let checkedEl = document.querySelectorAll("input[class=checkbox]:checked");
			console.log(checkedEl);
			let checkedRole = new Array();
			checkedEl.forEach(function(el, index){
				let tr = el.parentNode.parentNode;
				let role_id = tr.querySelector("td[id=id]").innerHTML;
				checkedRole.push(role_id);
			});
			console.log(checkedRole);			
			let author_code = document.querySelector("input[name=keyword]").value;
			console.log(author_code);
			
			let data = {"author_code" : author_code, "role_id" : checkedRole};
			console.log(data);
			
			
			$.ajax({
				url : "/sys/authorRoleReg.do",
				type : "post",
				data : JSON.stringify(data),
				dataType: "json",
		        contentType: "application/json",
				success : function(res){
					alert("롤 권한 등록되었습니다.");
					//url 변경 부분 수정 author_code도 같이 넘기도록
				}
			})
		}
	}

	function checkbox(e, event) {
		event.stopPropagation();
	}

	function deleteMember() {
		if (confirm("삭제하시겠습니까?")) {
			let checkedBoxes = document.querySelectorAll("input[type=checkbox]:checked");
			let tr = '';
			let deletedIds = new Array();
			console.log(checkedBoxes);
			for (i = 0; i < checkedBoxes.length - 1; i++) {
				tr = checkedBoxes[i].parentElement.parentElement;
				console.log(tr);
				console.log(tr.querySelector("td:nth-child(3)").innerHTML);
				deletedIds.push(tr.querySelector("td:nth-child(3)").innerHTML);
			}
			console.log(deletedIds);

 			$.ajax({
				url : '/sys/memberDelete.do',
				method : 'post',
				data : {
					'id' : deletedIds.toString()
				},
				success : function(data) {
					alert("삭제 완료했습니다.");
					getUrl("/sys/memberManage.do");
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:"	+ request.responseText + "\n" + "error:" + error);
					var err = JSON.parse(request.responseText);
					alert(err.resData[0].errorMsg);
				}
			});
		}
	}

	function downloadExcelMember() {
		location.href = "/download/memberManageExcel.do";
	}

	function registMemberExcel() {
		getUrl("/sys/registMemberManageExcelView.do");
	}
</script>
</html>