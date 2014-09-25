package leetCode;


public class LeetCodes {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Graph puzzle = new Maze();
        Point[] points = new Point[9];
        
        for(int i=0; i<3; i++) {
        	for(int j=0; j<3; j++) {
        		points[i*3+j] = new Point(i,j);
        		puzzle.addVertice(points[i*3+j]);
        	}
        }
        
        puzzle.addEdge(new Edge(points[0], points[1]));
        puzzle.addEdge(new Edge(points[0], points[6]));
        puzzle.addEdge(new Edge(points[6], points[7]));
        puzzle.addEdge(new Edge(points[4], points[7]));
        puzzle.addEdge(new Edge(points[4], points[5]));
        puzzle.addEdge(new Edge(points[2], points[5]));
        puzzle.addEdge(new Edge(points[5], points[8]));
        
        
        puzzle.printGraph();
    }
    
}