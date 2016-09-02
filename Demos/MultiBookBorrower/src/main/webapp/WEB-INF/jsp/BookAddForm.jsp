 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

 

<div id="global">
<form:form modelAttribute="book" action= "addBook" method="post">
    <fieldset>
        <legend>Add a book</legend>
        <p>
            <label for="category">Category </label>
 		 	<form:select path="category.id">
		    	<option value="-">  --Select Category </option>
		    	<!-- Identifies field [name] of value object -->
		<form:options items="${categories}" itemLabel="name"/>
		 
<%-- 	JSTL--
	  		<c:forEach var="category" items="${categories}" >
		    		<option value="${category.key}" > ${category.value.name}</option>
				</c:forEach>
 --%>
 		    </form:select>
        </p>
         
        <p>
            <label for="title">Title </label>
            <form:input type="text" id="title" path="title"/>
 
        </p>
        <p>
            <label for="author">Author: </label>
            <form:input type="text" id="author" path="author"/>
        </p>
        <p>
            <label for="isbn">ISBN: </label>
            <form:input type="text" id="isbn" path="isbn"/>
        </p>
        
        <p id="buttons">
             <input id="submit" type="submit" value="Add Book">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
