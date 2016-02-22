/**
 * 
 */
package com.javapractice.thinking.reusingclasses;

/**
 * @author Feng
 *
 */
class Game {
	Game(int i) {
		System.out.print("Game constructor");
	}
}
class BoardGame extends Game {
	BoardGame(int i) {
		super(i);
		System.out.print("BoardGame constructor");
	}
}
public class Chess extends BoardGame {
	// Exercise 6
	Chess() {
		super(11);
		System.out.print("Chess constructor");
	}
	public static void main(String[] args) {
		Chess x = new Chess();
	}
}
