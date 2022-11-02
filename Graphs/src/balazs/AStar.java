package balazs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class NodeA {
	private String name;
	private double x;
	private double y;
	private double g;
	private double h;
	private double f; // f = g(x) + h(x)
	private List<EdgeA> adjacencyList;
	private NodeA parent;
	public NodeA(String name, double x, double y) {
		super();
		this.x = x;
		this.y = y;
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getG() {
		return g;
	}
	public void setG(double g) {
		this.g = g;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public double getF() {
		return f;
	}
	public void setF(double f) {
		this.f = f;
	}
	public List<EdgeA> getNeighbor() {
		return adjacencyList;
	}
	public void addNeighbor(EdgeA e) {
		this.adjacencyList.add(e);
	}
	public NodeA getParent() {
		return parent;
	}
	public void setParent(NodeA parent) {
		this.parent = parent;
	}
	@Override
	public String toString() {
		return name;
	}
}

class NodeCompare implements Comparator<NodeA> {
	@Override
	public int compare(NodeA o1, NodeA o2) {
		return Double.compare(o1.getF(), o2.getF());
	}
}

class EdgeA {
	private double weight;
	private NodeA target;
	public EdgeA(NodeA target, double weight) {
		super();
		this.weight = weight;
		this.target = target;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public NodeA getTarget() {
		return target;
	}
}

class AStarAlgo {
	private NodeA source;
	private NodeA dest;
	private Set<NodeA> explored;
	private PriorityQueue<NodeA> queue;
	public AStarAlgo(NodeA source, NodeA dest) {
		super();
		this.source = source;
		this.dest = dest;
		this.explored = new HashSet<>();
		this.queue = new PriorityQueue<>(new NodeCompare());
	}
	
	public void run() {
		queue.add(source);
		while(!queue.isEmpty()) {
			NodeA current = queue.poll();
			explored.add(current);
			
			// Found the destination node
			if(current == dest)
				break;
			
			// Consider adjacent nodes
			for(EdgeA e : current.getNeighbor()) {
				NodeA child = e.getTarget();
				double cost = e.getWeight();
				double tempG = current.getG() + cost;
				double tempF = tempG + heuristic(current, dest);
				
				// If we haven't consider the child and the f(x) is higher
				if(explored.contains(child) && tempF >= child.getF()) {
					continue;
				}
				// Else if we haven't visited OR the f(x) is lower
				else if(!queue.contains(child) || tempF <= child.getF()) {
					child.setParent(current);
					child.setG(tempG);
					child.setF(tempF);
					
					// re-insert lower value in the queue
					if(queue.contains(child))
						queue.remove(child);
					queue.add(child);
				}
			}
		}
	}

	private double heuristic(NodeA n1, NodeA n2) {
		return Math.sqrt(
							((n1.getX()-n2.getX()) * (n1.getX()-n2.getX())) +
							((n1.getY()-n2.getY()) * (n1.getY()-n2.getY()))
						);
	}
	
	public void show() {
		List<NodeA> path = new ArrayList<>();
		for(NodeA node=dest; node!=null; node=node.getParent()) {
			path.add(node);	
		}
		Collections.reverse(path);
		System.out.println(path);
	}
	
}

public class AStar {

	public static void main(String[] args) {
		NodeA n1 = new NodeA("A",0,0);
        NodeA n2 = new NodeA("B",10,20);
        NodeA n3 = new NodeA("C",20,40);
        NodeA n4 = new NodeA("D",30,10);
        NodeA n5 = new NodeA("E",40,30);
        NodeA n6 = new NodeA("F",50,10);
        NodeA n7 = new NodeA("G",50,40);
        
        n1.addNeighbor(new EdgeA(n2, 10));
        n1.addNeighbor(new EdgeA(n4, 50));
        
        n2.addNeighbor(new EdgeA(n3, 10));
        n2.addNeighbor(new EdgeA(n4, 20));
        
        n3.addNeighbor(new EdgeA(n5, 10));
        n3.addNeighbor(new EdgeA(n7, 30));
        
        n4.addNeighbor(new EdgeA(n6, 80));
        
        n5.addNeighbor(new EdgeA(n6, 50));
        n5.addNeighbor(new EdgeA(n7, 10));
        
        n7.addNeighbor(new EdgeA(n6, 10));
		
        AStarAlgo search = new AStarAlgo(n1,n6);
        search.run();
        search.show();

	}

}
