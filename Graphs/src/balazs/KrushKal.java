package balazs;

import java.util.ArrayList;
import java.util.List;

class Node {
	private int height;
	private Node parent;
	public Node(int height, Node parent) {
		super();
		this.height = height;
		this.parent = parent;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
}

class _Vertex_ {
	private String name;
	private Node node;
	public _Vertex_(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return name;
	}
}

class _Edge_ {
	private double weight;
	private _Vertex_ startVertex;
	private _Vertex_ targetVertex;
		
	public _Edge_(_Vertex_ startVertex, _Vertex_ targetVertex, double weight) {
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
	public _Vertex_ getStartVertex() {
		return startVertex;
	}
	public void setStartVertex(_Vertex_ startVertex) {
		this.startVertex = startVertex;
	}
	public _Vertex_ getTargetVertex() {
		return targetVertex;
	}
	public void setTargetVertex(_Vertex_ targetVertex) {
		this.targetVertex = targetVertex;
	}
	@Override
	public String toString() {
		return "[" + startVertex + "-" + targetVertex + "]";
	}
	
}

class DisjoinSet {
	public DisjoinSet(List<_Vertex_> vertexList) {
		makeSets(vertexList);
	}

	private void makeSets(List<_Vertex_> vertexList) {
		for(_Vertex_ v : vertexList) {
			Node node = new Node(0, null);
			v.setNode(node);
		}
	}
	
	// Find the representative (root node) for node n
	public Node find(Node node) {
		Node actual = node;
		
		// find the representative
		while(actual.getParent() != null) {
			actual = actual.getParent();
		}
		
		// path compression to make sure that next time we look for the
		// representative of the node is O(1)
		Node root = actual;
		actual = node;
		while(actual != root) {
			Node temp = actual.getParent();
			actual.setParent(root);
			actual = temp;
		}
				
		return root;
	}
	
	public void union(Node node1, Node node2) {
		Node root1 = find(node1);
		Node root2 = find(node2);
		
		if(root1 == root2)
			return;
		// Attach the smaller tree to the root of the larger tree
		if(root1.getHeight() < root2.getHeight()) {
			root1.setParent(root2);
		} else if (root2.getHeight() < root1.getHeight()) {
			root2.setParent(root1);
		} else {
			root2.setParent(root1);
			root1.setHeight(root1.getHeight() + 1);
		}
	}
}

class KruskalAlgorithm {
	public void run(List<_Vertex_> vertexList, List<_Edge_> edgeList) {
		DisjoinSet dis = new DisjoinSet(vertexList);
		List<_Edge_> mst = new ArrayList<>();
		
		// User merge sort to sort the edges
		// Collections.sort();
		edgeList.sort((e1, e2) -> Double.compare(e1.getWeight(), e2.getWeight()));
		for(_Edge_ e : edgeList) {
			_Vertex_ u = e.getStartVertex();
			_Vertex_ v = e.getTargetVertex();
			
			// The edge is in the MST is the nodes are in different sets
			if(dis.find(u.getNode()) != dis.find(v.getNode())) {
				mst.add(e);
			}
			
			// Merge the sets
			dis.union(u.getNode(), v.getNode());
		}
		
		for(_Edge_ e : mst) {
			System.out.println(e);
		}
	}
}

public class KrushKal {

	public static void main(String[] args) {
		List<_Vertex_> vertexList = new ArrayList<>();
		vertexList.add(new _Vertex_("A"));
		vertexList.add(new _Vertex_("B"));
		vertexList.add(new _Vertex_("C"));
		vertexList.add(new _Vertex_("D"));
		vertexList.add(new _Vertex_("E"));
		vertexList.add(new _Vertex_("F"));
		vertexList.add(new _Vertex_("G"));
		vertexList.add(new _Vertex_("H"));
		
		List<_Edge_> edgeList = new ArrayList<>();
		edgeList.add(new _Edge_(vertexList.get(0), vertexList.get(1), 3));
		edgeList.add(new _Edge_(vertexList.get(0), vertexList.get(2), 2));
		edgeList.add(new _Edge_(vertexList.get(0), vertexList.get(3), 5));
		edgeList.add(new _Edge_(vertexList.get(1), vertexList.get(5), 13));
		edgeList.add(new _Edge_(vertexList.get(1), vertexList.get(3), 2));
		edgeList.add(new _Edge_(vertexList.get(2), vertexList.get(4), 5));
		edgeList.add(new _Edge_(vertexList.get(2), vertexList.get(3), 2));
		edgeList.add(new _Edge_(vertexList.get(3), vertexList.get(4), 4));
		edgeList.add(new _Edge_(vertexList.get(3), vertexList.get(5), 6));
		edgeList.add(new _Edge_(vertexList.get(3), vertexList.get(6), 3));
		edgeList.add(new _Edge_(vertexList.get(4), vertexList.get(6), 6));
		edgeList.add(new _Edge_(vertexList.get(5), vertexList.get(6), 2));
		edgeList.add(new _Edge_(vertexList.get(5), vertexList.get(7), 3));
		edgeList.add(new _Edge_(vertexList.get(6), vertexList.get(7), 6));
		
		KruskalAlgorithm algorithm = new KruskalAlgorithm();
		algorithm.run(vertexList,  edgeList);
	}

}
