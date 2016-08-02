package com.manish.equalitytest;

public class EqualTest {
	public static void main(String args[]) {
		String a = new String("abc");
		String b = new String("abc");
		String c = a;
		String d = "abc";
		System.out.println("String a = new String(\"abc\");" +
                "\nString b = new String(\"abc\");" +
                "\nString c = a;" +
                "\nString d = \"abc\";\n");

		System.out.println("a == b : "+ (a == b));
		System.out.println("a == c : "+ (a == c));
		System.out.println("a == d : "+ (a == d));
		System.out.println("a.equals(b) : "+ a.equals(b));
		System.out.println("a.equals(c) : "+ a.equals(c));
		System.out.println("a.equals(d) : "+ a.equals(d));
	}
}
