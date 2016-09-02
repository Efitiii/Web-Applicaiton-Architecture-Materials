<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Save Product</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}
    </p>
    
        <form action="product_input.action" method="get">
           <input id="submit" type="submit"  
                value="Add product">
	</form>
 
  	<a href="<c:url value="/" />" >Add Product</a>	
    
    
</div>
</body>
</html>