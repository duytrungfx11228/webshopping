<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" >
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>Login Form</title>
    </head>
    <body id="particles-js">
	<%
		
		String user="",pass="",remem="";
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cook: cookies){
				if(cook.getName().equals("cookuser")){
					user = cook.getValue();
				} else if(cook.getName().equals("cookpass")){
					pass = cook.getValue();
				}	else if(cook.getName().equals("cookremem")){
					remem = cook.getValue();
				}	
			}
		}
	%>
	<div class="animated bounceInDown">
		<div class="container">
			<span class="error animated tada" id="msg"> </span>
			
			<form name="form1" class="box" onsubmit="return checkStuff()" action="login" method="post">
				<h4>
					Admin<span>Dashboard</span>
				</h4>
				<h5>Sign in to your account.</h5>
				<% 
					String msg = (String) session.getAttribute("error");
					if(msg==null){
						msg="";
					}
				%>
	             <h4> <%= msg %></h4>
				<input type="text" name="username" value="<%=user %>" placeholder="Username"
					autocomplete="off"> <i class="typcn typcn-eye" id="eye"></i>
				<input type="password" name="password" value="<%=pass %>" placeholder="Passsword"
					id="pwd" autocomplete="off"> 
				<label> 
					<input type="checkbox" name="remember" value="1" <%= "1".equals(remem) ? "checked='/checked'": "" %> /> <span></span> 
					<small class="rmb">Rememberme</small>
				</label> 
				 <a href="#" class="forgetpass">Forget Password?</a> 
				 <input type="submit" value="Sign in" class="btn1">
			</form>
			<a href="#" class="dnthave">Don’t have an account? Sign up</a>
		</div>
		
	</div>
	<script type="text/javascript">
		var pwd = document.getElementById('pwd');
		var eye = document.getElementById('eye');

		eye.addEventListener('click', togglePass);

		function togglePass() {

			eye.classList.toggle('active');

			(pwd.type == 'password') ? pwd.type = 'text'
					: pwd.type = 'password';
		}

		function checkStuff() {
			var username = document.form1.username;
			var password = document.form1.password;
			var msg = document.getElementById('msg');

			if (username.value == "") {
				msg.style.display = 'block';
				msg.innerHTML = "Please enter your username";
				username.focus();
				return false;
			} else {
				msg.innerHTML = "";
			}

			if (password.value == "") {
				msg.innerHTML = "Please enter your password";
				password.focus();
				return false;
			} else {
				msg.innerHTML = "";
			}

		}
	</script>
</body>
</html>