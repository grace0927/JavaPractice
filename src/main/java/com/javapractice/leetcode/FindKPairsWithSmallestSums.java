/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author feng
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u,v) which consists of one element from the first array and one element 
 * from the second array.
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 *
 */
public class FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        for(int i=0; i<nums1.length; i++) {
            for(int j=0; j<nums2.length; j++) {
                list.add(new int[]{nums1[i], nums2[j]});
            }
        }
        Collections.sort(list, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0]+a[1]-b[0]-b[1];
            }
        });
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<k && i<list.size(); i++) {
            res.add(list.get(i));
        }
        return res;
    }
}
