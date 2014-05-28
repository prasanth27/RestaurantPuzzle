package com.restaurant.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.restaurant.model.Meal;

public class ComboMealMaker {
	
	private  List<String> searchItems; 
	private ConcurrentHashMap<Integer, Float> hotelPrices ;
	
	private class HotelMinPriceChecker implements Runnable {
	
		private int hotelId ;	
		private List<Meal> menu;
		private boolean isItemFound = false;
		private float minPrice = Float.MAX_VALUE; 
		
		public HotelMinPriceChecker(List<Meal> menu , int hotelId) {
			// TODO Auto-generated constructor stub
			this.menu = menu;
			this.hotelId = hotelId;
		}
		
		public void run()  {
			int numOfCombos = 1 << menu.size(); 
			//System.out.println("hotel ="+Thread.currentThread().getName() + " Matching Items found = "+ menu.size()+" total combinations = "+numOfCombos);
			 for(int i = 0; i < numOfCombos; i++) {
				   
				 int pos = menu.size() - 1;
				 int bitmask = i;
				 
				   List<Integer> indicesRemaining = new ArrayList<Integer>(searchItems.size());
				   for(int j =0 ; j<searchItems.size();j++ ){
					   indicesRemaining.add(j);
				   }
				   
				   
				   float price = 0;
				   while(bitmask > 0)	 {
						if((bitmask & 1) == 1){
							Meal meal = menu.get(pos);
							price += meal.getPrice();
							
							if (indicesRemaining.size() > 0){
								Iterator< Integer> itr = indicesRemaining.iterator();
								while(itr.hasNext()){
									if(meal.containsItem(searchItems.get(itr.next()))){
										itr.remove();
									}
								}
							}
					    }
					    bitmask >>= 1;
					    pos--;
				   }
				 
				   if(indicesRemaining.size() == 0 && price <= minPrice){
					   minPrice = price;
					   isItemFound =true;
				   }
				   
			 }
			 
			 if(isItemFound){
				 hotelPrices.put(hotelId, minPrice);
			 }
		}
	}
	
	
	public String getBestDeal(Map <Integer, Set<Meal>> hotelVsMealMap , List<String> sItems){
		String result = "Nil";
		this.searchItems = sItems;
		this.hotelPrices = new  ConcurrentHashMap<Integer, Float>(sItems.size());
		
		Thread workerThreads[] = new Thread[hotelVsMealMap.size()];
		Iterator<Integer> itr = hotelVsMealMap.keySet().iterator();
		int count = 0;
		while(itr.hasNext()){
			Integer hotelID = itr.next();
			List<Meal> hotelMenu = new ArrayList<Meal>(hotelVsMealMap.get(hotelID));
			HotelMinPriceChecker hotel = new HotelMinPriceChecker(hotelMenu,hotelID);
			workerThreads[count] = new Thread(hotel,"Hotel-"+hotelID);
			workerThreads[count].start();
			count ++;
		}
		
		for(Thread t:workerThreads){
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int hotId=0 ;
		float minprice = Float.MAX_VALUE;
		Iterator<Integer> finalPrices = hotelPrices.keySet().iterator();
		while(finalPrices.hasNext()){
			int hID = finalPrices.next();
			float p  = hotelPrices.get(hID); 
			if( p <minprice){
				minprice = p;
				hotId =hID;
			}
		}
			
		if(hotId > 0){
			result = hotId+", "+minprice;
		}
		
		return result;
	}
}
