package bfs_linked_list;

import java.util.ArrayList;

public class GraphNodes {
	String name;
	int index;
	boolean isVisited = false;
	ArrayList<GraphNodes> neighbors = new ArrayList<GraphNodes>();
	
	public GraphNodes(String name, int index) {
		this.name = name;
		this.index = index;
	}
}
