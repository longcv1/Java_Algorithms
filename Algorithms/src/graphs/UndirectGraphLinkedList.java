package graphs;

import java.util.ArrayList;

public class UndirectGraphLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<GraphNodes> nodeList = new ArrayList<GraphNodes>();
		
		nodeList.add(new GraphNodes("A", 0));
		nodeList.add(new GraphNodes("B", 1));
		nodeList.add(new GraphNodes("C", 2));
		nodeList.add(new GraphNodes("D", 3));
		nodeList.add(new GraphNodes("E", 4));
		
		Graph g = new Graph(nodeList);
		g.addUndirectedEdge(0, 1);
		g.addUndirectedEdge(0, 2);
		g.addUndirectedEdge(0, 3);
		g.addUndirectedEdge(1, 4);
		g.addUndirectedEdge(3, 4);
		g.addUndirectedEdge(2, 3);
		
		System.out.println(g.toString());
	}

}
