package karimov;

public class Activities {
	private String name;
	private int startTime;
	private int finishTime;
	
	// Constructor
	public Activities(String name, int startTime, int finishTime) {
		this.name = name;
		this.startTime = startTime;
		this.finishTime = finishTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(int finishTime) {
		this.finishTime = finishTime;
	}
	
	@Override
	public String toString() {
		return "Activities: " + this.name + ", start time: " + this.startTime + ", finish time: " + this.finishTime;
	}
}
