package mum.edu.formatter;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import mum.edu.domain.Book;
import mum.edu.service.BookService;

/**
 * If a Book referenced in a Form by the String value of its ID
 * it is converted into an Object & Vice-versa
 * USE CASE: multiple select in form...
 * @author admin1
 *
 */
@Component
public class BookFormatter implements Formatter<Book> {

@Autowired
private BookService bookService;

	@Override
	public Book parse(String text, Locale locale) throws ParseException {
	  	        return bookService.get(Long.valueOf(text));
	}

	// Automatic setting of selected in form multiple select
	@Override
	public String print(Book object, Locale locale) {
	 	      return String.valueOf(object.getId());
	}
}
 
