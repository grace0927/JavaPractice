/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetCode;

/**
 *
 * @author jianyu
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int num = 0;
        int i;
        for(i=0; i<A.length; i++) {
            num ^= A[i];
        }
        
        return num;
    }
    
    public int singleNumberThree(int[] A) {
    	int num = 0;
    	
    	return num;
    }
}
