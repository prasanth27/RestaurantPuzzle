package com.restaurant.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.restaurant.model.Meal;
import com.restaurant.utils.Logger;

public class ComboMealMaker {
	
	private  List<String> searchItems; 
	
	private float minPrice = Float.MAX_VALUE ;
	private int minId = -1;
	
	
	public String getBestDeal(Map <Integer, Set<Meal>> hotelVsMealMap , List<String> sItems){
		String result = "Nil";
		this.searchItems = sItems;
		
		Iterator<Integer> itr = hotelVsMealMap.keySet().iterator();
		while(itr.hasNext()){
			List<Meal> hotelMenu = new ArrayList<Meal>(hotelVsMealMap.get(itr.next()));
			findBestMeal(hotelMenu);
		}
		
		if( minId > 0){
			result =minId+", "+minPrice ;
			return result;
		}
		
		return result;
	}
	
	
	private void findBestMeal(List<Meal> menu){
		int numOfCombos = 1 << menu.size(); 
		//System.out.println("menus"+menu.size()+" and cominations "+numOfCombos);
		 for(int i = 0; i < numOfCombos; i++) {
			   
			 int pos = menu.size() - 1;
			 int bitmask = i;
			 
			   boolean [] itemsFound = new boolean [searchItems.size()];
			   int matches = 0;
			   float price = 0;
			   int hotelId = 0;
			   
			   while(bitmask > 0)	 {
					if((bitmask & 1) == 1){
						Meal meal = menu.get(pos);
						hotelId= meal.getHotelID();
						price += meal.getPrice();
						for(int j=0 ;  j < searchItems.size() && matches<searchItems.size(); j++){
							if( (!itemsFound[j]) &&
									(meal.containsItem(searchItems.get(j)))){
										itemsFound[j] = true;
										matches++;
							}
						}
				    }
				    bitmask >>= 1;
				    pos--;
			   }
			 
			   if(matches == searchItems.size() && price < minPrice){
				   minPrice = price;
				   minId = hotelId;
			   }
		 }
	}
	
}
