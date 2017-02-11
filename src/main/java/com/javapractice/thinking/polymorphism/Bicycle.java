/**
 * 
 */
package com.javapractice.thinking.polymorphism;

/**
 * @author Feng
 *
 */
public class Bicycle extends Cycle {
	public String toString() {
		return "Bicycle";
	}
	
	@Override
	public int wheels() {
		return 2;
	}
}
