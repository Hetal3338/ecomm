<%@include file="Header.jsp" %>

<div class="container">
<form action="<c:url value="/updateCategory"/>" method="post" >
<table align="center" class="table table-bordered">
	<tr class="info">
		<td colspan="2"><center>Category Detail</center></td>
	</tr>
	<tr>
		<td>Category Name</td>
		<td><input type="text" name="catName" value="${category.categoryName }"/></td>
	</tr>
	<tr>
		<td>Category Desc</td>
		<td><textarea rows="6" cols="30" name="catDesc">${category.categoryDesc}</textarea></td>
	</tr>
	<tr>
		<td>Category Id</td>
		<td><input type="text" name="catId" value="${category.categoryId}"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<center>
		<input type="submit" value="Update Category" class="btn btn-success"/>
		</center>
		</td>
	</tr>

</table>
</form>
</div>
</body>
</html>