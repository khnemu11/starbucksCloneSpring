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
				var msg = name + "님 어서오세요";
				alert(msg);
			}
			else{
				var msg = "로그인 실패!";
				alert(msg);
			}
			
		},
		error: function(xhr, status, error){
				alert(error);
		}
	});
}