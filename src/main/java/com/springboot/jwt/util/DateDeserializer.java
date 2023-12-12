package com.springboot.jwt.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

class DateDeserializer implements JsonDeserializer<LocalDate>
{
	
	 private static final Pattern DATE_PATTERN = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
	 
	 private static final Pattern DATE_PATTERN1 = Pattern.compile("([0-9]{2})/([0-9]{2})/([0-9]{4})");
	    
    @Override
    public LocalDate deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException
    {
        String myDate = je.getAsString();
        System.out.println(myDate);
        if(DATE_PATTERN.matcher(myDate).matches()) {
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	  //convert String to LocalDate
        	  LocalDate localDate = LocalDate.parse(myDate, formatter);
        	return localDate;
        }
        // inspect string using regexes
        // convert string to Date        
        // return Date object
		return null;
    }
}

