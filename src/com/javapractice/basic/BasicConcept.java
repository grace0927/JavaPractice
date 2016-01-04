/**
 * 
 */
package com.javapractice.basic;

import java.util.HashMap;

/**
 * @author jianyu
 *
 */
public class BasicConcept {
	/*
	 * basic concept about string
	 */
	public void calculateInteger() {
		int res = 0+(1-0)/2;
		System.out.println(res);
	}
	
	/*
	 * basic concept about string
	 */
	public void printString(String a) {
		System.out.println(a.substring(2, 3));
	}
	
	/*
	 * basic concept proving regarding local variables
	 */
	public void changeData(Integer a) {
		a = 10;
		System.out.println(a);
	}
	
	/*
	 * basic concept about hash map object
	 */
	public void stringhash() {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("hello", 1);
		HashMap<String, Integer> temp = new HashMap<>(map);
		System.out.println(temp.containsKey("hello"));
	}
	
	/*
	 * basic concept about XOR
	 */
	public void XOR() {
		boolean one = false;
		one ^= true;
		System.out.println(one);
		one ^= true;
		System.out.println(one);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConcept test = new BasicConcept();
		test.calculateInteger();
	}

}
