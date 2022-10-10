package balazs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
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
