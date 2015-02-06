package com.javapractice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	List<Point> vertices = new ArrayList<>();
	List<Edge> edges = new ArrayList<>();
	
	public Graph() {
		
	}
	
	public Graph(List<Point> vertices) {
		this.vertices = vertices;
	}
	
	public Graph(List<Point> vertices, List<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}
	
	public boolean addVertice(Point a) {
		if(!vertices.contains(a)) {
			vertices.add(a);
			return true;
		} else {
			System.out.println("vertices " + a + "already exists");
			return false;
		}
	}
	
	public boolean addEdge(Edge a) {
		if(!edges.contains(a)) {
			if(vertices.contains(a.getOrig()) && vertices.contains(a.getEnd())) {
				edges.add(a);
				return true;
			} else {
				System.out.println("edge (" + a.getOrig() + ", " + a.getEnd() + ") contains unknown points");
				return false;
			}
		} else {
			System.out.println("edge " + a + "already exists");
			return false;
		}
	}
	
	public List<Point> printVertices() {
		System.out.println("this graph contains vertices: ");
		for(Point vertice : vertices) {
			System.out.println(vertice + " ");
		}
		System.out.println(".");
		return vertices;
	}
	
	public List<Edge> printEdges() {
		System.out.println("this graph contains edges: ");
		for(Edge edge : edges) {
			System.out.println(edge + " ");
		}
		System.out.println(".");
		return edges;
	}
	
	public void printGraph() {
		System.out.println("this graph contains vertices: ");
		for(Point vertice : vertices) {
			System.out.println(vertice.printPoint());
		}
		System.out.println("this graph contains edges: ");
		for(Edge edge : edges) {
			System.out.println(edge.printEdge());
		}
	}
	
	
	public boolean searchPath(Point orig, Point end) {
		if(vertices.contains(orig) && vertices.contains(end)) {
			return true;
		} else {
			return false;
		}
	}
}
