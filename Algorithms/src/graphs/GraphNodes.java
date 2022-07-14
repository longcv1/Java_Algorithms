package graphs;

import java.util.ArrayList;

public class GraphNodes {
	String m_Name;
	int m_Index;
	ArrayList<GraphNodes> neighbors = new ArrayList<GraphNodes>();
	
	public GraphNodes(String name, int index) {
		// TODO Auto-generated constructor stub
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
