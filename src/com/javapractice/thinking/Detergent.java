/**
 * 
 */
package com.javapractice.thinking;

/**
 * @author Feng
 *
 */
class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }
    public static void main(String[] args) {
    	Cleanser x = new Cleanser();
  		x.dilute(); x.apply(); x.scrub();
  		System.out.print(x);
    } 
}

public class Detergent extends Cleanser{
	public Detergent(int i) {
		System.out.println("Detergent Construct");
	}
	
	Cleanser cleanser = new Cleanser();
	public void dilute() {
		cleanser.dilute();
	}
	
	public void dilute(int i) {
		System.out.println("int");
	}
	
	public void dilute(float i) {
		System.out.println("float");
	}
	
	// Change a method:
    public void scrub() {
      append(" Detergent.scrub()");
      super.scrub(); // Call base-class version
    }
    // Add methods to the interface:
    public void foam() { append(" foam()"); }
    // Test the new class:
    public static void main(String[] args) {
      Detergent x = new Detergent(1);
      x.dilute();
      x.apply();
      x.scrub();
      x.foam();
      System.out.print(x);
      System.out.print("Testing base class:");
      Cleanser.main(args);
    }
}
