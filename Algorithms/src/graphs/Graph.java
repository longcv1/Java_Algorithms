package graphs;

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
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		for(int i = 0; i < nodeList.size(); i++) {
			s.append(nodeList.get(i).getName() + ": ");
			
			for(int j = 0 ; j < nodeList.get(i).neighbors.size(); j++) {
				if(j == nodeList.get(i).neighbors.size() - 1) {
					s.append(nodeList.get(i).neighbors.get(j).getName());
				} else {
					s.append(nodeList.get(i).neighbors.get(j).getName() + " -> ");
				}
			}
			
			s.append("\n");
		}
				
		return s.toString();
	}
}
