# First Project Created to learn Cucumber from Command Line

###### Learnings used in the Project
1. Ways to get help from the Cucumber Main class
2. Create skeleton for the feature file
3. Run the code with Tags (used in feature/demo.feature)
4. Use of Datatable in the Feature file and Datatable is not editable (used in Tic-Tac-Toe example)
	- If raw() method of the DataTable is used to put values into a List<List<String>> then the values of the List will not be editable
	- To edit the variable for a DataTable that has to be done in below way :
	```
	List<List<String>> board = new ArrayList<List<String>>();
	for(List<String> row : dataTable.raw()) {
		board.add(new ArrayList<String>(row));
	}

	```
5. Cucumber DataTable Assertion can be done by below code :
`expectedTable.diff(board);`
6. Use of Transformer Class (Used in Bank and Teller Example)
	```
	public class MoneyConverter extends Transformer<Money> {
    
		public Money transform(String amount) {
			//Write some code here and return object of Money
 		}
	}
	```
7. Use of Helper class (used in Teller examle - KnowsTheDomain class)

