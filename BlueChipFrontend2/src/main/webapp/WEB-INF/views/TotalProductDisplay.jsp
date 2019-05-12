
<%@include file="Header.jsp" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
	<br> 
	<hr>

	
<div class="card">
	<div class="row">
		<aside class="col-sm-5 border-right">
<article class="gallery-wrap"> 
<div class="img-big-wrap">
  <div> <a href="#">
  
  <img src="<c:url value="/resources/images/${product.productId}.jpg"/>"></a></div>
	</div> 

</article> <!-- gallery-wrap .end// -->
		</aside>
		<aside class="col-sm-7">
<article class="card-body p-5">
	<h3 class="title mb-3">${product.productName}</h3>

<p class="price-detail-wrap"> 
	<span class="price h3 text-warning"> 
		<span class="currency">INR Rs.</span><span class="num">${product.price}/-</span>
	</span> 
 <dl class="item-property">
  <dt>Product id</dt>
  <dd><p>${product.productId} </p></dd>
</dl>
</p> <!-- price-detail-wrap .// -->
<dl class="item-property">
  <dt>Description</dt>
  <dd><p>${product.productDesc} </p></dd>
</dl>

</dl>  <!-- item-property-hor .// -->
<dl class="param param-feature">
  <dt>stock</dt>
  <dd>${product.stock}</dd>
</dl>  <!-- item-property-hor .// -->
<dl class="param param-feature">
  <dt>Supplier</dt>
  <dd>${product.supplierId}</dd>
</dl>  <!-- item-property-hor .// -->
<dl class="param param-feature">
  <dt>Category</dt>
  <dd>${product.categoryId}</dd>
</dl>  <!-- item-property-hor .// -->


<hr>
<form action="addToCart/${product.productId}">
	<div class="row">
		<div class="col-sm-5">
			<dl class="param param-inline">
			  <dt>Quantity: </dt>
			  <dd>
			  	<select name="quantity" class="form-control form-control-sm" style="width:70px;">
			  		<option> 1 </option>
			  		<option> 2 </option>
			  		<option> 3 </option>
			  		<option> 4 </option>
			  		<option> 5 </option>
			  	</select>
			  </dd>
			</dl>  <!-- item-property .// -->
		</div> <!-- col.// -->
		
	</div> <!-- row.// -->
	<hr>
	<input type="submit" value="add to Cart" class="btn btn-success"/>
	
	</form>
</article> <!-- card-body.// -->
		</aside> <!-- col.// -->
	</div> <!-- row.// -->
</div> <!-- card.// -->


</div>
<!--container.//-->


<br><br><br>