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
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/login">

		<h1>Login</h1>

		<div>
			<h1>LoginMamber</h1>
			<div>
				<input type="text" name="Username" value="" placeholder="Username">
			</div>
			<div>
				<input type="password" name="password" value=""
					placeholder="password">
			</div>
			<div>
				<button type="Submit" name="button">ตกลง</button>
				<button type="reset" name="button">ยกเลิก</button>
			</div>
			</td>
			<td>
				<h1>LoginRider</h1>
				<div>
					<input type="text" name="Username" value="" placeholder="Username">
				</div>
				<div>
					<input type="password" name="password" value=""
						placeholder="password">
				</div>
				<div>
					<button type="Submit" name="button">ตกลง</button>
					<button type="reset" name="button">ยกเลิก</button>
				</div>
		</div>


	</form>

	<div>
		Don't have an account? <a
			href="${pageContext.request.contextPath}/loadregister">REGISTER</a>
	</div>
</body>
</html>