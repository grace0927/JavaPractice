/**
 * 
 */
package com.javapractice.lintcode;

/**
 * @author jianyu
 * http://www.lintcode.com/en/problem/binary-representation/
 * Given a (decimal - e.g. 3.72) number that is passed in as a string, 
 * return the binary representation that is passed in as a string.
 * If the number can not be represented accurately in binary with at most 32 characters, return ERROR.
 * For n = "3.72", return "ERROR".
 * For n = "3.5", return "11.1".
 *
 */
public class BinaryRepresentation {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        int len = n.length();
        StringBuilder resHead = new StringBuilder();
        StringBuilder resRes = new StringBuilder();
        int pos = 0;
        long cur = 0;

        while(pos<len && n.charAt(pos)!='.') {
        	cur = cur*10+n.charAt(pos)-48;
        	pos++;
        }
        if(cur==0) {
            resHead.insert(0,"0");
        }
        while(cur!=0) {
        	resHead.insert(0, cur&1);
        	cur >>= 1;
        }
        if(pos==len && resHead.length()<=32) {
        	return resHead.toString();
        }
        if(resHead.length()>32) {
        	return new String("ERROR");
        }

        pos++;
        int pow = 0;
        while(pos<len) {
        	cur = cur*10+n.charAt(pos)-48;
        	pow++;
        	pos++;
        }
        
        while(cur!=0) {
        	if(resRes.length()>32) {
        		return "ERROR";
        	}
        	cur *= 2;
        	if(cur >= Math.pow(10, pow)) {
        		resRes.append("1");
        		cur -= Math.pow(10, pow);
        	} else {
        		resRes.append("0");
        	}
        }
        
        return (resRes.length()>0)?(resHead.toString()+"."+resRes.toString()):resHead.toString();
    }
}
