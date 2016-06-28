package support;

public class Teller {
	
	private Account myAccount;
	private CashSlot cashSlot;
	
	public Teller() {
		this.cashSlot = new CashSlot();
	}
	
	public Teller(CashSlot cashSlot) {
		this.cashSlot = cashSlot;
	}
	
	public void withdrawFrom(Account account, int dollars) {
		myAccount = account;
		Money tmpMoney = new Money(dollars, 0);
		myAccount.withdraw(tmpMoney);
		
		cashSlot.dispense(dollars);
		
	}
	
	
}
