package fam.poiry.GroceryApp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class App 
{
    public static void main( String[] args )
    {
        printMealList(false);
    }
    
    public static void printMealList(boolean allowRepeats) {
    	List<String> mealList = new ArrayList<String>();
    	mealList.add("Pizza");
    	mealList.add("Greek Pizza");
    	mealList.add("Burgers");
    	mealList.add("Tacos");
    	mealList.add("Taco Soup");
    	mealList.add("Chicken Wraps");
    	mealList.add("Chicken Ceasar Salad");
    	mealList.add("Soup and Sandwiches");
    	mealList.add("Spaghetti");
    	mealList.add("Beans and Cornbread");
    	mealList.add("Pesto Chicken w/Knochi");
    	mealList.add("Chicken and Fries");
    	mealList.add("Chicken and Waffles");
    	mealList.add("Breakfast");
    	mealList.add("Fish and Chips");
    	
    	Random random = new Random();
    	
    	if (allowRepeats) {
    		for (int i = 0; i < 7; i++) {
    			System.out.println(mealList.get(random.nextInt(mealList.size())));
    		}
    	} else {
    		Set<Integer> usedInts = new HashSet<Integer>();
    		for (int i = 0; i < 7; i++) {
    			int x = random.nextInt(mealList.size());
    			
    			while (usedInts.contains(x)) {
    				x = random.nextInt(mealList.size());
    			}
    			
    			System.out.println(mealList.get(x));
				usedInts.add(x);
    		}
    	}
    }
}
