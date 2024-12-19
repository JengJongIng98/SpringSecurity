<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/views/customLogin.jsp</h1>
	
	<h2> 사용자 정의 로그인 페이지 </h2>
	
	<fieldset>
		<legend>로그인</legend>
		<form action="/login" method="post">
			아이디 : <input type="text" name="username"><br>
			비밀번호 : <input type="password" name="password"><br>
			
			<!-- CSRF 토큰값 생성, 시큐리티 POST방식 호출시 반드시 필요함 -->
			<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
			
			<input type="submit" value="로그인">
		</form>
	</fieldset>
	
</body>
</html>