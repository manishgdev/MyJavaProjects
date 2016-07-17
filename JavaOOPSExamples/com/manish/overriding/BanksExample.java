package com.manish.overriding;

public class BanksExample {
	public static void main(String args[]) {
		SBI s = new SBI();
		ICICI i = new ICICI();
		PNB p = new PNB();

		// SBI s2 = new Bank(); Bank cannot be converted to SBI
		Bank b = new SBI();

		System.out.println("SBI Rate of Interest = "+s.getInterest());
		System.out.println("PNB Rate of Interest = "+p.getInterest());
		System.out.println("ICICI Rate of Interest = "+p.getInterest());

		System.out.println("\nObject of Bank but instantiated with SBI");
		System.out.println("Bank's Rate of Interest = "+b.getInterest());
	}
}

class Bank {
	public int getInterest() {
		return 0;
	}
}

class SBI extends Bank {
        public int getInterest() {
                return 10;
        }
}

class PNB extends Bank {
        public int getInterest() {
                return 9;
        }
}

class ICICI extends Bank {
        public int getInterest() {
                return 7;
        }
}

