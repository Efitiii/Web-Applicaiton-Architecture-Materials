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
<form:form modelAttribute="borrower" action="borrowBooks" method="post">
    <fieldset>
        <legend>Borrow books for ${borrower.name }</legend>

       <p>
            <label for="name">Borrower Name: </label>
            <form:input   id="name"  path="name"  />
       </p>
            <form:hidden  id="id"  path="id"  />

        <p>
            <label for="books">Books </label>
     		<form:select id = "books" path="books" size="5" multiple="true" 
     							items="${books}" itemValue= "id" itemLabel="title"  />
 
          </p>
     
         
        <p id="buttons">
             <input id="submit" type="submit" value="Borrow Books">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
