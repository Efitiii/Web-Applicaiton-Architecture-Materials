<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Book List</title>
<style type="text/css">@import url("<spring:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<h1>Borrower List</h1>

 
<table>
<tr>
    <th>Name</th>
  
</tr>
<c:forEach items="${borrowers}" var="borrower">
    <tr>
        <td>${borrower.value.name}</td>
  
  
  <c:url var="borrow" value="/borrowBooks">
   <c:param name="borrower" value="${borrower.key}"/>
 </c:url>
 <td> <a href="${borrow}">Borrow Books </a></td>
        
       </tr>
</c:forEach>
</table>


    <form action="addBook" method="get">
           <input id="submit" type="submit"  
                value="Add Book">
	</form>

 


</div>
</body>
</html>
