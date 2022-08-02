<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style><%@include file="/css/style.css"%></style>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-9">
				<div class="row">
					<c:forEach items="${listp}" var="o">
						<div class="col-12 col-md-6 col-lg-4">
							<div class="col">
								<div class="card card-img">
									<a href="Detail?pid=${o.id}" title="vew product"> <img src="${o.src}"
										class="card-img-top" alt="Card image cap">
									</a>
									<div class="card-body">
										<p class="card-text">${o.type}.</p>

										<h6 class="card-title">
											<a href="Detail?pid=${o.id}" title="vew product">${o.name}</a>
										</h6>

										<h6 class="card-price">$${o.price}</h6>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-3">
				<div class="card bg-light mb-3">
					<div class="card-header bg-primary text-white text-uppercase">
						<i class="fa fa-list"></i> Categories
					</div>
					<ul class="list-group category_block">
						<c:forEach items="${listct}" var="o">
							<li class="list-group-item text-white ${tg == o.name ? 'active':''}"><a href="ControllerCategory?name=${o.name}">${o.name}</a></li>
						</c:forEach>

					</ul>
				</div>
				<div class="card bg-light mb-3">
					<div class="card-header bg-success text-white text-uppercase">
						Product</div>
					<div class="card-body">
						<img class="img-fluid" src="" />
						<h5 class="card-title">name</h5>
						<p class="card-text">title</p>
						<p class="bloc_left_price">price</p>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="clearfix">
				<ul class="pagination">
					<c:if test="${tag>1}">
						<li class="page-item"><a href="${path}?name=${tg}&index=${tag-1}"
							class="page-link">Previous</a></li>
					</c:if>

					<c:forEach begin="1" end="${endp}" var="i">
						<li class="page-item ${tag == i?'active':''}"><a
							href="${path}?name=${tg}&index=${i}" class="page-link">${i}</a></li>
					</c:forEach>
					<c:if test="${tag < endp}">
						<li class="page-item"><a href="${path}?name=${tg}&index=${tag+1}"
							class="page-link">Next</a></li>
					</c:if>

				</ul>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>