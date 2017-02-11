/**
 * 
 */
package com.javapractice.thinking.reusingclasses;

/**
 * @author Feng
 * Reusing Classes Exercise 2
 *
 */
public class NewDetergent extends Detergent {
	
	private BDetergent tank = new BDetergent(1);
	
	// Exercise 7
	public NewDetergent() {
		super(1);
	}
	
	// Exercise 8
	public NewDetergent(int i) {
		super(i);
	}
	
	@Override
	public void scrub() {
		append("NewDetergent scrub");
		super.scrub();
	}
	
	public void dilute(String a) {
		System.out.println("String");
	}
	
	public void sterilize() {
		append("NewDetergent sterilize");
	}
}
