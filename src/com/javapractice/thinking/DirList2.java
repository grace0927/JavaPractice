/**
 * 
 */
package com.javapractice.thinking;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Feng
 *
 */
public class DirList2 {
	public static FilenameFilter filter(final String regex) {
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		};
	}
	
	public static void main(String[] args) {
		File dir = new File("./src/com/javapractice/thinking");
		String[] list;
		if(args.length==0) {
			list = dir.list();
		} else {
			list = dir.list(filter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String item:list) {
			System.out.println(item);
		}
	}
}
