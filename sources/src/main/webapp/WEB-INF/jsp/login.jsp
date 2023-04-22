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
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	background-color: #f2f2f2;
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
}

.container {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.form {
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 30px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

input[type="text"], input[type="password"] {
	padding: 10px;
	margin-bottom: 20px;
	border: none;
	border-radius: 5px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
	width: 100%;
	max-width: 300px;
	font-size: 16px;
	color: #555;
	background-color: #f2f2f2;
}

input[type="submit"] {
	padding: 10px 20px;
	background-color: #4CAF50;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"]:hover {
	background-color: #3e8e41;
}

.link {
	text-align: center;
	margin-top: 10px;
	font-size: 14px;
	color: #999;
}

.link a {
	color: #4CAF50;
}
</style>
</head>
<body>

	<div>
		<form name="frm" method="post"
			action="${pageContext.request.contextPath}/loginCustomer">
			<div class="container">
				<%
				if (err == -1) {
				%>
				<div>
					<strong class="link">Error!</strong> เกิดข้อผิดพลาด กรุณาลองใหม่อีกครั้ง.
				</div>
				<%
				}
				%>
				<form class="form" action="">
					<h2>Login</h2>
					<label for="username">Username:</label> <input type="text"
						id="Email" name="Email" required> <label for="password">Password:</label>
					<input type="password" id="password" name="password" required>
					<input type="submit" value="Login">
					<div class="link">
						Don't have an account? <a
							href="${pageContext.request.contextPath}/loadregister">REGISTER</a>
					</div>
				</form>
			</div>

		</form>
</body>
</html>