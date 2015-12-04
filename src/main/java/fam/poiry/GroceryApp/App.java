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
    	params.addMealDifficultyParameter(1, 4);
    	params.addMealDifficultyParameter(2, 2);
    	params.addMealDifficultyParameter(3, 1);
    	printMealList(createArbitraryMealList(mealList, false, params));
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
    
    public static List<Meal> createEquallyWeightedMealList(List<Meal> fullMealList, boolean allowRepeats) {
    	List<Meal> weightedMealList = new ArrayList<Meal>();
    	Random random = new Random();
    	
    	Set<Integer> intSet = new HashSet<Integer>();
		
		Set<Integer> testSet = new HashSet<Integer>();
		testSet.add(1);
		testSet.add(2);
		testSet.add(3);
		
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
    	
    	for (Map.Entry<Integer, Integer> entry : params.getMealDifficultyMap().entrySet()) {
    		for (Meal meal : createArbitraryMealListOfEaseX(fullMealList, allowRepeats, entry.getKey(), entry.getValue())) {
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
