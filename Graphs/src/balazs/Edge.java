package balazs;

public class Edge {
	private double weight;
	private VertexG startVertex;
	private VertexG targetVertex;
		
	public Edge(double weight, VertexG startVertex, VertexG targetVertex) {
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
	public VertexG getStartVertex() {
		return startVertex;
	}
	public void setStartVertex(VertexG startVertex) {
		this.startVertex = startVertex;
	}
	public VertexG getTargetVertex() {
		return targetVertex;
	}
	public void setTargetVertex(VertexG targetVertex) {
		this.targetVertex = targetVertex;
	}
}
