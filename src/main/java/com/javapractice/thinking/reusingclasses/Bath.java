/**
 * 
 */
package com.javapractice.thinking.reusingclasses;

/**
 * @author Feng
 *
 */
class Soap {
	private String s;
	
	Soap() {
		System.out.println("Soap()");
		s = "constructed";
	}
	
	public String toString() {
		return s;
	}
}
public class Bath {
	// Initializing at point of definition -- first
	private String s1="Happy", s2="Happy", s3, s4;
	private Soap castille;
	private int i;
	private float toy;
	
	public Bath() {
		// -- third
		System.out.println(s1);
		System.out.println(i);
		System.out.println("Inside Bath()");
		s3 = "Joy";
		toy = 3.14f;
		castille = new Soap();
	}
	
	// Instance Initialization -- second
	{
		System.out.println(s1);
		i=47;
	}
	
	public String toString() {
		if(s4==null) {
			// Delayed initialization -- last
			s4 = "Joy";
		}
		String res = ""
				+ "s1=" + s1 + "\n"
				+ "s2=" + s2 + "\n"
				+ "s3=" + s3 + "\n"
				+ "s4=" + s4 + "\n"
				+ "i=" + i + "\n"
				+ "toy=" + toy + "\n"
				+ "castille=" + castille;
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bath b = new Bath();
		System.out.println(b);
	}

}
