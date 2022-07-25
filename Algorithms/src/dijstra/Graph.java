package dijstra;

import java.util.*;

public class Graph {
	ArrayList<Node> nodeList = new ArrayList<Node>();
	
	public Graph(ArrayList<Node> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void addEdge(int i, int j, int d) {
		Node first = nodeList.get(i);
		Node second = nodeList.get(j);
		first.neighbors.add(second);
		first.weightMap.put(second, d);
	}
	
	void Dijkstra(Node node) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		node.distance = 0;
		queue.addAll(nodeList);
		
		while(!queue.isEmpty()) {
			Node currentNode = queue.remove();
			for(Node neighbor: currentNode.neighbors) {
				if(queue.contains(neighbor)) {
					if(currentNode.distance + currentNode.weightMap.get(neighbor) < neighbor.distance) {
						neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
						neighbor.parent = currentNode;
						// Refresh the queue with new value
						queue.add(neighbor);
					}	
				}
			}
		}
		
		for(Node nodeToCheck : nodeList) {
			System.out.println("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", path: ");
			pathPrint(nodeToCheck);
		}
	}

	public void pathPrint(Node node) {
		if(node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.println(node.name + " ");
	}
}
