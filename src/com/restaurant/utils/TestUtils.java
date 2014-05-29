package com.restaurant.utils;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

import com.restaurant.controller.BestPriceController;

public class TestUtils {

	
	public  static void testCase1(){
		String fileName = "sample_data.csv";
		List<String> input = Arrays.asList(new String[]{"burger","tofu_log"});
		String expected = "2, 10.5";
	
		execute(fileName,input,expected);
	}
	
	public  void testCase2(){
		String fileName = "sample_data.csv";
		List<String> input = Arrays.asList(new String[]{"burger","tofu_log"});
		String expected = "2, 10.5";
		
		execute(fileName,input,expected);
	}
	
	
	public  void testCase3(){
		String fileName = "sample_data.csv";
		
		List<String> input = Arrays.asList(new String[]{"fancy_european_water","extreme_fajita"});
		String expected = "6, 11.0";
		execute(fileName,input,expected);
	}
	
	
	public  void testCase4(){
		String fileName = "sample_data_7.csv";
		List<String> input = Arrays.asList(new String[]{"burger","pepsi","momo","chowmien"});
		String expected = "1, 7.0";
		
		execute(fileName,input,expected);
	}
	
	
	public  void testCaseBig1(){
		String fileName = "jurgensville_testcase_83694.csv";
		List<String> input = Arrays.asList(new String[]{"wada","chicken","dosa","wine"});
		String expected = "1, 2.0";
		
		execute(fileName,input,expected);
	}
	
	public  void testCaseBig2(){
		String fileName = "jurgensville_testcase_14035.csv";
		List<String> input = Arrays.asList(new String[]{"fish","khichdi","wada","chicken"});
		String expected = "Nil";
		
		execute(fileName,input,expected);
	}
	
	public  void testCaseBig3(){
		String fileName = "jurgensville_testcase_26638.csv";
		List<String> input = Arrays.asList(new String[]{"uttapam","puri","chicken"});
		String expected = "2, 2.0";
		
		execute(fileName,input,expected);
	}
	
	@Test
	public  void  test() {
		// TODO Auto-generated method stub
		
		//Small Files
		testCase1();
		//testCase2();
		//testCase3();
		//testCase4();
		
		// Big Files
		//testCaseBig1();
		//testCaseBig2();
		//testCaseBig3();
	}
	
	public static void execute( String fileName, List<String> input, String expected){
		 String actual=BestPriceController.execute(fileName, input);
		Assert.assertEquals(expected, actual);
	}
}
