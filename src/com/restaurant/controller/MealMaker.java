package com.restaurant.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.restaurant.model.Meal;

public class MealMaker {
	
	/**
	 *  Parse inputs and make Menu
	 * @param keyWords
	 * @return Menu Map
	 */
	public static Map <Integer, Set<Meal>> createMenuFromInputs(List<String> keyWords){
		Map <Integer, Set<Meal>> hotelMenu = new HashMap<Integer, Set<Meal>>() ;
		for(String item : keyWords){
			String[] items  = item.split(",");
			Meal meal = splitStringToMakeMeal(items);
			
			Integer hotelID = new Integer(items[0]);
			if(hotelMenu.containsKey(hotelID)){
				Set<Meal> dishes = hotelMenu.get(hotelID) ;
				dishes.add(meal);
			}else{
				Set<Meal> dishes = new HashSet<Meal>();
				dishes.add(meal);
				hotelMenu.put(hotelID, dishes);
			}
		}
		return hotelMenu;
	}
	
	private static Meal splitStringToMakeMeal(String[] items){
		Meal m = new Meal();
		for(int i=0;i<items.length;i++){
			switch(i){
				case 0 :
						m.setHotelID(items[i]) ;
						break;
				case 1 :
						m.setPrice(items[i]);
						break;
				default:
						m.addItemToMeal(items[i]);
						break;
			}
		}
		return m;
	}
	
}
