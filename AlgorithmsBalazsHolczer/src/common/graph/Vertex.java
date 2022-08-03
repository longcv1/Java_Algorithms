package common.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
	protected String name;
	protected boolean visited;
	protected List<Vertex> neighborsList;
	
	public Vertex(String name) {
		this.name = name;
		this.visited = false;
		this.neighborsList = new ArrayList<Vertex>();
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

	public List<Vertex> getNeighbors() {
		return this.neighborsList;
	}

	public void addNeighbor(Vertex v) {
		this.neighborsList.add(v);
	}

	@Override
	public String toString() {
		return this.name;
	}
}
