package balazs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Bin{
	private int id;
	private int capacity;
	private int actualSize;
	private List<Integer> items;
	
	public Bin(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
		this.items = new ArrayList<>();
	}
	
	@Override
	public String toString() {
		String contentOfBin = "Items in bin" + this.id + " : ";
		for(Integer item : this.items) {
			contentOfBin += item + " ";
		}
		return contentOfBin;
	}
	
	boolean put(Integer item) {
		// the item does not fit into the bin
		if(actualSize + item > capacity)
			return false;
		// add the item to the bin
		items.add(item);
		actualSize += item;
		return true;
	}
}

class BinPackingAlgo {
	private List<Bin> bins;
	private List<Integer> items;
	private int binCapacity;
	private int binCounter = 1;
	
	public BinPackingAlgo(List<Integer> items, int capacity) {
		this.binCapacity = capacity;
		this.items = items;
		this.bins = new ArrayList<>(items.size());
	}
	
	void solve() {
		// sort the items in descending order
		Collections.sort(items, Collections.reverseOrder());
		
		// there is no solution
		if(items.get(0) > binCapacity) {
			System.out.println("No solution.....");
			return;
		}
		
		// first bin
		bins.add(new Bin(binCounter, binCapacity));
		for(Integer item : items) {
			// track whether we have put the item into a bin or not
			boolean isOk = false;
			int currentBin=0;
			while(!isOk) {
				// item does not fit in last bin -> try a new bin
				if(currentBin == bins.size()) {
					Bin newBin = new Bin(++binCounter, binCapacity);
					newBin.put(item);
					bins.add(newBin);
					isOk = true;
				} else if (bins.get(currentBin).put(item)) {
					//current item fit the given bin
					isOk = true;
				} else {
					// trying the next bin
					currentBin++;
				}
			}
		}
	}
	
	void show() {
		for(Bin bin : bins) {
			System.out.println(bin);
		}
	}
}

public class BinPacking {

	public static void main(String[] args) {
		List<Integer> items = Arrays.asList(5, 5, 5);
		int binCapacity = 15;
		BinPackingAlgo algo = new BinPackingAlgo(items, binCapacity);
		algo.solve();
		algo.show();
	}

}
