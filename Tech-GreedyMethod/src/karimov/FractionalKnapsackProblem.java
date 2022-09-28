package karimov;

import java.util.ArrayList;

class KnapsackItem {
	private int index;
	private int value;
	private int weight;
	private double ratio;

	public KnapsackItem(int index, int value, int weight) {
		this.index = index;
		this.value = value;
		this.weight = weight;
		ratio = value * 1.0 / weight;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public double getRatio() {
		return ratio;
	}

	public void setRatio(double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "Item index=" + index + ", value=" + value + ", weight=" + weight + ", ratio=" + ratio;
	}
}

class FractionalKnapsack {
	  static void knapSack (ArrayList<KnapsackItem> items, int capacity) {
		items.sort((o1, o2) -> {
			return o2.getRatio() > o1.getRatio() ? 1 : -1;
		});
	    int usedCapacity = 0;
	    double totalValue = 0;

	    for (KnapsackItem item : items) {
	      if (usedCapacity + item.getWeight()<=capacity) {
	        usedCapacity+=item.getWeight();
	        System.out.println("Taken: "+item);
	        totalValue+=item.getValue();
	      } else {
	        int usedWeight = capacity - usedCapacity;
	        double value = item.getRatio()*usedWeight;
	        System.out.println("Taken: item index = "+ item.getIndex()+ ", obtained value= "+ value+ ", used weight =" +usedWeight+ ", ratio = "+ item.getRatio());
	        usedCapacity += usedWeight;
	        totalValue += value;

	      }
	      if (usedCapacity == capacity) break;
	    }

	    System.out.println("\nTotal value: "+ totalValue);

	  }
	}

public class FractionalKnapsackProblem {

	public static void main(String[] args) {
		ArrayList<KnapsackItem> items = new ArrayList<>();
		int[] value = {100, 120, 60};
		int[] weight = {20, 30, 10};
		int capacity = 50;
		for(int i=0; i<value.length; i++) {
			items.add(new KnapsackItem(i+1, value[i], weight[i]));
		}
		FractionalKnapsack.knapSack(items, capacity);
	}

}
