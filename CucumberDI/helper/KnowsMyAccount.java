package helper;

import support.Account;
import support.CashSlot;
import support.Teller;

/**
 * This is a simple way of creating Helper in the Cucumber project
 * Used to return instance of All the classes which will be shared amoung the Projects
 */
public class KnowsMyAccount {
	
	private Account myAccount;
	private CashSlot cashSlot;
	private Teller teller;
	
	public Account getMyAccount() {
		if(myAccount == null) 
			myAccount = new Account();
		return myAccount;
	}
	
	public Teller getTeller() {
		if (teller == null)
			teller = new Teller(getCashSlot());
		return teller;
	}
	
	public CashSlot getCashSlot() {
		if(cashSlot == null)
			cashSlot = new CashSlot();
		return cashSlot;
	}
}
