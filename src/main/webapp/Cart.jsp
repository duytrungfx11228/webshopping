<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cart</title>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

			<div class="pb-5">
				<div class="container">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="p-2 px-3 text-uppercase">Product</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Price</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Quantity</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Money</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Action</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:set var="o" value="${sessionScope.cart}" />

										<c:forEach items="${o.items}" var="i">

											<tr>
												<th scope="row">
													<div class="p-2">
														<img src="${i.product.src}" alt="" width="70"
															class="img-fluid rounded shadow-sm">
														<div class="ml-3 d-inline-block align-middle">
															<h5 class="mb-0">${i.product.name}</h5>
															<span class="text-muted font-weight-normal font-italic"></span>
														</div>
													</div>
												</th>
												<td class="align-middle"><strong>${i.price}</strong></td>
												<td class="align-middle"><a
													href="process?num=-1&pid=${i.product.id}"><button
															class="btnSub">-</button></a> <strong>${i.amountProduct}</strong> <a
													href="process?num=1&pid=${i.product.id}"><button class="btnAdd">+</button></a></td>
												<td class="align-middle"><strong><fmt:formatNumber
															pattern="##.##" value="${i.price*i.amountProduct}" /></strong></td>
												<td class="align-middle"><a href="delete?pid=${i.product.id}"
													class="text-dark">
														<button type="button" class="btn btn-danger">Delete</button>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<td class="align-middle"><strong>Total Money</strong></td>
											<td class="align-middle"><strong></strong></td>
											<td class="align-middle"><strong></strong></td>
											<td class="align-middle"><strong>${money}</strong></td>
											<td class="align-middle"><strong></strong></td>
										</tr>
									</tfoot>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

					<div class="row py-5 p-4 bg-white rounded shadow-sm">
						<div class="col-lg-6">
							<form action="buy" method="post">
								<div class="input-group input-group-sm mb-3">
									<span class="input-group-text" id="inputGroup-sizing-sm">Email</span>
									<input type="text" name="email" class="form-control">
								</div>

								<div class="input-group mb-3">
									<span class="input-group-text" id="inputGroup-sizing-default">Address</span>
									<input type="text" name="address" class="form-control">
								</div>

								<div class="input-group input-group-lg">
									<span class="input-group-text" id="inputGroup-sizing-lg">Discount_code</span>
									<input type="text" name="discount" class="form-control">
								</div>
								<div class="input-group input-group-lg">
									<input type="submit" value="Submit" class="btn1">
								</div>
							</form>

						</div>
					</div>
				</div>
			</div>
			<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>

