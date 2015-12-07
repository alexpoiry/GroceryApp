package fam.poiry.GroceryApp;

import java.util.HashSet;
import java.util.Set;

public class GroceryList {

	private Set<Ingredient> groceryListItems;
	
	public GroceryList() {
		groceryListItems = new HashSet<Ingredient>();
	}
	
	public GroceryList(Set<Ingredient> groceryListItems) {
		this.groceryListItems = groceryListItems;
	}
	
	public void addGroceryListItem(Ingredient item) {
		groceryListItems.add(item);
	}
	
	public Set<Ingredient> getGroceryListItems() {
		return groceryListItems;
	}
}
