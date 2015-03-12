package com.javapractice.leetcode;

public class ValidNumber {
	public boolean isNumber(String s) {
        if(s==null || s.length()<1) {
            return false;
        }
        
        boolean e = true;
        int space = 0;
        boolean dot = false;
        boolean neg = false;
        int sum = -1;
        int len = s.length();
        
        for(int i=0; i<len; i++) {
            char cur = s.charAt(i);
            if(cur==' ') {
                if(space == 0) {
                    space = 1;
                } else if(space == 2){
                    space = 3;
                }
            } else if(cur=='e') {
                if(e) {
                    return false;
                } else {
                    e = true;
                    sum = -1;
                }
            } else if(cur=='.') {
                if(dot) {
                    return false;
                } else {
                    dot = true;
                }
            } else if(cur=='-') {
                if(neg) {
                    return false;
                } else {
                    neg = true;
                }
            } else if(cur>='0' && cur<='9') {
                if(space == 1) {
                    space = 2;
                } else if(space == 3) {
                    return false;
                }
                e = false;
                sum = cur;
            }
        }
        
        if(e && sum==-1) {
            return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) {
		ValidNumber test = new ValidNumber();
		System.out.println(test.isNumber("2e0"));

	}

}
