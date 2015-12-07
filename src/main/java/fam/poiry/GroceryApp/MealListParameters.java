package fam.poiry.GroceryApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MealListParameters {

	private Map<Integer, MealMetadata> mealParameterMap = new HashMap<Integer, MealMetadata>();
	
	public void addMealDifficultyParameter(int difficulty, int totalNumberOfMeals, int mealsWithLeftovers) {
		mealParameterMap.put(difficulty, new MealMetadata(totalNumberOfMeals, mealsWithLeftovers));
	}
	
	public int getNumberOfMealsByDifficulty(Integer difficulty) {
		return mealParameterMap.get(difficulty).getTotalNumberOfMeals();
	}
	
	public int getNumberOfMealsWithLeftoversByDifficulty(Integer difficulty) {
		return mealParameterMap.get(difficulty).getMealsWithLeftovers();
	}
	
	public List<Integer> getDifficultyValues() {
		List<Integer> difficultyList = new ArrayList<Integer>();
		for (Map.Entry<Integer, MealMetadata> entry : mealParameterMap.entrySet()) {
			difficultyList.add(entry.getKey());
		}
		return difficultyList;
	}
	
	private class MealMetadata {
		private int totalNumberOfMeals;
		private int mealsWithLeftovers;
		
		MealMetadata(int totalNumberOfMeals, int mealsWithLeftovers) {
			this.totalNumberOfMeals = totalNumberOfMeals;
			this.mealsWithLeftovers = mealsWithLeftovers;
		}
		
		public int getTotalNumberOfMeals() {
			return totalNumberOfMeals;
		}
		
		public int getMealsWithLeftovers() {
			return mealsWithLeftovers;
		}
	}
}