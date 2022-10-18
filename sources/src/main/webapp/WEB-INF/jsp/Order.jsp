<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bean.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
int i = 0;
%>
<%
List<Post> Posts = (List) session.getAttribute("post");
List<Meun> Meuns = (List) session.getAttribute("meuns");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ORDERFOOD</title>
</head>
<body>
	<form name="frm" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/losdorders">
		<%
		for (Post p : Posts) {
		%>
		<%
		i++;
		%>
		<div>
			<p><%=p.getRestaurant()%></p>
		</div>
		<div>
			<img alt="" src="img/<%=p.getProfile()%>" width="250px "
				height="200px">
		</div>
		<div>
			<p>
				จำนวน<%=p.getAmount()%>/10
			</p>
		</div>
		<div>
			<p>
				ค่าส่ง<%=p.getDeliveryfee()%></p>
		</div>
		<%
		for (Meun m : Meuns) {
		%>
		<%
		i++;
		%>
		<div></div>
		<%
		}
		%>
		<div>
			<input type="radio" id="transfer" name="transfer" value="Transfer">  
			<label for="transfer">โอน</label><br>   
			<input type="radio"id="cash" name="cash" value="Cash">  
			<label for="Cash">เก็บเงินปลายทาง</label><br>
		</div>
		<div><p><%=p.getDetail() %> <%=p.getLocation() %></p></div>
		<div>
			หมายเหตุ *
			<textarea name="detailfood" rows="4" cols="50" placeholder="หมายเหตุ *"
				id="detailfood"></textarea>
		</div>
		
		<%
		}
		%>
		<div>
			<input type="submit" value="Register"
				OnClick="return validateForm(frm)" />
		</div>
	</form>
</body>
</html>