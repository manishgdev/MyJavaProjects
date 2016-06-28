package transforms;

import cucumber.api.Transformer;
import support.Money;

/**
* This class uses the Cucumber Transform mechanism to convert the input parameter into an understandable object
*
*
*/
public class LongTransformer extends Transformer<Integer> {
    
    public Integer transform(String amount) {
        return 0;
    }
    
}
