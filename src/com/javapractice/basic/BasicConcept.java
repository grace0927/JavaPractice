/**
 * 
 */
package com.javapractice.basic;

/**
 * @author jianyu
 *
 */
public class BasicConcept {

	public void changeData(Integer a) {
		a = 10;
		System.out.println(a);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicConcept test = new BasicConcept();
		Integer a = new Integer(1);
		test.changeData(a);
		System.out.println(a);
	}

}
