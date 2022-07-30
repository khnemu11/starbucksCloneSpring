# starbucksCloneSpring
스프링으로 스타벅스를 클론

http://ksh-starbucks-clone.herokuapp.com/

### 구현한 동작 기능

#### 헤더


![image](https://user-images.githubusercontent.com/37679352/181906463-240d4a5d-c962-441b-aa7f-378249819a02.png)


1) 오른쪽 상단 돋보기 클릭시 입력 필드가 나오는 동작 애니매이션(검색 기능은 구현X)
2) 메뉴 별 드롭박스 동작 애니매이션
3) 로고 및 "스타벅스 원두" 메뉴 클릭시 원두 리스트 페이지 이동(나머지 구현 X)
4) 로그인 세션 값에 따른 sign in/sign out 메뉴 변경
5) sign in 클릭시 로그인 화면 전환
6) sign out 클릭시 로그 아웃 후 인덱스(스타벅스 원두 리스트) 화면 전환

#### 원두 목록

![image](https://user-images.githubusercontent.com/37679352/181906689-a43e4d71-f28a-477e-979a-8e3f41a4cbba.png)

1) 등록되어 있는 커피를 타입에 맞게 분류 후 이름과 함께 리스트 출력
2) 해당 커피 원두 클릭 시 상세 정보 페이지로 화면 전환
3) 커피 원두에 마우스 포인터가 올라갈 시 스케일 업 애니매이션
4) 한줄당 4개씩 출력하도록 그리드 설정
5) 오른쪽 + 버튼 클릭시 "스타벅스 원두 추가"로 화면 전환
5-1) 만약 로그인이 안되어 있다면 로그인 화면으로 이동

#### 상세정보

![image](https://user-images.githubusercontent.com/37679352/181906930-929d9c18-6744-473a-9a8a-3a2f0b57a610.png)


1) 원두 상세 정보 출력
2) 페이스북 아이콘 클릭 시 해당 페이지 공유하기로 화면 이동
3) 선택 사항(테이스팅 노트, processing method, enjoy with) 중 값이 있는 것만 출력
4) 오른쪽 상단 연필 아이콘 클릭 시 해당 페이지 수정 페이지로 화면 이동

#### 원두 수정

![image](https://user-images.githubusercontent.com/37679352/181907444-2bdaf3de-6440-48b7-9f80-290ac348c655.png)


1) 원두 상세 정보 출력
2) 페이스북 아이콘 클릭 시 해당 페이지 공유하기로 화면 이동
3) 선택 사항(테이스팅 노트, processing method, enjoy with) 중 값이 있는 것만 출력
4) 오른쪽 상단 연필 아이콘 클릭 시 해당 페이지 수정 페이지로 화면 이동

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
7) heroku 배포(people api 동작 불가/허용된 구글 아이디만 가능(khnemu11@gmail.com, 21700118@handong.ac.kr))

#### 07/30

1) people api의 heroku 요청 시간 에러로 인한 people api 로직 제거
2) 커피 원두 정보 추가(무게, processing method)
3) 커피 원두정보 추가에 따른 수정/추가/삭제 추가
4) 커피 원두 상세 정보 페이지 디자인 변경
5) 커피 원두 상세 정보 페이지에서 선택 사항(테이스팅 노트, processing method, enjoy with) 값에 따른 동적 div 표현 방식 추가
6) 사진 변경 기능 추가
7) 기타 css 정리 
