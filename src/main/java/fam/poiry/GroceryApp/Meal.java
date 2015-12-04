package fam.poiry.GroceryApp;

import java.util.HashSet;
import java.util.Set;

public class Meal {

	private String name;
	private Set<String> ingrediants = new HashSet<String>();
	private int ease;
	private boolean leftovers;
	
	public Meal(String name, int ease, boolean hasLeftovers) {
		this.name = name;
		this.ease = ease;
		this.leftovers = hasLeftovers;
	}
	
	public void addIngrediant(String ingrediant) {
		ingrediants.add(ingrediant);
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
