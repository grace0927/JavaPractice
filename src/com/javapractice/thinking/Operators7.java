/**
 * 
 */
package com.javapractice.thinking;

import java.util.Random;

/**
 * @author Feng
 *
 */
public class Operators7 {

	static boolean coin() {
		Random rand = new Random();
		return (rand.nextDouble()>0.5);
	}
	
	static void compare(String a, String b) {
		System.out.println(a==b);
		System.out.println(a.equals(b));
		System.out.println(a!=b);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			String res = "";
			if(coin()) {
				res = "head";
			} else {
				res = "tail";
			}
			System.out.println(res);
		}
		
		long hex = 0xf23f;
		long oct = 023412;
		System.out.println(Long.toBinaryString(hex));
		System.out.println(Long.toBinaryString(oct));
		
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Float.MAX_VALUE);
		System.out.println(Float.MIN_VALUE);
		
		int zero = 8;
		int one = 9;
		System.out.println(Integer.toBinaryString(zero&one));
		System.out.println(Integer.toBinaryString(zero|one));
		System.out.println(Integer.toBinaryString(zero^one));
		
		while(one>0) {
			System.out.println(Integer.toBinaryString(one));
			one >>= 1;
		}
		System.out.println();
		int s = 7;
		s <<= 1;
		while(s>0) {
			System.out.println(Integer.toBinaryString(s));
			s >>>= 1;
		}
		for(char a='a'; a<'z'; a++) {
			System.out.println(Integer.toBinaryString(a));
		}
		compare("hello", "world");
		compare("hello", "hello");
	}

}
