package com.restaurant.utils;
public class Logger {
	public static final boolean LOGGER = true;
	public static final boolean PRINT_FILE_CONTENTS = false;
	public static final boolean PRINT_ALL_COMBOS = true;
	public static final boolean PRINT_ALL_BEST_PRICE = true;
	
	
	public static void log(String s){
		log(s,true);
	}
	
	public static void log(String s, boolean enable){
		if(LOGGER && enable){
			System.out.println(s);
		}
	}
	
	public static void log(String header, String matter){
		log(header, matter,true);
	}
	
	public static void log(String header, String matter,boolean enable){
		if(LOGGER&&enable){
			System.out.println("------------------ **  ["+header+"]  **------------------");
			System.out.println(matter);
			System.out.println("---------------------------------------------------------------");
		}
	}
}
