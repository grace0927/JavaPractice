/**
 * 
 */
package com.javapractice.thinking.polymorphism;

/**
 * @author Feng
 *
 */
public class Tricycle extends Cycle {

	public String toString() {
		return "Tricycle";
	}
	
	@Override
	public int wheels() {
		return 3;
	}
}
