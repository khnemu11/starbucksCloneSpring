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
	<jsp:include page="../common/header.jsp"></jsp:include>
          
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
							<div><h2>${coffee.name_kr}  </h2><h2>${coffee.weight}</h2></div>
							<div><p>${coffee.name_en}    </p><p>${coffee.weight}</p></div>
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
						<p>${coffee.weight}</p>
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
			<div class="context-description-bottom">
				<div class="description-bottom-left">
					<div class="description-bottom-left-top description_detail">
						${coffee.description_detail}
					</div>
					<div class="description-bottom-left-bottom">
						<div class="design-story">
							<img src="resources/img/productInvestigate_img01.jpg"/>
							<h4>디자인 스토리</h4>
							<p>${coffee.design_story}</p>
						</div>
						<div class="tasting-note">
							<img src="resources/img/productInvestigate_img02.jpg"/>
							<h4>커피 테이스팅 노트</h4>
							<p>${coffee.coffee_tasting_note}</p>
						</div>
					</div>
				</div>
				<div class="description-bottom-right">
					<div class="right-block tasting_notes">
						<h4>Tasting Notes</h4>
						<p>${coffee.tasting_notes}</p>
					</div>
					<div class="right-block enjoy_with">
						<h4>Enjoy With</h4>	
						<p>${coffee.enjoy_with}</p>
					</div>
					<div class="right-block processing_method">
						<h4>Processing Method</h4>	
						<p>${coffee.processing_method}</p>
					</div>
				</div>
			</div>
			<div class="context-bottom">
				<div class="context-bottom-common">
					<div class="promotion">
						<div>
							<h4>프로모션 새소식</h4>	
							<ul>
								<li>해당 상품과 관련된 진행 중인 프로모션이 없습니다.</li>
							</ul>
						</div>
						<span class="material-symbols-outlined promotion-add">add_circle</span>
					</div>
					<div class="axis-indicator"></div>
					<div class="order">
						<img src="resources/img/sirenOrder_img_171109.png"/>
						<div class="order-right">
							<h4>사이렌 오더란?</h4>	
							<ul>
								<p>매장에서 줄을 서지 않고 주문하는 쉽고 간편한 O2O (Online to Offline) 서비스로서 앱을 통해 스타벅스 음료, 푸드 및 원두의 결제 및 주문을 완료하면 매장에서 즉시 메뉴를 받을 수 있는 스타벅스만의 신개념 서비스 입니다.</p>
							</ul>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script src="resources/js/menu.js"></script>
 	<script src="resources/js/crud.js"></script>
  	<script src="resources/js/share.js"></script>
  	<script src="resources/js/coffeeDetail.js"></script>
</body>
</html>	