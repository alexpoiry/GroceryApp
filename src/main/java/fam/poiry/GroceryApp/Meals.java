package fam.poiry.GroceryApp;

import java.util.Set;

public interface Meals {
	void addIngredient(Ingredient ingrediant);
	Set<Ingredient> getIngredient();
	String getMealName();
	boolean hasLeftovers();
	int getEaseOfPreparation();

}
