<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	   <meta charset="UTF-8">
        <title>${coffee.name_kr} | Starbucks Korea</title>
        <link href="resources/img/logo.png" rel="shortcut icon" type="image/x-icon">
        <link rel="stylesheet" type="text/css" href="resources/css/coffeeBeanDetail.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
        <script  src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
          
	<main class="container-wrapper">
		<div class="container">
			<div class="container-name">
				<h2>스타벅스 원두</h2>
				<span class="title-home">
					<span class="material-symbols-outlined">home</span>&nbsp;
					<span> > COFFEE >
						<c:choose>
							<c:when test="${coffee.type eq 'dark_roast'}">
								다크 로스트
							</c:when>
							<c:when test="${coffee.type eq 'blond_roast'}">
								블론드 로스트
							</c:when>
							<c:when test="${coffee.type eq 'medium_roast'}">
								미디엄 로스트
							</c:when>
							<c:when test="${coffee.type eq 'reserve_roast'}">
								리저브 원두
							</c:when>
						</c:choose>					
					  > ${coffee.name_kr}</span>
				</span>
			</div>
			<div class="context-top">
				<div class="coffee-img">
					<img src="resources/img/coffee_bean/coffee_bean_${coffee.seq}.jpg"/>
				</div>
				<div class="coffee-description">
					<div class="name">
						<div class="name-left">
							<h2>${coffee.name_kr}</h2>
							<p>${coffee.name_en}</p>
						</div>
						<div class="name-right">
							<span class="material-symbols-outlined" id="edit" data-seq="${coffee.seq}">edit</span>
							<span class="material-symbols-outlined" id ="delete" data-seq="${coffee.seq}">delete</span>
						</div>
					</div>
					<div class="description-sum">
						<p>${coffee.description_summary}</p>
					</div>
					<div class="type-wrapper">
							<c:choose>
								<c:when test="${coffee.type eq 'dark_roast'}">
									<div class="type">
									<div class="type-left">
										<img src="resources/img/icon/${coffee.type}.png"/>
									</div>
									<div class=type-right>
										<h3>다크 로스트</h3>
										<p>강렬하고 강인한 맛 Strong & Powerful</p>
									</div>		
									</div>
								</c:when>
								<c:when test="${coffee.type eq 'blond_roast'}">
									<div class="type">
									<div class="type-left">
										<img src="resources/img/icon/${coffee.type}.png"/>
									</div>
									<div class=type-right>
										<h3>블론드 로스트</h3>
										<p>은은하고 부드러운 맛 Subtle & Mellow</p>
									</div>
									</div>
								</c:when>
								<c:when test="${coffee.type eq 'medium_roast'}">
									<div class="type">
									<div class="type-left">
										<img src="resources/img/icon/${coffee.type}.png"/>
									</div>
									<div class=type-right>
										<h3>미디엄 로스트</h3>
										<p>균형잡힌 부드러움 Balance & Mellow</p>
									</div>
									</div>
								</c:when>
							</c:choose>
					</div>
					<div class="weight">
						<p>250g</p>
					</div>
					<div class="more">
						<img src="resources/img/icon/more_left.jpg"/>
						<img src="resources/img/icon/more_right.jpg"/>
					</div>
					
					<div class="icon">
						<%-- <div class="fb-share-button" 
			                data-href="https://ksh-starbucks-clone.herokuapp.com/coffee_bean_detail.jsp?seq=${coffee.seq}" 
			                data-layout="button_count"
			                data-size="small">
                		</div> --%>
                		<img src="resources/img/icon/facebook.png" data-seq="${coffee.seq}"/>
					</div>
				</div>
			</div>
			<div class="context-bottom">
				
			</div>
		</div>
	</main>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="resources/js/menu.js"></script>
 	<script src="resources/js/crud.js"></script>
  	<script src="resources/js/share.js"></script>
</body>
</html>	