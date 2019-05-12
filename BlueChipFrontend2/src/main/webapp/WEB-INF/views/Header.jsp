<%@ page language="java" contentType="text/html"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>

<title>BlueChip-${title}</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">BlueChip</a>
    </div>
    <ul class="nav navbar-nav">
     
        <li><a href="<c:url value="/login"/>">Login</a></li>
		<li><a href="<c:url value="/register"/>">Register</a></li>
		<li><a href="<c:url value="/Aboutus"/>">About Us</a></li>
			<sec:authorize access="hasRole('ROLE_ADMIN')" var="isAdmin">
		<li><a href="<c:url value="/category"/>">Manage Category</a></li>
		<li><a href="<c:url value="/product"/>">Manage Product</a></li>
		<li><a href="<c:url value='/productDisplay'/>">Products</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')" var="isUser">
		<li><a href="<c:url value='/productDisplay'/>">Products</a></li>
		<li><a href="<c:url value="/showCart"/>"><span class="glyphicon glyphicon-shopping-cart"></span>Cart()</a></li>
      	
       	</sec:authorize>
      	</ul>
      	<ul class="nav navbar-nav navbar-right">
       <c:choose>
		<c:when test="${(isAdmin)  || (isUser)}">
		<li><a href="<c:url value='/logout'/>"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</c:when>
		<c:otherwise>
      
      <li><a href="<c:url value="/register"/>"><span class="glyphicon glyphicon-user"></span>Sign up</a></li>
      <li><a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      	</c:otherwise>
		</c:choose>
    </ul>
    
  </div>
</nav>
​