package common.graph;

public class Edge {
	private double weight;
	private VertexDijstra startVertex;
	private VertexDijstra targetVertex;
	public Edge(double weight, VertexDijstra startVertex, VertexDijstra targetVertex) {
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
	public VertexDijstra getStartVertex() {
		return startVertex;
	}
	public void setStartVertex(VertexDijstra startVertex) {
		this.startVertex = startVertex;
	}
	public VertexDijstra getTargetVertex() {
		return targetVertex;
	}
	public void setTargetVertex(VertexDijstra targetVertex) {
		this.targetVertex = targetVertex;
	}
}
