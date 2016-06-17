package support;

public class Money {
    
    private int dollars;
    private int cents;
    
    public Money() {
        this.dollars = 0;
        this.cents = 0;
    }
    
    public Money(Money amount) {
        this.dollars = amount.getDollars();
        this.cents = amount.getCents();
    }
    
    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }
    
    public int getDollars() {
        return dollars;
    }
    
    public int getCents() {
        return cents;
    }
    
    public void add(Money amount) {
        dollars += amount.dollars;
        cents += amount.cents;
        if(cents > 100) {
            dollars = dollars + 1;
            cents = cents - 100;
        }
    }
    
    public void minus(Money amount) {
        dollars -= amount.dollars;
        cents -= amount.cents;
        if(cents < 0) {
            dollars = dollars - 1;
            cents = cents + 100;
        }
    }
    
    public boolean equals(Object obj) {
        System.out.println("Equality Method called for Money class");
        boolean result = false;
        if(obj instanceof Money) {
            Money that = (Money)obj;
            if(this.dollars == that.dollars && this.cents == that.cents)
                result = true;
        }
        return result;
    }
    
    public String toString() {
        String result = "$"+dollars+"."+cents;
        return result;
    }
}