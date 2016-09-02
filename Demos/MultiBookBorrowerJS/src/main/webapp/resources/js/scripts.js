$(document).ready(function() {

 	var bookList = new Array();
	var book;

    $("#btn-add").click(function(){
        $("#select-from option:selected").each( function() {
                $('#select-to').append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option>");
 
               	book = {id:$(this).val(), title:$(this).text()}; 
               	bookList.push( book);
               	
                 $(this).remove();
        });
    });
    
    $('#btn-remove').click(function(){
        $('#select-to option:selected').each( function() {
            $('#select-from').append("<option value='"+$(this).val()+"'>"+$(this).text()+"</option>");
 
        	book = {id:$(this).val(), title:$(this).text()}; 
            bookRemove( book);

             $(this).remove();
        });
    });
    
     function bookRemove(value) {
    	var index = bookList.indexOf(value);
    	bookList.splice(index, 1);   
    };

    saveList = function() {
        	bookList = new Array();
               $('#select-to option').each( function() {
        	book = {id:$(this).val(), title:$(this).text()}; 
             bookList.push( book);
     });
    }
 
    updateBooks = function(){
			$('#books').empty();
   	        $.each(bookList, function(i,book) {        	
 
		var book = 
			'<label>' + book.title + '</label>' 
			+ '<input type="hidden" name="books[' + i + '].title" value="' + book.title + '">'
			+ '<input type="hidden" name="books[' + i + '].id" value="' + book.id + '">'
			+ '<br>';
   	        	        
  	            $('#books').append(book);
  	            	
   	        
   	        });
   	 

    }
    
    toggle_visibility = function(id) {
        var element = document.getElementById(id);
        if(element.style.display == 'block')
        	element.style.display = 'none';
        else
        	element.style.display = 'block';
     }	 

 
});

