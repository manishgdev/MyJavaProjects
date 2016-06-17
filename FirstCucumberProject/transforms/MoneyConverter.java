package transforms;

import cucumber.api.Transformer;
import support.Money;

/**
* This class uses the Cucumber Transform mechanism to convert the input parameter into an understandable object
*
*
*/
public class MoneyConverter extends Transformer<Money> {
    
    public Money transform(String amount) {
        String[] numbers = amount.substring(1).split("\\.");
        int dollars = Integer.parseInt(numbers[0]);
        int cents = 0;
        if(numbers.length >= 2)
            cents = Integer.parseInt(numbers[1]);
        
        return new Money(dollars, cents);
    }
    
}