 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<head>
<title>Save Product</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The book has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Borrower Name: ${borrower.name}<br/><br/>
       <b> BOOKS::</b>    <br/> 
	  		<c:forEach var="book" items="${borrower.books}">
		    		 ${book.title} <br/>
			</c:forEach>
    </p>
    
    <form action="borrowerList" method="get">
           <input id="submit" type="submit"  
                value="List Borrowers">
	</form>
    
</div>
</body>
</html>