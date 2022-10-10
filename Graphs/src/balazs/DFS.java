package balazs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class DFSAlgoStack{
	private Stack<Vertex> s;
	// Constructor	
	public DFSAlgoStack() {
		super();
		this.s = new Stack<>();
	}

	public void run(List<Vertex> list) {
		// it may happen that we have independent clusters
		for(Vertex v : list) {
			if(!v.isVisited()) {
				v.setVisited(true);
				dfsHelper(v);
			}
		}
	}

	private void dfsHelper(Vertex root) {
		s.add(root);
		root.setVisited(true);
		
		while(!s.isEmpty()) {
			Vertex actual = s.pop();
			System.out.println(actual);
			for(Vertex v : actual.getAdjacencyList()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					s.push(v);
				}
			}
		}
	}
}

class DFSAlgoRecursion{
	public void run(List<Vertex> list) {
		// it may happen that we have independent clusters
		for(Vertex v : list) {
			if(!v.isVisited()) {
				v.setVisited(true);
				dfsHelper(v);
			}
		}
	}
	
	private void dfsHelper(Vertex vertex) {
		System.out.println(vertex);
		
		for(Vertex v : vertex.getAdjacencyList()) {
			if(!v.isVisited()) {
				v.setVisited(true);
				dfsHelper(v);
			}
		}
	}
}

public class DFS {

	public static void main(String[] args) {
//		Vertex v1 = new Vertex("A");
//		Vertex v2 = new Vertex("B");
//		Vertex v3 = new Vertex("C");
//		Vertex v4 = new Vertex("D");
//		Vertex v5 = new Vertex("E");
//		v1.addNeighbor(v2); v1.addNeighbor(v3);
//		v3.addNeighbor(v4);
//		v4.addNeighbor(v5);
//		
//		List<Vertex> list = new ArrayList<>();
//		list.add(v1);
//		list.add(v2);
//		list.add(v3);
//		list.add(v4);
//		list.add(v5);
//		
//		DFSAlgoStack dfs_stack = new DFSAlgoStack();
//		dfs_stack.run(list);
		System.out.println("\n==============\n");
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");
		Vertex v6 = new Vertex("F");
		Vertex v7 = new Vertex("G");
		Vertex v8 = new Vertex("H");
		v1.addNeighbor(v2); v1.addNeighbor(v6); v1.addNeighbor(v7);
		v2.addNeighbor(v3); v2.addNeighbor(v4);
		v4.addNeighbor(v5);
		v7.addNeighbor(v8);
		
		List<Vertex> list = new ArrayList<>();
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		list.add(v6);
		list.add(v7);
		list.add(v8);
		
		DFSAlgoRecursion dfs_re = new DFSAlgoRecursion();
		dfs_re.run(list);
	}

}
