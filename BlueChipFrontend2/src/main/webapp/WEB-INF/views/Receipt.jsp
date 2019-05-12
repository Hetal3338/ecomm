<%@include file="Header.jsp" %>
<div class="container">

<table class="table table-bordered">
	<tr>
		<td>ORDER ID</td>
		<td>${orderDetail.orderId}</td>
		<td>Customer Name</td>
		<td>${orderDetail.username}</td>
	</tr>
	<tr>
		<td>Shopping Amount</td>
		<td>${grandTotal}</td>
		<td>Order Date</td>
		<td>${orderDetail.orderDate}</td>
	</tr>
<table class="table table-bordered">

	<tr bgcolor="pink">
		<td colspan="6" class="text-center">Invoice</td>
	</tr>
	<tr class="warning">
		<th>Product Id</th>
		<th>Product Name</th>
		<th>Price</th>
		<th>Quantity</th>
		<th>Image</th>
		<th>Total Price</th>
	</tr>
	<c:forEach items="${cartItemList}" var="cart">
	<tr>
		<td>${cart.productId}</td>
		<td>${cart.productName}</td>
		<td>${cart.price}</td>
		<td>${cart.quantity}</td>
		<td>${cart.quantity*cart.price}</td>
		<td><img src="<c:url value="/resources/images/${cart.productId}.jpg"/>" width="50" height="50"/></td>
		
	</tr>
	</form>
</c:forEach>
</table>

<tr bgcolor="pink">
	<td colspan="4">Address</td>
</tr>
<tr>
	<td>${user.address}</td>
</tr>
</div>