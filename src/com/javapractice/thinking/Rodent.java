/**
 * 
 */
package com.javapractice.thinking;

/**
 * @author Feng
 *
 */
public class Rodent {
	public void eat(String s) {
		System.out.println("Rodent eat " + s);
	}
	
	public void eatAll(String[] s) {
		System.out.println("Rodent start");
		for(String str:s) {
			eat(str);
		}
	}
}
