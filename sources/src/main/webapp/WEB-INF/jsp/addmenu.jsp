<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*, util.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADDMENU</title>
</head>
<body>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/losdmenu">
		<div>
			ชื่อเมนูอาหาร *<input type="text" placeholder="ชื่อร้านอาหาร *"
				value="" name="namemenu" id="namemenu" /> ราคา *<input type="text"
				placeholder="ราคา *" value="" name="nameprice" id="menuprice" />
		</div>
		<div>
			<input type="submit" value="เพิ่มรายการอาหาร">
		</div>
	</form>
	<div>
		Don't have an account? <a
			href="${pageContext.request.contextPath}/loadpost">ประกาศรับส่ง</a>
	</div>
</body>
</html>