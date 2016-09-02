<head>
<title>Save Product</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The book has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Book Name: ${book.title}<br/>
        Category: ${book.category.name}<br/>
        Author: ${book.author}<br/>
        ISBN:  ${book.isbn}
    </p>
    
    <form action="bookList" method="get">
           <input id="submit" type="submit"  
                value="List Books">
	</form>
    
</div>
</body>
</html>