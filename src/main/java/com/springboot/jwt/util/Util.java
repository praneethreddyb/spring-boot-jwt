package com.springboot.jwt.util;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;

public class Util {

	public static boolean isBlank(Object o) {
		if (o == null)
			return true;
		else if (o instanceof String) {
			if (((String) o).trim().equals(""))
				return true;
		} else if (o instanceof Collection<?>) {
			if (((Collection<?>) o).isEmpty())
				return true;
		} else if (o instanceof Integer) {
			if (((Integer) o) <= 0)
				return true;
		} else if (o instanceof Long) {
			if (((Long) o) <= 0)
				return true;
		} else if (o instanceof Short) {
			if (((Short) o) <= 0)
				return true;
		} else if (o instanceof Byte) {
			if (((Byte) o) <= 0)
				return true;
		} else if (o instanceof Double) {
			if (((Double) o) <= 0)
				return true;
		} else if (o instanceof Float) {
			if (((Float) o) <= 0)
				return true;
		} else if (o instanceof Map<?, ?>) {
			if (((Map<?, ?>) o).isEmpty())
				return true;
		} else if (o.getClass().isArray()) {
			return Array.getLength(o) == 0;
		} else {
			if (o.toString().trim().equals(""))
				return true;
		}
		return false;
	}

	public static boolean hasData(Object o) {
		return !isBlank(o);
	}

	public static void main(String[] args) {
		String json = "{\r\n" + "  \"name\": \"Praneeth\",\r\n" + "  \"dateOfBirth\": \"21/12/2022\"\r\n" + "}";

		Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new DateDeserializer()).create();
		User user = gson.fromJson(json, User.class);
		System.out.println(user.getName());
		
		System.out.println(user.getDateOfBirth());

	}
}
