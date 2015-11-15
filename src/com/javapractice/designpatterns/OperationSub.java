/**
 * 
 */
package com.javapractice.designpatterns;

/**
 * @author feng
 *
 */
public class OperationSub implements Operation {

	private double first;
	private double second;
	
	/* (non-Javadoc)
	 * @see com.javapractice.designpatterns.Operation#getResult()
	 */
	@Override
	public double getResult() {
		// TODO Auto-generated method stub
		return first-second;
	}

}
