/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Feng
 * https://leetcode.com/problems/russian-doll-envelopes/
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). 
 * One envelope can fit into another if and only if both the width 
 * and height of one envelope is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * Example:
 * Given envelopes = [[5,4],[6,4],[6,7],[2,3]], 
 * the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 */
public class RussianDollEnvelopes {
    class Envelope {
        int w, h;
        public Envelope(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n<2) {
            return n;
        }
        List<Envelope> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(new Envelope(envelopes[i][0], envelopes[i][1]));
        }
        Collections.sort(list, new Comparator<Envelope>() {
           public int compare(Envelope a, Envelope b) {
               return (a.w==b.w)?a.h-b.h:a.w-b.w;
           } 
        });
        int[] dp = new int[n];
        int cnt = 0;
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            Envelope e = list.get(i);
            for(int j=0; j<i; j++) {
                Envelope s = list.get(j);
                if(e.w>s.w && e.h>s.h) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            cnt = Math.max(cnt, dp[i]);
        }
        return cnt;
    }
}