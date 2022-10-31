package balazs;

import java.util.ArrayList;
import java.util.List;

class HamiltonAlgo {
	private int[][] graph;
	private boolean[] visited;
	private List<Integer> path;
	private int min;
	public HamiltonAlgo(int[][] graph) {
		super();
		this.graph = graph;
		this.visited = new boolean[graph.length];
		this.path = new ArrayList<>();
		init();
	}
	private void init() {
		visited[0] = true;
		path.add(0);
		min = Integer.MAX_VALUE;
	}
	
	private boolean isValid(int vertex, int actualPostion) {
		// If the vertex is already visited
		// and there is no connection between 2 vertices => it's invalid
		if(visited[vertex] || graph[actualPostion][vertex] ==0)
			return false;
		return true;
	}
	
	public void solve(int actualPostion, int counter, int cost) {
		// And there is a connection between the last and first node
		if(counter == graph.length && graph[actualPostion][0] != 0) {
			path.add(0); // 0 1 2 3 0
			path.forEach(num -> System.out.print(num + " "));
			System.out.println("\nCOST: " + (cost + graph[actualPostion][0] + "\n"));
			
			// tracking the minimum route
			if(cost + graph[actualPostion][0] < min)
				min = cost + graph[actualPostion][0];
			
			// remove the last node
			path.remove(path.size()-1);
			return;
		}
		// We have considered all the vertices in the G(V,E)
		for(int i=0; i<graph.length; i++) {
			if(isValid(i, actualPostion)) {
				visited[i] = true;
				path.add(i);
				solve(i, counter+1, cost + graph[actualPostion][i]);
				
				// BACKTRACK
				visited[i] = false;
				path.remove(path.size()-1);
			}
		}
	}
	
	public void show() {
		System.out.println("Min hamiltonian cycle: " + min);
	}
}

public class HamiltonCycle {

	public static void main(String[] args) {
		// adjacency matrix (graph)
		int[][] graph = {{0, 1, 0, 0, 1},
						 {1, 0, 1, 1, 0},
						 {0, 1, 0, 1, 1},
						 {0, 1, 1, 0, 1},
						 {1, 0, 1, 1, 0}};
		HamiltonAlgo tsp = new HamiltonAlgo(graph);
		tsp.solve(0, 1, 0);
		tsp.show();
	}

}
