<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="loginForm" action="#" method="post">
		<p> 아 이 디 : <input type="text" name ="id" id="id">
		<p> 비밀번호 : <input type="password" name ="pw" id="pw">
		<p><input type="button" value="전송" id="submitt">
	</form>
	
	<p><a href="../index.jsp">Index Home</a>
	
	<script type="text/javascript">
	
		var submit = document.querySelector("#submitt");
		console.log("서브밋 들고옴");
		submit.addEventListener("click", checkLogin)
	
		function checkLogin()
		{
			var form = document.loginForm;
			
			if(form.id.value.length < 4 || form.id.value.length > 12) 
			{
				alert("아이디는 4~12자 이내로 입력 가능합니다.");
				form.id.select();
				return;
			}
			
			if(form.pw.value.length < 4) 
			{
				alert("비밀번호는 4자 이상으로 입력해야 합니다.");
				form.pw.select();
				return;
			}
			
			for (i=0; i< form.id.value.length; i++)
			{
				var ch = form.id.value.charAt(i);
				
				if((ch<'a' || ch>'z') && (ch>'A'||ch<'Z') && (ch>'0'|| ch<'9'))
				{
					alert("아이디는 영문 소문자만 입력 가능합니다.");
					form.id.select();
					return;
				}
			}
			
			if (isNaN(form.pw.value))
			{
				alert("비밀번호는 숫자만 입력가능합니다.")
				form.pw.select();
				return;
			}
			
			form.submit();
		}
		
		
		
	</script>
</body>
</html>