# starbucksCloneSpring
스프링을 이용한 스타벅스 클론코딩

개발환경 : spring, mybatis, heroku, clearDB

http://ksh-starbucks-clone.herokuapp.com/

### 구현한 동작 기능

#### 헤더


![image](https://user-images.githubusercontent.com/37679352/181906463-240d4a5d-c962-441b-aa7f-378249819a02.png)


1) 오른쪽 상단 돋보기 클릭시 입력 필드가 나오는 동작 애니매이션(검색 기능은 구현X)
2) 메뉴 별 mouseon 반응형 드롭박스 동작 애니매이션
3) 로고 및 "스타벅스 원두" 메뉴 클릭시 원두 리스트 페이지 이동(나머지 구현 X)
4) 로그인 세션 값에 따른 sign in/sign out 메뉴 변경
5) sign in 클릭시 로그인 화면 전환
6) sign out 클릭시 로그 아웃 후 인덱스(스타벅스 원두 리스트) 화면 전환
7) 해더가 컨테이너 위로 겹쳐서 출력


#### 푸터

![image](https://user-images.githubusercontent.com/37679352/181908760-c2a5d5e9-c599-4a82-b4e6-4d8bcb6756a6.png)



#### 원두 목록

![image](https://user-images.githubusercontent.com/37679352/181906689-a43e4d71-f28a-477e-979a-8e3f41a4cbba.png)

1) 등록되어 있는 커피를 타입에 맞게 분류 후 이름과 함께 리스트 출력
2) 해당 커피 원두 클릭 시 상세 정보 페이지로 화면 전환
3) 커피 원두에 마우스 포인터가 올라갈 시 스케일 업 애니매이션
4) 한줄당 4개씩 출력하도록 그리드 설정
5) 오른쪽 + 버튼 클릭시 "스타벅스 원두 추가"로 화면 전환
- 만약 로그인이 안되어 있다면 로그인 화면으로 이동

#### 상세정보
![image](https://user-images.githubusercontent.com/37679352/181907653-17a6d600-6533-4359-9586-a23c0899d504.png)


1) 원두 상세 정보 출력
2) 페이스북 아이콘 클릭 시 해당 페이지 공유하기로 화면 이동
3) 선택 사항(테이스팅 노트, processing method, enjoy with) 중 값이 있는 것만 출력
4) 오른쪽 상단 연필 아이콘 클릭 시 해당 페이지 수정 페이지로 화면 이동
5) 오른쪽 상단 휴지통 아이콘 클릭 시 해당 페이지 삭제 알림을 띄우고 확인 후 삭제한 뒤 커피 리스트 페이지로 화면 이동
6) 수정, 삭제 버튼 클릭시 로그인이 되어있지 않으면 로그인 페이지로 이동

#### 원두 추가
![image](https://user-images.githubusercontent.com/37679352/181908688-f94ca89d-690f-4b9a-8553-7a0e1910409a.png)

1) 원두를 추가하는 페이지
2) 각 정보를 기입 후 추가 버튼을 클릭하면 원두 추가 후 원두 리스트 페이지 이동
  - 중복되는 한글 이름이 있다면 추가 X


#### 원두 수정

![image](https://user-images.githubusercontent.com/37679352/181907444-2bdaf3de-6440-48b7-9f80-290ac348c655.png)


1) 커피 원두의 정보를 수정할 수 있는 페이지
2) 상제 정보 페이지 디자인을 바탕으로 정보가 있는 곳을 input/textarea로 표현
3) 오른쪽 상단 메뉴로 커피 타입 설정
4) MultipartHttpServletRequest 이용한 파일 업로드 기능
5) 모든 정보를 입력하고 하단의 수정완료를 클릭하면 정보를 갱신 후 해당 커피 상세 페이지로 이동
  - 한글 이름이 기본키이므로 만약 중복되는 이름이라면 갱신하지 않고 상세 페이지로 이동
  - 파일은 데이터베이스가 아닌 서버에 저장 
  - 파일 이름을 coffeebeen_[seq].jpg로 변경하여 img/coffeebean 폴더에 저장해 파일 구별
  
  
#### 로그인

![image](https://user-images.githubusercontent.com/37679352/181907990-ec1941cf-096c-4c39-8f50-202591f35983.png)


1) 로그인 페이지
2) 이이디 저장 버튼 클릭 시 색변환(기능 구현X)
3) 아이디와 로그인을 입력하고 로그인 버튼 입력시 로그인 후 결과를 알림창으로 출력한 뒤 성공하면 커피원두 리스트 페이지로 화면 이동
  - 실패하면 이동X
  - ajax로 구현하였기 때문에 실패하였어도 입력한 정보는 사라지지 않음
4) 구글 로그인 클릭시 아이디가 없다면 회원가입, 있다면 로그인 기능후 결과를 알림창으로 출력한 뒤 성공하면 커피원두 리스트 페이지로 화면 이동
  - 로컬에서 접속 시 people api를 활용해 전화번호, 성별, 이름, 생년월일, 이메일, 닉네임 을 취득 후 회원가입/로그인
  - heroku에서 접속시 people api를 활용하지 않고 id token을 이용해 이메일, 이름을 취득 후 회원가입/로그인
  - 로그인 실패시 알림창으로 결과 출력후 페이지 이동 X
5) 회원가입 클릭시 회원가입 페이지로 이동

#### 회원가입

![image](https://user-images.githubusercontent.com/37679352/181908209-020afdc7-6bb2-4033-a1a5-66575e436fa2.png)


1) 로그인을 위한 회원가입 페이지
2) 기입하는 정보 : 이름, 휴대전화, 성별, 전화번호, 아이디, 비밀번호, 닉네임, 생년월일
3) ajax를 활용한 아이디 조회 기능(아이디 입력 후 입력창에서 마우스를 떼면 작동)
  - 중복시 빨간 색으로 표시 및 해당 아이디 사용 불가
3) 비밀번호 validator기능
  - 영문 포함 12자리가 아니라면 빨간색으로 표시
  - 비밀번호와 비밀번호 확인이 동일하지 않으면 빨간색으로 표시
4) 이름, 휴대전화, 성별, 생년월일, 전화번호 미입력 validator 기능
5) 회원가입 버튼을 클릭 시 회원가입 완료 후 회원가입 완료 페이지 이동
  - 만약 모든 validator를 통과하지 못했다면 회원가입 페이지 이동 
  
 #### 회원가입 완료 페이지
 
  ![image](https://user-images.githubusercontent.com/37679352/181908446-a7f8a03c-7a79-4c26-b68d-890515e105a7.png)
  
  1) 회원가입이 완료되면 출력되는 페이지
  2) 회원가입때 사용되었던 이름을 이용해 완료 문구를 출력
  

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
