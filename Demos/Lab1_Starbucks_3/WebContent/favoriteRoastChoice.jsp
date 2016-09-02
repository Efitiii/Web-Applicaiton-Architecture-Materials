<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Ask for advise about your favorite roast</h2>
<form action="../action/advice" method="get">
  <select name="roast">
  <option value="-">--Choose Roast--</option>
 <option value="dark">Dark</option>
  <option value="medium">Medium</option>
  <option value="light">Light</option>
  </select><br/><br/>
  <input type="submit" value="Submit"/><br/><br/>
 </form>
</body>
</html>