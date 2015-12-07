package fam.poiry.GroceryApp;

import java.util.HashSet;
import java.util.Set;

public class Ingredient {

	private String ingredientName;
	private Set<String> ingredientDescriptors;
	private Measurement measurement;
	private Fraction amount;
	
	public Ingredient(String name) {
		ingredientName = name;
		ingredientDescriptors = new HashSet<String>();
		measurement = Measurement.SELF;
		amount = new Fraction(1);
	}
	
	public Ingredient(String name, Set<String> descriptors) {
		ingredientName = name;
		ingredientDescriptors = descriptors;
		measurement = Measurement.SELF;
		amount = new Fraction(1);
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
	
	public void setMeasurement(Measurement measurement) {
		this.measurement = measurement;
	}
	
	public String getMeasurementName() {
		return measurement.getMeasurementName();
	}
	
	public String getMeasurementAbbrv() {
		return measurement.getMeasurementAbbrv();
	}
	
	public void setAmount(Fraction amount) {
		this.amount = amount;
	}
	
	public String getAmount() {
		return amount.toString();
	}
	
	public enum Measurement {
		OZ ("ounces", "oz"),
		FLOZ ("fluid ounces", "fl.oz"),
		LBS ("pounds", "lbs"),
		TSP ("teaspoon", "tsp"),
		TBSP ("tablespoon", "tbsp"),
		C ("cups", "c"),
		SELF ("self", "x"),
		PT ("pint", "pt"),
		QT ("quart", "qt"),
		GAL ("gallon", "gal"),
		DOZ ("dozen", "doz"),
		PKG ("package", "pkg"),
		SM ("small", "sm"),
		MED ("medium", "med"),
		LG ("large", "lg");
		
		private String name;
		private String abbreviation;
		Measurement(String name, String abbreviation) {
			this.name = name;
			this.abbreviation = abbreviation;
		}
		
		String getMeasurementName() {
			return name;
		}
		
		String getMeasurementAbbrv() {
			return abbreviation;
		}
	}
}