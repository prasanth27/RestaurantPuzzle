package com.restaurant.model;

import java.util.HashSet;
import java.util.Set;


public class Meal {
	private Float price ;
	private Set<String> items;
	private int hotelID;
	
	public Meal() {
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean containsItem(String dish){
		return items.contains(dish.trim());
	}
	
	public boolean containsAllItems(Set<String> dishes){
		return items.containsAll(dishes) ;
	}
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = new Float(price);
	}
	public Set<String> getItems() {
		return items;
	}
	public void setItems(Set<String> items) {
		this.items = items;
	}
	public void addItemToMeal(String s){
		if(items == null)
			items = new HashSet<String>();
		items.add(s);
		
	}
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(String hotelID) {
		this.hotelID = Integer.parseInt(hotelID);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return items.hashCode()+hotelID+price.hashCode();
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0 instanceof Meal){
			Meal meal = (Meal)arg0;
			return ( (meal.getItems().equals(this.items)) && (meal.getHotelID() == this.hotelID)&& (meal.getPrice().equals(this.getPrice())));
		}
		return false;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{ id:"+hotelID+" ,price:"+price+" , items:"+items.toString()+ "}";
	}
}
