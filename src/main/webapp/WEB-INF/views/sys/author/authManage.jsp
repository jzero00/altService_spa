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
						<div class="col-4">권한관리 목록</div>
						<div class="col-8">권한명 검색창</div>
					</div>
				</th>
			</tr>
		</table>
		<table class="table">
			<thead>
				<tr>
					<th class="text-center" style="width: 10px"><input type="checkbox"></th>
					<th class="text-center">권한 ID</th>
					<th class="text-center">권한명</th>
					<th class="text-center">설명</th>
					<th class="text-center">등록일</th>
					<th class="text-center">롤정보</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="list">
					<tr id="" onclick="getAuthDtl(this); return false;">
						<td class="text-center"><input type="checkbox" onclick="checkbox(this,event)"></td>
						<td class="text-center" id="id">${list.author_code }</td>
						<td class="text-center">${list.author_nm }</td>
						<td class="text-center">${list.author_dc }</td>
						<td class="text-center"><fmt:formatDate value="${list.author_creat_de }" pattern="yyyy-MM-dd" /></td>
						<td class="text-center">
							<a href="#" class="text-muted" onclick="getRole(this,event)">
	                        <i class="fas fa-search"></i>
	                        </a>
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
	function getAuthDtl(e) {
/* 		let id = e.querySelector("td[id=id]").innerHTML;
		let data = {"id" : id};
		postUrl("/sys/memberDtl.do",data); */
	}
	
	function getRole(e, event){
		event.preventDefault();
		console.log($(e).closest("tr").children("td").eq(1).text());
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

	function registMember() {
		getUrl("/sys/memberRegView.do");
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