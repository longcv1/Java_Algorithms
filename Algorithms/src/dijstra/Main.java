package dijstra;

import java.util.ArrayList;
import dijstra.Graph;
import dijstra.Node;

public class Main {

	public static void main(String[] args) {
		ArrayList<Node> nodeList = new ArrayList<Node>();
		nodeList.add(new Node("A", 0));
		nodeList.add(new Node("B", 1));
		nodeList.add(new Node("C", 2));
		nodeList.add(new Node("D", 3));
		nodeList.add(new Node("E", 4));
		nodeList.add(new Node("F", 5));
		nodeList.add(new Node("G", 6));
		
		Graph g = new Graph(nodeList);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 2, 5);
		g.addEdge(1, 2, 6);
		g.addEdge(1, 3, 1);
		g.addEdge(1, 4, 3);
		g.addEdge(2, 5, 8);
		g.addEdge(3, 4, 4);
		g.addEdge(4, 6, 9);
		g.addEdge(5, 6, 7);
		
		System.out.println("Dijkstra from source A:");
		g.Dijkstra(nodeList.get(0));
	}

}
