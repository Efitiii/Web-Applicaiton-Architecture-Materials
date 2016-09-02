package app04a.formatter;

import java.util.Locale;

import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;
import app04a.domain.Phone;

public class PhoneFormatter implements Formatter<Phone> {

	  public String print(Phone phone, Locale locale) {
 	       return phone.getAreaCode() + "-" +
	    		phone.getPrefix() + "-" + phone.getNumber();
	  }

	  public Phone parse(String source, Locale locale)
	      throws ParseException {
		  Phone isbNumber= null;
 
			int start = Integer.parseInt(source.substring(0, 3));
		    int middle = Integer.parseInt(source.substring(4, 7));
		    int end = Integer.parseInt(source.substring(8, 12));
		    isbNumber =  new Phone(start, middle, end);
 
		    return isbNumber;
	  }
}