package balazs;

class GraphColoringAlgo{
	private int nbOfVertexes;
	private int nbOfColors;
	private int[] colors;
	private int [][] graph;
	
	GraphColoringAlgo(int[][] graph, int nbOfColors) {
		this.nbOfColors = nbOfColors;
		this.nbOfVertexes = graph[0].length;
		this.colors = new int[nbOfVertexes];
		this.graph = graph;
	}
	
	public void solve() {
		if(solveProblem(0))
			show();
		else
			System.out.println("OOPS! No solution......");
	}
	
	private boolean solveProblem(int nodeIndex) {
		if(nodeIndex == nbOfVertexes)
			return true;
		
		for(int colorIndex=1; colorIndex<=nbOfVertexes; ++colorIndex) {
			if(isColorValid(nodeIndex, colorIndex)) {
				colors[nodeIndex] = colorIndex;
				
				if(solveProblem(nodeIndex+1))
					return true;
			}
		}
		
		return false;
	}
	
	private boolean isColorValid(int nodeIndex, int colorIndex) {
		for(int i=0; i<nbOfVertexes; i++) {
			if(graph[nodeIndex][i] == 1 && colorIndex == colors[i]) {
				return false;
			}
		}
		return true;
	}
	
	private void show() {
		for(int i=0; i<colors.length; i++)
			System.out.println("Node: " + (i + 1) + " has color index: " + colors[i]);
	}
}


public class GraphColoring {

	public static void main(String[] args) {
		int [][] graph =  
			{   {0,1,1,1,0,0},
				{1,0,1,0,1,1},
				{1,1,0,1,0,1},
				{1,0,1,0,0,1},
				{0,1,0,0,0,1},
				{0,1,1,1,1,0}
			};
		
		GraphColoringAlgo algo = new GraphColoringAlgo(graph, 4);
		algo.solve();
	}

}
