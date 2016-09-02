<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

<h1>Registration Form</h1><br />
     
     <form:form modelAttribute="student" action="registration" method="post">
     <fieldset>
     <legend>Student Registration</legend>
     
     <p>
       <form:errors path="*" cssStyle="color : red;align:center;" />
     </p>
     
     <p>
            <label for="firstName">First Name: </label>
           <form:input path="firstName" />
 	
 		  	<div style="text-align: center;">
 				<form:errors path="firstName" cssStyle="color : red;" /> 
 			</div>
       </p>
       
         <p>
            <label for="lastName">Last Name: </label>
           <form:input path="lastName" />
 	
 		  	<div style="text-align: center;">
 				<form:errors path="lastName" cssStyle="color : red;" /> 
 			</div>
       </p>
       
         <p>
            <label for="gender">Gender: </label>
           <form:select path="gender" items="${gender}" />	
           
 		  	<div style="text-align: center;">
 				<form:errors path="gender" cssStyle="color : red;" /> 
 			</div>
       </p>
       
         <p>
            <label for="birthday">Date Of Birth: </label>
            <form:input path="birthday" id="birthDate" placeholder="mm-dd-yyyy"  />
            
            <div style="text-align: center;">
 			<form:errors path="birthday" cssStyle="color : red;" /> 
 			</div>
        </p>
        
         <p>
            <label for="email">Email: </label>
            <form:input path="email" id="email" placeholder="mm@mail.com" />
            
            <div style="text-align: center;">
 			<form:errors path="email" cssStyle="color : red;" /> 
 			</div>
        </p>
        
         <p>
            <label for="phone">Phone: </label>
            <form:input path="phone" id="phone" placeholder="xxx-xxx-xxxx"  />
            
            <div style="text-align: center;">
 			<form:errors path="phone" cssStyle="color : red;" /> 
 			</div>
        </p>
        
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Register">
        </p>
       
     </fieldset>
     </form:form>
  
</body>
</html>