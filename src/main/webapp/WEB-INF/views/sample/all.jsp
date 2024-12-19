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
	<h1>/views/sample/all.jsp</h1>
	
	<h2> 모든 사용자가 접근 가능페이지 </h2>
	
	<!-- p673 isAnonymous() -->
	<sec:authorize access="isAnonymous()">
		<!-- 익명의 사용자일때 (로그인 X) -->
		<a href="/customLogin">로그인</a>
	</sec:authorize>
	
	
	<sec:authorize access="isAuthenticated()">
		<!-- 인증된 사용자일때 (로그인O) -->
		<a href="/sample/admin">관리자 페이지로 이동</a>
	</sec:authorize>
	
</body>
</html>