/**
 * 
 */
package com.javapractice.thinking.reusingclasses;

/**
 * @author Feng
 *
 */
class Instrument {
	public void play() {}
	static void tune(Instrument i) {
		i.play();
	}
}
public class Wind extends Instrument {
	public static void main(String[] args) {
		Wind flute = new Wind();
		Instrument.tune(flute); // Upcasting
	}
}
