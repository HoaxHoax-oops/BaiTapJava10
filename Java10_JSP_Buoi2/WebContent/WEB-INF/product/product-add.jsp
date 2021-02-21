<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/js/all.min.js" integrity="sha256-MAgcygDRahs+F/Nk5Vz387whB4kSK9NXlDN3w58LLq0=" crossorigin="anonymous"></script>
<title>
	<c:choose>
		<c:when test="${command=='ADD'}">Add</c:when>
		<c:otherwise>Edit</c:otherwise>
	</c:choose> 
	new product
</title>
</head>
<body>
	<div class="container bg-light shadow mx-auto pb-5">
		<h3 class="text-info text-center mt-5 pt-2">
			<c:choose>
				<c:when test="${command=='ADD'}">Add</c:when>
				<c:otherwise>Edit</c:otherwise>
			</c:choose> 
			new product
		</h3>
		<div class="container w-50 p-4 mb-4 shadow rounded">
			<%-- đặt đường dẫn cho form khi ấn submit sẽ gọi đến doPost với url là /product/add --%>
			<%String path = request.getContextPath(); %>
			<form method="POST" 
				<c:choose>
					<c:when test="${command=='ADD'}">action="<%=path%>/product/add"</c:when>
					<c:when test="${command=='EDIT'}">action="<%=path%>/product/edit"</c:when>	 		
				</c:choose> 
			>
				<div class="form-group">
			    <label class="text-info" for="id">Product id</label>
			    <input type="text" class="form-control" name="productId" id="id" <c:if test="${command=='EDIT'}">value="${product.id}" readonly</c:if> >
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="name">Product name</label>
			    <input type="text" class="form-control" name="productName" id="name" <c:if test="${command=='EDIT'}">value="${product.name}"</c:if>>
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="code">Product code</label>
			    <input type="text" class="form-control" name="productCode" id="code" <c:if test="${command=='EDIT'}">value="${product.code}"</c:if> >
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="description">Description</label>
			    <textarea rows=2 type="number" class="form-control" name="description" placeholder="Enter Product Code" id="description"><c:if test="${command=='EDIT'}">${product.description}</c:if></textarea>
			  </div>
			  <div class="form-group">
			    <label class="text-info" for="price">Price</label><br>
			    <input class="w-25" type="number" class="form-control" name="productPrice" id="price" <c:if test="${command=='EDIT'}">value="${product.price}"</c:if>>
			  </div>
			  <div class="form-group mt-2">
			  	<button type="submit" class="btn btn-info w-50 mx-auto">
			  		<c:choose>
						<c:when test="${command=='ADD'}">Add</c:when>
						<c:otherwise>Edit</c:otherwise>
					</c:choose> 
			  	</button>
			  </div>
		
			</form>
		</div>
	</div>
</body>
</html>