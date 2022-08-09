package tree.spaning.graph;

public class Edge implements Comparable<Edge> {
	private double weight;
	private Vertex startVertex;
	private Vertex targeVertex;
	public Edge(double weight, Vertex startVertex, Vertex targeVertex) {
		super();
		this.weight = weight;
		this.startVertex = startVertex;
		this.targeVertex = targeVertex;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Vertex getStartVertex() {
		return startVertex;
	}
	public void setStartVertex(Vertex startVertex) {
		this.startVertex = startVertex;
	}
	public Vertex getTargeVertex() {
		return targeVertex;
	}
	public void setTargeVertex(Vertex targeVertex) {
		this.targeVertex = targeVertex;
	}
	
	@Override
	public int compareTo(Edge o) {
		return Double.compare(this.weight, o.getWeight());
	}
	@Override
	public String toString() {
		return startVertex + " - " + targeVertex;
	}	
}
