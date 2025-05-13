<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<script>
	let result = '<c:out value="${result}" />';
	let url = '<c:out value="${url}" />';
	alert(result);
	location.href = url;
</script>
</head>
<body>

</body>
</html>