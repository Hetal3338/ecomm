<%@include file="Header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">


<form:form action="InsertProduct" modelAttribute="product" enctype="multipart/form-data"  method="post">
<table align="center" class="table table-bordered">
	<tr>
		<td colspan="2"><font color="red">${ErrorInfo}</font></td>
		</tr>

	<tr class="info">
		<td colspan="2"><center>Enter Product</center></td>
	</tr>
	<tr>
		<td>Product Id</td>
		<td><form:input path="productId"/></td>
	</tr>
	<tr>
		<td>Category</td>
		<td><form:select path="categoryId">
			<form:option value="0" label="--Select List"/>
			<form:options items="${categoryList}"/>
		</form:select></td>
		</tr>
	<tr>
		<td>Price</td>
		<td><form:input path="price"/></td>
	</tr>
	<tr>
		<td>Product Desc</td>
		<td><form:input path="productDesc"/></td>
	</tr>
	<tr>
		<td>Product Name</td>
		<td><form:input path="productName"/></td>
	</tr>
	<tr>
		<td>Stock</td>
		<td><form:input path="stock"/></td>
	<tr>
	<td>Supplier</td>
		<td><form:input path="supplierId"/></td>
	</tr>
	<tr>
		<td>Product Image</td>
		<td><form:input type="file" path="pimage"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<center>
		<input type="submit" value="add Product" class="btn btn-success"/>
		</center>
		</td>
	</tr>
</table>
</form:form>


<br/><br/><br/>
<table align="center" class="table table-bordered">

		<tr bgcolor="orange">
		<td colspan="9"><center> Product Detail</center></td>
		</tr>
		<tr class="info">
			<td>ProductId</td>
			<td>Category</td>
			<td>Price</td>
			<td>Product Desc</td>
			<td>Product Name</td>
			<td>Stock</td>
			<td>Supplier</td>
			<td>Image</td>
			<td>Operation</td>
		</tr>
		<c:forEach items="${productlist}" var="product">
		<tr>
			<td>${product.productId}</td>
			<td>${product.categoryId}</td>
			<td>${product.price}</td>
			<td>${product.productDesc}</td>
			<td>${product.productName}</td>
			<td>${product.stock}</td>
			<td>${product.supplierId}</td>
			<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="50" height="50"/>
			<td>
			<a href="<c:url value="/editProduct/${product.productId}"/>">
			<img src="<c:url value="/resources/images/ed.png"/>" width="40" height="40"/>
			&nbsp;&nbsp;&nbsp;&nbsp;
			</a>
			<a href="<c:url value="/deleteProduct/${product.productId}"/>">
			<img src="<c:url value="/resources/images/del.jpg"/>" width="40" height="40"/>
			&nbsp;&nbsp;&nbsp;&nbsp;
			</a>
			</td>
		</tr>
</c:forEach>

</table>
</div>


