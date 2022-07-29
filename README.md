# starbucksCloneSpring
스프링으로 스타벅스를 클론

http://ksh-starbucks-clone.herokuapp.com/

### 업데이트

#### ~07/25

1) 기존 https://github.com/khnemu11/starbucks_clone을 스프링 mvc구조로 변환
2) mybatis 환경설정

#### 07/27

1) 로그인 기능 구현
2) 회원가입 기능 구현
3) 로그인 페이지 디자인 완료
4) 로그인 인가를 위한 인터셉터 구현
5) 로그인한 유저의 정보를 매 요청때 마다 업데이트 하기 위한 인터셉터 구현
6) 회원가입 비밀번호 validator를 ajax로 구현
7) 로그인 시 ajax로 로그인하고 결과를 alert로 보여준 뒤 coffeelist로 보내주는 시나리오 추가

#### 07/28

1) 로그아웃 구현
2) 회원가입 디자인 완료
3) 로그인했을 때와 아닐 때 로그아웃/로그인 메뉴가 바뀌도록 헤더 메뉴 추가
4) id, 생년월일, 전화번호, 이름 validator 추가
5) 아이디 중복 여부를 ajax로 구현
5) 유저빈에 전화번호, 닉네임 추가 및 이에 따른 회원가입 로직 추가
6) 기능에 따른 jsp 및 이미지 폴더 구분

#### 07/29

1) 구글 로그인 api의 id token을 활용한 로그인 및 회원가입 추가
2) people api를 활요한 구글 로그인 이용정보 취득하여 로그인 및 회원가입 기능 추가(로컬에서만 가능)
3) heroku에서 people api 활용을 위한 동적 port 찾기 알고리즘 추가
4) heroku에서 people api 활용시 30초 이내로 요청이 완료되지 않는 오류발생을 처리하기 위해 1)의 에러 처리 추가
5) 커피 원두 상세정보 디자인(중반부 부분) 추가
6) ajax를 활용한 동적 페이지 처리를 위해 해당 jsp에 <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests"> 태그 추가
7) heroku 배포(people api 동작 불가)
