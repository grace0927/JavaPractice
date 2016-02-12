/**
 * 
 */
package com.javapractice.thinking;

/**
 * @author Feng
 *
 */
public class Root {
	public Component1 one = new Component1(1);
	public Root(int i) {
		System.out.println("root");
	}
	
	public void dispose() {
		one.dispose();
	}
}
