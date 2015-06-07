/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 * https://oj.leetcode.com/problems/restore-ip-addresses/
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        
        restoreIpAddressesUtil(s, 0, list, str, 0, 0);
        
        return list;
    }
	
	public void restoreIpAddressesUtil(String s, int start, List<String> list, StringBuilder str, int dot, int total) {
		if(start == s.length()) {
		    if(dot == 3 && str.charAt(str.length()-1) != '.') {
			    list.add(str.toString());
		    }
			return ;
		}
		
		int cur = (int)(s.charAt(start)-48);
		total = total*10+cur;
		if(total < 256 && total >= 0) {
			if(dot < 3) {
				str.append(s.charAt(start));
				str.append('.');
				restoreIpAddressesUtil(s, start+1, list, str, dot+1, 0);
				str.deleteCharAt(str.length()-1);
				if(total != 0 || (total == 0 && str.charAt(str.length()-1) != '0')) {
				    restoreIpAddressesUtil(s, start+1, list, str, dot, total);
				}
				str.deleteCharAt(str.length()-1);
			} else {
			    if(str.charAt(str.length()-1) != '0' || total != cur) {
				    str.append(s.charAt(start));
				    restoreIpAddressesUtil(s, start+1, list, str, dot, total);
				    str.deleteCharAt(str.length()-1);
			    }
			}
		}
		
		return ;
    }
}
