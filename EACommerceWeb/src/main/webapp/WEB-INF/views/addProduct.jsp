<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<form:form modelAttribute="newProduct" class="form-horizontal">
			<fieldset>
				<legend>Add new product</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId"><spring:message
							code="addProduct.form.productId.label" /></label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text"
							class="form:input-large" />
						<form:errors path="productId" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name"><spring:message
							code="addProduct.form.name.label" /></label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text"
							class="form:input-large" />
						<form:errors path="name" cssClass="text-danger" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="price"><spring:message
							code="addProduct.form.price.label" /></label>
					<div class="col-lg-10">
						<div class="form:input-prepend">
							<form:input id="price" path="price" type="text"
								class="form:input-large" />
							<form:errors path="price" cssClass="text-danger" />
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description"><spring:message
							code="addProduct.form.description.label" /></label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="2" />
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
		<div class="container">
			<h1>Products</h1>
	
		</div>
	</section>
	
	<section>
		<div class="container">
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="product">
						<tr>
							<td><c:out value="${product.productId}" /></td>
							<td><c:out value="${product.name}" /></td>
							<td><c:out value="${product.price}" /></td>
							<td><a
									href=" <spring:url value="/product/delete/${product.id}" /> "
									class="btn btn-danger"> <span
									class="glyphicon glyphicon-remove" /></span> delete
								</a>
							</td>
						</tr>
					</c:forEach>


				</tbody>
			</table>
		</div>
	</section>
</body>
</html>
