/**
 * 
 */
package com.javapractice.designpatterns.simplefactory;

/**
 * @author feng
 *
 */
public class OperationFactory {

	public static Operation createOperation(char operator) {
		Operation opr = null;
		switch(operator) {
			case '+':
				opr = new OperationPlus();
				break;
			case '-':
				opr = new OperationSub();
				break;
			default:
				opr = new OperationPlus();
				break;
		}
		return opr;
	}
}
