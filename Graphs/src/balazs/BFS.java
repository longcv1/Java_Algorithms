package balazs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Vertex{
	private String name;
	private boolean visited;
	private List<Vertex> adjacencyList;
	public Vertex(String name) {
		super();
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public void addNeighbor(Vertex vertex) {
		this.adjacencyList.add(vertex);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public List<Vertex> getAdjacencyList() {
		return this.adjacencyList;
	}
	
}

class BFSAlgo{
	public void traverse(Vertex root) {
		Queue<Vertex> q = new LinkedList<>();
		root.setVisited(true);
		q.add(root);
		while(!q.isEmpty()) {
			Vertex actual = q.remove();
			System.out.println("Visited vertex: " + actual);
			for(Vertex v : actual.getAdjacencyList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					q.add(v);
				}
			}
		}
	}
}

public class BFS {

	public static void main(String[] args) {
		 Vertex a = new Vertex("A");
		 Vertex b = new Vertex("B");
		 Vertex c = new Vertex("C");
		 Vertex d = new Vertex("D");
		 Vertex e = new Vertex("E");
		 Vertex f = new Vertex("F");
		 Vertex g = new Vertex("G");
		 Vertex h = new Vertex("H");
		 
		 a.addNeighbor(b); a.addNeighbor(f); a.addNeighbor(g);
		 b.addNeighbor(a); b.addNeighbor(c); b.addNeighbor(d);
		 c.addNeighbor(b);
		 d.addNeighbor(b); d.addNeighbor(e);
		 f.addNeighbor(a);
		 g.addNeighbor(a); g.addNeighbor(h);
		 h.addNeighbor(g);
		 
		 BFSAlgo bfs = new BFSAlgo();
		 bfs.traverse(a);
	}

}
