<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp" %>
<%@include file="MyCarouse.jsp" %>

<form action="login" method="post">
<table class="table table-bordered responsive">
	<tr class="sucess">
		<td colspan="4" class="text-center">Sign In Here</td>
	</tr>
	<tr class="success">
		<td colspan="2">Email Id</td>
		<td colspan="2"><input type="text" name="emailId"/></td>
	</tr>
	<tr>
		<td colspan="2">Password</td>
		<td colspan="2"><input type="password" name="password"/></td>
	</tr>
	<tr>
	<td colspan="4">
	<center>
	<input type="submit" value="Login" class="btn btn-success"/>
	</center>
	</td>
	</table>
	</form>
</body>
</html>