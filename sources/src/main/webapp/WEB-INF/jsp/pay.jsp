<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*, util.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%Member memFeature = null;%>
<%int level = 0;%>
<%try {
	memFeature = (Member) session.getAttribute("Customer");
	String levelstring = memFeature.getMemFeature();
	System.out.println("777444" + levelstring);
	level = Integer.parseInt(levelstring);
	System.out.println("777" + level);
} catch (Exception e) {
	System.out.println("665" + level);
	level = 0;
}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAYFOOD</title>
</head>
<body>
<div>
	<a href="${pageContext.request.contextPath}/">หน้าหลัก</a>
	<%if (level != 0) {%>
	<%if (level == 2 || level == 1) {%>
	<a href="${pageContext.request.contextPath}/loadorder">สั่งอาหาร</a>
	<%}%>
	<%if (level == 3 || level == 1) {%>
	<a href="${pageContext.request.contextPath}/loadpost">ประกาศรับส่ง</a>
	<a href="${pageContext.request.contextPath}/loadaddmeun">เพิ่มเมนู</a>
	<%}%>
	<a href="${pageContext.request.contextPath}/loadeditProfile">แก่ไขข้อมูล</a>
	<a href="${pageContext.request.contextPath}/loadlogout">ออกระบบ</a>
	<%} else {%>
	<a href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
	<%}%>
</div>
<form name="frm" method="post" enctype="multipart/form-data"action="${pageContext.request.contextPath}/loadmains">

</form>
</body>
</html>