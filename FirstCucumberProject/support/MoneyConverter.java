package support;

import cucumber.api.Transformer;
/**
* This class uses the Cucumber Transform mechanism to convert the input parameter into an understandable object
*
*
*/
public class MoneyConverter extends Transformer<Money> {
    
    public Money transform(String amount) {
        String[] numbers = amount.split("\\.");
        int dollars = Integer.parseInt(numbers[0]);
        int cents = Integer.parseInt(numbers[1]);
        return new Money(dollars, cents);
    }
    
}