package common.graph;

import java.util.ArrayList;
import java.util.List;

public class VertexDijstra implements Comparable<VertexDijstra> {
	private String name;
	private boolean visited;
	private List<Edge> adjacencyList;
	
	// the distance from the starting vertex
	private double distance;
	
	// the previous vertex on the shortest path
	private VertexDijstra predecessor;
	
	public VertexDijstra(String name) {
		super();
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
	public void addNeighbors(Edge e) {
		this.adjacencyList.add(e);
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public VertexDijstra getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(VertexDijstra predecessor) {
		this.predecessor = predecessor;
	}
	
	@Override
	public int compareTo(VertexDijstra o) {
		return Double.compare(this.distance, o.getDistance());
	}
	@Override
	public String toString() {
		return this.name + " - " + this.distance;
	}
}
