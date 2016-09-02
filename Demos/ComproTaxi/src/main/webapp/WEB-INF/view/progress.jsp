<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<style>
#myProgress {
  width: 100%;
  height: 20px;
  position: relative;
  border: 1px solid #ccc;
}
#myBar {
  width: 10px;
  height: 100%;
  position: absolute;
  background-color: blue;
}
</style>
<body>

<h1>My First JavaScript Progress Bar</h1>

<div id="myProgress">
<div id="myBar"></div>
</div>

<br>
<button onclick="move()">Click Me</button> 

<script>
function move() {
  var elem = document.getElementById("myBar");   
  var width = 10;
  var id = setInterval(frame, 10);
  function frame() {
    if (width == 100) {
      clearInterval(id);
    } else {
      width++; 
      elem.style.width = width + '%'; 
    }
  }
}
</script>

</body>
</html>