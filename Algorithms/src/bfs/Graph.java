package bfs;

import java.util.*;

public class Graph {
	
	ArrayList<GraphNodes> nodeList = new ArrayList<GraphNodes>();
	int[][] adjacentMatrix;
	
	public Graph(ArrayList<GraphNodes> nodeList) {
		this.nodeList = nodeList;
		adjacentMatrix = new int[nodeList.size()][nodeList.size()];
		
	}
	
	public void addUndirectedEdge(int i, int j) {
		adjacentMatrix[i][j] = 1;
		adjacentMatrix[j][i] = 1;
	}
	
	public ArrayList<GraphNodes> getNeighbors(GraphNodes node){
		ArrayList<GraphNodes> neighbor = new ArrayList<GraphNodes>();
		int nodeIndex = node.getIndex();
		
		for(int i = 0 ; i < adjacentMatrix.length ; i++) {
			if(adjacentMatrix[nodeIndex][i] == 1) {
				neighbor.add(nodeList.get(i));
			}
		}
		
		return neighbor;
	}
	
	void BFSVisit(GraphNodes node) {
		LinkedList<GraphNodes> q = new LinkedList<GraphNodes>();
		
		q.add(node);
		
		while(!q.isEmpty()) {
			GraphNodes current = q.remove(0);
			current.setVisited(true);
			System.out.print(current.getName() + " ");
			
			ArrayList<GraphNodes> neighbors = getNeighbors(current);
			for(GraphNodes n : neighbors) {
				if(!n.isVisited()) {
					q.add(n);
					n.setVisited(true);
				}
			}
		}
		
	}
	
	public void BFS() {
		for(GraphNodes node : nodeList) {
			if(!node.isVisited()) {
				BFSVisit(node);
			}
		}
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("   ");
		
		for(int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).getName() + " ");
		}
		
		s.append("\n");
		
		for(int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).getName() + ": ");
			for(int j : adjacentMatrix[i]) {
				s.append(j + " "); 
			}
			s.append("\n");
		}
				
		return s.toString();
	}
}
