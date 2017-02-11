/**
 * 
 */
package com.javapractice.thinking.accesscontrol;

import com.javapractice.thinking.initializationcleanup.Connection;
import com.javapractice.thinking.initializationcleanup.ConnectionManager;

/**
 * @author Feng
 *
 */
class One {
	protected int a = 1;
}

public class AccessControl {
	protected int a;
	
	public static void main(String[] args) {
		One a = new One();
		System.out.println(a.a);
		Connection conn = ConnectionManager.getConnection();
		while(conn != null) {
			conn.print();
			conn = ConnectionManager.getConnection();
		}
	}
}
