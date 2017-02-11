/**
 * 
 */
package com.javapractice.thinking.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @author Feng
 *
 */
public class DirFilter implements FilenameFilter {
	private Pattern pattern;
	
	public DirFilter(String str) {
		pattern = Pattern.compile(str);
	}

	/* (non-Javadoc)
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		return pattern.matcher(name).matches();
	}

}
