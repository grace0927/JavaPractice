/**
 * 
 */
package com.javapractice.thinking;

/**
 * @author Feng
 *
 */
public class ConnectionManager {
	private static int cnt = 0;
	private static int total = 5;
	private static Connection[] pool = new Connection[total];
	
	static {
		pool = new Connection[total];
		for(int i=0; i<total; i++) {
			pool[i] = new Connection();
		}
	}
	
	public static Connection getConnection() {
		if(cnt==total) {
			return null;
		}
		cnt++;
		return pool[cnt-1];
	}
}
