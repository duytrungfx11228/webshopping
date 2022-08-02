<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--begin of menu-->
	<div class="container-fluid">
		<div class="row header">
			<div class="col-md-6">
				<h1>Mobile Shop</h1>
				<h3>
					Company<span>logo</span>
				</h3>
			</div>
			<div class="col-md-6 search">
				<form action="Search" method="post" class="form-inline my-2 my-lg-0">
					<input value="${txtsearch}" name="txt" type="text" class="form-control inp" list="datalistOptions"
						id="exampleDataList" placeholder="Type to search...">
					<button class="btn btn-outline-success my-2 my-sm-0 but"
						type="submit">Search</button>
				</form>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row topnav thanh">
			<div class="col-md-4">
				<a href="Home">Home</a> <a href="#">Products</a> <a href="#">About
					us</a>
			</div>
			<div class="col-md-8">
				<a href="login" style="float: right">Login</a>
				<a href="#" style="float: right">Register</a>
			</div>
		</div>
	</div>
	<!--end of menu-->