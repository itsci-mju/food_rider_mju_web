<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*, util.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%Member mr = (Member)session.getAttribute("stCustomer");
System.out.println("32165" + mr);
%>
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
	System.out.println("777444" + levelstring);
	level = Integer.parseInt(levelstring);
	System.out.println("777" + level);
} catch (Exception e) {
	System.out.println("665" + level);
	level = 0;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EdilProfile</title>
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
<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/loadeditProfile">
		
<h1>แก่ไขข้อมูส่วนตัว</h1>
		<div>
			<div>
				<img src="img/" alt="" value="<%=mr.getMemImageProfile()%>"/>
				รูปโปรไฟล์ *<input type="file" name="profile_pic" id="imgs"
					accept="image/png/gif,image/jpeg/gif">
			</div>

			<div>
				ชื่อ *<input type="text" placeholder="ชื่อ *" value="<%=mr.getMemName()%>" 
				name="name" id="name" />
			</div>

			<div>
				Email *<input type="text" placeholder="Email *" value="<%=mr.getMemEmail()%>"
					name="email" id="email" />
			</div>

			<div>
				ที่อยู่ *
				<textarea name="adds" rows="4" cols="50" placeholder="ที่อยู่ *" value="<%=mr.getMemAddress()%>"
					id="adds"></textarea>
			</div>

			<div>
				เบอร์โทรศัพท์ *<input type="text" minlength="10" maxlength="10"
					name="phone" placeholder="เบอร์โทรศัพท์ *" value="" id="phone" value="<%=mr.getMemPhone()%>"/>
			</div>

			<div>
				
				<input type="radio" id="rider" name="rider" value="2">
				  <label for="memner">ผู้ใช้ทั่วไป</label><br>   
				<input type="radio"id="rider" name="rider" value="3">   
					<label for="Rider">ไรเดอร์</label><br> 
			</div>

			<div>
				Password *<input type="password" name="password" value="<%=mr.getPassword()%>"
					id="password" placeholder="password">
			</div>
		</div>
		<div>
			<input type="submit" value="Register"
				OnClick="return validateForm(frm)" />
		</div>
		
	</form>
<div>
		<a href="${pageContext.request.contextPath}/loadlogin">LOGIN</a>
	</div>
</body>
</html>