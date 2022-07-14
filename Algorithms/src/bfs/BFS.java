package bfs;

import java.util.ArrayList;

/*******************
 * enqueue any starting vertex
 * while queue is not empty
 * 		p = dequeue()
 * 		if p is unvisited
 * 			mark it visited
 * 			enqueue all adjacent
 * 			unvisited vertices of p
 * 
 * */



public class BFS {

	public static void main(String[] args) {
		ArrayList<GraphNodes> nodes = new ArrayList<GraphNodes>();
		nodes.add(new GraphNodes("A", 0));
		nodes.add(new GraphNodes("B", 1));
		nodes.add(new GraphNodes("C", 2));
		nodes.add(new GraphNodes("D", 3));
		nodes.add(new GraphNodes("E", 4));
		
		
		Graph g = new Graph(nodes);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 2);
		g.addUndirectedEdge(0, 3);
		g.addUndirectedEdge(1, 4);
		g.addUndirectedEdge(2, 3);
		g.addUndirectedEdge(3, 4);
		
		System.out.println(g.toString());
		System.out.println("\nBFS:\n");
		g.BFS();
	}

}
