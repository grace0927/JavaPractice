/**
 * 
 */
package com.javapractice.thinking.reusingclasses;

/**
 * @author Feng
 *
 */
class Art {
	Art() {
		System.out.println("Art constructor");
	}
}

class Drawing extends Art {
	Drawing() {
		System.out.println("Drawing constructor");
	}
}

public class Cartoon extends Drawing {
	public Cartoon() {
		System.out.println("Cartoon constructor");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cartoon s = new Cartoon();
	}

}
