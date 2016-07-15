package demo;

import cucumber.api.java.en.*;
import cucumber.api.PendingException;
import java.util.Map;
import org.junit.*;
import cucumber.api.DataTable;
import java.util.List;
import java.util.ArrayList;

public class TicTacToe {

    private List<List<String>> board;
    
    @Given("^a board like this :$")
    public void a_board_like_this(DataTable emptyTable) throws Throwable {
        // board = emptyTable.raw(); 
        /* 
         * Above statement creates an uneditable DataTable
         * Editing which will give 
         * java.lang.UnsupportedOperationException
	     * at java.util.Collections$UnmodifiableList.set(Collections.java:1311)
         */
         System.out.println("Printing Empty Datatable : \n"+emptyTable.toString());
         System.out.println("Printing Empty Datatable : \n"+emptyTable);
         board = new ArrayList<List<String>>();
         for(List<String> row : emptyTable.raw()) {
			 board.add(new ArrayList<String>(row));
		 }
    }

    @When("^player x plays in row (\\d+), column (\\d+)$")
    public void player_x_plays_in_row_column(int row, int col) throws Throwable {
        System.out.println("Board Before updating : "+board.toString());
        board.get(row).set(col,"x");
        System.out.println("Board After updating : "+board.toString());
    }

    @Then("^the board should look like this:$")
    public void the_board_should_look_like_this(DataTable expectedTable) throws Throwable {
        // Below statement gives "cucumber.runtime.table.TableDiffException: Tables were not identical:"
        expectedTable.diff(board);
    }
    
}
