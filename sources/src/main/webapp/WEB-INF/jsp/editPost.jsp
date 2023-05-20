<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*, util.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
Member memFeature = null;
Post postid = null;
postid = (Post) session.getAttribute("Epost");
List<Post> lp = (List<Post>) session.getAttribute("sp");
%>
<%
Post p = null;
List<Post> list = (List<Post>) session.getAttribute("st");
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
	width: 82%;
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

.file {
	width: 100%;
	height: 100%;
	position: absolute;
	opacity: 0;
	cursor: pointer;
}

output {
	width: 100%;
	min-height: 150px;
	display: flex;
	justify-content: flex-start;
	flex-wrap: wrap;
	gap: 15px;
	position: relative;
	border-radius: 5px;
}

output .image {
	height: 150px;
	border-radius: 5px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.15);
	overflow: hidden;
	position: relative;
}

output .image img {
	height: 100%;
	width: 100%;
}

output .image span {
	position: absolute;
	top: -4px;
	right: 4px;
	cursor: pointer;
	font-size: 22px;
	color: white;
}

output .image span:hover {
	opacity: 0.8;
}

output .span--hidden {
	visibility: hidden;
}

.image-preview {
	display: block;
	width: 200px;
	height: 200px;
	border-radius: 50%;
	border: 5px solid white;
	margin: 0 auto;
	background-size: cover;
	background-position: center;
}
</style>
</head>
<body>
	<!-- navbar -->
	<nav class="navbar">
		<div style="text-align: left;">
			<a href="${pageContext.request.contextPath}/">หน้าหลัก</a>
			<%
			if (level != 0) {
			%>
			<%
			if (level == 2 || level == 1) {
			%>
			<a href="${pageContext.request.contextPath}/loadorder">ประวัติ</a>
			<%
			}
			%>
			<%
			if (level == 3 || level == 1) {
			%>
			<a href="${pageContext.request.contextPath}/loadpost">ประกาศรับส่ง</a>
			<a href="${pageContext.request.contextPath}/ShowPost">แก้ไขประกาศรับส่ง</a>
			<%
			}
			%>
		</div>
		<div style="text-align: right;">
			<a href="${pageContext.request.contextPath}/loadsoeditmem">แก้ไขข้อมูล</a>
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
		</div>
		<a href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
		<%
		}
		%>

	</nav>
	<br>
	<br>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/loadeditPost">

		<h1>แก้ไขประกาศรับส่งอาหาร</h1>
		<div style="text-align: center;">
			<table style="text-align: center;">
				<%
				if (postid != null) {
				%>
				<tr>
					<th><img 
						src="./img/<%=postid.getProfile_pic()%>" alt="" width="200"
						height="150" /> <label for="imgs">รูปโปรไฟล์ร้านอาหาร : <input
							type="file" name="profile_pic" id="imgs"
							accept="image/png/gif,image/jpeg/gif">
					</label></th>

					<th><label for="restaurant">ชื่อร้านค้า : <input
							type="text" placeholder="ชื่อร้านค้า *"
							value="<%=postid.getRestaurant()%>" name="restaurant"
							id="restaurant" readonly />
					</label> <img src="./img/<%=postid.getMeun()%>"
						alt="" width="200" height="150" /> <label for="imgs">รูปเมนูอาหาร
							: <input type="file" name="meun" id="imgs"
							accept="image/png/gif,image/jpeg/gif"
							value="<%=postid.getMeun()%>">
					</label> <label for="postdate">วันที่ :</label> <input type="date"
						id="postdate" name="postdate" value="<%=postid.getPostDate()%>"
						readonly> <label for="posttime">เลือกเวลา :</label> <input
						type="time" id="posttime" name="posttime"
						value="<%=postid.getPostTime()%>" readonly> <label
						for="amount">จำนวนคนที่จะส่ง :</label> <select name="amount"
						id="amount" value="">
							<option value="select"><%=postid.getAmount()%></option>
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
					</select> <label for="deliveryfee">ค่าส่ง :</label> <input type="text"
						placeholder="ค่าส่ง *" value="<%=postid.getDeliveryfee()%>"
						name="deliveryfee" id="deliveryfee" /></th>
				<tr>
					<th><label for="detail">หมายเหตุ :</label> <textarea
							name="detail" rows="4" cols="50" placeholder="หมายเหตุ *"
							id="detail" value=""><%=postid.getDetail()%></textarea></th>
					<th></th>
					<th><label for="location">ที่อยู่ :</label> <textarea
							name="location" rows="4" cols="50" placeholder="ที่อยู่ *"
							id="location" value=""><%=postid.getLocation()%></textarea></th>
				</tr>

				<%
				}
				%>
			</table>
			<table>
				<tr>

					<th>
						<button type="Submit" name="button"
							OnClick="return validateForm(frm)">ตกลง</button>
					</th>

					<th>
						<button type="reset" name="button">ยกเลิก</button>
					</th>
				</tr>
			</table>
		</div>


	</form>

</body>
</html>