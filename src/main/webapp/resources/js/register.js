function check(form){
	var pwd = form.password.value;
	var pwd2 = form.passwordCheck.value;
	var regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,20}$/;
	var id = form.id.value;	
	$("#errorText").remove();
	$("input").css("border","1px solid #d3d3d3");
	if(!id){
		var errorText = "<span class =\"subText\" id=\"errorText\">id를 입력하세요.</span>"
		$('.id-wrapper').append(errorText);
		$('.id-wrapper input').css("border","1px solid red");
	}
	else if($('id').data('accept')!='true'){
		$(".id-wrapper .subText").remove();
	
		var errorText = "<span class =\"subText\" id=\"errorText\">사용가능한 id를 입력하세요.</span>"
		$('.id-wrapper').append(errorText);
		$('.id-wrapper input').css("border","1px solid red");
	}
	else if(!regex.test(pwd)){
		var errorText = "<span  id=\"errorText\">영문, 숫자 혼합하여 10~20자리 이내로 입력하세요.</span>"
		$('.password-wrapper').append(errorText);
		$('#password').css("border","1px solid red");
		return false;
	}
	else if(pwd != pwd2){
		var errorText = "<span id=\"errorText\">입력하신 비밀번호가 다릅니다.</span>"
		$('.passwordCheck-wrapper').append(errorText);
		$('#password').css("border","1px solid red");
		$('#passwordCheck').css("border","1px solid red");
		return false;
	}
	else{
		form.action = "register";
		form.method = "POST";
		form.submit();
	}
}
$('#id').focusout(function(){
	var param = '?id='+$('#id').val();
	if(param != '?id='){
			$.ajax({
				type : 'GET',
				datatype : 'json',
				url : 'idCheck'+param,
				beforeSend : function(){
					$(".id-wrapper .subText").remove();
					$('#id').data('accept','false');
					$("#id").attr("disabled", true);
					$("#id").css("border","1px solid #d3d3d3");
					$("#id").css("border-top","3px solid #d3d3d3");
					var readyText = "<span class =\"subText\" id=\"readyText\">아이디를 조회중입니다.</span>"
					$('.id-wrapper').append(readyText);
				},
				success : function(result){
					if(result){
						$("#id").removeAttr("disabled");
						$(".id-wrapper #readyText").remove();
						$("#id").css("border","1px solid #d3d3d3");
						
						if(result > 0){
							var errorText = "<span class =\"subText\" id=\"errorText\">사용하실 수 없는 아이디입니다.</span>"
							$('.id-wrapper').append(errorText);
							$('#id').data('accept','false');
							$('#id').css("border","1px solid red");
							$('#errorText').css("color","red");
						}
						else{
							var successText = "<span class =\"subText\" id=\"successText\">사용하실 수 있는 아이디입니다.</span>"
							$('.id-wrapper').append(successText);
							$('#id').data('accept','true');
							$('#id').css("border","1px solid d3d3d3");
							$("#id").css("border-top","3px solid #d3d3d3");
						}
					}
					else{
						var msg = "아이디 확인 실패!";
						alert(msg);
					}				
				},
				error: function(xhr, status, error){
						alert("로그인 로드 실패");
				},
			});
		}
})
