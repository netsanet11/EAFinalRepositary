<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Order Items</title>
</head>
<body>
<section>
<div class="jumbotron">
			<div class="container">
				<h1>Order Items</h1>
				
			</div>
		</div>		
		
	</section>
<section class="container">
		<div class="row">
			<c:forEach items="${items}" var="item">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<!-- img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/-->
						<div class="caption">
							<h3>Name: ${item.product.name}</h3>
							<p>Description: ${item.product.description}</p>
							<p>Price: ${item.product.price}USD</p>	
							<p>Quantity: ${item.quantity}</p>			
						</div>
					</div>
				</div>				
			</c:forEach>
			
		</div>
	</section>
<section>
<p>
								<a
									href=" <spring:url value="/checkout/submit" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Submit Order
								</a>
							</p>
</section>
</body>
</html>