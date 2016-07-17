package com.manish.statics;

public class StaticMethod {
	int rollNo;
	String name;
	static String college="KJSIEIT";

	public StaticMethod(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}

	public static void change() {
		// Non-Static Variables cannot be accessed here
		college = "KJSV";
	}

	public static void main(String args[]) {
		StaticMethod s1 = new StaticMethod(50,"Ramesh");
		StaticMethod s2 = new StaticMethod(55, "Suresh");
		System.out.println("Student's detail before changing college of Ramesh");
		System.out.println("Student1 -> Roll No = "+s1.rollNo+", Name = '"+s1.name+"', College = '"+s1.college+"'");
		System.out.println("Student2 -> Roll No = "+s2.rollNo+", Name = '"+s2.name+"', College = '"+s2.college+"'");
		s1.change();
		System.out.println("Student's detail After changing college of Ramesh");
                System.out.println("Student1 -> Roll No = "+s1.rollNo+", Name = '"+s1.name+"', College = '"+s1.college+"'");
		System.out.println("Student2 -> Roll No = "+s2.rollNo+", Name = '"+s2.name+"', College = '"+s2.college+"'");
		System.out.println("\nAccess College Variable without object Name :- "+college);
	}
}
