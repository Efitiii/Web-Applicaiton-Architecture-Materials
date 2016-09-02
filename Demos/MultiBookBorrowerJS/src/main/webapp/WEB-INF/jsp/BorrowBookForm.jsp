 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/scripts.js"/>"></script>
</head>
<body>

 

<div id="global">
<form:form modelAttribute="borrower" action="borrowBooks" method="post">
    <fieldset>
        <legend>Borrow books for ${borrowerData.name }</legend>

       <p>
            <label for="name">Borrower Name: </label>
            <form:input   id="name"  path="name" value="${borrowerData.name }"/>
        </p>
            <form:hidden  id="id"  path="id" value="${borrowerData.id }"/>

        <p>
  <%--
             <label for="books">Books </label>
     		<form:select id= "books" path="books" size="5" readonly="true"
     								items="${borrowerData.books}" itemLabel="title"  />
 --%>
 Books 
 <div id="books" >
    <c:forEach var="book" items="${borrowerData.books}" varStatus="status">
        <form:hidden path="books[${status.index}].id" name="id" id="id" value="${book.id}" />
        <label for="title">${book.title} </label>
        <form:hidden path="books[${status.index}].title" name="title" id="title" value="${book.title}" />
 	<br>
    </c:forEach> 				
</div>
</p>
      <p>
		<button type="button" onclick="saveList();toggle_visibility('pop');">add Books</button>          
           </p>
     
         
        <p id="buttons">
             <input id="submit" type="submit" value="Borrow Books">
        </p>
    </fieldset>
</form:form>

	<div id="pop" style="display:none">
	<form id="addBooksForm" method="post">
		<table>
			<tr>
				<td>
		    		<select id="select-from" size="5" multiple="multiple" >
			    		<c:forEach	items="${notBorrowedBooks}" var="book" >
			     			<option value="${book.key}" > ${book.value.title}</option>
			    		</c:forEach>
					</select>
				</td>
		  		<td style="background-color:white">
		  			<img id="btn-add" alt="Green Arrow" src="<c:url value="/resource/images/arrow_green.png"/>" ><br>
		  			<img id="btn-remove" alt="Red Arrow" src="<c:url value="/resource/images/arrow_red.png"/>" >
		  			
		  		</td>
		  		<td>
		  
		    		<select id="select-to" size="5" multiple="multiple" >
			    		<c:forEach	items="${borrowerData.books}" var="book" >
			     			<option value="${book.id}" > ${book.title}</option>
			    		</c:forEach>
					</select>
				</td>
		  
			</tr>	
		</table>
		<button type="button" onclick="updateBooks();toggle_visibility('pop');">Update Books</button>          	
	  </form>
	</div>
 
 </div>
</body>
</html>
