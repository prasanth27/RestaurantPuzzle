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
	public static String execute(String fileName, List<String> searchItems){
		// Filter Items based on search criteria
		 MealMaker m = new MealMaker();	
		 CsvReader.parseFileFilterInput(fileName, searchItems,m);
		
		// Create HotelWise Menu of Meals
		Map <Integer, Set<Meal>> hotelVsMealMap = m.getHotelMenus();
		
		// Make Combo Items and Select the Best Meal
		ComboMealMaker cb = new ComboMealMaker();
		String bestDeal = cb.getBestDeal(hotelVsMealMap, searchItems) ;
		return bestDeal;
		
	}
}
