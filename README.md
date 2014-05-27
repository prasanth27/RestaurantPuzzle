Jurgensville Restaurant Puzzle:
--------------------------------
Because it is the Internet Age, but also it is a recession, the Comptroller of the town of Jurgensville has decided to publish the prices of every item on every menu of every restaurant in town, all in a single CSV file (Jurgensville is not quite up to date with modern data serialization methods). In addition, the restaurants of Jurgensville also offer Value Meals, which are groups of several items, at a discounted price. The Comptroller has also included these Value Meals in the file. The file's format is:
 
for lines that define a price for a single item:
            restaurant ID, price, item_label
for lines that define the price for a Value Meal (there can be any number of items in a value meal)
            restaurant ID, price, item_1_label, item_2_label, ...
 All restaurant IDs are integers, all item labels are underscore(no space) separated letters, and the price is a decimal number.
 
Because you are an expert software engineer, you decide to write a program that accepts the town's price file, and a list of item labels that someone wants to eat for dinner, and outputs the restaurant they should go to, and the total price it will cost them.  It is okay to purchase extra items, as long as the total cost is minimized. If multiple restaurants are found, output any restaurant ID with the minimum price. DON'T OUTPUT ALL RESTAURANT IDs AND PRICEs. You can safely assume that SINGLE QUANTITY for any menu item will be asked by the user.
 
Please solve the puzzle above using the development language that you are being interviewed for.
We have seen many solutions that work for the attached data-set. However the solutions fail with many other data-sets we use to check the boundary conditions. Keeping this in mind, kindly assess all the possibilities, including but not limited to:
 
1. Menu directly available(1 item or all items).
2. Menu available but distributed over multiple items.
3. Menu need not be present in all restaurants listed.
4. Menu not available at all.
 
Here are some sample data sets, program inputs, and the expected result:
----------------------------
Data File data.csv
1, 4.00, burger
1, 8.00, tofu_log
2, 5.00, burger
2, 6.50, tofu_log
Program Input:
            program data.csv burger tofu_log
Expected Output:
            2, 11.5
----------------------------
----------------------------
Data File data.csv
3, 4.00, chef_salad
3, 8.00, steak_salad_sandwich
4, 5.00, steak_salad_sandwich
4, 2.50, wine_spritzer
Program Input
            program data.csv chef_salad wine_spritzer
Expected Output:
            Nil (to indicate that no matching restaurant could be found)
----------------------------
----------------------------
Data File data.csv
5, 4.00, extreme_fajita
5, 8.00, fancy_european_water
6, 5.00, fancy_european_water
6, 6.00, extreme_fajita, jalapeno_poppers, extra_salsa
Program Input:
            program data.csv fancy_european_water extreme_fajita
Expected Output:
            6, 11.0
----------------------------
We have included all these samples in the attached file, sample_data.csv.
 
 
IMPORTANT NOTE: Since we use a highly automated testing system, mandatorily stick to the following format for execution input and output. Deviation from them will result into rejection of your solution. Besides, do run and check your solution before sending to us. The solution must be complete in all respects and optimized to the best of your knowledge. Long processing time might as well result into rejection of the solution.
 
Input: $prompt$<executable> <script_name> <data.csv> <item1> <item2> ... (CSV name and items MUST BE command line output)
            e.g.
            $python script.py data.csv A B C
 
            or,
            $ruby script.rb data.csv A B C
 
            or,
            javac ProgramMain.java
            java ProgramMain
CSV file and items must be passed as command line arguments. Multiple item names must be provided space delimited and NOTHING ELSE like , or | etc.
 
Output: If a match found: Restaurant ID<space>Price. If not: Nil. Nothing else needs to be printed out. No decoration and articulated representation. No additional information at all needs to be printed out. For your reference:
 
Correct:
            1<space>2.50 (Same line, space separated values just.)
 
            or,
            Nil
Wrong:
            Restaurant ID: 1, Price: 2.50,
 
            or,
            Restaurant ID: 1
            Price: 2.50 ,
 
            or,
            ###
            Program start
        Items requested: [item1, item2]
        Available in restaurants: [1, 2]
            1, 2.50
            ###
            Program End
           
Follow the following format in your reply to the puzzle mail:
 
Development Language Used: (Python/Java/Ruby)
Main Script (in case of package with multiple files): (my_script_name.py/jurgensville_restaurant_solution.rb/AnyRandomName.java)
Run Instruction(In case of any deviation from the asked format): command_line_execution_example