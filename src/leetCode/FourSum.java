/**
 * 
 */
package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author feng
 *
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
        List<Integer> list = new ArrayList<>();
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        
        fourSumUtil(num, 0, list, map);
        
        for(List<Integer> cur:map.keySet()) {
            if(map.get(cur) == target) {
                result.add(cur);
            }
        }
        
        return result;
    }
    
    public void fourSumUtil(int[] num, int start, List<Integer> list, HashMap<List<Integer>, Integer> map) {
        if(list.size() == 4) {
            int sum = list.get(0)+list.get(1)+list.get(2)+list.get(3);
            List<Integer> temp = new ArrayList<>(list);
            map.put(temp, sum);
            return ;
        }
        
        int len = num.length;
        for(int i=start; i<len; i++) {
            Integer cur = new Integer(num[i]);
            list.add(cur);
            fourSumUtil(num, i+1, list, map);
            list.remove(cur);
        }
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FourSum test = new FourSum();
		int[] num = {-493,-482,-482,-456,-427,-405,-392,-385,-351,-269,-259,-251,-235,-235,-202,-201,-194,-189,-187,-186,-180,-177,-175,-156,-150,-147,-140,-122,-112,-112,-105,-98,-49,-38,-35,-34,-18,20,52,53,57,76,124,126,128,132,142,147,157,180,207,227,274,296,311,334,336,337,339,349,354,363,372,378,383,413,431,471,474,481,492};
		System.out.println(test.fourSum(num, 6189));

	}

}
