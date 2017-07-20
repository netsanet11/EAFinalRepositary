<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form modelAttribute="newAddress" class="form-horizontal">
			<fieldset>
				<legend>Add new address</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="street"><spring:message
							code="addAddress.form.street.label" /></label>
					<div class="col-lg-10">
						<form:input id="street" path="street" type="text"
							class="form:input-large" />
						<form:errors path="street" cssClass="text-danger" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="city"><spring:message
							code="addAddress.form.city.label" /></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="city" path="city" type="text"
								class="form:input-large" />
							<form:errors path="city" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="state"><spring:message
							code="addAddress.form.state.label" /></label>
					<div class="col-lg-10">
						<form:input id="state" path="state" type="text"
							class="form:input-large" />
						<form:errors path="state" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zip"><spring:message
							code="addAddress.form.zip.label" /></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="zip" path="zipCode" type="text"
								class="form:input-large" />
							<form:errors path="zipCode" cssClass="text-danger" />
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" />
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
	<section>
	
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
<p align="right">
								<a
									href=" <spring:url value="/checkout/submit" /> "
									class="btn btn-primary"> <span
									class="glyphicon-info-sign glyphicon" /></span> Submit Order
								</a>
							</p>
</section>
</body>
</html>