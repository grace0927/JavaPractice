/**
 * 
 */
package com.javapractice.thinking.polymorphism;

/**
 * @author Feng
 *
 */
public class Polymorphism {

	public static void ride(Cycle a) {
		System.out.println(a + " has " + a.wheels() + " wheels.");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ride(new Cycle());
		ride(new Unicycle());
		ride(new Bicycle());
		ride(new Tricycle());
		
		Rodent[] rodents = {new Rodent(), new Mouse(), new Gerbil(), new Hamster()};
		for(Rodent rodent:rodents) {
			rodent.eat("itself");
		}
		
		rodents[1].eatAll(new String[]{"meat", "ice cream"});
	}

}
