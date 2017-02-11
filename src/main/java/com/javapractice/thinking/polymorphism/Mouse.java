/**
 * 
 */
package com.javapractice.thinking.polymorphism;

/**
 * @author Feng
 *
 */
public class Mouse extends Rodent {
	@Override
	public void eat(String s) {
		System.out.println("Mouse eat " + s);
	}
}
