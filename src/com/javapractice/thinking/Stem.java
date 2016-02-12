/**
 * 
 */
package com.javapractice.thinking;

/**
 * @author Feng
 *
 */
public class Stem extends Root{
	public Component1 a = new Component1(1);
	public Stem(int i) {
		super(i);
		System.out.println("stem");
	}
	public void dispose() {
		a.dispose();
		super.dispose();
	}
}
