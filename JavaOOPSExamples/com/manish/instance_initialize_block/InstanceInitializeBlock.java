package com.manish.instance_initialize_block;

public class InstanceInitializeBlock {
	{
		System.out.println("This will get executed on every instance creation of this class");
	}

	public InstanceInitializeBlock() {
		System.out.println("Constructor Invoked"); // This will be executed after Instance Initialize Block
	}

	public void display() {
		System.out.println("Displaying Message from class method");
	}

	public static void main(String args[]) {
		InstanceInitializeBlock iib = new InstanceInitializeBlock();

		iib.display();
	}
}
