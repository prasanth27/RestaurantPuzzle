package com.restaurant.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.restaurant.model.Meal;

public class MealMaker {
	
	private Map <Integer, Set<Meal>> hotelMenu = new HashMap<Integer, Set<Meal>>() ;
	/**
	 *  Parse inputs and make Menu
	 * @param keyWords
	 * @return Menu Map
	 */
	public void createMenuFromInputs(String keyWord){
			String[] items  = keyWord.split(",");
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
	
	public Map <Integer, Set<Meal>> getHotelMenus(){
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
