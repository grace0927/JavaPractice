package leetCode;

public class Edge {

	Point orig = new Point();
	Point end = new Point();
	
	public Edge() {
		
	}
	
	public Edge(Point orig, Point end) {
		this.orig = orig;
		this.end = end;
	}
	
	public Point getOrig() {
		return this.orig;
	}
	
	public Point getEnd() {
		return this.end;
	}
	
	public String printEdge() {
		String result = "(" + orig.printPoint() + ", " + end.printPoint() + ")";
		return result;
	}
}
