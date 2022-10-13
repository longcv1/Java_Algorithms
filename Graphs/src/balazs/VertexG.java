package balazs;

import java.util.ArrayList;
import java.util.List;

public class VertexG implements Comparable<VertexG>{
	private String name;
	private boolean visited;
	private List<Edge> adjacencyList;
	private double distance;
	private VertexG predecessor;
	
	public VertexG(String name) {
		this.name = name;
		this.adjacencyList = new ArrayList<>();
		this.distance = Double.MAX_VALUE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Edge> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(Edge edge) {
		this.adjacencyList.add(edge);
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public VertexG getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(VertexG predecessor) {
		this.predecessor = predecessor;
	}
	
	@Override
	public int compareTo(VertexG o) {
		return Double.compare(distance, o.getDistance());
	}
	@Override
	public String toString() {
		return this.name + "-" + this.distance;
	}
}
