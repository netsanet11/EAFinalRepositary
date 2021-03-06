<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Orders</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Orders</h1>
			</div>
		</div>
		<div class="container">
					<a href='<spring:url value="/shop" />' class="btn btn-info btn-lg">		
          				<span class="glyphicon glyphicon-shopping-cart"></span> Shop 
        			</a>
        			<a href='<spring:url value="/product" />' class="btn btn-info btn-lg">		
          				<span class="glyphicon glyphicon-shopping-cart"></span> Manage products 
        			</a>
        			<a href='<spring:url value="/#" />' class="btn btn-info btn-lg">		
          				<span class="glyphicon glyphicon-shopping-cart"></span> Welcome 
        			</a>
        			<a href='<spring:url value="/logout" />' class="btn btn-info btn-lg">		
          				<span class="glyphicon glyphicon-shopping-cart"></span> Logout 
        			</a>
 					
				</div>	
	</section>
	
	<section>
		<c:forEach items="${orders}" var="order">
			<div class="container">
				<h1>Order: <c:out value="${order.orderNumber}" /></h1>
				<br/>
				<p>
					Address: 
					<c:out value="${order.address.street}" /> 
					<c:out value="${order.address.city}" /> - <c:out value="${order.address.state}" /> 
				</p>
				<p>
				Status: 
					<c:out value="${order.status.longName()}" /> 
				</p>
				
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${order.items}" var="item">
							<tr>
								<td><c:out value="${item.product.productId}" /></td>
								<td><c:out value="${item.product.name}" /></td>
								<td><c:out value="${item.product.price}" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</section>
</body>
</html>
