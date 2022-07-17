package bfs_linked_list;

import java.util.*;

public class Graph {
	
	ArrayList<GraphNodes> nodeList = new ArrayList<GraphNodes>();
	
	public Graph(ArrayList<GraphNodes> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void addUndirectedEdge(int i, int j) {
		GraphNodes first = nodeList.get(i);
		GraphNodes second = nodeList.get(j);
		
		first.neighbors.add(second);
		second.neighbors.add(first);
	}
	
	public void bfsVisit(GraphNodes node) {
		LinkedList<GraphNodes> que = new LinkedList<GraphNodes>();
		que.add(node);
		
		while(!que.isEmpty()) {
			GraphNodes current = que.remove(0);
			current.isVisited = true;
			
			System.out.print(current.name + "  ");
			for(GraphNodes neighbor : current.neighbors) {
				if(!neighbor.isVisited) {
					que.add(neighbor);
					neighbor.isVisited = true;
				}
			}
		}
	}
	
	public void bfsLinkedList() {
		for(GraphNodes node : nodeList) {
			if(!node.isVisited) {
				bfsVisit(node);
			}
		}
	}
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for(int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).name + ": ");
			
			for(int j = 0 ; j < nodeList.get(i).neighbors.size(); j++) {
				if(j == nodeList.get(i).neighbors.size() - 1) {
					s.append(nodeList.get(i).neighbors.get(j).name);
				} else {
					s.append(nodeList.get(i).neighbors.get(j).name + " -> ");
				}
			}
			
			s.append("\n");
		}
				
		return s.toString();
	}
}
