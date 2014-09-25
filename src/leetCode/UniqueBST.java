package leetCode;

public class UniqueBST {
    public int numTrees(int n) {
    	/* recursive */
        switch(n) {
            case 0:
                return 1;
            case 1:
                return 1;
            case 2:
                return 2;
            default:
                int result=0;
                for(int i=0; i<n; i++) {
                    result += numTrees(i) * numTrees(n-1-i);
                }
                return result;
        }
    }
    
    public int numTreesDP(int n){
    	/* iteration (Dynamic Program) */
    	if(n<0) {
    		return 0;
    	} else if(n==0) {
    		return 1;
    	} else {
    		Integer[] result = new Integer[n+1];
    		result[0] = 1;
    		result[1] = 1;
    		for(int i=2; i<n+1; i++) {
    			result[i]=0;
    			for(int j=0; j<i; j++){
    				result[i] += result[j] * result[i-j-1];
    			}
    		}
    		return result[n];
    	}
    }
    
    public static void main(String argv[]) {
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
    	
    }
}
