package fam.poiry.GroceryApp;

import fam.poiry.GroceryApp.Ingredient.Measurement;

public interface Ingredients {
	
    String getIngredientName();
    String getFullyQualifiedIngredientName();
	void setMeasurement(Measurement measurement);
    String getMeasurementName();
    String getMeasurementAbbrv();
    void setAmount(Fraction amount);
    String getAmount();

}
