function check(form){
	var pwd = form.password.value;
	var pwd2 = form.passwordCheck.value;
	var regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{10,20}$/;
	
	$("#errorText").remove();
	$("input").css("border","1px solid black");
	if(!regex.test(pwd)){
		var errorText = "<span id=\"errorText\">영문, 숫자 혼합하여 10~20자리 이내로 입력하세요.</span>"
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