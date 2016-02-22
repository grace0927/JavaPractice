/**
 * 
 */
package com.javapractice.thinking.initializationcleanup;

/**
 * @author Feng
 *
 */
// Exercise 20
enum Currency {
	PENNY, DOLLAR, EURO, YUAN, RMB, POUND
}

public class InitializationCleanup {

	// Exercise 1
	String a;
	
	// Exercise 2
	String b;
	String c = "here";
	
	// Exercise 3 && Exercise 9
	public InitializationCleanup() {
		this("hello");
		System.out.println(s3);
		b = "Hello";
	}
	
	// Exercise 4 && Exercise 17
	public InitializationCleanup(String b) {
		System.out.println(s3);
		this.b = b;
		System.out.println(b);
	}
	
	// Exercise 5
	public void bark(char a) {
		System.out.println(a);
	}
	public void bark(int b) {
		System.out.println(b);
	}
	
	// Exercise 6
	public void bark(char a, int b) {
		System.out.println(a + " " + b);
	}
	public void bark(int b, char a) {
		System.out.println(a + " " + b);
	}
	
	// Exercise 8
	public void first() {
		this.bark(1);
		bark(2);
	}
	
	// Exercise 10
	protected void finalize() {
		System.out.println("finalize()");
	}
	
	// Exercise 14
	static String s1 = new String("Hello");
	static String s2;
	static {
		s2 = "world";
	}
	static void printStatic() {
		System.out.println("start");
		System.out.println(s1+s2);
	}
	
	// Exercise 15
	String s3;
	{
		s3 = new String("s3: "+ "hi, instance initialization");
	}
	
	// Exercise 16
	String[] s = new String[]{"hi", "oho"};
	public void printS() {
		for(int i=0; i<s.length; i++) {
			System.out.println(s[i]);
		}
	}
	
	// Exercise 19
	public void practiceVararg(String... a) {
		for(String c:a) {
			System.out.println(c);
		}
	}
	
	// Exercise 20
	//public enum Currency {
	//	PENNY, DOLLAR, EURO, YUAN, RMB, POUND
	//}
	
	/**
	 * @param args
	 */
	public static void main(String... args) {
		// TODO Auto-generated method stub
		InitializationCleanup test = new InitializationCleanup();
		System.out.println(test.a);
		System.out.println(test.b);
		System.out.println(test.c);
		test.bark('a');
		test.bark(1);
		test.bark('a', 1);
		test.bark(1, 'a');
		test.first();
		System.out.println(test.s3);
		test.printS();
		
		// Exercise 11
		test = null;
		System.gc();
		System.runFinalization();
		
		InitializationCleanup.printStatic();
		InitializationCleanup[] t = new InitializationCleanup[2];
		
		//Exercise 18
		t[0] = new InitializationCleanup("one");
		t[1] = new InitializationCleanup("two");
		
		t[0].practiceVararg("a", "b");
		t[0].practiceVararg(new String[]{"c", "d"});
		
		// Exercise 20
		for(String arg:args) {
			System.out.println(arg);
		}
		
		for(Currency cur:Currency.values()) {
			System.out.println(cur+" "+cur.ordinal());
		}
		
		Currency a = Currency.DOLLAR;
		switch(a) {
			case DOLLAR:
				System.out.println("us");
				break;
			case RMB:
				System.out.println("cn");
				break;
			case PENNY:
			case EURO:
			case YUAN:
			case POUND:
				System.out.println("other");
				break;
		}
	}
}
