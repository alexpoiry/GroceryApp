package fam.poiry.GroceryApp;

import java.util.HashSet;
import java.util.Set;

public class Meal implements Meals {

	private String name;
	private Set<Ingredient> ingredients = new HashSet<Ingredient>();
	private int ease;
	private boolean leftovers;
	
	public Meal(String name, int ease, boolean hasLeftovers) {
		this.name = name;
		this.ease = ease;
		this.leftovers = hasLeftovers;
		ingredients = new HashSet<Ingredient>();
	}
	
	public Meal(String name, int ease, boolean hasLeftovers, Set<Ingredient> ingredients) {
		this.name = name;
		this.ease = ease;
		this.leftovers = hasLeftovers;
		this.ingredients = ingredients;
	}
	
	public void addIngredient(Ingredient ingrediant) {
		boolean valuesMatch = false;
		if (!ingredients.isEmpty()) {
			for (Ingredient testValue : ingredients) {
				if (testValue.getIngredientName().equalsIgnoreCase(ingrediant.getIngredientName()) &&
						testValue.getMeasurementAbbrv().equals(ingrediant.getMeasurementAbbrv())) {
					valuesMatch = true;
				}
			}
			
			if (!valuesMatch) {
				ingredients.add(ingrediant);
			} else {
				
			}
		} else {
			ingredients.add(ingrediant);
		}
	}
	
	public Set<Ingredient> getIngredient() {
		return ingredients;
	}
	
	public String getMealName() {
		return name;
	}
	
	public boolean hasLeftovers() {
		return leftovers;
	}
	
	public int getEaseOfPreparation() {
		return ease;
	}
}
