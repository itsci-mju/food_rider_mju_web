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
	level = Integer.parseInt(levelstring);
	System.out.println("submit! LEVE = " + level);
} catch (Exception e) {
	System.out.println("Error! LEVE = " + level);
	level = 0;

}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EDITPOST</title>
<style type="text/css">
/* CSS for navbar */
      .navbar {
        background-color: #8a2be2;
        color: #fff;
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 10px;
      }
        form {
        background-color: white;
        padding: 20px;
        border-radius: 10px;
        width: 50%;
        margin: 0 auto;
      }
      /* CSS for navbar links */
      .navbar a {
        color: #fff;
        text-decoration: none;
        font-size: 16px;
        margin-right: 10px;
      }
      
      /* CSS for registration form container */
      .form-container {
        margin: auto;
        width: 50%;
        background-color: #fff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0px 0px 5px #888;
      }
</style>
</head>
<body>
<!-- navbar -->
	<nav class="navbar">
		<a href="${pageContext.request.contextPath}/">หน้าหลัก</a>
		<%
		if (level != 0) {
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
		<a href="${pageContext.request.contextPath}/loadeditProfile">แก่ไขข้อมูล</a>
		<% 
		if ( level == 1) {
		%>
		<a href="${pageContext.request.contextPath}/loaddelMember">ข้อมูลสมาชิก</a>
		<%} %>
		<a href="${pageContext.request.contextPath}/loadlogout">ออกระบบ</a>
		<%
		} else {
		%>
		<a href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
		<%
		}
		%>
	</nav>
</div>

	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/">
		<h1>ประกาศรับส่งอาหาร</h1>
		<div>
			รูปโปรไฟล์ร้านอาหาร *<input type="file" name="profile_pic" id="imgs"
				accept="image/png/gif,image/jpeg/gif">
		</div>
		<div>
			ชื่อร้านค้า *<input type="text" placeholder="ชื่อร้านค้า *" value=""
				name="restaurant" id="restaurant" />
		</div>
		<div>
			จำนวนคนที่จะส่ง * <select name="amount" id="amount">
				<option value="select">เลือกจำนวนคน</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select>
		</div>
		<div>
			<label for="postdate">วันที่ *</label> <input type="date"
				id="postdate" name="postdate">
		</div>
		<div>
			<label for="posttime">เลือกเวลา:</label> <input type="time"
				id="posttime" name="posttime">
		</div>
		<div>
			ค่าส่ง *<input type="text" placeholder="ค่าส่ง *" value=""
				name="deliveryfee" id="deliveryfee" />
		</div>
		<div>
			หมายเหตุ *
			<textarea name="detail" rows="4" cols="50" placeholder="หมายเหตุ *"
				id="detail"></textarea>

			ที่อยู่ *
			<textarea name="location" rows="4" cols="50" placeholder="ที่อยู่ *"
				id="location"></textarea>
		</div>

		<div>
			<button type="Submit" name="button">ตกลง</button>
			<button type="reset" name="button">ยกเลิก</button>
		</div>
<a href="${pageContext.request.contextPath}/loadmains">หน้าหลัก</a> 
	</form>

</body>
</html>