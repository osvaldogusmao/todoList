package br.com.unifeob.todoList.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {

	public static Calendar  converterStringParaCalendar(String data){		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar date = Calendar.getInstance();
		try {
			date.setTime(dateFormat.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
