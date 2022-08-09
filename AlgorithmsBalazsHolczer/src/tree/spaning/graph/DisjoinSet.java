package tree.spaning.graph;

import java.util.*;

public class DisjoinSet {
	public DisjoinSet(List<Vertex> vertexList) {
		makeSets(vertexList);
	}
	private void makeSets(List<Vertex> vertexList) {
		for(Vertex v : vertexList)
			makeSet(v);
	}
	private void makeSet(Vertex v) {
		Node node = new Node(0, null);
		v.setNode(node);
	}
	
	// find the representative (root node) for node
	public Node find(Node node) {
		Node actual = node;
		//find the root
		while(actual.getParentNode() != null) {
			actual = actual.getParentNode();
		}
		
		// "path compression" to sure that the next time we look for
		// the representative of node is O(1).
		Node root = actual;
		actual = node;
		while(actual != root) {
			Node temp = actual.getParentNode();
			actual.setParentNode(root);
			actual = temp;
		}
		
		return root;
	}
	
	public void union(Node node1, Node node2) {
		Node root1 = find(node1);
		Node root2 = find(node2);
		
		if(root1 == root2) {
			return;
		}
		
		if(root1.getHeight() < root2.getHeight()) {
			root1.setParentNode(root2);
		} else if(root2.getHeight() < root1.getHeight()) {
			root2.setParentNode(root1);
		} else {
			root2.setParentNode(root1);
			root1.setHeight(root1.getHeight()+1);
		}
	}
}
