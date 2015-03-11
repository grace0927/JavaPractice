/**
 * 
 */
package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author jianyu
 *
 */
public class WordLadderII {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
		Queue<List<String>> queueList = new LinkedList<>();
		List<List<String>> res = new ArrayList<>();
		Queue<Integer> level = new LinkedList<>();
		List<String> neighList = new ArrayList<>();
		int lastLevel = 0;
		
		queue.add(start);
		level.add(0);
		List<String> list = new ArrayList<>();
		list.add(start);
		queueList.add(list);
		
		while(!queue.isEmpty()) {
			String cur = queue.poll();
			List<String> curList = queueList.poll();
			Integer curLevel = level.poll();
			
			if(isNeighbor(cur, end)) {
				curList.add(end);
				res.add(curList);
				lastLevel = curLevel;
				break;
			}
			
			for(int i=0; i<cur.length(); i++) {
				char[] arr = cur.toCharArray();
				for(char j='a'; j<='z'; j++) {
					arr[i] = j;
					String neigh = new String(arr);
					if(dict.contains(neigh)) {
						queue.add(neigh);
						level.add(curLevel+1);
						List<String> newList = new ArrayList<>(curList);
						newList.add(neigh);
						neighList.add(neigh);
						queueList.add(newList);
						System.out.println(newList);
					}
				}
			}
			if(curLevel > lastLevel) {
				lastLevel = curLevel;
				for(String str:neighList) {
					if(dict.contains(str)) {
						dict.remove(str);
					}
				}
				neighList.clear();
			}
		}
		
		while(!queue.isEmpty()) {
			String cur = queue.poll();
			List<String> curList = queueList.poll();
			Integer curLevel = level.poll();
			
			if(curLevel==lastLevel && isNeighbor(cur, end)) {
				curList.add(end);
				res.add(curList);
			}
		}
		
		return res;
    }
	
	public boolean isNeighbor(String one, String two) {
		int len = one.length();
		int count = 0;
		
		for(int i=0; i<len; i++) {
			if(one.charAt(i) != two.charAt(i)) {
				count++;
			}
			if(count > 1) {
				return false;
			}
		}
		
		return count==1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordLadderII test = new WordLadderII();
		Set<String> set = new HashSet<>();
		String[] arr = {"flail","halon","lexus","joint","pears","slabs","lorie","lapse","wroth","yalow","swear","cavil","piety","yogis","dhaka","laxer","tatum","provo","truss","tends","deana","dried","hutch","basho","flyby","miler","fries","floes","lingo","wider","scary","marks","perry","igloo","melts","lanny","satan","foamy","perks","denim","plugs","cloak","cyril","women","issue","rocky","marry","trash","merry","topic","hicks","dicky","prado","casio","lapel","diane","serer","paige","parry","elope","balds","dated","copra","earth","marty","slake","balms","daryl","loves","civet","sweat","daley","touch","maria","dacca","muggy","chore","felix","ogled","acids","terse","cults","darla","snubs","boats","recta","cohan","purse","joist","grosz","sheri","steam","manic","luisa","gluts","spits","boxer","abner","cooke","scowl","kenya","hasps","roger","edwin","black","terns","folks","demur","dingo","party","brian","numbs","forgo","gunny","waled","bucks","titan","ruffs","pizza","ravel","poole","suits","stoic","segre","white","lemur","belts","scums","parks","gusts","ozark","umped","heard","lorna","emile","orbit","onset","cruet","amiss","fumed","gelds","italy","rakes","loxed","kilts","mania","tombs","gaped","merge","molar","smith","tangs","misty","wefts","yawns","smile","scuff","width","paris","coded","sodom","shits","benny","pudgy","mayer","peary","curve","tulsa","ramos","thick","dogie","gourd","strop","ahmad","clove","tract","calyx","maris","wants","lipid","pearl","maybe","banjo","south","blend","diana","lanai","waged","shari","magic","duchy","decca","wried","maine","nutty","turns","satyr","holds","finks","twits","peaks","teems","peace","melon","czars","robby","tabby","shove","minty","marta","dregs","lacks","casts","aruba","stall","nurse","jewry","knuth"};
		//String[] arr = {"hot","dog","dot"};
		for(int i=0; i<arr.length; i++) {
			set.add(arr[i]);
		}
		System.out.println(test.findLadders("magic", "pearl", set));

	}

}
