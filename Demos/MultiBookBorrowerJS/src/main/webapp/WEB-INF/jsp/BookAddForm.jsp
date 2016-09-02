 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE HTML>
<html>
<head>
<title>Add Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

 

<div id="global">
<form  action= "addBook" method="post">
    <fieldset>
        <legend>Add a book</legend>
        <p>
            <label for="category">Category </label>
 		 	<select name="category.id">
		    	<option value="-">  --Select Category </option>
		
		  		<c:forEach var="category" items="${categories}">
		    		<option value="${category.key}" > ${category.value.name}</option>
				</c:forEach>
		    </select>
        </p>
         
        <p>
            <label for="title">Title </label>
            <input type="text" id="title" name="title" >
 
        </p>
        <p>
            <label for="author">Author: </label>
            <input type="text" id="author" name="author"/>
        </p>
        <p>
            <label for="isbn">ISBN: </label>
            <input type="text" id="isbn" name="isbn"/>
        </p>
        
        <p id="buttons">
             <input id="submit" type="submit" value="Add Book">
        </p>
    </fieldset>
</form>
</div>
</body>
</html>
