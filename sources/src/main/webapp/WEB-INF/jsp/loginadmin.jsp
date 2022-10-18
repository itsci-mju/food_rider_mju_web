<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGINADMIN</title>
</head>
<body>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/loginadmin">
		<div>
			<h1>LoginAdmin</h1>
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


	</form>

	<div>
		Don't have an account? <a
			href="${pageContext.request.contextPath}/loadregisteradmin">REGISTER</a>
	</div>
</body>
</html>