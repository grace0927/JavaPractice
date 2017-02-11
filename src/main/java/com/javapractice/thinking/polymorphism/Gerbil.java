/**
 * 
 */
package com.javapractice.thinking.polymorphism;

/**
 * @author Feng
 *
 */
public class Gerbil extends Rodent {
	@Override
	public void eat(String s) {
		System.out.println("Gerbil eat " + s);
	}
}
