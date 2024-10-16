<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name = "loginForm" action ="#" method="post">
		<p> 아 이 디 : <input type="text" name ="id" id="id">
		<p> 비밀번호 : <input type="password" name ="pw" id="pw">
		<p><input type="button" value="전송" id="submitt">
	</form>
	
	<script type="text/javascript">
	
		var submit = document.querySelector("#submitt");
		console.log("서브밋 들고옴");
		submit.addEventListener("click", checkLogin)
		console.log("서브밋에 이벤트 적용");
		
		function checkLogin()
		{
			var form = document.loginForm;
			console.log(form + "폼 변수 저장");
			var id = document.querySelector("#id").value;
			var pw = document.querySelector("#pw").value;
			
			if(id =="")
			{
				alert("아이디를 입력해주세요.");
				form.id.focus();
				return false;
			}
			else if(pw =="")
			{
				alert("비밀번호를 입력해주세요.");
				form.id.focus();
				return false;
			}
			form.submit();
		}	
	
	</script>
	
</body>
</html>