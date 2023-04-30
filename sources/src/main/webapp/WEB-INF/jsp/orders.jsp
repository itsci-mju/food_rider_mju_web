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
	System.out.println("submit! LEVE = " + level);
} catch (Exception e) {
	System.out.println("Error! LEVE = " + level);
	level = 0;

}
%>
<%
PostManager pm = new PostManager();
List<Post> list = (List<Post>) session.getAttribute("sp");

%>
<%
List<Post> Post = null;
%>
<%
PostManager sm = new PostManager();
%>
<%
try {
	Post = sm.Showpost();
} catch (Exception e) {

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDER</title>
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

input[type="submit"] {
	background-color: #6a5acd;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
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
	width: 120px;
	height: 120px;
	border-radius: 50%;
	border: 5px solid white;
	margin: 0 auto;
	background-size: cover;
	background-position: center;
}
h1 {
  text-align: center;
}
p {
text-align: center;
}
</style>
<script>
	function checkOnlyOne(clickedCheckbox) {
		const checkboxes = document.getElementsByName('fruit');
		for (let i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i] !== clickedCheckbox) {
				checkboxes[i].checked = false;
			}
		}
	}
</script>
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
		</div>
		<div style="text-align: right;">
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
		</div>
		<a href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
		<%
		}
		%>
		
	</nav>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/loadorder">
		<h1>กรุณาเลือกรายการอาหาร</h1>
		<%if(list != null) {%>
		<h1><%=list.get(0).getRestaurant() %></h1>
		<img alt="<%=list.get(0).getMeun() %>" src="" width="200" height="150">
		<label>จำนวน : <%=list.get(0).getAmount() %></label>
		<label>ค่าส่ง : <%=list.get(0).getDeliveryfee() %></label>
		<label> <input type="checkbox" name="fruit" value="transfer"
			onclick="checkOnlyOne(this)"> โอน
		</label> <br> <label> <input type="checkbox" name="fruit"
			value="destination" onclick="checkOnlyOne(this)"> เก็บเงินปลายทาง
		</label><br>
		<label>หมายเหตุ</label>
		<input type="note" name="note" value="หมายเหตุ">
		<p><%=list.get(0).getLocation() %></p>

<%} %>

	</form>
</body>

</html>