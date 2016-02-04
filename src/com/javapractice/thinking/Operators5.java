/**
 * 
 */
package com.javapractice.thinking;

/**
 * @author Feng
 *
 */
public class Operators5 {
	static class Dog {
		String name;
		String says;
		public Dog(String name, String says) {
			this.name = name;
			this.says = says;
		}
	}
	
	public static void main(String[] args) {
		Dog one = new Dog("spot", "Ruff!");
		Dog two = new Dog("scruffy", "Wurf!");
		System.out.println(one.name + " " + one.says);
		System.out.println(two.name + " " + two.says);
		
		Dog ref = two;
		System.out.println(ref==two);
		System.out.println(ref.equals(two));
	}
}
