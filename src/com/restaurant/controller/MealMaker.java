package com.restaurant.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.restaurant.model.Meal;

public class MealMaker {
	
	public MealMaker( List<String> searchItems) {
		// TODO Auto-generated constructor stub
		this.searchItemsRequired.addAll(searchItems);
	}
	
	private Map <Integer, Set<Meal>> hotelMenu = new HashMap<Integer, Set<Meal>>() ;
	private Map<Integer,Set<String>> searchItemsPresent = new HashMap<Integer,Set<String>>();
	private Set<String> searchItemsRequired = new HashSet<String>();
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
	
	public Map <Integer, Set<String>> getItemsInHotel(){
		return searchItemsPresent;
	}
	
	private  Meal splitStringToMakeMeal(String[] items){
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
						String s = items[i].trim();
						m.addItemToMeal(s);
						if(searchItemsRequired.contains(s)){
							if( ! searchItemsPresent.containsKey(m.getHotelID())){
									Set<String> set =	new HashSet();
									set.add(s);
									searchItemsPresent.put(m.getHotelID(), set);
							}else{
									searchItemsPresent.get(m.getHotelID()).add(items[i].trim());
							}
						}
						break;
			}
		}
		return m;
	}
	
}
