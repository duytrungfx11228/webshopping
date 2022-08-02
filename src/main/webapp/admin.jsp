<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width" />

<title>Admin</title>


<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
<link href="admin/assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
<style><%@include file="/admin/assets/css/pe-icon-7-stroke.css"%></style>
<style><%@include file="/admin/assets/css/demo.css"%></style>
<style><%@include file="/admin/assets/css/bootstrap.min.css"%></style>
<style><%@include file="/admin/assets/css/animate.min.css"%></style>
<style><%@include file="/admin/assets/css/light-bootstrap-dashboard.css"%></style>

</head>
<body>
	<div class="wrapper">
		<div class="sidebar" data-color="purple">

			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="#" class="simple-text"> Admin </a>
				</div>

				<ul class="nav">
					<li><a href="#"> <i class="pe-7s-graph"></i> Dashboard
					</a></li>
					<li class="active"><a href="#"> <i class="pe-7s-user"></i>User
							Profile
					</a></li>
					<li class="active"><a href="logout">
					 <i class="pe-7s-user"></i> Logout
			         </a></li>

				</ul>
			</div>
		</div>

		<div class="main-panel ">
			<div style="color: red; text-align: center">
				<%
				String msg = (String) session.getAttribute("user");
				String st = "";
				if(msg!=null){
					st = msg.substring(0, msg.indexOf("@"));
				}
				%>
				<h4>welcome: <%=st%></h4>	
			</div>
		</div>

	</div>

</body>
</html>