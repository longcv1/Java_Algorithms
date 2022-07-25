package dijstra;

import java.util.*;

public class Node implements Comparable<Node> {
	String name;
	ArrayList<Node> neighbors = new ArrayList<Node>();
	HashMap<Node, Integer> weightMap = new HashMap<>();
	boolean isVisited = false;
	Node parent;
	int distance;
	int index;
	
	Node(String name, int index){
		this.name = name;
		this.index = index;
		this.distance = Integer.MAX_VALUE;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.distance - o.distance;
	}
	
}
