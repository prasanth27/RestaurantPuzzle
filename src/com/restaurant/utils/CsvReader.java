package com.restaurant.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CsvReader {
	/**
	 * Reads file and returns Strings which contain any of the KeyWords.
	 * @param fileName
	 * @param keyWords
	 * @return Map of hotel vs Items
	 */
	public static  List<String> parseFileFilterInput(String fileName , List<String> keyWords ){
		
	  List<String> relatedItems =   new ArrayList<String>();
		File file = new File(fileName);
		FileInputStream fstream;
		
		try {
			fstream = new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			while ((strLine = br.readLine()) != null)   {
			  if(isContainsSerchItem(strLine, keyWords)){
				  populateMapWithSearchItems(relatedItems ,strLine);
			  }
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return relatedItems;
	}
	
	
	public static boolean isContainsSerchItem(String line , List<String>keywords){
		for(String word:keywords){
			if(line.contains(word.trim()))
				return true;
		}
		return false;
	}
	
	
	/**
	 * Populates the map with items in the Search Query.
	 * @param relatedItems
	 */
	public static void populateMapWithSearchItems( List<String> relatedItems , String strLine){
		relatedItems.add(strLine);
	}
	
}
