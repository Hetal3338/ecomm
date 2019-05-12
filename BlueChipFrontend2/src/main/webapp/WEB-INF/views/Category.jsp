
<%@include file="Header.jsp" %>

<div class="container">
<form action="<c:url value="/addCategory"/>" method="post" >
<table align="center" class="table table-bordered">
	<tr class="info">
		<td colspan="2"><center>Category Detail</center></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" id="catName"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><textarea rows="6" cols="30" name="catDesc"></textarea></td>
	</tr>
	<tr>
		<td>Category Id</td>
		<td><input type="text" name="catId" id="catId"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<center>
		<input type="submit" value="add Category" class="btn btn-success"/>
		</center>
		</td>
	</tr>

</table>
</form>

<table align="center" class="table table-bordered">

	<tr bgcolor=orange>
		<td colspan="4"><center>Category Detail</center></td>
	</tr>
	<tr class="success">
		<td>ID</td>
    	<td>Name</td>
    	<td>Description</td>
    	<td>Operation</td>
   </tr>
<c:forEach items="${listCategories}" var="category">
	<tr>
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>		
		<td>
			<a href="<c:url value="/editCategory/${category.categoryId}"/>">
			<img src="<c:url value="/resources/images/ed.png"/>" width="40" height="40"/>
			&nbsp;&nbsp;&nbsp;&nbsp;</a>
			<a href="<c:url value="/deleteCategory/${category.categoryId}"/>">
			<img src="<c:url value="/resources/images/del.jpg"/>" width="40" height="40"/>
			&nbsp;&nbsp;&nbsp;&nbsp;</a>
		</td>
	</tr>
</c:forEach>

</table>
</div>
</body>
</html>