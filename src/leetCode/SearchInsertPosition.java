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
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int index = 0;
        for(index = 0; index < A.length; index++) {
        	if(target < A[index]) {
        		break;
        	} else if(target == A[index]){
        		break;
        	} else {
        		continue;
        	}
        }
        return index;
    }
}
