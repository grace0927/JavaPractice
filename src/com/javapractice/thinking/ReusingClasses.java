/**
 * 
 */
package com.javapractice.thinking;

import java.util.Random;

/**
 * @author Feng
 *
 */
public class ReusingClasses {

	// Exercise 1
	Tank tank;
	private void lazyInitialTank() {
		if(tank==null) {
			tank = new Tank();
		}
	}
	
	// Exercise 18
	static final int a = getInt();
	final int b = getInt();
	static int getInt() {
		return new Random().nextInt();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Exercise 3 & 5
		NewDetergent det = new NewDetergent();
		// Exercise 13
		det.dilute();
		det.dilute(1);
		det.dilute(1f);
		det.dilute("1.String");
		
		// Exercise 16 & 17
		Amphibian a = new Frog();
		a.hi();
		
		ReusingClasses test = new ReusingClasses();
		System.out.println(test.a);
		System.out.println(test.b);
		ReusingClasses test1 = new ReusingClasses();
		System.out.println(test1.a);
		System.out.println(test1.b);
	}

}
