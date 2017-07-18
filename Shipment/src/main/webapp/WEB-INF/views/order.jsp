<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Members</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>One Order</h1>
				<p>The Specific of This Order</p>
			</div>

			<div class="pull-left">
				<h3>${SpecialBlurb}</h3>
			</div>
			<br>
		</div>
	</section>

	<section class="container">
		<div class="row">
			<form class="form-horizontal"
				action="<spring:url value="/orders/update"></spring:url>"
				method="post">
				<sec:csrfInput />
				<fieldset>
					<div class="form-group">
						<label class="control-label col-lg-2" for="id">id</label>
						<input id="id" class="form:input-large" placeholder="id"
							name='id' type="text" value="${order.id}" readonly>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2" for="orderNumber">orderId</label>
						<input id="orderNumber" class="form:input-large" placeholder="OrderNumber"
							name='orderNumber' type="text" value="${order.orderNumber}" readonly>
					</div>
					<div class="form-group">
						<label class="control-label col-lg-2" for="quantity">Quantity</label>
						<input id="quantity" class="form:input-large" placeholder="Quantity"
							name='Quantity' type="text" value="${order.quantity}" readonly>
					</div>
					<label class="control-label col-lg-2" for="status">Delivery Status</label>
					<select id="status" name="status" class="btn btn-danger pull-left">

						<option value="Undelivery"
							${order.status == 'Undelivery' ? 'selected="selected"' : ''}>
						Undelivery
				   </option>
						<option value="Delivering"
							${order.status == 'Delivering' ? 'selected="selected"' : ''}>
						Delivering
				   </option>
						<option value="Preparing"
							${order.status == 'Preparing' ? 'selected="selected"' : ''}>
						Preparing
				   </option>
						<option value="Delivered"
							${order.status == 'Delivered' ? 'selected="selected"' : ''}>
						Delivered
				   </option>
					</select>
					<br>
					<hr>
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnUpdate" class="btn btn-primary"
							value="Update" />
					</div>
				</fieldset>
			</form>
		</div>
	</section>
</body>
</html>
