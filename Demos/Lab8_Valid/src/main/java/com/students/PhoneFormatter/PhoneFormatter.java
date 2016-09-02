package com.students.PhoneFormatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.students.domain.Phone;

@Component
public class PhoneFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale arg1) {
		return String.valueOf(phone.getPrefix() + "-" + phone.getArea() + "-" + phone.getNumber());
	}

	@Override
	public Phone parse(String phoneStr, Locale arg1) throws ParseException {
		int start = Integer.parseInt(phoneStr.substring(0, 3));
	    int middle = Integer.parseInt(phoneStr.substring(4, 7));
	    int end = Integer.parseInt(phoneStr.substring(8, 11));
	    
		Phone phone = new Phone();

		phone.setArea(start);
		phone.setPrefix(middle);
		phone.setNumber(end);
		return phone;
	}

}
