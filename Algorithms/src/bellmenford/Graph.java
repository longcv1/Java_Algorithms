package bellmenford;

import java.util.*;
import bellmenford.Node;

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
	
	void BellmenFord(Node sourceNode) {
		sourceNode.distance = 0;
		for(int i = 0; i < nodeList.size(); i ++) {
			for(Node currentNode : nodeList) {
				for(Node neighbor : currentNode.neighbors) {
					if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
						neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
						neighbor.parent = currentNode;
					}
				}
			}
		}
		
		System.out.println("Checking for negative cycle.......");
		for(Node currentNode : nodeList) {
			for(Node neighbor : currentNode.neighbors) {
				if(neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
					System.out.println("Negative cycle found.....!");
					System.out.println("Vertex name: " + neighbor.name);
					System.out.println("Old cost: " + neighbor.distance);
					int newDistance = currentNode.distance + currentNode.weightMap.get(neighbor);
					System.out.println("New cost: " + newDistance);
					return;
				}
			}
		}
		
		System.out.println("Negative cycle not found!!!!!!!!");
		for(Node nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", path: ");
			pathPrint(nodeToCheck);
		}
	}

	public void pathPrint(Node node) {
		if(node.parent != null) {
			pathPrint(node.parent);
		}
		System.out.print(node.name + " ");
		System.out.println();
	}
}
