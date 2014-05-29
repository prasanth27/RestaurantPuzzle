

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.restaurant.controller.BestPriceController;
import com.restaurant.utils.Logger;

public class BestPrice{

	/**
	 * Returns the Most Economic Restaurant In your City
	 * @param args [0] CSV file
	 * @param args [1]  item1
	 * @param args [2]  item2   
	 * @return Restaurant_id,Price 
	 */
	public static void main(String[] args) {
		List<String> input = new ArrayList<String>(Arrays.asList(args));
		int inputLength = input.size();
		if(inputLength < 2){
			System.out.println("Please check input");
			return ;
		}
		String fileName = input.remove(0);
		String result = BestPriceController.execute(fileName, input);
		System.out.println(result);
	}
}
