<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>
	
	<form name = "loginForm" action="#" method="get">
		<p> 아 이 디 : <input type="text" name="id" id="id">
		<p> 비밀번호 : <input type = "password" name = "passwd" id="passwd">
		<p> <input type="submit" value="전송" id="submit">
	</form>
	
<script type ="text/javascript">
	var submit = document.querySelector("#submit");
	submit.addEventListener("click", checkForm);
	console.log(submit);
	function checkForm()
	{
		var id = document.querySelector("#id").value;
		console.log("id 값 체크" + id);
		var pw = document.querySelector("#passwd").value;
		console.log("password 값 체크" + pw)
		alert("아이디 : " + id + "\n" + "비밀번호 : " + pw);
	}
</script>
</body>


</html>