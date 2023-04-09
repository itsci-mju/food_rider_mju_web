<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
int err = 0;
try {
	err = (int) session.getAttribute("login");
	session.setMaxInactiveInterval(1);
	session.removeAttribute("login");
} catch (Exception e) {
	err = 0;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>
</head>
<body>

	<%
	if (err == -1) {
	%>
	<div>
		<strong>Error!</strong> เกิดข้อผิดพลาด กรุณาลองใหม่อีกครั้ง.
	</div>
	<%
	}
	%>

	<div>
		<form name="frm" method="post"
			action="${pageContext.request.contextPath}/loginCustomer">
			<div>

			<div>
				<input type="text" name="Email" value="" placeholder="Email">
			</div>
			<div>
				<input type="password" name="password" value=""
					placeholder="password">
			</div>
			<!--  <div>
				<input type="radio" id="rider" name="rider" value="2">
				  <label for="memner">ผู้ใช้ทั่วไป</label><br>   
				<input type="radio"id="rider" name="rider" value="3">   
					<label for="Rider">ไรเดอร์</label><br> 
			</div>
			-->
			<div>
				<button type="Submit" name="button">เข้าสู่ระบบ</button>
				<button type="reset" name="button">ยกเลิก</button>

			</div>
		</form>
		

		<div>
			Don't have an account? <a
				href="${pageContext.request.contextPath}/loadregister">REGISTER</a>
		</div>
</body>
</html>