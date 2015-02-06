/**
 * 
 */
package com.javapractice.LeetCode;

import java.util.HashMap;

/**
 * @author jianyu
 *
 * https://oj.leetcode.com/problems/lru-cache/
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
 * it should invalidate the least recently used item before inserting a new item.
 * 
 */

public class LRUCache {
    class Node {
        int key;
        int value;
        Node next;
        Node prev;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    class DLL {
        int capacity;
        int size;
        Node head;
        Node end;
        
        public DLL(int capacity) {
            this.capacity = capacity;
            this.size = 0;
        }
        
        public void addNode(Node node) {
            if(head==null) {
                // empty linked list
                head = node;
                end = head;
                size++;
            } else if(head.next==null) {
                // one node list
                head.next = node;
                node.prev = head;
                end = node;
                size++;
            }else {
                node.prev = end;
                end.next = node;
                end = node;
                size++;
            }
        }
        
        public void removeNode(Node node) {
            if(node.prev==null && node.next!=null) {
                // as head node and not the last one
                head = node.next;
                head.prev = null;
                size--;
            } else if(node.next==null && node.prev!=null) {
                // as end node and not the first one
                node.prev.next = null;
                end = node.prev;
                size--;
            } else if(node.next==null && node.prev==null) {
                // only one list
                head = null;
                end = null;
                size--;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                size--;
            }
        }
        
        public boolean isFull() {
            return size==capacity;
        }
    }
    
    DLL dll;
    HashMap<Integer, Node> cache = new HashMap<>();
    
    public LRUCache(int capacity) {
        dll = new DLL(capacity);
    }
    
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node tmp = cache.get(key);
            dll.removeNode(tmp);
            dll.addNode(tmp);
            return tmp.value;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        Node tmp = new Node(key, value);
        if(dll==null) {
            // if empty
            dll.addNode(tmp);
            cache.put(key, tmp);
        } else if(cache.containsKey(key)){
            // if key exists
            Node keyNode = cache.get(key);
            keyNode.value = value;
            dll.removeNode(keyNode);
            dll.addNode(keyNode);
        } else if(dll.isFull()){
            // cache full situation
            Node head = dll.head;
            cache.remove(head.key);
            cache.put(key, tmp);
            dll.removeNode(head);
            dll.addNode(tmp);
        } else {
            dll.addNode(tmp);
            cache.put(key,tmp);
        }
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
