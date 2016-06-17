package support;

public class Account {
    
    private Money balance;
    
    public Account() {
        balance = new Money();
    }
    
    public Account(Money amount) {
        balance = new Money(amount);
    }
    
    public void deposit(Money amount) {
        balance.add(amount);    
    }
    
    public void withdraw(Money amount) {
        balance.minus(amount);
    }
    
    public Money getBalance() {
        return balance;
    }
}