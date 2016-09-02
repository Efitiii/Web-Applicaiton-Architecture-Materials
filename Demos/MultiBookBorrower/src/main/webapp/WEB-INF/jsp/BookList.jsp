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
<h1>Book List</h1>

 
<table>
<tr>
    <th>Category</th>
    <th>Title</th>
    <th>ISBN</th>
    <th>Author</th>
 
</tr>
<c:forEach items="${books}" var="book">
    <tr>
        <td>${book.value.category.name}</td>
        <td>${book.value.title}</td>
        <td>${book.value.isbn}</td>
        <td>${book.value.author}</td>
        
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
