var count = 0;

function login(form){
	$.ajax({
		type : 'POST',
		data : $("form").serialize(),
		datatype : 'json',
		url : 'login',
		beforeSend : function(){
					$("html").css("cursor","wait");
				},
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
			$("html").css("cursor","default");
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
                        url : "./loginApiFail?token="+response.credential,
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
                            $("html").css("cursor","default");
                        },
                        error: function(xhr, status, error){
	                        alert("로그인 실패");
	                        $("html").css("cursor","default");
	                   }
                    })
            }

/*function handleCredentialResponse(response) {
    console.log("Encoded JWT ID token: " + response.credential);
        $.ajax({
            type : 'GET',
            datatype : 'json',
            url : "./loginGoogle?token="+response.credential,
            beforeSend : function(){
				$("html").css("cursor","wait");
			},
            success : function(result){
                if(result.name){
                    var name = result.name;
                    var msg = name + "님 환영합니다.";
                    alert(msg);
                    location.href="./index";
                }
                else{
                    $.ajax({
                        type : 'GET',
                        datatype : 'json',
                        url : "./loginApiFail?token="+response.credential,
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
                            $("html").css("cursor","pointer");
                        },
                        error: function(xhr, status, error){
	                        alert("로그인 실패");
	                        $("html").css("cursor","default");
	                   }
                    })
                }
            },
            error: function(xhr, status, error){
            		alert("people api 실패");
                    $.ajax({
                        type : 'GET',
                        datatype : 'json',
                        url : "./loginApiFail?token="+response.credential,
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
                            $("html").css("cursor","pointer");
                        },
                        error: function(xhr, status, error){
	                        alert("로그인 실패");
	                        $("html").css("cursor","default");
	                   }
                    })
            }
    });
}*/
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