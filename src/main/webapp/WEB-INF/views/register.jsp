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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">        
        <link rel="stylesheet" type="text/css" href="resources/css/login.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
       
</head>
<body>
<jsp:include page="./header.jsp"></jsp:include>

<main class="container-wrapper">
	<div class="container">
		<h2>회원가입</h2>
		<form method="post" accept-charset="UTF-8" onsubmit="return false;"> 
			<div class="login-wrapper">
				<input type="text" name="id" id="id" placeholder="아이디"/>
				<div class="password-wrapper">
					<input type="password" name="password" id="password" placeholder="비밀번호"/>
				</div>
				<div class="passwordCheck-wrapper">
					<input type="password" name="passwordCheck" id="passwordCheck" placeholder="비밀번호 확인"/>
				</div>
					<input type="text" name="name" placeholder="이름"/>
				<select class="form-select" name="year">
				  <option selected value="1">생년</option>
				  <c:forEach var="i" begin="1900" end="2022">
				  	<option value="${i}"> ${i}</option>
				  </c:forEach>
				</select>
				<select class="form-select" name="month">
				  <option selected value="1">월</option>
				 <c:forEach var="i" begin="1" end="12">
				  	<option value="${i}"> ${i}</option>
				  </c:forEach>
				</select>
				<select class="form-select" name="day">
				  <option selected  value="1">일</option>
				  <c:forEach var="i" begin="1" end="31">
				  	<option value="${i}"> ${i}</option>
				  </c:forEach>
				</select>
				
				<button onclick="check(this.form)">회원가입</button>
			</div>
		</form>
	</div>
</main>


<jsp:include page="footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script type="text/javascript">
$(document).ready(function(){
	var error = "${error}";
	var msg = "error is "+error;
	if(error){
		alert(msg);
	}	
}); 
</script>
<script src="resources/js/register.js"></script>
</body>
</html>