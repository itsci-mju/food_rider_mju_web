<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="bean.*, util.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MAIN</title>
</head>
<body>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/loadmains">
		<div>

			<a href="${pageContext.request.contextPath}/loadmains">หน้าหลัก</a> 
			<a href="${pageContext.request.contextPath}/loadpost">ประกาศรับส่ง</a>
			<a href="${pageContext.request.contextPath}/loadaddmeun">เพิ่มเมนู</a>
			<a href="${pageContext.request.contextPath}/loadorder">สั่งอาหาร</a>
			<a href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
			<a href="${pageContext.request.contextPath}/loadregister">ลงทะเบียน</a>

		</div>

	</form>
</body>
</html>