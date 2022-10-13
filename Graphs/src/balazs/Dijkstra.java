package balazs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class DijkstraAlgorithm {
	public void computePath(VertexG source) {
		source.setDistance(0);
		
		// Heap
		PriorityQueue<VertexG> q = new PriorityQueue<>();
		q.add(source);
		
		while(!q.isEmpty()) {
			VertexG current = q.poll();
			for(Edge e : current.getAdjacencyList()) {
				VertexG v = e.getTargetVertex();
				
				double d = current.getDistance() + e.getWeight();
				if(d < v.getDistance()) {
					q.remove(v);
					v.setDistance(d);
					v.setPredecessor(current);
					// Re-insert vertex after calculate weight
					q.add(v);
				}
			}
		}
	}
	
	public List<VertexG> getShortestPathTo(VertexG targetVertex) {
		List<VertexG> path = new ArrayList<>();		
		for(VertexG vertex=targetVertex;vertex!=null;vertex=vertex.getPredecessor())
			path.add(vertex);
		
		Collections.reverse(path);
		return path;
	}
}

public class Dijkstra {

	public static void main(String[] args) {
		VertexG vertex0 = new VertexG("A");	
		VertexG vertex1 = new VertexG("B");	
		VertexG vertex2 = new VertexG("C");	
		VertexG vertex3 = new VertexG("D");	
		VertexG vertex4 = new VertexG("E");	
		VertexG vertex5 = new VertexG("F");	
		VertexG vertex6 = new VertexG("G");
		VertexG vertex7 = new VertexG("H");
		
		vertex0.setAdjacencyList(new Edge(5, vertex0, vertex1));
		vertex0.setAdjacencyList(new Edge(9, vertex0, vertex4));
		vertex0.setAdjacencyList(new Edge(8, vertex0, vertex7));
		
		vertex1.setAdjacencyList(new Edge(12, vertex1, vertex2));
		vertex1.setAdjacencyList(new Edge(15, vertex1, vertex3));
		vertex1.setAdjacencyList(new Edge(4, vertex1, vertex7));
		
		vertex2.setAdjacencyList(new Edge(3, vertex2, vertex3));
		vertex2.setAdjacencyList(new Edge(11, vertex2, vertex6));
		
		vertex3.setAdjacencyList(new Edge(9, vertex3, vertex6));
		
		vertex4.setAdjacencyList(new Edge(4, vertex4, vertex5));
		vertex4.setAdjacencyList(new Edge(20, vertex4, vertex6));
		vertex4.setAdjacencyList(new Edge(5, vertex4, vertex7));
		
		vertex5.setAdjacencyList(new Edge(1, vertex5, vertex2));
		vertex5.setAdjacencyList(new Edge(13, vertex5, vertex7));
		
		vertex7.setAdjacencyList(new Edge(7, vertex7, vertex2));
		vertex7.setAdjacencyList(new Edge(6, vertex7, vertex5));
		
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm();
		algorithm.computePath(vertex0);
		
		System.out.println(algorithm.getShortestPathTo(vertex6));
	}

}
