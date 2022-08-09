package tree.spaning.graph;

import java.util.*;

class KruskalAlgo{
	public void run(List<Vertex> vertexList, List<Edge> edgeList) {
		DisjoinSet disjoinSet = new DisjoinSet(vertexList);
		List<Edge> mst = new ArrayList<>();
		
		Collections.sort(edgeList);
		
		for(Edge edge : edgeList) {
			Vertex u = edge.getStartVertex();
			Vertex v = edge.getTargeVertex();
			
			if(disjoinSet.find(u.getNode()) != disjoinSet.find(v.getNode()))
				mst.add(edge);
			
			disjoinSet.union(u.getNode(), v.getNode());
		}
		
		for(Edge e : mst) {
			System.out.println(e);
		}
	}
}


public class Kruskal {

	public static void main(String[] args) {
		List<Vertex> vlist = new ArrayList<>();
		vlist.add(new Vertex("A"));
		vlist.add(new Vertex("B"));
		vlist.add(new Vertex("C"));
		vlist.add(new Vertex("D"));
		vlist.add(new Vertex("E"));
		vlist.add(new Vertex("F"));
		vlist.add(new Vertex("G"));
		vlist.add(new Vertex("H"));
		
		List<Edge> elist = new ArrayList<>();
		elist.add(new Edge(3,  vlist.get(0), vlist.get(1)));
		elist.add(new Edge(2,  vlist.get(0), vlist.get(2)));
		elist.add(new Edge(5,  vlist.get(0), vlist.get(3)));
		elist.add(new Edge(13, vlist.get(1), vlist.get(5)));
		elist.add(new Edge(2,  vlist.get(1), vlist.get(3)));
		elist.add(new Edge(5,  vlist.get(2), vlist.get(4)));
		elist.add(new Edge(2,  vlist.get(2), vlist.get(3)));
		elist.add(new Edge(4,  vlist.get(3), vlist.get(4)));
		elist.add(new Edge(6,  vlist.get(3), vlist.get(5)));
		elist.add(new Edge(3,  vlist.get(3), vlist.get(6)));
		elist.add(new Edge(6,  vlist.get(4), vlist.get(6)));
		elist.add(new Edge(2,  vlist.get(5), vlist.get(6)));
		elist.add(new Edge(3,  vlist.get(5), vlist.get(7)));
		elist.add(new Edge(6,  vlist.get(6), vlist.get(7)));
		
		KruskalAlgo kruskal = new KruskalAlgo();
		kruskal.run(vlist, elist);
	}

}
