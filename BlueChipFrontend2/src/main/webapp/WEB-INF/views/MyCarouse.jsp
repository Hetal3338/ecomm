<c:url value="/resources/images" var="img" />
<div class="container">
 <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
      <center>  <img src="<c:url value="/resources/images/mobile.jpg"/>" alt="Moblie" style="width:50%;"></center>
      </div>

      <div class="item">
       <center> <img src="${img}/AC1.jpg" alt="AC" style="width:50%;"></center>
      </div>
    
      <div class="item">
     <center> <img src="<c:url value="/resources/images/laptop1.jpg"/>" alt="Laptop" style="width:40%;"></center>
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  

</div>