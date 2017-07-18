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
   			
 							<div class="pull-left"> <h3>${SpecialBlurb}</h3> </div>
 				<select id="status" name="status" class="btn btn-danger btn-mini pull-right">
				   <option value="Undelivery">
						Undelivery
				</option>
				   <option value="Delivering">Delivering</option>
				   <option value="Preparing">Preparing</option>
				   <option value="Delivered">Delivered</option>
				</select>				
 				<a href="<spring:url value="/orders/update" />" class="btn btn-danger btn-mini pull-right">Change Status of Oder</a>	
 				<br>
 		</div>
	</section>

	<section class="container">
		<div class="row">
 				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
 						<div class="caption">
							<h3>Product Name - ${order.productName}</h3>
							<p>Quantity -         ${order.quantity}</p>
							<p>Status - ${order.status}</p>

						</div>
					</div>
				</div>
 
		</div>
	</section>
</body>
</html>
