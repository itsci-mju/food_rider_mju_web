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
	System.out.println("Error! LEVE = " + level);
	level = 0;

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REGISTER</title>
   <style>
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
        color: #6a5ac;
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
      .address-container input[type=text], .address-container input[type=number] {
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
      /*.image-upload {
        display: block;
        margin-bottom: 20px;
      }
      .image-upload label {
        display: block;
        margin-bottom: 10px;
        color: #6a5acd;
        font-weight: bold;
      }
      .image-upload input[type="file"] {
        display: block;
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
      }*/
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
		<a href="${pageContext.request.contextPath}/loadlogout">ออกระบบ</a>
		<%
		} else {
		%>
		<a href="${pageContext.request.contextPath}/loadlogin">เช้าสู่ระบบ</a>
		<%
		}
		%>
	</nav>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/mregister">

		<!-- registration form -->
		<div class="form-container">
			<h1>ลงทะเบียน</h1>
			<form enctype="multipart/form-data">
				<div class="image-preview"></div>
				<label for="imge">รูปโปรไฟล์:</label> 
				<input type="file" accept="image/jpeg, image/png, image/jpg" name="profile_pic" id="imgs"> 
				<label for="name">ชื่อ:</label>
				<input type="text" placeholder="ชื่อ *" value="" name="name" id="name" /> 
				<label for="email">อีเมล:</label>
				<input type="text" placeholder="Email *" value="" name="email" id="email" />
				<label for="adds">ที่อยู่:</label>
				<textarea name="adds" rows="4" cols="50" placeholder="ที่อยู่ *" id="adds"></textarea>
				<label for="phone">เบอร์โทรศัพท์:</label>
				<input type="text" minlength="10" maxlength="10" name="phone" placeholder="เบอร์โทรศัพท์ *" value="" id="phone" />
				<label for="memner"><input type="radio" id="rider" name="rider" value="2"> ผู้ใช้ทั่วไป</label>   
				<label for="Rider"><input type="radio" id="rider" name="rider" value="3"> ไรเดอร์</label>
				<label for="rider">รหัสผ่าน:</label>
				<input type="password" name="password" value="" id="password" placeholder="password"/> 
				
				<input type="submit" value="Register" OnClick="return validateForm(frm)" />
			</form>
		</div>

	</form>
    <script>
      // Image preview
      const imageInput = document.querySelector('#image');
      const imagePreview = document.querySelector('.image-preview');
      imageInput.addEventListener('change', () => {
        const file = imageInput.files[0];
        const reader = new FileReader();
        reader.addEventListener('load', () => {
          imagePreview.style.backgroundImage = `url(${reader.result})`;
        });
        reader.readAsDataURL(file);
      });
    </script>
</body>
</html>