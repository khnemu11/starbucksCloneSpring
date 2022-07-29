<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"  content="text/html;charset=UTF-8">
	<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests ">
        <title>Starbucks</title>
        <link href="resources/img/logo.png" rel="shortcut icon" type="image/x-icon">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">        
        <link rel="stylesheet" type="text/css" href="resources/css/registerSuccess.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
       
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<main class="container-wrapper">
	<div class="container">
		<div class="w-100">
			<h2>${user.name} 고객님! </h2>
			<h2>스타벅스 코리아</h2>
			<h2>회원가입이 완료되었습니다.</h2>
			
			<img src="resources/img/congratulation.png">
		</div>
		<button class="submit" onclick="location.href='loginForm'">돌아가기</button>
	</div>
</main>


<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>