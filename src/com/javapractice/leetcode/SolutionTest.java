/**
 * 
 */
package com.javapractice.leetcode;

/**
 * @author feng
 *
 */
public class SolutionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddTwoNumbers test = new AddTwoNumbers();
		ListNode one = new ListNode(0);
		ListNode two = new ListNode(9);
		ListNode three = new ListNode(1);
		ListNode four = new ListNode(6);
		two.next = three;
		three.next = four;
		ListNode cur = test.addTwoNumbersAlter(one, two);
		while(cur != null) {
			System.out.println(cur.val);
			cur = cur.next;
		}
		
		Anagrams test0 = new Anagrams();
		String[] a = {"tho","tin","erg","end","pug","ton","alb",
				"mes","job","ads","soy","toe","tap","sen","ape",
				"led","rig","rig","con","wac","gog","zen","hay",
				"lie","pay","kid","oaf","arc","hay","vet","sat",
				"gap","hop","ben","gem","dem","pie","eco","cub",
				"coy","pep","wot","wee"};
		//String[] b = {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"};
		//String[] c = {"", ""};
		System.out.println(test0.anagrams(a));
		
    	Candy test1 = new Candy();
    	int[] ratings = {1,2};
    	int res = test1.candy(ratings);
    	System.out.println(res);
	}

}
