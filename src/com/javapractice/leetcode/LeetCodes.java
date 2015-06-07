package com.javapractice.leetcode;


public class LeetCodes {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    	long begintime = System.nanoTime();
    	UniqueBST test = new UniqueBST();
    	int res = test.numTrees(20);
    	long endtime=System.nanoTime();
    	long costTime1 = (endtime - begintime)/1000;

    	begintime = System.nanoTime();
    	res = test.numTreesDP(20);
    	endtime=System.nanoTime();
    	long costTime2 = (endtime - begintime)/1000;
    	
    	System.out.println("result is: " + res + " cost time: " + costTime1 + "ms" 
    			+ " cost time 2: " + costTime2 + "ms");

		char[][] graph = {
				{0,8,7,6,5,4,3,2,1},
                {2,0,0,0,0,0,0,0,0},
                {3,0,0,0,0,0,0,0,0},
                {4,0,0,0,0,0,0,0,0},
                {5,0,0,0,0,0,0,0,0},
                {6,0,0,0,0,0,0,0,0},
                {7,0,0,0,0,0,0,0,0},
                {8,0,0,0,0,0,0,0,0},
                {9,0,0,0,0,0,0,0,0}};
		
		ValidSudoku test0 = new ValidSudoku();
		System.out.println(test0.isValidSudoku(graph));
		
    }
    
}