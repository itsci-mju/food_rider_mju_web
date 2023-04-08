<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*, util.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Member memFeature = null;
%>
<%
int level = 0;
%>
<%
try {
	memFeature = (Member) session.getAttribute("Customer");
	String levelstring = memFeature.getMemFeature();
	level = Integer.parseInt(levelstring);
} catch (Exception e) {
	level = 0;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Profile</title>
</head>
<body>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/edilprofile">
		<div>
			<%
			if (level != 0) {
			%>

			<%
			System.out.println("555" + level);
			%>
			<%
			if (level == 2 || level == 1) {
			%>
			<a href="${pageContext.request.contextPath}/loadorder">สั่งอาหาร</a>

			<%
			}
			%>

			<%
			if (level == 3 || level == 1) {
			%>
			<a href="${pageContext.request.contextPath}/loadpost">ประกาศรับส่ง</a>
			<a href="${pageContext.request.contextPath}/loadaddmeun">เพิ่มเมนู</a>

			<%
			}
			%>
			<a href="${pageContext.request.contextPath}/loadlogout">ออกระบบ</a>
			<%
			} else {
			%>
			<a href="${pageContext.request.contextPath}/">หน้าหลัก</a> <a
				href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
			<%
			}
			%>









		</div>

	</form>
</body>
</html>