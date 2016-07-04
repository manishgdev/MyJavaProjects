package transforms;

import cucumber.api.Transformer;
import java.util.List;
import java.util.ArrayList;

public class NumberTransformer extends Transformer<List<Integer>> {
	//@Override
	public List<Integer> transform(String test) {
		List<Integer> numList = new ArrayList<Integer>();
		System.out.println("String to be converted : "+test);
		return numList;
	}

}
