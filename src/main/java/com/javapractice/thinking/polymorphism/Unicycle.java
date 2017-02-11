/**
 * 
 */
package com.javapractice.thinking.polymorphism;

/**
 * @author Feng
 *
 */
public class Unicycle extends Cycle {

	public String toString() {
		return "Unicycle";
	}
	
	@Override
	public int wheels() {
		return 1;
	}
}
