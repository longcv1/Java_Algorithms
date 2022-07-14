package bfs;

public class GraphNodes {
	String m_Name;
	int m_Index;
	boolean isVisited = false;
	
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public GraphNodes(String name, int index) {
		m_Name = name;
		m_Index = index;
	}

	public String getName() {
		return m_Name;
	}

	public void setName(String name) {
		this.m_Name = name;
	}

	public int getIndex() {
		return m_Index;
	}

	public void setIndex(int index) {
		this.m_Index = index;
	}

}
