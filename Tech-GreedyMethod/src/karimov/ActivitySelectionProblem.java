package karimov;

import java.util.ArrayList;

class Activity{
	private String name;
	private int startTime;
	private int finishTime;
	public Activity(String name, int startTime, int finishTime) {
		super();
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
		return "Activity: " + name + " , start time: " + startTime + " , finish time: " + finishTime;
	}
}

class ActivitySelectionAlgo{
	static void solve(ArrayList<Activity> activityList) {
		// Sort ascending finish time
		activityList.sort((o1, o2) -> o1.getFinishTime() - o2.getFinishTime());
		Activity previous = activityList.get(0);
		
		// Display the first task
		System.out.println("\nSchedule:\n\n" + activityList.get(0));
		
		for(int i=1; i<activityList.size(); i++) {
			Activity current = activityList.get(i);
			if(current.getStartTime() >= previous.getFinishTime()) {
				System.out.println(current);
				previous = current;
			}
		}
	}
}

public class ActivitySelectionProblem {

	public static void main(String[] args) {
		ArrayList<Activity> list = new ArrayList<>();
		list.add(new Activity("A1", 0, 6));
		list.add(new Activity("A2", 3, 4));
		list.add(new Activity("A3", 1, 2));
		list.add(new Activity("A4", 5, 8));
		list.add(new Activity("A5", 5, 7));
		list.add(new Activity("A6", 8, 9));
		
		ActivitySelectionAlgo.solve(list);
	}

}
