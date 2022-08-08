import java.util.*;

import common.graph.*;

class BellmanFordAlgo{
	private List<VertexDijstra> vertexList;
	private List<Edge> edgeList;
	public BellmanFordAlgo(List<VertexDijstra> vertexList, List<Edge> edgeList) {
		super();
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}
	
	public void run(VertexDijstra source) {
		source.setDistance(0);
		
		for(int i = 0; i < vertexList.size() - 1; i++) {
			// Relaxation
			for (Edge edge : edgeList) {
				VertexDijstra u = edge.getStartVertex();
				VertexDijstra v = edge.getTargetVertex();
				
				if(u.getDistance() + edge.getWeight() < v.getDistance()) {
					v.setDistance(u.getDistance() + edge.getWeight());
					v.setPredecessor(u);
				}
			}
		}
		
		// if we make additional relaxation and there is a shorter path 
		// then we know that there is a negative cycle in the graph
		for (Edge edge : edgeList) {
			if(edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
				if(hasCycle(edge)) {
					System.out.println("There is a negative cycle");
					return;
				}
			}
		}
	}

	private boolean hasCycle(Edge edge) {
		if(edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance()) {
			return true;
		}
		return false;
	}
	
	public void shortesPathTo(VertexDijstra vertex) {
		if(vertex.getDistance() == Double.MAX_VALUE) {
			System.out.println("There is no path from source to the given vertex!!!");
			return;
		}
		
		VertexDijstra actual = vertex;
		while(actual.getPredecessor() != null) {
			System.out.println(actual);
			actual = actual.getPredecessor();
		}
	}
}

public class BellmanFord {
	public static void main(String[] args) {
		List<VertexDijstra> vertexList = new ArrayList<>();
		
		vertexList.add(new VertexDijstra("A"));
		vertexList.add(new VertexDijstra("B"));
		vertexList.add(new VertexDijstra("C"));
		
		List<Edge> edgeList = new ArrayList<>();
		edgeList.add(new Edge(5, vertexList.get(0), vertexList.get(1)));
		edgeList.add(new Edge(2, vertexList.get(1), vertexList.get(2)));
		edgeList.add(new Edge(-10, vertexList.get(2), vertexList.get(0)));
		
		BellmanFordAlgo bf = new BellmanFordAlgo(vertexList, edgeList);
		bf.run(vertexList.get(0));
		//bf.shortesPathTo(vertexList.get(2));
	}
}
