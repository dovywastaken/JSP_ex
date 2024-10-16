<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Validation</title>
</head>
<body>
	<h3>회 원 가 입</h3>
	<form action="#" name="Member" method="post">
		<p> 아 이 디 : <input type="text" name="info" id="info">
		<p> 비밀번호 : <input type="password" name="pw" id="pw">
		<p> 이   름 : <input type="text" name="name" id="name">
		<p> 연 락 처: 
		<select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="019">019</option>
		</select>
		-
		<input type="text" maxlength="4" size="4" name="phone2" id="phone2">
		- 
		<input type="text" maxlength="4" size="4" name="phone3" id="phone3">
		<p> 이 메 일 : <input type="text" name="email" id="email">
		<p> <input type="button" value="가입하기" id="submitt">
	</form>
	
	<a href="./index.jsp">Index Home</a>
	
	<script type="text/javascript">
		var submit = document.querySelector("#submitt");
		submit.addEventListener("click", checkMember);
		
		function check()
		{
			alert("버튼 매핑 완료");
		}
	
		function checkMember()
		{
			
			var regExpId = /^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣]/;

			var regExpName = /^[가-힣]*$/;
			var regExpPasswd = /^[0-9]*$/;
			var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/;
			var regExpEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;


			
			var form = document.Member;
			
			var info = form.info.value;
			var name = form.name.value;
			var pw = form.pw.value;
			var phone = form.phone1.value + "-" + form.phone2.value + "-" + form.phone3.value;
			var email = form.email.value;
			
			
			if(!regExpId.test(info))
			{
				alert("아이디는 문자로 시작합니다");
				form.info.select();
				return;
			}
			
			
			if(!regExpName.test(name))
			{
				alert("이름은 한글만 입력하세요");
				return;
			}
			
			if(!regExpPasswd.test(pw))
			{
				alert("비밀번호는 숫자만 입력하세요");
				return;
			}
			
			if(!regExpPhone.test(phone))
			{
				alert("연락처 입력을 확인해주세요");
				return;
			}
			
			if(!regExpEmail.test(email))
			{
				alert("이메일 입력을 확인해주세요");
				return;
			}
			
			form.submit();
		}
	
	</script>
	
</body>
</html>