import java.util.LinkedList;
import java.util.Queue;

import common.graph.*; 


/****************************************
 * BFS(vertex)
 *  	Queue queue
 *  	vertex set visited true
 * 		queue.enqueue(vertex)
 * 
 * 		while queue is not empty
 * 			actual = queue.dequeue()
 * 			for v in actual neighbors
 * 				if v is not visited
 * 					v set visited true
 * 					queue.enqueue(v)
 * 					
 * **************************************/

class BreadthFistSearch{
	public void run(Vertex root) {
		Queue<Vertex> q = new LinkedList<>();
		root.setVisited(true);
		q.add(root);
		
		while(!q.isEmpty()) {
			Vertex current = q.remove();
			System.out.println("Vertex: " + current);
			
			for(Vertex v : current.getNeighbors()) {
				if(!v.isVisited()) {
					v.setVisited(true);
					q.add(v);
				}
			}
		}
	}
}



public class BFS {

	public static void main(String[] args) {
//		                            A
//		                         /  |  \
//		                        B   F   G
//		                      /  \     /
//		                     C   D    H
//		                        /
//		                       E
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");
		
		a.addNeighbor(b); a.addNeighbor(f); a.addNeighbor(g);
		b.addNeighbor(a); b.addNeighbor(c); b.addNeighbor(d);
		f.addNeighbor(a);
		g.addNeighbor(a); g.addNeighbor(h);
		c.addNeighbor(b);
		d.addNeighbor(b); d.addNeighbor(e);
		h.addNeighbor(g);
		e.addNeighbor(d);
		
		BreadthFistSearch bfs = new BreadthFistSearch();
		bfs.run(a);
	}

}
