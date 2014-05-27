package com.restaurant.controller;

import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.restaurant.model.Meal;
import com.restaurant.utils.CsvReader;
import com.restaurant.utils.Logger;

public class BestPriceController {

/**
 * 	Finds the Most Economic Restaurant 
 */
	public static void execute(String fileName, List<String> searchItems){
		// Filter Items based on search criteria
		//long t1 = System.currentTimeMillis();
		List<String> filteredItems =  CsvReader.parseFileFilterInput(fileName, searchItems);
		
		// Create HotelWise Menu of Meals
		Map <Integer, Set<Meal>> hotelVsMealMap = MealMaker.createMenuFromInputs(filteredItems);
		
		// Make Combo Items and Select the Best Meal
		ComboMealMaker cb = new ComboMealMaker();
		String bestDeal = cb.getBestDeal(hotelVsMealMap, searchItems) ;
		System.out.println(bestDeal);
		//long t2 = System.currentTimeMillis();
		//System.out.println(t2-t1);
		
	}
}
