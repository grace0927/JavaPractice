/**
 * 
 */
package com.javapractice.thinking.initializationcleanup;

/**
 * @author Feng
 *
 */
public class Tank {

	boolean filled;
	
	protected void finalize() {
		if(filled) {
			System.out.println("not empty");
		}
	}
	
	public void fill() {
		this.filled = true;
	}
	
	public void empty() {
		this.filled = false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Tank();
		new Tank().fill();
		System.gc();
		System.runFinalization();
	}

}
