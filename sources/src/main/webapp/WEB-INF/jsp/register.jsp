<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
</head>
<body>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/mregister">
			<div>
			<a href="${pageContext.request.contextPath}/">หน้าหลัก</a> 
			<a href="${pageContext.request.contextPath}/loadpost">ประกาศรับส่ง</a>
			<a href="${pageContext.request.contextPath}/loadaddmeun">เพิ่มเมนู</a>
			<a href="${pageContext.request.contextPath}/loadorder">สั่งอาหาร</a>
			<a href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
			<a href="${pageContext.request.contextPath}/loadregister">ลงทะเบียน</a>
			
			</div>
		<h1>REGISTER</h1>
		<div>
			<div>
				รูปโปรไฟล์ *<input type="file" name="profile_pic" id="imgs"
					accept="image/png/gif,image/jpeg/gif">
			</div>

			<div>
				ชื่อ *<input type="text" placeholder="ชื่อ *" value="" name="name"
					id="name" />
			</div>

			<div>
				Email *<input type="text" placeholder="Email *" value=""
					name="email" id="email" />
			</div>

			<div>
				ที่อยู่ *
				<textarea name="adds" rows="4" cols="50" placeholder="ที่อยู่ *"
					id="adds"></textarea>
			</div>

			<div>
				เบอร์โทรศัพท์ *<input type="text" minlength="10" maxlength="10"
					name="phone" placeholder="เบอร์โทรศัพท์ *" value="" id="phone" />
			</div>

			<div>
				
				<input type="radio" id="rider" name="rider" value="2">
				  <label for="memner">ผู้ใช้ทั่วไป</label><br>   
				<input type="radio"id="rider" name="rider" value="3">   
					<label for="Rider">ไรเดอร์</label><br> 
			</div>

			<div>
				Password *<input type="password" name="password" value=""
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