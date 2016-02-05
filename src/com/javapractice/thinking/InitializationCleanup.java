/**
 * 
 */
package com.javapractice.thinking;

/**
 * @author Feng
 *
 */
public class InitializationCleanup {

	// Exercise 1
	String a;
	
	// Exercise 2
	String b;
	String c = "here";
	
	// Exercise 3 && Exercise 9
	public InitializationCleanup() {
		this("hello");
		b = "Hello";
	}
	
	// Exercise 4
	public InitializationCleanup(String b) {
		this.b = b;
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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
	}
}
