package fam.poiry.GroceryApp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class App 
{
	private static int numOfDays = 7;
	
    public static void main( String[] args )
    {
    	//setNumberOfDaysForWhichToGenerateMeals(7);
    	GroceryList list = new GroceryList();
    	list.addGroceryListItem(new Ingredient("Chicken"));
    	list.addGroceryListItem(new Ingredient("Beef"));
    	list.addGroceryListItem(new Ingredient("Tomato"));
    	list.addGroceryListItem(new Ingredient("Lettuce"));
    	list.addGroceryListItem(new Ingredient("Egg"));
    	list.addGroceryListItem(new Ingredient("Bacon"));
    	list.addGroceryListItem(new Ingredient("Tortilla"));
    	list.addGroceryListItem(new Ingredient("Bean"));
    	list.addGroceryListItem(new Ingredient("Bun"));
    	list.addGroceryListItem(new Ingredient("Cheese"));
    	list.addGroceryListItem(new Ingredient("Gnochi"));
    	list.addGroceryListItem(new Ingredient("Spaghetti"));
    	list.addGroceryListItem(new Ingredient("Marinara Sauce"));
    	list.addGroceryListItem(new Ingredient("French Fries"));
    	list.addGroceryListItem(new Ingredient("Fish"));
    	list.addGroceryListItem(new Ingredient("Biscuits"));
    	list.addGroceryListItem(new Ingredient("Corn Bread Mix"));
    	list.addGroceryListItem(new Ingredient("Flour"));
    	list.addGroceryListItem(new Ingredient("Sugar"));
    	list.addGroceryListItem(new Ingredient("Butter"));
    	list.addGroceryListItem(new Ingredient("Milk"));
    	list.addGroceryListItem(new Ingredient("Salt"));
    	list.addGroceryListItem(new Ingredient("Pepper"));
    	list.addGroceryListItem(new Ingredient("Vanilla"));
    	list.addGroceryListItem(new Ingredient("Dressing"));
    	
    	
    	List<Meal> mealList = new ArrayList<Meal>();
    	mealList.add(new Meal("Pizza", 1, false));
    	mealList.add(new Meal("Greek Pizza", 3, false));
    	mealList.add(new Meal("Burgers", 2, false));
    	mealList.add(new Meal("Tacos", 2, false));
    	mealList.add(new Meal("Taco Soup", 2, false));
    	mealList.add(new Meal("Chicken Wraps", 2, false));
    	mealList.add(new Meal("Chicken Ceasar Salad", 2, false));
    	mealList.add(new Meal("Soup and Sandwiches", 1, false));
    	mealList.add(new Meal("Spaghetti", 1, false));
    	mealList.add(new Meal("Beans and Cornbread", 2, false));
    	mealList.add(new Meal("Pesto Chicken w/Gnochi", 3, false));
    	mealList.add(new Meal("Chicken and Fries", 1, false));
    	mealList.add(new Meal("Chicken and Waffles", 3, false));
    	mealList.add(new Meal("Breakfast", 3, false));
    	mealList.add(new Meal("Fish and Chips", 1, false));
    	
    	//printMealList(createRandomMealList(mealList, false));
    	//printMealList(createEquallyWeightedMealList(mealList, false));
    	MealListParameters params = new MealListParameters();
    	params.addMealDifficultyParameter(1, 4, 0);
    	params.addMealDifficultyParameter(2, 2, 0);
    	params.addMealDifficultyParameter(3, 1, 0);
    	//printMealList(createArbitraryMealList(mealList, false, params));
    	
    	Meal testMeal = new Meal("Breakfast", 3, false);
    	
    	Ingredient eggs = new Ingredient("Eggs");
    	eggs.setMeasurement(Ingredient.Measurement.SELF);
    	eggs.setAmount(new Fraction(5));
    	
    	Ingredient bacon = new Ingredient("Bacon");
    	bacon.setMeasurement(Ingredient.Measurement.OZ);
    	bacon.setAmount(new Fraction(8));
    	
    	Ingredient biscuits = new Ingredient("Biscuits");
    	biscuits.setMeasurement(Ingredient.Measurement.LBS);
    	biscuits.setAmount(new Fraction(1));
    	
    	testMeal.addIngredient(eggs);
    	testMeal.addIngredient(bacon);
    	testMeal.addIngredient(biscuits);
    	
    	Set<Ingredient> testSet = new HashSet<Ingredient>();
    	testSet.add(eggs);
    	testSet.add(biscuits);
    	testSet.add(bacon);
    	
    	JSONReaderWriter.printJSONObject(testSet);
    	
    	for (Ingredient returnVal : testMeal.getIngredient()) {
    		System.out.println(returnVal.getIngredientName());
    	}
    	
    	JSONReaderWriter.printJSONObject(testMeal);
    }
    
    public static void printMealList(List<Meal> mealList) {
    	for (Meal meal : mealList) {
    		System.out.println(meal.getMealName());
    	}
    }
    
    public static List<Meal> createRandomMealList(List<Meal> mealList, boolean allowRepeats) {
    	List<Meal> randomMealList = new ArrayList<Meal>();
    	Random random = new Random();
    	
    	if (allowRepeats) {
    		for (int i = 0; i < numOfDays; i++) {
    			randomMealList.add(mealList.get(random.nextInt(mealList.size())));
    		}
    	} else {
    		Set<Integer> usedInts = new HashSet<Integer>();
    		for (int i = 0; i < numOfDays; i++) {
    			int x = random.nextInt(mealList.size());
    			
    			while (usedInts.contains(x)) {
    				x = random.nextInt(mealList.size());
    			}
    			
    			randomMealList.add(mealList.get(x));
				usedInts.add(x);
    		}
    	}
    	
    	return randomMealList;
    }
    
    public static List<Meal> createEquallyWeightedMealList(List<Meal> fullMealList, Set<Integer> difficultySet, boolean allowRepeats) {
    	List<Meal> weightedMealList = new ArrayList<Meal>();
    	Random random = new Random();
    	
    	Set<Integer> intSet = new HashSet<Integer>();
		
		Set<Integer> testSet = difficultySet;
		
    	if (allowRepeats) {	
    		for (int i = 0; i < numOfDays; i++) {
    			int x = random.nextInt(fullMealList.size());
    			
    			while (intSet.contains(fullMealList.get(x).getEaseOfPreparation())) {
    				x = random.nextInt(fullMealList.size());
    				
    				if (intSet.containsAll(testSet)) {
    					intSet.clear();
    				}
    			}
    				
    			weightedMealList.add(fullMealList.get(x));
    			intSet.add(fullMealList.get(x).getEaseOfPreparation());
    		}
    	} else {
    		Set<Integer> usedInts = new HashSet<Integer>();
    		for (int i = 0; i < numOfDays; i++) {
    			int x = random.nextInt(fullMealList.size());
    			
    			while (intSet.contains(fullMealList.get(x).getEaseOfPreparation()) || usedInts.contains(x)) {
    				x = random.nextInt(fullMealList.size());
    				
    				if (intSet.containsAll(testSet)) {
    					intSet.clear();
    				}
    			}
    				
    			weightedMealList.add(fullMealList.get(x));
    			intSet.add(fullMealList.get(x).getEaseOfPreparation());
    			usedInts.add(x);
    		}
    	}
    	
    	return weightedMealList;
    }
    
    public static List<Meal> createArbitraryMealList(List<Meal> fullMealList, boolean allowRepeats, MealListParameters params) {
    	List<Meal> arbitraryMealList = new ArrayList<Meal>();
    	
    	for (Integer difficulty : params.getDifficultyValues()) {
    		for (Meal meal : createArbitraryMealListOfEaseX(fullMealList, allowRepeats, difficulty, params.getNumberOfMealsByDifficulty(difficulty))) {
        		arbitraryMealList.add(meal);
        	}
    	}
    	
    	return arbitraryMealList;
    }
    
    public static List<Meal> createArbitraryMealListOfEaseX(List<Meal> fullMealList, boolean allowRepeats, int easeValue, int numOfMeals) {
    	List<Meal> easeMealList = new ArrayList<Meal>();
    	Random random = new Random();
		
    	if (allowRepeats) {	
    		for (int i = 0; i < numOfMeals; i++) {
    			int x = random.nextInt(fullMealList.size());
    			
    			while (fullMealList.get(x).getEaseOfPreparation() != easeValue) {
    				x = random.nextInt(fullMealList.size());
    			}
    				
    			easeMealList.add(fullMealList.get(x));
    		}
    	} else {
    		Set<Integer> usedInts = new HashSet<Integer>();
    		for (int i = 0; i < numOfMeals; i++) {
    			int x = random.nextInt(fullMealList.size());
    			
    			while (fullMealList.get(x).getEaseOfPreparation() != easeValue || usedInts.contains(x)) {
    				x = random.nextInt(fullMealList.size());
    			}
    				
    			easeMealList.add(fullMealList.get(x));
    			usedInts.add(x);
    		}
    	}
    	
    	return easeMealList;
    }
    
    public static void setNumberOfDaysForWhichToGenerateMeals(int x) {
    	if (x > 0) {
    		numOfDays = x;
    	} else {
    		System.out.println("This must be a non-negative value");
    	}
    }
}
