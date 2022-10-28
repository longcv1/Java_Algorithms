package balazs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Vertex_T {
	private String name;
	private List<Vertex_T> adjacencyList;
	private boolean visited;
	private boolean onStack;
	private int index;
	private int lowLink;
	private int componentId;
	public Vertex_T(String name) {
		super();
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Vertex_T> getNeighbor() {
		return adjacencyList;
	}
	public void addNeighbor(Vertex_T v) {
		this.adjacencyList.add(v);
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public boolean isOnStack() {
		return onStack;
	}
	public void setOnStack(boolean onStack) {
		this.onStack = onStack;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getLowLink() {
		return lowLink;
	}
	public void setLowLink(int lowLink) {
		this.lowLink = lowLink;
	}
	public int getComponentId() {
		return componentId;
	}
	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}
	@Override
	public String toString() {
		return "Vertex " + this.name + " - " + this.componentId;
	}
	
}


class TarjanAlgo {
	private List<Vertex_T> graph;
	private Stack<Vertex_T> stack;
	private int index=0;
	private int counter=0;
	
	public TarjanAlgo(List<Vertex_T> graph) {
		super();
		this.graph = graph;
		this.stack = new Stack<>();
	}
	public void run() {
		for(Vertex_T v : graph) {
			if(!v.isVisited())
				dfs(v);
		}
	}
	private void dfs(Vertex_T vertex) {
		vertex.setIndex(index);
		vertex.setLowLink(index);
		index++;
		vertex.setVisited(true);
		stack.add(vertex);
		vertex.setOnStack(true);
		
		for(Vertex_T v : vertex.getNeighbor()) {
			if(!v.isVisited()) {
				dfs(v);
				// update the low link
				vertex.setLowLink(Math.min(vertex.getLowLink(),v.getLowLink()));
			} else if (v.isOnStack()) {
				vertex.setLowLink(Math.min(v.getIndex(), vertex.getIndex()));
			}
		}
		
		// found the root node of partial of scc
		if(vertex.getIndex() == vertex.getLowLink()) {
			while(true) {
				Vertex_T w = stack.pop();
				w.setOnStack(false);
				w.setComponentId(counter);
				if(w == vertex)
					break;
			}
			counter++;
		}
	}
	
	public void showComponents() {
		for(Vertex_T v : graph) {
			System.out.println(v);
		}
	}
}

public class Tarjan {

	public static void main(String[] args) {
		Vertex_T vertex1 = new Vertex_T("1");
		Vertex_T vertex2 = new Vertex_T("2");
		Vertex_T vertex3 = new Vertex_T("3");
		Vertex_T vertex4 = new Vertex_T("4");
		Vertex_T vertex5 = new Vertex_T("5");
		Vertex_T vertex6 = new Vertex_T("6");
		Vertex_T vertex7 = new Vertex_T("7");
		Vertex_T vertex8 = new Vertex_T("8");
		
		vertex1.addNeighbor(vertex2);
		
		vertex2.addNeighbor(vertex3);
		vertex2.addNeighbor(vertex5);
		vertex2.addNeighbor(vertex6);
		
		vertex3.addNeighbor(vertex4);
		vertex3.addNeighbor(vertex7);
		
		vertex4.addNeighbor(vertex8);
		vertex4.addNeighbor(vertex3);
		
		vertex5.addNeighbor(vertex1);
		vertex5.addNeighbor(vertex6);
		
		vertex6.addNeighbor(vertex7);
		vertex7.addNeighbor(vertex6);
		vertex8.addNeighbor(vertex4);
		vertex8.addNeighbor(vertex7);	
		
		List<Vertex_T> graph = new ArrayList<>();
		graph.add(vertex6);
		graph.add(vertex7);
		graph.add(vertex5);
		graph.add(vertex1);
		graph.add(vertex2);
		graph.add(vertex3);
		graph.add(vertex4);		
		graph.add(vertex8);
		
		TarjanAlgo algorithm = new TarjanAlgo(graph);
		algorithm.run();
		algorithm.showComponents();
	}

}
