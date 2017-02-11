/**
 * 
 */
package com.javapractice.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author feng
 *
 */
public class Maze {

	public void solver(boolean[][] board, int start, int end, List<Character> res) {
		if(end == 8) {
			System.out.println(res);
			return ;
		}
		board[start][end] = false;
		board[end][start] = false;
		int next = end-3;
		while(next >= 3) {
			if(board[end][next]) {
				res.add('u');
				solver(board, end, next, res);
				res.remove(res.size()-1);
			}
			next -= 3;
		}
		next = end+3;
		while(next < 9) {
			if(board[end][next]) {
				res.add('d');
				solver(board, end, next, res);
				res.remove(res.size()-1);
			}
			next += 3;
		}
		next = end-1;
		while(next>=0 && next/3 == end/3) {
			if(board[end][next]) {
				res.add('l');
				solver(board, end, next, res);
				res.remove(res.size()-1);
			}
			next--;
		}
		next = end+1;
		while(next<9 && next/3 == end/3) {
			if(board[end][next]) {
				res.add('r');
				solver(board, end, next, res);
				res.remove(res.size()-1);
			}
			next++;
		}
		board[start][end] = true;
		board[end][start] = true;
	}
	
	/**
	 * @param args
	 */
	/*
	public static void main(String[] args) {
		boolean[][] board = {{false, false, false, false, false, false, true, false, false},
				{false, false, true, false, false, false, false, false, false},
				{false, true, false, false, false, false, false, false, true},
				{true, false, false, false, false, true, true, false, false},
				{false, false, false, true, false, true, false, true, false},
				{false, false, true, true, false, false, false, false, true},
				{true, false, false, false, false, false, false, true, false},
				{false, false, false, false, true, false, true, false, false},
				{false, false, true, false, false, true, false, false, false},
		};
		List<Character> res = new ArrayList<>();
		int next = 0;
		Maze test = new Maze();
		
		next = 3;
		while(next < 9) {
			if(board[0][next]) {
				res.add('d');
				test.solver(board, 0, next, res);
				res.remove(res.size()-1);
			}
			next += 3;
		}
		next = 1;
		while(next/3 == 0/3) {
			if(board[0][next]) {
				res.add('r');
				test.solver(board, 0, next, res);
				res.remove(res.size()-1);
			}
			next++;
		}
		
	}
	*/
	class Vertex {
		int index;
		boolean visit;
		HashMap<Character, Vertex> neighbours;
		
		Vertex(int index) {
			this.index = index;
			this.neighbours = new HashMap<>();
		}
	}

	List<Vertex> vertices = new ArrayList<>();

	public void init() {
		for(int i=0; i<9; i++) {
			Vertex vertex = new Vertex(i);
			vertices.add(vertex);
		}
		vertices.get(0).neighbours.put(Character.valueOf('d'), vertices.get(6));
		vertices.get(0).neighbours.put(Character.valueOf('r'), vertices.get(1));
		vertices.get(1).neighbours.put(Character.valueOf('d'), vertices.get(4));
		vertices.get(4).neighbours.put(Character.valueOf('r'), vertices.get(5));
		vertices.get(5).neighbours.put(Character.valueOf('d'), vertices.get(8));
		vertices.get(2).neighbours.put(Character.valueOf('d'), vertices.get(8));
		vertices.get(6).neighbours.put(Character.valueOf('r'), vertices.get(7));
	}

	public boolean DFS(int from, int to, StringBuilder builder) {
		if(from == to) {
			System.out.println(builder.toString());
			return true;
		}		

		Vertex fromVertex = vertices.get(from);
		for(Character direction:fromVertex.neighbours.keySet()) {
			builder.append(direction);
			Vertex toVertex = fromVertex.neighbours.get(direction);
			toVertex.visit = true;
			if(DFS(toVertex.index, to, builder)) {
				return true;
			}
			toVertex.visit = false;
			builder.deleteCharAt(builder.length()-1);
		}
		return false;
	}

	public static void main(String args[]) {
		Maze maze = new Maze();
		maze.init();
		StringBuilder builder = new StringBuilder();
		maze.DFS(0, 8, builder);
	}
}
