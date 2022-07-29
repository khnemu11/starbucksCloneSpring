<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"  content="text/html;charset=UTF-8">
	<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests ">
    <title>Starbucks Korea</title>
    <link href="resources/img/logo.png" rel="shortcut icon" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">        
    <link rel="stylesheet" type="text/css" href="resources/css/register.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>

<main class="container-wrapper">
	<div class="container">
		<h2>회원가입</h2>
		<form method="post" accept-charset="UTF-8" onsubmit="return false;"> 
			<div class="reigister-wrapper">
				
				<div class="register-top">
					<div class="w-100 info">
						<img src="resources/img/icon_find_sally.png"/>
						<p>화원정보를 입력해주세요</p>
					</div>
					<div class="id-wrapper w-100">
						<input type="text" name="id" id="id" placeholder="아이디"/>
					</div>
					<div class="password-wrapper w-100">
						<input type="password" name="password" id="password" placeholder="비밀번호"/>
					</div>
					<div class="passwordCheck-wrapper w-100">
						<input type="password" name="passwordCheck" id="passwordCheck" placeholder="비밀번호 확인"/>
					</div>
				</div>
				<div class="register-bottom">
					<div class="name-wrapper bottom-div">
						<div class="w-88">
							<h3>이름 (필수)</h3>
							<div class="inline">
								<input type="text" name="name" placeholder="이름"/>
								<div class="btn-group" role="group" aria-label="Basic radio toggle button group">
								  <input type="radio" class="btn-check" name="sex" id="btnradio1" autocomplete="off" checked>
								  <label class="btn" for="btnradio1">남</label>
								
								  <input type="radio" class="btn-check" name="sex" id="btnradio2" autocomplete="off">
								  <label class="btn" for="btnradio2">여</label>
								</div>
							</div>
						</div>
					</div>
					<div class="ymd-wrapper bottom-div">
						<div class="w-88 ymd">
							<h3>생년월일 (필수)</h3>
							<div class="inline" id="ymd">
								<select class="form-select" name="year">
							  <option selected value="0">생년</option>
							  <c:forEach var="i" begin="1900" end="2022">
							  	<option value="${i}"> ${i}</option>
							  </c:forEach>
							</select>
							<select class="form-select" name="month">
							  <option selected value="0">월</option>
							 <c:forEach var="i" begin="1" end="12">
							  	<option value="${i}"> ${i}</option>
							  </c:forEach>
							</select>
							<select class="form-select" name="day">
							  <option selected  value="0">일</option>
							  <c:forEach var="i" begin="1" end="31">
							  	<option value="${i}"> ${i}</option>
							  </c:forEach>
							</select>
							<select class="form-select sl" name="sl">
							 	 <option selected value="s">양</option>
							 	 <option value="l">음</option>
							</select>
							</div>
						</div>
						<div class="w-88 ymd-subtext">
							<p>회원가입 완료 후 스타벅스 카드를 등록하시면 생일 무료음료 쿠폰이 발행됩니다.</p>
						</div>			
					</div>
					<div class="phone-wrapper bottom-div">
						<div class="w-88">
							<h3>휴대폰 번호 (필수)</h3>
							<input type="tel" id="phone" name="phone" pattern="010-[0-9]{4}-[0-9]{4}" title="010-XXXX-XXX">
						</div>
					</div>
					<div class="bottom-div nickname-img">
						
					</div>
					<div class="bottom-div">
						<div class="nickname-wrapper w-88">
							<div class="inline">
								<h3>닉네임 (선택)</h3>
								<span class="material-symbols-outlined error-icon">error</span>
							</div>
							<input type="text" id="nickname" name="nickname" placeholder="한글 6자리 이내로 입력하세요."/>
						</div>
					</div>
				</div>
				<div class="w-95">
					<p>* 선택항목은 입력하지 않거나 동의하지 않아도 회원 가입이 가능합니다.</p>
				</div>
				<button class="submit" onclick="check(this.form)">회원가입</button>
			</div>
		</form>
	</div>
</main>


<jsp:include page="../common/footer.jsp"></jsp:include>
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