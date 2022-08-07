import java.util.Stack;

import common.graph.*; 

/****************************************
 * DFS(vertex)
 *  	Stack stack
 *  	stack.push(vertex)
 *  
 * 		while stack is not empty
 * 			actual = stack.pop()
 * 			actual set visited true
 * 
 * 			for v in actual neighbors
 * 				if v is not visited
 * 					stack.push(v)
 * 					
 * **************************************/

class DepthFirstSearch{
	public void run(Vertex root) {
		Stack<Vertex> stk = new Stack<>();
		stk.push(root);
		
		while(!stk.isEmpty()) {
			Vertex actual = stk.pop();
			actual.setVisited(true);
			System.out.println("Vertex - " + actual);
			
			for(Vertex v : actual.getNeighbors()) {
				if(!v.isVisited()) {
					stk.push(v);
				}
			}
		}
	}
}

public class DFS {

	public static void main(String[] args) {
//        A
//     /  |  \
//    B   F   G
//  /  \     /
// C   D    H
//    /
//   E
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
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.run(a);
	}
}
