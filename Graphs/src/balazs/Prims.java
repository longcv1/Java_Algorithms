package balazs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;

class LazyPrimsAlgo {
	private Set<VertexG> unvisited;
	private List<Edge> mst;
	private PriorityQueue<Edge> heap;
	private double fullCost;
	public LazyPrimsAlgo(List<VertexG> vertexList) {
		super();
		this.mst = new ArrayList<>();
		this.heap = new PriorityQueue<>((e1, e2) -> Double.compare(e1.getWeight(), e2.getWeight()));
		this.unvisited = new HashSet<>(vertexList);
	}
	
	public void run(VertexG vertex) {
		unvisited.remove(vertex);
		while(!unvisited.isEmpty()) {
			// Insert all the edges into the heap except
			// edges leading to already visited vertex
			for(Edge e : vertex.getAdjacencyList()) {
				if(unvisited.contains(e.getTargetVertex())) {
					heap.add(e);
				}
			}
			
			// Get the minimum edge from the heap
			Edge minEdge = heap.remove();
			
			// Get another edge if the edge is leading to an visited edge
			if(!unvisited.contains(minEdge.getTargetVertex()))
				continue;
			
			mst.add(minEdge);
			fullCost += minEdge.getWeight();
			
			// in the next iteration we consider the next vertex
			vertex = minEdge.getTargetVertex();
			unvisited.remove(vertex);
		}
	}
	
	public void show() {
		System.out.println("Cost: " + this.fullCost);
		for(Edge e : this.mst) {
			System.out.println(e.getStartVertex() + "-" + e.getTargetVertex());	
		}
	}
}

public class Prims {

	public static void main(String[] args) {
		List<VertexG> vertexList = new ArrayList<>();

		VertexG vertex0 = new VertexG("A");
		VertexG vertex1 = new VertexG("B");
		VertexG vertex2 = new VertexG("C");
		VertexG vertex3 = new VertexG("D");
		VertexG vertex4 = new VertexG("E");
		VertexG vertex5 = new VertexG("F");
		VertexG vertex6 = new VertexG("G");
		
		vertexList.add(vertex0);
		vertexList.add(vertex1);
		vertexList.add(vertex2);
		vertexList.add(vertex3);
		vertexList.add(vertex4);
		vertexList.add(vertex5);
		vertexList.add(vertex6);
		
		vertex0.setAdjacencyList(new Edge(1, vertex0, vertex1));	
		vertex0.setAdjacencyList(new Edge(2, vertex0, vertex2));	
		vertex0.setAdjacencyList(new Edge(12, vertex0, vertex3));
		
		vertex1.setAdjacencyList(new Edge(1, vertex1, vertex0));	
		vertex1.setAdjacencyList(new Edge(4, vertex1, vertex3));	
		vertex1.setAdjacencyList(new Edge(7, vertex1, vertex4));
		vertex1.setAdjacencyList(new Edge(8, vertex1, vertex6));
		
		vertex2.setAdjacencyList(new Edge(2, vertex2, vertex0));	
		vertex2.setAdjacencyList(new Edge(6, vertex2, vertex3));
		vertex2.setAdjacencyList(new Edge(3, vertex2, vertex5));
		
		vertex3.setAdjacencyList(new Edge(12, vertex3, vertex0));	
		vertex3.setAdjacencyList(new Edge(4, vertex3, vertex1));
		vertex3.setAdjacencyList(new Edge(6, vertex3, vertex2));
		vertex3.setAdjacencyList(new Edge(2, vertex3, vertex4));	
		vertex3.setAdjacencyList(new Edge(5, vertex3, vertex5));
		
		vertex4.setAdjacencyList(new Edge(7, vertex4, vertex1));
		vertex4.setAdjacencyList(new Edge(2, vertex4, vertex3));
		vertex4.setAdjacencyList(new Edge(4, vertex4, vertex5));	
		vertex4.setAdjacencyList(new Edge(9, vertex4, vertex6));
		
		vertex5.setAdjacencyList(new Edge(3, vertex5, vertex2));
		vertex5.setAdjacencyList(new Edge(5, vertex5, vertex3));
		vertex5.setAdjacencyList(new Edge(4, vertex5, vertex4));	
		vertex5.setAdjacencyList(new Edge(2, vertex5, vertex6));
		
		vertex6.setAdjacencyList(new Edge(8, vertex6, vertex1));
		vertex6.setAdjacencyList(new Edge(9, vertex6, vertex4));	
		vertex6.setAdjacencyList(new Edge(2, vertex6, vertex5));
		
		LazyPrimsAlgo prims = new LazyPrimsAlgo(vertexList);
		prims.run(vertex0);
		prims.show();
	}

}
