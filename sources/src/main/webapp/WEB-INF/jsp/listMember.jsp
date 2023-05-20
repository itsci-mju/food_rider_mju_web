<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*, util.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
List<Member> list = (List<Member>) session.getAttribute("st");
/*int error = 0;
try{
	error = (int) request.getAttribute("errorListMember");
}catch (Exception e) {
	error = 0;
	
}

if(error == 1){
	System.out.println("บันทึกเสร็จ");
}else if (error == -1){
	System.out.println("ไม่บันทึกเสร็จ");
}*/

%>
<%
/*Member lm = (Member)session.getAttribute("mtCustomer");
List<Member>lm =(List<Member>)session.getAttribute("mtCustomer");>*/
LoginManager mn = new LoginManager();
Member lm = mn.searchMs("Email", "pw");
System.out.println("32165M" + lm);
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
	level = Integer.parseInt(levelstring);
	System.out.println("submit! LEVE = " + level);
	System.out.println(memFeature.getMemAddress());
	System.out.println(memFeature.getMemPhone());
} catch (Exception e) {
	System.out.println("Error! LEVE = " + level);
	level = 0;

}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTMEMBER</title>
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
	width: 80%;
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
/* แต่งปุ่มตลาง */
.center-btn {
  background-color: #4CAF50;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 5px;
  transition-duration: 0.4s;
}

.center-btn:hover {
  background-color: #3e8e41;
}

/* แต่งปุ่มยกเลิก */
.cancel-btn {
  background-color: #f44336;
  border: none;
  color: white;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 5px;
  transition-duration: 0.4s;
}

.cancel-btn:hover {
  background-color: #c62828;
}
.divo {
background-color: white;
	padding: 20px;
	border-radius: 10px;
	width: 80%;
	margin: 0 auto;
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
		<a href="${pageContext.request.contextPath}/loadorder">ประวัติสั่งอาหาร</a>
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

<div class=" divo">


		<h1>ข้อมูสมาชิก</h1>
		<!-- class="image-preview" -->
		<%if(list != null){ %>
		<table style="width: 100%">
		
			<tr>
				<th>รูปโปรไฟล์</th>
				<th>ชื่อ</th>
				<th>อีเมล</th>
				<th>ที่อยู่</th>
				<th>เบอร์โทรศัพท์</th>
				<th>สถานะ</th>
				<th>รหัสสมาชิก</th>
				<th>รหัสผ่าน</th>
				<th></th>
				<th></th>
			</tr>
			<%for(Member m : list) {%>
				
				<%if(Integer.parseInt(m.getMemFeature()) > 1 ) {%>
			<tr>
				<th><%=m.getMemImageProfile() %></th>
				<th><%=m.getMemName() %></th>
				<th><%=m.getMemEmail() %></th>
				<th><%=m.getMemAddress() %></th>
				<th><%=m.getMemPhone() %></th>
				<th><%=m.getMemFeature() %></th>
				<th><%=m.getMemID() %></th>
				<th><%=m.getPassword() %></th>
				<th>
				<!-- <a href="${pageContext.request.contextPath}/loadeditMember?memID=<%=m.getMemID() %>">แก้ไข</a> -->
				</th>
				<%if(m.getStatus().equals("ปลดบล็อก")){ %>
				<th><a href="${pageContext.request.contextPath}/resPostupdate?memID=<%=m.getMemID() %>&status=บล็อก"><button class="center-btn" >ปลดบล็อก</button></a></th>
				<%} %>
				
				<%if(m.getStatus().equals("บล็อก")){ %>
				<th><a  href="${pageContext.request.contextPath}/resPostupdate?memID=<%=m.getMemID() %>&status=ปลดบล็อก"><button class="cancel-btn" >บล็อก</button></a></th>
				<%} %>
			</tr>
			<%} %>
		<%} %>
		
		</table>
		<%} %>
		

</div>
</body>
</html>