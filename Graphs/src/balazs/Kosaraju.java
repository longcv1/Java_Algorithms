package balazs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class VertexScc {
	private int id;
	private String name;
	private boolean visited;
	private List<VertexScc> adjacencyList;
	private int componentId;

	public VertexScc(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}

	@Override
	public String toString() {
		return this.name;
	}

	public void addNeighbor(VertexScc vertex) {
		this.adjacencyList.add(vertex);
	}

	public boolean isVisited() {
		return visited;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getComponentId() {
		return componentId;
	}

	public void setComponentId(int componentId) {
		this.componentId = componentId;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<VertexScc> getNeighbor() {
		return this.adjacencyList;
	}
}

class EdgeScc {
	private double weight;
	private VertexScc startVertex;
	private VertexScc targetVertex;

	public EdgeScc(double weight, VertexScc startVertex, VertexScc targetVertex) {
		super();
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public VertexScc getStartVertex() {
		return startVertex;
	}

	public void setStartVertex(VertexScc startVertex) {
		this.startVertex = startVertex;
	}

	public VertexScc getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(VertexScc targetVertex) {
		this.targetVertex = targetVertex;
	}
}

class Graph {
	private List<VertexScc> vertexList;
	private List<EdgeScc> edgeList;

	public Graph(List<VertexScc> vertexList, List<EdgeScc> edgeList) {
		super();
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}

	public Graph() {
		// TODO Auto-generated constructor stub
	}

	public List<VertexScc> getVertexList() {
		return vertexList;
	}

	public void setVertexList(List<VertexScc> vertexList) {
		this.vertexList = vertexList;
	}

	public List<EdgeScc> getEdgeList() {
		return edgeList;
	}

	public void setEdgeList(List<EdgeScc> edgeList) {
		this.edgeList = edgeList;
	}

	public Graph getTransposeGraph() {
		Graph transposeGraph = new Graph();
		List<VertexScc> transposeList = new ArrayList<>();

		// transposed G'(V,E) contains the exact same vertex
		for (VertexScc v : this.vertexList) {
			transposeList.add(v);
		}

		// revert the edges(A->C become C->A)
		for (EdgeScc e : this.edgeList) {
			transposeList.get(e.getTargetVertex().getId()).addNeighbor(e.getStartVertex());
		}

		transposeGraph.setVertexList(transposeList);
		return transposeGraph;
	}
}

class DfsOrder {
	private Stack<VertexScc> stack = new Stack<>();

	public DfsOrder(Graph graph) {
		for (VertexScc v : graph.getVertexList()) {
			if (!v.isVisited()) {
				dfs(v);
			}
		}
	}

	private void dfs(VertexScc vertex) {
		vertex.setVisited(true);
		for (VertexScc v : vertex.getNeighbor()) {
			if (!v.isVisited())
				dfs(v);
		}
		// push a node has been visited into the stack
		stack.push(vertex);
	}

	public Stack<VertexScc> getStack() {
		return this.stack;
	}
}

class KosarajuAlgo {
	// we have to make 2 DFS
	// number of strongly connected components
	private int count;
	// track the SCC in the 2nd iteration
	private boolean[] marked;

	public KosarajuAlgo(Graph graph) {
		// first DFS on the G'(V,E) graph
		DfsOrder dfs = new DfsOrder(graph.getTransposeGraph());

		marked = new boolean[graph.getVertexList().size()];

		// we do another DFS on the original G(V,E) graph
		for (VertexScc v : dfs.getStack()) {
			if (!marked[v.getId()]) {
				dfs(v);
				count++;
			}
		}
	}

	private void dfs(VertexScc vertex) {
		marked[vertex.getId()] = true;
		vertex.setComponentId(count);

		for (VertexScc v : vertex.getNeighbor())
			if (!marked[v.getId()])
				dfs(v);
	}

	public int getCount() {
		return this.count;
	}
}

public class Kosaraju {

	public static void main(String[] args) {
		List<VertexScc> vertexList = new ArrayList<>();

		vertexList.add(new VertexScc(0, "A"));
		vertexList.add(new VertexScc(1, "B"));
		vertexList.add(new VertexScc(2, "C"));
		vertexList.add(new VertexScc(3, "D"));
		vertexList.add(new VertexScc(4, "E"));
		vertexList.add(new VertexScc(5, "F"));
		vertexList.add(new VertexScc(6, "G"));
		vertexList.add(new VertexScc(7, "H"));

		List<EdgeScc> edgeList = new ArrayList<EdgeScc>();

		edgeList.add(new EdgeScc(1, vertexList.get(0), vertexList.get(1)));

		edgeList.add(new EdgeScc(1, vertexList.get(1), vertexList.get(2)));
		edgeList.add(new EdgeScc(1, vertexList.get(1), vertexList.get(4)));
		edgeList.add(new EdgeScc(1, vertexList.get(1), vertexList.get(5)));

		edgeList.add(new EdgeScc(1, vertexList.get(2), vertexList.get(3)));
		edgeList.add(new EdgeScc(1, vertexList.get(2), vertexList.get(6)));

		edgeList.add(new EdgeScc(1, vertexList.get(3), vertexList.get(2)));
		edgeList.add(new EdgeScc(1, vertexList.get(3), vertexList.get(7)));

		edgeList.add(new EdgeScc(1, vertexList.get(4), vertexList.get(0)));
		edgeList.add(new EdgeScc(1, vertexList.get(4), vertexList.get(5)));

		edgeList.add(new EdgeScc(1, vertexList.get(5), vertexList.get(6)));

		edgeList.add(new EdgeScc(1, vertexList.get(6), vertexList.get(5)));

		edgeList.add(new EdgeScc(1, vertexList.get(7), vertexList.get(3)));
		edgeList.add(new EdgeScc(1, vertexList.get(7), vertexList.get(6)));

		Graph graph = new Graph(vertexList, edgeList);
		KosarajuAlgo algorithm = new KosarajuAlgo(graph);
		System.out.println(algorithm.getCount());

		for (VertexScc vertex : vertexList)
			System.out.println(vertex + " - " + vertex.getComponentId());

	}

}
