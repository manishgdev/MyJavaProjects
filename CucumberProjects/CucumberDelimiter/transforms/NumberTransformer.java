package transforms;

import cucumber.api.Transformer;

public class NumberTransformer extends Transformer<Integer> {
	@Override
	public Integer transform(String value) {
		System.out.println("String to be converted : "+value);
		return Integer.valueOf(value);
	}

}
