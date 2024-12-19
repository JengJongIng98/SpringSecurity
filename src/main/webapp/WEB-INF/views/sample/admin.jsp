<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/views/sample/admin.jsp</h1>
	
	<h2> 특정사용자(로그인한 사용자 & 관리자)만 접근가능 </h2>
	
	<sec:authentication property="principal"/>
	
	<!-- p673 isAnonymous() -->
	<sec:authorize access="isAnonymous()">
		<!-- 익명의 사용자일때 (로그인 X) -->
		<a href="/customLogin">로그인</a>
	</sec:authorize>
	
	
	
</body>
</html>