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
						<div class="col-6">롤관리 목록</div>
						<div class="col-3">
							<div class="form-group row">
								<label class="col-sm-4 col-form-label">롤명 : </label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="keyword" value="${cri.keyword }">
								</div>
							</div>
						</div>
						<div class="col-3">
							<div class="btn-group">
								<button type="button" class="btn bg-gradient-primary" onclick="searchRole(); return false;">조회</button>
							</div>
							<div class="btn-group">
								<button type="button" class="btn bg-gradient-primary" onclick="deleteRole(); return false;">삭제</button>
							</div>
							<div class="btn-group">
								<button type="button" class="btn bg-gradient-primary" onclick="registRole(); return false;">등록</button>
							</div>
						</div>
					</div>
				</th>
			</tr>
		</table>
		<table class="table">
			<thead>
				<tr>
					<th class="text-center" style="width: 10px"><input type="checkbox" onclick="checkAll(this);"></th>
					<th class="text-center">롤 ID</th>
					<th class="text-center">롤명</th>
					<th class="text-center">롤 타입</th>
					<th class="text-center">롤 sort</th>
					<th class="text-center">롤 설명</th>
					<th class="text-center">등록일</th>
					<th class="text-center"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
					<tr id="" onclick="getRoleDtl(this); return false;">
						<td class="text-center" onclick="checkbox(this,event)"><input type="checkbox" class="checkbox"></td>
						<td class="text-center" id="id">${list.role_code }</td>
						<td class="text-center">${list.role_nm }</td>
						<td class="text-center">${list.role_ty }</td>
						<td class="text-center">${list.role_pttrn }</td>
						<td class="text-center">${list.role_dc }</td>
						<td class="text-center"><fmt:formatDate value="${list.role_creat_de }" pattern="yyyy-MM-dd" /></td>
						<td class="text-center">
<!-- 							<a href="#" class="text-muted" onclick="getRole(this,event)"> -->
							<a href="#" class="text-muted">
	                        <i class="fas fa-search"></i>
	                        </a>
                        </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<form name="roleManageVO" method="post" id="form">
			<input type='hidden' name="page" value="${pageMaker.cri.page }" />
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
	function getRoleDtl(e) {
		let role_code = $(e).children("td#id").text();
		let data = {"role_code" : role_code};
		postUrl("/sys/roleManageDtl.do",data);
	}
	
	function searchRole() {
		let keyword = document.querySelector("input[id=keyword]").value;
		document.roleManageVO.querySelector("input[id=keyword]").value = keyword;
		
		let formData = $("#form").serialize();
		postUrl("/sys/roleManage.do",formData);
	}

	function search_list_go(pageNo) {
		document.roleManageVO.querySelector("input[name=page]").value = pageNo;
		let formData = $("#form").serialize();
		postUrl("/sys/roleManage.do",formData);
	}

	function registRole() {
		getUrl("/sys/roleManageRegView.do");
	}

	function checkbox(e, event) {
		event.stopPropagation();
	}

	function deleteRole(){
		if(confirm("삭제하시겠습니까?")){
			let checkedBoxes = document.querySelectorAll("input[class=checkbox]:checked");
			let tr = '';
			let deletedIds = new Array();
			console.log(checkedBoxes);
			for (i = 0; i < checkedBoxes.length; i++) {
				tr = checkedBoxes[i].parentElement.parentElement;
				console.log(tr.querySelector("td:nth-child(2)").innerHTML);
				deletedIds.push(tr.querySelector("td:nth-child(2)").innerHTML);
			}
			
			$.ajax({
				url : '/sys/roleManageDel.do',
				method : 'post',
				data : {
					'id' : deletedIds.toString()
				},
				success : function(data) {
					alert("삭제 완료했습니다.");
					getUrl("/sys/roleManage.do");
				},
				error : function(request, status, error) {
					alert("code:" + request.status + "\n" + "message:"	+ request.responseText + "\n" + "error:" + error);
					var err = JSON.parse(request.responseText);
					alert(err.resData[0].errorMsg);
				}
			});
		}
	}
	
	window.addEventListener("DOMContentLoaded",function(){
	 	checkAll();
	})
	function checkAll(e){
		let flag = e.checked;
		let checkboxes = document.querySelectorAll("input[class=checkbox]");
		if(flag){
			checkboxes.forEach(function(e){
				e.checked = true;
			})
		} else{
			checkboxes.forEach(function(e){
				e.checked = false;
			})
		}
	}
	
	
</script>
</html>