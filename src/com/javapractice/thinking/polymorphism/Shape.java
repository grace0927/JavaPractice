/**
 * 
 */
package com.javapractice.thinking.polymorphism;

/**
 * @author Feng
 *
 */
public class Shape {
	public void draw() {}
	public void erase() {}
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		Shape[] s = new Shape[9];
		for(int i = 0; i < s.length; i++)
			s[i] = gen.next();
		for(Shape shp : s)
			shp.draw();
	}
}
