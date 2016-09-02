<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
 
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
			</div>
				<p>
					<a href="<spring:url value="/products" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Products
					</a>
					<!--  enable to see column tests [add member goes to testfile.jsp -->
					<a href="<spring:url value="/testGrid" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Test Bootstrap Grid
					</a>

				</p>
		</div>
	</section>
</body>
</html>
