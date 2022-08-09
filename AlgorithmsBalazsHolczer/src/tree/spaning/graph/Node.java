package tree.spaning.graph;

public class Node {
	// the approximate count of nodes below this node
	private int height;
	private Node parentNode;
	public Node(int height, Node parentNode) {
		super();
		this.height = height;
		this.parentNode = parentNode;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Node getParentNode() {
		return parentNode;
	}
	public void setParentNode(Node parentNode) {
		this.parentNode = parentNode;
	}
}
