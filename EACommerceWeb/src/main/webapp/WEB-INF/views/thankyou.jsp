<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Thank You</title>
</head>
<body>
<section>
<div class="jumbotron">
			<div class="container">
				<h1>Success</h1>
				
			</div>
		</div>		
		
	</section>
<h1>Thank you for your order ${user.firstname}</h1>

<p>
								<a
									href=" <spring:url value="/orders/all" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Orders
								</a>
							</p>
</body>
</html>