var count = 0;

function login(form){
	$.ajax({
		type : 'POST',
		data : $("form").serialize(),
		datatype : 'json',
		url : 'login',
		success : function(result){
			if(result){
				var name = result.name;
				var msg = name + "님 환영합니다.";
				alert(msg);
				location.href="./index";
			}
			else{
				var msg = "로그인 실패!";
				alert(msg);
			}
		},
		error: function(xhr, status, error){
				alert("로그인 로드 실패");
		}
	});
}

$(".save").on('click',function(){
	if($(".check").css('background-color')=='rgb(0, 128, 0)'){
		$(".check").css('background-color','grey');
	}
	else{
		$(".check").css('background-color','green');
	}
});

  function handleCredentialResponse(response) {
  	console.log("Encoded JWT ID token: " + response.credential);
  		$.ajax({
		type : 'GET',
		datatype : 'json',
		url : "./loginGoogle?token="+response.credential,
		success : function(result){
			if(result){
				var name = result.name;
				var msg = name + "님 환영합니다.";
				alert(msg);
				location.href="./index";
			}
			else{
				var msg = "로그인 실패!";
				alert(msg);
			}
		},
		error: function(xhr, status, error){
				alert("로그인 로드 실패");
		}
	});
	//location.href = "./loginGoogle?token="+response.credential;
}
        window.onload = function () {
          google.accounts.id.initialize({
            client_id: "558238847033-fpn6eu5em79557sbghrtp83r3sncb331.apps.googleusercontent.com",
            callback: handleCredentialResponse
          });
          google.accounts.id.renderButton(
            document.getElementById("buttonDiv"),
            { theme: "outline", size: "large" }  // customization attributes
          );
         // google.accounts.id.prompt(); // also display the One Tap dialog
        }