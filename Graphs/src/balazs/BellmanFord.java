package balazs;

import java.util.ArrayList;
import java.util.List;

class BellmanFordAlgorithm{
	private List<VertexG> vertexList;
	private List<Edge> edgeList;
	public BellmanFordAlgorithm(List<VertexG> vertexList, List<Edge> edgeList) {
		super();
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}
	
	public void run(VertexG source) {
		source.setDistance(0);;
		
		for(int i=0; i<vertexList.size()-1; i++) {
			// Relaxation
			for(Edge e:edgeList) {
				VertexG u = e.getStartVertex();
				VertexG v = e.getTargetVertex();
				
				if(u.getDistance() + e.getWeight() < v.getDistance()) {
					v.setDistance(u.getDistance() + e.getWeight());
					v.setPredecessor(u);
				}
			}
			
			for(Edge edge : edgeList) {
				if(edge.getStartVertex().getDistance() != Double.MAX_VALUE) {
					if(hasCycle(edge)) {
						System.out.println("There is a negative cycle...");
					}
				}
			}
		}		
	}

	private boolean hasCycle(Edge edge) {
		return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
	}
	
	public void shortestPathTo(VertexG vertex) {
		
		if(vertex.getDistance() == Double.MAX_VALUE) {
			System.out.println("There is no path from source to the given vertex...");
			return;
		}
		
		VertexG actual = vertex;
		
		while(actual != null) {
			System.out.println(actual);
			actual = actual.getPredecessor();
		}
	}
}


public class BellmanFord {

	public static void main(String[] args) {
		VertexG vertex0 = new VertexG("A"	);	
		VertexG vertex1 = new VertexG("B"	);	
		VertexG vertex2 = new VertexG("C"	);	
		VertexG vertex3 = new VertexG("D"	);	
		VertexG vertex4 = new VertexG("E"	);	
		VertexG vertex5 = new VertexG("F"	);	
		VertexG vertex6 = new VertexG("G"	);
		VertexG vertex7 = new VertexG("H"	);
		
		List<VertexG> vertexList = new ArrayList<>();
		
		vertexList.add(vertex0);
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		vertexList.add(vertex3);
		vertexList.add(vertex4);
		vertexList.add(vertex5);
		vertexList.add(vertex6);
		vertexList.add(vertex7);
		
		List<Edge> edgeList = new ArrayList<>();
		
		edgeList.add(new Edge(5, vertex0, vertex1));
		edgeList.add(new Edge(9, vertex0, vertex4));
		edgeList.add(new Edge(8, vertex0, vertex7));
		
		edgeList.add(new Edge(12, vertex1, vertex2));
		edgeList.add(new Edge(15, vertex1, vertex3));
		edgeList.add(new Edge(4, vertex1, vertex7));
		
		edgeList.add(new Edge(3, vertex2, vertex3));
		edgeList.add(new Edge(11, vertex2, vertex6));
		
		edgeList.add(new Edge(9, vertex3, vertex6));
		
		edgeList.add(new Edge(4, vertex4, vertex5));
		edgeList.add(new Edge(20, vertex4, vertex6));
		edgeList.add(new Edge(5, vertex4, vertex7));
		
		edgeList.add(new Edge(1, vertex5, vertex2));
		edgeList.add(new Edge(13, vertex5, vertex7));
		
		edgeList.add(new Edge(7, vertex7, vertex2));
		edgeList.add(new Edge(6, vertex7, vertex5));
		
		BellmanFordAlgorithm algorithm = new BellmanFordAlgorithm(vertexList, edgeList);
		algorithm.run(vertexList.get(0));	
		algorithm.shortestPathTo(vertexList.get(6));
	}

}
