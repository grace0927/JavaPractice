/**
 * 
 */
package com.javapractice.thinking;

import java.util.Arrays;

/**
 * @author Feng
 *
 */
public class ControllingExecution {

	// Exercise 4
	static void primeGenerator(int n) {
		for(int i=2; i<=n; i++) {
			boolean flag = false;
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					flag = true;
				}
			}
			if(!flag) {
				System.out.println(i);
			}
		}
	}
	
	// Exercise 5
	static void printBinaryString(int a) {
		String res = "";
		while(a>0) {
			res = ((a&1)==1)?"1"+res:"0"+res;
			a>>=1;
		}
		System.out.println(res);
	}
	
	// Exercise 6
	static boolean isInRange(int target, int start, int end) {
		return (target>start && target<end);
	}
	
	// Exercise 9
	static void generateFibonacci(int n) {
		if(n<=0) {
			return ;
		}
		int[] fib = new int[n];
		fib[0] = 1;
		if(n>1) {
			fib[1] = 1;
		}
		for(int i=0; i<n; i++) {
			fib[i] = (i>1)?fib[i-2]+fib[i-1]:fib[i];
			System.out.print(fib[i]);
			System.out.print(" ");
		}
		System.out.println();
	}

	// Exercise 10
	static void findVampireNumber() {
		for(int i=1000; i<10000; i++) {
			if(isVampireNumber(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
	
	static boolean isVampireNumber(int n) {
		int[] res = new int[4];
		int tmp = n;
		for(int i=0; i<4; i++) {
			res[i] = n%10;
			n /= 10;
		}
		n = tmp;
		for(int i=1; i<4; i++) {
			if(res[0]!=0) {
				int a = res[0]*10+res[i];
				for(int j=1; j<4; j++) {
					if(j==i || res[j]==0) {
						continue;
					}
					int b = res[j]*10 + res[6-i-j];
					if(a*b==n) {
						return true;
					}
				}
			}
			if(res[i]!=0) {
				int a = res[i]*10+res[0];
				for(int j=1; j<4; j++) {
					if(j==i || res[j]==0) {
						continue;
					}
					int b = res[j]*10 + res[6-i-j];
					if(a*b==n) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	static void generateVampireNumber(int n) {
		if(n%2!=0 || n>10) {
			return ;
		}
		long start = (long)Math.pow(10, n/2.0-1);
		long end = (long)Math.pow(10, n/2.0);
		for(long i=start; i<end; i++) {
			for(long j=i; j<end; j++) {
				long res = i*j;
				char[] a = (Long.toString(i)+Long.toString(j)).toCharArray();
				char[] b = Long.toString(res).toCharArray();
				Arrays.sort(a);
				Arrays.sort(b);
				if(Arrays.equals(a, b)) {
					System.out.print(res + " ");
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		primeGenerator(100);
		printBinaryString(8&9);
		printBinaryString(8|9);
		printBinaryString(8^9);
		generateFibonacci(10);
		findVampireNumber();
		generateVampireNumber(4);
	}

}
