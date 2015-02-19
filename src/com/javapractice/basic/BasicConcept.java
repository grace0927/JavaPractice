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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConcept test = new BasicConcept();
		test.stringhash();
	}

}
