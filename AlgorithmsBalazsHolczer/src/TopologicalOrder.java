import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import common.graph.Vertex;

class Topological {
	private Stack<Vertex> stack;
	
	public Topological() {
		this.stack = new Stack<>();
	}
	
	public void dfs(Vertex vertex) {
		vertex.setVisited(true);
		
		for (Vertex v : vertex.getNeighbors()) {
			if(!v.isVisited()) {
				dfs(v);
			}
		}
		stack.push(vertex);
	}
	
	public Stack<Vertex> getStack() {
		return this.stack;
	}
}


public class TopologicalOrder {

	public static void main(String[] args) {
		
		Topological ordering = new Topological();
		
		List<Vertex> graph = new ArrayList<>();
		graph.add(new Vertex("0"));
		graph.add(new Vertex("1"));
		graph.add(new Vertex("2"));
		graph.add(new Vertex("3"));
		graph.add(new Vertex("4"));
		graph.add(new Vertex("5"));
		
		graph.get(2).addNeighbor(graph.get(3));
		graph.get(3).addNeighbor(graph.get(1));
		graph.get(4).addNeighbor(graph.get(0));
		graph.get(4).addNeighbor(graph.get(1));
		graph.get(5).addNeighbor(graph.get(0));
		graph.get(5).addNeighbor(graph.get(2));
		
		for(int i = 0 ; i < graph.size() ; ++i) {
			if(!graph.get(i).isVisited())
				ordering.dfs(graph.get(i));
		}
		
		Stack<Vertex> s = ordering.getStack();
		for(int i = 0; i < graph.size(); ++i) {
			System.out.println(s.pop());
		}
	}

}
