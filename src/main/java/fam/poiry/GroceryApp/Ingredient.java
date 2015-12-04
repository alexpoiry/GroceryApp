package fam.poiry.GroceryApp;

import java.util.Set;

public class Ingredient {

	private String ingredientName;
	private Set<String> ingredientDescriptors;
	private Set<Packaging> packaging;
	private Set<Measurements> measurements;
	
	public Ingredient(String name) {
		ingredientName = name;
	}
	
	public Ingredient(String name, Set<String> descriptors) {
		ingredientName = name;
		ingredientDescriptors = descriptors;
	}
	
	public String getIngredientName() {
		return ingredientName;
	}
	
	public String getFullyQualifiedIngredientName() {
		StringBuilder builder = new StringBuilder();
		builder.append(ingredientName);
		
		if (ingredientDescriptors != null || !ingredientDescriptors.isEmpty()) {
			builder.append(": ");
			
			for (String descriptor : ingredientDescriptors) {
				builder.append(descriptor);
				builder.append(", ");
			}
		}
		
		return builder.toString().substring(0, builder.length() - 2);
	}
	
	public enum Packaging {
		HOT, COLD, FRESH, FROZEN, DRIED, 
		DAIRY, BOX, BAG, CARTON, JAR,
		WEIGHT, BOTTLE, CAN, INDIVIDUAL
	}
	
	public enum Measurements {
		oz ("ounces"),
		floz ("fluid ounces"),
		lbs ("pounds"),
		tsp ("teaspoon"),
		tbsp ("tablespoon"),
		c ("cups"),
		self ("self"),
		pt ("pint"),
		qt ("quart"),
		gal ("gallon"),
		doz ("dozen"),
		pkg ("package"),
		sm ("small"),
		med ("medium"),
		lg ("large");
		
		private String name;
		
		Measurements(String name) {
			this.name = name;
		}
		
		String getMeasurementName() {
			return name;
		}
	}
}
