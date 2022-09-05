package balazs;

class HamiltonAlgo{
	private int nbOfVertexes;
	private int[] hamiltonPath;
	private int[][] adjacencyMatrix;
	public HamiltonAlgo(int[][] adjacencyMatrix) {
		super();
		this.adjacencyMatrix = adjacencyMatrix;
		this.nbOfVertexes = adjacencyMatrix[0].length;
		this.hamiltonPath = new int[nbOfVertexes];
	}
	
	private boolean isFindSolution(int position) {
		if(position == this.nbOfVertexes) {
			// there is a connection back to first vertex => cycle form
			if(adjacencyMatrix[hamiltonPath[position-1]][hamiltonPath[0]] == 1)
				return true;
			else
				return false;
		}
		
		// try all possible vertex in graph
		for(int i=1; i<nbOfVertexes; i++) {
			// if the vertex is valid then this is the next vertex in Hamilton cycle
			if(isValid(i, position)) {
				hamiltonPath[position] = i;
				
				if(isFindSolution(position+1))
					return true;
			}
		}
		
		return false;
	}
	
	private boolean isValid(int vertex, int curPosition) {
		// Check if 2 vertexes are connected
		if(adjacencyMatrix[hamiltonPath[curPosition-1]][vertex] == 0)
			return false;
		
		// Check already visited this given vertex
		for(int i=0; i<curPosition; i++) {
			if(hamiltonPath[i] == vertex)
				return false;
		}
		return true;
	}
	
	private void showResult() {
		System.out.println("Hamilton Cycle exists: ");
		for(int i=0; i<hamiltonPath.length; i++) {
			System.out.print(hamiltonPath[i] + " - ");
		}
	}
	
	public void solve() {
		// Start with first vertex (index 0)
		hamiltonPath[0] = 0;
		if(isFindSolution(1)) {
			showResult();
		} else {
			System.out.println("OOPS! Cannot find solution :(");
		}
	}
}


public class HamiltonCycle {

	public static void main(String[] args) {
		int [][] adjacencyMatrix =  {   {0,1,0,0,0,1},
										{1,0,1,0,0,0},
										{0,1,0,0,1,0},
										{0,0,0,0,1,1},
										{0,0,1,1,0,1},
										{1,0,0,1,1,0}
									};
		HamiltonAlgo algo = new HamiltonAlgo(adjacencyMatrix);
		algo.solve();
	}

}
