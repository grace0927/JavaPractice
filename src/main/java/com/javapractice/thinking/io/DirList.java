/**
 * 
 */
package com.javapractice.thinking.io;

import java.io.File;
import java.util.Arrays;

/**
 * @author Feng
 *
 */
public class DirList {
	public static void main(String[] args) {
		String dir = "./src/com/javapractice/thinking/";
		File path = new File(dir);
		String[] list;
		if(args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String item:list) {
			System.out.println(item);
			File file = new File(dir+item);
			System.out.println(file.length());
		}
	}
}
