<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*, util.*,java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADDPOST</title>
</head>
<body>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/losdposts">
		<div>
			<a href="${pageContext.request.contextPath}/">หน้าหลัก</a> 
			<a href="${pageContext.request.contextPath}/loadpost">ประกาศรับส่ง</a>
			<a href="${pageContext.request.contextPath}/loadaddmeun">เพิ่มเมนู</a>
			<a href="${pageContext.request.contextPath}/loadorder">สั่งอาหาร</a>
			<a href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
			<a href="${pageContext.request.contextPath}/loadregister">ลงทะเบียน</a>

		</div>
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