package fam.poiry.GroceryApp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONReaderWriter {

	public static void printJSONObject(Object objectToJSON) {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		System.out.println(gson.toJson(objectToJSON));
	}
}
