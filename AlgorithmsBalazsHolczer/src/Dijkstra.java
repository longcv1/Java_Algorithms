import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import common.graph.Edge;
import common.graph.VertexDijstra;

class DijkstraAlgo {
	public void computePath(VertexDijstra source) {
		
		source.setDistance(0);		
		PriorityQueue<VertexDijstra> queue = new PriorityQueue<>();
		queue.add(source);
		
		while(!queue.isEmpty()) {
			VertexDijstra actual = queue.poll();
			
			for(Edge edge : actual.getAdjacencyList()) {
//				VertexDijstra u = edge.getStartVertex();
				VertexDijstra v = edge.getTargetVertex();
				
				double d = actual.getDistance() + edge.getWeight();
				if(d < v.getDistance()) {
//					queue.remove(v);
					v.setDistance(d);
					v.setPredecessor(actual);
					queue.add(v);
				}
			}
		}
	}
	
	public List<VertexDijstra> getShortestPathTo(VertexDijstra targetVertex) {
		List<VertexDijstra> path = new ArrayList<>();
		for(VertexDijstra v = targetVertex; v != null ; v = v.getPredecessor())
			path.add(v);
		
		Collections.reverse(path);
		return path;
	}
}

public class Dijkstra {

	public static void main(String[] args) {
		VertexDijstra v0 = new VertexDijstra("A");
		VertexDijstra v1 = new VertexDijstra("B");
		VertexDijstra v2 = new VertexDijstra("C");
		VertexDijstra v3 = new VertexDijstra("D");
		VertexDijstra v4 = new VertexDijstra("E");
		VertexDijstra v5 = new VertexDijstra("F");
		VertexDijstra v6 = new VertexDijstra("G");
		VertexDijstra v7 = new VertexDijstra("H");
		
		v0.addNeighbors(new Edge(5, v0, v1));
		v0.addNeighbors(new Edge(8, v0, v4));
		v0.addNeighbors(new Edge(9, v0, v7));
		
		v1.addNeighbors(new Edge(12, v1, v2));
		v1.addNeighbors(new Edge(15, v1, v3));
		v1.addNeighbors(new Edge(4, v1, v7));
		
		v2.addNeighbors(new Edge(3, v2, v3));
		v2.addNeighbors(new Edge(11, v2, v6));
		
		v3.addNeighbors(new Edge(9, v3, v6));
		
		v4.addNeighbors(new Edge(4, v4, v5));
		v4.addNeighbors(new Edge(20, v4, v6));
		v4.addNeighbors(new Edge(5, v4, v7));
		
		v5.addNeighbors(new Edge(1, v5, v2));
		v5.addNeighbors(new Edge(13, v5, v7));
		
		v7.addNeighbors(new Edge(7, v7, v2));
		v7.addNeighbors(new Edge(6, v7, v5));
		
		
		DijkstraAlgo dijkstra = new DijkstraAlgo();
		dijkstra.computePath(v0);
		System.out.println(dijkstra.getShortestPathTo(v6).toString());
	}

}
