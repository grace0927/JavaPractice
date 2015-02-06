package com.javapractice.LeetCode;

public class Maze extends Graph {

	Point start;
	Point end;
	
	public Maze(){
		
	}
	
	public boolean setStart(Point start) {
		if(!vertices.contains(start)) {
			return false;
		} else {
			this.start = start;
			return true;
		}
	}
	
	public boolean setEnd(Point end) {
		if(!vertices.contains(end)) {
			return false;
		} else {
			this.end = end;
			return true;
		}
	}
	
	public void run() {
		
	}
}
