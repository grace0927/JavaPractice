/**
 * 
 */
package com.javapractice.thinking.polymorphism;

/**
 * @author Feng
 *
 */
public class Hamster extends Rodent {
	@Override
	public void eat(String s) {
		System.out.println("Hamster eat " + s);
	}
}
