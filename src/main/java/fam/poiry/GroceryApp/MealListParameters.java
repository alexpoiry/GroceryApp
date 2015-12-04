package fam.poiry.GroceryApp;

import java.util.HashMap;
import java.util.Map;

public class MealListParameters {

	private Map<Integer, Integer> mealDifficultyMap;
	
	public MealListParameters() {
		mealDifficultyMap = new HashMap<Integer, Integer>();
	}
	
	public MealListParameters(HashMap<Integer, Integer> mealDifficultyMap) {
		this.mealDifficultyMap = mealDifficultyMap;
	}
	
	public void addMealDifficultyParameter(int difficulty, int numberOfMeals) {
		mealDifficultyMap.put(difficulty, numberOfMeals);
	}
	
	public Map<Integer, Integer> getMealDifficultyMap() {
		return mealDifficultyMap;
	}
}
