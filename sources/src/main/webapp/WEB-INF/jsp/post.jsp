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
	System.out.println("Submit! LEVE = " + level);
} catch (Exception e) {
	System.out.println("Ererr! LEVE = " + level);
	level = 0;

}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADDPOST</title>
<style type="text/css">
/* CSS for body element */
body {
	background-color: #6a5acd;
	font-family: Arial, sans-serif;
}

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
	padding: 60px;
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
/* CSS for form h1 */
h1 {
	text-align: center;
	color: #6a5acd;
	font-weight: bold;
}

/* CSS for form labels */
label {
	display: block;
	margin-bottom: 10px;
	color: #6a5acd;
	font-weight: bold;
	text-align: left;
}
label[type=Submit1] {
	text-align:center;
}
/* CSS for form input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: none;
	border-radius: 3px;
	box-shadow: 0px 0px 5px #ccc;
}

/* CSS for form submit button */
input[type=submit] {
	background-color: #8a2be2;
	color: #fff;
	border: none;
	padding: 10px 20px;
	border-radius: 3px;
	cursor: pointer;
}

/* CSS for address container */
.address-container {
	margin: 20px 0;
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0px 0px 5px #888;
}

/* CSS for address labels */
.address-container label {
	margin-bottom: 5px;
	font-weight: bold;
}

/* CSS for address input fields */
.address-container input[type=text], .address-container input[type=number]
	{
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: none;
	border-radius: 3px;
	box-shadow: 0px 0px 5px #ccc;
}
/* CSS for form input fields */
input[type=text], input[type=password], textarea {
	width: 100%;
	padding: 10px;
	margin-bottom: 10px;
	border: none;
	border-radius: 3px;
	box-shadow: 0px 0px 5px #ccc;
}

input[type="reset"] {
	background-color: #6a5acd;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button[type="submit"] {
	background-color: #6a5acd;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	display: flex;
	align-items: right
}
button[type="reset"] {
	background-color: #6a5acd;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	display: flex;
	align-items: right 
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
		<a href="${pageContext.request.contextPath}/ShowPost">แก่ไขประกาศรับส่ง</a>
		<%
		}
		%>
		<a href="${pageContext.request.contextPath}/loadeditProfile">แก่ไขข้อมูล</a>
		<%
		if (level == 1) {
		%>
		<a href="${pageContext.request.contextPath}/loaddelMember">ข้อมูลสมาชิก</a>
		<%
		}
		%>
		<a href="${pageContext.request.contextPath}/loadlogout">ออกระบบ</a>
		<%
		} else {
		%>
		<a href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
		<%
		}
		%>
	</nav>
	<br>
	<br>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/losdposts">

		<h1>ประกาศรับส่งอาหาร</h1>
		<table>
			<tr>
				<th><label for="imgs">รูปโปรไฟล์ร้านอาหาร :</label> 
				<input type="file" name="profile_pic" id="imgs"
					accept="image/png/gif,image/jpeg/gif">
				</th>
				
				<th>
				<label for="restaurant">ชื่อร้านค้า :</label> 
					<input type="text" placeholder="ชื่อร้านค้า *" value="" name="restaurant"
					id="restaurant" /> 
				 <label for="imgs">รูปเมนูอาหาร :</label> 
				<input type="file" name="meun" id="imgs"
					accept="image/png/gif,image/jpeg/gif">
					
				<label for="postdate">วันที่ :</label> 
					<input type="date" id="postdate" name="postdate"> 
				<label for="posttime">เลือกเวลา :</label> 
					<input type="time" id="posttime"
					name="posttime"> 
				<label for="amount">จำนวนคนที่จะส่ง :</label> 
				<select name="amount" id="amount">
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
				</select> <label for="deliveryfee">ค่าส่ง :</label> 
				<input type="text" placeholder="ค่าส่ง *" value="" name="deliveryfee" id="deliveryfee" />
				</th>
			<tr>
				<th><label for="detail">หมายเหตุ :</label> <textarea
						name="detail" rows="4" cols="50" placeholder="หมายเหตุ *"
						id="detail"></textarea></th>
				<th></th>
				<th><label for="location">ที่อยู่ :</label> <textarea
						name="location" rows="4" cols="50" placeholder="ที่อยู่ *"
						id="location"></textarea></th>
			</tr>
			
				
				
				
			

		</table>
<table type="Submit1" >
<tr>
<th>
<button  type="Submit" name="button" OnClick="return validateForm(frm)">ตกลง</button>
</th>
<th>
<button type="reset" name="button">ยกเลิก</button>
</th>
</tr>
</table>
	
	


	</form>

</body>
</html>