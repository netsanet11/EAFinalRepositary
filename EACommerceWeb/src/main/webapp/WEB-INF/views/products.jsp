<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
				<p>All the available products in our store</p>
				
				<p align="right">
		<a href='<spring:url value="/checkout" />' class="btn btn-info btn-lg glyphicon glyphicon-shopping-cart" >Cart <span class="badge">${count}</span></a>
         </p>       	
       
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

		</div>	
			

	</section>

	<section class="container">
	
		<div class="row">
			<c:forEach items="${products}" var="product">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
					<!-- img src="<c:url value="/resource/images/${product.productId}.png"></c:url>" alt="image"  style = "width:100%"/-->
						<div class="caption">
							<h3>${product.name}</h3>
							<p>${product.description}</p>
							<p>${product.price}USD</p>
 							<p>
								<a
									href=" <spring:url value="/shop/addItem?id=${product.id}" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Add to Cart
								</a>
							</p>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	
</body>
</html>
