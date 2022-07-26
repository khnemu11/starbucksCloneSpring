<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"  content="text/html;charset=UTF-8">
	<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests ">
        <title>커피 추가 | Starbucks Korea</title>
        <link href="resources/img/logo.png" rel="shortcut icon" type="image/x-icon">
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">        
        <link rel="stylesheet" type="text/css" href="resources/css/coffeeBeanAdd.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<jsp:include page="../common/header.jsp"></jsp:include>
<main class="container-wrapper">
<form action="addcoffee" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
		<div class="container">
		<div class="container-name">
				<h2>스타벅스 원두 추가</h2>
		</div>
			<div class="context-top">
				<div class="coffee-img">
					<img src="resources/img/logo.png"/>
					<input type="file" name="file">
				</div>
				
				<div class="coffee-description">
					<div class="name">
						<div class="name-left">
							<h3>한글 이름</h3><input type="text" name="name_kr" /></h2>
							<h3>영어 이름</h3><input type="text" name="name_en" />
						</div>
						<div class="name-right">
							<select class="form-select type" aria-label="Default select example" name="type">
								  <option selected value="blond_roast">원두 종류</option>
								  <option value="blond_roast">블론드 로스트</option>
								  <option value="medium_roast">미디엄 로스트</option>
								  <option value="dark_roast">다크 로스트</option>
								  <option value="reserve_roast">리저브 원두</option>
							</select>
						</div>
					</div>
					<div class="description-sum">
						<h3>커피 내용 요약</h3>
						<textarea name="description_summary" ></textarea>
					</div>
					
					<div class="weight">
						<h3>무게 (g)</h3>
						<input type="text" name="weight" />
					</div>
					<div class="more">
						<img src="resources/img/icon/more_left.jpg"/>
						<img src="resources/img/icon/more_right.jpg"/>
					</div>
				</div>
			</div>
			<div class="context-description-bottom">
				<div class="description-bottom-left">
					<div class="description-bottom-left-top description_detail">
						<h3>상세 설명</h3>
						<textarea name=description_detail ></textarea>
					</div>
					<div class="description-bottom-left-bottom">
						<div class="design-story">
							<img src="resources/img/productInvestigate_img01.jpg"/>
							<h4>디자인 스토리</h4>
							<textarea  name=design_story ></textarea>
						</div>
						<div class="tasting-note">
							<img src="resources/img/productInvestigate_img02.jpg"/>
							<h4>커피 테이스팅 노트</h4>
							<textarea  name=coffee_tasting_note></textarea>
						</div>
					</div>
				</div>
				<div class="description-bottom-right">
					<div class="right-block tasting_notes">
						<h4>Tasting Notes</h4>
						<textarea name=tasting_notes ></textarea>
					</div>
					<div class="right-block enjoy_with">
						<h4>Enjoy With</h4>	
						<textarea name=enjoy_with ></textarea>
					</div>
					<div class="right-block processing_method">
						<h4>Processing Method</h4>	
						<textarea name=processing_method></textarea>
					</div>
				</div>
			</div>
			<div class="context-bottom">
				<input class="btn btn-primary submit" type="submit" value="추가">
			</div>
	</div>
	</form>
	
</main>


<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>