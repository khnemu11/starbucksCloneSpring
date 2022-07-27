<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"  content="text/html;charset=UTF-8">
	<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests ">
        <title>Starbucks</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">        
        <link rel="stylesheet" type="text/css" href="resources/css/login.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
       
</head>
<body>
<jsp:include page="./header.jsp"></jsp:include>
<main class="container-wrapper">
	<div class="container">
		<h2>로그인</h2>
		<div class="login-wrapper">
			<div class="login-top"> 
				<h3 class="welcome">Welcome!</h3><h3>스타벅스 코리아에 오신 것을 환영합니다</h3>
			</div>
			<form action="login" method="post" accept-charset="UTF-8" onsubmit="return false;">
			<div class="login-mid"> 
				<input type="text" name="id"/>
				<input type="password" name="password"/>
				<div class="save">
					<span class="material-symbols-outlined check">check</span>
					<h3>아이디 저장</h3>
				</div>
				<button class="submit" onclick="login(this.form)">로그인</button>
				<p>* 타 사이트와 비밀번호를 동일하게 사용할 경우 도용의 위험이 있으므로, 정기적인 비밀번호 변경을 해주시길 바랍니다.</p>
				<p>* 스타벅스 코리아의 공식 홈페이지는 Internet Explorer 9.0 이상, Chrome, Firefox, Safari 브라우저에 최적화 되어있습니다</p>
			</div>
			</form>
			<div class="login-bottom">
				<button onclick="location.href='#';">회원가입</button>
				<button onclick="location.href='#';">아이디 찾기</button>
				<button onclick="location.href='#';">비밀번호 찾기</button>
			</div>
		</div>
	</div>
</main>


<jsp:include page="footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="resources/js/login.js"></script>
</body>
</html>