package karimov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class AlgorithmSelection {
	
	static void run(ArrayList<Activities> activityList) {
		Comparator<Activities> finishTimeComp = new Comparator<Activities>() {
			@Override
			public int compare(Activities o1, Activities o2) {
				return o1.getFinishTime() - o2.getFinishTime();
			}
		};
		
		// Ascending sort finish time: 2, 4, 6, 7, 8, 9...
		Collections.sort(activityList, finishTimeComp);
		
		// Gets the first activity in the sorted list
		Activities previous = activityList.get(0);
		
		System.out.println("\nRecommend Schedules:\n" + activityList.get(0));
		
		for(int i = 1 ; i < activityList.size(); i++) {
			Activities current = activityList.get(i);
			if(current.getStartTime() >= previous.getFinishTime()) {
				System.out.println(current);
				previous = current;
			}
		}
	}
}


public class ActivitiesSelection {

	public static void main(String[] args) {
		ArrayList<Activities> list = new ArrayList<>();
		list.add(new Activities("A1", 0, 6));
		list.add(new Activities("A2", 3, 4));
		list.add(new Activities("A3", 1, 2));
		list.add(new Activities("A4", 5, 8));
		list.add(new Activities("A5", 5, 7));
		list.add(new Activities("A6", 8, 9));
		
		AlgorithmSelection.run(list);
	}

}
