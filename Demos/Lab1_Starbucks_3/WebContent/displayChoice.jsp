<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/action/login" method="get">
Starbuck's ${roast} Roast Coffees:

<table>
<c:forEach items="${advice}" var="item" varStatus="loop">

<c:choose>
<c:when test="${loop.index % 2==0}">
<tr style="background-color:cyan">
<td>${item}</td>
</tr>
</c:when>
<c:otherwise>
<tr style="background-color:yellow">
<td>${item}</td>
</tr>
</c:otherwise>
</c:choose>
</c:forEach>
</table>

<input type="submit" value="Back">

</form>
</body>
</html>